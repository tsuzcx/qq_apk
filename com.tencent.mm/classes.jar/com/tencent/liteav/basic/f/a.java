package com.tencent.liteav.basic.f;

public class a
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public int d;
  public long e;
  public byte[] f;
  
  public Object clone()
  {
    try
    {
      a locala = (a)super.clone();
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.f.a
 * JD-Core Version:    0.7.0.1
 */