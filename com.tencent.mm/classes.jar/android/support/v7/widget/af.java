package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class af
  extends RecyclerView.r
{
  public final DecelerateInterpolator Mh = new DecelerateInterpolator();
  protected PointF aeA;
  private final float aeB = a(paramContext.getResources().getDisplayMetrics());
  protected int aeC = 0;
  protected int aeD = 0;
  protected final LinearInterpolator aez = new LinearInterpolator();
  
  public af(Context paramContext) {}
  
  private static int ab(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  public float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.r.a parama)
  {
    if (this.acI.afG.getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      this.aeC = ab(this.aeC, paramInt1);
      this.aeD = ab(this.aeD, paramInt2);
    } while ((this.aeC != 0) || (this.aeD != 0));
    PointF localPointF = bD(this.ahA);
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      parama.ahH = this.ahA;
      stop();
      return;
    }
    float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x /= f;
    localPointF.y /= f;
    this.aeA = localPointF;
    this.aeC = ((int)(localPointF.x * 10000.0F));
    this.aeD = ((int)(localPointF.y * 10000.0F));
    paramInt1 = bH(10000);
    parama.a((int)(this.aeC * 1.2F), (int)(this.aeD * 1.2F), (int)(paramInt1 * 1.2F), this.aez);
  }
  
  public void a(View paramView, RecyclerView.r.a parama)
  {
    int m = 0;
    int i = he();
    RecyclerView.i locali = this.afm;
    int j;
    if ((locali == null) || (!locali.gO()))
    {
      j = 0;
      if ((this.aeA != null) && (this.aeA.y != 0.0F)) {
        break label174;
      }
      i = 0;
      label51:
      locali = this.afm;
      k = m;
      if (locali != null) {
        if (locali.gP()) {
          break label196;
        }
      }
    }
    RecyclerView.LayoutParams localLayoutParams;
    for (int k = m;; k = e(RecyclerView.i.bp(paramView) - localLayoutParams.topMargin, RecyclerView.i.br(paramView) + localLayoutParams.bottomMargin, locali.getPaddingTop(), locali.mHeight - locali.getPaddingBottom(), i))
    {
      i = bG((int)Math.sqrt(j * j + k * k));
      if (i > 0) {
        parama.a(-j, -k, i, this.Mh);
      }
      return;
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      j = e(RecyclerView.i.bo(paramView) - localLayoutParams.leftMargin, RecyclerView.i.bq(paramView) + localLayoutParams.rightMargin, locali.getPaddingLeft(), locali.mWidth - locali.getPaddingRight(), i);
      break;
      label174:
      if (this.aeA.y > 0.0F)
      {
        i = 1;
        break label51;
      }
      i = -1;
      break label51;
      label196:
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    }
  }
  
  public PointF bD(int paramInt)
  {
    RecyclerView.i locali = this.afm;
    if ((locali instanceof RecyclerView.r.b)) {
      return ((RecyclerView.r.b)locali).bD(paramInt);
    }
    new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(RecyclerView.r.b.class.getCanonicalName());
    return null;
  }
  
  public final int bG(int paramInt)
  {
    return (int)Math.ceil(bH(paramInt) / 0.3356D);
  }
  
  public int bH(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.aeB);
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
  
  public int he()
  {
    if ((this.aeA == null) || (this.aeA.x == 0.0F)) {
      return 0;
    }
    if (this.aeA.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  public void onStop()
  {
    this.aeD = 0;
    this.aeC = 0;
    this.aeA = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.af
 * JD-Core Version:    0.7.0.1
 */