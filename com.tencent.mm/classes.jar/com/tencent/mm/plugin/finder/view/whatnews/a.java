package com.tencent.mm.plugin.finder.view.whatnews;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewController;", "", "()V", "ID_KEY", "", "TAG", "", "isAvailableBoot", "", "()Z", "isAvailableBootLazy", "isAvailableBootLazy$delegate", "Lkotlin/Lazy;", "isAvailableEnter", "style", "", "getStyle", "()I", "clearShowFlag", "", "hasShown", "plugin-finder_release"})
public final class a
{
  private static final f wtF;
  public static final a wtG;
  
  static
  {
    AppMethodBeat.i(168552);
    wtG = new a();
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().getBoolean(ar.a.Olu, false);
    wtF = kotlin.g.ah((kotlin.g.a.a)a.wtH);
    AppMethodBeat.o(168552);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final a wtH;
    
    static
    {
      AppMethodBeat.i(168551);
      wtH = new a();
      AppMethodBeat.o(168551);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.a
 * JD-Core Version:    0.7.0.1
 */