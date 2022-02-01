package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class ae
  extends RecyclerView.r
{
  protected final DecelerateInterpolator VQ = new DecelerateInterpolator();
  protected final LinearInterpolator aqS = new LinearInterpolator();
  protected PointF aqT;
  private final float aqU = a(paramContext.getResources().getDisplayMetrics());
  protected int aqV = 0;
  protected int aqW = 0;
  
  public ae(Context paramContext) {}
  
  private static int aj(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  public int E(View paramView, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = this.arI;
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollVertically())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return f(localLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin, localLayoutManager.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin, localLayoutManager.getPaddingTop(), localLayoutManager.getHeight() - localLayoutManager.getPaddingBottom(), paramInt);
  }
  
  public int F(View paramView, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = this.arI;
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollHorizontally())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return f(localLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin, localLayoutManager.getDecoratedRight(paramView) + localLayoutParams.rightMargin, localLayoutManager.getPaddingLeft(), localLayoutManager.getWidth() - localLayoutManager.getPaddingRight(), paramInt);
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.r.a parama)
  {
    if (this.mRecyclerView.asc.getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      this.aqV = aj(this.aqV, paramInt1);
      this.aqW = aj(this.aqW, paramInt2);
    } while ((this.aqV != 0) || (this.aqW != 0));
    PointF localPointF = bZ(this.atO);
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      parama.atV = this.atO;
      stop();
      return;
    }
    float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x /= f;
    localPointF.y /= f;
    this.aqT = localPointF;
    this.aqV = ((int)(localPointF.x * 10000.0F));
    this.aqW = ((int)(localPointF.y * 10000.0F));
    paramInt1 = cd(10000);
    parama.a((int)(this.aqV * 1.2F), (int)(this.aqW * 1.2F), (int)(paramInt1 * 1.2F), this.aqS);
  }
  
  protected void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
  {
    int i = F(paramView, kz());
    int j = E(paramView, kA());
    int k = cc((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      parama.a(-i, -j, k, this.VQ);
    }
  }
  
  protected int cc(int paramInt)
  {
    return (int)Math.ceil(cd(paramInt) / 0.3356D);
  }
  
  protected int cd(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.aqU);
  }
  
  public int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    switch (paramInt5)
    {
    default: 
      throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    case -1: 
      paramInt1 = paramInt3 - paramInt1;
    }
    do
    {
      do
      {
        return paramInt1;
        return paramInt4 - paramInt2;
        paramInt3 -= paramInt1;
        paramInt1 = paramInt3;
      } while (paramInt3 > 0);
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt2;
    } while (paramInt2 < 0);
    return 0;
  }
  
  protected int kA()
  {
    if ((this.aqT == null) || (this.aqT.y == 0.0F)) {
      return 0;
    }
    if (this.aqT.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected int kz()
  {
    if ((this.aqT == null) || (this.aqT.x == 0.0F)) {
      return 0;
    }
    if (this.aqT.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected void onStop()
  {
    this.aqW = 0;
    this.aqV = 0;
    this.aqT = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ae
 * JD-Core Version:    0.7.0.1
 */