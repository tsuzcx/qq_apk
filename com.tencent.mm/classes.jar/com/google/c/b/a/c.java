package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private final a bKZ;
  private final List<b> bLb;
  
  public c(a parama)
  {
    AppMethodBeat.i(12229);
    this.bKZ = parama;
    this.bLb = new ArrayList();
    this.bLb.add(new b(parama, new int[] { 1 }));
    AppMethodBeat.o(12229);
  }
  
  private b gg(int paramInt)
  {
    AppMethodBeat.i(12230);
    if (paramInt >= this.bLb.size())
    {
      localObject1 = (b)this.bLb.get(this.bLb.size() - 1);
      int i = this.bLb.size();
      if (i <= paramInt)
      {
        Object localObject2 = this.bKZ;
        Object localObject3 = this.bKZ;
        int j = this.bKZ.bKY;
        localObject3 = new b((a)localObject2, new int[] { 1, localObject3.bKT[(i - 1 + j)] });
        if (!((b)localObject1).bKZ.equals(((b)localObject3).bKZ))
        {
          localObject1 = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
          AppMethodBeat.o(12230);
          throw ((Throwable)localObject1);
        }
        if ((((b)localObject1).isZero()) || (((b)localObject3).isZero())) {}
        int[] arrayOfInt;
        for (localObject1 = ((b)localObject1).bKZ.bKV;; localObject1 = new b(((b)localObject1).bKZ, arrayOfInt))
        {
          this.bLb.add(localObject1);
          i += 1;
          break;
          localObject2 = ((b)localObject1).bLa;
          int m = localObject2.length;
          localObject3 = ((b)localObject3).bLa;
          int n = localObject3.length;
          arrayOfInt = new int[m + n - 1];
          j = 0;
          while (j < m)
          {
            int i1 = localObject2[j];
            int k = 0;
            while (k < n)
            {
              arrayOfInt[(j + k)] = a.bK(arrayOfInt[(j + k)], ((b)localObject1).bKZ.bL(i1, localObject3[k]));
              k += 1;
            }
            j += 1;
          }
        }
      }
    }
    Object localObject1 = (b)this.bLb.get(paramInt);
    AppMethodBeat.o(12230);
    return localObject1;
  }
  
  public final void e(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(12231);
    if (paramInt == 0)
    {
      paramArrayOfInt = new IllegalArgumentException("No error correction bytes");
      AppMethodBeat.o(12231);
      throw paramArrayOfInt;
    }
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0)
    {
      paramArrayOfInt = new IllegalArgumentException("No data bytes provided");
      AppMethodBeat.o(12231);
      throw paramArrayOfInt;
    }
    Object localObject = gg(paramInt);
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    localObject = new b(this.bKZ, arrayOfInt).bM(paramInt, 1).b(localObject)[1].bLa;
    int j = paramInt - localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      paramArrayOfInt[(i + paramInt)] = 0;
      paramInt += 1;
    }
    System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
    AppMethodBeat.o(12231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.b.a.c
 * JD-Core Version:    0.7.0.1
 */