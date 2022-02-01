package com.tencent.mm.loader.h;

import com.tencent.mm.loader.h.b.a;
import java.io.OutputStream;

public abstract class f<T>
{
  private T bnW;
  
  f() {}
  
  public f(T paramT)
  {
    this.bnW = paramT;
  }
  
  public abstract a aSj();
  
  public final T aSr()
  {
    return this.bnW;
  }
  
  public abstract void b(OutputStream paramOutputStream);
  
  public static abstract interface a<T>
  {
    public abstract a aSk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.f
 * JD-Core Version:    0.7.0.1
 */