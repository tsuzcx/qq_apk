package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;", "", "sessionId", "", "anchorUsername", "anchorNickname", "anchorHeadUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorHeadUrl", "()Ljava/lang/String;", "getAnchorNickname", "getAnchorUsername", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"})
public final class b
{
  private final String kig;
  private final String sessionId;
  private final String yxR;
  private final String zev;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.sessionId = paramString1;
    this.kig = paramString2;
    this.yxR = paramString3;
    this.zev = paramString4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(259052);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.sessionId, paramObject.sessionId)) || (!p.h(this.kig, paramObject.kig)) || (!p.h(this.yxR, paramObject.yxR)) || (!p.h(this.zev, paramObject.zev))) {}
      }
    }
    else
    {
      AppMethodBeat.o(259052);
      return true;
    }
    AppMethodBeat.o(259052);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(259050);
    String str = this.sessionId;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.kig;
      if (str == null) {
        break label105;
      }
      j = str.hashCode();
      label42:
      str = this.yxR;
      if (str == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.zev;
      if (str != null) {
        m = str.hashCode();
      }
      AppMethodBeat.o(259050);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(259048);
    String str = "ApplyPkAnchorInfo(sessionId=" + this.sessionId + ", anchorUsername=" + this.kig + ", anchorNickname=" + this.yxR + ", anchorHeadUrl=" + this.zev + ")";
    AppMethodBeat.o(259048);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.b
 * JD-Core Version:    0.7.0.1
 */