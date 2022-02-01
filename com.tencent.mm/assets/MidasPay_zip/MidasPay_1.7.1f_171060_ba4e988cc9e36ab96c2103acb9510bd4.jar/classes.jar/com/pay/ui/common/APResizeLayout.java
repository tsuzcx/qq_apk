package com.pay.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class APResizeLayout
  extends LinearLayout
{
  public APResizeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public APResizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 > paramInt4)
    {
      com.pay.tool.APGlobalInfo.a = paramInt4;
      return;
    }
    com.pay.tool.APGlobalInfo.a = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APResizeLayout
 * JD-Core Version:    0.7.0.1
 */