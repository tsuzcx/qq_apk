package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class f
  extends d
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  private final AtomicBoolean mtA;
  private Method mtB;
  volatile int mtC;
  private final AtomicBoolean mtD;
  final b mtE;
  
  public f()
  {
    AppMethodBeat.i(193712);
    this.mtA = new AtomicBoolean(false);
    this.mtB = null;
    this.mtC = 2147483647;
    this.mtD = new AtomicBoolean(false);
    this.mtE = new b((byte)0);
    AppMethodBeat.o(193712);
  }
  
  private static int b(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(193715);
    if (paramSignalStrength.isGsm()) {}
    for (int i = c(paramSignalStrength);; i = paramSignalStrength.getCdmaDbm())
    {
      Log.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(i)));
      AppMethodBeat.o(193715);
      return i;
    }
  }
  
  private Method bIP()
  {
    AppMethodBeat.i(193714);
    if (!this.mtA.getAndSet(true)) {}
    try
    {
      this.mtB = SignalStrength.class.getMethod("getDbm", new Class[0]);
      Method localMethod = this.mtB;
      AppMethodBeat.o(193714);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(localException)));
        this.mtB = null;
      }
    }
  }
  
  private static int c(SignalStrength paramSignalStrength)
  {
    int j = -1;
    AppMethodBeat.i(193716);
    int k = paramSignalStrength.getGsmSignalStrength();
    if (k == 99) {}
    for (int i = -1;; i = k)
    {
      if (i != -1) {
        j = k * 2 - 113;
      }
      AppMethodBeat.o(193716);
      return j;
    }
  }
  
  public static f.c dS(Context paramContext)
  {
    AppMethodBeat.i(137666);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        paramContext = f.c.mtR;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
      {
        paramContext = f.c.mtL;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getType() == 1)
      {
        paramContext = f.c.mtQ;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4))
      {
        paramContext = f.c.mtM;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
      {
        paramContext = f.c.mtN;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 13) && (paramContext.getSubtype() < 20))
      {
        paramContext = f.c.mtO;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getSubtype() >= 20)
      {
        paramContext = f.c.mtP;
        AppMethodBeat.o(137666);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
      paramContext = f.c.mtR;
      AppMethodBeat.o(137666);
    }
    return paramContext;
  }
  
  protected f.c D(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(137665);
    paramf = dS(paramf.getContext());
    AppMethodBeat.o(137665);
    return paramf;
  }
  
  final int a(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(193713);
    Method localMethod = bIP();
    int i;
    if (localMethod == null)
    {
      i = b(paramSignalStrength);
      AppMethodBeat.o(193713);
      return i;
    }
    try
    {
      i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      AppMethodBeat.o(193713);
      return i;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(localException)));
      i = b(paramSignalStrength);
      AppMethodBeat.o(193713);
    }
    return i;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137664);
    paramJSONObject = new HashMap();
    f.c localc = D(paramf);
    Log.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", new Object[] { paramf.getAppId(), localc });
    paramJSONObject.put("networkType", localc.value);
    switch (f.4.mtG[localc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void xp(int paramAnonymousInt)
        {
          AppMethodBeat.i(193705);
          Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramf.i(paramInt, f.this.n("ok", paramJSONObject));
          AppMethodBeat.o(193705);
        }
      };
      if (!this.mtD.getAndSet(true)) {
        h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193707);
            TelephonyManager localTelephonyManager = (TelephonyManager)paramf.getContext().getApplicationContext().getSystemService("phone");
            Object localObject = f.this.mtE.bIQ();
            localObject = c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$3", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            AppMethodBeat.o(193707);
          }
        });
      }
      if (this.mtE.bIR())
      {
        paramJSONObject.xp(this.mtC);
        AppMethodBeat.o(137664);
        return;
      }
      this.mtE.a(paramJSONObject);
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void xp(int paramAnonymousInt)
        {
          AppMethodBeat.i(193706);
          Log.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramf.i(paramInt, f.this.n("ok", paramJSONObject));
          AppMethodBeat.o(193706);
        }
      };
      paramf = ((WifiManager)paramf.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if ((paramf != null) && (paramf.getBSSID() != null))
      {
        paramJSONObject.xp(paramf.getRssi());
        AppMethodBeat.o(137664);
        return;
      }
      Log.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
      paramJSONObject.xp(2147483647);
      AppMethodBeat.o(137664);
      return;
      paramf.i(paramInt, n("ok", paramJSONObject));
    }
  }
  
  static abstract interface a
  {
    public abstract void xp(int paramInt);
  }
  
  final class b
  {
    private PhoneStateListener mtH = null;
    boolean mtI = false;
    List<f.a> mtJ = null;
    
    private b() {}
    
    public final void a(f.a parama)
    {
      try
      {
        AppMethodBeat.i(193711);
        if (this.mtJ == null) {
          this.mtJ = new ArrayList();
        }
        this.mtJ.add(parama);
        AppMethodBeat.o(193711);
        return;
      }
      finally {}
    }
    
    public final PhoneStateListener bIQ()
    {
      try
      {
        AppMethodBeat.i(193710);
        if (this.mtH == null) {
          this.mtH = new PhoneStateListener()
          {
            public final void onSignalStrengthsChanged(SignalStrength arg1)
            {
              AppMethodBeat.i(193709);
              super.onSignalStrengthsChanged(???);
              int i = f.this.a(???);
              Log.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(i)));
              f.this.mtC = i;
              synchronized (f.b.this)
              {
                if (f.b.this.mtI) {
                  break label152;
                }
                f.b.this.mtI = true;
                if (f.b.this.mtJ == null) {
                  break label152;
                }
                Iterator localIterator = f.b.this.mtJ.iterator();
                if (localIterator.hasNext()) {
                  ((f.a)localIterator.next()).xp(i);
                }
              }
              f.b.this.mtJ.clear();
              f.b.this.mtJ = null;
              label152:
              AppMethodBeat.o(193709);
            }
          };
        }
        PhoneStateListener localPhoneStateListener = this.mtH;
        AppMethodBeat.o(193710);
        return localPhoneStateListener;
      }
      finally {}
    }
    
    public final boolean bIR()
    {
      try
      {
        boolean bool = this.mtI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.f
 * JD-Core Version:    0.7.0.1
 */