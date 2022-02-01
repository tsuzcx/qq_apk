package androidx.compose.runtime.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", "key", "", "get", "newWith", "value", "trySet", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final Object[] aqm;
  private final long[] arC;
  private final int size;
  
  public d(int paramInt, long[] paramArrayOfLong, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(202281);
    this.size = paramInt;
    this.arC = paramArrayOfLong;
    this.aqm = paramArrayOfObject;
    AppMethodBeat.o(202281);
  }
  
  private final int B(long paramLong)
  {
    int k = -1;
    int j = 0;
    int m = this.size - 1;
    int i = k;
    switch (m)
    {
    default: 
      i = m;
    }
    while (j <= i)
    {
      k = j + i >>> 1;
      long l = this.arC[k] - paramLong;
      if (l < 0L)
      {
        j = k + 1;
        continue;
        if (this.arC[0] == paramLong) {
          i = 0;
        }
      }
      do
      {
        do
        {
          return i;
          i = k;
        } while (this.arC[0] <= paramLong);
        return -2;
        i = k;
      } while (l <= 0L);
      i = k - 1;
    }
    return -(j + 1);
  }
  
  public final Object A(long paramLong)
  {
    AppMethodBeat.i(202288);
    int i = B(paramLong);
    if (i >= 0)
    {
      Object localObject = this.aqm[i];
      AppMethodBeat.o(202288);
      return localObject;
    }
    AppMethodBeat.o(202288);
    return null;
  }
  
  public final boolean c(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(202293);
    int i = B(paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(202293);
      return false;
    }
    this.aqm[i] = paramObject;
    AppMethodBeat.o(202293);
    return true;
  }
  
  public final d d(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(202300);
    int n = this.size;
    Object localObject1 = this.aqm;
    int i1 = localObject1.length;
    int i = 0;
    int j = 0;
    int k;
    if (i < i1)
    {
      if (localObject1[i] != null) {}
      for (m = 1;; m = 0)
      {
        k = j;
        if (m != 0) {
          k = j + 1;
        }
        i += 1;
        j = k;
        break;
      }
    }
    int m = j + 1;
    localObject1 = new long[m];
    Object[] arrayOfObject = new Object[m];
    long l;
    Object localObject2;
    if (m > 1)
    {
      i = 0;
      j = 0;
      k = j;
      if (j < m)
      {
        k = j;
        if (i < n)
        {
          l = this.arC[i];
          localObject2 = this.aqm[i];
          if (l <= paramLong) {
            break label224;
          }
          localObject1[j] = paramLong;
          arrayOfObject[j] = paramObject;
          k = j + 1;
        }
      }
      j = i;
      if (i == n)
      {
        localObject1[(m - 1)] = paramLong;
        arrayOfObject[(m - 1)] = paramObject;
      }
    }
    for (;;)
    {
      paramObject = new d(m, (long[])localObject1, arrayOfObject);
      AppMethodBeat.o(202300);
      return paramObject;
      label224:
      k = j;
      if (localObject2 != null)
      {
        localObject1[j] = l;
        arrayOfObject[j] = localObject2;
        k = j + 1;
      }
      i += 1;
      j = k;
      break;
      while (k < m)
      {
        paramLong = this.arC[j];
        paramObject = this.aqm[j];
        i = k;
        if (paramObject != null)
        {
          localObject1[k] = paramLong;
          arrayOfObject[k] = paramObject;
          i = k + 1;
        }
        j += 1;
        k = i;
      }
      continue;
      localObject1[0] = paramLong;
      arrayOfObject[0] = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.c.d
 * JD-Core Version:    0.7.0.1
 */