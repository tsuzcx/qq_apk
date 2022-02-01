package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class ae
  extends RecyclerView.s
{
  protected final DecelerateInterpolator VD = new DecelerateInterpolator();
  protected final LinearInterpolator aqG = new LinearInterpolator();
  protected PointF aqH;
  private final float aqI = a(paramContext.getResources().getDisplayMetrics());
  protected int aqJ = 0;
  protected int aqK = 0;
  
  public ae(Context paramContext) {}
  
  private static int ai(int paramInt1, int paramInt2)
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
    RecyclerView.i locali = this.arw;
    if ((locali == null) || (!locali.kd())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return f(RecyclerView.i.bH(paramView) - localLayoutParams.topMargin, RecyclerView.i.bJ(paramView) + localLayoutParams.bottomMargin, locali.getPaddingTop(), locali.mHeight - locali.getPaddingBottom(), paramInt);
  }
  
  public int F(View paramView, int paramInt)
  {
    RecyclerView.i locali = this.arw;
    if ((locali == null) || (!locali.kc())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return f(RecyclerView.i.bG(paramView) - localLayoutParams.leftMargin, RecyclerView.i.bI(paramView) + localLayoutParams.rightMargin, locali.getPaddingLeft(), locali.mWidth - locali.getPaddingRight(), paramInt);
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.s.a parama)
  {
    if (this.anl.arR.getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      this.aqJ = ai(this.aqJ, paramInt1);
      this.aqK = ai(this.aqK, paramInt2);
    } while ((this.aqJ != 0) || (this.aqK != 0));
    PointF localPointF = bZ(this.atQ);
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      parama.atX = this.atQ;
      stop();
      return;
    }
    float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x /= f;
    localPointF.y /= f;
    this.aqH = localPointF;
    this.aqJ = ((int)(localPointF.x * 10000.0F));
    this.aqK = ((int)(localPointF.y * 10000.0F));
    paramInt1 = ce(10000);
    parama.a((int)(this.aqJ * 1.2F), (int)(this.aqK * 1.2F), (int)(paramInt1 * 1.2F), this.aqG);
  }
  
  protected void a(View paramView, RecyclerView.t paramt, RecyclerView.s.a parama)
  {
    int i = F(paramView, kt());
    int j = E(paramView, ku());
    int k = cd((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      parama.a(-i, -j, k, this.VD);
    }
  }
  
  protected int cd(int paramInt)
  {
    return (int)Math.ceil(ce(paramInt) / 0.3356D);
  }
  
  protected int ce(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.aqI);
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
  
  protected int kt()
  {
    if ((this.aqH == null) || (this.aqH.x == 0.0F)) {
      return 0;
    }
    if (this.aqH.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected int ku()
  {
    if ((this.aqH == null) || (this.aqH.y == 0.0F)) {
      return 0;
    }
    if (this.aqH.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected void onStop()
  {
    this.aqK = 0;
    this.aqJ = 0;
    this.aqH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ae
 * JD-Core Version:    0.7.0.1
 */