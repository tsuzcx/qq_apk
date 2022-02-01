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
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderSearchLogic;", "", "()V", "FeedItemWidth", "", "getFeedItemWidth", "()I", "HighLightWordEnd", "", "getHighLightWordEnd", "()Ljava/lang/String;", "HighLightWordReplaceEnd", "getHighLightWordReplaceEnd", "HighLightWordReplaceStart", "getHighLightWordReplaceStart", "HighLightWordStart", "getHighLightWordStart", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "getFinderDataCache", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "setFinderDataCache", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;)V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "processHighLight", "Landroid/text/Spanned;", "origin", "textPaint", "Landroid/text/TextPaint;", "width", "removeHighLightTag", "plugin-finder_release"})
public final class i
{
  private static ConcurrentHashMap<Long, FinderItem> tZo;
  private static final String vvo = "<em class=\"highlight\">";
  private static final String vvp = "</em>";
  private static final String vvq = "<font color=\"#06AD56\">";
  private static final String vvr = "</font>";
  private static final int vvs;
  private static aqw vvt;
  public static final i vvu;
  
  static
  {
    AppMethodBeat.i(166868);
    vvu = new i();
    vvo = "<em class=\"highlight\">";
    vvp = "</em>";
    vvq = "<font color=\"#06AD56\">";
    vvr = "</font>";
    vvs = a.jn(MMApplicationContext.getContext()) - a.fromDPToPix(MMApplicationContext.getContext(), 72);
    tZo = new ConcurrentHashMap();
    AppMethodBeat.o(166868);
  }
  
  public static Spanned a(String paramString, TextPaint paramTextPaint, int paramInt)
  {
    AppMethodBeat.i(166867);
    p.h(paramString, "origin");
    p.h(paramTextPaint, "textPaint");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new k(vvo).e(paramString, vvq);
    Object localObject2 = Html.fromHtml(new k(vvp).e(paramString, vvr));
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
  
  public static void a(aqw paramaqw)
  {
    vvt = paramaqw;
  }
  
  public static String auY(String paramString)
  {
    AppMethodBeat.i(166865);
    p.h(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new k(vvo).e(paramString, "");
    paramString = new k(vvp).e(paramString, "");
    AppMethodBeat.o(166865);
    return paramString;
  }
  
  public static Spanned auZ(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(166866);
    p.h(paramString, "origin");
    paramString = (CharSequence)paramString;
    paramString = (CharSequence)new k(vvo).e(paramString, vvq);
    paramString = Html.fromHtml(new k(vvp).e(paramString, vvr));
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
          Log.i("Finder.Hightlight", k + ' ' + m);
          i += 1;
        }
      }
    }
    p.g(paramString, "spanStr");
    AppMethodBeat.o(166866);
    return paramString;
  }
  
  public static int dpZ()
  {
    return vvs;
  }
  
  public static aqw dqa()
  {
    return vvt;
  }
  
  public static ConcurrentHashMap<Long, FinderItem> dqb()
  {
    return tZo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.i
 * JD-Core Version:    0.7.0.1
 */