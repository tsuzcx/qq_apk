package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
  extends RecyclerView.r
{
  protected final LinearInterpolator bXX;
  protected final DecelerateInterpolator bXY;
  protected PointF bXZ;
  private final float bYa;
  protected int bYb;
  protected int bYc;
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(194850);
    this.bXX = new LinearInterpolator();
    this.bXY = new DecelerateInterpolator();
    this.bYb = 0;
    this.bYc = 0;
    this.bYa = c(paramContext.getResources().getDisplayMetrics());
    AppMethodBeat.o(194850);
  }
  
  private static int bq(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  public int I(View paramView, int paramInt)
  {
    AppMethodBeat.i(194941);
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollVertically()))
    {
      AppMethodBeat.o(194941);
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    paramInt = g(localLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin, localLayoutManager.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin, localLayoutManager.getPaddingTop(), localLayoutManager.getHeight() - localLayoutManager.getPaddingBottom(), paramInt);
    AppMethodBeat.o(194941);
    return paramInt;
  }
  
  public int J(View paramView, int paramInt)
  {
    AppMethodBeat.i(194950);
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollHorizontally()))
    {
      AppMethodBeat.o(194950);
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    paramInt = g(localLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin, localLayoutManager.getDecoratedRight(paramView) + localLayoutParams.rightMargin, localLayoutManager.getPaddingLeft(), localLayoutManager.getWidth() - localLayoutManager.getPaddingRight(), paramInt);
    AppMethodBeat.o(194950);
    return paramInt;
  }
  
  protected int JB()
  {
    if ((this.bXZ == null) || (this.bXZ.x == 0.0F)) {
      return 0;
    }
    if (this.bXZ.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected int JC()
  {
    if ((this.bXZ == null) || (this.bXZ.y == 0.0F)) {
      return 0;
    }
    if (this.bXZ.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected final void a(int paramInt1, int paramInt2, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(194885);
    if (getChildCount() == 0)
    {
      stop();
      AppMethodBeat.o(194885);
      return;
    }
    this.bYb = bq(this.bYb, paramInt1);
    this.bYc = bq(this.bYc, paramInt2);
    if ((this.bYb == 0) && (this.bYc == 0))
    {
      PointF localPointF = fM(this.cag);
      if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
      {
        parama.can = this.cag;
        stop();
        AppMethodBeat.o(194885);
        return;
      }
      float f = (float)Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
      localPointF.x /= f;
      localPointF.y /= f;
      this.bXZ = localPointF;
      this.bYb = ((int)(localPointF.x * 10000.0F));
      this.bYc = ((int)(localPointF.y * 10000.0F));
      paramInt1 = fP(10000);
      parama.a((int)(this.bYb * 1.2F), (int)(this.bYc * 1.2F), (int)(paramInt1 * 1.2F), this.bXX);
    }
    AppMethodBeat.o(194885);
  }
  
  protected void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(194873);
    int i = J(paramView, JB());
    int j = I(paramView, JC());
    int k = fO((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      parama.a(-i, -j, k, this.bXY);
    }
    AppMethodBeat.o(194873);
  }
  
  protected float c(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int fO(int paramInt)
  {
    AppMethodBeat.i(194900);
    paramInt = (int)Math.ceil(fP(paramInt) / 0.3356D);
    AppMethodBeat.o(194900);
    return paramInt;
  }
  
  protected int fP(int paramInt)
  {
    AppMethodBeat.i(194907);
    paramInt = (int)Math.ceil(Math.abs(paramInt) * this.bYa);
    AppMethodBeat.o(194907);
    return paramInt;
  }
  
  public int g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(194930);
    switch (paramInt5)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      AppMethodBeat.o(194930);
      throw localIllegalArgumentException;
    case -1: 
      AppMethodBeat.o(194930);
      return paramInt3 - paramInt1;
    case 1: 
      AppMethodBeat.o(194930);
      return paramInt4 - paramInt2;
    }
    paramInt1 = paramInt3 - paramInt1;
    if (paramInt1 > 0)
    {
      AppMethodBeat.o(194930);
      return paramInt1;
    }
    paramInt1 = paramInt4 - paramInt2;
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(194930);
      return paramInt1;
    }
    AppMethodBeat.o(194930);
    return 0;
  }
  
  protected void onStart() {}
  
  protected void onStop()
  {
    this.bYc = 0;
    this.bYb = 0;
    this.bXZ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.o
 * JD-Core Version:    0.7.0.1
 */