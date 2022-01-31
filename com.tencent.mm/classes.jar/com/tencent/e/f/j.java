package com.tencent.e.f;

public abstract class j<T>
{
  private volatile T mInstance;
  
  protected abstract T dTV();
  
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
          localObject1 = dTV();
          this.mInstance = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.f.j
 * JD-Core Version:    0.7.0.1
 */