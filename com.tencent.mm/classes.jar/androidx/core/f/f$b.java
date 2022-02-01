package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class f$b<T>
  implements f.a<T>
{
  private final Object[] mPool;
  private int mPoolSize;
  
  public f$b(int paramInt)
  {
    AppMethodBeat.i(251334);
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("The max pool size must be > 0");
      AppMethodBeat.o(251334);
      throw localIllegalArgumentException;
    }
    this.mPool = new Object[paramInt];
    AppMethodBeat.o(251334);
  }
  
  public T acquire()
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
  
  public boolean release(T paramT)
  {
    AppMethodBeat.i(251336);
    int i = 0;
    if (i < this.mPoolSize) {
      if (this.mPool[i] != paramT) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label60;
      }
      paramT = new IllegalStateException("Already in the pool!");
      AppMethodBeat.o(251336);
      throw paramT;
      i += 1;
      break;
    }
    label60:
    if (this.mPoolSize < this.mPool.length)
    {
      this.mPool[this.mPoolSize] = paramT;
      this.mPoolSize += 1;
      AppMethodBeat.o(251336);
      return true;
    }
    AppMethodBeat.o(251336);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.f.f.b
 * JD-Core Version:    0.7.0.1
 */