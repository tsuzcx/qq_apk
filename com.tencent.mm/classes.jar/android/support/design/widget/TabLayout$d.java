package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

final class TabLayout$d
  extends LinearLayout
{
  private int lI;
  private final Paint lJ;
  int lK = -1;
  float lL;
  private int lM = -1;
  private int lN = -1;
  private ValueAnimator lO;
  private int mLayoutDirection = -1;
  
  TabLayout$d(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.lJ = new Paint();
  }
  
  private void bI()
  {
    View localView = getChildAt(this.lK);
    int i;
    int j;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      i = localView.getLeft();
      j = localView.getRight();
      if ((this.lL <= 0.0F) || (this.lK >= getChildCount() - 1)) {
        break label151;
      }
      localView = getChildAt(this.lK + 1);
      float f1 = this.lL;
      float f2 = localView.getLeft();
      float f3 = this.lL;
      i = (int)(i * (1.0F - f3) + f1 * f2);
      f1 = this.lL;
      f2 = localView.getRight();
      f3 = this.lL;
      j = (int)(j * (1.0F - f3) + f2 * f1);
    }
    label151:
    for (;;)
    {
      i(i, j);
      return;
      i = -1;
      j = -1;
    }
  }
  
  final void N(int paramInt)
  {
    if (this.lJ.getColor() != paramInt)
    {
      this.lJ.setColor(paramInt);
      t.R(this);
    }
  }
  
  final void O(int paramInt)
  {
    if (this.lI != paramInt)
    {
      this.lI = paramInt;
      t.R(this);
    }
  }
  
  final void c(int paramInt, float paramFloat)
  {
    if ((this.lO != null) && (this.lO.isRunning())) {
      this.lO.cancel();
    }
    this.lK = paramInt;
    this.lL = paramFloat;
    bI();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.lM >= 0) && (this.lN > this.lM)) {
      paramCanvas.drawRect(this.lM, getHeight() - this.lI, this.lN, getHeight(), this.lJ);
    }
  }
  
  final void i(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.lM) || (paramInt2 != this.lN))
    {
      this.lM = paramInt1;
      this.lN = paramInt2;
      t.R(this);
    }
  }
  
  final void j(int paramInt1, int paramInt2)
  {
    if ((this.lO != null) && (this.lO.isRunning())) {
      this.lO.cancel();
    }
    int i;
    Object localObject;
    if (t.T(this) == 1)
    {
      i = 1;
      localObject = getChildAt(paramInt1);
      if (localObject != null) {
        break label56;
      }
      bI();
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label56:
      int k = ((View)localObject).getLeft();
      int m = ((View)localObject).getRight();
      int j;
      if (Math.abs(paramInt1 - this.lK) <= 1)
      {
        i = this.lM;
        j = this.lN;
      }
      while ((i != k) || (j != m))
      {
        localObject = new ValueAnimator();
        this.lO = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(a.fj);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new TabLayout.d.1(this, i, k, j, m));
        ((ValueAnimator)localObject).addListener(new TabLayout.d.2(this, paramInt1));
        ((ValueAnimator)localObject).start();
        return;
        j = this.lG.L(24);
        if (paramInt1 < this.lK)
        {
          if (i == 0)
          {
            i = m + j;
            j = i;
          }
        }
        else if (i != 0)
        {
          i = m + j;
          j = i;
          continue;
        }
        i = k - j;
        j = i;
      }
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.lO != null) && (this.lO.isRunning()))
    {
      this.lO.cancel();
      long l = this.lO.getDuration();
      paramInt1 = this.lK;
      float f = this.lO.getAnimatedFraction();
      j(paramInt1, Math.round((float)l * (1.0F - f)));
      return;
    }
    bI();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      break label15;
    }
    label15:
    while ((this.lG.mMode != 1) || (this.lG.lu != 1)) {
      return;
    }
    int n = getChildCount();
    int k = 0;
    int j = 0;
    label50:
    Object localObject;
    if (k < n)
    {
      localObject = getChildAt(k);
      if (((View)localObject).getVisibility() != 0) {
        break label234;
      }
    }
    label132:
    label219:
    label231:
    label234:
    for (int i = Math.max(j, ((View)localObject).getMeasuredWidth());; i = j)
    {
      k += 1;
      j = i;
      break label50;
      if (j <= 0) {
        break;
      }
      i = this.lG.L(16);
      int m;
      if (j * n <= getMeasuredWidth() - i * 2)
      {
        i = 0;
        k = 0;
        m = i;
        if (k >= n) {
          break label219;
        }
        localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
        if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).weight == 0.0F)) {
          break label231;
        }
        ((LinearLayout.LayoutParams)localObject).width = j;
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        i = 1;
      }
      for (;;)
      {
        k += 1;
        break label132;
        this.lG.lu = 0;
        this.lG.r(false);
        m = 1;
        if (m == 0) {
          break;
        }
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
  }
  
  public final void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if ((Build.VERSION.SDK_INT < 23) && (this.mLayoutDirection != paramInt))
    {
      requestLayout();
      this.mLayoutDirection = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.TabLayout.d
 * JD-Core Version:    0.7.0.1
 */