package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  extends RecyclerView.r
{
  protected final LinearInterpolator ajt;
  protected final DecelerateInterpolator aju;
  protected PointF ajv;
  private final float ajw;
  protected int ajx;
  protected int ajy;
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(261873);
    this.ajt = new LinearInterpolator();
    this.aju = new DecelerateInterpolator();
    this.ajx = 0;
    this.ajy = 0;
    this.ajw = a(paramContext.getResources().getDisplayMetrics());
    AppMethodBeat.o(261873);
  }
  
  private static int aw(int paramInt1, int paramInt2)
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
    AppMethodBeat.i(261887);
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollVertically()))
    {
      AppMethodBeat.o(261887);
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    paramInt = f(localLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin, localLayoutManager.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin, localLayoutManager.getPaddingTop(), localLayoutManager.getHeight() - localLayoutManager.getPaddingBottom(), paramInt);
    AppMethodBeat.o(261887);
    return paramInt;
  }
  
  public int F(View paramView, int paramInt)
  {
    AppMethodBeat.i(261888);
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollHorizontally()))
    {
      AppMethodBeat.o(261888);
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    paramInt = f(localLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin, localLayoutManager.getDecoratedRight(paramView) + localLayoutParams.rightMargin, localLayoutManager.getPaddingLeft(), localLayoutManager.getWidth() - localLayoutManager.getPaddingRight(), paramInt);
    AppMethodBeat.o(261888);
    return paramInt;
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(261878);
    if (getChildCount() == 0)
    {
      stop();
      AppMethodBeat.o(261878);
      return;
    }
    this.ajx = aw(this.ajx, paramInt1);
    this.ajy = aw(this.ajy, paramInt2);
    if ((this.ajx == 0) && (this.ajy == 0))
    {
      PointF localPointF = cB(this.alG);
      if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
      {
        parama.alN = this.alG;
        stop();
        AppMethodBeat.o(261878);
        return;
      }
      float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
      localPointF.x /= f;
      localPointF.y /= f;
      this.ajv = localPointF;
      this.ajx = ((int)(localPointF.x * 10000.0F));
      this.ajy = ((int)(localPointF.y * 10000.0F));
      paramInt1 = cF(10000);
      parama.a((int)(this.ajx * 1.2F), (int)(this.ajy * 1.2F), (int)(paramInt1 * 1.2F), this.ajt);
    }
    AppMethodBeat.o(261878);
  }
  
  protected void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(261875);
    int i = F(paramView, kQ());
    int j = E(paramView, kR());
    int k = cE((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      parama.a(-i, -j, k, this.aju);
    }
    AppMethodBeat.o(261875);
  }
  
  protected int cE(int paramInt)
  {
    AppMethodBeat.i(261879);
    paramInt = (int)Math.ceil(cF(paramInt) / 0.3356D);
    AppMethodBeat.o(261879);
    return paramInt;
  }
  
  protected int cF(int paramInt)
  {
    AppMethodBeat.i(261881);
    paramInt = (int)Math.ceil(Math.abs(paramInt) * this.ajw);
    AppMethodBeat.o(261881);
    return paramInt;
  }
  
  public int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(261884);
    switch (paramInt5)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      AppMethodBeat.o(261884);
      throw localIllegalArgumentException;
    case -1: 
      AppMethodBeat.o(261884);
      return paramInt3 - paramInt1;
    case 1: 
      AppMethodBeat.o(261884);
      return paramInt4 - paramInt2;
    }
    paramInt1 = paramInt3 - paramInt1;
    if (paramInt1 > 0)
    {
      AppMethodBeat.o(261884);
      return paramInt1;
    }
    paramInt1 = paramInt4 - paramInt2;
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(261884);
      return paramInt1;
    }
    AppMethodBeat.o(261884);
    return 0;
  }
  
  protected int kQ()
  {
    if ((this.ajv == null) || (this.ajv.x == 0.0F)) {
      return 0;
    }
    if (this.ajv.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected int kR()
  {
    if ((this.ajv == null) || (this.ajv.y == 0.0F)) {
      return 0;
    }
    if (this.ajv.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected void onStart() {}
  
  protected void onStop()
  {
    this.ajy = 0;
    this.ajx = 0;
    this.ajv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.p
 * JD-Core Version:    0.7.0.1
 */