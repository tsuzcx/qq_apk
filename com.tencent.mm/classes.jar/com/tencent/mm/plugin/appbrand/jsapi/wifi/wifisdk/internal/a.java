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
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  public boolean lAG;
  public BroadcastReceiver lAH;
  public String lAJ;
  public String lAK;
  private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a lAT;
  public Context lAW;
  a lAX;
  a.b lAY;
  public WifiConfiguration lAZ;
  ConnectivityManager lBa;
  private int lBb;
  private final int lBc;
  public boolean lBd;
  public Handler mHandler;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a parama, Context paramContext)
  {
    AppMethodBeat.i(144708);
    this.mHandler = null;
    this.lAX = null;
    this.lAY = null;
    this.lAZ = null;
    this.lAG = false;
    this.lAH = null;
    this.lBb = 0;
    this.lBc = 13000;
    this.lBd = false;
    this.lAT = parama;
    this.lAW = paramContext;
    try
    {
      this.lBa = ((ConnectivityManager)this.lAW.getSystemService("connectivity"));
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
            ae.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
            if (!a.this.bqg())
            {
              a.this.Sd("fail to connect wifi:time out");
              ae.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
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
        ae.printErrStackTrace("MicroMsg.WiFiConnector", parama, "can not retrieve ConnectivityManager", new Object[0]);
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
    AppMethodBeat.i(208364);
    ae.i("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
    boolean bool = c.tS(paramWifiConfiguration.networkId);
    AppMethodBeat.o(208364);
    return bool;
  }
  
  private void bqf()
  {
    AppMethodBeat.i(144709);
    if (this.lAG)
    {
      this.lAW.unregisterReceiver(this.lAH);
      this.lAG = false;
      ae.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(144709);
  }
  
  private static String tQ(int paramInt)
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
  
  public final void Sd(String paramString)
  {
    AppMethodBeat.i(144711);
    if (this.lAZ != null)
    {
      b.tR(this.lAZ.networkId);
      q(false, paramString);
      ae.i("MicroMsg.wifi_event", "cancelConnect, " + d.Se(this.lAZ.SSID) + " networkId:" + this.lAZ.networkId);
      ae.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(144711);
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144710);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == d.lBg) || (this.lBa == null))
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
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(c.bWU, new Object[] { this.lAW, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(c.bWU, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.lAY == null) {
          this.lAY = new a.b(this);
        }
        localObject1 = a(this.lAX, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(c.bWU, new Object[] { this.lAW, this.lAW.getMainLooper(), localObject1 });
        if (this.lAX == null) {
          this.lAX = new a(paramWifiConfiguration);
        }
        localObject2 = a(this.lAX, "android.net.wifi.WifiManager$ActionListener");
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
      if (this.lAX == null) {
        this.lAX = new a(paramWifiConfiguration);
      }
      Object localObject1 = a(this.lAX, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(c.bWU, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
      AppMethodBeat.o(144710);
      return true;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.WiFiConnector", "connectWifi fail since " + localException.toString() + ", try fallback");
      bool = b(paramWifiConfiguration);
      AppMethodBeat.o(144710);
    }
    return bool;
  }
  
  public final boolean bqg()
  {
    return (this.lBb == 3) || (this.lBb == 2);
  }
  
  public final void q(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(144713);
    ae.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!bqg())
    {
      if (this.lAT != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a locala = this.lAT;
        String str1 = this.lAJ;
        String str2 = this.lAK;
        if (paramBoolean) {
          paramString = "ok";
        }
        locala.F(str1, str2, paramString);
      }
      this.mHandler.removeMessages(1);
      bqf();
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 2;; i = 3)
    {
      tP(i);
      if ((!paramBoolean) && (this.lAZ != null)) {
        b.tR(this.lAZ.networkId);
      }
      AppMethodBeat.o(144713);
      return;
    }
  }
  
  public final void tP(int paramInt)
  {
    AppMethodBeat.i(144712);
    if (this.lBb != paramInt)
    {
      this.lBb = paramInt;
      ae.i("MicroMsg.WiFiConnector", "switchState:" + tQ(this.lBb));
    }
    AppMethodBeat.o(144712);
  }
  
  final class a
    implements InvocationHandler
  {
    private final WifiConfiguration lBf;
    
    public a(WifiConfiguration paramWifiConfiguration)
    {
      this.lBf = paramWifiConfiguration;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(144705);
      if (paramMethod.getName().compareTo("onSuccess") == 0)
      {
        ae.i("MicroMsg.WiFiConnector", "connectWifi use ActionListener success");
        AppMethodBeat.o(144705);
        return null;
      }
      if (paramMethod.getName().compareTo("onFailure") == 0)
      {
        ae.w("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
        c.tS(this.lBf.networkId);
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