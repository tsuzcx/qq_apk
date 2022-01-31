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
  private static b eMm;
  private static Object eMn;
  
  static
  {
    AppMethodBeat.i(105823);
    eMn = new NoCopySpan.Concrete();
    AppMethodBeat.o(105823);
  }
  
  public static b SR()
  {
    AppMethodBeat.i(105822);
    if (eMm == null) {
      eMm = new b();
    }
    b localb = eMm;
    AppMethodBeat.o(105822);
    return localb;
  }
  
  public static void a(Spannable paramSpannable)
  {
    AppMethodBeat.i(105821);
    Selection.removeSelection(paramSpannable);
    paramSpannable.removeSpan(eMn);
    AppMethodBeat.o(105821);
  }
  
  public static boolean a(View paramView, Layout paramLayout, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105820);
    int i = paramMotionEvent.getAction();
    if (!(paramView instanceof a))
    {
      AppMethodBeat.o(105820);
      return false;
    }
    paramView = (a)paramView;
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((j < paramView.getHorizontalDrawOffset()) || (j > paramLayout.getWidth() + paramView.getHorizontalDrawOffset()))
      {
        AppMethodBeat.o(105820);
        return false;
      }
      if ((k < paramView.getVerticalDrawOffset()) || (k > paramLayout.getHeight() + paramView.getVerticalDrawOffset()))
      {
        AppMethodBeat.o(105820);
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
          AppMethodBeat.o(105820);
          return true;
        }
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramView[0]), paramSpannable.getSpanEnd(paramView[0]));
        AppMethodBeat.o(105820);
        return true;
      }
      Selection.removeSelection(paramSpannable);
    }
    AppMethodBeat.o(105820);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.b.b
 * JD-Core Version:    0.7.0.1
 */