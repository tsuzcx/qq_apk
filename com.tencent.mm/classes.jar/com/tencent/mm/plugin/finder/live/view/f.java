package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "hideFloatBall", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends e
{
  public static final f.a DOI;
  private static String DOJ;
  
  static
  {
    AppMethodBeat.i(358035);
    DOI = new f.a((byte)0);
    AppMethodBeat.o(358035);
  }
  
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(358016);
    AppMethodBeat.o(358016);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(358060);
    super.J(paramInt, paramString);
    cYv().mUU = 15;
    cYr();
    AppMethodBeat.o(358060);
  }
  
  public final void bhT()
  {
    AppMethodBeat.i(358043);
    ((b)h.ax(b.class)).mq(true);
    super.bhT();
    AppMethodBeat.o(358043);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(358066);
    super.bhV();
    this.vkT.iR(false);
    AppMethodBeat.o(358066);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(358075);
    ((b)h.ax(b.class)).mq(false);
    this.vjV.vjI.opType = 4;
    super.bhW();
    AppMethodBeat.o(358075);
  }
  
  public final void rZ(boolean paramBoolean)
  {
    AppMethodBeat.i(358082);
    ((b)h.ax(b.class)).mq(paramBoolean);
    this.vjV.vjI.opType = 4;
    super.bhW();
    AppMethodBeat.o(358082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.f
 * JD-Core Version:    0.7.0.1
 */