package com.tencent.mm.live.core.mini;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/FloatBallHelper;", "()V", "timeWhenRemoveView", "", "addVoipView", "", "state", "", "view", "Landroid/view/View;", "reportDataInfo", "Lcom/tencent/mm/live/core/mini/ReportDataInfo;", "size", "Landroid/graphics/Point;", "clickFloatBall", "init", "initReportInfo", "removeVoipView", "Landroid/widget/FrameLayout;", "setLiveViewSize", "updateReportInfo", "Companion", "Holder", "plugin-core_release"})
public final class a
  extends FloatBallHelper
{
  public static final a kqF;
  public long kqE;
  
  static
  {
    AppMethodBeat.i(198730);
    kqF = new a((byte)0);
    AppMethodBeat.o(198730);
  }
  
  private a()
  {
    AppMethodBeat.i(198728);
    I(21, b.cwx());
    cvL().kqZ = 15;
    cvK();
    AppMethodBeat.o(198728);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(198715);
    this.rYE.rYs.kqZ = parame.kqZ;
    this.rYE.rYs.fIZ = String.valueOf(parame.liveId);
    BallReportInfo localBallReportInfo = this.rYE.rYs;
    if (parame.fFE) {}
    for (String str = "1";; str = "2")
    {
      localBallReportInfo.rYy = str;
      this.rYE.rYs.kqY = parame.kqY;
      this.rYE.rYs.opType = parame.opType;
      Log.v("MicroMsg.LiveFloatBallHelper", "addVoipView updateReportInfo bizScene: %d, bizId: %s, bizSubId: %s, generateType: %s", new Object[] { Integer.valueOf(this.rYE.rYs.kqZ), this.rYE.rYs.fIZ, this.rYE.rYs.rYy, Integer.valueOf(this.rYE.rYs.kqY) });
      AppMethodBeat.o(198715);
      return;
    }
  }
  
  public final void aMo()
  {
    AppMethodBeat.i(198727);
    if (this.rYE.rYm == null) {
      this.rYE.rYm = new Point();
    }
    int i = aw.aZ(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.Edge_A);
    this.rYE.rYm.x = (aw.aZ(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_width) + i * 2);
    this.rYE.rYm.y = (aw.aZ(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_height) + i * 2);
    Log.v("MicroMsg.LiveFloatBallHelper", "setLiveViewSize %s, margin: %d", new Object[] { this.rYE.rYm, Integer.valueOf(i) });
    AppMethodBeat.o(198727);
  }
  
  public final void b(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(198720);
    if (cvD())
    {
      Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.kqE = Util.nowMilliSecond();
      cvE();
      AppMethodBeat.o(198720);
      return;
    }
    Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(198720);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper$Companion;", "", "()V", "INTERVAL_REMOVE_THEN_ADD", "", "TAG", "", "instance", "Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "getInstance", "()Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "plugin-core_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper$Holder;", "", "()V", "sHelper", "Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "getSHelper", "()Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "setSHelper", "(Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;)V", "plugin-core_release"})
  public static final class b
  {
    private static a kqG;
    public static final b kqH;
    
    static
    {
      AppMethodBeat.i(199326);
      kqH = new b();
      kqG = new a((byte)0);
      AppMethodBeat.o(199326);
    }
    
    public static a aMp()
    {
      return kqG;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, View paramView, boolean paramBoolean, e parame, Point paramPoint) {}
    
    public final void run()
    {
      AppMethodBeat.i(198231);
      Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", new Object[] { Integer.valueOf(this.jOR), this.kqJ });
      a.a(this.kqI).rYr = true;
      a.a(this.kqI).qmt = false;
      a.a(this.kqI).state = this.jOR;
      a.a(this.kqI).bFK = this.kqJ;
      a.a(this.kqI).rYq = true;
      a.a(this.kqI).iUF = this.kqK;
      a.a(this.kqI, this.kqL);
      a.b(this.kqI);
      this.kqI.cvF();
      AppMethodBeat.o(198231);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.a
 * JD-Core Version:    0.7.0.1
 */