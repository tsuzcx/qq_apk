package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-logic_release"})
public final class t
  extends e
{
  public static final a kvJ;
  
  static
  {
    AppMethodBeat.i(201638);
    kvJ = new a((byte)0);
    AppMethodBeat.o(201638);
  }
  
  public t(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(201637);
    AppMethodBeat.o(201637);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(201630);
    super.I(paramInt, paramString);
    cvL().kqZ = 16;
    cvK();
    AppMethodBeat.o(201630);
  }
  
  public final void aOf()
  {
    AppMethodBeat.i(201625);
    ((b)h.ae(b.class)).ld(true);
    super.aOf();
    AppMethodBeat.o(201625);
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
    AppMethodBeat.i(201633);
    super.aOi();
    this.rZC.hS(false);
    AppMethodBeat.o(201633);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(201635);
    ((b)h.ae(b.class)).ld(false);
    this.rYE.rYs.opType = 4;
    super.aOj();
    AppMethodBeat.o(201635);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.t
 * JD-Core Version:    0.7.0.1
 */