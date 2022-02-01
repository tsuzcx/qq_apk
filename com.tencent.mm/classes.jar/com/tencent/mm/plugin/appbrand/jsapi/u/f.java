package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  private final AtomicBoolean kMG;
  private Method kMH;
  volatile int kMI;
  private final AtomicBoolean kMJ;
  final b kMK;
  
  public f()
  {
    AppMethodBeat.i(206824);
    this.kMG = new AtomicBoolean(false);
    this.kMH = null;
    this.kMI = 2147483647;
    this.kMJ = new AtomicBoolean(false);
    this.kMK = new b((byte)0);
    AppMethodBeat.o(206824);
  }
  
  private static int b(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(206827);
    if (paramSignalStrength.isGsm()) {}
    for (int i = c(paramSignalStrength);; i = paramSignalStrength.getCdmaDbm())
    {
      ac.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(i)));
      AppMethodBeat.o(206827);
      return i;
    }
  }
  
  private Method biQ()
  {
    AppMethodBeat.i(206826);
    if (!this.kMG.getAndSet(true)) {}
    try
    {
      this.kMH = SignalStrength.class.getMethod("getDbm", new Class[0]);
      Method localMethod = this.kMH;
      AppMethodBeat.o(206826);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(localException)));
        this.kMH = null;
      }
    }
  }
  
  private static int c(SignalStrength paramSignalStrength)
  {
    int j = -1;
    AppMethodBeat.i(206828);
    int k = paramSignalStrength.getGsmSignalStrength();
    if (k == 99) {}
    for (int i = -1;; i = k)
    {
      if (i != -1) {
        j = k * 2 - 113;
      }
      AppMethodBeat.o(206828);
      return j;
    }
  }
  
  public static f.c dv(Context paramContext)
  {
    AppMethodBeat.i(137666);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        paramContext = f.c.kMX;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
      {
        paramContext = f.c.kMR;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getType() == 1)
      {
        paramContext = f.c.kMW;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4))
      {
        paramContext = f.c.kMS;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
      {
        paramContext = f.c.kMT;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 13) && (paramContext.getSubtype() < 20))
      {
        paramContext = f.c.kMU;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getSubtype() >= 20)
      {
        paramContext = f.c.kMV;
        AppMethodBeat.o(137666);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
      paramContext = f.c.kMX;
      AppMethodBeat.o(137666);
    }
    return paramContext;
  }
  
  protected f.c C(c paramc)
  {
    AppMethodBeat.i(137665);
    paramc = dv(paramc.getContext());
    AppMethodBeat.o(137665);
    return paramc;
  }
  
  final int a(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(206825);
    Method localMethod = biQ();
    int i;
    if (localMethod == null)
    {
      i = b(paramSignalStrength);
      AppMethodBeat.o(206825);
      return i;
    }
    try
    {
      i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      AppMethodBeat.o(206825);
      return i;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(localException)));
      i = b(paramSignalStrength);
      AppMethodBeat.o(206825);
    }
    return i;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137664);
    paramJSONObject = new HashMap();
    f.c localc = C(paramc);
    ac.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", new Object[] { paramc.getAppId(), localc });
    paramJSONObject.put("networkType", localc.value);
    switch (f.4.kMM[localc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void sL(int paramAnonymousInt)
        {
          AppMethodBeat.i(206817);
          ac.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, f.this.k("ok", paramJSONObject));
          AppMethodBeat.o(206817);
        }
      };
      if (!this.kMJ.getAndSet(true)) {
        h.JZN.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206819);
            ((TelephonyManager)paramc.getContext().getApplicationContext().getSystemService("phone")).listen(f.this.kMK.biR(), 256);
            AppMethodBeat.o(206819);
          }
        });
      }
      if (this.kMK.biS())
      {
        paramJSONObject.sL(this.kMI);
        AppMethodBeat.o(137664);
        return;
      }
      this.kMK.a(paramJSONObject);
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void sL(int paramAnonymousInt)
        {
          AppMethodBeat.i(206818);
          ac.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, f.this.k("ok", paramJSONObject));
          AppMethodBeat.o(206818);
        }
      };
      paramc = ((WifiManager)paramc.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if ((paramc != null) && (paramc.getBSSID() != null))
      {
        paramJSONObject.sL(paramc.getRssi());
        AppMethodBeat.o(137664);
        return;
      }
      ac.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
      paramJSONObject.sL(2147483647);
      AppMethodBeat.o(137664);
      return;
      paramc.h(paramInt, k("ok", paramJSONObject));
    }
  }
  
  static abstract interface a
  {
    public abstract void sL(int paramInt);
  }
  
  final class b
  {
    private PhoneStateListener kMN = null;
    boolean kMO = false;
    List<f.a> kMP = null;
    
    private b() {}
    
    public final void a(f.a parama)
    {
      try
      {
        AppMethodBeat.i(206823);
        if (this.kMP == null) {
          this.kMP = new ArrayList();
        }
        this.kMP.add(parama);
        AppMethodBeat.o(206823);
        return;
      }
      finally {}
    }
    
    public final PhoneStateListener biR()
    {
      try
      {
        AppMethodBeat.i(206822);
        if (this.kMN == null) {
          this.kMN = new PhoneStateListener()
          {
            public final void onSignalStrengthsChanged(SignalStrength arg1)
            {
              AppMethodBeat.i(206821);
              super.onSignalStrengthsChanged(???);
              int i = f.this.a(???);
              ac.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(i)));
              f.this.kMI = i;
              synchronized (f.b.this)
              {
                if (f.b.this.kMO) {
                  break label152;
                }
                f.b.this.kMO = true;
                if (f.b.this.kMP == null) {
                  break label152;
                }
                Iterator localIterator = f.b.this.kMP.iterator();
                if (localIterator.hasNext()) {
                  ((f.a)localIterator.next()).sL(i);
                }
              }
              f.b.this.kMP.clear();
              f.b.this.kMP = null;
              label152:
              AppMethodBeat.o(206821);
            }
          };
        }
        PhoneStateListener localPhoneStateListener = this.kMN;
        AppMethodBeat.o(206822);
        return localPhoneStateListener;
      }
      finally {}
    }
    
    public final boolean biS()
    {
      try
      {
        boolean bool = this.kMO;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f
 * JD-Core Version:    0.7.0.1
 */