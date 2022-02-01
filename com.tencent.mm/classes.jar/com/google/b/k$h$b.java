package com.google.b;

public enum k$h$b
  implements cl
{
  private static final be.b<b> bRT = new be.b() {};
  private static final b[] bSz = values();
  final int value;
  
  static
  {
    bSA = new b[] { bSw, bSx, bSy };
  }
  
  private k$h$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static b hj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return bSw;
    case 1: 
      return bSx;
    }
    return bSy;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.k.h.b
 * JD-Core Version:    0.7.0.1
 */