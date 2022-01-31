package android.support.v4.e;

public final class k$c<T>
  extends k.b<T>
{
  private final Object mLock = new Object();
  
  public k$c(int paramInt)
  {
    super(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.e.k.c
 * JD-Core Version:    0.7.0.1
 */