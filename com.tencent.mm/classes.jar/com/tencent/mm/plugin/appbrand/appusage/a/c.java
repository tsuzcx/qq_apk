package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static float kWL = 0.0F;
  private static float kWM = 0.0F;
  private static volatile long kWN = 0L;
  private boolean kWO = false;
  private a kWP;
  
  public static boolean byF()
  {
    AppMethodBeat.i(44671);
    if ((kWM == -85.0F) || (kWL == -1000.0F))
    {
      AppMethodBeat.o(44671);
      return false;
    }
    if (Util.nowMilliSecond() - kWN < 300000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(44671);
      return false;
    }
    AppMethodBeat.o(44671);
    return true;
  }
  
  public static float getLatitude()
  {
    return kWM;
  }
  
  public static float getLongitude()
  {
    return kWL;
  }
  
  public final void a(a parama)
  {
    this.kWP = parama;
  }
  
  public final boolean byE()
  {
    return this.kWP != null;
  }
  
  public final void byG()
  {
    AppMethodBeat.i(44672);
    if (this.kWO)
    {
      AppMethodBeat.o(44672);
      return;
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.kWO = true;
    Object localObject = new PBool();
    final PBool localPBool = new PBool();
    ((PBool)localObject).value = false;
    localPBool.value = false;
    new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(44669);
        if (localPBool.value)
        {
          AppMethodBeat.o(44669);
          return false;
        }
        this.kWR.value = true;
        c.a(c.this);
        Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
        if (c.b(c.this) != null) {
          c.b(c.this).J(c.byH(), c.byI());
        }
        AppMethodBeat.o(44669);
        return false;
      }
    }, false).startTimer(TimeUnit.SECONDS.toMillis(20L));
    localObject = (b.a)f.cP(new b.a()
    {
      private int kWT = 0;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(44670);
        f.bs(this);
        d.bca().c(this);
        paramAnonymousInt = this.kWT + 1;
        this.kWT = paramAnonymousInt;
        if ((paramAnonymousInt > 1) || (this.kWR.value))
        {
          AppMethodBeat.o(44670);
          return false;
        }
        localPBool.value = true;
        c.a(c.this);
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
          if (c.b(c.this) != null) {
            c.b(c.this).J(paramAnonymousFloat1, paramAnonymousFloat2);
          }
          AppMethodBeat.o(44670);
          return false;
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
        c.aE(paramAnonymousFloat2);
        c.aF(paramAnonymousFloat1);
        c.AZ(Util.nowMilliSecond());
        if (c.b(c.this) != null) {
          c.b(c.this).J(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(44670);
        return true;
      }
    });
    d.bca().b((b.a)localObject, false);
    AppMethodBeat.o(44672);
  }
  
  public static abstract interface a
  {
    public abstract void J(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */