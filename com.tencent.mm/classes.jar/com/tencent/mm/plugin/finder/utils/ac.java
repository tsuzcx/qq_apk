package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "getORIGINAL_TERMS_URL", "()Ljava/lang/String;", "setORIGINAL_TERMS_URL", "(Ljava/lang/String;)V", "TAG", "debugOriginalNeedCheck", "", "getDebugOriginalNeedCheck", "()Z", "setDebugOriginalNeedCheck", "(Z)V", "checkInsertOriginalRedDot", "", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "context", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac Ghd;
  private static String Ghe;
  public static final String TAG;
  
  static
  {
    AppMethodBeat.i(333552);
    Ghd = new ac();
    TAG = "Finder.FinderOriginalUtil";
    Ghe = "https://" + WeChatHosts.domainString(e.h.host_weixin_qq_com) + "/cgi-bin/readtemplate?t=finder_appeal";
    AppMethodBeat.o(333552);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, TextView paramTextView, String paramString4)
  {
    AppMethodBeat.i(333489);
    s.u(paramContext, "context");
    s.u(paramString1, "h5url");
    s.u(paramString2, "allText");
    s.u(paramString3, "linkText");
    s.u(paramTextView, "descTv");
    s.u(paramString4, "logTag");
    int i = n.a((CharSequence)paramString2, paramString3, 0, false, 6);
    int j = i + paramString3.length();
    paramString3 = new SpannableString((CharSequence)paramString2);
    if ((i >= 0) && (j <= paramString2.length())) {
      paramString3.setSpan(new q(paramString1, MMApplicationContext.getContext().getResources().getColor(e.b.link_color), MMApplicationContext.getContext().getResources().getColor(e.b.BW_0_Alpha_0_2), (kotlin.g.a.b)new ac.a(paramString4, paramContext)), i, j, 17);
    }
    paramTextView.setText((CharSequence)paramString3);
    paramTextView.setOnTouchListener(new ac..ExternalSyntheticLambda0((Spannable)paramString3, paramTextView));
    AppMethodBeat.o(333489);
  }
  
  private static final boolean a(Spannable paramSpannable, TextView paramTextView, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(333543);
    s.u(paramSpannable, "$text");
    s.u(paramTextView, "$tv");
    int j = paramMotionEvent.getAction();
    if (paramView == null)
    {
      paramSpannable = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(333543);
      throw paramSpannable;
    }
    paramView = (TextView)paramView;
    switch (j)
    {
    case 2: 
    default: 
      switch (j)
      {
      }
      break;
    }
    for (;;)
    {
      boolean bool = false;
      Log.i(TAG, "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
      AppMethodBeat.o(333543);
      return bool;
      Object localObject1 = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
      if (localObject1 == null) {
        break;
      }
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof t))
        {
          ((t)localObject2).setIsPressed(false);
          paramTextView.invalidate();
        }
        i += 1;
      }
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      int m = paramView.getTotalPaddingLeft();
      int n = paramView.getTotalPaddingTop();
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      localObject1 = paramView.getLayout();
      i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
      localObject1 = (ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class);
      if (localObject1.length != 0)
      {
        localObject1 = localObject1[0];
        switch (j)
        {
        }
        for (;;)
        {
          bool = true;
          break;
          ((ClickableSpan)localObject1).onClick((View)paramView);
          continue;
          if ((localObject1 instanceof t))
          {
            ((t)localObject1).setIsPressed(true);
            paramTextView.invalidate();
          }
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject1), paramSpannable.getSpanEnd(localObject1));
        }
      }
      Selection.removeSelection(paramSpannable);
    }
  }
  
  public static String feY()
  {
    return Ghe;
  }
  
  public static int feZ()
  {
    AppMethodBeat.i(333496);
    Object localObject = h.baE().ban().get(at.a.adah, Integer.valueOf(1));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(333496);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < 0)
    {
      AppMethodBeat.o(333496);
      return 0;
    }
    AppMethodBeat.o(333496);
    return i;
  }
  
  public static boolean ffa()
  {
    AppMethodBeat.i(333505);
    d locald = d.FAy;
    if ((((Number)d.eUk().bmg()).intValue() == 1) || (s.p(h.baE().ban().get(at.a.adal, Integer.valueOf(0)), Integer.valueOf(1))))
    {
      AppMethodBeat.o(333505);
      return true;
    }
    AppMethodBeat.o(333505);
    return false;
  }
  
  public static int ffb()
  {
    AppMethodBeat.i(333511);
    int i = h.baE().ban().getInt(at.a.adag, 0);
    AppMethodBeat.o(333511);
    return i;
  }
  
  public static boolean ffc()
  {
    AppMethodBeat.i(333516);
    if (h.baE().ban().getInt(at.a.adak, 0) > 0)
    {
      AppMethodBeat.o(333516);
      return true;
    }
    AppMethodBeat.o(333516);
    return false;
  }
  
  public static int ffd()
  {
    AppMethodBeat.i(333520);
    int i = h.baE().ban().getInt(at.a.adaj, 0);
    AppMethodBeat.o(333520);
    return i;
  }
  
  public static boolean ffe()
  {
    AppMethodBeat.i(333526);
    if (ffb() == 2)
    {
      AppMethodBeat.o(333526);
      return true;
    }
    AppMethodBeat.o(333526);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ac
 * JD-Core Version:    0.7.0.1
 */