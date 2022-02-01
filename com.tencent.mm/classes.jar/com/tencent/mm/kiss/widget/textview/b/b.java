package com.tencent.mm.kiss.widget.textview.b;

import android.text.Layout;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a;

public final class b
{
  private static b ghr;
  private static Object ghs;
  
  static
  {
    AppMethodBeat.i(141143);
    ghs = new NoCopySpan.Concrete();
    AppMethodBeat.o(141143);
  }
  
  public static void a(Spannable paramSpannable)
  {
    AppMethodBeat.i(141141);
    Selection.removeSelection(paramSpannable);
    paramSpannable.removeSpan(ghs);
    AppMethodBeat.o(141141);
  }
  
  public static boolean a(View paramView, Layout paramLayout, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141140);
    int i = paramMotionEvent.getAction();
    if (!(paramView instanceof a))
    {
      AppMethodBeat.o(141140);
      return false;
    }
    paramView = (a)paramView;
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((j < paramView.getHorizontalDrawOffset()) || (j > paramLayout.getWidth() + paramView.getHorizontalDrawOffset()))
      {
        AppMethodBeat.o(141140);
        return false;
      }
      if ((k < paramView.getVerticalDrawOffset()) || (k > paramLayout.getHeight() + paramView.getVerticalDrawOffset()))
      {
        AppMethodBeat.o(141140);
        return false;
      }
      int m = paramView.getHorizontalDrawOffset();
      int n = paramView.getVerticalDrawOffset();
      int i1 = paramView.getScrollX();
      j = paramLayout.getOffsetForHorizontal(paramLayout.getLineForVertical(k - n + paramView.getScrollY()), j - m + i1);
      paramView = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (paramView.length != 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(141140);
          return true;
        }
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramView[0]), paramSpannable.getSpanEnd(paramView[0]));
        AppMethodBeat.o(141140);
        return true;
      }
      Selection.removeSelection(paramSpannable);
    }
    AppMethodBeat.o(141140);
    return false;
  }
  
  public static b agK()
  {
    AppMethodBeat.i(141142);
    if (ghr == null) {
      ghr = new b();
    }
    b localb = ghr;
    AppMethodBeat.o(141142);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.b.b
 * JD-Core Version:    0.7.0.1
 */