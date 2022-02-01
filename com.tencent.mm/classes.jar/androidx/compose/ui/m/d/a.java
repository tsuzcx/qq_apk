package androidx.compose.ui.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/intl/AndroidLocale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "javaLocale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "getJavaLocale", "()Ljava/util/Locale;", "language", "", "getLanguage", "()Ljava/lang/String;", "region", "getRegion", "script", "getScript", "toLanguageTag", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f
{
  public final Locale bdA;
  
  public a(Locale paramLocale)
  {
    AppMethodBeat.i(205122);
    this.bdA = paramLocale;
    AppMethodBeat.o(205122);
  }
  
  public final String BH()
  {
    AppMethodBeat.i(205127);
    String str = this.bdA.toLanguageTag();
    s.s(str, "javaLocale.toLanguageTag()");
    AppMethodBeat.o(205127);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.d.a
 * JD-Core Version:    0.7.0.1
 */