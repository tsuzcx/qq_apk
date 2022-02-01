package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.luggage.game.b.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniProgram;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "onAppBrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onConfig", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class e
  extends f
{
  public e(Context paramContext, i parami)
  {
    super(paramContext, parami);
    AppMethodBeat.i(130736);
    AppMethodBeat.o(130736);
  }
  
  protected void a(com.tencent.magicbrush.e parame)
  {
    AppMethodBeat.i(130734);
    p.h(parame, "builder");
    super.a(parame);
    parame.bQ(true);
    parame.HA();
    parame.b(a.b.cAt);
    parame.HB();
    parame.bO(false);
    parame.bP(false);
    AppMethodBeat.o(130734);
  }
  
  protected final void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130735);
    p.h(paramAppBrandRuntime, "runtime");
    b.ciD.a((MBRuntime)getMagicBrush(), paramAppBrandRuntime, false);
    AppMethodBeat.o(130735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.e
 * JD-Core Version:    0.7.0.1
 */