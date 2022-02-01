package com.d.a.c;

final class t<T>
  implements s<T>
{
  private final T[] bYk;
  private int pos;
  
  public t(T[] paramArrayOfT)
  {
    this.bYk = paramArrayOfT;
  }
  
  public final boolean as(T paramT)
  {
    Object[] arrayOfObject = this.bYk;
    int i = this.pos;
    this.pos = (i + 1);
    arrayOfObject[i] = paramT;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.t
 * JD-Core Version:    0.7.0.1
 */