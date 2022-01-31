package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

final class q
  implements t
{
  private static am i(s params)
  {
    return (am)params.gu();
  }
  
  public final float a(s params)
  {
    return i(params).aiA;
  }
  
  public final void a(s params, float paramFloat)
  {
    params = i(params);
    if (paramFloat != params.aix)
    {
      params.aix = paramFloat;
      params.h(null);
      params.invalidateSelf();
    }
  }
  
  public final void a(s params, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    params.j(new am(paramColorStateList, paramFloat1));
    paramContext = params.gv();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    b(params, paramFloat3);
  }
  
  public final void a(s params, ColorStateList paramColorStateList)
  {
    params = i(params);
    params.e(paramColorStateList);
    params.invalidateSelf();
  }
  
  public final float b(s params)
  {
    return i(params).aix * 2.0F;
  }
  
  public final void b(s params, float paramFloat)
  {
    am localam = i(params);
    boolean bool1 = params.getUseCompatPadding();
    boolean bool2 = params.getPreventCornerOverlap();
    if ((paramFloat != localam.aiA) || (localam.aiB != bool1) || (localam.aiC != bool2))
    {
      localam.aiA = paramFloat;
      localam.aiB = bool1;
      localam.aiC = bool2;
      localam.h(null);
      localam.invalidateSelf();
    }
    if (!params.getUseCompatPadding())
    {
      params.d(0, 0, 0, 0);
      return;
    }
    paramFloat = i(params).aiA;
    float f = i(params).aix;
    int i = (int)Math.ceil(an.d(paramFloat, f, params.getPreventCornerOverlap()));
    int j = (int)Math.ceil(an.c(paramFloat, f, params.getPreventCornerOverlap()));
    params.d(i, j, i, j);
  }
  
  public final float c(s params)
  {
    return i(params).aix * 2.0F;
  }
  
  public final void c(s params, float paramFloat)
  {
    params.gv().setElevation(paramFloat);
  }
  
  public final float d(s params)
  {
    return i(params).aix;
  }
  
  public final float e(s params)
  {
    return params.gv().getElevation();
  }
  
  public final void f(s params)
  {
    b(params, i(params).aiA);
  }
  
  public final void g(s params)
  {
    b(params, i(params).aiA);
  }
  
  public final void gw() {}
  
  public final ColorStateList h(s params)
  {
    return i(params).aiD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.q
 * JD-Core Version:    0.7.0.1
 */