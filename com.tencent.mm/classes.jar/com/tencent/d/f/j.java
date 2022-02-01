package com.tencent.d.f;

public abstract class j<T>
{
  private volatile T mInstance;
  
  protected abstract T fjA();
  
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
        localObject1 = fjA();
        this.mInstance = localObject1;
      }
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.j
 * JD-Core Version:    0.7.0.1
 */