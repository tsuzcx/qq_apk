package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends e
{
  public static final t.a mZk;
  
  static
  {
    AppMethodBeat.i(246524);
    mZk = new t.a((byte)0);
    AppMethodBeat.o(246524);
  }
  
  public t(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(246516);
    AppMethodBeat.o(246516);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(246543);
    super.J(paramInt, paramString);
    cYv().mUU = 16;
    cYr();
    AppMethodBeat.o(246543);
  }
  
  public final void bhT()
  {
    AppMethodBeat.i(246531);
    ((b)h.ax(b.class)).mq(true);
    super.bhT();
    AppMethodBeat.o(246531);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(246548);
    super.bhV();
    this.vkT.iR(false);
    AppMethodBeat.o(246548);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(246551);
    ((b)h.ax(b.class)).mq(false);
    this.vjV.vjI.opType = 4;
    super.bhW();
    AppMethodBeat.o(246551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.model.t
 * JD-Core Version:    0.7.0.1
 */