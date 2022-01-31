package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class PreviewFrameLayout
  extends RelativeLayout
{
  private double mAspectRatio = 1.333333333333333D;
  
  public PreviewFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public double getmAspectRatio()
  {
    return this.mAspectRatio;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingLeft() + getPaddingRight();
    int m = getPaddingTop() + getPaddingBottom();
    paramInt1 -= k;
    int j = paramInt2 - m;
    int i;
    if (paramInt1 > j)
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      paramInt2 = paramInt1;
      label57:
      if (i == 0) {
        break label124;
      }
      paramInt1 = j;
      label64:
      if (paramInt2 >= paramInt1 * this.mAspectRatio) {
        break label127;
      }
      paramInt2 = (int)(paramInt1 * this.mAspectRatio);
      label86:
      if (i == 0) {
        break label139;
      }
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt2 + k, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1 + m, 1073741824));
      return;
      i = 0;
      break;
      label118:
      paramInt2 = j;
      break label57;
      label124:
      break label64;
      label127:
      paramInt1 = (int)(paramInt2 / this.mAspectRatio);
      break label86;
      label139:
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
  
  public void setAspectRatio(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      throw new IllegalArgumentException();
    }
    if (this.mAspectRatio != paramDouble)
    {
      this.mAspectRatio = paramDouble;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout
 * JD-Core Version:    0.7.0.1
 */