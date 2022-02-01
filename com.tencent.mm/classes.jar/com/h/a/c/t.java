package com.h.a.c;

final class t<T>
  implements s<T>
{
  private final T[] ecC;
  private int pos;
  
  public t(T[] paramArrayOfT)
  {
    this.ecC = paramArrayOfT;
  }
  
  public final boolean bU(T paramT)
  {
    Object[] arrayOfObject = this.ecC;
    int i = this.pos;
    this.pos = (i + 1);
    arrayOfObject[i] = paramT;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.h.a.c.t
 * JD-Core Version:    0.7.0.1
 */