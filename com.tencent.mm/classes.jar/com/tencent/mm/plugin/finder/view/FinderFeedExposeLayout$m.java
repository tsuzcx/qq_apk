package com.tencent.mm.plugin.finder.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class FinderFeedExposeLayout$m
  implements View.OnTouchListener
{
  FinderFeedExposeLayout$m(FinderFeedExposeLayout paramFinderFeedExposeLayout, Spannable paramSpannable, FinderFeedExposeLayout.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168338);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    ((b)localObject1).bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$setSpanTouch$touchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject1).ahF());
    p.g(paramMotionEvent, "event");
    int j = paramMotionEvent.getAction();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(168338);
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
            this.tfx.ovs.invalidate();
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
      ae.i(FinderFeedExposeLayout.b(this.tfq), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
      a.a(bool, this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$setSpanTouch$touchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(168338);
      return bool;
      if (j != 0) {
        break;
      }
      if ((localObject2 instanceof o))
      {
        ((o)localObject2).setIsPressed(true);
        this.tfx.ovs.invalidate();
      }
      Selection.setSelection((Spannable)localObject1, ((Spannable)localObject1).getSpanStart(localObject2), ((Spannable)localObject1).getSpanEnd(localObject2));
      break;
      Selection.removeSelection((Spannable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout.m
 * JD-Core Version:    0.7.0.1
 */