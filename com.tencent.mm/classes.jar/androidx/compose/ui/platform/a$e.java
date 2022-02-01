package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "following", "", "current", "", "isEndBoundary", "", "index", "isStartBoundary", "preceding", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$e
  extends a.a
{
  public static final a.e.a aQL;
  private static e aQM;
  
  static
  {
    AppMethodBeat.i(206561);
    aQL = new a.e.a((byte)0);
    AppMethodBeat.o(206561);
  }
  
  private final boolean cU(int paramInt)
  {
    AppMethodBeat.i(206537);
    if ((getText().charAt(paramInt) != '\n') && ((paramInt == 0) || (getText().charAt(paramInt - 1) == '\n')))
    {
      AppMethodBeat.o(206537);
      return true;
    }
    AppMethodBeat.o(206537);
    return false;
  }
  
  private final boolean cV(int paramInt)
  {
    AppMethodBeat.i(206543);
    if ((paramInt > 0) && (getText().charAt(paramInt - 1) != '\n') && ((paramInt == getText().length()) || (getText().charAt(paramInt) == '\n')))
    {
      AppMethodBeat.o(206543);
      return true;
    }
    AppMethodBeat.o(206543);
    return false;
  }
  
  public final int[] cS(int paramInt)
  {
    AppMethodBeat.i(206565);
    int j = getText().length();
    if (j <= 0)
    {
      AppMethodBeat.o(206565);
      return null;
    }
    if (paramInt >= j)
    {
      AppMethodBeat.o(206565);
      return null;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    while ((i < j) && (getText().charAt(i) == '\n') && (!cU(i))) {
      i += 1;
    }
    if (i >= j)
    {
      AppMethodBeat.o(206565);
      return null;
    }
    paramInt = i + 1;
    while ((paramInt < j) && (!cV(paramInt))) {
      paramInt += 1;
    }
    int[] arrayOfInt = af(i, paramInt);
    AppMethodBeat.o(206565);
    return arrayOfInt;
  }
  
  public final int[] cT(int paramInt)
  {
    AppMethodBeat.i(206570);
    int j = getText().length();
    if (j <= 0)
    {
      AppMethodBeat.o(206570);
      return null;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(206570);
      return null;
    }
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    while ((i > 0) && (getText().charAt(i - 1) == '\n') && (!cV(i))) {
      i -= 1;
    }
    if (i <= 0)
    {
      AppMethodBeat.o(206570);
      return null;
    }
    paramInt = i - 1;
    while ((paramInt > 0) && (!cU(paramInt))) {
      paramInt -= 1;
    }
    int[] arrayOfInt = af(paramInt, i);
    AppMethodBeat.o(206570);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.a.e
 * JD-Core Version:    0.7.0.1
 */