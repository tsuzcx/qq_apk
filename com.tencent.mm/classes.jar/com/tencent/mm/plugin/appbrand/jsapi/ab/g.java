package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  private final AtomicBoolean prL;
  private Method prM;
  volatile int prN;
  private final AtomicBoolean prO;
  final b prP;
  
  public g()
  {
    AppMethodBeat.i(205700);
    this.prL = new AtomicBoolean(false);
    this.prM = null;
    this.prN = 2147483647;
    this.prO = new AtomicBoolean(false);
    this.prP = new b((byte)0);
    AppMethodBeat.o(205700);
  }
  
  private static int b(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(205708);
    if (paramSignalStrength.isGsm()) {}
    for (int i = c(paramSignalStrength);; i = paramSignalStrength.getCdmaDbm())
    {
      Log.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(i)));
      AppMethodBeat.o(205708);
      return i;
    }
  }
  
  private Method bUy()
  {
    AppMethodBeat.i(205706);
    if (!this.prL.getAndSet(true)) {}
    try
    {
      this.prM = SignalStrength.class.getMethod("getDbm", new Class[0]);
      Method localMethod = this.prM;
      AppMethodBeat.o(205706);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(localException)));
        this.prM = null;
      }
    }
  }
  
  private static int c(SignalStrength paramSignalStrength)
  {
    int j = -1;
    AppMethodBeat.i(205709);
    int k = paramSignalStrength.getGsmSignalStrength();
    if (k == 99) {}
    for (int i = -1;; i = k)
    {
      if (i != -1) {
        j = k * 2 - 113;
      }
      AppMethodBeat.o(205709);
      return j;
    }
  }
  
  public static c dR(Context paramContext)
  {
    AppMethodBeat.i(137666);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        paramContext = c.psc;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
      {
        paramContext = c.prW;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getType() == 1)
      {
        paramContext = c.psb;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4))
      {
        paramContext = c.prX;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
      {
        paramContext = c.prY;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 13) && (paramContext.getSubtype() < 20))
      {
        paramContext = c.prZ;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getSubtype() >= 20)
      {
        paramContext = c.psa;
        AppMethodBeat.o(137666);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
      paramContext = c.psc;
      AppMethodBeat.o(137666);
    }
    return paramContext;
  }
  
  protected c G(e parame)
  {
    AppMethodBeat.i(137665);
    parame = dR(parame.getContext());
    AppMethodBeat.o(137665);
    return parame;
  }
  
  final int a(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(205704);
    Method localMethod = bUy();
    int i;
    if (localMethod == null)
    {
      i = b(paramSignalStrength);
      AppMethodBeat.o(205704);
      return i;
    }
    try
    {
      i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      AppMethodBeat.o(205704);
      return i;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(localException)));
      i = b(paramSignalStrength);
      AppMethodBeat.o(205704);
    }
    return i;
  }
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137664);
    paramJSONObject = new HashMap();
    c localc = G(parame);
    Log.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", new Object[] { parame.getAppId(), localc });
    paramJSONObject.put("networkType", localc.value);
    switch (4.prR[localc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void AL(int paramAnonymousInt)
        {
          AppMethodBeat.i(205484);
          Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          parame.j(paramInt, g.this.m("ok", paramJSONObject));
          AppMethodBeat.o(205484);
        }
      };
      if (!this.prO.getAndSet(true)) {
        h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205809);
            TelephonyManager localTelephonyManager = (TelephonyManager)parame.getContext().getApplicationContext().getSystemService("phone");
            Object localObject = g.this.prP.bUz();
            localObject = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            AppMethodBeat.o(205809);
          }
        });
      }
      if (this.prP.bUA())
      {
        paramJSONObject.AL(this.prN);
        AppMethodBeat.o(137664);
        return;
      }
      this.prP.a(paramJSONObject);
      AppMethodBeat.o(137664);
      return;
      parame = new a()
      {
        public final void AL(int paramAnonymousInt)
        {
          AppMethodBeat.i(205878);
          Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          parame.j(paramInt, g.this.m("ok", paramJSONObject));
          AppMethodBeat.o(205878);
        }
      };
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        parame.AL(ConnectivityCompat.Companion.getWiFiRssi());
        AppMethodBeat.o(137664);
        return;
      }
      Log.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
      parame.AL(2147483647);
      AppMethodBeat.o(137664);
      return;
      parame.j(paramInt, m("ok", paramJSONObject));
    }
  }
  
  static abstract interface a
  {
    public abstract void AL(int paramInt);
  }
  
  final class b
  {
    private PhoneStateListener prS = null;
    boolean prT = false;
    List<g.a> prU = null;
    
    private b() {}
    
    public final void a(g.a parama)
    {
      try
      {
        AppMethodBeat.i(206276);
        if (this.prU == null) {
          this.prU = new ArrayList();
        }
        this.prU.add(parama);
        AppMethodBeat.o(206276);
        return;
      }
      finally {}
    }
    
    public final boolean bUA()
    {
      try
      {
        boolean bool = this.prT;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final PhoneStateListener bUz()
    {
      try
      {
        AppMethodBeat.i(206271);
        if (this.prS == null) {
          this.prS = new PhoneStateListener()
          {
            public final void onSignalStrengthsChanged(SignalStrength arg1)
            {
              AppMethodBeat.i(205784);
              super.onSignalStrengthsChanged(???);
              int i = g.this.a(???);
              Log.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(i)));
              g.this.prN = i;
              synchronized (g.b.this)
              {
                if (g.b.this.prT) {
                  break label152;
                }
                g.b.this.prT = true;
                if (g.b.this.prU == null) {
                  break label152;
                }
                Iterator localIterator = g.b.this.prU.iterator();
                if (localIterator.hasNext()) {
                  ((g.a)localIterator.next()).AL(i);
                }
              }
              g.b.this.prU.clear();
              g.b.this.prU = null;
              label152:
              AppMethodBeat.o(205784);
            }
          };
        }
        PhoneStateListener localPhoneStateListener = this.prS;
        AppMethodBeat.o(206271);
        return localPhoneStateListener;
      }
      finally {}
    }
  }
  
  public static enum c
  {
    public final String value;
    
    static
    {
      AppMethodBeat.i(137663);
      prW = new c("None", 0, "none");
      prX = new c("Mobile_2g", 1, "2g");
      prY = new c("Mobile_3g", 2, "3g");
      prZ = new c("Mobile_4g", 3, "4g");
      psa = new c("Mobile_5g", 4, "5g");
      psb = new c("Wifi", 5, "wifi");
      psc = new c("Unknown", 6, "unknown");
      psd = new c[] { prW, prX, prY, prZ, psa, psb, psc };
      AppMethodBeat.o(137663);
    }
    
    private c(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.g
 * JD-Core Version:    0.7.0.1
 */