package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/SuggestionConverter;", "", "context", "Landroid/content/Context;", "isFullEnjoy", "", "forceNightMode", "(Landroid/content/Context;ZZ)V", "getContext", "()Landroid/content/Context;", "endTag", "", "getForceNightMode", "()Z", "originColor", "", "pattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "startTag", "suggestColor", "tagEndCount", "tagStartCount", "convertToSpan", "Landroid/text/SpannableString;", "suggestion", "Lcom/tencent/mm/protocal/protobuf/Suggestion;", "getSpan", "highLightColor", "normalColor", "highlightSuggest", "Companion", "plugin-finder_release"})
public final class n
{
  public static final a AcQ;
  private final String AcL;
  private final int AcM;
  private final int AcN;
  final int AcO;
  final int AcP;
  private final boolean Acc;
  private final Context context;
  private final Pattern oiE;
  private final String rLn;
  private final boolean zEV;
  
  static
  {
    AppMethodBeat.i(280822);
    AcQ = new a((byte)0);
    AppMethodBeat.o(280822);
  }
  
  public n(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(280821);
    this.context = paramContext;
    this.Acc = paramBoolean1;
    this.zEV = paramBoolean2;
    this.oiE = Pattern.compile("<em class=\"highlight\">\\S+</em>");
    this.AcL = "<em class=\"highlight\">";
    this.rLn = "</em>";
    this.AcM = this.AcL.length();
    this.AcN = this.rLn.length();
    int i;
    if (this.Acc) {
      if (this.zEV)
      {
        i = this.context.getResources().getColor(b.c.BW_100_Alpha_0_5);
        this.AcO = i;
        if (!this.Acc) {
          break label203;
        }
        i = this.context.getResources().getColor(b.c.BW_100_Alpha_0_8);
      }
    }
    for (;;)
    {
      this.AcP = i;
      AppMethodBeat.o(280821);
      return;
      i = this.context.getResources().getColor(b.c.BW_100_Alpha_0_5);
      break;
      if (this.zEV)
      {
        i = this.context.getResources().getColor(b.c.BW_100_Alpha_0_5);
        break;
      }
      i = this.context.getResources().getColor(b.c.FG_1);
      break;
      label203:
      if (this.zEV) {
        i = this.context.getResources().getColor(b.c.BW_100_Alpha_0_8);
      } else {
        i = this.context.getResources().getColor(b.c.FG_0);
      }
    }
  }
  
  final SpannableString c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(280820);
    Matcher localMatcher = this.oiE.matcher((CharSequence)paramString2);
    paramString1 = new SpannableString((CharSequence)paramString1);
    int i = 0;
    int j = 0;
    label538:
    for (;;)
    {
      int m;
      int k;
      int n;
      int i1;
      try
      {
        if (!localMatcher.find()) {
          break label443;
        }
        m = localMatcher.start();
        k = localMatcher.end();
        Log.i("Finder.SuggestionConverter", m + " - " + k);
        n = this.AcM;
        i1 = this.AcN;
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(280820);
          throw paramString1;
        }
      }
      catch (Exception paramString1)
      {
        Log.i("Finder.SuggestionConverter", "illegal analysis:".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(280820);
        return null;
      }
      String str = paramString2.substring(n + m, k - i1);
      p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (i == m)
      {
        Log.i("Finder.SuggestionConverter", "lastEndIndex == startIndex -- " + i + "; startspan:" + j + " endSpan:" + (str.length() + j));
        paramString1.setSpan(new ForegroundColorSpan(paramInt1), j, str.length() + j, 33);
        j += str.length();
        i = k;
      }
      else if (i < m)
      {
        Log.i("Finder.SuggestionConverter", "lastEndIndex < startIndex -- " + i + "; curSpanIndex:" + j + " endSpan:" + (j + m - i));
        paramString1.setSpan(new ForegroundColorSpan(paramInt2), j, j + m - i, 33);
        j += m - i;
        Log.i("Finder.SuggestionConverter", "lastEndIndex < startIndex -- " + i + "; curSpanIndex:" + j + " endSpan:" + (str.length() + j));
        paramString1.setSpan(new ForegroundColorSpan(paramInt1), j, str.length() + j, 33);
        j = str.length() + j;
        i = k;
        break label538;
        label443:
        if (i < paramString2.length())
        {
          Log.i("Finder.SuggestionConverter", "lastEndIndex < highlightSuggest.length -- " + i + "; curSpanIndex " + j + " - endSpan:" + (paramString2.length() - i + j));
          paramString1.setSpan(new ForegroundColorSpan(paramInt2), j, paramString2.length() - i + j, 33);
        }
        AppMethodBeat.o(280820);
        return paramString1;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/SuggestionConverter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.n
 * JD-Core Version:    0.7.0.1
 */