package com.tencent.e.f;

public abstract class j<T>
{
  private volatile T mInstance;
  
  public final T get()
  {
    Object localObject3 = this.mInstance;
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = this.mInstance;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = gtQ();
        this.mInstance = localObject1;
      }
      return localObject1;
    }
    finally {}
  }
  
  protected abstract T gtQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.f.j
 * JD-Core Version:    0.7.0.1
 */