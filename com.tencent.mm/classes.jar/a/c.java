package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class c
{
  final e aBJ;
  
  public final String toString()
  {
    AppMethodBeat.i(52982);
    String str = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.aBJ.isCancellationRequested()) });
    AppMethodBeat.o(52982);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.c
 * JD-Core Version:    0.7.0.1
 */