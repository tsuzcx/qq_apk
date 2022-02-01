package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", "other", "plugin-finder_release"})
public final class x
{
  public final ben Amb;
  private final f xzz;
  
  public x(ben paramben)
  {
    AppMethodBeat.i(273715);
    this.Amb = paramben;
    this.xzz = g.ar((a)new a(this));
    AppMethodBeat.o(273715);
  }
  
  public final boolean a(x paramx)
  {
    AppMethodBeat.i(273714);
    p.k(paramx, "other");
    if ((this.Amb.SPE == paramx.Amb.SPE) && (!Util.isNullOrNil(getWording())) && (p.h(getWording(), paramx.getWording())))
    {
      AppMethodBeat.o(273714);
      return true;
    }
    AppMethodBeat.o(273714);
    return false;
  }
  
  public final long getId()
  {
    AppMethodBeat.i(273713);
    long l = ((Number)this.xzz.getValue()).longValue();
    AppMethodBeat.o(273713);
    return l;
  }
  
  public final String getWording()
  {
    String str2 = this.Amb.wording;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.x
 * JD-Core Version:    0.7.0.1
 */