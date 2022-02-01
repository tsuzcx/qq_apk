package androidx.compose.ui.g.c.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import androidx.compose.ui.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/util/PointAtTime;", "", "point", "Landroidx/compose/ui/geometry/Offset;", "time", "", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPoint-F1C5BW0", "()J", "J", "getTime", "component1", "component1-F1C5BW0", "component2", "copy", "copy-3MmeM6k", "(JJ)Landroidx/compose/ui/input/pointer/util/PointAtTime;", "equals", "", "other", "hashCode", "", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
{
  final long aMo;
  final long time;
  
  private b(long paramLong1, long paramLong2)
  {
    this.aMo = paramLong1;
    this.time = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205904);
    if (this == paramObject)
    {
      AppMethodBeat.o(205904);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(205904);
      return false;
    }
    paramObject = (b)paramObject;
    if (!e.e(this.aMo, paramObject.aMo))
    {
      AppMethodBeat.o(205904);
      return false;
    }
    if (this.time != paramObject.time)
    {
      AppMethodBeat.o(205904);
      return false;
    }
    AppMethodBeat.o(205904);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205901);
    int i = e.I(this.aMo);
    int j = q.a..ExternalSyntheticBackport0.m(this.time);
    AppMethodBeat.o(205901);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205893);
    String str = "PointAtTime(point=" + e.H(this.aMo) + ", time=" + this.time + ')';
    AppMethodBeat.o(205893);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.a.b
 * JD-Core Version:    0.7.0.1
 */