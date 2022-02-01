package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "", "sessionId", "", "fromPageName", "entryPageNames", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEntryPageNames", "()Ljava/util/List;", "setEntryPageNames", "(Ljava/util/List;)V", "getFromPageName", "()Ljava/lang/String;", "setFromPageName", "(Ljava/lang/String;)V", "getSessionId", "setSessionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public String sessionId;
  public String zKK;
  public List<String> zKL;
  
  public i(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122622);
    this.sessionId = paramString1;
    this.zKK = paramString2;
    this.zKL = paramList;
    AppMethodBeat.o(122622);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122625);
    if (this == paramObject)
    {
      AppMethodBeat.o(122625);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(122625);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(122625);
      return false;
    }
    if (!s.p(this.zKK, paramObject.zKK))
    {
      AppMethodBeat.o(122625);
      return false;
    }
    if (!s.p(this.zKL, paramObject.zKL))
    {
      AppMethodBeat.o(122625);
      return false;
    }
    AppMethodBeat.o(122625);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(122624);
    int i;
    if (this.sessionId == null)
    {
      i = 0;
      if (this.zKK != null) {
        break label59;
      }
    }
    for (;;)
    {
      int k = this.zKL.hashCode();
      AppMethodBeat.o(122624);
      return (i * 31 + j) * 31 + k;
      i = this.sessionId.hashCode();
      break;
      label59:
      j = this.zKK.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122623);
    String str = "SessionKEntry(sessionId=" + this.sessionId + ", fromPageName=" + this.zKK + ", entryPageNames=" + this.zKL + ')';
    AppMethodBeat.o(122623);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.i
 * JD-Core Version:    0.7.0.1
 */