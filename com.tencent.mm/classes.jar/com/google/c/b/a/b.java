package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  final a bSV;
  final int[] bSW;
  
  b(a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(12266);
    if (paramArrayOfInt.length == 0)
    {
      parama = new IllegalArgumentException();
      AppMethodBeat.o(12266);
      throw parama;
    }
    this.bSV = parama;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      int i = 1;
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.bSW = new int[] { 0 };
        AppMethodBeat.o(12266);
        return;
      }
      this.bSW = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.bSW, 0, this.bSW.length);
      AppMethodBeat.o(12266);
      return;
    }
    this.bSW = paramArrayOfInt;
    AppMethodBeat.o(12266);
  }
  
  private b a(b paramb)
  {
    AppMethodBeat.i(12267);
    if (!this.bSV.equals(paramb.bSV))
    {
      paramb = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
      AppMethodBeat.o(12267);
      throw paramb;
    }
    if (isZero())
    {
      AppMethodBeat.o(12267);
      return paramb;
    }
    if (paramb.isZero())
    {
      AppMethodBeat.o(12267);
      return this;
    }
    Object localObject1 = this.bSW;
    paramb = paramb.bSW;
    if (localObject1.length > paramb.length) {}
    for (;;)
    {
      Object localObject2 = new int[localObject1.length];
      int j = localObject1.length - paramb.length;
      System.arraycopy(localObject1, 0, localObject2, 0, j);
      int i = j;
      while (i < localObject1.length)
      {
        localObject2[i] = a.bJ(paramb[(i - j)], localObject1[i]);
        i += 1;
      }
      paramb = new b(this.bSV, (int[])localObject2);
      AppMethodBeat.o(12267);
      return paramb;
      localObject2 = paramb;
      paramb = (b)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private int fU(int paramInt)
  {
    return this.bSW[(this.bSW.length - 1 - paramInt)];
  }
  
  final b[] b(b paramb)
  {
    AppMethodBeat.i(12269);
    if (!this.bSV.equals(paramb.bSV))
    {
      paramb = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
      AppMethodBeat.o(12269);
      throw paramb;
    }
    if (paramb.isZero())
    {
      paramb = new IllegalArgumentException("Divide by 0");
      AppMethodBeat.o(12269);
      throw paramb;
    }
    b localb1 = this.bSV.bSR;
    int i = paramb.fU(paramb.bSW.length - 1);
    Object localObject1 = this.bSV;
    if (i == 0)
    {
      paramb = new ArithmeticException();
      AppMethodBeat.o(12269);
      throw paramb;
    }
    i = localObject1.bSP[(localObject1.size - localObject1.bSQ[i] - 1)];
    localObject1 = this;
    if ((((b)localObject1).bSW.length - 1 >= paramb.bSW.length - 1) && (!((b)localObject1).isZero()))
    {
      int j = ((b)localObject1).bSW.length - 1 - (paramb.bSW.length - 1);
      int k = this.bSV.bK(((b)localObject1).fU(((b)localObject1).bSW.length - 1), i);
      b localb2 = paramb.bL(j, k);
      Object localObject2 = this.bSV;
      if (j < 0)
      {
        paramb = new IllegalArgumentException();
        AppMethodBeat.o(12269);
        throw paramb;
      }
      if (k == 0) {}
      int[] arrayOfInt;
      for (localObject2 = ((a)localObject2).bSR;; localObject2 = new b((a)localObject2, arrayOfInt))
      {
        localb1 = localb1.a((b)localObject2);
        localObject1 = ((b)localObject1).a(localb2);
        break;
        arrayOfInt = new int[j + 1];
        arrayOfInt[0] = k;
      }
    }
    AppMethodBeat.o(12269);
    return new b[] { localb1, localObject1 };
  }
  
  final b bL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12268);
    if (paramInt1 < 0)
    {
      localObject = new IllegalArgumentException();
      AppMethodBeat.o(12268);
      throw ((Throwable)localObject);
    }
    if (paramInt2 == 0)
    {
      localObject = this.bSV.bSR;
      AppMethodBeat.o(12268);
      return localObject;
    }
    int i = this.bSW.length;
    Object localObject = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      localObject[paramInt1] = this.bSV.bK(this.bSW[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    localObject = new b(this.bSV, (int[])localObject);
    AppMethodBeat.o(12268);
    return localObject;
  }
  
  final boolean isZero()
  {
    boolean bool = false;
    if (this.bSW[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12270);
    Object localObject = new StringBuilder((this.bSW.length - 1) * 8);
    int i = this.bSW.length - 1;
    if (i >= 0)
    {
      int k = fU(i);
      int j;
      if (k != 0)
      {
        if (k < 0)
        {
          ((StringBuilder)localObject).append(" - ");
          j = -k;
        }
        while ((i == 0) || (j != 1))
        {
          a locala = this.bSV;
          if (j == 0)
          {
            localObject = new IllegalArgumentException();
            AppMethodBeat.o(12270);
            throw ((Throwable)localObject);
            j = k;
            if (((StringBuilder)localObject).length() > 0)
            {
              ((StringBuilder)localObject).append(" + ");
              j = k;
            }
          }
          else
          {
            j = locala.bSQ[j];
            if (j != 0) {
              break label166;
            }
            ((StringBuilder)localObject).append('1');
          }
        }
        label142:
        if (i != 0)
        {
          if (i != 1) {
            break label200;
          }
          ((StringBuilder)localObject).append('x');
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label166:
        if (j == 1)
        {
          ((StringBuilder)localObject).append('a');
          break label142;
        }
        ((StringBuilder)localObject).append("a^");
        ((StringBuilder)localObject).append(j);
        break label142;
        label200:
        ((StringBuilder)localObject).append("x^");
        ((StringBuilder)localObject).append(i);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(12270);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.b.a.b
 * JD-Core Version:    0.7.0.1
 */