package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "", "liveInfoList", "", "content", "toUsername", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getLiveInfoList", "getToUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class s
{
  public final String content;
  public final String fcD;
  public final String kvI;
  
  public s(String paramString1, String paramString2, String paramString3)
  {
    this.kvI = paramString1;
    this.content = paramString2;
    this.fcD = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200672);
    if (this != paramObject)
    {
      if ((paramObject instanceof s))
      {
        paramObject = (s)paramObject;
        if ((!p.h(this.kvI, paramObject.kvI)) || (!p.h(this.content, paramObject.content)) || (!p.h(this.fcD, paramObject.fcD))) {}
      }
    }
    else
    {
      AppMethodBeat.o(200672);
      return true;
    }
    AppMethodBeat.o(200672);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(200669);
    String str = this.kvI;
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
      str = this.fcD;
      if (str != null) {
        k = str.hashCode();
      }
      AppMethodBeat.o(200669);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200667);
    String str = "OnlineLiveListInfo(liveInfoList=" + this.kvI + ", content=" + this.content + ", toUsername=" + this.fcD + ")";
    AppMethodBeat.o(200667);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.s
 * JD-Core Version:    0.7.0.1
 */