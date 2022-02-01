package com.e.a.c;

final class t<T>
  implements s<T>
{
  private final T[] cgg;
  private int pos;
  
  public t(T[] paramArrayOfT)
  {
    this.cgg = paramArrayOfT;
  }
  
  public final boolean av(T paramT)
  {
    Object[] arrayOfObject = this.cgg;
    int i = this.pos;
    this.pos = (i + 1);
    arrayOfObject[i] = paramT;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.c.t
 * JD-Core Version:    0.7.0.1
 */