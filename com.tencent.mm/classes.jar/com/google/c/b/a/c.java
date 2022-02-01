package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private final a bIH;
  private final List<b> bIJ;
  
  public c(a parama)
  {
    AppMethodBeat.i(12229);
    this.bIH = parama;
    this.bIJ = new ArrayList();
    this.bIJ.add(new b(parama, new int[] { 1 }));
    AppMethodBeat.o(12229);
  }
  
  private b fS(int paramInt)
  {
    AppMethodBeat.i(12230);
    if (paramInt >= this.bIJ.size())
    {
      localObject1 = (b)this.bIJ.get(this.bIJ.size() - 1);
      int i = this.bIJ.size();
      if (i <= paramInt)
      {
        Object localObject2 = this.bIH;
        Object localObject3 = this.bIH;
        int j = this.bIH.bIG;
        localObject3 = new b((a)localObject2, new int[] { 1, localObject3.bIB[(i - 1 + j)] });
        if (!((b)localObject1).bIH.equals(((b)localObject3).bIH))
        {
          localObject1 = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
          AppMethodBeat.o(12230);
          throw ((Throwable)localObject1);
        }
        if ((((b)localObject1).isZero()) || (((b)localObject3).isZero())) {}
        int[] arrayOfInt;
        for (localObject1 = ((b)localObject1).bIH.bID;; localObject1 = new b(((b)localObject1).bIH, arrayOfInt))
        {
          this.bIJ.add(localObject1);
          i += 1;
          break;
          localObject2 = ((b)localObject1).bII;
          int m = localObject2.length;
          localObject3 = ((b)localObject3).bII;
          int n = localObject3.length;
          arrayOfInt = new int[m + n - 1];
          j = 0;
          while (j < m)
          {
            int i1 = localObject2[j];
            int k = 0;
            while (k < n)
            {
              arrayOfInt[(j + k)] = a.bH(arrayOfInt[(j + k)], ((b)localObject1).bIH.bI(i1, localObject3[k]));
              k += 1;
            }
            j += 1;
          }
        }
      }
    }
    Object localObject1 = (b)this.bIJ.get(paramInt);
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
    Object localObject = fS(paramInt);
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    localObject = new b(this.bIH, arrayOfInt).bJ(paramInt, 1).b(localObject)[1].bII;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.b.a.c
 * JD-Core Version:    0.7.0.1
 */