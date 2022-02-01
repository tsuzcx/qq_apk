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
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.a.b;
import d.g.b.k;
import d.n.n;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "TAG", "debugOriginalEntrance", "", "getDebugOriginalEntrance", "()Z", "setDebugOriginalEntrance", "(Z)V", "debugOriginalNeedCheck", "getDebugOriginalNeedCheck", "setDebugOriginalNeedCheck", "checkInsertOriginalRedDot", "", "checkPostNeedOriginal", "context", "Lcom/tencent/mm/ui/MMActivity;", "continuePost", "Lkotlin/Function0;", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"})
public final class q
{
  public static final q LaJ;
  private static final String TAG = "Finder.FinderOriginalUtil";
  
  static
  {
    AppMethodBeat.i(199641);
    LaJ = new q();
    TAG = "Finder.FinderOriginalUtil";
    AppMethodBeat.o(199641);
  }
  
  public static void a(final Context paramContext, String paramString1, String paramString2, String paramString3, final TextView paramTextView, String paramString4)
  {
    AppMethodBeat.i(199636);
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
      paramString2 = aj.getContext();
      k.g(paramString2, "MMApplicationContext.getContext()");
      int k = paramString2.getResources().getColor(2131100547);
      paramString2 = aj.getContext();
      k.g(paramString2, "MMApplicationContext.getContext()");
      paramString3.setSpan(new com.tencent.mm.plugin.finder.view.e(paramString1, k, paramString2.getResources().getColor(2131099658), (b)new b(paramString4, paramContext)), i, j, 17);
    }
    paramTextView.setText((CharSequence)paramString3);
    paramTextView.setOnTouchListener((View.OnTouchListener)new a((Spannable)paramString3, paramTextView));
    AppMethodBeat.o(199636);
  }
  
  public static int fVU()
  {
    AppMethodBeat.i(199637);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fwf, Integer.valueOf(1));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(199637);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < 0)
    {
      AppMethodBeat.o(199637);
      return 0;
    }
    AppMethodBeat.o(199637);
    return i;
  }
  
  public static int fVV()
  {
    AppMethodBeat.i(199638);
    com.tencent.mm.kernel.e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.Fwe, 0);
    AppMethodBeat.o(199638);
    return i;
  }
  
  public static boolean fVW()
  {
    AppMethodBeat.i(199639);
    com.tencent.mm.kernel.e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    if (locale.afk().getInt(ae.a.Fwi, 0) > 0)
    {
      AppMethodBeat.o(199639);
      return true;
    }
    AppMethodBeat.o(199639);
    return false;
  }
  
  public static int fVX()
  {
    AppMethodBeat.i(199640);
    com.tencent.mm.kernel.e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.Fwh, 0);
    AppMethodBeat.o(199640);
    return i;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class a
    implements View.OnTouchListener
  {
    a(Spannable paramSpannable, TextView paramTextView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(199634);
      k.g(paramMotionEvent, "event");
      int j = paramMotionEvent.getAction();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(199634);
        throw paramView;
      }
      paramView = (TextView)paramView;
      Spannable localSpannable = this.qLQ;
      Object localObject1;
      int k;
      int i;
      if ((j == 1) || (j == 3))
      {
        localObject1 = (ClickableSpan[])localSpannable.getSpans(0, this.qLQ.length(), ClickableSpan.class);
        if (localObject1 != null)
        {
          k = localObject1.length;
          i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 instanceof o))
            {
              ((o)localObject2).setIsPressed(false);
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
        localObject1 = paramView.getLayout();
        i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
        localObject1 = (ClickableSpan[])localSpannable.getSpans(i, i, ClickableSpan.class);
        if (localObject1.length != 0)
        {
          localObject1 = localObject1[0];
          if (j == 1) {
            ((ClickableSpan)localObject1).onClick((View)paramView);
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramView = q.LaJ;
        ad.i(q.fVY(), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
        AppMethodBeat.o(199634);
        return bool;
        if (j != 0) {
          break;
        }
        if ((localObject1 instanceof o))
        {
          ((o)localObject1).setIsPressed(true);
          paramTextView.invalidate();
        }
        Selection.setSelection(localSpannable, localSpannable.getSpanStart(localObject1), localSpannable.getSpanEnd(localObject1));
        break;
        Selection.removeSelection(localSpannable);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "url", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<String, y>
  {
    b(String paramString, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.q
 * JD-Core Version:    0.7.0.1
 */