package android.support.design.widget;

import android.support.v4.view.q;
import android.support.v4.widget.r;
import android.support.v4.widget.r.a;
import android.view.View;
import android.view.ViewParent;

final class n$1
  extends r.a
{
  private int fC = -1;
  private int jZ;
  
  n$1(n paramn) {}
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    this.fC = -1;
    int j = paramView.getWidth();
    int i;
    if (paramFloat1 != 0.0F) {
      if (q.Q(paramView) == 1)
      {
        i = 1;
        if (this.ka.jV != 2) {
          break label114;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label290;
        }
        if (paramView.getLeft() >= this.jZ) {
          break label278;
        }
        i = this.jZ - j;
        label70:
        if (!this.ka.ft.x(i, paramView.getTop())) {
          break label302;
        }
        q.b(paramView, new n.b(this.ka, paramView, bool));
      }
    }
    label114:
    while ((!bool) || (this.ka.jR == null))
    {
      return;
      i = 0;
      break;
      if (this.ka.jV == 0)
      {
        if (i != 0)
        {
          if (paramFloat1 < 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (paramFloat1 > 0.0F)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
      }
      if (this.ka.jV == 1)
      {
        if (i != 0)
        {
          if (paramFloat1 > 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (paramFloat1 < 0.0F)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
        i = paramView.getLeft();
        int k = this.jZ;
        int m = Math.round(paramView.getWidth() * this.ka.jW);
        if (Math.abs(i - k) >= m)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
      }
      i = 0;
      break label45;
      i = this.jZ + j;
      break label70;
      i = this.jZ;
      bool = false;
      break label70;
    }
    label278:
    label290:
    label302:
    this.ka.jR.onDismiss(paramView);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    float f1 = this.jZ + paramView.getWidth() * this.ka.jX;
    float f2 = this.jZ + paramView.getWidth() * this.ka.jY;
    if (paramInt1 <= f1)
    {
      paramView.setAlpha(1.0F);
      return;
    }
    if (paramInt1 >= f2)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(n.n(1.0F - n.c(f1, f2, paramInt1)));
  }
  
  public final boolean b(View paramView, int paramInt)
  {
    return (this.fC == -1) && (this.ka.g(paramView));
  }
  
  public final int c(View paramView, int paramInt)
  {
    return paramView.getTop();
  }
  
  public final int d(View paramView, int paramInt)
  {
    int i;
    int j;
    if (q.Q(paramView) == 1)
    {
      i = 1;
      if (this.ka.jV != 0) {
        break label72;
      }
      if (i == 0) {
        break label53;
      }
      i = this.jZ - paramView.getWidth();
      j = this.jZ;
    }
    for (;;)
    {
      return n.clamp(i, paramInt, j);
      i = 0;
      break;
      label53:
      i = this.jZ;
      j = this.jZ + paramView.getWidth();
      continue;
      label72:
      if (this.ka.jV == 1)
      {
        if (i != 0)
        {
          i = this.jZ;
          j = this.jZ + paramView.getWidth();
        }
        else
        {
          i = this.jZ - paramView.getWidth();
          j = this.jZ;
        }
      }
      else
      {
        i = this.jZ - paramView.getWidth();
        j = this.jZ + paramView.getWidth();
      }
    }
  }
  
  public final void j(View paramView, int paramInt)
  {
    this.fC = paramInt;
    this.jZ = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public final int q(View paramView)
  {
    return paramView.getWidth();
  }
  
  public final void x(int paramInt)
  {
    if (this.ka.jR != null) {
      this.ka.jR.s(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.n.1
 * JD-Core Version:    0.7.0.1
 */