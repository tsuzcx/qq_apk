package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.k.k;

@Metadata(d1={""}, d2={"TextRange", "Landroidx/compose/ui/text/TextRange;", "index", "", "(I)J", "start", "end", "(II)J", "packWithCheck", "", "constrain", "minimumValue", "maximumValue", "constrain-8ffj60Q", "(JII)J", "substring", "", "", "range", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final long ai(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204930);
    long l = s.J(aj(paramInt1, paramInt2));
    AppMethodBeat.o(204930);
    return l;
  }
  
  private static final long aj(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(204938);
    if (paramInt1 >= 0) {}
    Throwable localThrowable;
    for (int i = 1; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException(("start cannot be negative. [start: " + paramInt1 + ']').toString());
      AppMethodBeat.o(204938);
      throw localThrowable;
    }
    if (paramInt2 >= 0) {}
    for (i = j; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException(("end cannot negative. [end: " + paramInt2 + ']').toString());
      AppMethodBeat.o(204938);
      throw localThrowable;
    }
    long l1 = paramInt1;
    long l2 = paramInt2;
    AppMethodBeat.o(204938);
    return l1 << 32 | l2 & 0xFFFFFFFF;
  }
  
  public static final long f(long paramLong, int paramInt)
  {
    AppMethodBeat.i(204933);
    int i = k.bQ(s.aN(paramLong), 0, paramInt);
    paramInt = k.bQ(s.aO(paramLong), 0, paramInt);
    if ((i != s.aN(paramLong)) || (paramInt != s.aO(paramLong)))
    {
      paramLong = ai(i, paramInt);
      AppMethodBeat.o(204933);
      return paramLong;
    }
    AppMethodBeat.o(204933);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.t
 * JD-Core Version:    0.7.0.1
 */