package com.tencent.mm.plugin.appbrand.jsapi.ah.a.a;

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
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  public Handler mHandler;
  public boolean pIH;
  public String pIL;
  public String pIM;
  private com.tencent.mm.plugin.appbrand.jsapi.ah.a.b pIW;
  public Context pIZ;
  a pJa;
  a.b pJb;
  public WifiConfiguration pJc;
  public BroadcastReceiver pJd;
  ConnectivityManager pJe;
  private int pJf;
  public long pJg;
  public boolean pJh;
  public final boolean pJi;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.ah.a.b paramb, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(198985);
    this.mHandler = null;
    this.pJa = null;
    this.pJb = null;
    this.pJc = null;
    this.pIH = false;
    this.pJd = null;
    this.pJf = 0;
    this.pJg = 13000L;
    this.pJh = false;
    this.pIW = paramb;
    this.pIZ = paramContext;
    try
    {
      this.pJe = ((ConnectivityManager)this.pIZ.getSystemService("connectivity"));
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
            if (!a.this.bXX())
            {
              a.this.ajD("fail to connect wifi:time out");
              Log.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
            }
          }
        }
      };
      if (((paramBoolean) || (!com.tencent.mm.compatible.e.b.ct(this.pIZ))) && (this.pIZ.getApplicationInfo().targetSdkVersion >= 29) && (Build.VERSION.SDK_INT >= 29))
      {
        this.pJi = true;
        AppMethodBeat.o(198985);
        return;
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WiFiConnector", paramb, "can not retrieve ConnectivityManager", new Object[0]);
      }
      this.pJi = false;
      AppMethodBeat.o(198985);
    }
  }
  
  private static String Bm(int paramInt)
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
    AppMethodBeat.i(198991);
    Log.i("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
    boolean bool = d.Bp(paramWifiConfiguration.networkId);
    AppMethodBeat.o(198991);
    return bool;
  }
  
  private void bXW()
  {
    AppMethodBeat.i(144709);
    if (this.pIH)
    {
      this.pIZ.unregisterReceiver(this.pJd);
      this.pIH = false;
      Log.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(144709);
  }
  
  public final void Bl(int paramInt)
  {
    AppMethodBeat.i(144712);
    if (this.pJf != paramInt)
    {
      this.pJf = paramInt;
      Log.i("MicroMsg.WiFiConnector", "switchState:" + Bm(this.pJf));
    }
    AppMethodBeat.o(144712);
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144710);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == e.pJw) || (this.pJe == null))
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
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(d.pJv, new Object[] { this.pIZ, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(d.pJv, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.pJb == null) {
          this.pJb = new a.b(this);
        }
        localObject1 = a(this.pJa, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(d.pJv, new Object[] { this.pIZ, this.pIZ.getMainLooper(), localObject1 });
        if (this.pJa == null) {
          this.pJa = new a(paramWifiConfiguration);
        }
        localObject2 = a(this.pJa, "android.net.wifi.WifiManager$ActionListener");
        Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(d.pJv, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        bool = b(paramWifiConfiguration);
        AppMethodBeat.o(144710);
        return bool;
      }
      if (this.pJa == null) {
        this.pJa = new a(paramWifiConfiguration);
      }
      Object localObject1 = a(this.pJa, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(d.pJv, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
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
  
  public final void ajD(String paramString)
  {
    AppMethodBeat.i(144711);
    if (this.pJc != null)
    {
      b.Bn(this.pJc.networkId);
      v(false, paramString);
      Log.i("MicroMsg.wifi_event", "cancelConnect, " + e.ajE(this.pJc.SSID) + " networkId:" + this.pJc.networkId);
      Log.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(144711);
  }
  
  public final boolean bXX()
  {
    return (this.pJf == 3) || (this.pJf == 2);
  }
  
  public final void v(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(144713);
    Log.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!bXX())
    {
      if (this.pIW != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.ah.a.b localb = this.pIW;
        String str1 = this.pIL;
        String str2 = this.pIM;
        if (paramBoolean) {
          paramString = "ok";
        }
        localb.d(str1, str2, paramString, this.pJi);
      }
      this.mHandler.removeMessages(1);
      bXW();
      if (!paramBoolean) {
        break label129;
      }
    }
    label129:
    for (int i = 2;; i = 3)
    {
      Bl(i);
      if ((!paramBoolean) && (this.pJc != null)) {
        b.Bn(this.pJc.networkId);
      }
      AppMethodBeat.o(144713);
      return;
    }
  }
  
  final class a
    implements InvocationHandler
  {
    private final WifiConfiguration pJk;
    
    public a(WifiConfiguration paramWifiConfiguration)
    {
      this.pJk = paramWifiConfiguration;
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
        d.Bp(this.pJk.networkId);
      }
      AppMethodBeat.o(144705);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.a
 * JD-Core Version:    0.7.0.1
 */