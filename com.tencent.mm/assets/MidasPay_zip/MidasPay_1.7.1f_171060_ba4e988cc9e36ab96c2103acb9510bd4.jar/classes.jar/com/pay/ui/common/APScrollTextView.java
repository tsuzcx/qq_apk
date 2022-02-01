package com.pay.ui.common;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class APScrollTextView
  extends TextView
{
  public APScrollTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public APScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public APScrollTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APScrollTextView
 * JD-Core Version:    0.7.0.1
 */