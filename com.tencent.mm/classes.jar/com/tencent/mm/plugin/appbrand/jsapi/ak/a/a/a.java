package com.tencent.mm.plugin.appbrand.jsapi.ak.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  public Handler mHandler;
  public String sNF;
  public String sNG;
  private c sNQ;
  public Context sNT;
  a sNU;
  a.b sNV;
  public WifiConfiguration sNW;
  public BroadcastReceiver sNX;
  ConnectivityManager sNY;
  private int sNZ;
  public boolean sNz;
  public long sOa;
  public boolean sOb;
  public final boolean sOc;
  
  public a(c paramc, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(325777);
    this.mHandler = null;
    this.sNU = null;
    this.sNV = null;
    this.sNW = null;
    this.sNz = false;
    this.sNX = null;
    this.sNZ = 0;
    this.sOa = 13000L;
    this.sOb = false;
    this.sNQ = paramc;
    this.sNT = paramContext;
    try
    {
      this.sNY = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity"));
      this.mHandler = new Handler(paramContext.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(144702);
          if (paramAnonymousMessage == null)
          {
            AppMethodBeat.o(144702);
            return;
          }
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(144702);
            return;
            Log.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
            if (!a.this.cyn())
            {
              a.this.acE("fail to connect wifi:time out");
              Log.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
            }
          }
        }
      };
      if (((paramBoolean) || (!com.tencent.mm.compatible.e.b.dh(this.sNT))) && (this.sNT.getApplicationInfo().targetSdkVersion >= 29) && (Build.VERSION.SDK_INT >= 29))
      {
        this.sOc = true;
        AppMethodBeat.o(325777);
        return;
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WiFiConnector", paramc, "can not retrieve ConnectivityManager", new Object[0]);
      }
      this.sOc = false;
      AppMethodBeat.o(325777);
    }
  }
  
  private static String Bz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UnknowState";
    case 2: 
      return "STATE_CONNECTED";
    case 1: 
      return "STATE_CONNECTING";
    case 3: 
      return "STATE_FAIL";
    }
    return "STATE_NONE";
  }
  
  private static Object a(a parama, String paramString)
  {
    AppMethodBeat.i(144707);
    paramString = Class.forName(paramString);
    parama = Proxy.newProxyInstance(paramString.getClassLoader(), new Class[] { paramString }, parama);
    AppMethodBeat.o(144707);
    return parama;
  }
  
  private static boolean b(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(325785);
    Log.i("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
    boolean bool = d.BC(paramWifiConfiguration.networkId);
    AppMethodBeat.o(325785);
    return bool;
  }
  
  private void cym()
  {
    AppMethodBeat.i(144709);
    if (this.sNz)
    {
      this.sNT.unregisterReceiver(this.sNX);
      this.sNz = false;
      Log.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(144709);
  }
  
  public final void By(int paramInt)
  {
    AppMethodBeat.i(144712);
    if (this.sNZ != paramInt)
    {
      this.sNZ = paramInt;
      Log.i("MicroMsg.WiFiConnector", "switchState:" + Bz(this.sNZ));
    }
    AppMethodBeat.o(144712);
  }
  
  public final void H(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(144713);
    Log.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!cyn())
    {
      if (this.sNQ != null)
      {
        c localc = this.sNQ;
        if (paramBoolean) {
          paramString = "ok";
        }
        localc.aK(paramString, this.sOc);
      }
      this.mHandler.removeMessages(1);
      cym();
      if (!paramBoolean) {
        break label109;
      }
    }
    label109:
    for (int i = 2;; i = 3)
    {
      By(i);
      if ((!paramBoolean) && (this.sNW != null)) {
        b.BA(this.sNW.networkId);
      }
      AppMethodBeat.o(144713);
      return;
    }
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144710);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == e.sOo) || (this.sNY == null))
    {
      AppMethodBeat.o(144710);
      return false;
    }
    boolean bool;
    try
    {
      Class localClass1 = Class.forName("android.net.wifi.WifiManager");
      if (Build.VERSION.SDK_INT < 16)
      {
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(d.sOn, new Object[] { this.sNT, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(d.sOn, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.sNV == null) {
          this.sNV = new a.b(this);
        }
        localObject1 = a(this.sNU, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(d.sOn, new Object[] { this.sNT, this.sNT.getMainLooper(), localObject1 });
        if (this.sNU == null) {
          this.sNU = new a(paramWifiConfiguration);
        }
        localObject2 = a(this.sNU, "android.net.wifi.WifiManager$ActionListener");
        Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(d.sOn, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        bool = b(paramWifiConfiguration);
        AppMethodBeat.o(144710);
        return bool;
      }
      if (this.sNU == null) {
        this.sNU = new a(paramWifiConfiguration);
      }
      Object localObject1 = a(this.sNU, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(d.sOn, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
      AppMethodBeat.o(144710);
      return true;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.WiFiConnector", "connectWifi fail since " + localException.toString() + ", try fallback");
      bool = b(paramWifiConfiguration);
      AppMethodBeat.o(144710);
    }
    return bool;
  }
  
  public final void acE(String paramString)
  {
    AppMethodBeat.i(144711);
    if (this.sNW != null)
    {
      b.BA(this.sNW.networkId);
      H(false, paramString);
      Log.i("MicroMsg.wifi_event", "cancelConnect, " + e.acF(this.sNW.SSID) + " networkId:" + this.sNW.networkId);
      Log.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(144711);
  }
  
  public final boolean cyn()
  {
    return (this.sNZ == 3) || (this.sNZ == 2);
  }
  
  final class a
    implements InvocationHandler
  {
    private final WifiConfiguration sOe;
    
    public a(WifiConfiguration paramWifiConfiguration)
    {
      this.sOe = paramWifiConfiguration;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(144705);
      if (paramMethod.getName().compareTo("onSuccess") == 0)
      {
        Log.i("MicroMsg.WiFiConnector", "connectWifi use ActionListener success");
        AppMethodBeat.o(144705);
        return null;
      }
      if (paramMethod.getName().compareTo("onFailure") == 0)
      {
        Log.w("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
        d.BC(this.sOe.networkId);
      }
      AppMethodBeat.o(144705);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.a
 * JD-Core Version:    0.7.0.1
 */