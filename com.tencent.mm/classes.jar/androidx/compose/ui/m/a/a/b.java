package androidx.compose.ui.m.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", "start", "", "end", "locale", "Ljava/util/Locale;", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "iterator", "Ljava/text/BreakIterator;", "checkOffsetIsValid", "", "offset", "getBeginning", "getPrevWordBeginningOnTwoWordsBoundary", "", "getEnd", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterLetterOrDigit", "isAfterPunctuation", "isOnLetterOrDigit", "isOnPunctuation", "isPunctuationEndBoundary", "isPunctuationStartBoundary", "nextBoundary", "prevBoundary", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a bbv;
  private final CharSequence bbw;
  private final BreakIterator bbx;
  private final int end;
  private final int start;
  
  static
  {
    AppMethodBeat.i(205159);
    bbv = new b.a((byte)0);
    AppMethodBeat.o(205159);
  }
  
  public b(CharSequence paramCharSequence, int paramInt, Locale paramLocale)
  {
    AppMethodBeat.i(205152);
    this.bbw = paramCharSequence;
    if (this.bbw.length() >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("input start index is outside the CharSequence".toString());
      AppMethodBeat.o(205152);
      throw paramCharSequence;
    }
    if (paramInt >= 0) {
      if (paramInt <= this.bbw.length()) {
        i = j;
      }
    }
    while (i == 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("input end index is outside the CharSequence".toString());
      AppMethodBeat.o(205152);
      throw paramCharSequence;
      i = 0;
      continue;
      i = 0;
    }
    paramCharSequence = BreakIterator.getWordInstance(paramLocale);
    s.s(paramCharSequence, "getWordInstance(locale)");
    this.bbx = paramCharSequence;
    this.start = Math.max(0, -50);
    this.end = Math.min(this.bbw.length(), paramInt + 50);
    this.bbx.setText((CharacterIterator)new androidx.compose.ui.m.a.b(this.bbw, paramInt));
    AppMethodBeat.o(205152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.a.b
 * JD-Core Version:    0.7.0.1
 */