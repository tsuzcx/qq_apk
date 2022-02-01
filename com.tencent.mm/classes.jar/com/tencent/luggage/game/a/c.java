package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.g.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniProgram;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "onAppBrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onConfig", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class c
  extends d
{
  public c(Context paramContext, i parami)
  {
    super(paramContext, parami);
    AppMethodBeat.i(130736);
    AppMethodBeat.o(130736);
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(130734);
    p.k(paramf, "builder");
    super.a(paramf);
    paramf.cF(true);
    paramf.cE(false);
    paramf.b(a.b.cPo);
    paramf.cMN.a(g.cMt[15], Boolean.FALSE);
    paramf.cC(false);
    paramf.cD(false);
    AppMethodBeat.o(130734);
  }
  
  protected final void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130735);
    p.k(paramAppBrandRuntime, "runtime");
    com.tencent.luggage.game.b.c.csM.a((MBRuntime)getMagicBrush(), paramAppBrandRuntime, false);
    AppMethodBeat.o(130735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.a.c
 * JD-Core Version:    0.7.0.1
 */