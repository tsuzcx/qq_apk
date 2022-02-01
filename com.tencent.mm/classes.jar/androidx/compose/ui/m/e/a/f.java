package androidx.compose.ui.m.e.a;

import android.text.style.TtsSpan;
import android.text.style.TtsSpan.VerbatimBuilder;
import androidx.compose.ui.m.w;
import androidx.compose.ui.m.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"toSpan", "Landroid/text/style/TtsSpan;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final TtsSpan a(w paramw)
  {
    AppMethodBeat.i(205358);
    s.u(paramw, "<this>");
    if ((paramw instanceof x))
    {
      paramw = a((x)paramw);
      AppMethodBeat.o(205358);
      return paramw;
    }
    paramw = new p();
    AppMethodBeat.o(205358);
    throw paramw;
  }
  
  private static TtsSpan a(x paramx)
  {
    AppMethodBeat.i(205363);
    s.u(paramx, "<this>");
    paramx = new TtsSpan.VerbatimBuilder(paramx.baI).build();
    s.s(paramx, "builder.build()");
    AppMethodBeat.o(205363);
    return paramx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.m.e.a.f
 * JD-Core Version:    0.7.0.1
 */