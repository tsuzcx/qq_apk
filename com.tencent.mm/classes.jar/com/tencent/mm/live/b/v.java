package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "", "liveInfoList", "", "content", "toUsername", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getLiveInfoList", "getToUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class v
{
  public final String content;
  public final String dkV;
  public final String hIo;
  
  public v(String paramString1, String paramString2, String paramString3)
  {
    this.hIo = paramString1;
    this.content = paramString2;
    this.dkV = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207696);
    if (this != paramObject)
    {
      if ((paramObject instanceof v))
      {
        paramObject = (v)paramObject;
        if ((!p.j(this.hIo, paramObject.hIo)) || (!p.j(this.content, paramObject.content)) || (!p.j(this.dkV, paramObject.dkV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207696);
      return true;
    }
    AppMethodBeat.o(207696);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(207695);
    String str = this.hIo;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.content;
      if (str == null) {
        break label80;
      }
    }
    label80:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.dkV;
      if (str != null) {
        k = str.hashCode();
      }
      AppMethodBeat.o(207695);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207694);
    String str = "OnlineLiveListInfo(liveInfoList=" + this.hIo + ", content=" + this.content + ", toUsername=" + this.dkV + ")";
    AppMethodBeat.o(207694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.v
 * JD-Core Version:    0.7.0.1
 */