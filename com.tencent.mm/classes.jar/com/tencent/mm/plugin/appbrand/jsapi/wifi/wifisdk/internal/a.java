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
  public boolean kxS;
  public BroadcastReceiver kxT;
  public String kxV;
  public String kxW;
  private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a kyf;
  public Context kyi;
  a kyj;
  a.b kyk;
  public WifiConfiguration kyl;
  ConnectivityManager kym;
  private int kyn;
  private final int kyo;
  public boolean kyp;
  public Handler mHandler;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a parama, Context paramContext)
  {
    AppMethodBeat.i(144708);
    this.mHandler = null;
    this.kyj = null;
    this.kyk = null;
    this.kyl = null;
    this.kxS = false;
    this.kxT = null;
    this.kyn = 0;
    this.kyo = 13000;
    this.kyp = false;
    this.kyf = parama;
    this.kyi = paramContext;
    try
    {
      this.kym = ((ConnectivityManager)this.kyi.getSystemService("connectivity"));
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
            if (!a.this.beR())
            {
              a.this.JO("fail to connect wifi:time out");
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
  
  private void beQ()
  {
    AppMethodBeat.i(144709);
    if (this.kxS)
    {
      this.kyi.unregisterReceiver(this.kxT);
      this.kxS = false;
      ad.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(144709);
  }
  
  private static String sr(int paramInt)
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
  
  public final void JO(String paramString)
  {
    AppMethodBeat.i(144711);
    if (this.kyl != null)
    {
      b.ss(this.kyl.networkId);
      m(false, paramString);
      ad.i("MicroMsg.wifi_event", "cancelConnect, " + d.JP(this.kyl.SSID) + " networkId:" + this.kyl.networkId);
      ad.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(144711);
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144710);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == d.kys) || (this.kym == null))
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
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(c.bOZ, new Object[] { this.kyi, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(c.bOZ, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.kyk == null) {
          this.kyk = new a.b(this);
        }
        localObject1 = a(this.kyj, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(c.bOZ, new Object[] { this.kyi, this.kyi.getMainLooper(), localObject1 });
        if (this.kyj == null) {
          this.kyj = new a(paramWifiConfiguration);
        }
        localObject2 = a(this.kyj, "android.net.wifi.WifiManager$ActionListener");
        Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(c.bOZ, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        bool = c.st(paramWifiConfiguration.networkId);
        AppMethodBeat.o(144710);
        return bool;
      }
      if (this.kyj == null) {
        this.kyj = new a(paramWifiConfiguration);
      }
      Object localObject1 = a(this.kyj, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(c.bOZ, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
      AppMethodBeat.o(144710);
      return true;
    }
    catch (Exception localException)
    {
      bool = c.st(paramWifiConfiguration.networkId);
      AppMethodBeat.o(144710);
    }
    return bool;
  }
  
  public final boolean beR()
  {
    return (this.kyn == 3) || (this.kyn == 2);
  }
  
  public final void m(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(144713);
    ad.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!beR())
    {
      if (this.kyf != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a locala = this.kyf;
        String str1 = this.kxV;
        String str2 = this.kxW;
        if (paramBoolean) {
          paramString = "ok";
        }
        locala.G(str1, str2, paramString);
      }
      this.mHandler.removeMessages(1);
      beQ();
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 2;; i = 3)
    {
      sq(i);
      if ((!paramBoolean) && (this.kyl != null)) {
        b.ss(this.kyl.networkId);
      }
      AppMethodBeat.o(144713);
      return;
    }
  }
  
  public final void sq(int paramInt)
  {
    AppMethodBeat.i(144712);
    if (this.kyn != paramInt)
    {
      this.kyn = paramInt;
      ad.i("MicroMsg.WiFiConnector", "switchState:" + sr(this.kyn));
    }
    AppMethodBeat.o(144712);
  }
  
  final class a
    implements InvocationHandler
  {
    private final WifiConfiguration kyr;
    
    public a(WifiConfiguration paramWifiConfiguration)
    {
      this.kyr = paramWifiConfiguration;
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
        ad.w("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
        c.st(this.kyr.networkId);
      }
      AppMethodBeat.o(144705);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a
 * JD-Core Version:    0.7.0.1
 */