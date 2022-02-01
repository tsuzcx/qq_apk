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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ad;

final class FaceAgreementUI$7
  implements View.OnTouchListener
{
  FaceAgreementUI$7(FaceAgreementUI paramFaceAgreementUI, Spannable paramSpannable, TextView paramTextView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(221167);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    ((b)localObject1).bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject1).ahq());
    int j = paramMotionEvent.getAction();
    paramView = (TextView)paramView;
    int k;
    int i;
    if ((j == 1) || (j == 3))
    {
      localObject1 = (ClickableSpan[])this.EhS.getSpans(0, this.EhS.length(), ClickableSpan.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2 instanceof o))
          {
            ((o)localObject2).setIsPressed(false);
            this.EhU.invalidate();
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
      paramMotionEvent = (ClickableSpan[])this.EhS.getSpans(i, i, ClickableSpan.class);
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
      ad.i("MicroMsg.FaceAgreementUI", "touch ${event.x}, ${event.y}, ret:${ret}");
      a.a(bool, this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(221167);
      return bool;
      if ((paramMotionEvent instanceof o))
      {
        ((o)paramMotionEvent).setIsPressed(true);
        this.EhU.invalidate();
      }
      Selection.setSelection(this.EhS, this.EhS.getSpanStart(paramMotionEvent), this.EhS.getSpanEnd(paramMotionEvent));
      break;
      Selection.removeSelection(this.EhS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.7
 * JD-Core Version:    0.7.0.1
 */