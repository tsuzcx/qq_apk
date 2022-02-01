package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static float iWl = 0.0F;
  private static float iWm = 0.0F;
  private static volatile long iWn = 0L;
  private boolean iWo = false;
  private a iWp;
  
  public static boolean aSl()
  {
    AppMethodBeat.i(44671);
    if ((iWm == -85.0F) || (iWl == -1000.0F))
    {
      AppMethodBeat.o(44671);
      return false;
    }
    if (bt.eGO() - iWn < 300000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(44671);
      return false;
    }
    AppMethodBeat.o(44671);
    return true;
  }
  
  public static float aSm()
  {
    return iWl;
  }
  
  public static float aSn()
  {
    return iWm;
  }
  
  public final void a(a parama)
  {
    this.iWp = parama;
  }
  
  public final boolean aSk()
  {
    return this.iWp != null;
  }
  
  public final void aSo()
  {
    AppMethodBeat.i(44672);
    if (this.iWo)
    {
      AppMethodBeat.o(44672);
      return;
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.iWo = true;
    Object localObject = new PBool();
    final PBool localPBool = new PBool();
    ((PBool)localObject).value = false;
    localPBool.value = false;
    av localav = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(44669);
        if (localPBool.value)
        {
          AppMethodBeat.o(44669);
          return false;
        }
        this.iWr.value = true;
        c.a(c.this);
        ad.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
        if (c.b(c.this) != null) {
          c.b(c.this).B(c.aSp(), c.aSq());
        }
        AppMethodBeat.o(44669);
        return false;
      }
    }, false);
    long l = TimeUnit.SECONDS.toMillis(20L);
    localav.av(l, l);
    localObject = (b.a)e.cG(new b.a()
    {
      private int iWt = 0;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(44670);
        e.bk(this);
        d.axT().c(this);
        paramAnonymousInt = this.iWt + 1;
        this.iWt = paramAnonymousInt;
        if ((paramAnonymousInt > 1) || (this.iWr.value))
        {
          AppMethodBeat.o(44670);
          return false;
        }
        localPBool.value = true;
        c.a(c.this);
        if (!paramAnonymousBoolean)
        {
          ad.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
          if (c.b(c.this) != null) {
            c.b(c.this).B(paramAnonymousFloat1, paramAnonymousFloat2);
          }
          AppMethodBeat.o(44670);
          return false;
        }
        ad.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
        c.an(paramAnonymousFloat2);
        c.ao(paramAnonymousFloat1);
        c.mU(bt.eGO());
        if (c.b(c.this) != null) {
          c.b(c.this).B(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(44670);
        return true;
      }
    });
    d.axT().b((b.a)localObject, false);
    AppMethodBeat.o(44672);
  }
  
  public static abstract interface a
  {
    public abstract void B(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */