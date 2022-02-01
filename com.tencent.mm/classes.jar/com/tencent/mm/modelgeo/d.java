package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  public static d hTg;
  double bXG;
  private aq gKO;
  private boolean iaA;
  private boolean iaB;
  private f iaC;
  private g iaD;
  public boolean iam;
  h ian;
  long iao;
  public long iap;
  boolean iaq;
  public boolean iar;
  double ias;
  double iat;
  int iau;
  double iav;
  double iaw;
  String iax;
  String iay;
  int iaz;
  List<WeakReference<b.a>> listeners;
  private Context mContext;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(150488);
    this.iam = false;
    this.listeners = new ArrayList();
    this.iao = 0L;
    this.iap = 0L;
    this.iaq = false;
    this.iar = false;
    this.ias = 23.0D;
    this.iat = 100.0D;
    this.iau = 0;
    this.iav = 0.0D;
    this.iaw = 0.0D;
    this.bXG = 0.0D;
    this.iaA = false;
    this.iaB = false;
    this.gKO = new aq(Looper.getMainLooper());
    this.iaC = new f()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150482);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, true);
        if (paramAnonymousBoolean)
        {
          d.this.ias = paramAnonymousDouble1;
          d.this.iat = paramAnonymousDouble2;
          d.this.iau = paramAnonymousInt1;
          d.this.iav = paramAnonymousDouble3;
          d.this.iaw = paramAnonymousDouble4;
          d.this.bXG = paramAnonymousDouble5;
          d.this.iax = paramAnonymousString1;
          d.this.iay = paramAnonymousString2;
          d.this.iaz = paramAnonymousInt2;
          d.this.iap = System.currentTimeMillis();
          d.this.iaq = true;
          d.this.iar = false;
          d.a(d.this, 67592);
        }
        ae.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150481);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.iay);
            localBundle.putString("indoor_building_id", d.this.iax);
            localBundle.putInt("indoor_building_type", d.this.iaz);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.iaK, localBundle);
            AppMethodBeat.o(150481);
          }
        });
        AppMethodBeat.o(150482);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(150483);
        ae.i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(150483);
      }
    };
    this.iaD = new g()
    {
      public final void a(final boolean paramAnonymousBoolean, final double paramAnonymousDouble1, double paramAnonymousDouble2, final int paramAnonymousInt1, double paramAnonymousDouble3, final double paramAnonymousDouble4, final double paramAnonymousDouble5, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(150485);
        d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousDouble2, paramAnonymousDouble4, false);
        if (paramAnonymousBoolean)
        {
          d.this.ias = paramAnonymousDouble1;
          d.this.iat = paramAnonymousDouble2;
          d.this.iau = paramAnonymousInt1;
          d.this.iav = paramAnonymousDouble3;
          d.this.iaw = paramAnonymousDouble4;
          d.this.bXG = paramAnonymousDouble5;
          d.this.iax = paramAnonymousString1;
          d.this.iay = paramAnonymousString2;
          d.this.iaz = paramAnonymousInt2;
          d.this.iar = true;
          d.this.iaq = false;
          d.this.iap = System.currentTimeMillis();
          d.a(d.this, 67591);
        }
        ae.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", new Object[] { Double.valueOf(paramAnonymousDouble2), Double.valueOf(paramAnonymousDouble1), Integer.valueOf(paramAnonymousInt1), Double.valueOf(paramAnonymousDouble3) });
        new aq(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150484);
            Bundle localBundle = new Bundle();
            localBundle.putString("indoor_building_floor", d.this.iay);
            localBundle.putString("indoor_building_id", d.this.iax);
            localBundle.putInt("indoor_building_type", d.this.iaz);
            d.a(d.this, paramAnonymousBoolean, paramAnonymousDouble1, paramAnonymousInt1, paramAnonymousDouble4, paramAnonymousDouble5, this.iaK, localBundle);
            AppMethodBeat.o(150484);
          }
        }, 200L);
        AppMethodBeat.o(150485);
      }
    };
    this.mContext = paramContext;
    this.ian = h.cE(paramContext);
    AppMethodBeat.o(150488);
  }
  
  public static d aIh()
  {
    AppMethodBeat.i(150487);
    if (hTg == null) {
      hTg = new d(ak.getContext());
    }
    d locald = hTg;
    AppMethodBeat.o(150487);
    return locald;
  }
  
  public static boolean aIi()
  {
    AppMethodBeat.i(150494);
    try
    {
      boolean bool = ((LocationManager)ak.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(150494);
      return bool;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(150494);
    }
    return false;
  }
  
  public static boolean aIj()
  {
    AppMethodBeat.i(150496);
    try
    {
      boolean bool = ((LocationManager)ak.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(150496);
      return bool;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(150496);
    }
    return false;
  }
  
  public static void cD(Context paramContext)
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
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    ae.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[] { parama, Boolean.valueOf(paramBoolean), Integer.valueOf(0) });
    if ((this.iam) && (this.listeners.size() > 0)) {}
    try
    {
      this.iao = System.currentTimeMillis();
      this.iaA = false;
      this.iaB = false;
      this.ian.aIl();
      this.ian.a(this.iaD, 0, Looper.getMainLooper());
      this.iam = false;
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
      ae.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
      if ((this.listeners.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.iao = System.currentTimeMillis();
          this.iaA = false;
          this.iaB = false;
          this.ian.a(this.iaD, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.iar) && (System.currentTimeMillis() - this.iap < 60000L)) {
            this.iaD.a(true, this.ias, this.iat, this.iau, this.iav, this.iaw, this.bXG, this.iax, this.iay, this.iaz);
          }
          AppMethodBeat.o(150489);
          return;
          locala = locala;
          ae.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ae.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(224405);
    a(parama, true);
    AppMethodBeat.o(224405);
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150492);
    if ((!this.iam) && (this.listeners.size() > 0)) {}
    try
    {
      this.iao = System.currentTimeMillis();
      this.iaA = false;
      this.iaB = false;
      this.ian.aIl();
      this.ian.a(this.iaC, 1, Looper.getMainLooper());
      this.iam = true;
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
      ae.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.listeners.size()) });
      if ((this.listeners.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.iao = System.currentTimeMillis();
          this.iaA = false;
          this.iaB = false;
          this.ian.a(this.iaC, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.iaq) && (System.currentTimeMillis() - this.iap < 60000L)) {
            this.iaC.a(true, this.ias, this.iat, this.iau, this.iav, this.iaw, this.bXG, this.iax, this.iay, this.iaz);
          }
          AppMethodBeat.o(150492);
          return;
          locala = locala;
          ae.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ae.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void c(b.a parama)
  {
    AppMethodBeat.i(150493);
    new aq().post(new d.3(this, parama));
    AppMethodBeat.o(150493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d
 * JD-Core Version:    0.7.0.1
 */