package com.tencent.mm.plugin.finder.ui;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class FinderCreateContactUI$i
  implements View.OnTouchListener
{
  FinderCreateContactUI$i(FinderCreateContactUI paramFinderCreateContactUI, Spannable paramSpannable, TextView paramTextView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(167173);
    k.g(paramMotionEvent, "event");
    int j = paramMotionEvent.getAction();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(167173);
      throw paramView;
    }
    paramView = (TextView)paramView;
    Spannable localSpannable = this.rGF;
    Object localObject1;
    int k;
    int i;
    if ((j == 1) || (j == 3))
    {
      localObject1 = (ClickableSpan[])localSpannable.getSpans(0, this.rGF.length(), ClickableSpan.class);
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
            this.rGG.invalidate();
          }
          i += 1;
        }
      }
    }
    if ((j == 1) || (j == 0))
    {
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      int m = paramView.getPaddingLeft();
      int n = paramView.getPaddingTop();
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
      ac.i(FinderCreateContactUI.b(this.rGC), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
      AppMethodBeat.o(167173);
      return bool;
      if (j != 0) {
        break;
      }
      if ((localObject1 instanceof o))
      {
        ((o)localObject1).setIsPressed(true);
        this.rGG.invalidate();
      }
      Selection.setSelection(localSpannable, localSpannable.getSpanStart(localObject1), localSpannable.getSpanEnd(localObject1));
      break;
      Selection.removeSelection(localSpannable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI.i
 * JD-Core Version:    0.7.0.1
 */