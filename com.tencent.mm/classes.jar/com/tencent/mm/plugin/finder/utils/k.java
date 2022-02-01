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
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "TAG", "debugOriginalNeedCheck", "", "getDebugOriginalNeedCheck", "()Z", "setDebugOriginalNeedCheck", "(Z)V", "checkInsertOriginalRedDot", "", "checkPostNeedOriginal", "context", "Lcom/tencent/mm/ui/MMActivity;", "continuePost", "Lkotlin/Function0;", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"})
public final class k
{
  public static final String TAG = "Finder.FinderOriginalUtil";
  public static final k sWF;
  
  static
  {
    AppMethodBeat.i(205107);
    sWF = new k();
    TAG = "Finder.FinderOriginalUtil";
    AppMethodBeat.o(205107);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, final TextView paramTextView, String paramString4)
  {
    AppMethodBeat.i(205100);
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
      paramString2 = ak.getContext();
      p.g(paramString2, "MMApplicationContext.getContext()");
      int k = paramString2.getResources().getColor(2131100547);
      paramString2 = ak.getContext();
      p.g(paramString2, "MMApplicationContext.getContext()");
      paramString3.setSpan(new j(paramString1, k, paramString2.getResources().getColor(2131099658), (d.g.a.b)new k.b(paramString4, paramContext)), i, j, 17);
    }
    paramTextView.setText((CharSequence)paramString3);
    paramTextView.setOnTouchListener((View.OnTouchListener)new a((Spannable)paramString3, paramTextView));
    AppMethodBeat.o(205100);
  }
  
  public static int cNR()
  {
    AppMethodBeat.i(205101);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.Jbf, Integer.valueOf(1));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(205101);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < 0)
    {
      AppMethodBeat.o(205101);
      return 0;
    }
    AppMethodBeat.o(205101);
    return i;
  }
  
  public static boolean cNS()
  {
    AppMethodBeat.i(205102);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKG().value()).intValue() != 1)
    {
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      if (!p.i(((e)localObject).ajA().get(am.a.Jbj, Integer.valueOf(0)), Integer.valueOf(1))) {}
    }
    else
    {
      AppMethodBeat.o(205102);
      return true;
    }
    AppMethodBeat.o(205102);
    return false;
  }
  
  public static int cNT()
  {
    AppMethodBeat.i(205103);
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.Jbe, 0);
    AppMethodBeat.o(205103);
    return i;
  }
  
  public static boolean cNU()
  {
    AppMethodBeat.i(205104);
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajA().getInt(am.a.Jbi, 0) > 0)
    {
      AppMethodBeat.o(205104);
      return true;
    }
    AppMethodBeat.o(205104);
    return false;
  }
  
  public static int cNV()
  {
    AppMethodBeat.i(205105);
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.Jbh, 0);
    AppMethodBeat.o(205105);
    return i;
  }
  
  public static boolean cNW()
  {
    AppMethodBeat.i(205106);
    if (cNT() == 2)
    {
      AppMethodBeat.o(205106);
      return true;
    }
    AppMethodBeat.o(205106);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class a
    implements View.OnTouchListener
  {
    a(Spannable paramSpannable, TextView paramTextView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205098);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramMotionEvent);
      a.b("com/tencent/mm/plugin/finder/utils/FinderOriginalUtil$setSpanTouch$touchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      p.g(paramMotionEvent, "event");
      int j = paramMotionEvent.getAction();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(205098);
        throw paramView;
      }
      paramView = (TextView)paramView;
      localObject1 = this.sMT;
      Object localObject2;
      int k;
      int i;
      if ((j == 1) || (j == 3))
      {
        localObject2 = (ClickableSpan[])((Spannable)localObject1).getSpans(0, this.sMT.length(), ClickableSpan.class);
        if (localObject2 != null)
        {
          k = localObject2.length;
          i = 0;
          while (i < k)
          {
            Object localObject3 = localObject2[i];
            if ((localObject3 instanceof o))
            {
              ((o)localObject3).setIsPressed(false);
              paramTextView.invalidate();
            }
            i += 1;
          }
        }
      }
      if ((j == 1) || (j == 0))
      {
        i = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        int m = paramView.getTotalPaddingLeft();
        int n = paramView.getTotalPaddingTop();
        int i1 = paramView.getScrollX();
        int i2 = paramView.getScrollY();
        localObject2 = paramView.getLayout();
        i = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(k - n + i2), i - m + i1);
        localObject2 = (ClickableSpan[])((Spannable)localObject1).getSpans(i, i, ClickableSpan.class);
        if (localObject2.length != 0)
        {
          localObject2 = localObject2[0];
          if (j == 1) {
            ((ClickableSpan)localObject2).onClick((View)paramView);
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramView = k.sWF;
        ae.i(k.cNX(), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
        a.a(bool, this, "com/tencent/mm/plugin/finder/utils/FinderOriginalUtil$setSpanTouch$touchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205098);
        return bool;
        if (j != 0) {
          break;
        }
        if ((localObject2 instanceof o))
        {
          ((o)localObject2).setIsPressed(true);
          paramTextView.invalidate();
        }
        Selection.setSelection((Spannable)localObject1, ((Spannable)localObject1).getSpanStart(localObject2), ((Spannable)localObject1).getSpanEnd(localObject2));
        break;
        Selection.removeSelection((Spannable)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.k
 * JD-Core Version:    0.7.0.1
 */