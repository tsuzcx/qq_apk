package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static float jwB = 0.0F;
  private static float jwC = 0.0F;
  private static volatile long jwD = 0L;
  private boolean jwE = false;
  private a jwF;
  
  public static boolean aZi()
  {
    AppMethodBeat.i(44671);
    if ((jwC == -85.0F) || (jwB == -1000.0F))
    {
      AppMethodBeat.o(44671);
      return false;
    }
    if (bs.eWj() - jwD < 300000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(44671);
      return false;
    }
    AppMethodBeat.o(44671);
    return true;
  }
  
  public static float aZj()
  {
    return jwB;
  }
  
  public static float aZk()
  {
    return jwC;
  }
  
  public final void a(a parama)
  {
    this.jwF = parama;
  }
  
  public final boolean aZh()
  {
    return this.jwF != null;
  }
  
  public final void aZl()
  {
    AppMethodBeat.i(44672);
    if (this.jwE)
    {
      AppMethodBeat.o(44672);
      return;
    }
    ac.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.jwE = true;
    Object localObject = new PBool();
    final PBool localPBool = new PBool();
    ((PBool)localObject).value = false;
    localPBool.value = false;
    au localau = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(44669);
        if (localPBool.value)
        {
          AppMethodBeat.o(44669);
          return false;
        }
        this.jwH.value = true;
        c.a(c.this);
        ac.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
        if (c.b(c.this) != null) {
          c.b(c.this).E(c.aZm(), c.aZn());
        }
        AppMethodBeat.o(44669);
        return false;
      }
    }, false);
    long l = TimeUnit.SECONDS.toMillis(20L);
    localau.au(l, l);
    localObject = (b.a)e.cF(new b.a()
    {
      private int jwJ = 0;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(44670);
        e.bh(this);
        d.aEL().c(this);
        paramAnonymousInt = this.jwJ + 1;
        this.jwJ = paramAnonymousInt;
        if ((paramAnonymousInt > 1) || (this.jwH.value))
        {
          AppMethodBeat.o(44670);
          return false;
        }
        localPBool.value = true;
        c.a(c.this);
        if (!paramAnonymousBoolean)
        {
          ac.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
          if (c.b(c.this) != null) {
            c.b(c.this).E(paramAnonymousFloat1, paramAnonymousFloat2);
          }
          AppMethodBeat.o(44670);
          return false;
        }
        ac.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
        c.ar(paramAnonymousFloat2);
        c.as(paramAnonymousFloat1);
        c.qI(bs.eWj());
        if (c.b(c.this) != null) {
          c.b(c.this).E(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(44670);
        return true;
      }
    });
    d.aEL().b((b.a)localObject, false);
    AppMethodBeat.o(44672);
  }
  
  public static abstract interface a
  {
    public abstract void E(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */