package androidx.compose.ui.m.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/selection/WordBoundary;", "", "locale", "Ljava/util/Locale;", "text", "", "(Ljava/util/Locale;Ljava/lang/CharSequence;)V", "wordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "getWordEnd", "", "offset", "getWordStart", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final b bbu;
  
  public a(Locale paramLocale, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205142);
    this.bbu = new b(paramCharSequence, paramCharSequence.length(), paramLocale);
    AppMethodBeat.o(205142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.a.a
 * JD-Core Version:    0.7.0.1
 */