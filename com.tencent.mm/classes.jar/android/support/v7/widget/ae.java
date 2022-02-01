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
  protected final DecelerateInterpolator SS = new DecelerateInterpolator();
  protected final LinearInterpolator anT = new LinearInterpolator();
  protected PointF anU;
  private final float anV = a(paramContext.getResources().getDisplayMetrics());
  protected int anW = 0;
  protected int anX = 0;
  
  public ae(Context paramContext) {}
  
  private static int ah(int paramInt1, int paramInt2)
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
    RecyclerView.i locali = this.aoI;
    if ((locali == null) || (!locali.jF())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return e(RecyclerView.i.bH(paramView) - localLayoutParams.topMargin, RecyclerView.i.bJ(paramView) + localLayoutParams.bottomMargin, locali.getPaddingTop(), locali.mHeight - locali.getPaddingBottom(), paramInt);
  }
  
  public int F(View paramView, int paramInt)
  {
    RecyclerView.i locali = this.aoI;
    if ((locali == null) || (!locali.jE())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return e(RecyclerView.i.bG(paramView) - localLayoutParams.leftMargin, RecyclerView.i.bI(paramView) + localLayoutParams.rightMargin, locali.getPaddingLeft(), locali.mWidth - locali.getPaddingRight(), paramInt);
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.r.a parama)
  {
    if (this.akA.apd.getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      this.anW = ah(this.anW, paramInt1);
      this.anX = ah(this.anX, paramInt2);
    } while ((this.anW != 0) || (this.anX != 0));
    PointF localPointF = bZ(this.ard);
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      parama.arl = this.ard;
      stop();
      return;
    }
    float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x /= f;
    localPointF.y /= f;
    this.anU = localPointF;
    this.anW = ((int)(localPointF.x * 10000.0F));
    this.anX = ((int)(localPointF.y * 10000.0F));
    paramInt1 = ce(10000);
    parama.a((int)(this.anW * 1.2F), (int)(this.anX * 1.2F), (int)(paramInt1 * 1.2F), this.anT);
  }
  
  protected void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
  {
    int i = F(paramView, jV());
    int j = E(paramView, jW());
    int k = cd((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      parama.a(-i, -j, k, this.SS);
    }
  }
  
  protected final int cd(int paramInt)
  {
    return (int)Math.ceil(ce(paramInt) / 0.3356D);
  }
  
  protected int ce(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.anV);
  }
  
  public int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
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
  
  protected int jV()
  {
    if ((this.anU == null) || (this.anU.x == 0.0F)) {
      return 0;
    }
    if (this.anU.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected int jW()
  {
    if ((this.anU == null) || (this.anU.y == 0.0F)) {
      return 0;
    }
    if (this.anU.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected void onStop()
  {
    this.anX = 0;
    this.anW = 0;
    this.anU = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ae
 * JD-Core Version:    0.7.0.1
 */