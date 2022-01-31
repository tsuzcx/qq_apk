package com.tencent.matrix.iocanary.a;

public final class a
{
  public static final a boi;
  public final int boj;
  public final int bok;
  private final int bol;
  public final int bom;
  private final int mask;
  
  static
  {
    a locala = new a();
    boi = new a(locala.bmz, locala.bon, locala.boo, locala.bop, locala.boq, (byte)0);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mask = paramInt1;
    this.boj = paramInt2;
    this.bol = paramInt4;
    this.bok = paramInt3;
    this.bom = paramInt5;
  }
  
  public final boolean ed(int paramInt)
  {
    return (this.mask & paramInt) > 0;
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig;mask=%d]", new Object[] { Integer.valueOf(this.mask) });
  }
  
  public static final class a
  {
    int bmz = -1;
    int bon = 500;
    int boo = 4096;
    int bop = 20;
    int boq = 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */