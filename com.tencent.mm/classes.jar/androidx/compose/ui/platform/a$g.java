package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "isEndBoundary", "", "index", "isLetterOrDigit", "isStartBoundary", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$g
  extends a.a
{
  public static final int Ue;
  public static final a.g.a aQN;
  private static g aQO;
  private BreakIterator aQB;
  
  static
  {
    AppMethodBeat.i(206568);
    aQN = new a.g.a((byte)0);
    Ue = 8;
    AppMethodBeat.o(206568);
  }
  
  private a$g(Locale paramLocale)
  {
    AppMethodBeat.i(206534);
    paramLocale = BreakIterator.getWordInstance(paramLocale);
    s.s(paramLocale, "getWordInstance(locale)");
    this.aQB = paramLocale;
    AppMethodBeat.o(206534);
  }
  
  private final boolean cU(int paramInt)
  {
    AppMethodBeat.i(206540);
    if ((cW(paramInt)) && ((paramInt == 0) || (!cW(paramInt - 1))))
    {
      AppMethodBeat.o(206540);
      return true;
    }
    AppMethodBeat.o(206540);
    return false;
  }
  
  private final boolean cV(int paramInt)
  {
    AppMethodBeat.i(206549);
    if ((paramInt > 0) && (cW(paramInt - 1)) && ((paramInt == getText().length()) || (!cW(paramInt))))
    {
      AppMethodBeat.o(206549);
      return true;
    }
    AppMethodBeat.o(206549);
    return false;
  }
  
  private final boolean cW(int paramInt)
  {
    AppMethodBeat.i(206554);
    if ((paramInt >= 0) && (paramInt < getText().length()))
    {
      Object localObject = getText();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206554);
        throw ((Throwable)localObject);
      }
      boolean bool = Character.isLetterOrDigit(((String)localObject).codePointAt(paramInt));
      AppMethodBeat.o(206554);
      return bool;
    }
    AppMethodBeat.o(206554);
    return false;
  }
  
  public final void al(String paramString)
  {
    AppMethodBeat.i(206573);
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
    AppMethodBeat.o(206573);
  }
  
  public final int[] cS(int paramInt)
  {
    AppMethodBeat.i(206580);
    if (getText().length() <= 0)
    {
      AppMethodBeat.o(206580);
      return null;
    }
    if (paramInt >= getText().length())
    {
      AppMethodBeat.o(206580);
      return null;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    while ((!cW(i)) && (!cU(i)))
    {
      localBreakIterator = this.aQB;
      localObject = localBreakIterator;
      if (localBreakIterator == null)
      {
        s.bIx("impl");
        localObject = null;
      }
      paramInt = ((BreakIterator)localObject).following(i);
      i = paramInt;
      if (paramInt == -1)
      {
        AppMethodBeat.o(206580);
        return null;
      }
    }
    BreakIterator localBreakIterator = this.aQB;
    Object localObject = localBreakIterator;
    if (localBreakIterator == null)
    {
      s.bIx("impl");
      localObject = null;
    }
    paramInt = ((BreakIterator)localObject).following(i);
    if ((paramInt == -1) || (!cV(paramInt)))
    {
      AppMethodBeat.o(206580);
      return null;
    }
    localObject = af(i, paramInt);
    AppMethodBeat.o(206580);
    return localObject;
  }
  
  public final int[] cT(int paramInt)
  {
    AppMethodBeat.i(206586);
    int j = getText().length();
    if (j <= 0)
    {
      AppMethodBeat.o(206586);
      return null;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(206586);
      return null;
    }
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    while ((i > 0) && (!cW(i - 1)) && (!cV(i)))
    {
      localBreakIterator = this.aQB;
      localObject = localBreakIterator;
      if (localBreakIterator == null)
      {
        s.bIx("impl");
        localObject = null;
      }
      paramInt = ((BreakIterator)localObject).preceding(i);
      i = paramInt;
      if (paramInt == -1)
      {
        AppMethodBeat.o(206586);
        return null;
      }
    }
    BreakIterator localBreakIterator = this.aQB;
    Object localObject = localBreakIterator;
    if (localBreakIterator == null)
    {
      s.bIx("impl");
      localObject = null;
    }
    paramInt = ((BreakIterator)localObject).preceding(i);
    if ((paramInt == -1) || (!cU(paramInt)))
    {
      AppMethodBeat.o(206586);
      return null;
    }
    localObject = af(paramInt, i);
    AppMethodBeat.o(206586);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.a.g
 * JD-Core Version:    0.7.0.1
 */