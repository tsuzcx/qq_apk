package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ame;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", "other", "Companion", "plugin-finder_release"})
public final class o
{
  private static final int rEp = 1;
  public static final a rEq;
  public final f rDJ;
  public final ame rEo;
  
  static
  {
    AppMethodBeat.i(202988);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(o.class), "id", "getId()J")) };
    rEq = new a((byte)0);
    rEp = 1;
    AppMethodBeat.o(202988);
  }
  
  public o(ame paramame)
  {
    AppMethodBeat.i(202990);
    this.rEo = paramame;
    this.rDJ = g.K((a)new b(this));
    AppMethodBeat.o(202990);
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(202989);
    String str = this.rEo.dlQ;
    d.g.b.k.g(str, "localPb.wording");
    AppMethodBeat.o(202989);
    return str;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem$Companion;", "", "()V", "VIEW_ITEM_WORDING", "", "getVIEW_ITEM_WORDING", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Long>
  {
    b(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.o
 * JD-Core Version:    0.7.0.1
 */