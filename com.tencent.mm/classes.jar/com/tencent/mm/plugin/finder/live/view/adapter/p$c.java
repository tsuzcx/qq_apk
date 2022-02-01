package com.tencent.mm.plugin.finder.live.view.adapter;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter$FinderFastCommentInfo;", "", "comment", "", "type", "", "lastSendTime", "", "(Ljava/lang/String;IJ)V", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "getLastSendTime", "()J", "setLastSendTime", "(J)V", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p$c
{
  public String comment;
  public long pdr;
  final int type;
  
  public p$c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(358771);
    this.comment = paramString;
    this.type = paramInt;
    this.pdr = paramLong;
    AppMethodBeat.o(358771);
  }
  
  public final void axZ(String paramString)
  {
    AppMethodBeat.i(358781);
    s.u(paramString, "<set-?>");
    this.comment = paramString;
    AppMethodBeat.o(358781);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(358804);
    if (this == paramObject)
    {
      AppMethodBeat.o(358804);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(358804);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.comment, paramObject.comment))
    {
      AppMethodBeat.o(358804);
      return false;
    }
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(358804);
      return false;
    }
    if (this.pdr != paramObject.pdr)
    {
      AppMethodBeat.o(358804);
      return false;
    }
    AppMethodBeat.o(358804);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(358796);
    int i = this.comment.hashCode();
    int j = this.type;
    int k = q.a..ExternalSyntheticBackport0.m(this.pdr);
    AppMethodBeat.o(358796);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(358788);
    String str = "FinderFastCommentInfo(comment=" + this.comment + ", type=" + this.type + ", lastSendTime=" + this.pdr + ')';
    AppMethodBeat.o(358788);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.p.c
 * JD-Core Version:    0.7.0.1
 */