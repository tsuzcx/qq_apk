package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

public class in
{
  int a;
  im b;
  im c;
  Interpolator d;
  ArrayList<im> e;
  is f;
  
  public in(im... paramVarArgs)
  {
    AppMethodBeat.i(223174);
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((im)this.e.get(0));
    this.c = ((im)this.e.get(this.a - 1));
    this.d = this.c.c;
    AppMethodBeat.o(223174);
  }
  
  private static in a(double... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(223196);
    int j = paramVarArgs.length;
    im.a[] arrayOfa = new im.a[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfa[0] = ((im.a)im.b());
      arrayOfa[1] = ((im.a)im.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      paramVarArgs = new ij(arrayOfa);
      AppMethodBeat.o(223196);
      return paramVarArgs;
      arrayOfa[0] = ((im.a)im.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfa[i] = ((im.a)im.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  private static in a(int... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(223185);
    int j = paramVarArgs.length;
    im.b[] arrayOfb = new im.b[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfb[0] = ((im.b)im.a());
      arrayOfb[1] = ((im.b)im.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      paramVarArgs = new il(arrayOfb);
      AppMethodBeat.o(223185);
      return paramVarArgs;
      arrayOfb[0] = ((im.b)im.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfb[i] = ((im.b)im.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  private static in a(im... paramVarArgs)
  {
    int n = 0;
    AppMethodBeat.i(223209);
    int i1 = paramVarArgs.length;
    int i = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    if (i < i1)
    {
      if ((paramVarArgs[i] instanceof im.a)) {
        j = 1;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramVarArgs[i] instanceof im.b)) {
          k = 1;
        } else {
          m = 1;
        }
      }
    }
    Object localObject;
    if ((j != 0) && (k == 0) && (m == 0))
    {
      localObject = new im.a[i1];
      i = n;
      while (i < i1)
      {
        localObject[i] = ((im.a)paramVarArgs[i]);
        i += 1;
      }
      paramVarArgs = new ij((im.a[])localObject);
      AppMethodBeat.o(223209);
      return paramVarArgs;
    }
    if ((k != 0) && (j == 0) && (m == 0))
    {
      localObject = new im.b[i1];
      i = 0;
      while (i < i1)
      {
        localObject[i] = ((im.b)paramVarArgs[i]);
        i += 1;
      }
      paramVarArgs = new il((im.b[])localObject);
      AppMethodBeat.o(223209);
      return paramVarArgs;
    }
    paramVarArgs = new in(paramVarArgs);
    AppMethodBeat.o(223209);
    return paramVarArgs;
  }
  
  public static in a(Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(223220);
    int j = paramVarArgs.length;
    im.c[] arrayOfc = new im.c[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfc[0] = ((im.c)im.c());
      arrayOfc[1] = ((im.c)im.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      paramVarArgs = new in(arrayOfc);
      AppMethodBeat.o(223220);
      return paramVarArgs;
      arrayOfc[0] = ((im.c)im.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfc[i] = ((im.c)im.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  private void a(is paramis)
  {
    this.f = paramis;
  }
  
  public in a()
  {
    AppMethodBeat.i(223236);
    Object localObject = this.e;
    int j = this.e.size();
    im[] arrayOfim = new im[j];
    int i = 0;
    while (i < j)
    {
      arrayOfim[i] = ((im)((ArrayList)localObject).get(i)).e();
      i += 1;
    }
    localObject = new in(arrayOfim);
    AppMethodBeat.o(223236);
    return localObject;
  }
  
  public Object a(float paramFloat)
  {
    AppMethodBeat.i(223258);
    float f1;
    if (this.a == 2)
    {
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      localObject1 = this.f.a(f1, this.b.d(), this.c.d());
      AppMethodBeat.o(223258);
      return localObject1;
    }
    Object localObject2;
    if (paramFloat <= 0.0F)
    {
      localObject1 = (im)this.e.get(1);
      localObject2 = ((im)localObject1).c;
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = this.b.a;
      paramFloat = (f1 - paramFloat) / (((im)localObject1).a - paramFloat);
      localObject1 = this.f.a(paramFloat, this.b.d(), ((im)localObject1).d());
      AppMethodBeat.o(223258);
      return localObject1;
    }
    if (paramFloat >= 1.0F)
    {
      localObject1 = (im)this.e.get(this.a - 2);
      localObject2 = this.c.c;
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = ((im)localObject1).a;
      paramFloat = (f1 - paramFloat) / (this.c.a - paramFloat);
      localObject1 = this.f.a(paramFloat, ((im)localObject1).d(), this.c.d());
      AppMethodBeat.o(223258);
      return localObject1;
    }
    Object localObject1 = this.b;
    int i = 1;
    while (i < this.a)
    {
      localObject2 = (im)this.e.get(i);
      if (paramFloat < ((im)localObject2).a)
      {
        Interpolator localInterpolator = ((im)localObject2).c;
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = ((im)localObject1).a;
        paramFloat = (f1 - paramFloat) / (((im)localObject2).a - paramFloat);
        localObject1 = this.f.a(paramFloat, ((im)localObject1).d(), ((im)localObject2).d());
        AppMethodBeat.o(223258);
        return localObject1;
      }
      i += 1;
      localObject1 = localObject2;
    }
    localObject1 = this.c.d();
    AppMethodBeat.o(223258);
    return localObject1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(223271);
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      str = str + ((im)this.e.get(i)).d() + "  ";
      i += 1;
    }
    AppMethodBeat.o(223271);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.in
 * JD-Core Version:    0.7.0.1
 */