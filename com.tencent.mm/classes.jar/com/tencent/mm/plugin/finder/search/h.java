package com.tencent.mm.plugin.finder.search;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderSearchLogic;", "", "()V", "FeedItemWidth", "", "getFeedItemWidth", "()I", "HighLightWordEnd", "", "getHighLightWordEnd", "()Ljava/lang/String;", "HighLightWordReplaceEnd", "getHighLightWordReplaceEnd", "HighLightWordReplaceStart", "getHighLightWordReplaceStart", "HighLightWordStart", "getHighLightWordStart", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "getFinderDataCache", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "setFinderDataCache", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;)V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "processHighLight", "Landroid/text/Spanned;", "origin", "textPaint", "Landroid/text/TextPaint;", "width", "removeHighLightTag", "plugin-finder_release"})
public final class h
{
  private static final int rBA;
  private static ajw rBB;
  public static final h rBC;
  private static final String rBw = "<em class=\"highlight\">";
  private static final String rBx = "</em>";
  private static final String rBy = "<font color=\"#06AD56\">";
  private static final String rBz = "</font>";
  private static ConcurrentHashMap<Long, FinderItem> roF;
  
  static
  {
    AppMethodBeat.i(166868);
    rBC = new h();
    rBw = "<em class=\"highlight\">";
    rBx = "</em>";
    rBy = "<font color=\"#06AD56\">";
    rBz = "</font>";
    rBA = a.ig(ai.getContext()) - a.fromDPToPix(ai.getContext(), 72);
    roF = new ConcurrentHashMap();
    AppMethodBeat.o(166868);
  }
  
  public static Spanned a(String paramString, TextPaint paramTextPaint, int paramInt)
  {
    AppMethodBeat.i(166867);
    d.g.b.k.h(paramString, "origin");
    d.g.b.k.h(paramTextPaint, "textPaint");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new d.n.k(rBw).d(paramString, rBy);
    Object localObject2 = Html.fromHtml(new d.n.k(rBx).d(paramString, rBz));
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
    d.g.b.k.g(localObject2, "spanStr");
    AppMethodBeat.o(166867);
    return localObject2;
  }
  
  public static void a(ajw paramajw)
  {
    rBB = paramajw;
  }
  
  public static String adY(String paramString)
  {
    AppMethodBeat.i(166865);
    d.g.b.k.h(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new d.n.k(rBw).d(paramString, "");
    paramString = new d.n.k(rBx).d(paramString, "");
    AppMethodBeat.o(166865);
    return paramString;
  }
  
  public static Spanned adZ(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(166866);
    d.g.b.k.h(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new d.n.k(rBw).d(paramString, rBy);
    paramString = Html.fromHtml(new d.n.k(rBx).d(paramString, rBz));
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
          ac.i("Finder.Hightlight", k + ' ' + m);
          i += 1;
        }
      }
    }
    d.g.b.k.g(paramString, "spanStr");
    AppMethodBeat.o(166866);
    return paramString;
  }
  
  public static int cxR()
  {
    return rBA;
  }
  
  public static ajw cxS()
  {
    return rBB;
  }
  
  public static ConcurrentHashMap<Long, FinderItem> cxT()
  {
    return roF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.h
 * JD-Core Version:    0.7.0.1
 */