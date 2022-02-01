package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "", "LiveId", "", "enableComment", "", "wording", "", "(JILjava/lang/String;)V", "getLiveId", "()J", "getEnableComment", "()I", "getWording", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class c
{
  public final String dQx;
  public final long hFH;
  public final int hFI;
  
  public c(long paramLong, int paramInt, String paramString)
  {
    this.hFH = paramLong;
    this.hFI = paramInt;
    this.dQx = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207558);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.hFH != paramObject.hFH) || (this.hFI != paramObject.hFI) || (!p.j(this.dQx, paramObject.dQx))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207558);
      return true;
    }
    AppMethodBeat.o(207558);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(207557);
    long l = this.hFH;
    int j = (int)(l ^ l >>> 32);
    int k = this.hFI;
    String str = this.dQx;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(207557);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207556);
    String str = "BanLiveCommentInfo(LiveId=" + this.hFH + ", enableComment=" + this.hFI + ", wording=" + this.dQx + ")";
    AppMethodBeat.o(207556);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.c
 * JD-Core Version:    0.7.0.1
 */