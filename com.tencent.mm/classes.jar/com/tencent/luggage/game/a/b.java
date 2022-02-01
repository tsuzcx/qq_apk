package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class b
  extends d
{
  private final boolean csj;
  private final boolean csk;
  private final int csl;
  private final boolean csm;
  
  public b(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    AppMethodBeat.i(247538);
    this.csj = paramBoolean1;
    this.csk = paramBoolean2;
    this.csl = paramInt;
    this.csm = paramBoolean3;
    AppMethodBeat.o(247538);
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(130732);
    p.k(paramf, "builder");
    super.a(paramf);
    paramf.cF(false);
    paramf.cC(this.csj);
    boolean bool = this.csk;
    paramf.cMH.a(g.cMt[9], Boolean.valueOf(bool));
    int i = this.csl;
    paramf.cMQ.a(g.cMt[16], Integer.valueOf(i));
    paramf.cMS.a(g.cMt[18], Boolean.TRUE);
    bool = this.csm;
    paramf.cMR.a(g.cMt[17], Boolean.valueOf(bool));
    AppMethodBeat.o(130732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */