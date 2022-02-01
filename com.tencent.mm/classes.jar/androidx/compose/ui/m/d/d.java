package androidx.compose.ui.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/intl/Locale;", "", "languageTag", "", "(Ljava/lang/String;)V", "platformLocale", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Landroidx/compose/ui/text/intl/PlatformLocale;)V", "language", "getLanguage", "()Ljava/lang/String;", "getPlatformLocale$ui_text_release", "()Landroidx/compose/ui/text/intl/PlatformLocale;", "region", "getRegion", "script", "getScript", "equals", "", "other", "hashCode", "", "toLanguageTag", "toString", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a bdB;
  public final f bdC;
  
  static
  {
    AppMethodBeat.i(205134);
    bdB = new a((byte)0);
    AppMethodBeat.o(205134);
  }
  
  public d(f paramf)
  {
    AppMethodBeat.i(205125);
    this.bdC = paramf;
    AppMethodBeat.o(205125);
  }
  
  public d(String paramString)
  {
    this(h.BM().ao(paramString));
    AppMethodBeat.i(205130);
    AppMethodBeat.o(205130);
  }
  
  public final String BH()
  {
    AppMethodBeat.i(205138);
    String str = this.bdC.BH();
    AppMethodBeat.o(205138);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205147);
    if (paramObject == null)
    {
      AppMethodBeat.o(205147);
      return false;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(205147);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(205147);
      return true;
    }
    boolean bool = s.p(BH(), ((d)paramObject).BH());
    AppMethodBeat.o(205147);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205153);
    int i = BH().hashCode();
    AppMethodBeat.o(205153);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205161);
    String str = BH();
    AppMethodBeat.o(205161);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/text/intl/Locale$Companion;", "", "()V", "current", "Landroidx/compose/ui/text/intl/Locale;", "getCurrent", "()Landroidx/compose/ui/text/intl/Locale;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static d BJ()
    {
      AppMethodBeat.i(205131);
      d locald = new d((f)h.BM().BI().get(0));
      AppMethodBeat.o(205131);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.d.d
 * JD-Core Version:    0.7.0.1
 */