package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  volatile int swA;
  private final AtomicBoolean swB;
  final b swC;
  private final AtomicBoolean swy;
  private Method swz;
  
  public k()
  {
    AppMethodBeat.i(326037);
    this.swy = new AtomicBoolean(false);
    this.swz = null;
    this.swA = 2147483647;
    this.swB = new AtomicBoolean(false);
    this.swC = new b((byte)0);
    AppMethodBeat.o(326037);
  }
  
  private static int b(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(326047);
    if (paramSignalStrength.isGsm()) {}
    for (int i = c(paramSignalStrength);; i = paramSignalStrength.getCdmaDbm())
    {
      Log.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(i)));
      AppMethodBeat.o(326047);
      return i;
    }
  }
  
  private static int c(SignalStrength paramSignalStrength)
  {
    int j = -1;
    AppMethodBeat.i(326051);
    int k = paramSignalStrength.getGsmSignalStrength();
    if (k == 99) {}
    for (int i = -1;; i = k)
    {
      if (i != -1) {
        j = k * 2 - 113;
      }
      AppMethodBeat.o(326051);
      return j;
    }
  }
  
  public static k.c cuM()
  {
    AppMethodBeat.i(326039);
    try
    {
      Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (localObject == null)
      {
        localObject = k.c.swQ;
        AppMethodBeat.o(326039);
        return localObject;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected()))
      {
        localObject = k.c.swK;
        AppMethodBeat.o(326039);
        return localObject;
      }
      if (((NetworkInfo)localObject).getType() == 1)
      {
        localObject = k.c.swP;
        AppMethodBeat.o(326039);
        return localObject;
      }
      if ((((NetworkInfo)localObject).getSubtype() == 2) || (((NetworkInfo)localObject).getSubtype() == 1) || (((NetworkInfo)localObject).getSubtype() == 4))
      {
        localObject = k.c.swL;
        AppMethodBeat.o(326039);
        return localObject;
      }
      if ((((NetworkInfo)localObject).getSubtype() >= 5) && (((NetworkInfo)localObject).getSubtype() < 13))
      {
        localObject = k.c.swM;
        AppMethodBeat.o(326039);
        return localObject;
      }
      if ((((NetworkInfo)localObject).getSubtype() >= 13) && (((NetworkInfo)localObject).getSubtype() < 20))
      {
        localObject = k.c.swN;
        AppMethodBeat.o(326039);
        return localObject;
      }
      if (((NetworkInfo)localObject).getSubtype() >= 20)
      {
        localObject = k.c.swO;
        AppMethodBeat.o(326039);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.JsApiGetNetworkType", localException, "", new Object[0]);
      k.c localc = k.c.swQ;
      AppMethodBeat.o(326039);
      return localc;
    }
  }
  
  private Method cuN()
  {
    AppMethodBeat.i(326042);
    if (!this.swy.getAndSet(true)) {}
    try
    {
      this.swz = SignalStrength.class.getMethod("getDbm", new Class[0]);
      Method localMethod = this.swz;
      AppMethodBeat.o(326042);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(localException)));
        this.swz = null;
      }
    }
  }
  
  protected k.c I(f paramf)
  {
    AppMethodBeat.i(137665);
    paramf.getContext();
    paramf = cuM();
    AppMethodBeat.o(137665);
    return paramf;
  }
  
  final int a(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(326063);
    Method localMethod = cuN();
    int i;
    if (localMethod == null)
    {
      i = b(paramSignalStrength);
      AppMethodBeat.o(326063);
      return i;
    }
    try
    {
      i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      AppMethodBeat.o(326063);
      return i;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(localException)));
      i = b(paramSignalStrength);
      AppMethodBeat.o(326063);
    }
    return i;
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137664);
    paramJSONObject = new HashMap();
    k.c localc = I(paramf);
    String str1 = System.getProperty("http.proxyHost");
    String str2 = System.getProperty("https.proxyHost");
    Log.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s,httpProxyHost:%s,httpsProxyHost:%s", new Object[] { paramf.getAppId(), localc, str1, str2 });
    paramJSONObject.put("networkType", localc.value);
    if ((!Util.isNullOrNil(str1)) || (!Util.isNullOrNil(str2)))
    {
      paramJSONObject.put("hasSystemProxy", Boolean.TRUE);
      switch (k.4.swF[localc.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137664);
      return;
      paramJSONObject.put("hasSystemProxy", Boolean.FALSE);
      break;
      paramJSONObject = new a()
      {
        private Future<?> swD;
        
        private void Ba(int paramAnonymousInt)
        {
          AppMethodBeat.i(326018);
          Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrengthInternal, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramf.callback(paramInt, k.this.m("ok", paramJSONObject));
          AppMethodBeat.o(326018);
        }
        
        public final void AZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(326027);
          if (this.swD.isDone())
          {
            Log.w("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: %d, fallbackFuture done too early", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(326027);
            return;
          }
          this.swD.cancel(true);
          Ba(paramAnonymousInt);
          AppMethodBeat.o(326027);
        }
      };
      if (!this.swB.getAndSet(true)) {
        h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(326015);
            TelephonyManager localTelephonyManager = (TelephonyManager)paramf.getContext().getApplicationContext().getSystemService("phone");
            Object localObject = k.this.swC.cuP();
            localObject = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            AppMethodBeat.o(326015);
          }
        });
      }
      if (this.swC.cuQ())
      {
        paramJSONObject.AZ(this.swA);
        AppMethodBeat.o(137664);
        return;
      }
      this.swC.a(paramJSONObject);
      AppMethodBeat.o(137664);
      return;
      paramf = new a()
      {
        public final void AZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(326014);
          Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramf.callback(paramInt, k.this.m("ok", paramJSONObject));
          AppMethodBeat.o(326014);
        }
      };
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        paramf.AZ(ConnectivityCompat.Companion.getWiFiRssi());
        AppMethodBeat.o(137664);
        return;
      }
      Log.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
      paramf.AZ(2147483647);
      AppMethodBeat.o(137664);
      return;
      paramf.callback(paramInt, m("ok", paramJSONObject));
    }
  }
  
  static abstract interface a
  {
    public abstract void AZ(int paramInt);
  }
  
  final class b
  {
    private PhoneStateListener swG = null;
    boolean swH = false;
    List<k.a> swI = null;
    
    private b() {}
    
    public final void a(k.a parama)
    {
      try
      {
        AppMethodBeat.i(326029);
        if (this.swI == null) {
          this.swI = new ArrayList();
        }
        this.swI.add(parama);
        AppMethodBeat.o(326029);
        return;
      }
      finally {}
    }
    
    public final PhoneStateListener cuP()
    {
      try
      {
        AppMethodBeat.i(326023);
        if (this.swG == null) {
          this.swG = new PhoneStateListener()
          {
            public final void onSignalStrengthsChanged(SignalStrength arg1)
            {
              AppMethodBeat.i(326096);
              super.onSignalStrengthsChanged(???);
              int i = k.this.a(???);
              Log.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(i)));
              k.this.swA = i;
              synchronized (k.b.this)
              {
                if (k.b.this.swH) {
                  break label152;
                }
                k.b.this.swH = true;
                if (k.b.this.swI == null) {
                  break label152;
                }
                Iterator localIterator = k.b.this.swI.iterator();
                if (localIterator.hasNext()) {
                  ((k.a)localIterator.next()).AZ(i);
                }
              }
              k.b.this.swI.clear();
              k.b.this.swI = null;
              label152:
              AppMethodBeat.o(326096);
            }
          };
        }
        PhoneStateListener localPhoneStateListener = this.swG;
        AppMethodBeat.o(326023);
        return localPhoneStateListener;
      }
      finally {}
    }
    
    public final boolean cuQ()
    {
      try
      {
        boolean bool = this.swH;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.k
 * JD-Core Version:    0.7.0.1
 */