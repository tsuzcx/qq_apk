package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "", "domain", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "manifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "extInfo", "", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;Ljava/lang/String;)V", "getDomain", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getManifest", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
public final class j
{
  String extInfo;
  final arg nGF;
  final arh nGG;
  
  private j(arg paramarg, arh paramarh)
  {
    AppMethodBeat.i(198880);
    this.nGF = paramarg;
    this.nGG = paramarh;
    this.extInfo = null;
    AppMethodBeat.o(198880);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198883);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((!k.g(this.nGF, paramObject.nGF)) || (!k.g(this.nGG, paramObject.nGG)) || (!k.g(this.extInfo, paramObject.extInfo))) {}
      }
    }
    else
    {
      AppMethodBeat.o(198883);
      return true;
    }
    AppMethodBeat.o(198883);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(198882);
    Object localObject = this.nGF;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.nGG;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.extInfo;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(198882);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198881);
    String str = "PrefetchManifest(domain=" + this.nGF + ", manifest=" + this.nGG + ", extInfo=" + this.extInfo + ")";
    AppMethodBeat.o(198881);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.j
 * JD-Core Version:    0.7.0.1
 */