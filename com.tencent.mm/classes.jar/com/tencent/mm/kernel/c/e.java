package com.tencent.mm.kernel.c;

public final class e<T extends a>
  implements b, c<T>
{
  private T dNc;
  
  public e(T paramT)
  {
    this.dNc = paramT;
  }
  
  public final T EA()
  {
    return this.dNc;
  }
  
  public final void Ey()
  {
    if ((this.dNc instanceof b)) {
      ((b)this.dNc).Ey();
    }
  }
  
  public final void Ez()
  {
    if ((this.dNc instanceof b)) {
      ((b)this.dNc).Ez();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */