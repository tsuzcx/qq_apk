package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class il
  extends in
{
  private int g;
  private int h;
  private int i;
  private boolean j = true;
  
  public il(im.b... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  private il b()
  {
    AppMethodBeat.i(223223);
    Object localObject = this.e;
    int m = this.e.size();
    im.b[] arrayOfb = new im.b[m];
    int k = 0;
    while (k < m)
    {
      arrayOfb[k] = ((im.b)((im)((ArrayList)localObject).get(k)).e());
      k += 1;
    }
    localObject = new il(arrayOfb);
    AppMethodBeat.o(223223);
    return localObject;
  }
  
  public final Object a(float paramFloat)
  {
    AppMethodBeat.i(223230);
    int k = b(paramFloat);
    AppMethodBeat.o(223230);
    return Integer.valueOf(k);
  }
  
  public final int b(float paramFloat)
  {
    int k = 1;
    AppMethodBeat.i(223251);
    float f1;
    int m;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((im.b)this.e.get(0)).e;
        this.h = ((im.b)this.e.get(1)).e;
        this.i = (this.h - this.g);
      }
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null)
      {
        k = this.g;
        m = (int)(this.i * f1);
        AppMethodBeat.o(223251);
        return k + m;
      }
      k = ((Number)this.f.a(f1, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
      AppMethodBeat.o(223251);
      return k;
    }
    im.b localb;
    float f2;
    float f3;
    if (paramFloat <= 0.0F)
    {
      localObject = (im.b)this.e.get(0);
      localb = (im.b)this.e.get(1);
      k = ((im.b)localObject).e;
      m = localb.e;
      f2 = ((im)localObject).a;
      f3 = localb.a;
      localObject = localb.c;
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null)
      {
        m = (int)(paramFloat * (m - k));
        AppMethodBeat.o(223251);
        return m + k;
      }
      k = ((Number)this.f.a(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
      AppMethodBeat.o(223251);
      return k;
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (im.b)this.e.get(this.a - 2);
      localb = (im.b)this.e.get(this.a - 1);
      k = ((im.b)localObject).e;
      m = localb.e;
      f2 = ((im)localObject).a;
      f3 = localb.a;
      localObject = localb.c;
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null)
      {
        m = (int)(paramFloat * (m - k));
        AppMethodBeat.o(223251);
        return m + k;
      }
      k = ((Number)this.f.a(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
      AppMethodBeat.o(223251);
      return k;
    }
    for (Object localObject = (im.b)this.e.get(0); k < this.a; localObject = localb)
    {
      localb = (im.b)this.e.get(k);
      if (paramFloat < localb.a)
      {
        Interpolator localInterpolator = localb.c;
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((im)localObject).a) / (localb.a - ((im)localObject).a);
        k = ((im.b)localObject).e;
        m = localb.e;
        if (this.f == null)
        {
          m = (int)((m - k) * paramFloat);
          AppMethodBeat.o(223251);
          return m + k;
        }
        k = ((Number)this.f.a(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
        AppMethodBeat.o(223251);
        return k;
      }
      k += 1;
    }
    k = ((Number)((im)this.e.get(this.a - 1)).d()).intValue();
    AppMethodBeat.o(223251);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.il
 * JD-Core Version:    0.7.0.1
 */