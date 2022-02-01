package com.tencent.mm.plugin.finder.live.plugin;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfo;", "", "type", "", "value", "", "title", "", "value2", "(IJLjava/lang/CharSequence;J)V", "getTitle", "()Ljava/lang/CharSequence;", "getType", "()I", "getValue", "()J", "getValue2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
{
  final long CTJ;
  final CharSequence title;
  final int type;
  final long value;
  
  public g$a(int paramInt, long paramLong1, CharSequence paramCharSequence, long paramLong2)
  {
    AppMethodBeat.i(354952);
    this.type = paramInt;
    this.value = paramLong1;
    this.title = paramCharSequence;
    this.CTJ = paramLong2;
    AppMethodBeat.o(354952);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(354988);
    if (this == paramObject)
    {
      AppMethodBeat.o(354988);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(354988);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(354988);
      return false;
    }
    if (this.value != paramObject.value)
    {
      AppMethodBeat.o(354988);
      return false;
    }
    if (!s.p(this.title, paramObject.title))
    {
      AppMethodBeat.o(354988);
      return false;
    }
    if (this.CTJ != paramObject.CTJ)
    {
      AppMethodBeat.o(354988);
      return false;
    }
    AppMethodBeat.o(354988);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(354978);
    int i = this.type;
    int j = q.a..ExternalSyntheticBackport0.m(this.value);
    int k = this.title.hashCode();
    int m = q.a..ExternalSyntheticBackport0.m(this.CTJ);
    AppMethodBeat.o(354978);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(354971);
    String str = "CommonInfo(type=" + this.type + ", value=" + this.value + ", title=" + this.title + ", value2=" + this.CTJ + ')';
    AppMethodBeat.o(354971);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.g.a
 * JD-Core Version:    0.7.0.1
 */