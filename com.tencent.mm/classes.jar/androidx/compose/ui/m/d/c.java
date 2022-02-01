package androidx.compose.ui.m.d;

import android.os.LocaleList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI24;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", "current", "", "Landroidx/compose/ui/text/intl/PlatformLocale;", "getCurrent", "()Ljava/util/List;", "parseLanguageTag", "languageTag", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements g
{
  public final List<f> BI()
  {
    AppMethodBeat.i(205121);
    LocaleList localLocaleList = LocaleList.getDefault();
    s.s(localLocaleList, "getDefault()");
    List localList = (List)new ArrayList();
    int i = 0;
    int k = localLocaleList.size();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Locale localLocale = localLocaleList.get(i);
      s.s(localLocale, "localeList[i]");
      localList.add(new a(localLocale));
      if (j >= k)
      {
        AppMethodBeat.o(205121);
        return localList;
      }
      i = j;
    }
  }
  
  public final f ao(String paramString)
  {
    AppMethodBeat.i(205128);
    s.u(paramString, "languageTag");
    paramString = Locale.forLanguageTag(paramString);
    s.s(paramString, "forLanguageTag(languageTag)");
    paramString = (f)new a(paramString);
    AppMethodBeat.o(205128);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.d.c
 * JD-Core Version:    0.7.0.1
 */