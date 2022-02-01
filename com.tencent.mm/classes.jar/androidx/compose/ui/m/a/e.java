package androidx.compose.ui.m.a;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"hasSpan", "", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final boolean a(Spanned paramSpanned, Class<?> paramClass)
  {
    AppMethodBeat.i(205166);
    s.u(paramSpanned, "<this>");
    s.u(paramClass, "clazz");
    if (paramSpanned.nextSpanTransition(-1, paramSpanned.length(), paramClass) != paramSpanned.length())
    {
      AppMethodBeat.o(205166);
      return true;
    }
    AppMethodBeat.o(205166);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.e
 * JD-Core Version:    0.7.0.1
 */