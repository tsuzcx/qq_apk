package com.tencent.mm.live.core.mini;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.a.b;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/FloatBallHelper;", "()V", "timeWhenRemoveView", "", "addVoipView", "", "state", "", "view", "Landroid/view/View;", "reportDataInfo", "Lcom/tencent/mm/live/core/mini/ReportDataInfo;", "size", "Landroid/graphics/Point;", "adjustFloatBallSize", "newSize", "clickFloatBall", "init", "initReportInfo", "removeVoipView", "Landroid/widget/FrameLayout;", "setLiveViewSize", "updateReportInfo", "Companion", "Holder", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends FloatBallHelper
{
  public static final a.a mUD;
  private long mUE;
  
  static
  {
    AppMethodBeat.i(247648);
    mUD = new a.a((byte)0);
    AppMethodBeat.o(247648);
  }
  
  private a()
  {
    AppMethodBeat.i(247613);
    J(21, "LiveFloatBall");
    cYv().mUU = 15;
    cYr();
    AppMethodBeat.o(247613);
  }
  
  private static final void a(int paramInt, View paramView, a parama, boolean paramBoolean, e parame, Point paramPoint)
  {
    AppMethodBeat.i(247634);
    s.u(parama, "this$0");
    s.u(parame, "$reportDataInfo");
    s.u(paramPoint, "$size");
    Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
    parama.vjV.vjH = true;
    parama.vjV.trn = false;
    parama.vjV.state = paramInt;
    parama.vjV.dyK = paramView;
    parama.vjV.vjG = true;
    parama.vjV.lwK = paramBoolean;
    parama.a(parame);
    parama.c(paramPoint);
    parama.cYq();
    AppMethodBeat.o(247634);
  }
  
  private final void a(e parame)
  {
    AppMethodBeat.i(247621);
    this.vjV.vjI.mUU = parame.mUU;
    this.vjV.vjI.hOH = String.valueOf(parame.liveId);
    BallReportInfo localBallReportInfo = this.vjV.vjI;
    if (parame.hKC) {}
    for (String str = "1";; str = "2")
    {
      localBallReportInfo.vjO = str;
      this.vjV.vjI.mUT = parame.mUT;
      this.vjV.vjI.opType = parame.opType;
      Log.v("MicroMsg.LiveFloatBallHelper", "addVoipView updateReportInfo bizScene: %d, bizId: %s, bizSubId: %s, generateType: %s", new Object[] { Integer.valueOf(this.vjV.vjI.mUU), this.vjV.vjI.hOH, this.vjV.vjI.vjO, Integer.valueOf(this.vjV.vjI.mUT) });
      AppMethodBeat.o(247621);
      return;
    }
  }
  
  private final void c(Point paramPoint)
  {
    AppMethodBeat.i(247628);
    this.vjV.vjC = new Point();
    int i = bd.bs(MMApplicationContext.getContext(), a.b.Edge_A);
    this.vjV.vjC.x = (paramPoint.x + i * 2);
    this.vjV.vjC.y = (paramPoint.y + i * 2);
    Log.v("MicroMsg.LiveFloatBallHelper", "setLiveViewSize %s, margin: %d", new Object[] { this.vjV.vjC, Integer.valueOf(i) });
    AppMethodBeat.o(247628);
  }
  
  public final void a(View paramView, e parame, Point paramPoint)
  {
    AppMethodBeat.i(247670);
    s.u(parame, "reportDataInfo");
    s.u(paramPoint, "size");
    if (paramView != null)
    {
      int i = bd.bs(MMApplicationContext.getContext(), a.b.Edge_A);
      paramView.setPadding(i, i, i, i);
      boolean bool = parame.lwK;
      if (cYo())
      {
        if (this.vjV.dyK != paramView)
        {
          Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(4), paramView, this.vjV.dyK });
          this.vjV.vjH = true;
          this.vjV.state = 4;
          this.vjV.dyK = paramView;
          this.vjV.trn = false;
          this.vjV.vjG = true;
          this.vjV.lwK = bool;
          a(parame);
          c(paramPoint);
          cYq();
          AppMethodBeat.o(247670);
          return;
        }
        Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", new Object[] { Integer.valueOf(4), paramView });
        AppMethodBeat.o(247670);
        return;
      }
      paramView = new a..ExternalSyntheticLambda0(4, paramView, this, bool, parame, paramPoint);
      long l = 200L + this.mUE - Util.nowMilliSecond();
      if (l <= 0L)
      {
        paramView.run();
        AppMethodBeat.o(247670);
        return;
      }
      Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
      MMHandlerThread.postToMainThreadDelayed(paramView, l);
    }
    AppMethodBeat.o(247670);
  }
  
  public final void b(Point paramPoint)
  {
    int j = 1;
    AppMethodBeat.i(247698);
    s.u(paramPoint, "newSize");
    Point localPoint = this.vjV.vjC;
    if ((localPoint != null) && (localPoint.x == paramPoint.x))
    {
      i = 1;
      if (i == 0) {
        break label104;
      }
      localPoint = this.vjV.vjC;
      if ((localPoint == null) || (localPoint.y != paramPoint.y)) {
        break label99;
      }
    }
    label99:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label104;
      }
      Log.i("MicroMsg.LiveFloatBallHelper", "adjustFloatBallSize same donothing");
      AppMethodBeat.o(247698);
      return;
      i = 0;
      break;
    }
    label104:
    c(paramPoint);
    cYr();
    Log.i("MicroMsg.LiveFloatBallHelper", "adjustFloatBallSize width:" + paramPoint.x + ", height:" + paramPoint.y);
    AppMethodBeat.o(247698);
  }
  
  public final void b(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(247681);
    if (cYo())
    {
      Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.mUE = Util.nowMilliSecond();
      cYp();
      AppMethodBeat.o(247681);
      return;
    }
    Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(247681);
  }
  
  public final void bfO()
  {
    AppMethodBeat.i(247691);
    Log.d("MicroMsg.LiveFloatBallHelper", "clickFloatBall");
    this.vjV.vjI.opType = 3;
    ((b)h.ax(b.class)).m(this.vjV);
    AppMethodBeat.o(247691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.a
 * JD-Core Version:    0.7.0.1
 */