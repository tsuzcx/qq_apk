package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "", "sessionId", "", "fromPageName", "entryPageNames", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEntryPageNames", "()Ljava/util/List;", "setEntryPageNames", "(Ljava/util/List;)V", "getFromPageName", "()Ljava/lang/String;", "setFromPageName", "(Ljava/lang/String;)V", "getSessionId", "setSessionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-expt_release"})
public final class e
{
  public String cpW;
  public String mba;
  public List<String> mbb;
  
  public e(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(152539);
    this.cpW = paramString1;
    this.mba = paramString2;
    this.mbb = paramList;
    AppMethodBeat.o(152539);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(152542);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!j.e(this.cpW, paramObject.cpW)) || (!j.e(this.mba, paramObject.mba)) || (!j.e(this.mbb, paramObject.mbb))) {}
      }
    }
    else
    {
      AppMethodBeat.o(152542);
      return true;
    }
    AppMethodBeat.o(152542);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(152541);
    Object localObject = this.cpW;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.mba;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.mbb;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(152541);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152540);
    String str = "SessionKEntry(sessionId=" + this.cpW + ", fromPageName=" + this.mba + ", entryPageNames=" + this.mbb + ")";
    AppMethodBeat.o(152540);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.e
 * JD-Core Version:    0.7.0.1
 */