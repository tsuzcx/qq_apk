package com.tencent.mm.plugin.finder.search;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.n.k;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderSearchLogic;", "", "()V", "FeedItemWidth", "", "getFeedItemWidth", "()I", "HighLightWordEnd", "", "getHighLightWordEnd", "()Ljava/lang/String;", "HighLightWordReplaceEnd", "getHighLightWordReplaceEnd", "HighLightWordReplaceStart", "getHighLightWordReplaceStart", "HighLightWordStart", "getHighLightWordStart", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "getFinderDataCache", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "setFinderDataCache", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;)V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "processHighLight", "Landroid/text/Spanned;", "origin", "textPaint", "Landroid/text/TextPaint;", "width", "removeHighLightTag", "plugin-finder_release"})
public final class h
{
  private static final String sDY = "<em class=\"highlight\">";
  private static final String sDZ = "</em>";
  private static final String sEa = "<font color=\"#06AD56\">";
  private static final String sEb = "</font>";
  private static final int sEc;
  private static ang sEd;
  public static final h sEe;
  private static ConcurrentHashMap<Long, FinderItem> smf;
  
  static
  {
    AppMethodBeat.i(166868);
    sEe = new h();
    sDY = "<em class=\"highlight\">";
    sDZ = "</em>";
    sEa = "<font color=\"#06AD56\">";
    sEb = "</font>";
    sEc = a.iu(ak.getContext()) - a.fromDPToPix(ak.getContext(), 72);
    smf = new ConcurrentHashMap();
    AppMethodBeat.o(166868);
  }
  
  public static Spanned a(String paramString, TextPaint paramTextPaint, int paramInt)
  {
    AppMethodBeat.i(166867);
    p.h(paramString, "origin");
    p.h(paramTextPaint, "textPaint");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new k(sDY).e(paramString, sEa);
    Object localObject2 = Html.fromHtml(new k(sDZ).e(paramString, sEb));
    if ((paramTextPaint.measureText(localObject2.toString()) > paramInt) && ((localObject2 instanceof SpannableStringBuilder)))
    {
      float f1 = paramInt - paramTextPaint.getTextSize() * 2.0F;
      float f2 = paramTextPaint.measureText("…");
      paramString = (ForegroundColorSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), ForegroundColorSpan.class);
      if (paramString != null)
      {
        int k = paramString.length;
        int j = 0;
        i = 0;
        paramInt = 0;
        while (j < k)
        {
          localObject1 = paramString[j];
          paramInt = ((Spanned)localObject2).getSpanStart(localObject1);
          i = ((Spanned)localObject2).getSpanEnd(localObject1);
          j += 1;
        }
      }
      int i = 0;
      paramInt = 0;
      if (i == 0)
      {
        AppMethodBeat.o(166867);
        return localObject2;
      }
      float f3 = paramTextPaint.measureText((CharSequence)localObject2, 0, paramInt);
      float f4 = paramTextPaint.measureText((CharSequence)localObject2, paramInt, i);
      float f5 = paramTextPaint.measureText((CharSequence)localObject2, i, ((Spanned)localObject2).length());
      Object localObject1 = ((Spanned)localObject2).subSequence(0, paramInt);
      paramString = ((Spanned)localObject2).subSequence(paramInt, i);
      localObject2 = ((Spanned)localObject2).subSequence(i, ((Spanned)localObject2).length());
      if (f3 + f4 + f2 < f1)
      {
        localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject1).append(paramString);
        ((SpannableStringBuilder)localObject1).append(TextUtils.ellipsize((CharSequence)localObject2, paramTextPaint, f1 - f3 - f4, TextUtils.TruncateAt.END));
        paramString = (Spanned)localObject1;
        AppMethodBeat.o(166867);
        return paramString;
      }
      if (f2 + f4 + f5 < f1)
      {
        localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(TextUtils.ellipsize((CharSequence)localObject1, paramTextPaint, f1 - f4 - f5, TextUtils.TruncateAt.START));
        localSpannableStringBuilder.append(paramString);
        localSpannableStringBuilder.append((CharSequence)localObject2);
        paramString = (Spanned)localSpannableStringBuilder;
        AppMethodBeat.o(166867);
        return paramString;
      }
      if (f2 + f4 + f2 >= f1)
      {
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(TextUtils.ellipsize(paramString, paramTextPaint, f1, TextUtils.TruncateAt.END));
        paramString = (Spanned)localObject1;
        AppMethodBeat.o(166867);
        return paramString;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      f1 = (f1 - f4) / 2.0F;
      localSpannableStringBuilder.append(TextUtils.ellipsize((CharSequence)localObject1, paramTextPaint, f1, TextUtils.TruncateAt.START));
      localSpannableStringBuilder.append(paramString);
      localSpannableStringBuilder.append(TextUtils.ellipsize((CharSequence)localObject2, paramTextPaint, f1, TextUtils.TruncateAt.END));
      paramString = (Spanned)localSpannableStringBuilder;
      AppMethodBeat.o(166867);
      return paramString;
    }
    p.g(localObject2, "spanStr");
    AppMethodBeat.o(166867);
    return localObject2;
  }
  
  public static void a(ang paramang)
  {
    sEd = paramang;
  }
  
  public static String aiV(String paramString)
  {
    AppMethodBeat.i(166865);
    p.h(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new k(sDY).e(paramString, "");
    paramString = new k(sDZ).e(paramString, "");
    AppMethodBeat.o(166865);
    return paramString;
  }
  
  public static Spanned aiW(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(166866);
    p.h(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new k(sDY).e(paramString, sEa);
    paramString = Html.fromHtml(new k(sDZ).e(paramString, sEb));
    if ((paramString instanceof SpannableStringBuilder))
    {
      ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])paramString.getSpans(0, paramString.length(), ForegroundColorSpan.class);
      if (arrayOfForegroundColorSpan != null)
      {
        int j = arrayOfForegroundColorSpan.length;
        while (i < j)
        {
          ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[i];
          int k = paramString.getSpanStart(localForegroundColorSpan);
          int m = paramString.getSpanEnd(localForegroundColorSpan);
          ae.i("Finder.Hightlight", k + ' ' + m);
          i += 1;
        }
      }
    }
    p.g(paramString, "spanStr");
    AppMethodBeat.o(166866);
    return paramString;
  }
  
  public static int cGK()
  {
    return sEc;
  }
  
  public static ang cGL()
  {
    return sEd;
  }
  
  public static ConcurrentHashMap<Long, FinderItem> cGM()
  {
    return smf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.h
 * JD-Core Version:    0.7.0.1
 */