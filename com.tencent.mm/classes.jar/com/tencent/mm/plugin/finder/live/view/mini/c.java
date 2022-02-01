package com.tencent.mm.plugin.finder.live.view.mini;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowReporter;", "", "()V", "TAG", "", "lastEnterState", "", "getLastEnterState", "()I", "setLastEnterState", "(I)V", "lastEnterTime", "", "getLastEnterTime", "()J", "setLastEnterTime", "(J)V", "lastLiveType", "getLastLiveType", "setLastLiveType", "lastWindowSize", "Landroid/graphics/Point;", "getLastWindowSize", "()Landroid/graphics/Point;", "setLastWindowSize", "(Landroid/graphics/Point;)V", "originEnterTime", "getOriginEnterTime", "setOriginEnterTime", "enter", "", "liveType", "size", "enterBackground", "shouldReportEnter", "", "enterForgound", "shouldReportExit", "exit", "clickCloseBtn", "getPlayDesktopSwitch", "getWindowType", "reportEnter", "reportExit", "resetState", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  long AcP;
  int DVI;
  private int DVJ = 1;
  private Point DVK;
  long DVL;
  final String TAG = "Finder.FinderLiveMiniWindowReporter";
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(358287);
    s.u(paramc, "this$0");
    if (paramc.DVI == 1)
    {
      Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaZ, Boolean.TRUE);
      if (localObject == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(358287);
        throw paramc;
      }
      boolean bool = ((Boolean)localObject).booleanValue();
      Log.i(paramc.TAG, s.X("getPlayDesktopSwitch ", Boolean.valueOf(bool)));
      if (!bool)
      {
        Log.i(paramc.TAG, "skip report enter because user setting");
        AppMethodBeat.o(358287);
        return;
      }
    }
    paramc.ewf();
    AppMethodBeat.o(358287);
  }
  
  private static int j(Point paramPoint)
  {
    if (paramPoint.x == paramPoint.y) {
      return 3;
    }
    if (paramPoint.x > paramPoint.y) {
      return 2;
    }
    return 1;
  }
  
  public final void b(int paramInt, Point paramPoint)
  {
    AppMethodBeat.i(358303);
    s.u(paramPoint, "size");
    a locala = a.DJT;
    if (a.bUx())
    {
      AppMethodBeat.o(358303);
      return;
    }
    this.AcP = 0L;
    this.DVI = 0;
    this.DVJ = 1;
    this.DVK = null;
    this.DVL = cn.bDw();
    this.AcP = this.DVL;
    this.DVI = 0;
    this.DVJ = paramInt;
    this.DVK = paramPoint;
    com.tencent.threadpool.h.ahAA.p(new c..ExternalSyntheticLambda0(this), 1000L);
    Log.i(this.TAG, "enter liveType:" + paramInt + ", size:" + paramPoint);
    AppMethodBeat.o(358303);
  }
  
  final void ewf()
  {
    AppMethodBeat.i(358324);
    boolean bool;
    Point localPoint;
    if (this.DVI == 0)
    {
      bool = true;
      localPoint = this.DVK;
      if (localPoint != null) {
        break label50;
      }
    }
    label50:
    for (int i = 1;; i = j(localPoint))
    {
      k.Doi.a(bool, 1, 0L, i, this.DVJ);
      AppMethodBeat.o(358324);
      return;
      bool = false;
      break;
    }
  }
  
  public final void sc(boolean paramBoolean)
  {
    AppMethodBeat.i(358308);
    a locala = a.DJT;
    if (a.bUx())
    {
      AppMethodBeat.o(358308);
      return;
    }
    sd(paramBoolean);
    this.AcP = 0L;
    this.DVL = 0L;
    Log.i(this.TAG, s.X("exit clickCloseBtn:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(358308);
  }
  
  final void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(358317);
    if (this.AcP > 0L)
    {
      boolean bool;
      long l;
      Point localPoint;
      if (this.DVI == 0)
      {
        bool = true;
        l = cn.bDw() - this.AcP;
        localPoint = this.DVK;
        if (localPoint != null) {
          break label91;
        }
      }
      label91:
      for (int i = 1;; i = j(localPoint))
      {
        k.Doi.a(bool, 2, l, i, this.DVJ);
        if (!paramBoolean) {
          break label119;
        }
        k.Doi.a(bool, 3, l, i, this.DVJ);
        AppMethodBeat.o(358317);
        return;
        bool = false;
        break;
      }
    }
    Log.i(this.TAG, s.X("reportExit but lastEnterTime <= 0, lastEnterTime:", Long.valueOf(this.AcP)));
    label119:
    AppMethodBeat.o(358317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.mini.c
 * JD-Core Version:    0.7.0.1
 */