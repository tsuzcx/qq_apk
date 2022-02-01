package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.SizeMeasure;

public class UnaffectedRelativeLayout
  extends RelativeLayout
{
  int a;
  int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = -1;
  
  public UnaffectedRelativeLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public UnaffectedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if (paramInt2 == this.g) {
      return true;
    }
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      return false;
    }
    if ((paramInt1 == paramInt3) && (paramInt3 != 0) && (paramInt4 != 0)) {
      if (paramInt2 < paramInt4) {
        if (Math.abs(paramInt2 - this.c) > this.d) {
          if (!bool) {
            break label129;
          }
        }
      }
    }
    label129:
    for (this.g = paramInt2;; this.g = -1)
    {
      a();
      return bool;
      bool = false;
      break;
      if (Math.abs(paramInt2 - paramInt4) < this.d)
      {
        if ((paramInt4 != this.a) && (paramInt4 != this.b)) {
          break;
        }
        bool = false;
        break;
      }
      bool = false;
      break;
    }
  }
  
  private void b()
  {
    this.c = SizeMeasure.i(getContext());
    this.d = AIOUtils.a(150.0F, getResources());
  }
  
  public void a()
  {
    if (SizeMeasure.a(getContext()))
    {
      this.a = this.g;
      return;
    }
    this.b = this.g;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.c = SizeMeasure.i(getContext());
    this.g = -1;
    this.f = this.c;
    requestLayout();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    SizeMeasure.b(getContext());
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i = paramInt2;
    if (getHeight() > 0)
    {
      i = paramInt2;
      if (a(j, k, this.e, this.f)) {
        i = View.MeasureSpec.makeMeasureSpec(getHeight(), View.MeasureSpec.getMode(paramInt2));
      }
    }
    this.e = j;
    this.f = k;
    super.onMeasure(paramInt1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UnaffectedRelativeLayout
 * JD-Core Version:    0.7.0.1
 */