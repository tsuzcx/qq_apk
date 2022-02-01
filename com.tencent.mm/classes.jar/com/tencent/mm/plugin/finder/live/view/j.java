package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "hideFloatBall", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.plugin.ball.service.f
{
  private static String uzR;
  public static final a uzS;
  
  static
  {
    AppMethodBeat.i(247557);
    uzS = new a((byte)0);
    AppMethodBeat.o(247557);
  }
  
  public j(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(247556);
    AppMethodBeat.o(247556);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(247552);
    super.G(paramInt, paramString);
    ciw().hDa = 15;
    civ();
    AppMethodBeat.o(247552);
  }
  
  public final void aGf()
  {
    AppMethodBeat.i(247551);
    ((b)g.af(b.class)).jS(true);
    super.aGf();
    AppMethodBeat.o(247551);
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
    AppMethodBeat.i(247553);
    super.aGi();
    this.oXA.hb(false);
    AppMethodBeat.o(247553);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(247554);
    ((b)g.af(b.class)).jS(false);
    this.oWE.oWs.opType = 4;
    super.aGj();
    AppMethodBeat.o(247554);
  }
  
  public final void nA(boolean paramBoolean)
  {
    AppMethodBeat.i(247555);
    ((b)g.af(b.class)).jS(paramBoolean);
    this.oWE.oWs.opType = 4;
    super.aGj();
    AppMethodBeat.o(247555);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper$Companion;", "", "()V", "TAG", "", "activateUIKey", "getActivateUIKey", "()Ljava/lang/String;", "setActivateUIKey", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.j
 * JD-Core Version:    0.7.0.1
 */