package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "TAG", "debugOriginalEntrance", "", "getDebugOriginalEntrance", "()Z", "setDebugOriginalEntrance", "(Z)V", "debugOriginalNeedCheck", "getDebugOriginalNeedCheck", "setDebugOriginalNeedCheck", "checkInsertOriginalRedDot", "", "checkPostNeedOriginal", "context", "Lcom/tencent/mm/ui/MMActivity;", "continuePost", "Lkotlin/Function0;", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"})
public final class j
{
  private static final String TAG = "Finder.FinderOriginalUtil";
  public static final j rOX;
  
  static
  {
    AppMethodBeat.i(203617);
    rOX = new j();
    TAG = "Finder.FinderOriginalUtil";
    AppMethodBeat.o(203617);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, TextView paramTextView, String paramString4)
  {
    AppMethodBeat.i(203612);
    k.h(paramContext, "context");
    k.h(paramString1, "h5url");
    k.h(paramString2, "allText");
    k.h(paramString3, "linkText");
    k.h(paramTextView, "descTv");
    k.h(paramString4, "logTag");
    int i = n.a((CharSequence)paramString2, paramString3, 0, false, 6);
    int j = i + paramString3.length();
    paramString3 = new SpannableString((CharSequence)paramString2);
    if ((i >= 0) && (j <= paramString2.length()))
    {
      paramString2 = ai.getContext();
      k.g(paramString2, "MMApplicationContext.getContext()");
      int k = paramString2.getResources().getColor(2131100547);
      paramString2 = ai.getContext();
      k.g(paramString2, "MMApplicationContext.getContext()");
      paramString3.setSpan(new com.tencent.mm.plugin.finder.view.g(paramString1, k, paramString2.getResources().getColor(2131099658), (b)new j.b(paramString4, paramContext)), i, j, 17);
    }
    paramTextView.setText((CharSequence)paramString3);
    paramTextView.setOnTouchListener((View.OnTouchListener)new j.a((Spannable)paramString3, paramTextView));
    AppMethodBeat.o(203612);
  }
  
  public static int cCW()
  {
    AppMethodBeat.i(203613);
    Object localObject = com.tencent.mm.kernel.g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GTZ, Integer.valueOf(1));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(203613);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < 0)
    {
      AppMethodBeat.o(203613);
      return 0;
    }
    AppMethodBeat.o(203613);
    return i;
  }
  
  public static int cCX()
  {
    AppMethodBeat.i(203614);
    e locale = com.tencent.mm.kernel.g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GTY, 0);
    AppMethodBeat.o(203614);
    return i;
  }
  
  public static boolean cCY()
  {
    AppMethodBeat.i(203615);
    e locale = com.tencent.mm.kernel.g.agR();
    k.g(locale, "MMKernel.storage()");
    if (locale.agA().getInt(ah.a.GUc, 0) > 0)
    {
      AppMethodBeat.o(203615);
      return true;
    }
    AppMethodBeat.o(203615);
    return false;
  }
  
  public static int cCZ()
  {
    AppMethodBeat.i(203616);
    e locale = com.tencent.mm.kernel.g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GUb, 0);
    AppMethodBeat.o(203616);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.j
 * JD-Core Version:    0.7.0.1
 */