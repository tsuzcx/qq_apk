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
  protected final DecelerateInterpolator TN = new DecelerateInterpolator();
  protected final LinearInterpolator aoO = new LinearInterpolator();
  protected PointF aoP;
  private final float aoQ = a(paramContext.getResources().getDisplayMetrics());
  protected int aoR = 0;
  protected int aoS = 0;
  
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
    RecyclerView.i locali = this.apE;
    if ((locali == null) || (!locali.jN())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return e(RecyclerView.i.bH(paramView) - localLayoutParams.topMargin, RecyclerView.i.bJ(paramView) + localLayoutParams.bottomMargin, locali.getPaddingTop(), locali.mHeight - locali.getPaddingBottom(), paramInt);
  }
  
  public int F(View paramView, int paramInt)
  {
    RecyclerView.i locali = this.apE;
    if ((locali == null) || (!locali.jM())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return e(RecyclerView.i.bG(paramView) - localLayoutParams.leftMargin, RecyclerView.i.bI(paramView) + localLayoutParams.rightMargin, locali.getPaddingLeft(), locali.mWidth - locali.getPaddingRight(), paramInt);
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.s.a parama)
  {
    if (this.alu.apZ.getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      this.aoR = ah(this.aoR, paramInt1);
      this.aoS = ah(this.aoS, paramInt2);
    } while ((this.aoR != 0) || (this.aoS != 0));
    PointF localPointF = bZ(this.arZ);
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      parama.asg = this.arZ;
      stop();
      return;
    }
    float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x /= f;
    localPointF.y /= f;
    this.aoP = localPointF;
    this.aoR = ((int)(localPointF.x * 10000.0F));
    this.aoS = ((int)(localPointF.y * 10000.0F));
    paramInt1 = ce(10000);
    parama.a((int)(this.aoR * 1.2F), (int)(this.aoS * 1.2F), (int)(paramInt1 * 1.2F), this.aoO);
  }
  
  protected void a(View paramView, RecyclerView.t paramt, RecyclerView.s.a parama)
  {
    int i = F(paramView, kd());
    int j = E(paramView, ke());
    int k = cd((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      parama.a(-i, -j, k, this.TN);
    }
  }
  
  protected final int cd(int paramInt)
  {
    return (int)Math.ceil(ce(paramInt) / 0.3356D);
  }
  
  protected int ce(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.aoQ);
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
  
  protected int kd()
  {
    if ((this.aoP == null) || (this.aoP.x == 0.0F)) {
      return 0;
    }
    if (this.aoP.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected int ke()
  {
    if ((this.aoP == null) || (this.aoP.y == 0.0F)) {
      return 0;
    }
    if (this.aoP.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected void onStop()
  {
    this.aoS = 0;
    this.aoR = 0;
    this.aoP = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ae
 * JD-Core Version:    0.7.0.1
 */