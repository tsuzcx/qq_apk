package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.view.i;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "TAG", "debugOriginalEntrance", "", "getDebugOriginalEntrance", "()Z", "setDebugOriginalEntrance", "(Z)V", "debugOriginalNeedCheck", "getDebugOriginalNeedCheck", "setDebugOriginalNeedCheck", "checkInsertOriginalRedDot", "", "checkPostNeedOriginal", "context", "Lcom/tencent/mm/ui/MMActivity;", "continuePost", "Lkotlin/Function0;", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"})
public final class k
{
  private static final String TAG = "Finder.FinderOriginalUtil";
  public static final k sLu;
  
  static
  {
    AppMethodBeat.i(204487);
    sLu = new k();
    TAG = "Finder.FinderOriginalUtil";
    AppMethodBeat.o(204487);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, TextView paramTextView, String paramString4)
  {
    AppMethodBeat.i(204482);
    p.h(paramContext, "context");
    p.h(paramString1, "h5url");
    p.h(paramString2, "allText");
    p.h(paramString3, "linkText");
    p.h(paramTextView, "descTv");
    p.h(paramString4, "logTag");
    int i = n.a((CharSequence)paramString2, paramString3, 0, false, 6);
    int j = i + paramString3.length();
    paramString3 = new SpannableString((CharSequence)paramString2);
    if ((i >= 0) && (j <= paramString2.length()))
    {
      paramString2 = aj.getContext();
      p.g(paramString2, "MMApplicationContext.getContext()");
      int k = paramString2.getResources().getColor(2131100547);
      paramString2 = aj.getContext();
      p.g(paramString2, "MMApplicationContext.getContext()");
      paramString3.setSpan(new i(paramString1, k, paramString2.getResources().getColor(2131099658), (b)new k.b(paramString4, paramContext)), i, j, 17);
    }
    paramTextView.setText((CharSequence)paramString3);
    paramTextView.setOnTouchListener((View.OnTouchListener)new k.a((Spannable)paramString3, paramTextView));
    AppMethodBeat.o(204482);
  }
  
  public static int cLn()
  {
    AppMethodBeat.i(204483);
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajl().get(al.a.IGF, Integer.valueOf(1));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(204483);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < 0)
    {
      AppMethodBeat.o(204483);
      return 0;
    }
    AppMethodBeat.o(204483);
    return i;
  }
  
  public static int cLo()
  {
    AppMethodBeat.i(204484);
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IGE, 0);
    AppMethodBeat.o(204484);
    return i;
  }
  
  public static boolean cLp()
  {
    AppMethodBeat.i(204485);
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajl().getInt(al.a.IGI, 0) > 0)
    {
      AppMethodBeat.o(204485);
      return true;
    }
    AppMethodBeat.o(204485);
    return false;
  }
  
  public static int cLq()
  {
    AppMethodBeat.i(204486);
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IGH, 0);
    AppMethodBeat.o(204486);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.k
 * JD-Core Version:    0.7.0.1
 */