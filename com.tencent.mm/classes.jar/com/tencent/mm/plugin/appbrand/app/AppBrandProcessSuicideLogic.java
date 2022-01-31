package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.sdk.g.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends a
{
  private static final AppBrandProcessSuicideLogic gSB;
  private final AtomicInteger gSC;
  private final AtomicBoolean gSD;
  
  static
  {
    AppMethodBeat.i(129207);
    gSB = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(129207);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(129203);
    this.gSC = new AtomicInteger(0);
    this.gSD = new AtomicBoolean();
    AppMethodBeat.o(129203);
  }
  
  public static void aux()
  {
    AppMethodBeat.i(138692);
    gSB.gSD.set(true);
    AppMethodBeat.o(138692);
  }
  
  public static void f(Application paramApplication)
  {
    AppMethodBeat.i(129202);
    paramApplication.registerActivityLifecycleCallbacks(gSB);
    AppMethodBeat.o(129202);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(129204);
    this.gSD.set(false);
    this.gSC.incrementAndGet();
    AppMethodBeat.o(129204);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(129205);
    if (this.gSC.decrementAndGet() == 0) {
      d.post(new AppBrandProcessSuicideLogic.1(this, paramActivity.getClass()), "CleanupWhenNoActivitiesAliveInAppBrandProcess");
    }
    AppMethodBeat.o(129205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */