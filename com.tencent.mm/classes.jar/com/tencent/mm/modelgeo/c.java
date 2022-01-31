package com.tencent.mm.modelgeo;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  implements a
{
  public static c egs;
  List<WeakReference<a.a>> aLS = new ArrayList();
  double aWH = 0.0D;
  private ah dPi = new ah(Looper.getMainLooper());
  double elA = 23.0D;
  double elB = 100.0D;
  int elC = 0;
  double elD = 0.0D;
  double elE = 0.0D;
  String elF;
  String elG;
  int elH;
  private boolean elI = false;
  private boolean elJ = false;
  private e elK = new c.1(this);
  private f elL = new c.2(this);
  public boolean elu = false;
  g elv;
  long elw = 0L;
  long elx = 0L;
  boolean ely = false;
  boolean elz = false;
  private Context mContext;
  
  private c(Context paramContext)
  {
    this.mContext = paramContext;
    this.elv = g.by(paramContext);
  }
  
  public static c Ob()
  {
    if (egs == null) {
      egs = new c(ae.getContext());
    }
    return egs;
  }
  
  public static boolean Oc()
  {
    try
    {
      boolean bool = ((LocationManager)ae.getContext().getSystemService("location")).isProviderEnabled("gps");
      return bool;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bk.j(localException) });
    }
    return false;
  }
  
  public static boolean Od()
  {
    try
    {
      boolean bool = ((LocationManager)ae.getContext().getSystemService("location")).isProviderEnabled("network");
      return bool;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bk.j(localException) });
    }
    return false;
  }
  
  public final boolean Oe()
  {
    return (this.elx > 0L) && (this.elz) && (System.currentTimeMillis() - this.elx < 600000L);
  }
  
  public final void a(a.a parama)
  {
    b(parama, true);
  }
  
  public final void a(a.a parama, boolean paramBoolean)
  {
    y.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[] { parama, Boolean.valueOf(paramBoolean), Integer.valueOf(0) });
    if ((this.elu) && (this.aLS.size() > 0)) {}
    try
    {
      this.elw = System.currentTimeMillis();
      this.elI = false;
      this.elJ = false;
      g.Og();
      g.a(this.elL, 0, Looper.getMainLooper());
      this.elu = false;
      Iterator localIterator = this.aLS.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((a.a)localWeakReference.get()).equals(parama)));
      i = 0;
      if (i != 0) {
        this.aLS.add(new WeakReference(parama));
      }
      y.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.aLS.size()) });
      if ((this.aLS.size() != 1) || (i == 0)) {}
    }
    catch (g.a locala)
    {
      for (;;)
      {
        try
        {
          this.elw = System.currentTimeMillis();
          this.elI = false;
          this.elJ = false;
          g.a(this.elL, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.elz) && (System.currentTimeMillis() - this.elx < 60000L)) {
            this.elL.a(true, this.elA, this.elB, this.elC, this.elD, this.elE, this.aWH, this.elF, this.elG, this.elH);
          }
          return;
          locala = locala;
          y.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (g.a parama)
        {
          y.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void b(a.a parama)
  {
    a(parama, true);
  }
  
  public final void b(a.a parama, boolean paramBoolean)
  {
    if ((!this.elu) && (this.aLS.size() > 0)) {}
    try
    {
      this.elw = System.currentTimeMillis();
      this.elI = false;
      this.elJ = false;
      g.Og();
      g.a(this.elK, 1, Looper.getMainLooper());
      this.elu = true;
      Iterator localIterator = this.aLS.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((a.a)localWeakReference.get()).equals(parama)));
      i = 0;
      if (i != 0) {
        this.aLS.add(new WeakReference(parama));
      }
      y.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.aLS.size()) });
      if ((this.aLS.size() != 1) || (i == 0)) {}
    }
    catch (g.a locala)
    {
      for (;;)
      {
        try
        {
          this.elw = System.currentTimeMillis();
          this.elI = false;
          this.elJ = false;
          g.a(this.elK, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.ely) && (System.currentTimeMillis() - this.elx < 60000L)) {
            this.elK.a(true, this.elA, this.elB, this.elC, this.elD, this.elE, this.aWH, this.elF, this.elG, this.elH);
          }
          return;
          locala = locala;
          y.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (g.a parama)
        {
          y.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void c(a.a parama)
  {
    new ah().post(new c.3(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c
 * JD-Core Version:    0.7.0.1
 */