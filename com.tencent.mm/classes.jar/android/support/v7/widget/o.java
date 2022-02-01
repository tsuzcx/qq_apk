package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

final class o
  implements r
{
  private static an j(q paramq)
  {
    return (an)paramq.jy();
  }
  
  public final float a(q paramq)
  {
    return j(paramq).auO;
  }
  
  public final void a(q paramq, float paramFloat)
  {
    paramq = j(paramq);
    if (paramFloat != paramq.auL)
    {
      paramq.auL = paramFloat;
      paramq.h(null);
      paramq.invalidateSelf();
    }
  }
  
  public final void a(q paramq, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramq.q(new an(paramColorStateList, paramFloat1));
    paramContext = paramq.jz();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    b(paramq, paramFloat3);
  }
  
  public final void a(q paramq, ColorStateList paramColorStateList)
  {
    paramq = j(paramq);
    paramq.g(paramColorStateList);
    paramq.invalidateSelf();
  }
  
  public final float b(q paramq)
  {
    return j(paramq).auL * 2.0F;
  }
  
  public final void b(q paramq, float paramFloat)
  {
    j(paramq).a(paramFloat, paramq.getUseCompatPadding(), paramq.getPreventCornerOverlap());
    f(paramq);
  }
  
  public final float c(q paramq)
  {
    return j(paramq).auL * 2.0F;
  }
  
  public final void c(q paramq, float paramFloat)
  {
    paramq.jz().setElevation(paramFloat);
  }
  
  public final float d(q paramq)
  {
    return j(paramq).auL;
  }
  
  public final float e(q paramq)
  {
    return paramq.jz().getElevation();
  }
  
  public final void f(q paramq)
  {
    if (!paramq.getUseCompatPadding())
    {
      paramq.e(0, 0, 0, 0);
      return;
    }
    float f1 = j(paramq).auO;
    float f2 = j(paramq).auL;
    int i = (int)Math.ceil(ao.b(f1, f2, paramq.getPreventCornerOverlap()));
    int j = (int)Math.ceil(ao.a(f1, f2, paramq.getPreventCornerOverlap()));
    paramq.e(i, j, i, j);
  }
  
  public final void g(q paramq)
  {
    b(paramq, j(paramq).auO);
  }
  
  public final void h(q paramq)
  {
    b(paramq, j(paramq).auO);
  }
  
  public final ColorStateList i(q paramq)
  {
    return j(paramq).auR;
  }
  
  public final void initStatic() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.o
 * JD-Core Version:    0.7.0.1
 */