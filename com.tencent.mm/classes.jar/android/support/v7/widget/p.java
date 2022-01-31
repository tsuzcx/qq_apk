package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

class p
  implements r
{
  final RectF abQ = new RectF();
  
  private static void f(q paramq)
  {
    Rect localRect = new Rect();
    k(paramq).getPadding(localRect);
    paramq.O((int)Math.ceil(k(paramq).getMinWidth()), (int)Math.ceil(k(paramq).getMinHeight()));
    paramq.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private static ao k(q paramq)
  {
    return (ao)paramq.hu();
  }
  
  public final float a(q paramq)
  {
    return k(paramq).kt;
  }
  
  public final void a(q paramq, float paramFloat)
  {
    ao localao = k(paramq);
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Invalid radius " + paramFloat + ". Must be >= 0");
    }
    paramFloat = (int)(0.5F + paramFloat);
    if (localao.kq != paramFloat)
    {
      localao.kq = paramFloat;
      localao.kw = true;
      localao.invalidateSelf();
    }
    f(paramq);
  }
  
  public final void a(q paramq, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramContext = new ao(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    paramContext.aq(paramq.getPreventCornerOverlap());
    paramq.l(paramContext);
    f(paramq);
  }
  
  public final void a(q paramq, ColorStateList paramColorStateList)
  {
    paramq = k(paramq);
    paramq.e(paramColorStateList);
    paramq.invalidateSelf();
  }
  
  public final float b(q paramq)
  {
    return k(paramq).getMinWidth();
  }
  
  public final void b(q paramq, float paramFloat)
  {
    ao localao = k(paramq);
    localao.p(localao.kv, paramFloat);
    f(paramq);
  }
  
  public final float c(q paramq)
  {
    return k(paramq).getMinHeight();
  }
  
  public final void c(q paramq, float paramFloat)
  {
    paramq = k(paramq);
    paramq.p(paramFloat, paramq.kt);
  }
  
  public final float d(q paramq)
  {
    return k(paramq).kq;
  }
  
  public final float e(q paramq)
  {
    return k(paramq).kv;
  }
  
  public final void g(q paramq) {}
  
  public final void h(q paramq)
  {
    k(paramq).aq(paramq.getPreventCornerOverlap());
    f(paramq);
  }
  
  public void hw()
  {
    ao.akV = new p.1(this);
  }
  
  public final ColorStateList i(q paramq)
  {
    return k(paramq).akT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.p
 * JD-Core Version:    0.7.0.1
 */