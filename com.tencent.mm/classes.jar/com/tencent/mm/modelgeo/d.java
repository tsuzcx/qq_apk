package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  public static d gXu;
  double bPL;
  private ap gAC;
  private boolean heA;
  private boolean heB;
  private f heC;
  private g heD;
  public boolean hem;
  h hen;
  long heo;
  public long hep;
  boolean heq;
  public boolean her;
  double hes;
  double het;
  int heu;
  double hev;
  double hew;
  String hex;
  String hey;
  int hez;
  List<WeakReference<b.a>> listeners;
  private Context mContext;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(150488);
    this.hem = false;
    this.listeners = new ArrayList();
    this.heo = 0L;
    this.hep = 0L;
    this.heq = false;
    this.her = false;
    this.hes = 23.0D;
    this.het = 100.0D;
    this.heu = 0;
    this.hev = 0.0D;
    this.hew = 0.0D;
    this.bPL = 0.0D;
    this.heA = false;
    this.heB = false;
    this.gAC = new ap(Looper.getMainLooper());
    this.heC = new f()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150482);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, true);
        if (paramAnonymousBoolean)
        {
          d.this.hes = paramAnonymousDouble1;
          d.this.het = paramAnonymousDouble2;
          d.this.heu = paramAnonymousInt1;
          d.this.hev = paramAnonymousDouble3;
          d.this.hew = paramAnonymousDouble4;
          d.this.bPL = paramAnonymousDouble5;
          d.this.hex = paramAnonymousString1;
          d.this.hey = paramAnonymousString2;
          d.this.hez = paramAnonymousInt2;
          d.this.hep = System.currentTimeMillis();
          d.this.heq = true;
          d.this.her = false;
          d.a(d.this, 67592);
        }
        ad.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150481);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.hey);
            localBundle.putString("indoor_building_id", d.this.hex);
            localBundle.putInt("indoor_building_type", d.this.hez);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.heK, localBundle);
            AppMethodBeat.o(150481);
          }
        });
        AppMethodBeat.o(150482);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(150483);
        ad.i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(150483);
      }
    };
    this.heD = new g()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150485);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, false);
        if (paramAnonymousBoolean)
        {
          d.this.hes = paramAnonymousDouble1;
          d.this.het = paramAnonymousDouble2;
          d.this.heu = paramAnonymousInt1;
          d.this.hev = paramAnonymousDouble3;
          d.this.hew = paramAnonymousDouble4;
          d.this.bPL = paramAnonymousDouble5;
          d.this.hex = paramAnonymousString1;
          d.this.hey = paramAnonymousString2;
          d.this.hez = paramAnonymousInt2;
          d.this.her = true;
          d.this.heq = false;
          d.this.hep = System.currentTimeMillis();
          d.a(d.this, 67591);
        }
        ad.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new ap(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150484);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.hey);
            localBundle.putString("indoor_building_id", d.this.hex);
            localBundle.putInt("indoor_building_type", d.this.hez);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.heK, localBundle);
            AppMethodBeat.o(150484);
          }
        }, 200L);
        AppMethodBeat.o(150485);
      }
    };
    this.mContext = paramContext;
    this.hen = h.cw(paramContext);
    AppMethodBeat.o(150488);
  }
  
  public static d axT()
  {
    AppMethodBeat.i(150487);
    if (gXu == null) {
      gXu = new d(aj.getContext());
    }
    d locald = gXu;
    AppMethodBeat.o(150487);
    return locald;
  }
  
  public static boolean axU()
  {
    AppMethodBeat.i(150494);
    try
    {
      boolean bool = ((LocationManager)aj.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(150494);
      return bool;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(150494);
    }
    return false;
  }
  
  public static boolean axV()
  {
    AppMethodBeat.i(150496);
    try
    {
      boolean bool = ((LocationManager)aj.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(150496);
      return bool;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(150496);
    }
    return false;
  }
  
  public static void cv(Context paramContext)
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(150495);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(150491);
    b(parama, true);
    AppMethodBeat.o(150491);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150489);
    ad.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[] { parama, Boolean.valueOf(paramBoolean), Integer.valueOf(0) });
    if ((this.hem) && (this.listeners.size() > 0)) {}
    try
    {
      this.heo = System.currentTimeMillis();
      this.heA = false;
      this.heB = false;
      this.hen.axX();
      this.hen.a(this.heD, 0, Looper.getMainLooper());
      this.hem = false;
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
      ad.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
      if ((this.listeners.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.heo = System.currentTimeMillis();
          this.heA = false;
          this.heB = false;
          this.hen.a(this.heD, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.her) && (System.currentTimeMillis() - this.hep < 60000L)) {
            this.heD.a(true, this.hes, this.het, this.heu, this.hev, this.hew, this.bPL, this.hex, this.hey, this.hez);
          }
          AppMethodBeat.o(150489);
          return;
          locala = locala;
          ad.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ad.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(203568);
    a(parama, true);
    AppMethodBeat.o(203568);
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150492);
    if ((!this.hem) && (this.listeners.size() > 0)) {}
    try
    {
      this.heo = System.currentTimeMillis();
      this.heA = false;
      this.heB = false;
      this.hen.axX();
      this.hen.a(this.heC, 1, Looper.getMainLooper());
      this.hem = true;
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
      ad.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
      if ((this.listeners.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.heo = System.currentTimeMillis();
          this.heA = false;
          this.heB = false;
          this.hen.a(this.heC, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.heq) && (System.currentTimeMillis() - this.hep < 60000L)) {
            this.heC.a(true, this.hes, this.het, this.heu, this.hev, this.hew, this.bPL, this.hex, this.hey, this.hez);
          }
          AppMethodBeat.o(150492);
          return;
          locala = locala;
          ad.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ad.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void c(final b.a parama)
  {
    AppMethodBeat.i(150493);
    new ap().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150486);
        Object localObject1 = new ArrayList();
        Object localObject2 = d.this.listeners.iterator();
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
          d.this.listeners.remove(localObject2);
        }
        ad.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[] { Integer.valueOf(d.this.listeners.size()) });
        if ((d.this.listeners.size() == 0) && (d.this.hen != null)) {
          d.this.hen.axX();
        }
        AppMethodBeat.o(150486);
      }
    });
    AppMethodBeat.o(150493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d
 * JD-Core Version:    0.7.0.1
 */