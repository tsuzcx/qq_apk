package androidx.compose.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"toStringAsFixed", "", "", "digits", "", "ui-geometry_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final String I(float paramFloat)
  {
    AppMethodBeat.i(205517);
    int j = Math.max(1, 0);
    float f = (float)Math.pow(10.0D, j);
    paramFloat *= f;
    if (paramFloat - (int)paramFloat >= 0.5F) {}
    for (int i = (int)paramFloat + 1;; i = (int)paramFloat)
    {
      paramFloat = i / f;
      if (j <= 0) {
        break;
      }
      AppMethodBeat.o(205517);
      return String.valueOf(paramFloat);
    }
    i = (int)paramFloat;
    AppMethodBeat.o(205517);
    return String.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.c
 * JD-Core Version:    0.7.0.1
 */