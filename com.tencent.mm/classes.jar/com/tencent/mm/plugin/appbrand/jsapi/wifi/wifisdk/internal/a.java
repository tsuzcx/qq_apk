package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  public boolean gGR = false;
  public BroadcastReceiver gGS = null;
  public String gGV;
  public String gGW;
  private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a gHf;
  public Context gHg;
  a.a gHh = null;
  a.b gHi = null;
  public WifiConfiguration gHj = null;
  ConnectivityManager gHk;
  private int gHl = 0;
  private final int gHm = 13000;
  public Handler mHandler = null;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a parama, Context paramContext)
  {
    this.gHf = parama;
    this.gHg = paramContext;
    try
    {
      this.gHk = ((ConnectivityManager)this.gHg.getSystemService("connectivity"));
      this.mHandler = new Handler(paramContext.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          if (paramAnonymousMessage == null) {}
          do
          {
            return;
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            }
            y.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
          } while (a.this.alq());
          a.this.uN("fail to connect wifi:time out");
          y.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
        }
      };
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WiFiConnector", parama, "can not retrieve ConnectivityManager", new Object[0]);
      }
    }
  }
  
  private static Object a(a.a parama, String paramString)
  {
    paramString = Class.forName(paramString);
    return Proxy.newProxyInstance(paramString.getClassLoader(), new Class[] { paramString }, parama);
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == d.gHp) || (this.gHk == null)) {
      return false;
    }
    try
    {
      Class localClass1 = Class.forName("android.net.wifi.WifiManager");
      if (Build.VERSION.SDK_INT < 16)
      {
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(c.aVR, new Object[] { this.gHg, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(c.aVR, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        return true;
      }
    }
    catch (Exception localException)
    {
      return c.lK(paramWifiConfiguration.networkId);
    }
    if (Build.VERSION.SDK_INT == 16)
    {
      if (this.gHi == null) {
        this.gHi = new a.b(this);
      }
      localObject1 = a(this.gHh, "android.net.wifi.WifiManager$ChannelListener");
      localObject1 = localException.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(c.aVR, new Object[] { this.gHg, this.gHg.getMainLooper(), localObject1 });
      if (this.gHh == null) {
        this.gHh = new a.a(this);
      }
      localObject2 = a(this.gHh, "android.net.wifi.WifiManager$ActionListener");
      Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localException.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(c.aVR, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
      return true;
    }
    if (this.gHh == null) {
      this.gHh = new a.a(this);
    }
    Object localObject1 = a(this.gHh, "android.net.wifi.WifiManager$ActionListener");
    Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
    localException.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(c.aVR, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
    return true;
  }
  
  public final boolean alq()
  {
    return (this.gHl == 3) || (this.gHl == 2);
  }
  
  public final void g(boolean paramBoolean, String paramString)
  {
    y.i("MicroMsg.WiFiConnector", "finishConnectTask success:" + paramBoolean);
    if (!alq())
    {
      if (this.gHf != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a locala = this.gHf;
        if (paramBoolean) {
          paramString = "ok";
        }
        locala.uM(paramString);
      }
      this.mHandler.removeMessages(1);
      if (this.gGR)
      {
        this.gHg.unregisterReceiver(this.gGS);
        this.gGR = false;
        y.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
      }
      if (!paramBoolean) {
        break label128;
      }
    }
    label128:
    for (int i = 2;; i = 3)
    {
      lI(i);
      if ((!paramBoolean) && (this.gHj != null)) {
        b.lJ(this.gHj.networkId);
      }
      return;
    }
  }
  
  public final void lI(int paramInt)
  {
    StringBuilder localStringBuilder;
    String str;
    if (this.gHl != paramInt)
    {
      this.gHl = paramInt;
      localStringBuilder = new StringBuilder("switchState:");
      switch (this.gHl)
      {
      default: 
        str = "UnknowState";
      }
    }
    for (;;)
    {
      y.i("MicroMsg.WiFiConnector", str);
      return;
      str = "STATE_CONNECTED";
      continue;
      str = "STATE_CONNECTING";
      continue;
      str = "STATE_FAIL";
      continue;
      str = "STATE_NONE";
    }
  }
  
  public final void uN(String paramString)
  {
    if (this.gHj != null)
    {
      b.lJ(this.gHj.networkId);
      g(false, paramString);
      y.i("MicroMsg.wifi_event", "cancelConnect, " + d.uO(this.gHj.SSID) + " networkId:" + this.gHj.networkId);
      y.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a
 * JD-Core Version:    0.7.0.1
 */