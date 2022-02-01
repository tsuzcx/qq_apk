package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class p
  implements r
{
  final RectF alV = new RectF();
  
  private static ao k(q paramq)
  {
    return (ao)paramq.jy();
  }
  
  public final float a(q paramq)
  {
    return k(paramq).auY;
  }
  
  public final void a(q paramq, float paramFloat)
  {
    ao localao = k(paramq);
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Invalid radius " + paramFloat + ". Must be >= 0");
    }
    paramFloat = (int)(0.5F + paramFloat);
    if (localao.Kx != paramFloat)
    {
      localao.Kx = paramFloat;
      localao.avb = true;
      localao.invalidateSelf();
    }
    f(paramq);
  }
  
  public final void a(q paramq, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramContext = new ao(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    paramContext.aw(paramq.getPreventCornerOverlap());
    paramq.q(paramContext);
    f(paramq);
  }
  
  public final void a(q paramq, ColorStateList paramColorStateList)
  {
    paramq = k(paramq);
    paramq.g(paramColorStateList);
    paramq.invalidateSelf();
  }
  
  public final float b(q paramq)
  {
    return k(paramq).getMinWidth();
  }
  
  public final void b(q paramq, float paramFloat)
  {
    ao localao = k(paramq);
    localao.f(localao.ava, paramFloat);
    f(paramq);
  }
  
  public final float c(q paramq)
  {
    return k(paramq).getMinHeight();
  }
  
  public final void c(q paramq, float paramFloat)
  {
    paramq = k(paramq);
    paramq.f(paramFloat, paramq.auY);
  }
  
  public final float d(q paramq)
  {
    return k(paramq).Kx;
  }
  
  public final float e(q paramq)
  {
    return k(paramq).ava;
  }
  
  public final void f(q paramq)
  {
    Rect localRect = new Rect();
    k(paramq).getPadding(localRect);
    paramq.R((int)Math.ceil(k(paramq).getMinWidth()), (int)Math.ceil(k(paramq).getMinHeight()));
    paramq.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  public final void g(q paramq) {}
  
  public final void h(q paramq)
  {
    k(paramq).aw(paramq.getPreventCornerOverlap());
    f(paramq);
  }
  
  public final ColorStateList i(q paramq)
  {
    return k(paramq).auR;
  }
  
  public void initStatic()
  {
    ao.auT = new ao.a()
    {
      public final void a(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        float f1 = 2.0F * paramAnonymousFloat;
        float f2 = paramAnonymousRectF.width() - f1 - 1.0F;
        float f3 = paramAnonymousRectF.height();
        if (paramAnonymousFloat >= 1.0F)
        {
          float f4 = paramAnonymousFloat + 0.5F;
          p.this.alV.set(-f4, -f4, f4, f4);
          int i = paramAnonymousCanvas.save();
          paramAnonymousCanvas.translate(paramAnonymousRectF.left + f4, paramAnonymousRectF.top + f4);
          paramAnonymousCanvas.drawArc(p.this.alV, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(p.this.alV, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f3 - f1 - 1.0F, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(p.this.alV, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(p.this.alV, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.restoreToCount(i);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.top, 1.0F + (paramAnonymousRectF.right - f4), paramAnonymousRectF.top + f4, paramAnonymousPaint);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.bottom - f4, 1.0F + (paramAnonymousRectF.right - f4), paramAnonymousRectF.bottom, paramAnonymousPaint);
        }
        paramAnonymousCanvas.drawRect(paramAnonymousRectF.left, paramAnonymousRectF.top + paramAnonymousFloat, paramAnonymousRectF.right, paramAnonymousRectF.bottom - paramAnonymousFloat, paramAnonymousPaint);
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.p
 * JD-Core Version:    0.7.0.1
 */