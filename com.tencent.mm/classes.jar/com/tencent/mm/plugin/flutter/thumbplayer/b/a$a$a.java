package com.tencent.mm.plugin.flutter.thumbplayer.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$Companion$PlayRange;", "", "startTimeMs", "", "endTimeMs", "(JJ)V", "getEndTimeMs", "()J", "getStartTimeMs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a$a
{
  public final long endTimeMs;
  public final long startTimeMs;
  
  public a$a$a(long paramLong1, long paramLong2)
  {
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.startTimeMs != paramObject.startTimeMs) {
        return false;
      }
    } while (this.endTimeMs == paramObject.endTimeMs);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(263214);
    int i = q.a..ExternalSyntheticBackport0.m(this.startTimeMs);
    int j = q.a..ExternalSyntheticBackport0.m(this.endTimeMs);
    AppMethodBeat.o(263214);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(263209);
    String str = "PlayRange(startTimeMs=" + this.startTimeMs + ", endTimeMs=" + this.endTimeMs + ')';
    AppMethodBeat.o(263209);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */