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
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  public BroadcastReceiver ihA;
  public String ihD;
  public String ihE;
  private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a ihN;
  public Context ihO;
  a.a ihP;
  a.b ihQ;
  public WifiConfiguration ihR;
  ConnectivityManager ihS;
  private int ihT;
  private final int ihU;
  public boolean ihV;
  public boolean ihz;
  public Handler mHandler;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a parama, Context paramContext)
  {
    AppMethodBeat.i(94393);
    this.mHandler = null;
    this.ihP = null;
    this.ihQ = null;
    this.ihR = null;
    this.ihz = false;
    this.ihA = null;
    this.ihT = 0;
    this.ihU = 13000;
    this.ihV = false;
    this.ihN = parama;
    this.ihO = paramContext;
    try
    {
      this.ihS = ((ConnectivityManager)this.ihO.getSystemService("connectivity"));
      this.mHandler = new Handler(paramContext.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(94387);
          if (paramAnonymousMessage == null)
          {
            AppMethodBeat.o(94387);
            return;
          }
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(94387);
            return;
            ab.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
            if (!a.this.aGu())
            {
              a.this.Dg("fail to connect wifi:time out");
              ab.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
            }
          }
        }
      };
      AppMethodBeat.o(94393);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WiFiConnector", parama, "can not retrieve ConnectivityManager", new Object[0]);
      }
    }
  }
  
  private static Object a(a.a parama, String paramString)
  {
    AppMethodBeat.i(94392);
    paramString = Class.forName(paramString);
    parama = Proxy.newProxyInstance(paramString.getClassLoader(), new Class[] { paramString }, parama);
    AppMethodBeat.o(94392);
    return parama;
  }
  
  private void aGt()
  {
    AppMethodBeat.i(94394);
    if (this.ihz)
    {
      this.ihO.unregisterReceiver(this.ihA);
      this.ihz = false;
      ab.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(94394);
  }
  
  private static String or(int paramInt)
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
  
  public final void Dg(String paramString)
  {
    AppMethodBeat.i(94396);
    if (this.ihR != null)
    {
      b.os(this.ihR.networkId);
      k(false, paramString);
      ab.i("MicroMsg.wifi_event", "cancelConnect, " + d.Dh(this.ihR.SSID) + " networkId:" + this.ihR.networkId);
      ab.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(94396);
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(94395);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == d.ihY) || (this.ihS == null))
    {
      AppMethodBeat.o(94395);
      return false;
    }
    try
    {
      Class localClass1 = Class.forName("android.net.wifi.WifiManager");
      if (Build.VERSION.SDK_INT < 16)
      {
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(c.bmz, new Object[] { this.ihO, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(c.bmz, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(94395);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.ihQ == null) {
          this.ihQ = new a.b(this);
        }
        localObject1 = a(this.ihP, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(c.bmz, new Object[] { this.ihO, this.ihO.getMainLooper(), localObject1 });
        if (this.ihP == null) {
          this.ihP = new a.a(this);
        }
        localObject2 = a(this.ihP, "android.net.wifi.WifiManager$ActionListener");
        Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(c.bmz, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
        AppMethodBeat.o(94395);
        return true;
      }
      if (this.ihP == null) {
        this.ihP = new a.a(this);
      }
      Object localObject1 = a(this.ihP, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(c.bmz, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
      AppMethodBeat.o(94395);
      return true;
    }
    catch (Exception localException)
    {
      boolean bool = c.ot(paramWifiConfiguration.networkId);
      AppMethodBeat.o(94395);
      return bool;
    }
  }
  
  public final boolean aGu()
  {
    return (this.ihT == 3) || (this.ihT == 2);
  }
  
  public final void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(94398);
    ab.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!aGu())
    {
      if (this.ihN != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a locala = this.ihN;
        if (paramBoolean) {
          paramString = "ok";
        }
        locala.Df(paramString);
      }
      this.mHandler.removeMessages(1);
      aGt();
      if (!paramBoolean) {
        break label109;
      }
    }
    label109:
    for (int i = 2;; i = 3)
    {
      oq(i);
      if ((!paramBoolean) && (this.ihR != null)) {
        b.os(this.ihR.networkId);
      }
      AppMethodBeat.o(94398);
      return;
    }
  }
  
  public final void oq(int paramInt)
  {
    AppMethodBeat.i(94397);
    if (this.ihT != paramInt)
    {
      this.ihT = paramInt;
      ab.i("MicroMsg.WiFiConnector", "switchState:" + or(this.ihT));
    }
    AppMethodBeat.o(94397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a
 * JD-Core Version:    0.7.0.1
 */