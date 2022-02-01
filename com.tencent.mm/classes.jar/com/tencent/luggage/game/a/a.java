package com.tencent.luggage.game.a;

import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/boot/BufferURLLogic;", "", "()V", "bind", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "jsruntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "luggage-wxa-game-ext_release"})
public final class a
{
  public static final a cii;
  
  static
  {
    AppMethodBeat.i(220739);
    cii = new a();
    AppMethodBeat.o(220739);
  }
  
  public static final void a(d paramd, i parami)
  {
    AppMethodBeat.i(220738);
    p.h(paramd, "magicbrush");
    p.h(parami, "jsruntime");
    parami = parami.P(k.class);
    if (parami == null) {
      p.gkB();
    }
    ((k)parami).a((y)new b(paramd.cxo));
    AppMethodBeat.o(220738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.a
 * JD-Core Version:    0.7.0.1
 */