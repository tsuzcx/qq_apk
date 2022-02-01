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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  a.b lwA;
  public WifiConfiguration lwB;
  ConnectivityManager lwC;
  private int lwD;
  private final int lwE;
  public boolean lwF;
  public boolean lwi;
  public BroadcastReceiver lwj;
  public String lwl;
  public String lwm;
  private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a lwv;
  public Context lwy;
  a lwz;
  public Handler mHandler;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a parama, Context paramContext)
  {
    AppMethodBeat.i(144708);
    this.mHandler = null;
    this.lwz = null;
    this.lwA = null;
    this.lwB = null;
    this.lwi = false;
    this.lwj = null;
    this.lwD = 0;
    this.lwE = 13000;
    this.lwF = false;
    this.lwv = parama;
    this.lwy = paramContext;
    try
    {
      this.lwC = ((ConnectivityManager)this.lwy.getSystemService("connectivity"));
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
            ad.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
            if (!a.this.bpw())
            {
              a.this.Ru("fail to connect wifi:time out");
              ad.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
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
        ad.printErrStackTrace("MicroMsg.WiFiConnector", parama, "can not retrieve ConnectivityManager", new Object[0]);
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
  
  private static boolean b(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(195115);
    ad.i("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
    boolean bool = c.tN(paramWifiConfiguration.networkId);
    AppMethodBeat.o(195115);
    return bool;
  }
  
  private void bpv()
  {
    AppMethodBeat.i(144709);
    if (this.lwi)
    {
      this.lwy.unregisterReceiver(this.lwj);
      this.lwi = false;
      ad.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(144709);
  }
  
  private static String tL(int paramInt)
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
  
  public final void Ru(String paramString)
  {
    AppMethodBeat.i(144711);
    if (this.lwB != null)
    {
      b.tM(this.lwB.networkId);
      q(false, paramString);
      ad.i("MicroMsg.wifi_event", "cancelConnect, " + d.Rv(this.lwB.SSID) + " networkId:" + this.lwB.networkId);
      ad.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(144711);
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144710);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == d.lwI) || (this.lwC == null))
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
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(c.bWU, new Object[] { this.lwy, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(c.bWU, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.lwA == null) {
          this.lwA = new a.b(this);
        }
        localObject1 = a(this.lwz, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(c.bWU, new Object[] { this.lwy, this.lwy.getMainLooper(), localObject1 });
        if (this.lwz == null) {
          this.lwz = new a(paramWifiConfiguration);
        }
        localObject2 = a(this.lwz, "android.net.wifi.WifiManager$ActionListener");
        Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(c.bWU, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        bool = b(paramWifiConfiguration);
        AppMethodBeat.o(144710);
        return bool;
      }
      if (this.lwz == null) {
        this.lwz = new a(paramWifiConfiguration);
      }
      Object localObject1 = a(this.lwz, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(c.bWU, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
      AppMethodBeat.o(144710);
      return true;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.WiFiConnector", "connectWifi fail since " + localException.toString() + ", try fallback");
      bool = b(paramWifiConfiguration);
      AppMethodBeat.o(144710);
    }
    return bool;
  }
  
  public final boolean bpw()
  {
    return (this.lwD == 3) || (this.lwD == 2);
  }
  
  public final void q(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(144713);
    ad.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!bpw())
    {
      if (this.lwv != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a locala = this.lwv;
        String str1 = this.lwl;
        String str2 = this.lwm;
        if (paramBoolean) {
          paramString = "ok";
        }
        locala.F(str1, str2, paramString);
      }
      this.mHandler.removeMessages(1);
      bpv();
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 2;; i = 3)
    {
      tK(i);
      if ((!paramBoolean) && (this.lwB != null)) {
        b.tM(this.lwB.networkId);
      }
      AppMethodBeat.o(144713);
      return;
    }
  }
  
  public final void tK(int paramInt)
  {
    AppMethodBeat.i(144712);
    if (this.lwD != paramInt)
    {
      this.lwD = paramInt;
      ad.i("MicroMsg.WiFiConnector", "switchState:" + tL(this.lwD));
    }
    AppMethodBeat.o(144712);
  }
  
  final class a
    implements InvocationHandler
  {
    private final WifiConfiguration lwH;
    
    public a(WifiConfiguration paramWifiConfiguration)
    {
      this.lwH = paramWifiConfiguration;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(144705);
      if (paramMethod.getName().compareTo("onSuccess") == 0)
      {
        ad.i("MicroMsg.WiFiConnector", "connectWifi use ActionListener success");
        AppMethodBeat.o(144705);
        return null;
      }
      if (paramMethod.getName().compareTo("onFailure") == 0)
      {
        ad.w("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
        c.tN(this.lwH.networkId);
      }
      AppMethodBeat.o(144705);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a
 * JD-Core Version:    0.7.0.1
 */