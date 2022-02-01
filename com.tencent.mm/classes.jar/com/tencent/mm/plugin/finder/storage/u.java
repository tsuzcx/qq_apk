package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.sdk.platformtools.bt;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", "other", "plugin-finder_release"})
public final class u
{
  private final f rWv;
  public final apk szb;
  
  public u(apk paramapk)
  {
    AppMethodBeat.i(203723);
    this.szb = paramapk;
    this.rWv = g.O((a)new a(this));
    AppMethodBeat.o(203723);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(203721);
    p.h(paramu, "other");
    if ((this.szb.GnS == paramu.szb.GnS) && (!bt.isNullOrNil(getWording())) && (p.i(getWording(), paramu.getWording())))
    {
      AppMethodBeat.o(203721);
      return true;
    }
    AppMethodBeat.o(203721);
    return false;
  }
  
  public final long getId()
  {
    AppMethodBeat.i(203720);
    long l = ((Number)this.rWv.getValue()).longValue();
    AppMethodBeat.o(203720);
    return l;
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(203722);
    String str = this.szb.dxD;
    p.g(str, "localPb.wording");
    AppMethodBeat.o(203722);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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