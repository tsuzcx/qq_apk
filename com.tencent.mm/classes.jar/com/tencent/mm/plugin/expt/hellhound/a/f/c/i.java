package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "", "sessionId", "", "fromPageName", "entryPageNames", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEntryPageNames", "()Ljava/util/List;", "setEntryPageNames", "(Ljava/util/List;)V", "getFromPageName", "()Ljava/lang/String;", "setFromPageName", "(Ljava/lang/String;)V", "getSessionId", "setSessionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-expt_release"})
public final class i
{
  public String sessionId;
  public String woF;
  public List<String> woG;
  
  public i(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122622);
    this.sessionId = paramString1;
    this.woF = paramString2;
    this.woG = paramList;
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
        if ((!p.h(this.sessionId, paramObject.sessionId)) || (!p.h(this.woF, paramObject.woF)) || (!p.h(this.woG, paramObject.woG))) {}
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
      localObject = this.woF;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.woG;
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
    String str = "SessionKEntry(sessionId=" + this.sessionId + ", fromPageName=" + this.woF + ", entryPageNames=" + this.woG + ")";
    AppMethodBeat.o(122623);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.i
 * JD-Core Version:    0.7.0.1
 */