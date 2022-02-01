package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;", "", "linkAnchorUsername", "", "linkObjectId", "", "linkLiveId", "linkAnchorNickname", "linkAnchorAvatarUrl", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getLinkAnchorAvatarUrl", "()Ljava/lang/String;", "setLinkAnchorAvatarUrl", "(Ljava/lang/String;)V", "getLinkAnchorNickname", "setLinkAnchorNickname", "getLinkAnchorUsername", "setLinkAnchorUsername", "getLinkLiveId", "()J", "setLinkLiveId", "(J)V", "getLinkObjectId", "setLinkObjectId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
public final class h
{
  public String hwh;
  public String hwi;
  public String hwj;
  public long uFp;
  public long uFq;
  
  public h(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    this.hwh = paramString1;
    this.uFp = paramLong1;
    this.uFq = paramLong2;
    this.hwi = paramString2;
    this.hwj = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(248010);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.j(this.hwh, paramObject.hwh)) || (this.uFp != paramObject.uFp) || (this.uFq != paramObject.uFq) || (!p.j(this.hwi, paramObject.hwi)) || (!p.j(this.hwj, paramObject.hwj))) {}
      }
    }
    else
    {
      AppMethodBeat.o(248010);
      return true;
    }
    AppMethodBeat.o(248010);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(248009);
    String str = this.hwh;
    int i;
    int m;
    int n;
    if (str != null)
    {
      i = str.hashCode();
      long l = this.uFp;
      m = (int)(l ^ l >>> 32);
      l = this.uFq;
      n = (int)(l ^ l >>> 32);
      str = this.hwi;
      if (str == null) {
        break label126;
      }
    }
    label126:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.hwj;
      if (str != null) {
        k = str.hashCode();
      }
      AppMethodBeat.o(248009);
      return (j + ((i * 31 + m) * 31 + n) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248008);
    String str = "LinkInviteInfo(linkAnchorUsername=" + this.hwh + ", linkObjectId=" + this.uFp + ", linkLiveId=" + this.uFq + ", linkAnchorNickname=" + this.hwi + ", linkAnchorAvatarUrl=" + this.hwj + ")";
    AppMethodBeat.o(248008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.h
 * JD-Core Version:    0.7.0.1
 */