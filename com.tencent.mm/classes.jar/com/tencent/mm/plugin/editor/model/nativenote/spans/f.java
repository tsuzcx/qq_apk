package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends ArrowKeyMovementMethod
{
  private static f pDN;
  
  public static f cgH()
  {
    AppMethodBeat.i(181935);
    if (pDN == null) {
      pDN = new f();
    }
    f localf = pDN;
    AppMethodBeat.o(181935);
    return localf;
  }
  
  public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181936);
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int m = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int n = paramTextView.getTotalPaddingLeft();
      int k = paramTextView.getTotalPaddingTop();
      m = paramTextView.getScrollX() + (m - n);
      n = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(n + (j - k)), m);
      localObject = (s[])paramSpannable.getSpans(j, j + 1, s.class);
      if ((m < com.tencent.mm.plugin.editor.model.nativenote.manager.f.cfO()) && (localObject.length != 0))
      {
        if (i == 0) {
          localObject[0].a(paramTextView, paramSpannable, paramMotionEvent, localObject[0]);
        }
        AppMethodBeat.o(181936);
        return false;
      }
    }
    AppMethodBeat.o(181936);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.f
 * JD-Core Version:    0.7.0.1
 */