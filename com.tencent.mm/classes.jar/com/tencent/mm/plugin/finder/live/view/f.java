package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "hideFloatBall", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-finder_release"})
public final class f
  extends e
{
  private static String yVx;
  public static final a yVy;
  
  static
  {
    AppMethodBeat.i(290014);
    yVy = new a((byte)0);
    AppMethodBeat.o(290014);
  }
  
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(290013);
    AppMethodBeat.o(290013);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(290009);
    super.I(paramInt, paramString);
    cvL().kqZ = 15;
    cvK();
    AppMethodBeat.o(290009);
  }
  
  public final void aOf()
  {
    AppMethodBeat.i(290008);
    ((b)h.ae(b.class)).ld(true);
    super.aOf();
    AppMethodBeat.o(290008);
  }
  
  public final boolean aOg()
  {
    return false;
  }
  
  public final boolean aOh()
  {
    return false;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(290010);
    super.aOi();
    this.rZC.hS(false);
    AppMethodBeat.o(290010);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(290011);
    ((b)h.ae(b.class)).ld(false);
    this.rYE.rYs.opType = 4;
    super.aOj();
    AppMethodBeat.o(290011);
  }
  
  public final void pv(boolean paramBoolean)
  {
    AppMethodBeat.i(290012);
    ((b)h.ae(b.class)).ld(paramBoolean);
    this.rYE.rYs.opType = 4;
    super.aOj();
    AppMethodBeat.o(290012);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper$Companion;", "", "()V", "TAG", "", "activateUIKey", "getActivateUIKey", "()Ljava/lang/String;", "setActivateUIKey", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.f
 * JD-Core Version:    0.7.0.1
 */