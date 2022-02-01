package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "", "LiveId", "", "enableComment", "", "wording", "", "(JILjava/lang/String;)V", "getLiveId", "()J", "getEnableComment", "()I", "getWording", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class c
{
  public final long ktO;
  public final int ktP;
  public final String wording;
  
  public c(long paramLong, int paramInt, String paramString)
  {
    this.ktO = paramLong;
    this.ktP = paramInt;
    this.wording = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201281);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.ktO != paramObject.ktO) || (this.ktP != paramObject.ktP) || (!p.h(this.wording, paramObject.wording))) {}
      }
    }
    else
    {
      AppMethodBeat.o(201281);
      return true;
    }
    AppMethodBeat.o(201281);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201276);
    long l = this.ktO;
    int j = (int)(l ^ l >>> 32);
    int k = this.ktP;
    String str = this.wording;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(201276);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201270);
    String str = "BanLiveCommentInfo(LiveId=" + this.ktO + ", enableComment=" + this.ktP + ", wording=" + this.wording + ")";
    AppMethodBeat.o(201270);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.c
 * JD-Core Version:    0.7.0.1
 */