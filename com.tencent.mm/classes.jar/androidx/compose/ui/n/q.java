package androidx.compose.ui.n;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/TextUnitType;", "", "type", "", "constructor-impl", "(J)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  private static final long avr;
  public static final q.a beU;
  private static final long beW;
  private static final long beX;
  public final long beV;
  
  static
  {
    AppMethodBeat.i(204733);
    beU = new q.a((byte)0);
    avr = 0L;
    beW = 4294967296L;
    beX = 8589934592L;
    AppMethodBeat.o(204733);
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.beV;
    if (!(paramObject instanceof q)) {}
    while (l != ((q)paramObject).beV) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204751);
    int i = q.a..ExternalSyntheticBackport0.m(this.beV);
    AppMethodBeat.o(204751);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204740);
    long l = this.beV;
    if (e(l, avr))
    {
      AppMethodBeat.o(204740);
      return "Unspecified";
    }
    if (e(l, beW))
    {
      AppMethodBeat.o(204740);
      return "Sp";
    }
    if (e(l, beX))
    {
      AppMethodBeat.o(204740);
      return "Em";
    }
    AppMethodBeat.o(204740);
    return "Invalid";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.q
 * JD-Core Version:    0.7.0.1
 */