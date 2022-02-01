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
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  public boolean mHU;
  public BroadcastReceiver mHV;
  public String mHX;
  public String mHY;
  public Handler mHandler;
  private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a mIi;
  public Context mIl;
  a mIm;
  a.b mIn;
  public WifiConfiguration mIo;
  ConnectivityManager mIp;
  private int mIq;
  private final int mIr;
  public boolean mIs;
  
  public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a parama, Context paramContext)
  {
    AppMethodBeat.i(144708);
    this.mHandler = null;
    this.mIm = null;
    this.mIn = null;
    this.mIo = null;
    this.mHU = false;
    this.mHV = null;
    this.mIq = 0;
    this.mIr = 13000;
    this.mIs = false;
    this.mIi = parama;
    this.mIl = paramContext;
    try
    {
      this.mIp = ((ConnectivityManager)this.mIl.getSystemService("connectivity"));
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
            if (!a.this.bLM())
            {
              a.this.abI("fail to connect wifi:time out");
              Log.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
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
        Log.printErrStackTrace("MicroMsg.WiFiConnector", parama, "can not retrieve ConnectivityManager", new Object[0]);
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
    AppMethodBeat.i(215175);
    Log.i("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
    boolean bool = d.xQ(paramWifiConfiguration.networkId);
    AppMethodBeat.o(215175);
    return bool;
  }
  
  private void bLL()
  {
    AppMethodBeat.i(144709);
    if (this.mHU)
    {
      this.mIl.unregisterReceiver(this.mHV);
      this.mHU = false;
      Log.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
    AppMethodBeat.o(144709);
  }
  
  private static String xO(int paramInt)
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
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    AppMethodBeat.i(144710);
    if ((paramWifiConfiguration == null) || (paramWifiConfiguration.networkId == e.mIE) || (this.mIp == null))
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
        localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(d.chC, new Object[] { this.mIl, this.mHandler });
        localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(d.chC, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (this.mIn == null) {
          this.mIn = new a.b(this);
        }
        localObject1 = a(this.mIm, "android.net.wifi.WifiManager$ChannelListener");
        localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(d.chC, new Object[] { this.mIl, this.mIl.getMainLooper(), localObject1 });
        if (this.mIm == null) {
          this.mIm = new a(paramWifiConfiguration);
        }
        localObject2 = a(this.mIm, "android.net.wifi.WifiManager$ActionListener");
        Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(d.chC, new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
        AppMethodBeat.o(144710);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        bool = b(paramWifiConfiguration);
        AppMethodBeat.o(144710);
        return bool;
      }
      if (this.mIm == null) {
        this.mIm = new a(paramWifiConfiguration);
      }
      Object localObject1 = a(this.mIm, "android.net.wifi.WifiManager$ActionListener");
      Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
      localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(d.chC, new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
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
  
  public final void abI(String paramString)
  {
    AppMethodBeat.i(144711);
    if (this.mIo != null)
    {
      b.xP(this.mIo.networkId);
      q(false, paramString);
      Log.i("MicroMsg.wifi_event", "cancelConnect, " + e.abJ(this.mIo.SSID) + " networkId:" + this.mIo.networkId);
      Log.i("MicroMsg.WiFiConnector", "cancelConnect");
    }
    AppMethodBeat.o(144711);
  }
  
  public final boolean bLM()
  {
    return (this.mIq == 3) || (this.mIq == 2);
  }
  
  public final void q(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(144713);
    Log.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(paramBoolean)));
    if (!bLM())
    {
      if (this.mIi != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a locala = this.mIi;
        String str1 = this.mHX;
        String str2 = this.mHY;
        if (paramBoolean) {
          paramString = "ok";
        }
        locala.H(str1, str2, paramString);
      }
      this.mHandler.removeMessages(1);
      bLL();
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 2;; i = 3)
    {
      xN(i);
      if ((!paramBoolean) && (this.mIo != null)) {
        b.xP(this.mIo.networkId);
      }
      AppMethodBeat.o(144713);
      return;
    }
  }
  
  public final void xN(int paramInt)
  {
    AppMethodBeat.i(144712);
    if (this.mIq != paramInt)
    {
      this.mIq = paramInt;
      Log.i("MicroMsg.WiFiConnector", "switchState:" + xO(this.mIq));
    }
    AppMethodBeat.o(144712);
  }
  
  final class a
    implements InvocationHandler
  {
    private final WifiConfiguration mIu;
    
    public a(WifiConfiguration paramWifiConfiguration)
    {
      this.mIu = paramWifiConfiguration;
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
        d.xQ(this.mIu.networkId);
      }
      AppMethodBeat.o(144705);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a
 * JD-Core Version:    0.7.0.1
 */