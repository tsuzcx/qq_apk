package com.c.a.c;

final class t<T>
  implements s<T>
{
  private final T[] cqH;
  private int pos;
  
  public t(T[] paramArrayOfT)
  {
    this.cqH = paramArrayOfT;
  }
  
  public final boolean aD(T paramT)
  {
    Object[] arrayOfObject = this.cqH;
    int i = this.pos;
    this.pos = (i + 1);
    arrayOfObject[i] = paramT;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.c.t
 * JD-Core Version:    0.7.0.1
 */