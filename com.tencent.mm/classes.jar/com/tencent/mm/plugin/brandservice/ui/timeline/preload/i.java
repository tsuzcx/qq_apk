package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aod;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "", "domain", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "manifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;)V", "getDomain", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "getManifest", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-brandservice_release"})
public final class i
{
  final aoc ndT;
  final aod ndU;
  
  public i(aoc paramaoc, aod paramaod)
  {
    AppMethodBeat.i(193084);
    this.ndT = paramaoc;
    this.ndU = paramaod;
    AppMethodBeat.o(193084);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193087);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!k.g(this.ndT, paramObject.ndT)) || (!k.g(this.ndU, paramObject.ndU))) {}
      }
    }
    else
    {
      AppMethodBeat.o(193087);
      return true;
    }
    AppMethodBeat.o(193087);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(193086);
    Object localObject = this.ndT;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.ndU;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(193086);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193085);
    String str = "PrefetchManifest(domain=" + this.ndT + ", manifest=" + this.ndU + ")";
    AppMethodBeat.o(193085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.i
 * JD-Core Version:    0.7.0.1
 */