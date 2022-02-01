package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.m.a;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "Lcom/tencent/magicbrush/utils/SyncTask;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener$OnDestroyListener;", "fn", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "luggage-wxa-game-ext_release"})
public final class d$a
  extends com.tencent.magicbrush.utils.e
  implements m.a
{
  public d$a(a<x> parama)
  {
    super((Runnable)new e(parama));
    AppMethodBeat.i(130738);
    AppMethodBeat.o(130738);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(130737);
    run();
    AppMethodBeat.o(130737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.a.d.a
 * JD-Core Version:    0.7.0.1
 */