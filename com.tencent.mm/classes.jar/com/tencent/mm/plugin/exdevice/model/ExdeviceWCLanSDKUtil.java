package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil
{
  BroadcastReceiver jQN;
  HashMap<String, byte[]> lEC;
  HashMap<String, Boolean> lEE;
  j.a lEF;
  j.a lEH;
  private int lEV;
  private int lEW;
  j.a lEX;
  j.a lEY;
  HashMap<String, String> lEZ;
  boolean lFa;
  boolean lFb;
  boolean lFc;
  int lFd;
  Context mContext;
  
  public ExdeviceWCLanSDKUtil()
  {
    AppMethodBeat.i(19290);
    this.lEV = 0;
    this.lEW = 0;
    this.lEC = new HashMap();
    this.lEE = new HashMap();
    this.lEZ = new HashMap();
    this.mContext = null;
    this.lFa = false;
    this.lFb = false;
    this.lFc = false;
    this.lFa = true;
    this.lFb = true;
    this.lEC.clear();
    this.lEE.clear();
    this.lEZ.clear();
    this.mContext = ah.getContext();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    if (this.jQN == null) {
      this.jQN = new ExdeviceWCLanSDKUtil.LanStateChangeReceiver(this);
    }
    this.mContext.registerReceiver(this.jQN, localIntentFilter);
    this.lEX = new ExdeviceWCLanSDKUtil.1(this);
    this.lEF = new ExdeviceWCLanSDKUtil.2(this);
    this.lEH = new ExdeviceWCLanSDKUtil.3(this);
    this.lEY = new ExdeviceWCLanSDKUtil.4(this);
    AppMethodBeat.o(19290);
  }
  
  public final boolean Lv(String paramString)
  {
    AppMethodBeat.i(19294);
    if ((paramString != null) && (this.lEE.containsKey(paramString)))
    {
      boolean bool = ((Boolean)this.lEE.get(paramString)).booleanValue();
      AppMethodBeat.o(19294);
      return bool;
    }
    AppMethodBeat.o(19294);
    return false;
  }
  
  public final boolean aC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19292);
    Object localObject;
    if ((paramString != null) && (this.lEC.containsKey(paramString)))
    {
      localObject = (byte[])this.lEC.get(paramString);
      this.lFc = true;
      if (!paramBoolean) {}
    }
    else
    {
      String str;
      try
      {
        str = new JSONObject(new String((byte[])localObject)).getString("deviceType");
        ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: ".concat(String.valueOf(paramString)));
        if (Java2CExDevice.connectWCLanDevice((byte[])localObject, false) == 0) {
          break label146;
        }
        ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
        AppMethodBeat.o(19292);
        return false;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", paramString, "", new Object[0]);
        ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
        AppMethodBeat.o(19292);
        return false;
      }
      ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
      AppMethodBeat.o(19292);
      return false;
      label146:
      localObject = new dv();
      ((dv)localObject).crI.bYu = paramString;
      ((dv)localObject).crI.crJ = 1;
      ((dv)localObject).crI.cqQ = str;
      a.ymk.l((b)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(19292);
      return true;
      n(false, paramString);
      ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
      Java2CExDevice.disconnectWCLanDevice((byte[])localObject);
    }
  }
  
  public final boolean dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19293);
    if (!Lv(paramString1))
    {
      ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + paramString1 + " not connected!");
      AppMethodBeat.o(19293);
      return false;
    }
    if ((paramString1 != null) && (this.lEC.containsKey(paramString1)))
    {
      paramString1 = (byte[])this.lEC.get(paramString1);
      this.lEV = 0;
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
        this.lEV = Java2CExDevice.useWCLanDeviceService(paramString1, localJSONObject.toString().getBytes());
        if (this.lEV == 0) {
          break label237;
        }
        bool = true;
        ab.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.lEV);
        AppMethodBeat.o(19293);
        return bool;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", paramString1, "", new Object[0]);
        ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
        AppMethodBeat.o(19293);
        return false;
      }
      ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
      AppMethodBeat.o(19293);
      return false;
      label237:
      ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
      boolean bool = false;
    }
  }
  
  public final boolean n(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(19291);
    if ((paramString != null) && (this.lEC.containsKey(paramString))) {
      paramString = (byte[])this.lEC.get(paramString);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        if (paramBoolean)
        {
          ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
          localJSONObject2.put("cmd", "open");
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("wxmsg_jsapi", localJSONObject2);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("services", localJSONObject1);
          this.lEW = Java2CExDevice.useWCLanDeviceService(paramString, localJSONObject2.toString().getBytes());
          if (this.lEW != 0)
          {
            ab.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.lEW);
            AppMethodBeat.o(19291);
            return true;
            ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            AppMethodBeat.o(19291);
            return false;
          }
        }
        else
        {
          ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
          localJSONObject2.put("cmd", "close");
          continue;
        }
        ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", paramString, "", new Object[0]);
        ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
        AppMethodBeat.o(19291);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil
 * JD-Core Version:    0.7.0.1
 */