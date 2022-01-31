package android.support.v7.widget.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class a$a
{
  private static final b aqv = new c.b();
  private static final Interpolator aqw = new a.a.1();
  private static final Interpolator aqx = new a.a.2();
  private int aqy = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      aqv = new c.a();
      return;
    }
  }
  
  public static RecyclerView.v a(RecyclerView.v paramv, List<RecyclerView.v> paramList, int paramInt1, int paramInt2)
  {
    int m = paramv.aku.getWidth();
    int n = paramv.aku.getHeight();
    int i = -1;
    int i1 = paramInt1 - paramv.aku.getLeft();
    int i2 = paramInt2 - paramv.aku.getTop();
    int i3 = paramList.size();
    int j = 0;
    Object localObject2 = null;
    Object localObject1;
    int k;
    if (j < i3)
    {
      localObject1 = (RecyclerView.v)paramList.get(j);
      if (i1 <= 0) {
        break label343;
      }
      k = ((RecyclerView.v)localObject1).aku.getRight() - (paramInt1 + m);
      if ((k >= 0) || (((RecyclerView.v)localObject1).aku.getRight() <= paramv.aku.getRight())) {
        break label343;
      }
      k = Math.abs(k);
      if (k <= i) {
        break label343;
      }
      localObject2 = localObject1;
      i = k;
      label142:
      if (i1 >= 0) {
        break label356;
      }
      k = ((RecyclerView.v)localObject1).aku.getLeft() - paramInt1;
      if ((k <= 0) || (((RecyclerView.v)localObject1).aku.getLeft() >= paramv.aku.getLeft())) {
        break label356;
      }
      k = Math.abs(k);
      if (k <= i) {
        break label356;
      }
      localObject2 = localObject1;
      i = k;
    }
    label343:
    label356:
    for (;;)
    {
      if (i2 < 0)
      {
        k = ((RecyclerView.v)localObject1).aku.getTop() - paramInt2;
        if ((k > 0) && (((RecyclerView.v)localObject1).aku.getTop() < paramv.aku.getTop()))
        {
          k = Math.abs(k);
          if (k > i)
          {
            localObject2 = localObject1;
            i = k;
          }
        }
      }
      for (;;)
      {
        if (i2 > 0)
        {
          k = ((RecyclerView.v)localObject1).aku.getBottom() - (paramInt2 + n);
          if ((k < 0) && (((RecyclerView.v)localObject1).aku.getBottom() > paramv.aku.getBottom()))
          {
            k = Math.abs(k);
            if (k > i) {
              i = k;
            }
          }
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject1;
          break;
          return localObject2;
          break label142;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static int cL(int paramInt)
  {
    if (paramInt == 0) {}
    return 983055;
  }
  
  public static long d(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = paramRecyclerView.getItemAnimator();
    if (paramRecyclerView == null)
    {
      if (paramInt == 8) {
        return 200L;
      }
      return 250L;
    }
    if (paramInt == 8) {
      return paramRecyclerView.ajh;
    }
    return paramRecyclerView.ajg;
  }
  
  static int j(RecyclerView paramRecyclerView)
  {
    t.T(paramRecyclerView);
    return 983055;
  }
  
  private int k(RecyclerView paramRecyclerView)
  {
    if (this.aqy == -1) {
      this.aqy = paramRecyclerView.getResources().getDimensionPixelSize(2131428478);
    }
    return this.aqy;
  }
  
  public final int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
  {
    float f1 = 1.0F;
    int i = k(paramRecyclerView);
    int j = Math.abs(paramInt2);
    int k = (int)Math.signum(paramInt2);
    float f2 = Math.min(1.0F, j * 1.0F / paramInt1);
    paramInt1 = (int)(i * k * aqx.getInterpolation(f2));
    if (paramLong > 2000L) {}
    for (;;)
    {
      f2 = paramInt1;
      i = (int)(aqw.getInterpolation(f1) * f2);
      paramInt1 = i;
      if (i == 0)
      {
        if (paramInt2 <= 0) {
          break;
        }
        paramInt1 = 1;
      }
      return paramInt1;
      f1 = (float)paramLong / 2000.0F;
    }
    return -1;
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    aqv.a(paramCanvas, paramRecyclerView, paramv.aku, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    aqv.cb(paramv.aku);
  }
  
  public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2);
  
  public void f(RecyclerView.v paramv, int paramInt) {}
  
  public boolean le()
  {
    return true;
  }
  
  public float lf()
  {
    return 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.a.a.a
 * JD-Core Version:    0.7.0.1
 */