package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class ij
  extends in
{
  private double g;
  private double h;
  private double i;
  private boolean j = true;
  
  public ij(im.a... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  private ij b()
  {
    AppMethodBeat.i(223339);
    Object localObject = this.e;
    int m = this.e.size();
    im.a[] arrayOfa = new im.a[m];
    int k = 0;
    while (k < m)
    {
      arrayOfa[k] = ((im.a)((im)((ArrayList)localObject).get(k)).e());
      k += 1;
    }
    localObject = new ij(arrayOfa);
    AppMethodBeat.o(223339);
    return localObject;
  }
  
  public final Object a(float paramFloat)
  {
    AppMethodBeat.i(223348);
    double d = b(paramFloat);
    AppMethodBeat.o(223348);
    return Double.valueOf(d);
  }
  
  public final double b(float paramFloat)
  {
    int k = 1;
    AppMethodBeat.i(223365);
    float f1;
    double d2;
    double d3;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((im.a)this.e.get(0)).e;
        this.h = ((im.a)this.e.get(1)).e;
        this.i = (this.h - this.g);
      }
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null)
      {
        d1 = this.g;
        d2 = f1;
        d3 = this.i;
        AppMethodBeat.o(223365);
        return d1 + d2 * d3;
      }
      d1 = ((Number)this.f.a(f1, Double.valueOf(this.g), Double.valueOf(this.h))).doubleValue();
      AppMethodBeat.o(223365);
      return d1;
    }
    im.a locala;
    float f2;
    float f3;
    if (paramFloat <= 0.0F)
    {
      localObject = (im.a)this.e.get(0);
      locala = (im.a)this.e.get(1);
      d1 = ((im.a)localObject).e;
      d2 = locala.e;
      f2 = ((im)localObject).a;
      f3 = locala.a;
      localObject = locala.c;
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null)
      {
        d3 = paramFloat;
        AppMethodBeat.o(223365);
        return d3 * (d2 - d1) + d1;
      }
      d1 = ((Number)this.f.a(paramFloat, Double.valueOf(d1), Double.valueOf(d2))).floatValue();
      AppMethodBeat.o(223365);
      return d1;
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (im.a)this.e.get(this.a - 2);
      locala = (im.a)this.e.get(this.a - 1);
      d1 = ((im.a)localObject).e;
      d2 = locala.e;
      f2 = ((im)localObject).a;
      f3 = locala.a;
      localObject = locala.c;
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null)
      {
        d3 = paramFloat;
        AppMethodBeat.o(223365);
        return d3 * (d2 - d1) + d1;
      }
      d1 = ((Number)this.f.a(paramFloat, Double.valueOf(d1), Double.valueOf(d2))).floatValue();
      AppMethodBeat.o(223365);
      return d1;
    }
    for (Object localObject = (im.a)this.e.get(0); k < this.a; localObject = locala)
    {
      locala = (im.a)this.e.get(k);
      if (paramFloat < locala.a)
      {
        Interpolator localInterpolator = locala.c;
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((im)localObject).a) / (locala.a - ((im)localObject).a);
        d1 = ((im.a)localObject).e;
        d2 = locala.e;
        if (this.f == null)
        {
          d3 = paramFloat;
          AppMethodBeat.o(223365);
          return d3 * (d2 - d1) + d1;
        }
        d1 = ((Number)this.f.a(paramFloat, Double.valueOf(d1), Double.valueOf(d2))).floatValue();
        AppMethodBeat.o(223365);
        return d1;
      }
      k += 1;
    }
    double d1 = ((Number)((im)this.e.get(this.a - 1)).d()).floatValue();
    AppMethodBeat.o(223365);
    return d1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ij
 * JD-Core Version:    0.7.0.1
 */