package com.pay.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class APLinearLayout
  extends LinearLayout
{
  private static boolean a = true;
  
  public APLinearLayout(Context paramContext)
  {
    super(paramContext);
    if (!a) {
      setFocusable(true);
    }
  }
  
  public APLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (!a) {
      setFocusable(true);
    }
  }
  
  public static void setClickAble(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APLinearLayout
 * JD-Core Version:    0.7.0.1
 */