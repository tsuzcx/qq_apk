package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "", "sessionId", "", "fromPageName", "entryPageNames", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEntryPageNames", "()Ljava/util/List;", "setEntryPageNames", "(Ljava/util/List;)V", "getFromPageName", "()Ljava/lang/String;", "setFromPageName", "(Ljava/lang/String;)V", "getSessionId", "setSessionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-expt_release"})
public final class i
{
  public String pHA;
  public List<String> pHB;
  public String sessionId;
  
  public i(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122622);
    this.sessionId = paramString1;
    this.pHA = paramString2;
    this.pHB = paramList;
    AppMethodBeat.o(122622);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122625);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!k.g(this.sessionId, paramObject.sessionId)) || (!k.g(this.pHA, paramObject.pHA)) || (!k.g(this.pHB, paramObject.pHB))) {}
      }
    }
    else
    {
      AppMethodBeat.o(122625);
      return true;
    }
    AppMethodBeat.o(122625);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(122624);
    Object localObject = this.sessionId;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.pHA;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.pHB;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(122624);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122623);
    String str = "SessionKEntry(sessionId=" + this.sessionId + ", fromPageName=" + this.pHA + ", entryPageNames=" + this.pHB + ")";
    AppMethodBeat.o(122623);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.i
 * JD-Core Version:    0.7.0.1
 */