package androidx.compose.ui.m.a;

import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "textDirectionHeuristic", "", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final TextDirectionHeuristic dw(int paramInt)
  {
    AppMethodBeat.i(205176);
    switch (paramInt)
    {
    default: 
      localTextDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      s.s(localTextDirectionHeuristic, "FIRSTSTRONG_LTR");
      AppMethodBeat.o(205176);
      return localTextDirectionHeuristic;
    case 0: 
      localTextDirectionHeuristic = TextDirectionHeuristics.LTR;
      s.s(localTextDirectionHeuristic, "LTR");
      AppMethodBeat.o(205176);
      return localTextDirectionHeuristic;
    case 5: 
      localTextDirectionHeuristic = TextDirectionHeuristics.LOCALE;
      s.s(localTextDirectionHeuristic, "LOCALE");
      AppMethodBeat.o(205176);
      return localTextDirectionHeuristic;
    case 1: 
      localTextDirectionHeuristic = TextDirectionHeuristics.RTL;
      s.s(localTextDirectionHeuristic, "RTL");
      AppMethodBeat.o(205176);
      return localTextDirectionHeuristic;
    case 3: 
      localTextDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
      s.s(localTextDirectionHeuristic, "FIRSTSTRONG_RTL");
      AppMethodBeat.o(205176);
      return localTextDirectionHeuristic;
    case 4: 
      localTextDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
      s.s(localTextDirectionHeuristic, "ANYRTL_LTR");
      AppMethodBeat.o(205176);
      return localTextDirectionHeuristic;
    }
    TextDirectionHeuristic localTextDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    s.s(localTextDirectionHeuristic, "FIRSTSTRONG_LTR");
    AppMethodBeat.o(205176);
    return localTextDirectionHeuristic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.m.a.o
 * JD-Core Version:    0.7.0.1
 */