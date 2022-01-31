package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private final a bjf;
  private final List<b> bjh;
  
  public c(a parama)
  {
    AppMethodBeat.i(57164);
    this.bjf = parama;
    this.bjh = new ArrayList();
    this.bjh.add(new b(parama, new int[] { 1 }));
    AppMethodBeat.o(57164);
  }
  
  private b fe(int paramInt)
  {
    AppMethodBeat.i(57165);
    if (paramInt >= this.bjh.size())
    {
      localObject1 = (b)this.bjh.get(this.bjh.size() - 1);
      int i = this.bjh.size();
      if (i <= paramInt)
      {
        Object localObject2 = this.bjf;
        Object localObject3 = this.bjf;
        int j = this.bjf.bje;
        localObject3 = new b((a)localObject2, new int[] { 1, localObject3.biZ[(i - 1 + j)] });
        if (!((b)localObject1).bjf.equals(((b)localObject3).bjf))
        {
          localObject1 = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
          AppMethodBeat.o(57165);
          throw ((Throwable)localObject1);
        }
        if ((((b)localObject1).isZero()) || (((b)localObject3).isZero())) {}
        int[] arrayOfInt;
        for (localObject1 = ((b)localObject1).bjf.bjb;; localObject1 = new b(((b)localObject1).bjf, arrayOfInt))
        {
          this.bjh.add(localObject1);
          i += 1;
          break;
          localObject2 = ((b)localObject1).bjg;
          int m = localObject2.length;
          localObject3 = ((b)localObject3).bjg;
          int n = localObject3.length;
          arrayOfInt = new int[m + n - 1];
          j = 0;
          while (j < m)
          {
            int i1 = localObject2[j];
            int k = 0;
            while (k < n)
            {
              arrayOfInt[(j + k)] = a.bv(arrayOfInt[(j + k)], ((b)localObject1).bjf.bw(i1, localObject3[k]));
              k += 1;
            }
            j += 1;
          }
        }
      }
    }
    Object localObject1 = (b)this.bjh.get(paramInt);
    AppMethodBeat.o(57165);
    return localObject1;
  }
  
  public final void e(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(57166);
    if (paramInt == 0)
    {
      paramArrayOfInt = new IllegalArgumentException("No error correction bytes");
      AppMethodBeat.o(57166);
      throw paramArrayOfInt;
    }
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0)
    {
      paramArrayOfInt = new IllegalArgumentException("No data bytes provided");
      AppMethodBeat.o(57166);
      throw paramArrayOfInt;
    }
    Object localObject = fe(paramInt);
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    localObject = new b(this.bjf, arrayOfInt).bx(paramInt, 1).b(localObject)[1].bjg;
    int j = paramInt - localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      paramArrayOfInt[(i + paramInt)] = 0;
      paramInt += 1;
    }
    System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
    AppMethodBeat.o(57166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.b.a.c
 * JD-Core Version:    0.7.0.1
 */