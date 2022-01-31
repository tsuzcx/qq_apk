package android.support.v4.f;

public final class k$c<T>
  extends k.b<T>
{
  private final Object mLock = new Object();
  
  public k$c(int paramInt)
  {
    super(paramInt);
  }
  
  public final boolean D(T paramT)
  {
    synchronized (this.mLock)
    {
      boolean bool = super.D(paramT);
      return bool;
    }
  }
  
  public final T de()
  {
    synchronized (this.mLock)
    {
      Object localObject2 = super.de();
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.f.k.c
 * JD-Core Version:    0.7.0.1
 */