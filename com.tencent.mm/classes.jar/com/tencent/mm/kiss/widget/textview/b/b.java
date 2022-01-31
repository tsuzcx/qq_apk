package com.tencent.mm.kiss.widget.textview.b;

import android.text.Layout;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.kiss.widget.textview.a;

public final class b
{
  private static b dOF;
  private static Object dOG = new NoCopySpan.Concrete();
  
  public static b EK()
  {
    if (dOF == null) {
      dOF = new b();
    }
    return dOF;
  }
  
  public static void a(Spannable paramSpannable)
  {
    Selection.removeSelection(paramSpannable);
    paramSpannable.removeSpan(dOG);
  }
  
  public static boolean a(View paramView, Layout paramLayout, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (!(paramView instanceof a)) {
      return false;
    }
    paramView = (a)paramView;
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((j < paramView.getHorizontalDrawOffset()) || (j > paramLayout.getWidth() + paramView.getHorizontalDrawOffset())) {
        return false;
      }
      if ((k < paramView.getVerticalDrawOffset()) || (k > paramLayout.getHeight() + paramView.getVerticalDrawOffset())) {
        return false;
      }
      int m = paramView.getHorizontalDrawOffset();
      int n = paramView.getVerticalDrawOffset();
      int i1 = paramView.getScrollX();
      j = paramLayout.getOffsetForHorizontal(paramLayout.getLineForVertical(k - n + paramView.getScrollY()), j - m + i1);
      paramView = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (paramView.length != 0)
      {
        if (i == 1) {
          return true;
        }
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramView[0]), paramSpannable.getSpanEnd(paramView[0]));
        return true;
      }
      Selection.removeSelection(paramSpannable);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.b.b
 * JD-Core Version:    0.7.0.1
 */