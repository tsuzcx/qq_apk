package com.tencent.mm.plugin.finder.view.whatnews;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewController;", "", "()V", "ID_KEY", "", "TAG", "", "isAvailableBoot", "", "()Z", "isAvailableBootLazy", "isAvailableBootLazy$delegate", "Lkotlin/Lazy;", "isAvailableEnter", "style", "", "getStyle", "()I", "clearShowFlag", "", "hasShown", "plugin-finder_release"})
public final class a
{
  public static final f sYP;
  public static final a sYQ;
  
  static
  {
    AppMethodBeat.i(168552);
    sYQ = new a();
    e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().getBoolean(al.a.IHP, false);
    sYP = d.g.O((d.g.a.a)a.sYR);
    AppMethodBeat.o(168552);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final a sYR;
    
    static
    {
      AppMethodBeat.i(168551);
      sYR = new a();
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