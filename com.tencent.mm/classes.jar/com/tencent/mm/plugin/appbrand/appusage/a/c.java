package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static float nQX = 0.0F;
  private static float nQY = 0.0F;
  private static volatile long nQZ = 0L;
  private boolean nRa = false;
  private a nRb;
  
  public static boolean bJT()
  {
    AppMethodBeat.i(44671);
    if ((nQY == -85.0F) || (nQX == -1000.0F))
    {
      AppMethodBeat.o(44671);
      return false;
    }
    if (Util.nowMilliSecond() - nQZ < 300000L) {}
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
    return nQY;
  }
  
  public static float getLongitude()
  {
    return nQX;
  }
  
  public final void a(a parama)
  {
    this.nRb = parama;
  }
  
  public final boolean bJS()
  {
    return this.nRb != null;
  }
  
  public final void bJU()
  {
    AppMethodBeat.i(44672);
    if (this.nRa)
    {
      AppMethodBeat.o(44672);
      return;
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.nRa = true;
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
        this.nRd.value = true;
        c.a(c.this);
        Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
        if (c.b(c.this) != null) {
          c.b(c.this).K(c.bJV(), c.bJW());
        }
        AppMethodBeat.o(44669);
        return false;
      }
    }, false).startTimer(TimeUnit.SECONDS.toMillis(20L));
    localObject = (b.a)h.cQ(new b.a()
    {
      private int nRf = 0;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(44670);
        h.bs(this);
        d.blq().b(this);
        paramAnonymousInt = this.nRf + 1;
        this.nRf = paramAnonymousInt;
        if ((paramAnonymousInt > 1) || (this.nRd.value))
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
            c.b(c.this).K(paramAnonymousFloat1, paramAnonymousFloat2);
          }
          AppMethodBeat.o(44670);
          return false;
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
        c.aE(paramAnonymousFloat2);
        c.aF(paramAnonymousFloat1);
        c.Hl(Util.nowMilliSecond());
        if (c.b(c.this) != null) {
          c.b(c.this).K(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(44670);
        return true;
      }
    });
    d.blq().b((b.a)localObject, false);
    AppMethodBeat.o(44672);
  }
  
  public static abstract interface a
  {
    public abstract void K(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */