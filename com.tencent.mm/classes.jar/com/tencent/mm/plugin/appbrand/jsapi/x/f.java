package com.tencent.mm.plugin.appbrand.jsapi.x;

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

public class f
  extends a
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  private final AtomicBoolean ljj;
  private Method ljk;
  volatile int ljl;
  private final AtomicBoolean ljm;
  final b ljn;
  
  public f()
  {
    AppMethodBeat.i(195032);
    this.ljj = new AtomicBoolean(false);
    this.ljk = null;
    this.ljl = 2147483647;
    this.ljm = new AtomicBoolean(false);
    this.ljn = new b((byte)0);
    AppMethodBeat.o(195032);
  }
  
  private static int b(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(195035);
    if (paramSignalStrength.isGsm()) {}
    for (int i = c(paramSignalStrength);; i = paramSignalStrength.getCdmaDbm())
    {
      ad.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(i)));
      AppMethodBeat.o(195035);
      return i;
    }
  }
  
  private Method bmC()
  {
    AppMethodBeat.i(195034);
    if (!this.ljj.getAndSet(true)) {}
    try
    {
      this.ljk = SignalStrength.class.getMethod("getDbm", new Class[0]);
      Method localMethod = this.ljk;
      AppMethodBeat.o(195034);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(localException)));
        this.ljk = null;
      }
    }
  }
  
  private static int c(SignalStrength paramSignalStrength)
  {
    int j = -1;
    AppMethodBeat.i(195036);
    int k = paramSignalStrength.getGsmSignalStrength();
    if (k == 99) {}
    for (int i = -1;; i = k)
    {
      if (i != -1) {
        j = k * 2 - 113;
      }
      AppMethodBeat.o(195036);
      return j;
    }
  }
  
  public static c dt(Context paramContext)
  {
    AppMethodBeat.i(137666);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        paramContext = c.ljA;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
      {
        paramContext = c.lju;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getType() == 1)
      {
        paramContext = c.ljz;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4))
      {
        paramContext = c.ljv;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
      {
        paramContext = c.ljw;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 13) && (paramContext.getSubtype() < 20))
      {
        paramContext = c.ljx;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getSubtype() >= 20)
      {
        paramContext = c.ljy;
        AppMethodBeat.o(137666);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
      paramContext = c.ljA;
      AppMethodBeat.o(137666);
    }
    return paramContext;
  }
  
  protected c C(c paramc)
  {
    AppMethodBeat.i(137665);
    paramc = dt(paramc.getContext());
    AppMethodBeat.o(137665);
    return paramc;
  }
  
  final int a(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(195033);
    Method localMethod = bmC();
    int i;
    if (localMethod == null)
    {
      i = b(paramSignalStrength);
      AppMethodBeat.o(195033);
      return i;
    }
    try
    {
      i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      AppMethodBeat.o(195033);
      return i;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(localException)));
      i = b(paramSignalStrength);
      AppMethodBeat.o(195033);
    }
    return i;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137664);
    paramJSONObject = new HashMap();
    c localc = C(paramc);
    ad.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", new Object[] { paramc.getAppId(), localc });
    paramJSONObject.put("networkType", localc.value);
    switch (4.ljp[localc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void to(int paramAnonymousInt)
        {
          AppMethodBeat.i(195025);
          ad.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, f.this.m("ok", paramJSONObject));
          AppMethodBeat.o(195025);
        }
      };
      if (!this.ljm.getAndSet(true)) {
        h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195027);
            ((TelephonyManager)paramc.getContext().getApplicationContext().getSystemService("phone")).listen(f.this.ljn.bmD(), 256);
            AppMethodBeat.o(195027);
          }
        });
      }
      if (this.ljn.bmE())
      {
        paramJSONObject.to(this.ljl);
        AppMethodBeat.o(137664);
        return;
      }
      this.ljn.a(paramJSONObject);
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void to(int paramAnonymousInt)
        {
          AppMethodBeat.i(195026);
          ad.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, f.this.m("ok", paramJSONObject));
          AppMethodBeat.o(195026);
        }
      };
      paramc = ((WifiManager)paramc.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if ((paramc != null) && (paramc.getBSSID() != null))
      {
        paramJSONObject.to(paramc.getRssi());
        AppMethodBeat.o(137664);
        return;
      }
      ad.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
      paramJSONObject.to(2147483647);
      AppMethodBeat.o(137664);
      return;
      paramc.h(paramInt, m("ok", paramJSONObject));
    }
  }
  
  static abstract interface a
  {
    public abstract void to(int paramInt);
  }
  
  final class b
  {
    private PhoneStateListener ljq = null;
    boolean ljr = false;
    List<f.a> ljs = null;
    
    private b() {}
    
    public final void a(f.a parama)
    {
      try
      {
        AppMethodBeat.i(195031);
        if (this.ljs == null) {
          this.ljs = new ArrayList();
        }
        this.ljs.add(parama);
        AppMethodBeat.o(195031);
        return;
      }
      finally {}
    }
    
    public final PhoneStateListener bmD()
    {
      try
      {
        AppMethodBeat.i(195030);
        if (this.ljq == null) {
          this.ljq = new PhoneStateListener()
          {
            public final void onSignalStrengthsChanged(SignalStrength arg1)
            {
              AppMethodBeat.i(195029);
              super.onSignalStrengthsChanged(???);
              int i = f.this.a(???);
              ad.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(i)));
              f.this.ljl = i;
              synchronized (f.b.this)
              {
                if (f.b.this.ljr) {
                  break label152;
                }
                f.b.this.ljr = true;
                if (f.b.this.ljs == null) {
                  break label152;
                }
                Iterator localIterator = f.b.this.ljs.iterator();
                if (localIterator.hasNext()) {
                  ((f.a)localIterator.next()).to(i);
                }
              }
              f.b.this.ljs.clear();
              f.b.this.ljs = null;
              label152:
              AppMethodBeat.o(195029);
            }
          };
        }
        PhoneStateListener localPhoneStateListener = this.ljq;
        AppMethodBeat.o(195030);
        return localPhoneStateListener;
      }
      finally {}
    }
    
    public final boolean bmE()
    {
      try
      {
        boolean bool = this.ljr;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  public static enum c
  {
    public final String value;
    
    static
    {
      AppMethodBeat.i(137663);
      lju = new c("None", 0, "none");
      ljv = new c("Mobile_2g", 1, "2g");
      ljw = new c("Mobile_3g", 2, "3g");
      ljx = new c("Mobile_4g", 3, "4g");
      ljy = new c("Mobile_5g", 4, "5g");
      ljz = new c("Wifi", 5, "wifi");
      ljA = new c("Unknown", 6, "unknown");
      ljB = new c[] { lju, ljv, ljw, ljx, ljy, ljz, ljA };
      AppMethodBeat.o(137663);
    }
    
    private c(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.f
 * JD-Core Version:    0.7.0.1
 */