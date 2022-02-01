package com.tencent.mm.plugin.finder.search;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.danmaku.f.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchLogic;", "", "()V", "DefaultHighLightWordReplaceStart", "", "FeedItemWidth", "", "getFeedItemWidth", "()I", "HighLightWordEnd", "getHighLightWordEnd", "()Ljava/lang/String;", "HighLightWordReplaceEnd", "getHighLightWordReplaceEnd", "HighLightWordReplaceStart", "getHighLightWordReplaceStart", "setHighLightWordReplaceStart", "(Ljava/lang/String;)V", "HighLightWordStart", "getHighLightWordStart", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "getFinderDataCache", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "setFinderDataCache", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;)V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "highLightFontColor", "getRemoveTextSize", "", "textPaint", "Landroid/text/TextPaint;", "removeTextSize", "", "processHighLight", "Landroid/text/Spanned;", "origin", "width", "removeHighLightTag", "plugin-finder_release"})
public final class j
{
  private static final String Acm = "<em class=\"highlight\">";
  private static final String Acn = "</em>";
  private static String Aco;
  private static final String Acp = "</font>";
  private static final int Acq;
  private static ass Acr;
  public static final j Acs;
  private static ConcurrentHashMap<Long, FinderItem> xLE;
  
  static
  {
    AppMethodBeat.i(166868);
    Acs = new j();
    Acm = "<em class=\"highlight\">";
    Acn = "</em>";
    Aco = "<font color=\"#06AD56\">";
    Acp = "</font>";
    Acq = a.kr(MMApplicationContext.getContext()) - a.fromDPToPix(MMApplicationContext.getContext(), 72);
    xLE = new ConcurrentHashMap();
    AppMethodBeat.o(166868);
  }
  
