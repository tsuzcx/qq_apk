package com.tencent.mm.plugin.finder.search;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchLogic;", "", "()V", "DefaultHighLightWordReplaceStart", "", "FeedItemWidth", "", "getFeedItemWidth", "()I", "HighLightWordEnd", "getHighLightWordEnd", "()Ljava/lang/String;", "HighLightWordReplaceEnd", "getHighLightWordReplaceEnd", "HighLightWordReplaceStart", "getHighLightWordReplaceStart", "setHighLightWordReplaceStart", "(Ljava/lang/String;)V", "HighLightWordStart", "getHighLightWordStart", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "getFinderDataCache", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "setFinderDataCache", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;)V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "highLightFontColor", "getRemoveTextSize", "", "textPaint", "Landroid/text/TextPaint;", "removeTextSize", "", "processHighLight", "Landroid/text/Spanned;", "origin", "width", "removeHighLightTag", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static ConcurrentHashMap<Long, FinderItem> BlP;
  public static final k FxZ;
  private static final String Fya;
  private static final String Fyb;
  private static String Fyc;
  private static final String Fyd;
  private static final int Fye;
  private static axg Fyf;
  
  static
  {
    AppMethodBeat.i(166868);
    FxZ = new k();
    Fya = "<em class=\"highlight\">";
    Fyb = "</em>";
    Fyc = "<font color=\"#06AD56\">";
    Fyd = "</font>";
    Fye = a.ms(MMApplicationContext.getContext()) - a.fromDPToPix(MMApplicationContext.getContext(), 72);
    BlP = new ConcurrentHashMap();
    AppMethodBeat.o(166868);
  }
  
  public static String Sp(String paramString)
  {
    AppMethodBeat.i(166865);
    s.u(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new kotlin.n.k(Fya).e(paramString, "");
    paramString = new kotlin.n.k(Fyb).e(paramString, "");
    AppMethodBeat.o(166865);
    return paramString;
  }
  
  public static Spanned a(String paramString1, TextPaint paramTextPaint, int paramInt, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(342549);
    s.u(paramString1, "origin");
    s.u(paramTextPaint, "textPaint");
    s.u(paramString2, "highLightFontColor");
    paramString2 = aAi(paramString2);
    paramString1 = (CharSequence)paramString1;
    paramString1 = (CharSequence)new kotlin.n.k(Fya).e(paramString1, paramString2);
    Object localObject = Html.fromHtml(new kotlin.n.k(Fyb).e(paramString1, Fyd));
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
        int j = 0;
        int n = paramString1.length;
        paramInt = m;
        for (i = k; j < n; i = ((Spanned)localObject).getSpanEnd(paramString2))
        {
          paramString2 = paramString1[j];
          j += 1;
          paramInt = ((Spanned)localObject).getSpanStart(paramString2);
        }
      }
      if (i == 0)
      {
        AppMethodBeat.o(342549);
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
        AppMethodBeat.o(342549);
        return paramString1;
      }
      if (f2 + f4 + f5 < f1)
      {
        localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(TextUtils.ellipsize(paramString2, paramTextPaint, f1 - f4 - f5, TextUtils.TruncateAt.START));
        localSpannableStringBuilder.append(paramString1);
        localSpannableStringBuilder.append((CharSequence)localObject);
        paramString1 = (Spanned)localSpannableStringBuilder;
        AppMethodBeat.o(342549);
        return paramString1;
      }
      if (f2 + f4 + f2 >= f1)
      {
        paramString2 = new SpannableStringBuilder();
        paramString2.append(TextUtils.ellipsize(paramString1, paramTextPaint, f1, TextUtils.TruncateAt.END));
        paramString1 = (Spanned)paramString2;
        AppMethodBeat.o(342549);
        return paramString1;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      f1 = (f1 - f4) / 2.0F;
      localSpannableStringBuilder.append(TextUtils.ellipsize(paramString2, paramTextPaint, f1, TextUtils.TruncateAt.START));
      localSpannableStringBuilder.append(paramString1);
      localSpannableStringBuilder.append(TextUtils.ellipsize((CharSequence)localObject, paramTextPaint, f1, TextUtils.TruncateAt.END));
      paramString1 = (Spanned)localSpannableStringBuilder;
      AppMethodBeat.o(342549);
      return paramString1;
    }
    s.s(localObject, "spanStr");
    AppMethodBeat.o(342549);
    return localObject;
  }
  
  public static void a(axg paramaxg)
  {
    Fyf = paramaxg;
  }
  
  private static String aAi(String paramString)
  {
    AppMethodBeat.i(342591);
    Log.d("getHighLightWordReplaceStart", s.X("getHighLightWordReplaceStart: ", paramString));
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = "<font color=" + paramString + '>';
      AppMethodBeat.o(342591);
      return paramString;
    }
    AppMethodBeat.o(342591);
    return "<font color=\"#06AD56\">";
  }
  
  public static Spanned cm(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(342527);
    s.u(paramString1, "origin");
    s.u(paramString2, "highLightFontColor");
    paramString2 = aAi(paramString2);
    paramString1 = (CharSequence)paramString1;
    paramString1 = (CharSequence)new kotlin.n.k(Fya).e(paramString1, paramString2);
    paramString1 = Html.fromHtml(new kotlin.n.k(Fyb).e(paramString1, Fyd));
    if ((paramString1 instanceof SpannableStringBuilder))
    {
      paramString2 = (ForegroundColorSpan[])paramString1.getSpans(0, paramString1.length(), ForegroundColorSpan.class);
      if (paramString2 != null)
      {
        int j = paramString2.length;
        while (i < j)
        {
          Object localObject = paramString2[i];
          i += 1;
          int k = paramString1.getSpanStart(localObject);
          int m = paramString1.getSpanEnd(localObject);
          Log.i("Finder.Hightlight", k + ' ' + m);
        }
      }
    }
    s.s(paramString1, "spanStr");
    AppMethodBeat.o(342527);
    return paramString1;
  }
  
  public static int ePd()
  {
    return Fye;
  }
  
  public static axg ePe()
  {
    return Fyf;
  }
  
  public static ConcurrentHashMap<Long, FinderItem> ePf()
  {
    return BlP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.k
 * JD-Core Version:    0.7.0.1
 */