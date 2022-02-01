package com.tencent.mm.plugin.finder.replay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/model/FinderLiveReplayPageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "hideFloatBall", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  private static String DOJ;
  public static final a FlR;
  
  static
  {
    AppMethodBeat.i(332764);
    FlR = new a((byte)0);
    AppMethodBeat.o(332764);
  }
  
  public b(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(332744);
    AppMethodBeat.o(332744);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(332776);
    super.J(paramInt, paramString);
    cYv().mUU = 21;
    cYr();
    AppMethodBeat.o(332776);
  }
  
  public final void bhT()
  {
    AppMethodBeat.i(332768);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(true);
    super.bhT();
    AppMethodBeat.o(332768);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(332789);
    super.bhV();
    this.vkT.iR(false);
    AppMethodBeat.o(332789);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(332799);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(false);
    this.vjV.vjI.opType = 4;
    super.bhW();
    AppMethodBeat.o(332799);
  }
  
  public final void rZ(boolean paramBoolean)
  {
    AppMethodBeat.i(332806);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(paramBoolean);
    this.vjV.vjI.opType = 4;
    super.bhW();
    AppMethodBeat.o(332806);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/model/FinderLiveReplayPageFloatBallHelper$Companion;", "", "()V", "TAG", "", "activateUIKey", "getActivateUIKey", "()Ljava/lang/String;", "setActivateUIKey", "(Ljava/lang/String;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.model.b
 * JD-Core Version:    0.7.0.1
 */