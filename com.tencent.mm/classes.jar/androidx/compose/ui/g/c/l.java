package androidx.compose.ui.g.c;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerId;", "", "value", "", "constructor-impl", "(J)J", "getValue", "()J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public final long value;
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(205811);
    String str = "PointerId(value=" + paramLong + ')';
    AppMethodBeat.o(205811);
    return str;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.value;
    if (!(paramObject instanceof l)) {}
    while (l != ((l)paramObject).value) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205837);
    int i = q.a..ExternalSyntheticBackport0.m(this.value);
    AppMethodBeat.o(205837);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205829);
    String str = H(this.value);
    AppMethodBeat.o(205829);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.l
 * JD-Core Version:    0.7.0.1
 */