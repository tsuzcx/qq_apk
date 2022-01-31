package com.tencent.mm.ck;

public final class h<T>
{
  private byte[] dIn = new byte[0];
  private volatile T mInstance;
  private c<T> wDh;
  
  public h(c<T> paramc)
  {
    this.wDh = paramc;
  }
  
  public final T get()
  {
    if (this.mInstance == null) {}
    synchronized (this.dIn)
    {
      if (this.mInstance == null) {
        this.mInstance = this.wDh.get();
      }
      return this.mInstance;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ck.h
 * JD-Core Version:    0.7.0.1
 */