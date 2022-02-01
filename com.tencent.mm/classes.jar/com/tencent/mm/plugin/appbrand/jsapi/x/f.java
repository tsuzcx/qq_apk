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
import com.tencent.mm.sdk.platformtools.ae;
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
  private final AtomicBoolean lmV;
  private Method lmW;
  volatile int lmX;
  private final AtomicBoolean lmY;
  final b lmZ;
  
  public f()
  {
    AppMethodBeat.i(197263);
    this.lmV = new AtomicBoolean(false);
    this.lmW = null;
    this.lmX = 2147483647;
    this.lmY = new AtomicBoolean(false);
    this.lmZ = new b((byte)0);
    AppMethodBeat.o(197263);
  }
  
  private static int b(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(197266);
    if (paramSignalStrength.isGsm()) {}
    for (int i = c(paramSignalStrength);; i = paramSignalStrength.getCdmaDbm())
    {
      ae.i("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: ".concat(String.valueOf(i)));
      AppMethodBeat.o(197266);
      return i;
    }
  }
  
  private Method bnl()
  {
    AppMethodBeat.i(197265);
    if (!this.lmV.getAndSet(true)) {}
    try
    {
      this.lmW = SignalStrength.class.getMethod("getDbm", new Class[0]);
      Method localMethod = this.lmW;
      AppMethodBeat.o(197265);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since ".concat(String.valueOf(localException)));
        this.lmW = null;
      }
    }
  }
  
  private static int c(SignalStrength paramSignalStrength)
  {
    int j = -1;
    AppMethodBeat.i(197267);
    int k = paramSignalStrength.getGsmSignalStrength();
    if (k == 99) {}
    for (int i = -1;; i = k)
    {
      if (i != -1) {
        j = k * 2 - 113;
      }
      AppMethodBeat.o(197267);
      return j;
    }
  }
  
  public static f.c dx(Context paramContext)
  {
    AppMethodBeat.i(137666);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        paramContext = f.c.lnn;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
      {
        paramContext = f.c.lnh;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getType() == 1)
      {
        paramContext = f.c.lnm;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4))
      {
        paramContext = f.c.lni;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
      {
        paramContext = f.c.lnj;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 13) && (paramContext.getSubtype() < 20))
      {
        paramContext = f.c.lnk;
        AppMethodBeat.o(137666);
        return paramContext;
      }
      if (paramContext.getSubtype() >= 20)
      {
        paramContext = f.c.lnl;
        AppMethodBeat.o(137666);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
      paramContext = f.c.lnn;
      AppMethodBeat.o(137666);
    }
    return paramContext;
  }
  
  protected f.c C(c paramc)
  {
    AppMethodBeat.i(137665);
    paramc = dx(paramc.getContext());
    AppMethodBeat.o(137665);
    return paramc;
  }
  
  final int a(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(197264);
    Method localMethod = bnl();
    int i;
    if (localMethod == null)
    {
      i = b(paramSignalStrength);
      AppMethodBeat.o(197264);
      return i;
    }
    try
    {
      i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      AppMethodBeat.o(197264);
      return i;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since ".concat(String.valueOf(localException)));
      i = b(paramSignalStrength);
      AppMethodBeat.o(197264);
    }
    return i;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137664);
    paramJSONObject = new HashMap();
    f.c localc = C(paramc);
    ae.i("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", new Object[] { paramc.getAppId(), localc });
    paramJSONObject.put("networkType", localc.value);
    switch (f.4.lnb[localc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void tr(int paramAnonymousInt)
        {
          AppMethodBeat.i(197256);
          ae.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, f.this.n("ok", paramJSONObject));
          AppMethodBeat.o(197256);
        }
      };
      if (!this.lmY.getAndSet(true)) {
        h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197258);
            ((TelephonyManager)paramc.getContext().getApplicationContext().getSystemService("phone")).listen(f.this.lmZ.bnm(), 256);
            AppMethodBeat.o(197258);
          }
        });
      }
      if (this.lmZ.bnn())
      {
        paramJSONObject.tr(this.lmX);
        AppMethodBeat.o(137664);
        return;
      }
      this.lmZ.a(paramJSONObject);
      AppMethodBeat.o(137664);
      return;
      paramJSONObject = new a()
      {
        public final void tr(int paramAnonymousInt)
        {
          AppMethodBeat.i(197257);
          ae.i("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: ".concat(String.valueOf(paramAnonymousInt)));
          if (2147483647 != paramAnonymousInt) {
            paramJSONObject.put("signalStrength", Integer.valueOf(paramAnonymousInt));
          }
          paramc.h(paramInt, f.this.n("ok", paramJSONObject));
          AppMethodBeat.o(197257);
        }
      };
      paramc = ((WifiManager)paramc.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if ((paramc != null) && (paramc.getBSSID() != null))
      {
        paramJSONObject.tr(paramc.getRssi());
        AppMethodBeat.o(137664);
        return;
      }
      ae.w("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
      paramJSONObject.tr(2147483647);
      AppMethodBeat.o(137664);
      return;
      paramc.h(paramInt, n("ok", paramJSONObject));
    }
  }
  
  static abstract interface a
  {
    public abstract void tr(int paramInt);
  }
  
  final class b
  {
    private PhoneStateListener lnc = null;
    boolean lnd = false;
    List<f.a> lne = null;
    
    private b() {}
    
    public final void a(f.a parama)
    {
      try
      {
        AppMethodBeat.i(197262);
        if (this.lne == null) {
          this.lne = new ArrayList();
        }
        this.lne.add(parama);
        AppMethodBeat.o(197262);
        return;
      }
      finally {}
    }
    
    public final PhoneStateListener bnm()
    {
      try
      {
        AppMethodBeat.i(197261);
        if (this.lnc == null) {
          this.lnc = new PhoneStateListener()
          {
            public final void onSignalStrengthsChanged(SignalStrength arg1)
            {
              AppMethodBeat.i(197260);
              super.onSignalStrengthsChanged(???);
              int i = f.this.a(???);
              ae.i("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: ".concat(String.valueOf(i)));
              f.this.lmX = i;
              synchronized (f.b.this)
              {
                if (f.b.this.lnd) {
                  break label152;
                }
                f.b.this.lnd = true;
                if (f.b.this.lne == null) {
                  break label152;
                }
                Iterator localIterator = f.b.this.lne.iterator();
                if (localIterator.hasNext()) {
                  ((f.a)localIterator.next()).tr(i);
                }
              }
              f.b.this.lne.clear();
              f.b.this.lne = null;
              label152:
              AppMethodBeat.o(197260);
            }
          };
        }
        PhoneStateListener localPhoneStateListener = this.lnc;
        AppMethodBeat.o(197261);
        return localPhoneStateListener;
      }
      finally {}
    }
    
    public final boolean bnn()
    {
      try
      {
        boolean bool = this.lnd;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.f
 * JD-Core Version:    0.7.0.1
 */