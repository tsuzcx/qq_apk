package com.tencent.mm.live.core.mini;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/FloatBallHelper;", "()V", "timeWhenRemoveView", "", "addVoipView", "", "state", "", "view", "Landroid/view/View;", "reportDataInfo", "Lcom/tencent/mm/live/core/mini/ReportDataInfo;", "size", "Landroid/graphics/Point;", "clickFloatBall", "init", "initReportInfo", "removeVoipView", "Landroid/widget/FrameLayout;", "setLiveViewSize", "updateReportInfo", "Companion", "Holder", "plugin-core_release"})
public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  public static final a hCD;
  public long hCC;
  
  static
  {
    AppMethodBeat.i(196577);
    hCD = new a((byte)0);
    AppMethodBeat.o(196577);
  }
  
  private a()
  {
    AppMethodBeat.i(196576);
    G(21, b.cjf());
    ciw().hDa = 15;
    civ();
    AppMethodBeat.o(196576);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(196573);
    this.oWE.oWs.hDa = paramf.hDa;
    this.oWE.oWs.dPJ = String.valueOf(paramf.liveId);
    BallReportInfo localBallReportInfo = this.oWE.oWs;
    if (paramf.dMz) {}
    for (String str = "1";; str = "2")
    {
      localBallReportInfo.oWy = str;
      this.oWE.oWs.hCZ = paramf.hCZ;
      this.oWE.oWs.opType = paramf.opType;
      Log.v("MicroMsg.LiveFloatBallHelper", "addVoipView updateReportInfo bizScene: %d, bizId: %s, bizSubId: %s, generateType: %s", new Object[] { Integer.valueOf(this.oWE.oWs.hDa), this.oWE.oWs.dPJ, this.oWE.oWs.oWy, Integer.valueOf(this.oWE.oWs.hCZ) });
      AppMethodBeat.o(196573);
      return;
    }
  }
  
  public final void aEh()
  {
    AppMethodBeat.i(196575);
    if (this.oWE.oWm == null) {
      this.oWE.oWm = new Point();
    }
    int i = at.aH(MMApplicationContext.getContext(), 2131165314);
    this.oWE.oWm.x = (at.aH(MMApplicationContext.getContext(), 2131166448) + i * 2);
    this.oWE.oWm.y = (at.aH(MMApplicationContext.getContext(), 2131166446) + i * 2);
    Log.v("MicroMsg.LiveFloatBallHelper", "setLiveViewSize %s, margin: %d", new Object[] { this.oWE.oWm, Integer.valueOf(i) });
    AppMethodBeat.o(196575);
  }
  
  public final void b(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(196574);
    if (ciq())
    {
      Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.hCC = Util.nowMilliSecond();
      cir();
      AppMethodBeat.o(196574);
      return;
    }
    Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(196574);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper$Companion;", "", "()V", "INTERVAL_REMOVE_THEN_ADD", "", "TAG", "", "instance", "Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "getInstance", "()Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "plugin-core_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper$Holder;", "", "()V", "sHelper", "Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "getSHelper", "()Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "setSHelper", "(Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;)V", "plugin-core_release"})
  public static final class b
  {
    private static a hCE;
    public static final b hCF;
    
    static
    {
      AppMethodBeat.i(196571);
      hCF = new b();
      hCE = new a((byte)0);
      AppMethodBeat.o(196571);
    }
    
    public static a aEi()
    {
      return hCE;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, View paramView, boolean paramBoolean, f paramf, Point paramPoint) {}
    
    public final void run()
    {
      AppMethodBeat.i(196572);
      Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", new Object[] { Integer.valueOf(this.hCH), this.hCI });
      a.a(this.hCG).oWr = true;
      a.a(this.hCG).nno = false;
      a.a(this.hCG).state = this.hCH;
      a.a(this.hCG).vk = this.hCI;
      a.a(this.hCG).oWq = true;
      a.a(this.hCG).gqx = this.hCJ;
      a.a(this.hCG, this.hCK);
      a.b(this.hCG);
      this.hCG.cis();
      AppMethodBeat.o(196572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.a
 * JD-Core Version:    0.7.0.1
 */