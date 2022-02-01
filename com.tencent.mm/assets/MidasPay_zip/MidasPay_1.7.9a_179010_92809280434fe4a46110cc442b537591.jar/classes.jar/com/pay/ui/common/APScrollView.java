package com.pay.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.midas.comm.APLog;

public class APScrollView
  extends ScrollView
{
  public APScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public APScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public APScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void fling(int paramInt)
  {
    paramInt /= 40;
    super.fling(paramInt);
    APLog.i("APScrollView", String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APScrollView
 * JD-Core Version:    0.7.0.1
 */