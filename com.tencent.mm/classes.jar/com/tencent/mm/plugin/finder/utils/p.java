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
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "getORIGINAL_TERMS_URL", "()Ljava/lang/String;", "setORIGINAL_TERMS_URL", "(Ljava/lang/String;)V", "TAG", "debugOriginalNeedCheck", "", "getDebugOriginalNeedCheck", "()Z", "setDebugOriginalNeedCheck", "(Z)V", "checkInsertOriginalRedDot", "", "checkPostNeedOriginal", "context", "Lcom/tencent/mm/ui/MMActivity;", "continuePost", "Lkotlin/Function0;", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"})
public final class p
{
  public static final String TAG = "Finder.FinderOriginalUtil";
  private static String vVX;
  public static final p vVY;
  
  static
  {
    AppMethodBeat.i(253466);
    vVY = new p();
    TAG = "Finder.FinderOriginalUtil";
    vVX = "https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/readtemplate?t=finder_appeal";
    AppMethodBeat.o(253466);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, TextView paramTextView, String paramString4)
  {
    AppMethodBeat.i(253459);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString1, "h5url");
    kotlin.g.b.p.h(paramString2, "allText");
    kotlin.g.b.p.h(paramString3, "linkText");
    kotlin.g.b.p.h(paramTextView, "descTv");
    kotlin.g.b.p.h(paramString4, "logTag");
    int i = n.a((CharSequence)paramString2, paramString3, 0, false, 6);
    int j = i + paramString3.length();
    paramString3 = new SpannableString((CharSequence)paramString2);
    if ((i >= 0) && (j <= paramString2.length()))
    {
      paramString2 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(paramString2, "MMApplicationContext.getContext()");
      int k = paramString2.getResources().getColor(2131100685);
      paramString2 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(paramString2, "MMApplicationContext.getContext()");
      paramString3.setSpan(new com.tencent.mm.plugin.finder.view.l(paramString1, k, paramString2.getResources().getColor(2131099660), (kotlin.g.a.b)new p.b(paramString4, paramContext)), i, j, 17);
    }
    paramTextView.setText((CharSequence)paramString3);
    paramTextView.setOnTouchListener((View.OnTouchListener)new p.a((Spannable)paramString3, paramTextView));
    AppMethodBeat.o(253459);
  }
  
  public static String dBT()
  {
    return vVX;
  }
  
  public static int dBU()
  {
    AppMethodBeat.i(253460);
    Object localObject = g.aAh();
    kotlin.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.OjQ, Integer.valueOf(1));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(253460);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < 0)
    {
      AppMethodBeat.o(253460);
      return 0;
    }
    AppMethodBeat.o(253460);
    return i;
  }
  
  public static boolean dBV()
  {
    AppMethodBeat.i(253461);
    Object localObject = c.vCb;
    if (((Number)c.duA().value()).intValue() != 1)
    {
      localObject = g.aAh();
      kotlin.g.b.p.g(localObject, "MMKernel.storage()");
      if (!kotlin.g.b.p.j(((e)localObject).azQ().get(ar.a.OjU, Integer.valueOf(0)), Integer.valueOf(1))) {}
    }
    else
    {
      AppMethodBeat.o(253461);
      return true;
    }
    AppMethodBeat.o(253461);
    return false;
  }
  
  public static int dBW()
  {
    AppMethodBeat.i(253462);
    e locale = g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OjP, 0);
    AppMethodBeat.o(253462);
    return i;
  }
  
  public static boolean dBX()
  {
    AppMethodBeat.i(253463);
    e locale = g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    if (locale.azQ().getInt(ar.a.OjT, 0) > 0)
    {
      AppMethodBeat.o(253463);
      return true;
    }
    AppMethodBeat.o(253463);
    return false;
  }
  
  public static int dBY()
  {
    AppMethodBeat.i(253464);
    e locale = g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OjS, 0);
    AppMethodBeat.o(253464);
    return i;
  }
  
  public static boolean dBZ()
  {
    AppMethodBeat.i(253465);
    if (dBW() == 2)
    {
      AppMethodBeat.o(253465);
      return true;
    }
    AppMethodBeat.o(253465);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p
 * JD-Core Version:    0.7.0.1
 */