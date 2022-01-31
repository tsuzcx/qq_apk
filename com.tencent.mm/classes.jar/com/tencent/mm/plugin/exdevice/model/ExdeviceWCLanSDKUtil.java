package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.h.a.ds;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil
{
  BroadcastReceiver hWU;
  HashMap<String, String> jvA = new HashMap();
  boolean jvB = false;
  boolean jvC = false;
  boolean jvD = false;
  int jvE;
  HashMap<String, byte[]> jvd = new HashMap();
  HashMap<String, Boolean> jvf = new HashMap();
  j.a jvg;
  j.a jvi;
  private int jvw = 0;
  private int jvx = 0;
  j.a jvy;
  j.a jvz;
  Context mContext = null;
  
  public ExdeviceWCLanSDKUtil()
  {
    this.jvd.clear();
    this.jvf.clear();
    this.jvA.clear();
    this.mContext = ae.getContext();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    if (this.hWU == null) {
      this.hWU = new ExdeviceWCLanSDKUtil.LanStateChangeReceiver(this);
    }
    this.mContext.registerReceiver(this.hWU, localIntentFilter);
    this.jvy = new ExdeviceWCLanSDKUtil.1(this);
    this.jvg = new ExdeviceWCLanSDKUtil.2(this);
    this.jvi = new ExdeviceWCLanSDKUtil.3(this);
    this.jvz = new ExdeviceWCLanSDKUtil.4(this);
  }
  
  public final boolean Bt(String paramString)
  {
    if ((paramString != null) && (this.jvf.containsKey(paramString))) {
      return ((Boolean)this.jvf.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public final boolean ar(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramString != null) && (this.jvd.containsKey(paramString)))
    {
      localObject = (byte[])this.jvd.get(paramString);
      this.jvD = true;
      if (!paramBoolean) {}
    }
    else
    {
      String str;
      try
      {
        str = new JSONObject(new String((byte[])localObject)).getString("deviceType");
        y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: " + paramString);
        if (Java2CExDevice.connectWCLanDevice((byte[])localObject, false) == 0) {
          break label129;
        }
        y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
        return false;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", paramString, "", new Object[0]);
        y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
        return false;
      }
      y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
      return false;
      label129:
      localObject = new ds();
      ((ds)localObject).bKo.bwK = paramString;
      ((ds)localObject).bKo.bKp = 1;
      ((ds)localObject).bKo.bJw = str;
      a.udP.m((b)localObject);
    }
    for (;;)
    {
      return true;
      i(false, paramString);
      y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
      Java2CExDevice.disconnectWCLanDevice((byte[])localObject);
    }
  }
  
  public final boolean cP(String paramString1, String paramString2)
  {
    if (!Bt(paramString1))
    {
      y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + paramString1 + " not connected!");
      return false;
    }
    if ((paramString1 != null) && (this.jvd.containsKey(paramString1)))
    {
      paramString1 = (byte[])this.jvd.get(paramString1);
      this.jvw = 0;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", paramString2);
        paramString2 = new JSONObject();
        paramString2.put("wxmsg_jsapi", localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("services", paramString2);
        this.jvw = Java2CExDevice.useWCLanDeviceService(paramString1, localJSONObject.toString().getBytes());
        if (this.jvw == 0) {
          break label205;
        }
        bool = true;
        y.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.jvw);
        return bool;
      }
      catch (Exception paramString1)
      {
        y.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", paramString1, "", new Object[0]);
        y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
        return false;
      }
      y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
      return false;
      label205:
      y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
      boolean bool = false;
    }
  }
  
  public final boolean i(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.jvd.containsKey(paramString))) {
      paramString = (byte[])this.jvd.get(paramString);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        if (paramBoolean)
        {
          y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
          localJSONObject2.put("cmd", "open");
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("wxmsg_jsapi", localJSONObject2);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("services", localJSONObject1);
          this.jvx = Java2CExDevice.useWCLanDeviceService(paramString, localJSONObject2.toString().getBytes());
          if (this.jvx != 0)
          {
            y.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.jvx);
            return true;
            y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            return false;
          }
        }
        else
        {
          y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
          localJSONObject2.put("cmd", "close");
          continue;
        }
        y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", paramString, "", new Object[0]);
        y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil
 * JD-Core Version:    0.7.0.1
 */