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
  private static float jQx = 0.0F;
  private static float jQy = 0.0F;
  private static volatile long jQz = 0L;
  private boolean jQA = false;
  private a jQB;
  
  public static boolean bcG()
  {
    AppMethodBeat.i(44671);
    if ((jQy == -85.0F) || (jQx == -1000.0F))
    {
      AppMethodBeat.o(44671);
      return false;
    }
    if (bt.flT() - jQz < 300000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(44671);
      return false;
    }
    AppMethodBeat.o(44671);
    return true;
  }
  
  public static float bcH()
  {
    return jQx;
  }
  
  public static float bcI()
  {
    return jQy;
  }
  
  public final void a(a parama)
  {
    this.jQB = parama;
  }
  
  public final boolean bcF()
  {
    return this.jQB != null;
  }
  
  public final void bcJ()
  {
    AppMethodBeat.i(44672);
    if (this.jQA)
    {
      AppMethodBeat.o(44672);
      return;
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.jQA = true;
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
        this.jQD.value = true;
        c.a(c.this);
        ad.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
        if (c.b(c.this) != null) {
          c.b(c.this).F(c.bcK(), c.bcL());
        }
        AppMethodBeat.o(44669);
        return false;
      }
    }, false);
    long l = TimeUnit.SECONDS.toMillis(20L);
    localav.az(l, l);
    localObject = (b.a)e.cH(new b.a()
    {
      private int jQF = 0;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(44670);
        e.bj(this);
        d.aHQ().c(this);
        paramAnonymousInt = this.jQF + 1;
        this.jQF = paramAnonymousInt;
        if ((paramAnonymousInt > 1) || (this.jQD.value))
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
            c.b(c.this).F(paramAnonymousFloat1, paramAnonymousFloat2);
          }
          AppMethodBeat.o(44670);
          return false;
        }
        ad.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
        c.au(paramAnonymousFloat2);
        c.av(paramAnonymousFloat1);
        c.sG(bt.flT());
        if (c.b(c.this) != null) {
          c.b(c.this).F(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(44670);
        return true;
      }
    });
    d.aHQ().b((b.a)localObject, false);
    AppMethodBeat.o(44672);
  }
  
  public static abstract interface a
  {
    public abstract void F(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */