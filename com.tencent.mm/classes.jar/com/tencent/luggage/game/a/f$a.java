package com.tencent.luggage.game.a;

import com.tencent.magicbrush.utils.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import d.g.a.a;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "Lcom/tencent/magicbrush/utils/SyncTask;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener$OnDestroyListener;", "fn", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "luggage-wxa-game-ext_release"})
public final class f$a
  extends e
  implements m.a
{
  public f$a(a<z> parama)
  {
    super((Runnable)new g(parama));
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
 * Qualified Name:     com.tencent.luggage.game.a.f.a
 * JD-Core Version:    0.7.0.1
 */