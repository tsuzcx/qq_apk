package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static float jTP = 0.0F;
  private static float jTQ = 0.0F;
  private static volatile long jTR = 0L;
  private boolean jTS = false;
  private a jTT;
  
  public static boolean bdl()
  {
    AppMethodBeat.i(44671);
    if ((jTQ == -85.0F) || (jTP == -1000.0F))
    {
      AppMethodBeat.o(44671);
      return false;
    }
    if (bu.fpO() - jTR < 300000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(44671);
      return false;
    }
    AppMethodBeat.o(44671);
    return true;
  }
  
  public static float bdm()
  {
    return jTP;
  }
  
  public static float bdn()
  {
    return jTQ;
  }
  
  public final void a(a parama)
  {
    this.jTT = parama;
  }
  
  public final boolean bdk()
  {
    return this.jTT != null;
  }
  
  public final void bdo()
  {
    AppMethodBeat.i(44672);
    if (this.jTS)
    {
      AppMethodBeat.o(44672);
      return;
    }
    ae.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.jTS = true;
    Object localObject = new PBool();
    final PBool localPBool = new PBool();
    ((PBool)localObject).value = false;
    localPBool.value = false;
    aw localaw = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(44669);
        if (localPBool.value)
        {
          AppMethodBeat.o(44669);
          return false;
        }
        this.jTV.value = true;
        c.a(c.this);
        ae.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
        if (c.b(c.this) != null) {
          c.b(c.this).F(c.bdp(), c.bdq());
        }
        AppMethodBeat.o(44669);
        return false;
      }
    }, false);
    long l = TimeUnit.SECONDS.toMillis(20L);
    localaw.ay(l, l);
    localObject = (b.a)f.cI(new b.a()
    {
      private int jTX = 0;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(44670);
        f.bj(this);
        d.aIh().c(this);
        paramAnonymousInt = this.jTX + 1;
        this.jTX = paramAnonymousInt;
        if ((paramAnonymousInt > 1) || (this.jTV.value))
        {
          AppMethodBeat.o(44670);
          return false;
        }
        localPBool.value = true;
        c.a(c.this);
        if (!paramAnonymousBoolean)
        {
          ae.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
          if (c.b(c.this) != null) {
            c.b(c.this).F(paramAnonymousFloat1, paramAnonymousFloat2);
          }
          AppMethodBeat.o(44670);
          return false;
        }
        ae.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
        c.au(paramAnonymousFloat2);
        c.av(paramAnonymousFloat1);
        c.sT(bu.fpO());
        if (c.b(c.this) != null) {
          c.b(c.this).F(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(44670);
        return true;
      }
    });
    d.aIh().b((b.a)localObject, false);
    AppMethodBeat.o(44672);
  }
  
  public static abstract interface a
  {
    public abstract void F(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */