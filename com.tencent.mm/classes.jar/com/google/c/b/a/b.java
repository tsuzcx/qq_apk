package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  final a bKZ;
  final int[] bLa;
  
  b(a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(12266);
    if (paramArrayOfInt.length == 0)
    {
      parama = new IllegalArgumentException();
      AppMethodBeat.o(12266);
      throw parama;
    }
    this.bKZ = parama;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      int i = 1;
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.bLa = new int[] { 0 };
        AppMethodBeat.o(12266);
        return;
      }
      this.bLa = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.bLa, 0, this.bLa.length);
      AppMethodBeat.o(12266);
      return;
    }
    this.bLa = paramArrayOfInt;
    AppMethodBeat.o(12266);
  }
  
  private b a(b paramb)
  {
    AppMethodBeat.i(12267);
    if (!this.bKZ.equals(paramb.bKZ))
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
    Object localObject1 = this.bLa;
    paramb = paramb.bLa;
    if (localObject1.length > paramb.length) {}
    for (;;)
    {
      Object localObject2 = new int[localObject1.length];
      int j = localObject1.length - paramb.length;
      System.arraycopy(localObject1, 0, localObject2, 0, j);
      int i = j;
      while (i < localObject1.length)
      {
        localObject2[i] = a.bK(paramb[(i - j)], localObject1[i]);
        i += 1;
      }
      paramb = new b(this.bKZ, (int[])localObject2);
      AppMethodBeat.o(12267);
      return paramb;
      localObject2 = paramb;
      paramb = (b)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private int gf(int paramInt)
  {
    return this.bLa[(this.bLa.length - 1 - paramInt)];
  }
  
  final b[] b(b paramb)
  {
    AppMethodBeat.i(12269);
    if (!this.bKZ.equals(paramb.bKZ))
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
    b localb1 = this.bKZ.bKV;
    int i = paramb.gf(paramb.bLa.length - 1);
    Object localObject1 = this.bKZ;
    if (i == 0)
    {
      paramb = new ArithmeticException();
      AppMethodBeat.o(12269);
      throw paramb;
    }
    i = localObject1.bKT[(localObject1.size - localObject1.bKU[i] - 1)];
    localObject1 = this;
    if ((((b)localObject1).bLa.length - 1 >= paramb.bLa.length - 1) && (!((b)localObject1).isZero()))
    {
      int j = ((b)localObject1).bLa.length - 1 - (paramb.bLa.length - 1);
      int k = this.bKZ.bL(((b)localObject1).gf(((b)localObject1).bLa.length - 1), i);
      b localb2 = paramb.bM(j, k);
      Object localObject2 = this.bKZ;
      if (j < 0)
      {
        paramb = new IllegalArgumentException();
        AppMethodBeat.o(12269);
        throw paramb;
      }
      if (k == 0) {}
      int[] arrayOfInt;
      for (localObject2 = ((a)localObject2).bKV;; localObject2 = new b((a)localObject2, arrayOfInt))
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
  
  final b bM(int paramInt1, int paramInt2)
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
      localObject = this.bKZ.bKV;
      AppMethodBeat.o(12268);
      return localObject;
    }
    int i = this.bLa.length;
    Object localObject = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      localObject[paramInt1] = this.bKZ.bL(this.bLa[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    localObject = new b(this.bKZ, (int[])localObject);
    AppMethodBeat.o(12268);
    return localObject;
  }
  
  final boolean isZero()
  {
    boolean bool = false;
    if (this.bLa[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12270);
    Object localObject = new StringBuilder((this.bLa.length - 1) * 8);
    int i = this.bLa.length - 1;
    if (i >= 0)
    {
      int k = gf(i);
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
          a locala = this.bKZ;
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
            j = locala.bKU[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.b.a.b
 * JD-Core Version:    0.7.0.1
 */