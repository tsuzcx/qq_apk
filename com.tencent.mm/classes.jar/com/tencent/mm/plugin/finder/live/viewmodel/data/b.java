package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;", "", "sessionId", "", "anchorUsername", "anchorNickname", "anchorHeadUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorHeadUrl", "()Ljava/lang/String;", "getAnchorNickname", "getAnchorUsername", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final String Dky;
  private final String Ebo;
  private final String mIC;
  private final String sessionId;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.sessionId = paramString1;
    this.mIC = paramString2;
    this.Dky = paramString3;
    this.Ebo = paramString4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356564);
    if (this == paramObject)
    {
      AppMethodBeat.o(356564);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(356564);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(356564);
      return false;
    }
    if (!s.p(this.mIC, paramObject.mIC))
    {
      AppMethodBeat.o(356564);
      return false;
    }
    if (!s.p(this.Dky, paramObject.Dky))
    {
      AppMethodBeat.o(356564);
      return false;
    }
    if (!s.p(this.Ebo, paramObject.Ebo))
    {
      AppMethodBeat.o(356564);
      return false;
    }
    AppMethodBeat.o(356564);
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(356558);
    int i;
    int j;
    label26:
    int k;
    if (this.sessionId == null)
    {
      i = 0;
      if (this.mIC != null) {
        break label76;
      }
      j = 0;
      if (this.Dky != null) {
        break label87;
      }
      k = 0;
      label35:
      if (this.Ebo != null) {
        break label98;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(356558);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = this.sessionId.hashCode();
      break;
      label76:
      j = this.mIC.hashCode();
      break label26;
      label87:
      k = this.Dky.hashCode();
      break label35;
      label98:
      m = this.Ebo.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356553);
    String str = "ApplyPkAnchorInfo(sessionId=" + this.sessionId + ", anchorUsername=" + this.mIC + ", anchorNickname=" + this.Dky + ", anchorHeadUrl=" + this.Ebo + ')';
    AppMethodBeat.o(356553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.b
 * JD-Core Version:    0.7.0.1
 */