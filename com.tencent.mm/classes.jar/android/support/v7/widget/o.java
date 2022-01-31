package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

final class o
  implements r
{
  private static void f(q paramq)
  {
    if (!paramq.getUseCompatPadding())
    {
      paramq.e(0, 0, 0, 0);
      return;
    }
    float f1 = j(paramq).akQ;
    float f2 = j(paramq).akN;
    int i = (int)Math.ceil(ao.d(f1, f2, paramq.getPreventCornerOverlap()));
    int j = (int)Math.ceil(ao.c(f1, f2, paramq.getPreventCornerOverlap()));
    paramq.e(i, j, i, j);
  }
  
  private static an j(q paramq)
  {
    return (an)paramq.hu();
  }
  
  public final float a(q paramq)
  {
    return j(paramq).akQ;
  }
  
  public final void a(q paramq, float paramFloat)
  {
    paramq = j(paramq);
    if (paramFloat != paramq.akN)
    {
      paramq.akN = paramFloat;
      paramq.h(null);
      paramq.invalidateSelf();
    }
  }
  
  public final void a(q paramq, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramq.l(new an(paramColorStateList, paramFloat1));
    paramContext = paramq.hv();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    b(paramq, paramFloat3);
  }
  
  public final void a(q paramq, ColorStateList paramColorStateList)
  {
    paramq = j(paramq);
    paramq.e(paramColorStateList);
    paramq.invalidateSelf();
  }
  
  public final float b(q paramq)
  {
    return j(paramq).akN * 2.0F;
  }
  
  public final void b(q paramq, float paramFloat)
  {
    j(paramq).a(paramFloat, paramq.getUseCompatPadding(), paramq.getPreventCornerOverlap());
    f(paramq);
  }
  
  public final float c(q paramq)
  {
    return j(paramq).akN * 2.0F;
  }
  
  public final void c(q paramq, float paramFloat)
  {
    paramq.hv().setElevation(paramFloat);
  }
  
  public final float d(q paramq)
  {
    return j(paramq).akN;
  }
  
  public final float e(q paramq)
  {
    return paramq.hv().getElevation();
  }
  
  public final void g(q paramq)
  {
    b(paramq, j(paramq).akQ);
  }
  
  public final void h(q paramq)
  {
    b(paramq, j(paramq).akQ);
  }
  
  public final void hw() {}
  
  public final ColorStateList i(q paramq)
  {
    return j(paramq).akT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.o
 * JD-Core Version:    0.7.0.1
 */