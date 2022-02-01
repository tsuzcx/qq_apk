package com.tencent.mm.plugin.finder.view.whatnews;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewController;", "", "()V", "ID_KEY", "", "TAG", "", "isAvailableBoot", "", "()Z", "isAvailableBootLazy", "isAvailableBootLazy$delegate", "Lkotlin/Lazy;", "isAvailableEnter", "style", "", "getStyle", "()I", "clearShowFlag", "", "hasShown", "plugin-finder_release"})
public final class a
{
  public static final f tkd;
  public static final a tke;
  
  static
  {
    AppMethodBeat.i(168552);
    tke = new a();
    e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().getBoolean(am.a.Jcs, false);
    tkd = d.g.O((d.g.a.a)a.tkf);
    AppMethodBeat.o(168552);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final a tkf;
    
    static
    {
      AppMethodBeat.i(168551);
      tkf = new a();
      AppMethodBeat.o(168551);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.a
 * JD-Core Version:    0.7.0.1
 */