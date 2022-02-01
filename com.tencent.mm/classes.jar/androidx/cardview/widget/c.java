package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

class c
  implements e
{
  final RectF Rg;
  
  c()
  {
    AppMethodBeat.i(192406);
    this.Rg = new RectF();
    AppMethodBeat.o(192406);
  }
  
  private static g k(d paramd)
  {
    AppMethodBeat.i(192415);
    paramd = (g)paramd.le();
    AppMethodBeat.o(192415);
    return paramd;
  }
  
  public final float a(d paramd)
  {
    AppMethodBeat.i(192577);
    float f = k(paramd).Rz;
    AppMethodBeat.o(192577);
    return f;
  }
  
  public final void a(d paramd, float paramFloat)
  {
    AppMethodBeat.i(192503);
    g localg = k(paramd);
    if (paramFloat < 0.0F)
    {
      paramd = new IllegalArgumentException("Invalid radius " + paramFloat + ". Must be >= 0");
      AppMethodBeat.o(192503);
      throw paramd;
    }
    paramFloat = (int)(0.5F + paramFloat);
    if (localg.Rx != paramFloat)
    {
      localg.Rx = paramFloat;
      localg.RC = true;
      localg.invalidateSelf();
    }
    f(paramd);
    AppMethodBeat.o(192503);
  }
  
  public final void a(d paramd, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(192434);
    paramContext = new g(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    paramContext.af(paramd.getPreventCornerOverlap());
    paramd.k(paramContext);
    f(paramd);
    AppMethodBeat.o(192434);
  }
  
  public final void a(d paramd, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192477);
    paramd = k(paramd);
    paramd.b(paramColorStateList);
    paramd.invalidateSelf();
    AppMethodBeat.o(192477);
  }
  
  public final float b(d paramd)
  {
    AppMethodBeat.i(369495);
    float f = k(paramd).getMinWidth();
    AppMethodBeat.o(369495);
    return f;
  }
  
  public final void b(d paramd, float paramFloat)
  {
    AppMethodBeat.i(192562);
    g localg = k(paramd);
    localg.p(localg.RB, paramFloat);
    f(paramd);
    AppMethodBeat.o(192562);
  }
  
  public final float c(d paramd)
  {
    AppMethodBeat.i(369496);
    float f = k(paramd).getMinHeight();
    AppMethodBeat.o(369496);
    return f;
  }
  
  public final void c(d paramd, float paramFloat)
  {
    AppMethodBeat.i(192530);
    paramd = k(paramd);
    paramd.p(paramFloat, paramd.Rz);
    AppMethodBeat.o(192530);
  }
  
  public final float d(d paramd)
  {
    AppMethodBeat.i(192516);
    float f = k(paramd).Rx;
    AppMethodBeat.o(192516);
    return f;
  }
  
  public final float e(d paramd)
  {
    AppMethodBeat.i(192549);
    float f = k(paramd).RB;
    AppMethodBeat.o(192549);
    return f;
  }
  
  public final void f(d paramd)
  {
    AppMethodBeat.i(192447);
    Rect localRect = new Rect();
    k(paramd).getPadding(localRect);
    paramd.A((int)Math.ceil(k(paramd).getMinWidth()), (int)Math.ceil(k(paramd).getMinHeight()));
    paramd.e(localRect.left, localRect.top, localRect.right, localRect.bottom);
    AppMethodBeat.o(192447);
  }
  
  public final void g(d paramd) {}
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(192464);
    k(paramd).af(paramd.getPreventCornerOverlap());
    f(paramd);
    AppMethodBeat.o(192464);
  }
  
  public final ColorStateList i(d paramd)
  {
    AppMethodBeat.i(192488);
    paramd = k(paramd).Ro;
    AppMethodBeat.o(192488);
    return paramd;
  }
  
  public void initStatic()
  {
    AppMethodBeat.i(192425);
    g.Rt = new c.1(this);
    AppMethodBeat.o(192425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.cardview.widget.c
 * JD-Core Version:    0.7.0.1
 */