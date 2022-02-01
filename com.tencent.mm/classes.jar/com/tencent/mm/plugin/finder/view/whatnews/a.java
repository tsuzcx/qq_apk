package com.tencent.mm.plugin.finder.view.whatnews;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.f;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewController;", "", "()V", "ID_KEY", "", "TAG", "", "isAvailableBoot", "", "()Z", "isAvailableBootLazy", "isAvailableBootLazy$delegate", "Lkotlin/Lazy;", "isAvailableEnter", "style", "", "getStyle", "()I", "clearShowFlag", "", "hasShown", "plugin-finder_release"})
public final class a
{
  public static final f qZw;
  public static final a qZx;
  
  static
  {
    AppMethodBeat.i(168552);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "isAvailableBootLazy", "isAvailableBootLazy()Z")) };
    qZx = new a();
    e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.afk().getBoolean(ae.a.FwR, false);
    qZw = d.g.E((d.g.a.a)a.qZy);
    AppMethodBeat.o(168552);
  }
  
  public static void ctk()
  {
    AppMethodBeat.i(168553);
    e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.FwR, Boolean.FALSE);
    AppMethodBeat.o(168553);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public static final a qZy;
    
    static
    {
      AppMethodBeat.i(168551);
      qZy = new a();
      AppMethodBeat.o(168551);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.a
 * JD-Core Version:    0.7.0.1
 */