package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static float qQK = 0.0F;
  private static float qQL = 0.0F;
  private static volatile long qQM = 0L;
  private boolean qQN = false;
  public a qQO;
  
  public static boolean cjv()
  {
    AppMethodBeat.i(44671);
    if ((qQL == -85.0F) || (qQK == -1000.0F))
    {
      AppMethodBeat.o(44671);
      return false;
    }
    if (Util.nowMilliSecond() - qQM < 300000L) {}
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
    return qQL;
  }
  
  public static float getLongitude()
  {
    return qQK;
  }
  
  public final void cjw()
  {
    AppMethodBeat.i(44672);
    if (this.qQN)
    {
      AppMethodBeat.o(44672);
      return;
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
    this.qQN = true;
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
        this.qQQ.value = true;
        c.a(c.this);
        Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
        if (c.b(c.this) != null) {
          c.b(c.this).onCallbackLocation(c.beI(), c.cjx());
        }
        AppMethodBeat.o(44669);
        return false;
      }
    }, false).startTimer(TimeUnit.SECONDS.toMillis(20L));
    localObject = (b.a)com.tencent.mm.plugin.appbrand.utils.l.em(new b.a()
    {
      private int qQS = 0;
      
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(319363);
        com.tencent.mm.plugin.appbrand.utils.l.cM(this);
        d.bJl().a(this);
        paramAnonymousInt = this.qQS + 1;
        this.qQS = paramAnonymousInt;
        if ((paramAnonymousInt > 1) || (this.qQQ.value))
        {
          AppMethodBeat.o(319363);
          return false;
        }
        localPBool.value = true;
        c.a(c.this);
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
          if (c.b(c.this) != null) {
            c.b(c.this).onCallbackLocation(paramAnonymousFloat1, paramAnonymousFloat2);
          }
          AppMethodBeat.o(319363);
          return false;
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
        c.bC(paramAnonymousFloat2);
        c.bD(paramAnonymousFloat1);
        c.jB(Util.nowMilliSecond());
        if (c.b(c.this) != null) {
          c.b(c.this).onCallbackLocation(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(319363);
        return true;
      }
    });
    d.bJl().a((b.a)localObject, false);
    com.tencent.mm.plugin.report.service.l.kK(22, 10);
    AppMethodBeat.o(44672);
  }
  
  public static abstract interface a
  {
    public abstract void onCallbackLocation(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */