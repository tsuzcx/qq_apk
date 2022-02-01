package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", "other", "plugin-finder_release"})
public final class aa
{
  private final f tON;
  public final ays vEN;
  
  public aa(ays paramays)
  {
    AppMethodBeat.i(251817);
    this.vEN = paramays;
    this.tON = g.ah((a)new a(this));
    AppMethodBeat.o(251817);
  }
  
  public final boolean a(aa paramaa)
  {
    AppMethodBeat.i(251816);
    p.h(paramaa, "other");
    if ((this.vEN.LIS == paramaa.vEN.LIS) && (!Util.isNullOrNil(getWording())) && (p.j(getWording(), paramaa.getWording())))
    {
      AppMethodBeat.o(251816);
      return true;
    }
    AppMethodBeat.o(251816);
    return false;
  }
  
  public final long getId()
  {
    AppMethodBeat.i(251815);
    long l = ((Number)this.tON.getValue()).longValue();
    AppMethodBeat.o(251815);
    return l;
  }
  
  public final String getWording()
  {
    String str2 = this.vEN.dQx;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.aa
 * JD-Core Version:    0.7.0.1
 */