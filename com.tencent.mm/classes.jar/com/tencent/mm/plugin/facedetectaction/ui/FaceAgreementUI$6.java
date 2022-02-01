package com.tencent.mm.plugin.facedetectaction.ui;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceAgreementUI$6
  implements View.OnTouchListener
{
  FaceAgreementUI$6(FaceAgreementUI paramFaceAgreementUI, Spannable paramSpannable, TextView paramTextView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197449);
    int j = paramMotionEvent.getAction();
    paramView = (TextView)paramView;
    int k;
    int i;
    if ((j == 1) || (j == 3))
    {
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])this.wEU.getSpans(0, this.wEU.length(), ClickableSpan.class);
      if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length > 0))
      {
        k = arrayOfClickableSpan.length;
        i = 0;
        while (i < k)
        {
          ClickableSpan localClickableSpan = arrayOfClickableSpan[i];
          if ((localClickableSpan instanceof p))
          {
            ((p)localClickableSpan).setIsPressed(false);
            this.wEV.invalidate();
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
      paramMotionEvent = paramView.getLayout();
      i = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), i - m + i1);
      paramMotionEvent = (ClickableSpan[])this.wEU.getSpans(i, i, ClickableSpan.class);
      if (paramMotionEvent.length != 0)
      {
        paramMotionEvent = paramMotionEvent[0];
        if (j == 1) {
          paramMotionEvent.onClick(paramView);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FaceAgreementUI", "touch ${event.x}, ${event.y}, ret:${ret}");
      AppMethodBeat.o(197449);
      return bool;
      if ((paramMotionEvent instanceof p))
      {
        ((p)paramMotionEvent).setIsPressed(true);
        this.wEV.invalidate();
      }
      Selection.setSelection(this.wEU, this.wEU.getSpanStart(paramMotionEvent), this.wEU.getSpanEnd(paramMotionEvent));
      break;
      Selection.removeSelection(this.wEU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.6
 * JD-Core Version:    0.7.0.1
 */