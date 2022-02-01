package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  extends a.a
{
  public static final int Ue;
  public static final a.b.a aQA;
  private static b aQC;
  private BreakIterator aQB;
  
  static
  {
    AppMethodBeat.i(206572);
    aQA = new a.b.a((byte)0);
    Ue = 8;
    AppMethodBeat.o(206572);
  }
  
  private a$b(Locale paramLocale)
  {
    AppMethodBeat.i(206558);
    paramLocale = BreakIterator.getCharacterInstance(paramLocale);
    s.s(paramLocale, "getCharacterInstance(locale)");
    this.aQB = paramLocale;
    AppMethodBeat.o(206558);
  }
  
  public final void al(String paramString)
  {
    AppMethodBeat.i(206578);
    s.u(paramString, "text");
    super.al(paramString);
    BreakIterator localBreakIterator2 = this.aQB;
    BreakIterator localBreakIterator1 = localBreakIterator2;
    if (localBreakIterator2 == null)
    {
      s.bIx("impl");
      localBreakIterator1 = null;
    }
    localBreakIterator1.setText(paramString);
    AppMethodBeat.o(206578);
  }
  
  public final int[] cS(int paramInt)
  {
    AppMethodBeat.i(206587);
    int i = getText().length();
    if (i <= 0)
    {
      AppMethodBeat.o(206587);
      return null;
    }
    if (paramInt >= i)
    {
      AppMethodBeat.o(206587);
      return null;
    }
    i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    do
    {
      localBreakIterator = this.aQB;
      localObject = localBreakIterator;
      if (localBreakIterator == null)
      {
        s.bIx("impl");
        localObject = null;
      }
      if (((BreakIterator)localObject).isBoundary(i)) {
        break;
      }
      localBreakIterator = this.aQB;
      localObject = localBreakIterator;
      if (localBreakIterator == null)
      {
        s.bIx("impl");
        localObject = null;
      }
      paramInt = ((BreakIterator)localObject).following(i);
      i = paramInt;
    } while (paramInt != -1);
    AppMethodBeat.o(206587);
    return null;
    BreakIterator localBreakIterator = this.aQB;
    Object localObject = localBreakIterator;
    if (localBreakIterator == null)
    {
      s.bIx("impl");
      localObject = null;
    }
    paramInt = ((BreakIterator)localObject).following(i);
    if (paramInt == -1)
    {
      AppMethodBeat.o(206587);
      return null;
    }
    localObject = af(i, paramInt);
    AppMethodBeat.o(206587);
    return localObject;
  }
  
  public final int[] cT(int paramInt)
  {
    AppMethodBeat.i(206593);
    int j = getText().length();
    if (j <= 0)
    {
      AppMethodBeat.o(206593);
      return null;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(206593);
      return null;
    }
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    do
    {
      localBreakIterator = this.aQB;
      localObject = localBreakIterator;
      if (localBreakIterator == null)
      {
        s.bIx("impl");
        localObject = null;
      }
      if (((BreakIterator)localObject).isBoundary(i)) {
        break;
      }
      localBreakIterator = this.aQB;
      localObject = localBreakIterator;
      if (localBreakIterator == null)
      {
        s.bIx("impl");
        localObject = null;
      }
      paramInt = ((BreakIterator)localObject).preceding(i);
      i = paramInt;
    } while (paramInt != -1);
    AppMethodBeat.o(206593);
    return null;
    BreakIterator localBreakIterator = this.aQB;
    Object localObject = localBreakIterator;
    if (localBreakIterator == null)
    {
      s.bIx("impl");
      localObject = null;
    }
    paramInt = ((BreakIterator)localObject).preceding(i);
    if (paramInt == -1)
    {
      AppMethodBeat.o(206593);
      return null;
    }
    localObject = af(paramInt, i);
    AppMethodBeat.o(206593);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.a.b
 * JD-Core Version:    0.7.0.1
 */