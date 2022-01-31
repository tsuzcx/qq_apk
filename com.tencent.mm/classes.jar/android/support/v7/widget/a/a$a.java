package android.support.v7.widget.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class a$a
{
  private static final b aoe = new c.b();
  private static final Interpolator aof = new a.a.1();
  private static final Interpolator aog = new a.a.2();
  private int aoh = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      aoe = new c.a();
      return;
    }
  }
  
  public static void H(RecyclerView.v paramv)
  {
    paramv = paramv.aie;
  }
  
  public static float L(float paramFloat)
  {
    return paramFloat;
  }
  
  public static float M(float paramFloat)
  {
    return paramFloat;
  }
  
  public static RecyclerView.v a(RecyclerView.v paramv, List<RecyclerView.v> paramList, int paramInt1, int paramInt2)
  {
    int m = paramv.aie.getWidth();
    int n = paramv.aie.getHeight();
    int i = -1;
    int i1 = paramInt1 - paramv.aie.getLeft();
    int i2 = paramInt2 - paramv.aie.getTop();
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
      k = ((RecyclerView.v)localObject1).aie.getRight() - (paramInt1 + m);
      if ((k >= 0) || (((RecyclerView.v)localObject1).aie.getRight() <= paramv.aie.getRight())) {
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
      k = ((RecyclerView.v)localObject1).aie.getLeft() - paramInt1;
      if ((k <= 0) || (((RecyclerView.v)localObject1).aie.getLeft() >= paramv.aie.getLeft())) {
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
        k = ((RecyclerView.v)localObject1).aie.getTop() - paramInt2;
        if ((k > 0) && (((RecyclerView.v)localObject1).aie.getTop() < paramv.aie.getTop()))
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
          k = ((RecyclerView.v)localObject1).aie.getBottom() - (paramInt2 + n);
          if ((k < 0) && (((RecyclerView.v)localObject1).aie.getBottom() > paramv.aie.getBottom()))
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
  
  public static int aB(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0xC0C0C;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
    if (paramInt2 == 0) {
      return paramInt1 | i << 2;
    }
    return paramInt1 | i << 1 & 0xFFF3F3F3 | (i << 1 & 0xC0C0C) << 2;
  }
  
  public static int aC(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0x303030;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
    if (paramInt2 == 0) {
      return paramInt1 | i >> 2;
    }
    return paramInt1 | i >> 1 & 0xFFCFCFCF | (i >> 1 & 0x303030) >> 2;
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
      return paramRecyclerView.agR;
    }
    return paramRecyclerView.agQ;
  }
  
  static int g(RecyclerView paramRecyclerView)
  {
    return aC(3342387, q.Q(paramRecyclerView));
  }
  
  public static boolean jk()
  {
    return true;
  }
  
  public static int jn()
  {
    return 0;
  }
  
  public static float jo()
  {
    return 0.5F;
  }
  
  public final int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, long paramLong)
  {
    float f1 = 1.0F;
    if (this.aoh == -1) {
      this.aoh = paramRecyclerView.getResources().getDimensionPixelSize(android.support.v7.e.a.a.item_touch_helper_max_drag_scroll_per_frame);
    }
    int i = this.aoh;
    int j = Math.abs(paramInt2);
    int k = (int)Math.signum(paramInt2);
    float f2 = Math.min(1.0F, j * 1.0F / paramInt1);
    paramInt1 = (int)(i * k * aog.getInterpolation(f2));
    if (paramLong > 2000L) {}
    for (;;)
    {
      f2 = paramInt1;
      i = (int)(aof.getInterpolation(f1) * f2);
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
    aoe.a(paramCanvas, paramRecyclerView, paramv.aie, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    aoe.bI(paramv.aie);
  }
  
  public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2);
  
  public void f(RecyclerView.v paramv, int paramInt)
  {
    if (paramv != null) {
      paramv = paramv.aie;
    }
  }
  
  public abstract int jj();
  
  public boolean jl()
  {
    return true;
  }
  
  public boolean jm()
  {
    return true;
  }
  
  public float jp()
  {
    return 0.5F;
  }
  
  public abstract void jq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a.a
 * JD-Core Version:    0.7.0.1
 */