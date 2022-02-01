package com.tencent.mm.live.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "", "LiveId", "", "enableComment", "", "wording", "", "(JILjava/lang/String;)V", "getLiveId", "()J", "getEnableComment", "()I", "getWording", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final long mXI;
  public final int mXJ;
  public final String wording;
  
  public c(long paramLong, int paramInt, String paramString)
  {
    this.mXI = paramLong;
    this.mXJ = paramInt;
    this.wording = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246600);
    if (this == paramObject)
    {
      AppMethodBeat.o(246600);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(246600);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.mXI != paramObject.mXI)
    {
      AppMethodBeat.o(246600);
      return false;
    }
    if (this.mXJ != paramObject.mXJ)
    {
      AppMethodBeat.o(246600);
      return false;
    }
    if (!s.p(this.wording, paramObject.wording))
    {
      AppMethodBeat.o(246600);
      return false;
    }
    AppMethodBeat.o(246600);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(246590);
    int j = q.a..ExternalSyntheticBackport0.m(this.mXI);
    int k = this.mXJ;
    if (this.wording == null) {}
    for (int i = 0;; i = this.wording.hashCode())
    {
      AppMethodBeat.o(246590);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246582);
    String str = "BanLiveCommentInfo(LiveId=" + this.mXI + ", enableComment=" + this.mXJ + ", wording=" + this.wording + ')';
    AppMethodBeat.o(246582);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.c
 * JD-Core Version:    0.7.0.1
 */