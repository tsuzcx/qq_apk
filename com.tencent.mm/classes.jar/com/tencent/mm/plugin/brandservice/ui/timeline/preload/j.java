package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.avt;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "", "domain", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "manifest", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "extInfo", "", "bizScene", "", "(Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;Ljava/lang/String;I)V", "getBizScene", "()I", "setBizScene", "(I)V", "getDomain", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getManifest", "()Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchResInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"})
public final class j
{
  String extInfo;
  int nLC;
  final avs opi;
  final avt opj;
  
  private j(avs paramavs, avt paramavt)
  {
    AppMethodBeat.i(208821);
    this.opi = paramavs;
    this.opj = paramavt;
    this.extInfo = null;
    this.nLC = 0;
    AppMethodBeat.o(208821);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208824);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((!p.i(this.opi, paramObject.opi)) || (!p.i(this.opj, paramObject.opj)) || (!p.i(this.extInfo, paramObject.extInfo)) || (this.nLC != paramObject.nLC)) {}
      }
    }
    else
    {
      AppMethodBeat.o(208824);
      return true;
    }
    AppMethodBeat.o(208824);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(208823);
    Object localObject = this.opi;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.opj;
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.extInfo;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.nLC;
      AppMethodBeat.o(208823);
      return ((j + i * 31) * 31 + k) * 31 + m;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208822);
    String str = "PrefetchManifest(domain=" + this.opi + ", manifest=" + this.opj + ", extInfo=" + this.extInfo + ", bizScene=" + this.nLC + ")";
    AppMethodBeat.o(208822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.j
 * JD-Core Version:    0.7.0.1
 */