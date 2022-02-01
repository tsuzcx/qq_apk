package com.d.a.c;

final class u<T>
  implements t<T>
{
  private final T[] cmk;
  private int pos;
  
  public u(T[] paramArrayOfT)
  {
    this.cmk = paramArrayOfT;
  }
  
  public final boolean az(T paramT)
  {
    Object[] arrayOfObject = this.cmk;
    int i = this.pos;
    this.pos = (i + 1);
    arrayOfObject[i] = paramT;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.u
 * JD-Core Version:    0.7.0.1
 */