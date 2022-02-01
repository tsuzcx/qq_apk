package com.tencent.mobileqq.dating.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewDebug.ExportedProperty;
import android.widget.TextView;

public class DatingCommentTextView
  extends TextView
{
  private int a = -1;
  private int b = -1;
  
  public DatingCommentTextView(Context paramContext)
  {
    super(paramContext);
    setFocusable(false);
  }
  
  public DatingCommentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(false);
  }
  
  @ViewDebug.ExportedProperty(category="focus")
  public boolean hasFocus()
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    for (;;)
    {
      int i;
      try
      {
        i = paramMotionEvent.getActionMasked();
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = getTotalPaddingLeft();
        int n = getTotalPaddingTop();
        int i1 = getScrollX();
        int i2 = getScrollY();
        paramMotionEvent = getLayout();
        j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
        paramMotionEvent = getText();
        if ((TextUtils.isEmpty(paramMotionEvent)) || (!(paramMotionEvent instanceof Spannable))) {
          break label341;
        }
        paramMotionEvent = (Spannable)getText();
        ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
        if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0)) {
          break label283;
        }
        if (i != 0) {
          break label346;
        }
        this.a = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
        this.b = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
        if ((this.a < 0) || (this.b < this.a)) {
          break label344;
        }
        paramMotionEvent.setSpan(new BackgroundColorSpan(Color.parseColor("#d5d5d5")), this.a, this.b, 33);
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
        return bool;
      }
      if ((this.a >= 0) && (this.b >= this.a))
      {
        paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.a, this.b, 33);
        Selection.removeSelection(paramMotionEvent);
        this.a = -1;
        this.b = -1;
        break label344;
        label283:
        if ((this.a >= 0) && (this.b >= this.a))
        {
          paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.a, this.b, 33);
          Selection.removeSelection(paramMotionEvent);
          this.a = -1;
          this.b = -1;
        }
        return false;
        label341:
        return bool;
      }
      label344:
      label346:
      do
      {
        return true;
        if (i == 1) {
          break;
        }
      } while (i != 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingCommentTextView
 * JD-Core Version:    0.7.0.1
 */