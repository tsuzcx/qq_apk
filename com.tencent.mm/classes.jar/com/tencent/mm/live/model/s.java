package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "", "liveInfoList", "", "content", "toUsername", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getLiveInfoList", "getToUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public final String content;
  public final String hgl;
  public final String mZj;
  
  public s(String paramString1, String paramString2, String paramString3)
  {
    this.mZj = paramString1;
    this.content = paramString2;
    this.hgl = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246540);
    if (this == paramObject)
    {
      AppMethodBeat.o(246540);
      return true;
    }
    if (!(paramObject instanceof s))
    {
      AppMethodBeat.o(246540);
      return false;
    }
    paramObject = (s)paramObject;
    if (!kotlin.g.b.s.p(this.mZj, paramObject.mZj))
    {
      AppMethodBeat.o(246540);
      return false;
    }
    if (!kotlin.g.b.s.p(this.content, paramObject.content))
    {
      AppMethodBeat.o(246540);
      return false;
    }
    if (!kotlin.g.b.s.p(this.hgl, paramObject.hgl))
    {
      AppMethodBeat.o(246540);
      return false;
    }
    AppMethodBeat.o(246540);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(246534);
    int i;
    int j;
    if (this.mZj == null)
    {
      i = 0;
      if (this.content != null) {
        break label60;
      }
      j = 0;
      label25:
      if (this.hgl != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(246534);
      return (j + i * 31) * 31 + k;
      i = this.mZj.hashCode();
      break;
      label60:
      j = this.content.hashCode();
      break label25;
      label71:
      k = this.hgl.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246526);
    String str = "OnlineLiveListInfo(liveInfoList=" + this.mZj + ", content=" + this.content + ", toUsername=" + this.hgl + ')';
    AppMethodBeat.o(246526);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.s
 * JD-Core Version:    0.7.0.1
 */