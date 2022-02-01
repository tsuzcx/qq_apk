package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avd;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "", "domain", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "manifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "extInfo", "", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;Ljava/lang/String;)V", "getDomain", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getManifest", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
public final class j
{
  String extInfo;
  final avc oji;
  final avd ojj;
  
  private j(avc paramavc, avd paramavd)
  {
    AppMethodBeat.i(209826);
    this.oji = paramavc;
    this.ojj = paramavd;
    this.extInfo = null;
    AppMethodBeat.o(209826);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(209829);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((!p.i(this.oji, paramObject.oji)) || (!p.i(this.ojj, paramObject.ojj)) || (!p.i(this.extInfo, paramObject.extInfo))) {}
      }
    }
    else
    {
      AppMethodBeat.o(209829);
      return true;
    }
    AppMethodBeat.o(209829);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(209828);
    Object localObject = this.oji;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.ojj;
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
      AppMethodBeat.o(209828);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209827);
    String str = "PrefetchManifest(domain=" + this.oji + ", manifest=" + this.ojj + ", extInfo=" + this.extInfo + ")";
    AppMethodBeat.o(209827);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.j
 * JD-Core Version:    0.7.0.1
 */