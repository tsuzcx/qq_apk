package android.support.v4.e;

public final class l
{
  public static abstract interface a<T>
  {
    public abstract T acquire();
    
    public abstract boolean release(T paramT);
  }
  
  public static class b<T>
    implements l.a<T>
  {
    private final Object[] mPool;
    private int mPoolSize;
    
    public b(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("The max pool size must be > 0");
      }
      this.mPool = new Object[paramInt];
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
      boolean bool = false;
      int i = 0;
      if (i < this.mPoolSize) {
        if (this.mPool[i] != paramT) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label50;
        }
        throw new IllegalStateException("Already in the pool!");
        i += 1;
        break;
      }
      label50:
      if (this.mPoolSize < this.mPool.length)
      {
        this.mPool[this.mPoolSize] = paramT;
        this.mPoolSize += 1;
        bool = true;
      }
      return bool;
    }
  }
  
  public static final class c<T>
    extends l.b<T>
  {
    private final Object mLock = new Object();
    
    public c(int paramInt)
    {
      super();
    }
    
    public final T acquire()
    {
      synchronized (this.mLock)
      {
        Object localObject2 = super.acquire();
        return localObject2;
      }
    }
    
    public final boolean release(T paramT)
    {
      synchronized (this.mLock)
      {
        boolean bool = super.release(paramT);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.l
 * JD-Core Version:    0.7.0.1
 */