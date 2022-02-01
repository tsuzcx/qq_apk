package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", "other", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  private final j AXa;
  public final bpn FLT;
  
  public z(bpn parambpn)
  {
    AppMethodBeat.i(339374);
    this.FLT = parambpn;
    this.AXa = k.cm((a)new a(this));
    AppMethodBeat.o(339374);
  }
  
  public final boolean a(z paramz)
  {
    AppMethodBeat.i(339382);
    s.u(paramz, "other");
    if ((this.FLT.ZXW == paramz.FLT.ZXW) && (!Util.isNullOrNil(getWording())) && (s.p(getWording(), paramz.getWording())))
    {
      AppMethodBeat.o(339382);
      return true;
    }
    AppMethodBeat.o(339382);
    return false;
  }
  
  public final long getId()
  {
    AppMethodBeat.i(339376);
    long l = ((Number)this.AXa.getValue()).longValue();
    AppMethodBeat.o(339376);
    return l;
  }
  
  public final String getWording()
  {
    String str2 = this.FLT.wording;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Long>
  {
    a(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.z
 * JD-Core Version:    0.7.0.1
 */