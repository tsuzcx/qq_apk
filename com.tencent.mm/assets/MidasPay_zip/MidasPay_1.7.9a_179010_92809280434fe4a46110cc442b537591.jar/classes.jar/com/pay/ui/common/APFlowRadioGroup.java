package com.pay.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RadioGroup;
import com.tencent.midas.comm.APLog;
import midas.x.a;

public class APFlowRadioGroup
  extends RadioGroup
{
  public APFlowRadioGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public APFlowRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getChildCount();
    int n = paramInt3 - paramInt1;
    paramInt4 = 0;
    paramInt2 = 0;
    for (paramInt1 = 0; paramInt4 < m; paramInt1 = paramInt3)
    {
      View localView = getChildAt(paramInt4);
      int i = paramInt2;
      paramInt3 = paramInt1;
      if (localView.getVisibility() != 8)
      {
        int i1 = localView.getMeasuredHeight();
        int j = n / 3;
        int k = paramInt2 + j;
        i = paramInt1 * i1 + i1;
        paramInt2 = k;
        paramInt3 = paramInt1;
        if (k > n)
        {
          paramInt3 = paramInt1 + 1;
          i = paramInt3 * i1 + i1;
          paramInt2 = j;
        }
        localView.layout(paramInt2 - j, i - i1, paramInt2, i);
        i = paramInt2;
      }
      paramInt4 += 1;
      paramInt2 = i;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = getChildCount();
    int i = 0;
    paramInt2 = 0;
    int k = 0;
    int m;
    for (int j = 0; i < i1; j = m)
    {
      View localView = getChildAt(i);
      paramInt1 = k;
      m = j;
      if (localView.getVisibility() != 8)
      {
        localView.measure(0, 0);
        paramInt1 = n / 3;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("width=");
        localStringBuilder.append(paramInt1);
        APLog.e("FlowRadioGroup", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("width dp=");
        localStringBuilder.append(APUICommonMethod.b(a.r().a(), paramInt1));
        APLog.e("FlowRadioGroup", localStringBuilder.toString());
        int i2 = localView.getMeasuredHeight();
        paramInt2 = k + paramInt1;
        if (paramInt2 > n)
        {
          m = j + 1;
          paramInt2 = m * i2 + i2;
        }
        else
        {
          k = j * i2 + i2;
          m = j;
          paramInt1 = paramInt2;
          paramInt2 = k;
        }
      }
      i += 1;
      k = paramInt1;
    }
    setMeasuredDimension(n, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APFlowRadioGroup
 * JD-Core Version:    0.7.0.1
 */