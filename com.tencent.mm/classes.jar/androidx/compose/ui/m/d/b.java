package androidx.compose.ui.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI23;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", "current", "", "Landroidx/compose/ui/text/intl/PlatformLocale;", "getCurrent", "()Ljava/util/List;", "parseLanguageTag", "languageTag", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements g
{
  public final List<f> BI()
  {
    AppMethodBeat.i(205118);
    Object localObject = Locale.getDefault();
    s.s(localObject, "getDefault()");
    localObject = p.listOf(new a((Locale)localObject));
    AppMethodBeat.o(205118);
    return localObject;
  }
  
  public final f ao(String paramString)
  {
    AppMethodBeat.i(205124);
    s.u(paramString, "languageTag");
    paramString = Locale.forLanguageTag(paramString);
    s.s(paramString, "forLanguageTag(languageTag)");
    paramString = (f)new a(paramString);
    AppMethodBeat.o(205124);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.d.b
 * JD-Core Version:    0.7.0.1
 */