package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzk;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", "other", "Companion", "plugin-finder_release"})
public final class s
{
  private static final int KXk = 1;
  public static final a KXl;
  public final f KWJ;
  public final dzk KXj;
  
  static
  {
    AppMethodBeat.i(199024);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(s.class), "id", "getId()J")) };
    KXl = new a((byte)0);
    KXk = 1;
    AppMethodBeat.o(199024);
  }
  
  public s(dzk paramdzk)
  {
    AppMethodBeat.i(199026);
    this.KXj = paramdzk;
    this.KWJ = g.E((a)new b(this));
    AppMethodBeat.o(199026);
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(199025);
    String str = this.KXj.doh;
    d.g.b.k.g(str, "localPb.wording");
    AppMethodBeat.o(199025);
    return str;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem$Companion;", "", "()V", "VIEW_ITEM_WORDING", "", "getVIEW_ITEM_WORDING", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Long>
  {
    b(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.s
 * JD-Core Version:    0.7.0.1
 */