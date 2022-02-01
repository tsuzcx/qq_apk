package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$b<T>
  implements g.a<T>
{
  private final Object[] mPool;
  private int mPoolSize;
  
  g$b()
  {
    AppMethodBeat.i(193923);
    this.mPool = new Object[256];
    AppMethodBeat.o(193923);
  }
  
  public final T acquire()
  {
    if (this.mPoolSize > 0)
    {
      int i = this.mPoolSize - 1;
      Object localObject = this.mPool[i];
      this.mPool[i] = null;
      this.mPoolSize -= 1;
      return localObject;
    }
    return null;
  }
  
  public final void i(T[] paramArrayOfT, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramArrayOfT.length) {
      i = paramArrayOfT.length;
    }
    paramInt = 0;
    while (paramInt < i)
    {
      T ? = paramArrayOfT[paramInt];
      if (this.mPoolSize < this.mPool.length)
      {
        this.mPool[this.mPoolSize] = ?;
        this.mPoolSize += 1;
      }
      paramInt += 1;
    }
  }
  
  public final boolean release(T paramT)
  {
    if (this.mPoolSize < this.mPool.length)
    {
      this.mPool[this.mPoolSize] = paramT;
      this.mPoolSize += 1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.constraintlayout.a.g.b
 * JD-Core Version:    0.7.0.1
 */