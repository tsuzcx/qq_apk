package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  final a bjf;
  final int[] bjg;
  
  b(a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(57201);
    if (paramArrayOfInt.length == 0)
    {
      parama = new IllegalArgumentException();
      AppMethodBeat.o(57201);
      throw parama;
    }
    this.bjf = parama;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      int i = 1;
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.bjg = new int[] { 0 };
        AppMethodBeat.o(57201);
        return;
      }
      this.bjg = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.bjg, 0, this.bjg.length);
      AppMethodBeat.o(57201);
      return;
    }
    this.bjg = paramArrayOfInt;
    AppMethodBeat.o(57201);
  }
  
  private b a(b paramb)
  {
    AppMethodBeat.i(57202);
    if (!this.bjf.equals(paramb.bjf))
    {
      paramb = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
      AppMethodBeat.o(57202);
      throw paramb;
    }
    if (isZero())
    {
      AppMethodBeat.o(57202);
      return paramb;
    }
    if (paramb.isZero())
    {
      AppMethodBeat.o(57202);
      return this;
    }
    Object localObject1 = this.bjg;
    paramb = paramb.bjg;
    if (localObject1.length > paramb.length) {}
    for (;;)
    {
      Object localObject2 = new int[localObject1.length];
      int j = localObject1.length - paramb.length;
      System.arraycopy(localObject1, 0, localObject2, 0, j);
      int i = j;
      while (i < localObject1.length)
      {
        localObject2[i] = a.bv(paramb[(i - j)], localObject1[i]);
        i += 1;
      }
      paramb = new b(this.bjf, (int[])localObject2);
      AppMethodBeat.o(57202);
      return paramb;
      localObject2 = paramb;
      paramb = (b)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private int fd(int paramInt)
  {
    return this.bjg[(this.bjg.length - 1 - paramInt)];
  }
  
  final b[] b(b paramb)
  {
    AppMethodBeat.i(57204);
    if (!this.bjf.equals(paramb.bjf))
    {
      paramb = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
      AppMethodBeat.o(57204);
      throw paramb;
    }
    if (paramb.isZero())
    {
      paramb = new IllegalArgumentException("Divide by 0");
      AppMethodBeat.o(57204);
      throw paramb;
    }
    b localb1 = this.bjf.bjb;
    int i = paramb.fd(paramb.bjg.length - 1);
    Object localObject1 = this.bjf;
    if (i == 0)
    {
      paramb = new ArithmeticException();
      AppMethodBeat.o(57204);
      throw paramb;
    }
    i = localObject1.biZ[(localObject1.size - localObject1.bja[i] - 1)];
    localObject1 = this;
    if ((((b)localObject1).bjg.length - 1 >= paramb.bjg.length - 1) && (!((b)localObject1).isZero()))
    {
      int j = ((b)localObject1).bjg.length - 1 - (paramb.bjg.length - 1);
      int k = this.bjf.bw(((b)localObject1).fd(((b)localObject1).bjg.length - 1), i);
      b localb2 = paramb.bx(j, k);
      Object localObject2 = this.bjf;
      if (j < 0)
      {
        paramb = new IllegalArgumentException();
        AppMethodBeat.o(57204);
        throw paramb;
      }
      if (k == 0) {}
      int[] arrayOfInt;
      for (localObject2 = ((a)localObject2).bjb;; localObject2 = new b((a)localObject2, arrayOfInt))
      {
        localb1 = localb1.a((b)localObject2);
        localObject1 = ((b)localObject1).a(localb2);
        break;
        arrayOfInt = new int[j + 1];
        arrayOfInt[0] = k;
      }
    }
    AppMethodBeat.o(57204);
    return new b[] { localb1, localObject1 };
  }
  
  final b bx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57203);
    if (paramInt1 < 0)
    {
      localObject = new IllegalArgumentException();
      AppMethodBeat.o(57203);
      throw ((Throwable)localObject);
    }
    if (paramInt2 == 0)
    {
      localObject = this.bjf.bjb;
      AppMethodBeat.o(57203);
      return localObject;
    }
    int i = this.bjg.length;
    Object localObject = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      localObject[paramInt1] = this.bjf.bw(this.bjg[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    localObject = new b(this.bjf, (int[])localObject);
    AppMethodBeat.o(57203);
    return localObject;
  }
  
  final boolean isZero()
  {
    boolean bool = false;
    if (this.bjg[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57205);
    Object localObject = new StringBuilder((this.bjg.length - 1) * 8);
    int i = this.bjg.length - 1;
    if (i >= 0)
    {
      int k = fd(i);
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
          a locala = this.bjf;
          if (j == 0)
          {
            localObject = new IllegalArgumentException();
            AppMethodBeat.o(57205);
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
            j = locala.bja[j];
            if (j != 0) {
              break label164;
            }
            ((StringBuilder)localObject).append('1');
          }
        }
        label140:
        if (i != 0)
        {
          if (i != 1) {
            break label198;
          }
          ((StringBuilder)localObject).append('x');
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label164:
        if (j == 1)
        {
          ((StringBuilder)localObject).append('a');
          break label140;
        }
        ((StringBuilder)localObject).append("a^");
        ((StringBuilder)localObject).append(j);
        break label140;
        label198:
        ((StringBuilder)localObject).append("x^");
        ((StringBuilder)localObject).append(i);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(57205);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */