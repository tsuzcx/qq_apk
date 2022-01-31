package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

final class TabLayout$d
  extends LinearLayout
{
  private int kK;
  private final Paint kL;
  int kM = -1;
  float kN;
  private int kO = -1;
  private int kP = -1;
  private int kQ = -1;
  ValueAnimator kR;
  
  TabLayout$d(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.kL = new Paint();
  }
  
  final void O(int paramInt)
  {
    if (this.kL.getColor() != paramInt)
    {
      this.kL.setColor(paramInt);
      q.O(this);
    }
  }
  
  final void P(int paramInt)
  {
    if (this.kK != paramInt)
    {
      this.kK = paramInt;
      q.O(this);
    }
  }
  
  final void aY()
  {
    View localView = getChildAt(this.kM);
    int i;
    int j;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      i = localView.getLeft();
      j = localView.getRight();
      if ((this.kN <= 0.0F) || (this.kM >= getChildCount() - 1)) {
        break label151;
      }
      localView = getChildAt(this.kM + 1);
      float f1 = this.kN;
      float f2 = localView.getLeft();
      float f3 = this.kN;
      i = (int)(i * (1.0F - f3) + f1 * f2);
      f1 = this.kN;
      f2 = localView.getRight();
      f3 = this.kN;
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
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.kP >= 0) && (this.kQ > this.kP)) {
      paramCanvas.drawRect(this.kP, getHeight() - this.kK, this.kQ, getHeight(), this.kL);
    }
  }
  
  final void i(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.kP) || (paramInt2 != this.kQ))
    {
      this.kP = paramInt1;
      this.kQ = paramInt2;
      q.O(this);
    }
  }
  
  final void j(int paramInt1, int paramInt2)
  {
    if ((this.kR != null) && (this.kR.isRunning())) {
      this.kR.cancel();
    }
    int i;
    Object localObject;
    if (q.Q(this) == 1)
    {
      i = 1;
      localObject = getChildAt(paramInt1);
      if (localObject != null) {
        break label56;
      }
      aY();
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
      if (Math.abs(paramInt1 - this.kM) <= 1)
      {
        i = this.kP;
        j = this.kQ;
      }
      while ((i != k) || (j != m))
      {
        localObject = new ValueAnimator();
        this.kR = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(a.el);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new TabLayout.d.1(this, i, k, j, m));
        ((ValueAnimator)localObject).addListener(new TabLayout.d.2(this, paramInt1));
        ((ValueAnimator)localObject).start();
        return;
        j = this.kI.M(24);
        if (paramInt1 < this.kM)
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
    if ((this.kR != null) && (this.kR.isRunning()))
    {
      this.kR.cancel();
      long l = this.kR.getDuration();
      paramInt1 = this.kM;
      float f = this.kR.getAnimatedFraction();
      j(paramInt1, Math.round((float)l * (1.0F - f)));
      return;
    }
    aY();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      break label15;
    }
    label15:
    while ((this.kI.mMode != 1) || (this.kI.kw != 1)) {
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
      i = this.kI.M(16);
      int m;
      if (j * n <= getMeasuredWidth() - i * 2)
      {
        k = 0;
        i = 0;
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
        this.kI.kw = 0;
        this.kI.s(false);
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
    if ((Build.VERSION.SDK_INT < 23) && (this.kO != paramInt))
    {
      requestLayout();
      this.kO = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.TabLayout.d
 * JD-Core Version:    0.7.0.1
 */