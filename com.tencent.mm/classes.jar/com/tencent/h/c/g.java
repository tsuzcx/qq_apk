package com.tencent.h.c;

public abstract class g<T>
{
  private volatile T mInstance;
  
  public final T get()
  {
    Object localObject1 = this.mInstance;
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.mInstance;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = oR();
          this.mInstance = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
  
  protected abstract T oR();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.h.c.g
 * JD-Core Version:    0.7.0.1
 */