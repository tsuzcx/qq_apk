package android.support.constraint.solver;

final class Pools
{
  private static final boolean DEBUG = false;
  
  static abstract interface Pool<T>
  {
    public abstract T acquire();
    
    public abstract boolean release(T paramT);
    
    public abstract void releaseAll(T[] paramArrayOfT, int paramInt);
  }
  
  static class SimplePool<T>
    implements Pools.Pool<T>
  {
    private final Object[] mPool;
    private int mPoolSize;
    
    SimplePool(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("The max pool size must be > 0");
      }
      this.mPool = new Object[paramInt];
    }
    
    private boolean isInPool(T paramT)
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.mPoolSize)
        {
          if (this.mPool[i] == paramT) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
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
      if (this.mPoolSize < this.mPool.length)
      {
        this.mPool[this.mPoolSize] = paramT;
        this.mPoolSize += 1;
        return true;
      }
      return false;
    }
    
    public void releaseAll(T[] paramArrayOfT, int paramInt)
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.Pools
 * JD-Core Version:    0.7.0.1
 */