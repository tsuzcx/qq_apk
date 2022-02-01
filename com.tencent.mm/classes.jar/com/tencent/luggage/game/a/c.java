package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.luggage.game.b.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniProgram;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "onAppBrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onConfig", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class c
  extends d
{
  public c(Context paramContext, i parami)
  {
    super(paramContext, parami);
    AppMethodBeat.i(130736);
    AppMethodBeat.o(130736);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130734);
    k.h(parame, "builder");
    super.a(parame);
    parame.bQ(true);
    parame.cmK.a(f.$$delegatedProperties[13], Boolean.FALSE);
    parame.b(a.b.coV);
    parame.cmM.a(f.$$delegatedProperties[15], Boolean.FALSE);
    parame.bO(false);
    parame.bP(false);
    AppMethodBeat.o(130734);
  }
  
  protected final void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130735);
    k.h(paramAppBrandRuntime, "runtime");
    b.bYj.a((MBRuntime)getMagicBrush(), paramAppBrandRuntime, false);
    AppMethodBeat.o(130735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.c
 * JD-Core Version:    0.7.0.1
 */