  public static Spanned a(String paramString1, TextPaint paramTextPaint, int paramInt, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(288390);
    p.k(paramString1, "origin");
    p.k(paramTextPaint, "textPaint");
    p.k(paramString2, "highLightFontColor");
    paramString2 = aEp(paramString2);
    paramString1 = (CharSequence)paramString1;
    paramString1 = (CharSequence)new k(Acm).e(paramString1, paramString2);
    Object localObject = Html.fromHtml(new k(Acn).e(paramString1, Acp));
    if ((paramTextPaint.measureText(localObject.toString()) > paramInt) && ((localObject instanceof SpannableStringBuilder)))
    {
      float f2 = paramInt;
      if (paramBoolean) {}
      int i;
      for (float f1 = paramTextPaint.getTextSize() * 2.0F;; f1 = 0.0F)
      {
        f1 = f2 - f1;
        f2 = paramTextPaint.measureText("…");
        paramInt = 0;
        int m = 0;
        i = 0;
        int k = 0;
        paramString1 = (ForegroundColorSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ForegroundColorSpan.class);
        if (paramString1 == null) {
          break;
        }
        int n = paramString1.length;
        int j = 0;
        paramInt = m;
        i = k;
        while (j < n)
        {
          paramString2 = paramString1[j];
          paramInt = ((Spanned)localObject).getSpanStart(paramString2);
          i = ((Spanned)localObject).getSpanEnd(paramString2);
          j += 1;
        }
      }
      if (i == 0)
      {
        AppMethodBeat.o(288390);
        return localObject;
      }
      float f3 = paramTextPaint.measureText((CharSequence)localObject, 0, paramInt);
      float f4 = paramTextPaint.measureText((CharSequence)localObject, paramInt, i);
      float f5 = paramTextPaint.measureText((CharSequence)localObject, i, ((Spanned)localObject).length());
      paramString2 = ((Spanned)localObject).subSequence(0, paramInt);
      paramString1 = ((Spanned)localObject).subSequence(paramInt, i);
      localObject = ((Spanned)localObject).subSequence(i, ((Spanned)localObject).length());
      if (f3 + f4 + f2 < f1)
      {
        paramString2 = new SpannableStringBuilder(paramString2);
        paramString2.append(paramString1);
        paramString2.append(TextUtils.ellipsize((CharSequence)localObject, paramTextPaint, f1 - f3 - f4, TextUtils.TruncateAt.END));
        paramString1 = (Spanned)paramString2;
        AppMethodBeat.o(288390);
        return paramString1;
      }
      if (f2 + f4 + f5 < f1)
      {
        localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(TextUtils.ellipsize(paramString2, paramTextPaint, f1 - f4 - f5, TextUtils.TruncateAt.START));
        localSpannableStringBuilder.append(paramString1);
        localSpannableStringBuilder.append((CharSequence)localObject);
        paramString1 = (Spanned)localSpannableStringBuilder;
        AppMethodBeat.o(288390);
        return paramString1;
      }
      if (f2 + f4 + f2 >= f1)
      {
        paramString2 = new SpannableStringBuilder();
        paramString2.append(TextUtils.ellipsize(paramString1, paramTextPaint, f1, TextUtils.TruncateAt.END));
        paramString1 = (Spanned)paramString2;
        AppMethodBeat.o(288390);
        return paramString1;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      f1 = (f1 - f4) / 2.0F;
      localSpannableStringBuilder.append(TextUtils.ellipsize(paramString2, paramTextPaint, f1, TextUtils.TruncateAt.START));
      localSpannableStringBuilder.append(paramString1);
      localSpannableStringBuilder.append(TextUtils.ellipsize((CharSequence)localObject, paramTextPaint, f1, TextUtils.TruncateAt.END));
      paramString1 = (Spanned)localSpannableStringBuilder;
      AppMethodBeat.o(288390);
      return paramString1;
    }
    p.j(localObject, "spanStr");
    AppMethodBeat.o(288390);
    return localObject;
  }
  
  public static void a(ass paramass)
  {
    Acr = paramass;
  }
  
  private static String aEp(String paramString)
  {
    AppMethodBeat.i(288395);
    Log.d("getHighLightWordReplaceStart", "getHighLightWordReplaceStart: ".concat(String.valueOf(paramString)));
    if (!d.fK(paramString))
    {
      paramString = "<font color=" + paramString + '>';
      AppMethodBeat.o(288395);
      return paramString;
    }
    AppMethodBeat.o(288395);
    return "<font color=\"#06AD56\">";
  }
  
  public static String aac(String paramString)
  {
    AppMethodBeat.i(166865);
    p.k(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new k(Acm).e(paramString, "");
    paramString = new k(Acn).e(paramString, "");
    AppMethodBeat.o(166865);
    return paramString;
  }
  
  public static Spanned bZ(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(288388);
    p.k(paramString1, "origin");
    p.k(paramString2, "highLightFontColor");
    paramString2 = aEp(paramString2);
    paramString1 = (CharSequence)paramString1;
    paramString1 = (CharSequence)new k(Acm).e(paramString1, paramString2);
    paramString1 = Html.fromHtml(new k(Acn).e(paramString1, Acp));
    if ((paramString1 instanceof SpannableStringBuilder))
    {
      paramString2 = (ForegroundColorSpan[])paramString1.getSpans(0, paramString1.length(), ForegroundColorSpan.class);
      if (paramString2 != null)
      {
        int j = paramString2.length;
        while (i < j)
        {
          Object localObject = paramString2[i];
          int k = paramString1.getSpanStart(localObject);
          int m = paramString1.getSpanEnd(localObject);
          Log.i("Finder.Hightlight", k + ' ' + m);
          i += 1;
        }
      }
    }
    p.j(paramString1, "spanStr");
    AppMethodBeat.o(288388);
    return paramString1;
  }
  
  public static int dRg()
  {
    return Acq;
  }
  
  public static ass dRh()
  {
    return Acr;
  }
  
  public static ConcurrentHashMap<Long, FinderItem> dRi()
  {
    return xLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.j
 * JD-Core Version:    0.7.0.1
 */