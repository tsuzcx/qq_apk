package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  ConnectivityManager kZA;
  private int kZB;
  private final int kZC;
  public boolean kZD;
  public boolean kZg;
  public BroadcastReceiver kZh;
  public String kZj;
  public String kZk;
  private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a kZt;
  public Context kZw;
  a kZx;
  a.b kZy;
  public WifiConfiguration kZz;
  public Handler mHandler;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a parama, Context paramContext)
  {
    AppMethodBeat.i(144708);
    this.mHandler = null;
    this.kZx = null;
    this.kZy = null;
    this.kZz = null;
    this.kZg = false;
    this.kZh = null;
    this.kZB = 0;
    this.kZC = 13000;
    this.kZD = false;
    this.kZt = parama;
    this.kZw = paramContext;
    try
    {
      this.kZA = ((ConnectivityManager)this.kZw.getSystemService("connectivity"));
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
            ac.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
            if (!a.this.blL())
            {
              a.this.NV("fail to connect wifi:time out");
              ac.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
            }
          }
        }
      };
      AppMethodBeat.o(144708);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WiFiConnector", parama, "can not retrieve ConnectivityManager", new Object[0]);
      }
    }
  }
  
  private static Object a(a parama, String paramString)
  {
    AppMethodBeat.i(144707);
    paramString = Class.forName(paramString);
    parama = Proxy.newProxyInstance(paramString.getClassLoader(), new Class[] { paramString }, parama);
    AppMethodBeat.o(144707);
    return parama;
  }
  
  private void blK()
  {
    AppMethodBeat.i(144709);
    if (this.kZg)
    {
      this.kZw.unregisterReceiver(this.kZh);
      this.kZg = false;
      ac.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(144709);
  }
  
  private static String th(int paramInt)
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
  
  public final void NV(String paramString)
  {
    AppMethodBeat.i(144711);
    if (this.kZz != null)
    {
      b.ti(this.kZz.networkId);
      n(false, paramString);
      ac.i("MicroMsg.wifi_event", "cancelConnect, " + d.NW(this.kZz.SSID) + " networkId:" + this.kZz.networkId);
      ac.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(144711);
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144710);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == d.kZG) || (this.kZA == null))
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
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(c.bMH, new Object[] { this.kZw, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(c.bMH, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.kZy == null) {
          this.kZy = new a.b(this);
        }
        localObject1 = a(this.kZx, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(c.bMH, new Object[] { this.kZw, this.kZw.getMainLooper(), localObject1 });
        if (this.kZx == null) {
          this.kZx = new a(paramWifiConfiguration);
        }
        localObject2 = a(this.kZx, "android.net.wifi.WifiManager$ActionListener");
        Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(c.bMH, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        bool = c.tj(paramWifiConfiguration.networkId);
        AppMethodBeat.o(144710);
        return bool;
      }
      if (this.kZx == null) {
        this.kZx = new a(paramWifiConfiguration);
      }
      Object localObject1 = a(this.kZx, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(c.bMH, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
      AppMethodBeat.o(144710);
      return true;
    }
    catch (Exception localException)
    {
      bool = c.tj(paramWifiConfiguration.networkId);
      AppMethodBeat.o(144710);
    }
    return bool;
  }
  
  public final boolean blL()
  {
    return (this.kZB == 3) || (this.kZB == 2);
  }
  
  public final void n(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(144713);
    ac.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!blL())
    {
      if (this.kZt != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a locala = this.kZt;
        String str1 = this.kZj;
        String str2 = this.kZk;
        if (paramBoolean) {
          paramString = "ok";
        }
        locala.G(str1, str2, paramString);
      }
      this.mHandler.removeMessages(1);
      blK();
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 2;; i = 3)
    {
      tg(i);
      if ((!paramBoolean) && (this.kZz != null)) {
        b.ti(this.kZz.networkId);
      }
      AppMethodBeat.o(144713);
      return;
    }
  }
  
  public final void tg(int paramInt)
  {
    AppMethodBeat.i(144712);
    if (this.kZB != paramInt)
    {
      this.kZB = paramInt;
      ac.i("MicroMsg.WiFiConnector", "switchState:" + th(this.kZB));
    }
    AppMethodBeat.o(144712);
  }
  
  final class a
    implements InvocationHandler
  {
    private final WifiConfiguration kZF;
    
    public a(WifiConfiguration paramWifiConfiguration)
    {
      this.kZF = paramWifiConfiguration;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(144705);
      if (paramMethod.getName().compareTo("onSuccess") == 0)
      {
        AppMethodBeat.o(144705);
        return null;
      }
      if (paramMethod.getName().compareTo("onFailure") == 0)
      {
        ac.w("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
        c.tj(this.kZF.networkId);
      }
      AppMethodBeat.o(144705);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a
 * JD-Core Version:    0.7.0.1
 */