package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.report.c.a;
import com.tencent.matrix.report.c.b;
import com.tencent.matrix.report.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ac;
import com.tencent.mm.app.ac.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  static String oEA;
  static boolean oEx;
  static int oEy;
  static long oEz;
  public static d owr;
  private List<WeakReference<b.a>> listeners;
  private Context mContext;
  private MMHandler mRi;
  private g oEB;
  private h oEC;
  public boolean oEg;
  private i oEh;
  long oEi;
  public long oEj;
  private boolean oEk;
  public boolean oEl;
  private double oEm;
  private double oEn;
  private int oEo;
  private double oEp;
  private double oEq;
  private double oEr;
  private String oEs;
  private String oEt;
  private int oEu;
  private boolean oEv;
  private boolean oEw;
  
  static
  {
    AppMethodBeat.i(231790);
    oEy = 0;
    oEz = -1L;
    oEA = null;
    boolean bool = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_battery_location_tms_enable", "1", false, true).equals("1");
    oEx = bool;
    if (bool) {
      ac.aCN().a(new ac.b()
      {
        public final void onProcessBackground(String paramAnonymousString)
        {
          AppMethodBeat.i(231728);
          d.oEz = SystemClock.uptimeMillis();
          AppMethodBeat.o(231728);
        }
        
        public final void onProcessForeground(String paramAnonymousString)
        {
          AppMethodBeat.i(231724);
          if ((d.oEy > 0) && (d.oEz > 0L))
          {
            long l1 = SystemClock.uptimeMillis() - d.oEz;
            int i = d.oEy;
            String str2 = d.oEA;
            if ((l1 > com.tencent.matrix.c.a.aya()) && (i > 0))
            {
              com.tencent.matrix.a.a.a locala = com.tencent.matrix.a.a.a.dD(l1);
              if (locala.clZ)
              {
                l1 = Math.max(1L, l1 / 60000L);
                int j = locala.awy();
                int k = locala.awz();
                long l2 = i / l1;
                if (l2 > 2L)
                {
                  String str3 = c.a.ayX();
                  String str1 = locala.eOk;
                  String str4 = c.b.gU(str2);
                  paramAnonymousString = str1;
                  if (!TextUtils.isEmpty(locala.eOm)) {
                    if (!"background".equals(locala.eOk))
                    {
                      paramAnonymousString = str1;
                      if (!"bg".equals(locala.eOk)) {}
                    }
                    else
                    {
                      paramAnonymousString = "bg-" + locala.eOm;
                    }
                  }
                  Log.i("Matrix.battery.BatteryReporter", "#reportTmsLocationException");
                  e.b.a(e.b.access$300(), str3, "", j, k, "avgTmsLocationErr", l2, "", 0L, "duringMin", l1, paramAnonymousString, str2, locala.eOe, locala.eOg, locala.eOl, str4);
                }
              }
            }
          }
          d.oEy = 0;
          d.oEz = -1L;
          AppMethodBeat.o(231724);
        }
      });
    }
    AppMethodBeat.o(231790);
  }
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(150488);
    this.oEg = false;
    this.listeners = new ArrayList();
    this.oEi = 0L;
    this.oEj = 0L;
    this.oEk = false;
    this.oEl = false;
    this.oEm = 23.0D;
    this.oEn = 100.0D;
    this.oEo = 0;
    this.oEp = 0.0D;
    this.oEq = 0.0D;
    this.oEr = 0.0D;
    this.oEv = false;
    this.oEw = false;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.oEB = new g()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(231738);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, true);
        if (paramAnonymousBoolean)
        {
          d.a(d.this, paramAnonymousDouble1);
          d.b(d.this, paramAnonymousDouble2);
          d.a(d.this, paramAnonymousInt1);
          d.c(d.this, paramAnonymousDouble3);
          d.d(d.this, paramAnonymousDouble4);
          d.e(d.this, paramAnonymousDouble5);
          d.a(d.this, paramAnonymousString1);
          d.b(d.this, paramAnonymousString2);
          d.b(d.this, paramAnonymousInt2);
          d.a(d.this, System.currentTimeMillis());
          d.a(d.this, true);
          d.b(d.this, false);
          d.c(d.this, 67592);
        }
        Log.i("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231729);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.a(d.this));
            localBundle.putString("indoor_building_id", d.b(d.this));
            localBundle.putInt("indoor_building_type", d.c(d.this));
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.oEK, this.oEL, localBundle);
            AppMethodBeat.o(231729);
          }
        });
        AppMethodBeat.o(231738);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(231741);
        Log.i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(231741);
      }
    };
    this.oEC = new h()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(231732);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, false);
        if (paramAnonymousBoolean)
        {
          d.a(d.this, paramAnonymousDouble1);
          d.b(d.this, paramAnonymousDouble2);
          d.a(d.this, paramAnonymousInt1);
          d.c(d.this, paramAnonymousDouble3);
          d.d(d.this, paramAnonymousDouble4);
          d.e(d.this, paramAnonymousDouble5);
          d.a(d.this, paramAnonymousString1);
          d.b(d.this, paramAnonymousString2);
          d.b(d.this, paramAnonymousInt2);
          d.b(d.this, true);
          d.a(d.this, false);
          d.a(d.this, System.currentTimeMillis());
          d.c(d.this, 67591);
        }
        Log.i("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231743);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.a(d.this));
            localBundle.putString("indoor_building_id", d.b(d.this));
            localBundle.putInt("indoor_building_type", d.c(d.this));
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.oEK, this.oEL, localBundle);
            AppMethodBeat.o(231743);
          }
        }, 200L);
        AppMethodBeat.o(231732);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(150488);
  }
  
  private static void bJk()
  {
    AppMethodBeat.i(231718);
    if (!oEx)
    {
      AppMethodBeat.o(231718);
      return;
    }
    if (!ac.aCN().eny)
    {
      oEy += 1;
      if (com.tencent.matrix.c.a.aym()) {
        oEA = com.tencent.matrix.a.b.b.getThrowableStack(new Throwable());
      }
      Log.w("MicroMsg.LocationGeo", "onBgLocateRequest, count = " + oEy + ", stack = \n" + oEA);
    }
    AppMethodBeat.o(231718);
  }
  
  public static d bJl()
  {
    AppMethodBeat.i(150487);
    if (owr == null) {
      owr = new d(MMApplicationContext.getContext());
    }
    if ((owr.oEh == null) && (com.tencent.mm.compatible.util.h.aQh())) {
      owr.oEh = i.dQ(MMApplicationContext.getContext());
    }
    d locald = owr;
    AppMethodBeat.o(150487);
    return locald;
  }
  
  public static boolean bJm()
  {
    AppMethodBeat.i(150494);
    try
    {
      boolean bool = ((LocationManager)MMApplicationContext.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(150494);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(150494);
    }
    return false;
  }
  
  public static boolean bJn()
  {
    AppMethodBeat.i(231734);
    try
    {
      boolean bool = ((LocationManager)MMApplicationContext.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(231734);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(231734);
    }
    return false;
  }
  
  public static void dP(Context paramContext)
  {
    AppMethodBeat.i(150495);
    Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(-1, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(150495);
      return;
    }
    ((Intent)localObject).addFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(150495);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(150493);
    new MMHandler().post(new d.6(this, parama));
    AppMethodBeat.o(150493);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(231797);
    Log.i("MicroMsg.LocationGeo", "startGcj02 %s useCache %s ", new Object[] { parama, Boolean.valueOf(paramBoolean) });
    if (this.oEh == null)
    {
      Log.w("MicroMsg.LocationGeo", "fail, location service not yet ready");
      new MMHandler(Looper.getMainLooper()).post(new d.3(this, parama));
      AppMethodBeat.o(231797);
      return;
    }
    bJk();
    if ((!this.oEg) && (this.listeners.size() > 0)) {}
    try
    {
      this.oEi = System.currentTimeMillis();
      this.oEv = false;
      this.oEw = false;
      this.oEh.bJp();
      this.oEh.a(this.oEB, this.mContext, 1, Looper.getMainLooper());
      this.oEg = true;
      Iterator localIterator = this.listeners.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((b.a)localWeakReference.get()).equals(parama)));
      i = 0;
      if (i != 0) {
        this.listeners.add(new WeakReference(parama));
      }
      Log.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
      if ((this.listeners.size() != 1) || (i == 0)) {}
    }
    catch (i.a locala)
    {
      for (;;)
      {
        try
        {
          this.oEi = System.currentTimeMillis();
          this.oEv = false;
          this.oEw = false;
          this.oEh.a(this.oEB, this.mContext, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.oEk) && (System.currentTimeMillis() - this.oEj < 600000L)) {
            this.oEB.a(true, this.oEm, this.oEn, this.oEo, this.oEp, this.oEq, this.oEr, this.oEs, this.oEt, this.oEu);
          }
          AppMethodBeat.o(231797);
          return;
          locala = locala;
          Log.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (i.a parama)
        {
          Log.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void a(b.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(231793);
    Log.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s continuous %b", new Object[] { parama, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.oEh == null)
    {
      Log.w("MicroMsg.LocationGeo", "fail, location service not yet ready");
      new MMHandler(Looper.getMainLooper()).post(new d.2(this, parama));
      AppMethodBeat.o(231793);
      return;
    }
    bJk();
    if ((this.oEg) && (this.listeners.size() > 0)) {}
    for (;;)
    {
      try
      {
        this.oEi = System.currentTimeMillis();
        this.oEv = false;
        this.oEw = false;
        this.oEh.bJp();
        this.oEh.a(this.oEC, this.mContext, 0, Looper.getMainLooper());
        this.oEg = false;
        Iterator localIterator = this.listeners.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (!((b.a)localWeakReference.get()).equals(parama))) {
            continue;
          }
          i = 0;
          if (i != 0) {
            this.listeners.add(new WeakReference(parama));
          }
          Log.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
          if ((paramBoolean1) && (this.oEl) && (System.currentTimeMillis() - this.oEj < 600000L))
          {
            this.oEC.a(true, this.oEm, this.oEn, this.oEo, this.oEp, this.oEq, this.oEr, this.oEs, this.oEt, this.oEu);
            if (!paramBoolean2)
            {
              Log.i("MicroMsg.LocationGeo", "once location, and can use cache");
              AppMethodBeat.o(231793);
              return;
            }
          }
        }
      }
      catch (i.a locala)
      {
        Log.d("MicroMsg.LocationGeo", locala.toString());
        continue;
        if ((this.listeners.size() == 1) && (i != 0)) {
          try
          {
            this.oEi = System.currentTimeMillis();
            this.oEv = false;
            this.oEw = false;
            this.oEh.a(this.oEC, this.mContext, 0, Looper.getMainLooper());
            AppMethodBeat.o(231793);
            return;
          }
          catch (i.a parama)
          {
            Log.d("MicroMsg.LocationGeo", parama.toString());
          }
        }
        AppMethodBeat.o(231793);
        return;
      }
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d
 * JD-Core Version:    0.7.0.1
 */