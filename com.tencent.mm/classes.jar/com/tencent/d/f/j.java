package com.tencent.d.f;

public abstract class j<T>
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
          localObject1 = oM();
          this.mInstance = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
  
  protected abstract T oM();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.j
 * JD-Core Version:    0.7.0.1
 */