package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

class r
  implements t
{
  final RectF abf = new RectF();
  
  private void j(s params)
  {
    Rect localRect = new Rect();
    k(params).getPadding(localRect);
    params.L((int)Math.ceil(b(params)), (int)Math.ceil(c(params)));
    params.d(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private static an k(s params)
  {
    return (an)params.gu();
  }
  
  public final float a(s params)
  {
    return k(params).jv;
  }
  
  public final void a(s params, float paramFloat)
  {
    an localan = k(params);
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Invalid radius " + paramFloat + ". Must be >= 0");
    }
    paramFloat = (int)(0.5F + paramFloat);
    if (localan.js != paramFloat)
    {
      localan.js = paramFloat;
      localan.jy = true;
      localan.invalidateSelf();
    }
    j(params);
  }
  
  public final void a(s params, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramContext = new an(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    paramContext.ah(params.getPreventCornerOverlap());
    params.j(paramContext);
    j(params);
  }
  
  public final void a(s params, ColorStateList paramColorStateList)
  {
    params = k(params);
    params.e(paramColorStateList);
    params.invalidateSelf();
  }
  
  public final float b(s params)
  {
    params = k(params);
    float f1 = Math.max(params.jv, params.js + params.aiE + params.jv / 2.0F);
    float f2 = params.jv;
    return (params.aiE + f2) * 2.0F + f1 * 2.0F;
  }
  
  public final void b(s params, float paramFloat)
  {
    an localan = k(params);
    localan.p(localan.jx, paramFloat);
    j(params);
  }
  
  public final float c(s params)
  {
    params = k(params);
    float f1 = Math.max(params.jv, params.js + params.aiE + params.jv * 1.5F / 2.0F);
    float f2 = params.jv;
    return (params.aiE + f2 * 1.5F) * 2.0F + f1 * 2.0F;
  }
  
  public final void c(s params, float paramFloat)
  {
    params = k(params);
    params.p(paramFloat, params.jv);
  }
  
  public final float d(s params)
  {
    return k(params).js;
  }
  
  public final float e(s params)
  {
    return k(params).jx;
  }
  
  public final void f(s params) {}
  
  public final void g(s params)
  {
    k(params).ah(params.getPreventCornerOverlap());
    j(params);
  }
  
  public void gw()
  {
    an.aiF = new r.1(this);
  }
  
  public final ColorStateList h(s params)
  {
    return k(params).aiD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.r
 * JD-Core Version:    0.7.0.1
 */