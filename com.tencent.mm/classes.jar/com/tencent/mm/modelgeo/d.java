package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  implements b
{
  public static d lEL;
  private MMHandler knk;
  public boolean lLE;
  private i lLF;
  long lLG;
  public long lLH;
  private boolean lLI;
  public boolean lLJ;
  private double lLK;
  private double lLL;
  private int lLM;
  private double lLN;
  private double lLO;
  private double lLP;
  private String lLQ;
  private String lLR;
  private int lLS;
  private boolean lLT;
  private boolean lLU;
  private g lLV;
  private h lLW;
  private List<WeakReference<b.a>> listeners;
  private Context mContext;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(150488);
    this.lLE = false;
    this.listeners = new ArrayList();
    this.lLG = 0L;
    this.lLH = 0L;
    this.lLI = false;
    this.lLJ = false;
    this.lLK = 23.0D;
    this.lLL = 100.0D;
    this.lLM = 0;
    this.lLN = 0.0D;
    this.lLO = 0.0D;
    this.lLP = 0.0D;
    this.lLT = false;
    this.lLU = false;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.lLV = new g()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150482);
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
        Log.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150481);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.a(d.this));
            localBundle.putString("indoor_building_id", d.b(d.this));
            localBundle.putInt("indoor_building_type", d.c(d.this));
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.lMd, localBundle);
            AppMethodBeat.o(150481);
          }
        });
        AppMethodBeat.o(150482);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(150483);
        Log.i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(150483);
      }
    };
    this.lLW = new h()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150485);
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
        Log.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150484);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.a(d.this));
            localBundle.putString("indoor_building_id", d.b(d.this));
            localBundle.putInt("indoor_building_type", d.c(d.this));
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.lMd, localBundle);
            AppMethodBeat.o(150484);
          }
        }, 200L);
        AppMethodBeat.o(150485);
      }
    };
    this.mContext = paramContext;
    this.lLF = i.cX(paramContext);
    AppMethodBeat.o(150488);
  }
  
  public static d blq()
  {
    AppMethodBeat.i(150487);
    if (lEL == null) {
      lEL = new d(MMApplicationContext.getContext());
    }
    d locald = lEL;
    AppMethodBeat.o(150487);
    return locald;
  }
  
  public static boolean blr()
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
  
  public static boolean bls()
  {
    AppMethodBeat.i(150496);
    try
    {
      boolean bool = ((LocationManager)MMApplicationContext.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(150496);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(150496);
    }
    return false;
  }
  
  public static void cW(Context paramContext)
  {
    AppMethodBeat.i(150495);
    Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult((Intent)localObject, -1);
      AppMethodBeat.o(150495);
      return;
    }
    ((Intent)localObject).addFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(150495);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(293012);
    a(parama, true);
    AppMethodBeat.o(293012);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150489);
    Log.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[] { parama, Boolean.valueOf(paramBoolean), Integer.valueOf(0) });
    if ((this.lLE) && (this.listeners.size() > 0)) {}
    try
    {
      this.lLG = System.currentTimeMillis();
      this.lLT = false;
      this.lLU = false;
      this.lLF.blu();
      this.lLF.a(this.lLW, 0, Looper.getMainLooper());
      this.lLE = false;
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
          this.lLG = System.currentTimeMillis();
          this.lLT = false;
          this.lLU = false;
          this.lLF.a(this.lLW, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.lLJ) && (System.currentTimeMillis() - this.lLH < 60000L)) {
            this.lLW.a(true, this.lLK, this.lLL, this.lLM, this.lLN, this.lLO, this.lLP, this.lLQ, this.lLR, this.lLS);
          }
          AppMethodBeat.o(150489);
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
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(150493);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150486);
        Object localObject1 = new ArrayList();
        Object localObject2 = d.d(d.this).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (((b.a)localWeakReference.get()).equals(parama))) {
            ((List)localObject1).add(localWeakReference);
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WeakReference)((Iterator)localObject1).next();
          d.d(d.this).remove(localObject2);
        }
        Log.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[] { Integer.valueOf(d.d(d.this).size()) });
        if ((d.d(d.this).size() == 0) && (d.e(d.this) != null)) {
          d.e(d.this).blu();
        }
        AppMethodBeat.o(150486);
      }
    });
    AppMethodBeat.o(150493);
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150492);
    if ((!this.lLE) && (this.listeners.size() > 0)) {}
    try
    {
      this.lLG = System.currentTimeMillis();
      this.lLT = false;
      this.lLU = false;
      this.lLF.blu();
      this.lLF.a(this.lLV, 1, Looper.getMainLooper());
      this.lLE = true;
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
          this.lLG = System.currentTimeMillis();
          this.lLT = false;
          this.lLU = false;
          this.lLF.a(this.lLV, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.lLI) && (System.currentTimeMillis() - this.lLH < 60000L)) {
            this.lLV.a(true, this.lLK, this.lLL, this.lLM, this.lLN, this.lLO, this.lLP, this.lLQ, this.lLR, this.lLS);
          }
          AppMethodBeat.o(150492);
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
  
  public final void c(b.a parama)
  {
    AppMethodBeat.i(150491);
    b(parama, true);
    AppMethodBeat.o(150491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d
 * JD-Core Version:    0.7.0.1
 */