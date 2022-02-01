package com.tencent.mapsdk.internal;

public abstract class mm<T extends mo>
{
  protected int a;
  protected long b;
  protected mn<T> c;
  protected T d;
  
  protected mm(mn<T> parammn, T paramT)
  {
    this.c = parammn;
    this.d = paramT;
  }
  
  public final T a()
  {
    return this.d;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(T paramT)
  {
    if ((this.c == null) || (paramT == null)) {
      return;
    }
    this.d = paramT;
    this.c.a(this);
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.a;
  }
  
  public String getId()
  {
    return this.a;
  }
  
  public void remove()
  {
    if (this.c == null) {
      return;
    }
    this.c.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mm
 * JD-Core Version:    0.7.0.1
 */