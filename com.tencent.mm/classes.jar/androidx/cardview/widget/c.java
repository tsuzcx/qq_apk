package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

class c
  implements e
{
  final RectF yR;
  
  c()
  {
    AppMethodBeat.i(188160);
    this.yR = new RectF();
    AppMethodBeat.o(188160);
  }
  
  private static g k(d paramd)
  {
    AppMethodBeat.i(188186);
    paramd = (g)paramd.eV();
    AppMethodBeat.o(188186);
    return paramd;
  }
  
  public final float a(d paramd)
  {
    AppMethodBeat.i(188179);
    float f = k(paramd).zl;
    AppMethodBeat.o(188179);
    return f;
  }
  
  public final void a(d paramd, float paramFloat)
  {
    AppMethodBeat.i(188169);
    g localg = k(paramd);
    if (paramFloat < 0.0F)
    {
      paramd = new IllegalArgumentException("Invalid radius " + paramFloat + ". Must be >= 0");
      AppMethodBeat.o(188169);
      throw paramd;
    }
    paramFloat = (int)(0.5F + paramFloat);
    if (localg.zj != paramFloat)
    {
      localg.zj = paramFloat;
      localg.zo = true;
      localg.invalidateSelf();
    }
    f(paramd);
    AppMethodBeat.o(188169);
  }
  
  public final void a(d paramd, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(188162);
    paramContext = new g(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    paramContext.U(paramd.getPreventCornerOverlap());
    paramd.j(paramContext);
    f(paramd);
    AppMethodBeat.o(188162);
  }
  
  public final void a(d paramd, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(188165);
    paramd = k(paramd);
    paramd.b(paramColorStateList);
    paramd.invalidateSelf();
    AppMethodBeat.o(188165);
  }
  
  public final float b(d paramd)
  {
    AppMethodBeat.i(292718);
    float f = k(paramd).getMinWidth();
    AppMethodBeat.o(292718);
    return f;
  }
  
  public final void b(d paramd, float paramFloat)
  {
    AppMethodBeat.i(188176);
    g localg = k(paramd);
    localg.b(localg.zn, paramFloat);
    f(paramd);
    AppMethodBeat.o(188176);
  }
  
  public final float c(d paramd)
  {
    AppMethodBeat.i(292719);
    float f = k(paramd).getMinHeight();
    AppMethodBeat.o(292719);
    return f;
  }
  
  public final void c(d paramd, float paramFloat)
  {
    AppMethodBeat.i(188173);
    paramd = k(paramd);
    paramd.b(paramFloat, paramd.zl);
    AppMethodBeat.o(188173);
  }
  
  public final float d(d paramd)
  {
    AppMethodBeat.i(188170);
    float f = k(paramd).zj;
    AppMethodBeat.o(188170);
    return f;
  }
  
  public final float e(d paramd)
  {
    AppMethodBeat.i(188175);
    float f = k(paramd).zn;
    AppMethodBeat.o(188175);
    return f;
  }
  
  public final void f(d paramd)
  {
    AppMethodBeat.i(188163);
    Rect localRect = new Rect();
    k(paramd).getPadding(localRect);
    paramd.s((int)Math.ceil(k(paramd).getMinWidth()), (int)Math.ceil(k(paramd).getMinHeight()));
    paramd.c(localRect.left, localRect.top, localRect.right, localRect.bottom);
    AppMethodBeat.o(188163);
  }
  
  public final void g(d paramd) {}
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(188164);
    k(paramd).U(paramd.getPreventCornerOverlap());
    f(paramd);
    AppMethodBeat.o(188164);
  }
  
  public final ColorStateList i(d paramd)
  {
    AppMethodBeat.i(188168);
    paramd = k(paramd).yZ;
    AppMethodBeat.o(188168);
    return paramd;
  }
  
  public void initStatic()
  {
    AppMethodBeat.i(188161);
    g.ze = new g.a()
    {
      public final void a(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        AppMethodBeat.i(188157);
        float f1 = 2.0F * paramAnonymousFloat;
        float f2 = paramAnonymousRectF.width() - f1 - 1.0F;
        float f3 = paramAnonymousRectF.height();
        if (paramAnonymousFloat >= 1.0F)
        {
          float f4 = paramAnonymousFloat + 0.5F;
          c.this.yR.set(-f4, -f4, f4, f4);
          int i = paramAnonymousCanvas.save();
          paramAnonymousCanvas.translate(paramAnonymousRectF.left + f4, paramAnonymousRectF.top + f4);
          paramAnonymousCanvas.drawArc(c.this.yR, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(c.this.yR, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f3 - f1 - 1.0F, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(c.this.yR, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(c.this.yR, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.restoreToCount(i);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.top, 1.0F + (paramAnonymousRectF.right - f4), paramAnonymousRectF.top + f4, paramAnonymousPaint);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.bottom - f4, 1.0F + (paramAnonymousRectF.right - f4), paramAnonymousRectF.bottom, paramAnonymousPaint);
        }
        paramAnonymousCanvas.drawRect(paramAnonymousRectF.left, paramAnonymousRectF.top + paramAnonymousFloat, paramAnonymousRectF.right, paramAnonymousRectF.bottom - paramAnonymousFloat, paramAnonymousPaint);
        AppMethodBeat.o(188157);
      }
    };
    AppMethodBeat.o(188161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.cardview.widget.c
 * JD-Core Version:    0.7.0.1
 */