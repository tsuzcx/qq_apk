package com.tencent.mm.loader.h;

import com.tencent.mm.loader.h.b.a;
import java.io.OutputStream;

public abstract class f<T>
{
  T data;
  
  f() {}
  
  public f(T paramT)
  {
    this.data = paramT;
  }
  
  public abstract a TU();
  
  public abstract void b(OutputStream paramOutputStream);
  
  public final T value()
  {
    return this.data;
  }
  
  public static abstract interface a<T>
  {
    public abstract a TV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.h.f
 * JD-Core Version:    0.7.0.1
 */