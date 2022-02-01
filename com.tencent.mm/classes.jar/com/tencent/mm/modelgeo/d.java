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
  public static d hQo;
  double bXG;
  private ap gIf;
  double hXA;
  double hXB;
  int hXC;
  double hXD;
  double hXE;
  String hXF;
  String hXG;
  int hXH;
  private boolean hXI;
  private boolean hXJ;
  private f hXK;
  private g hXL;
  public boolean hXu;
  h hXv;
  long hXw;
  public long hXx;
  boolean hXy;
  public boolean hXz;
  List<WeakReference<b.a>> listeners;
  private Context mContext;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(150488);
    this.hXu = false;
    this.listeners = new ArrayList();
    this.hXw = 0L;
    this.hXx = 0L;
    this.hXy = false;
    this.hXz = false;
    this.hXA = 23.0D;
    this.hXB = 100.0D;
    this.hXC = 0;
    this.hXD = 0.0D;
    this.hXE = 0.0D;
    this.bXG = 0.0D;
    this.hXI = false;
    this.hXJ = false;
    this.gIf = new ap(Looper.getMainLooper());
    this.hXK = new f()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150482);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, true);
        if (paramAnonymousBoolean)
        {
          d.this.hXA = paramAnonymousDouble1;
          d.this.hXB = paramAnonymousDouble2;
          d.this.hXC = paramAnonymousInt1;
          d.this.hXD = paramAnonymousDouble3;
          d.this.hXE = paramAnonymousDouble4;
          d.this.bXG = paramAnonymousDouble5;
          d.this.hXF = paramAnonymousString1;
          d.this.hXG = paramAnonymousString2;
          d.this.hXH = paramAnonymousInt2;
          d.this.hXx = System.currentTimeMillis();
          d.this.hXy = true;
          d.this.hXz = false;
          d.a(d.this, 67592);
        }
        ad.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150481);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.hXG);
            localBundle.putString("indoor_building_id", d.this.hXF);
            localBundle.putInt("indoor_building_type", d.this.hXH);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.hXS, localBundle);
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
    this.hXL = new g()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150485);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, false);
        if (paramAnonymousBoolean)
        {
          d.this.hXA = paramAnonymousDouble1;
          d.this.hXB = paramAnonymousDouble2;
          d.this.hXC = paramAnonymousInt1;
          d.this.hXD = paramAnonymousDouble3;
          d.this.hXE = paramAnonymousDouble4;
          d.this.bXG = paramAnonymousDouble5;
          d.this.hXF = paramAnonymousString1;
          d.this.hXG = paramAnonymousString2;
          d.this.hXH = paramAnonymousInt2;
          d.this.hXz = true;
          d.this.hXy = false;
          d.this.hXx = System.currentTimeMillis();
          d.a(d.this, 67591);
        }
        ad.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new ap(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150484);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.hXG);
            localBundle.putString("indoor_building_id", d.this.hXF);
            localBundle.putInt("indoor_building_type", d.this.hXH);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.hXS, localBundle);
            AppMethodBeat.o(150484);
          }
        }, 200L);
        AppMethodBeat.o(150485);
      }
    };
    this.mContext = paramContext;
    this.hXv = h.cC(paramContext);
    AppMethodBeat.o(150488);
  }
  
  public static d aHQ()
  {
    AppMethodBeat.i(150487);
    if (hQo == null) {
      hQo = new d(aj.getContext());
    }
    d locald = hQo;
    AppMethodBeat.o(150487);
    return locald;
  }
  
  public static boolean aHR()
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
      ad.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(150494);
    }
    return false;
  }
  
  public static boolean aHS()
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
      ad.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(150496);
    }
    return false;
  }
  
  public static void cB(Context paramContext)
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    if ((this.hXu) && (this.listeners.size() > 0)) {}
    try
    {
      this.hXw = System.currentTimeMillis();
      this.hXI = false;
      this.hXJ = false;
      this.hXv.aHU();
      this.hXv.a(this.hXL, 0, Looper.getMainLooper());
      this.hXu = false;
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
          this.hXw = System.currentTimeMillis();
          this.hXI = false;
          this.hXJ = false;
          this.hXv.a(this.hXL, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.hXz) && (System.currentTimeMillis() - this.hXx < 60000L)) {
            this.hXL.a(true, this.hXA, this.hXB, this.hXC, this.hXD, this.hXE, this.bXG, this.hXF, this.hXG, this.hXH);
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
    AppMethodBeat.i(221218);
    a(parama, true);
    AppMethodBeat.o(221218);
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150492);
    if ((!this.hXu) && (this.listeners.size() > 0)) {}
    try
    {
      this.hXw = System.currentTimeMillis();
      this.hXI = false;
      this.hXJ = false;
      this.hXv.aHU();
      this.hXv.a(this.hXK, 1, Looper.getMainLooper());
      this.hXu = true;
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
          this.hXw = System.currentTimeMillis();
          this.hXI = false;
          this.hXJ = false;
          this.hXv.a(this.hXK, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.hXy) && (System.currentTimeMillis() - this.hXx < 60000L)) {
            this.hXK.a(true, this.hXA, this.hXB, this.hXC, this.hXD, this.hXE, this.bXG, this.hXF, this.hXG, this.hXH);
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
        if ((d.this.listeners.size() == 0) && (d.this.hXv != null)) {
          d.this.hXv.aHU();
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