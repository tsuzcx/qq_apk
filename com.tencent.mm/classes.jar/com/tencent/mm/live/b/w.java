package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-logic_release"})
public final class w
  extends com.tencent.mm.plugin.ball.service.f
{
  public static final a hIp;
  
  static
  {
    AppMethodBeat.i(207702);
    hIp = new a((byte)0);
    AppMethodBeat.o(207702);
  }
  
  public w(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(207701);
    AppMethodBeat.o(207701);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(207698);
    super.G(paramInt, paramString);
    ciw().hDa = 16;
    civ();
    AppMethodBeat.o(207698);
  }
  
  public final void aGf()
  {
    AppMethodBeat.i(207697);
    ((b)g.af(b.class)).jS(true);
    super.aGf();
    AppMethodBeat.o(207697);
  }
  
  public final boolean aGg()
  {
    return false;
  }
  
  public final boolean aGh()
  {
    return false;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(207699);
    super.aGi();
    this.oXA.hb(false);
    AppMethodBeat.o(207699);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(207700);
    ((b)g.af(b.class)).jS(false);
    this.oWE.oWs.opType = 4;
    super.aGj();
    AppMethodBeat.o(207700);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.w
 * JD-Core Version:    0.7.0.1
 */