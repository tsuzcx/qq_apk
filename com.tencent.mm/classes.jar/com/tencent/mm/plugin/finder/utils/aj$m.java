package com.tencent.mm.plugin.finder.utils;

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
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class aj$m
  implements View.OnTouchListener
{
  aj$m(View paramView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(275135);
    kotlin.g.b.p.j(paramMotionEvent, "event");
    int j = paramMotionEvent.getAction();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(275135);
      throw paramView;
    }
    TextView localTextView = (TextView)paramView;
    if ((localTextView.getText() instanceof Spannable))
    {
      paramView = localTextView.getText();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.text.Spannable");
        AppMethodBeat.o(275135);
        throw paramView;
      }
    }
    Object localObject1;
    int k;
    int i;
    for (paramView = (Spannable)paramView; (j == 1) || (j == 3); paramView = (Spannable)new SpannableString(localTextView.getText()))
    {
      localObject1 = (ClickableSpan[])paramView.getSpans(0, paramView.length(), ClickableSpan.class);
      if (localObject1 == null) {
        break;
      }
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof com.tencent.mm.pluginsdk.ui.span.p))
        {
          ((com.tencent.mm.pluginsdk.ui.span.p)localObject2).setIsPressed(false);
          this.AGs.invalidate();
        }
        i += 1;
      }
    }
    if ((j == 1) || (j == 0))
    {
      int m = (int)paramMotionEvent.getX();
      i = (int)paramMotionEvent.getY();
      int n = localTextView.getTotalPaddingLeft();
      k = localTextView.getTotalPaddingTop();
      m = m - n + localTextView.getScrollX();
      n = localTextView.getScrollY();
      localObject1 = localTextView.getLayout();
      i = ((Layout)localObject1).getLineForVertical(i - k + n);
      k = ((Layout)localObject1).getOffsetForHorizontal(i, m);
      if (m > ((Layout)localObject1).getLineWidth(i))
      {
        localObject1 = null;
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label465;
        }
        localObject1 = localObject1[0];
        if (j != 1) {
          break label413;
        }
        ((ClickableSpan)localObject1).onClick((View)localTextView);
      }
    }
    label331:
    for (boolean bool = true;; bool = false)
    {
      paramView = aj.AGc;
      Log.i(aj.eeA(), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
      AppMethodBeat.o(275135);
      return bool;
      localObject1 = (ClickableSpan[])paramView.getSpans(k, k, ClickableSpan.class);
      break;
      if (j != 0) {
        break label331;
      }
      if ((localObject1 instanceof com.tencent.mm.pluginsdk.ui.span.p))
      {
        ((com.tencent.mm.pluginsdk.ui.span.p)localObject1).setIsPressed(true);
        this.AGs.invalidate();
      }
      Selection.setSelection(paramView, paramView.getSpanStart(localObject1), paramView.getSpanEnd(localObject1));
      break label331;
      label465:
      Selection.removeSelection(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aj.m
 * JD-Core Version:    0.7.0.1
 */