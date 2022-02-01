package com.tencent.mm.plugin.finder.view.whatnews;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.f;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewController;", "", "()V", "ID_KEY", "", "TAG", "", "isAvailableBoot", "", "()Z", "isAvailableBootLazy", "isAvailableBootLazy$delegate", "Lkotlin/Lazy;", "isAvailableEnter", "style", "", "getStyle", "()I", "clearShowFlag", "", "hasShown", "plugin-finder_release"})
public final class a
{
  public static final a sbA;
  public static final f sbz;
  
  static
  {
    AppMethodBeat.i(168552);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "isAvailableBootLazy", "isAvailableBootLazy()Z")) };
    sbA = new a();
    e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.agA().getBoolean(ah.a.GVh, false);
    sbz = d.g.K((d.g.a.a)a.sbB);
    AppMethodBeat.o(168552);
  }
  
  public static void cFE()
  {
    AppMethodBeat.i(168553);
    e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GVh, Boolean.FALSE);
    AppMethodBeat.o(168553);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public static final a sbB;
    
    static
    {
      AppMethodBeat.i(168551);
      sbB = new a();
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