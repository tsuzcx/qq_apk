package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import d.g.a.a;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "Lcom/tencent/magicbrush/utils/SyncTask;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener$OnDestroyListener;", "fn", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "luggage-wxa-game-ext_release"})
public final class d$a
  extends com.tencent.magicbrush.utils.e
  implements m.a
{
  public d$a(a<y> parama)
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