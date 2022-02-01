package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  public static d hxT;
  double bNt;
  private ao gox;
  public boolean hEP;
  h hEQ;
  long hER;
  public long hES;
  boolean hET;
  public boolean hEU;
  double hEV;
  double hEW;
  int hEX;
  double hEY;
  double hEZ;
  String hFa;
  String hFb;
  int hFc;
  private boolean hFd;
  private boolean hFe;
  private f hFf;
  private g hFg;
  List<WeakReference<b.a>> listeners;
  private Context mContext;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(150488);
    this.hEP = false;
    this.listeners = new ArrayList();
    this.hER = 0L;
    this.hES = 0L;
    this.hET = false;
    this.hEU = false;
    this.hEV = 23.0D;
    this.hEW = 100.0D;
    this.hEX = 0;
    this.hEY = 0.0D;
    this.hEZ = 0.0D;
    this.bNt = 0.0D;
    this.hFd = false;
    this.hFe = false;
    this.gox = new ao(Looper.getMainLooper());
    this.hFf = new f()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150482);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, true);
        if (paramAnonymousBoolean)
        {
          d.this.hEV = paramAnonymousDouble1;
          d.this.hEW = paramAnonymousDouble2;
          d.this.hEX = paramAnonymousInt1;
          d.this.hEY = paramAnonymousDouble3;
          d.this.hEZ = paramAnonymousDouble4;
          d.this.bNt = paramAnonymousDouble5;
          d.this.hFa = paramAnonymousString1;
          d.this.hFb = paramAnonymousString2;
          d.this.hFc = paramAnonymousInt2;
          d.this.hES = System.currentTimeMillis();
          d.this.hET = true;
          d.this.hEU = false;
          d.a(d.this, 67592);
        }
        ac.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new ao(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150481);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.hFb);
            localBundle.putString("indoor_building_id", d.this.hFa);
            localBundle.putInt("indoor_building_type", d.this.hFc);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.hFn, localBundle);
            AppMethodBeat.o(150481);
          }
        });
        AppMethodBeat.o(150482);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(150483);
        ac.i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(150483);
      }
    };
    this.hFg = new g()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150485);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, false);
        if (paramAnonymousBoolean)
        {
          d.this.hEV = paramAnonymousDouble1;
          d.this.hEW = paramAnonymousDouble2;
          d.this.hEX = paramAnonymousInt1;
          d.this.hEY = paramAnonymousDouble3;
          d.this.hEZ = paramAnonymousDouble4;
          d.this.bNt = paramAnonymousDouble5;
          d.this.hFa = paramAnonymousString1;
          d.this.hFb = paramAnonymousString2;
          d.this.hFc = paramAnonymousInt2;
          d.this.hEU = true;
          d.this.hET = false;
          d.this.hES = System.currentTimeMillis();
          d.a(d.this, 67591);
        }
        ac.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new ao(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150484);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.hFb);
            localBundle.putString("indoor_building_id", d.this.hFa);
            localBundle.putInt("indoor_building_type", d.this.hFc);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.hFn, localBundle);
            AppMethodBeat.o(150484);
          }
        }, 200L);
        AppMethodBeat.o(150485);
      }
    };
    this.mContext = paramContext;
    this.hEQ = h.cF(paramContext);
    AppMethodBeat.o(150488);
  }
  
  public static d aEL()
  {
    AppMethodBeat.i(150487);
    if (hxT == null) {
      hxT = new d(ai.getContext());
    }
    d locald = hxT;
    AppMethodBeat.o(150487);
    return locald;
  }
  
  public static boolean aEM()
  {
    AppMethodBeat.i(150494);
    try
    {
      boolean bool = ((LocationManager)ai.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(150494);
      return bool;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(150494);
    }
    return false;
  }
  
  public static boolean aEN()
  {
    AppMethodBeat.i(150496);
    try
    {
      boolean bool = ((LocationManager)ai.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(150496);
      return bool;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(150496);
    }
    return false;
  }
  
  public static void cE(Context paramContext)
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    ac.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[] { parama, Boolean.valueOf(paramBoolean), Integer.valueOf(0) });
    if ((this.hEP) && (this.listeners.size() > 0)) {}
    try
    {
      this.hER = System.currentTimeMillis();
      this.hFd = false;
      this.hFe = false;
      this.hEQ.aEP();
      this.hEQ.a(this.hFg, 0, Looper.getMainLooper());
      this.hEP = false;
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
      ac.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
      if ((this.listeners.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.hER = System.currentTimeMillis();
          this.hFd = false;
          this.hFe = false;
          this.hEQ.a(this.hFg, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.hEU) && (System.currentTimeMillis() - this.hES < 60000L)) {
            this.hFg.a(true, this.hEV, this.hEW, this.hEX, this.hEY, this.hEZ, this.bNt, this.hFa, this.hFb, this.hFc);
          }
          AppMethodBeat.o(150489);
          return;
          locala = locala;
          ac.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ac.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(210347);
    a(parama, true);
    AppMethodBeat.o(210347);
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150492);
    if ((!this.hEP) && (this.listeners.size() > 0)) {}
    try
    {
      this.hER = System.currentTimeMillis();
      this.hFd = false;
      this.hFe = false;
      this.hEQ.aEP();
      this.hEQ.a(this.hFf, 1, Looper.getMainLooper());
      this.hEP = true;
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
      ac.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
      if ((this.listeners.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.hER = System.currentTimeMillis();
          this.hFd = false;
          this.hFe = false;
          this.hEQ.a(this.hFf, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.hET) && (System.currentTimeMillis() - this.hES < 60000L)) {
            this.hFf.a(true, this.hEV, this.hEW, this.hEX, this.hEY, this.hEZ, this.bNt, this.hFa, this.hFb, this.hFc);
          }
          AppMethodBeat.o(150492);
          return;
          locala = locala;
          ac.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ac.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void c(final b.a parama)
  {
    AppMethodBeat.i(150493);
    new ao().post(new Runnable()
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
        ac.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[] { Integer.valueOf(d.this.listeners.size()) });
        if ((d.this.listeners.size() == 0) && (d.this.hEQ != null)) {
          d.this.hEQ.aEP();
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