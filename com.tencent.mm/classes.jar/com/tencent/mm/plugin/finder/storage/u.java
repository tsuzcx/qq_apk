package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.sdk.platformtools.bu;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", "other", "plugin-finder_release"})
public final class u
{
  public final apx sJS;
  private final f sfg;
  
  public u(apx paramapx)
  {
    AppMethodBeat.i(204290);
    this.sJS = paramapx;
    this.sfg = g.O((a)new a(this));
    AppMethodBeat.o(204290);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(204289);
    p.h(paramu, "other");
    if ((this.sJS.GGY == paramu.sJS.GGY) && (!bu.isNullOrNil(getWording())) && (p.i(getWording(), paramu.getWording())))
    {
      AppMethodBeat.o(204289);
      return true;
    }
    AppMethodBeat.o(204289);
    return false;
  }
  
  public final long getId()
  {
    AppMethodBeat.i(204288);
    long l = ((Number)this.sfg.getValue()).longValue();
    AppMethodBeat.o(204288);
    return l;
  }
  
  public final String getWording()
  {
    String str2 = this.sJS.dyI;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.u
 * JD-Core Version:    0.7.0.1
 */