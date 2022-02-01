package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/SuggestionConverter;", "", "context", "Landroid/content/Context;", "isFullEnjoy", "", "forceNightMode", "(Landroid/content/Context;ZZ)V", "getContext", "()Landroid/content/Context;", "endTag", "", "getForceNightMode", "()Z", "originColor", "", "pattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "startTag", "suggestColor", "tagEndCount", "tagStartCount", "convertToSpan", "Landroid/text/SpannableString;", "suggestion", "Lcom/tencent/mm/protocal/protobuf/Suggestion;", "getSpan", "highLightColor", "normalColor", "highlightSuggest", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final a Fyx;
  private final boolean ANb;
  private final boolean FxW;
  private final int FyA;
  final int FyB;
  final int FyC;
  private final String Fyy;
  private final int Fyz;
  private final Context context;
  private final Pattern rmg;
  private final String uWB;
  
  static
  {
    AppMethodBeat.i(342538);
    Fyx = new a((byte)0);
    AppMethodBeat.o(342538);
  }
  
  public o(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(342532);
    this.context = paramContext;
    this.FxW = paramBoolean1;
    this.ANb = paramBoolean2;
    this.rmg = Pattern.compile("<em class=\"highlight\">\\S+</em>");
    this.Fyy = "<em class=\"highlight\">";
    this.uWB = "</em>";
    this.Fyz = this.Fyy.length();
    this.FyA = this.uWB.length();
    int i;
    if (this.FxW) {
      if (this.ANb)
      {
        i = this.context.getResources().getColor(e.b.BW_100_Alpha_0_5);
        this.FyB = i;
        if (!this.FxW) {
          break label203;
        }
        i = this.context.getResources().getColor(e.b.BW_100_Alpha_0_8);
      }
    }
    for (;;)
    {
      this.FyC = i;
      AppMethodBeat.o(342532);
      return;
      i = this.context.getResources().getColor(e.b.BW_100_Alpha_0_5);
      break;
      if (this.ANb)
      {
        i = this.context.getResources().getColor(e.b.BW_100_Alpha_0_5);
        break;
      }
      i = this.context.getResources().getColor(e.b.FG_1);
      break;
      label203:
      if (this.ANb) {
        i = this.context.getResources().getColor(e.b.BW_100_Alpha_0_8);
      } else {
        i = this.context.getResources().getColor(e.b.FG_0);
      }
    }
  }
  
  final SpannableString d(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(342557);
    Matcher localMatcher = this.rmg.matcher((CharSequence)paramString2);
    paramString1 = new SpannableString((CharSequence)paramString1);
    int i = 0;
    int j = 0;
    for (;;)
    {
      int m;
      int k;
      int n;
      int i1;
      try
      {
        if (!localMatcher.find()) {
          break;
        }
        m = localMatcher.start();
        k = localMatcher.end();
        Log.i("Finder.SuggestionConverter", m + " - " + k);
        n = this.Fyz;
        i1 = this.FyA;
        if (paramString2 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(342557);
          throw paramString1;
        }
      }
      catch (Exception paramString1)
      {
        Log.i("Finder.SuggestionConverter", s.X("illegal analysis:", paramString1));
        AppMethodBeat.o(342557);
        return null;
      }
      String str = paramString2.substring(n + m, k - i1);
      s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
        j += str.length();
        i = k;
      }
    }
    if (i < paramString2.length())
    {
      Log.i("Finder.SuggestionConverter", "lastEndIndex < highlightSuggest.length -- " + i + "; curSpanIndex " + j + " - endSpan:" + (paramString2.length() - i + j));
      paramString1.setSpan(new ForegroundColorSpan(paramInt2), j, paramString2.length() - i + j, 33);
    }
    AppMethodBeat.o(342557);
    return paramString1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/SuggestionConverter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.o
 * JD-Core Version:    0.7.0.1
 */