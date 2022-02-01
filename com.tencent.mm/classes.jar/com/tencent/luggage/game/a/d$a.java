package com.tencent.luggage.game.a;

import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.m.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "Lcom/tencent/magicbrush/utils/SyncTask;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener$OnDestroyListener;", "fn", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
  extends f
  implements m.a
{
  public d$a(a<ah> parama)
  {
    super(new d.a..ExternalSyntheticLambda0(parama));
    AppMethodBeat.i(130738);
    AppMethodBeat.o(130738);
  }
  
  private static final void o(a parama)
  {
    AppMethodBeat.i(220114);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(220114);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(130737);
    run();
    AppMethodBeat.o(130737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.d.a
 * JD-Core Version:    0.7.0.1
 */