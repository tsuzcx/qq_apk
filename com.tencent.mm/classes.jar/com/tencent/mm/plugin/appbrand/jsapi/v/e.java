package com.tencent.mm.plugin.appbrand.jsapi.v;

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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class e
  extends a
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  private final AtomicBoolean klo;
  private Method klp;
  volatile int klq;
  private final AtomicBoolean klr;
  final b kls;
  
  public e()
  {
    AppMethodBeat.i(194766);
    this.klo = new AtomicBoolean(false);
    this.klp = null;
    this.klq = 2147483647;
    this.klr = new AtomicBoolean(false);
    this.kls = new b((byte)0);
    AppMethodBeat.o(194766);
  }
  
  private static int b(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(194769);
    if (paramSignalStrength.isGsm()) {}
    for (int i = c(paramSignalStrength);; i = paramSignalStrength.getCdmaDbm())
    {
      ad.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(i)));
      AppMethodBeat.o(194769);
      return i;
    }
  }
  
  private Method bbV()
  {
    AppMethodBeat.i(194768);
    if (!this.klo.getAndSet(true)) {}
    try
    {
      this.klp = SignalStrength.class.getMethod("getDbm", new Class[0]);
      Method localMethod = this.klp;
      AppMethodBeat.o(194768);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(localException)));
        this.klp = null;
      }
    }
  }
  
  private static int c(SignalStrength paramSignalStrength)
  {
    int j = -1;
    AppMethodBeat.i(194770);
    int k = paramSignalStrength.getGsmSignalStrength();
    if (k == 99) {}
    for (int i = -1;; i = k)
    {
      if (i != -1) {
        j = k * 2 - 113;
      }
      AppMethodBeat.o(194770);
      return j;
    }
  }
  
  public static e.c dm(Context paramContext)
  {
    AppMethodBeat.i(137666);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        paramContext = e.c.klF;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
      {
        paramContext = e.c.klz;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getType() == 1)
      {
        paramContext = e.c.klE;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4))
      {
        paramContext = e.c.klA;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
      {
        paramContext = e.c.klB;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 13) && (paramContext.getSubtype() < 20))
      {
        paramContext = e.c.klC;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getSubtype() >= 20)
      {
        paramContext = e.c.klD;
        AppMethodBeat.o(137666);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
      paramContext = e.c.klF;
      AppMethodBeat.o(137666);
    }
    return paramContext;
  }
  
  protected e.c C(c paramc)
  {
    AppMethodBeat.i(137665);
    paramc = dm(paramc.getContext());
    AppMethodBeat.o(137665);
    return paramc;
  }
  
  final int a(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(194767);
    Method localMethod = bbV();
    int i;
    if (localMethod == null)
    {
      i = b(paramSignalStrength);
      AppMethodBeat.o(194767);
      return i;
    }
    try
    {
      i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      AppMethodBeat.o(194767);
      return i;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(localException)));
      i = b(paramSignalStrength);
      AppMethodBeat.o(194767);
    }
    return i;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137664);
    paramJSONObject = new HashMap();
    e.c localc = C(paramc);
    ad.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", new Object[] { paramc.getAppId(), localc });
    paramJSONObject.put("networkType", localc.value);
    switch (e.4.klu[localc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void rU(int paramAnonymousInt)
        {
          AppMethodBeat.i(194759);
          ad.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, e.this.k("ok", paramJSONObject));
          AppMethodBeat.o(194759);
        }
      };
      if (!this.klr.getAndSet(true)) {
        h.Iye.aN(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194761);
            ((TelephonyManager)paramc.getContext().getApplicationContext().getSystemService("phone")).listen(e.this.kls.bbW(), 256);
            AppMethodBeat.o(194761);
          }
        });
      }
      if (this.kls.bbX())
      {
        paramJSONObject.rU(this.klq);
        AppMethodBeat.o(137664);
        return;
      }
      this.kls.a(paramJSONObject);
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void rU(int paramAnonymousInt)
        {
          AppMethodBeat.i(194760);
          ad.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, e.this.k("ok", paramJSONObject));
          AppMethodBeat.o(194760);
        }
      };
      paramc = ((WifiManager)paramc.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if ((paramc != null) && (paramc.getBSSID() != null))
      {
        paramJSONObject.rU(paramc.getRssi());
        AppMethodBeat.o(137664);
        return;
      }
      ad.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
      paramJSONObject.rU(2147483647);
      AppMethodBeat.o(137664);
      return;
      paramc.h(paramInt, k("ok", paramJSONObject));
    }
  }
  
  static abstract interface a
  {
    public abstract void rU(int paramInt);
  }
  
  final class b
  {
    private PhoneStateListener klv = null;
    boolean klw = false;
    List<e.a> klx = null;
    
    private b() {}
    
    public final void a(e.a parama)
    {
      try
      {
        AppMethodBeat.i(194765);
        if (this.klx == null) {
          this.klx = new ArrayList();
        }
        this.klx.add(parama);
        AppMethodBeat.o(194765);
        return;
      }
      finally {}
    }
    
    public final PhoneStateListener bbW()
    {
      try
      {
        AppMethodBeat.i(194764);
        if (this.klv == null) {
          this.klv = new PhoneStateListener()
          {
            public final void onSignalStrengthsChanged(SignalStrength arg1)
            {
              AppMethodBeat.i(194763);
              super.onSignalStrengthsChanged(???);
              int i = e.this.a(???);
              ad.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(i)));
              e.this.klq = i;
              synchronized (e.b.this)
              {
                if (e.b.this.klw) {
                  break label152;
                }
                e.b.this.klw = true;
                if (e.b.this.klx == null) {
                  break label152;
                }
                Iterator localIterator = e.b.this.klx.iterator();
                if (localIterator.hasNext()) {
                  ((e.a)localIterator.next()).rU(i);
                }
              }
              e.b.this.klx.clear();
              e.b.this.klx = null;
              label152:
              AppMethodBeat.o(194763);
            }
          };
        }
        PhoneStateListener localPhoneStateListener = this.klv;
        AppMethodBeat.o(194764);
        return localPhoneStateListener;
      }
      finally {}
    }
    
    public final boolean bbX()
    {
      try
      {
        boolean bool = this.klw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.e
 * JD-Core Version:    0.7.0.1
 */