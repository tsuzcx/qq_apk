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
  protected final DecelerateInterpolator LP = new DecelerateInterpolator();
  protected final LinearInterpolator agM = new LinearInterpolator();
  protected PointF agN;
  private final float agO = c(paramContext.getResources().getDisplayMetrics());
  protected int agP = 0;
  protected int agQ = 0;
  
  public ae(Context paramContext) {}
  
  private static int af(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.r.a parama)
  {
    if (this.adt.ahW.getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      this.agP = af(this.agP, paramInt1);
      this.agQ = af(this.agQ, paramInt2);
    } while ((this.agP != 0) || (this.agQ != 0));
    PointF localPointF = bI(this.ajQ);
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      parama.ajX = this.ajQ;
      stop();
      return;
    }
    float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x /= f;
    localPointF.y /= f;
    this.agN = localPointF;
    this.agP = ((int)(localPointF.x * 10000.0F));
    this.agQ = ((int)(localPointF.y * 10000.0F));
    paramInt1 = bM(10000);
    parama.a((int)(this.agP * 1.2F), (int)(this.agQ * 1.2F), (int)(paramInt1 * 1.2F), this.agM);
  }
  
  protected void a(View paramView, RecyclerView.r.a parama)
  {
    int k = 0;
    int i = iA();
    RecyclerView.i locali = this.ahB;
    int m;
    if ((locali == null) || (!locali.ij()))
    {
      i = 0;
      m = iB();
      locali = this.ahB;
      j = k;
      if (locali != null) {
        if (locali.ik()) {
          break label157;
        }
      }
    }
    RecyclerView.LayoutParams localLayoutParams;
    for (int j = k;; j = e(RecyclerView.i.bA(paramView) - localLayoutParams.topMargin, RecyclerView.i.bC(paramView) + localLayoutParams.bottomMargin, locali.getPaddingTop(), locali.mHeight - locali.getPaddingBottom(), m))
    {
      k = bL((int)Math.sqrt(i * i + j * j));
      if (k > 0) {
        parama.a(-i, -j, k, this.LP);
      }
      return;
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      i = e(RecyclerView.i.bz(paramView) - localLayoutParams.leftMargin, RecyclerView.i.bB(paramView) + localLayoutParams.rightMargin, locali.getPaddingLeft(), locali.mWidth - locali.getPaddingRight(), i);
      break;
      label157:
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    }
  }
  
  public PointF bI(int paramInt)
  {
    RecyclerView.i locali = this.ahB;
    if ((locali instanceof RecyclerView.r.b)) {
      return ((RecyclerView.r.b)locali).bI(paramInt);
    }
    new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(RecyclerView.r.b.class.getCanonicalName());
    return null;
  }
  
  protected final int bL(int paramInt)
  {
    return (int)Math.ceil(bM(paramInt) / 0.3356D);
  }
  
  protected int bM(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.agO);
  }
  
  protected float c(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
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
  
  protected int iA()
  {
    if ((this.agN == null) || (this.agN.x == 0.0F)) {
      return 0;
    }
    if (this.agN.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected int iB()
  {
    if ((this.agN == null) || (this.agN.y == 0.0F)) {
      return 0;
    }
    if (this.agN.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected void onStop()
  {
    this.agQ = 0;
    this.agP = 0;
    this.agN = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.ae
 * JD-Core Version:    0.7.0.1
 */