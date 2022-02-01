package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "getORIGINAL_TERMS_URL", "()Ljava/lang/String;", "setORIGINAL_TERMS_URL", "(Ljava/lang/String;)V", "TAG", "debugOriginalNeedCheck", "", "getDebugOriginalNeedCheck", "()Z", "setDebugOriginalNeedCheck", "(Z)V", "checkInsertOriginalRedDot", "", "checkPostNeedOriginal", "context", "Lcom/tencent/mm/ui/MMActivity;", "continuePost", "Lkotlin/Function0;", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"})
public final class v
{
  private static String ADU;
  public static final v ADV;
  public static final String TAG = "Finder.FinderOriginalUtil";
  
  static
  {
    AppMethodBeat.i(267414);
    ADV = new v();
    TAG = "Finder.FinderOriginalUtil";
    ADU = "https://" + WeChatHosts.domainString(b.j.host_weixin_qq_com) + "/cgi-bin/readtemplate?t=finder_appeal";
    AppMethodBeat.o(267414);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, TextView paramTextView, String paramString4)
  {
    AppMethodBeat.i(267407);
    p.k(paramContext, "context");
    p.k(paramString1, "h5url");
    p.k(paramString2, "allText");
    p.k(paramString3, "linkText");
    p.k(paramTextView, "descTv");
    p.k(paramString4, "logTag");
    int i = n.a((CharSequence)paramString2, paramString3, 0, false, 6);
    int j = i + paramString3.length();
    paramString3 = new SpannableString((CharSequence)paramString2);
    if ((i >= 0) && (j <= paramString2.length()))
    {
      paramString2 = MMApplicationContext.getContext();
      p.j(paramString2, "MMApplicationContext.getContext()");
      int k = paramString2.getResources().getColor(b.c.link_color);
      paramString2 = MMApplicationContext.getContext();
      p.j(paramString2, "MMApplicationContext.getContext()");
      paramString3.setSpan(new o(paramString1, k, paramString2.getResources().getColor(b.c.BW_0_Alpha_0_2), (kotlin.g.a.b)new v.b(paramString4, paramContext)), i, j, 17);
    }
    paramTextView.setText((CharSequence)paramString3);
    paramTextView.setOnTouchListener((View.OnTouchListener)new v.a((Spannable)paramString3, paramTextView));
    AppMethodBeat.o(267407);
  }
  
  public static String edh()
  {
    return ADU;
  }
  
  public static int edi()
  {
    AppMethodBeat.i(267408);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.Vym, Integer.valueOf(1));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(267408);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < 0)
    {
      AppMethodBeat.o(267408);
      return 0;
    }
    AppMethodBeat.o(267408);
    return i;
  }
  
  public static boolean edj()
  {
    AppMethodBeat.i(267409);
    Object localObject = d.AjH;
    if (((Number)d.dVI().aSr()).intValue() != 1)
    {
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      if (!p.h(((f)localObject).aHp().get(ar.a.Vyq, Integer.valueOf(0)), Integer.valueOf(1))) {}
    }
    else
    {
      AppMethodBeat.o(267409);
      return true;
    }
    AppMethodBeat.o(267409);
    return false;
  }
  
  public static int edk()
  {
    AppMethodBeat.i(267410);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.Vyl, 0);
    AppMethodBeat.o(267410);
    return i;
  }
  
  public static boolean edl()
  {
    AppMethodBeat.i(267411);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    if (localf.aHp().getInt(ar.a.Vyp, 0) > 0)
    {
      AppMethodBeat.o(267411);
      return true;
    }
    AppMethodBeat.o(267411);
    return false;
  }
  
  public static int edm()
  {
    AppMethodBeat.i(267412);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.Vyo, 0);
    AppMethodBeat.o(267412);
    return i;
  }
  
  public static boolean edn()
  {
    AppMethodBeat.i(267413);
    if (edk() == 2)
    {
      AppMethodBeat.o(267413);
      return true;
    }
    AppMethodBeat.o(267413);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.v
 * JD-Core Version:    0.7.0.1
 */