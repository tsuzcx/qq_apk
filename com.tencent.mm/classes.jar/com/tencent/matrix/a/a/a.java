package com.tencent.matrix.a.a;

public final class a
{
  public static final a bmt = new a().qP();
  public final int bmu;
  public final int bmv;
  public final int bmw;
  public final int bmx;
  public final int bmy;
  private final int mask;
  
  private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mask = paramInt1;
    this.bmu = paramInt2;
    this.bmv = paramInt3;
    this.bmw = paramInt4;
    this.bmx = paramInt5;
    this.bmy = paramInt6;
  }
  
  public final boolean ed(int paramInt)
  {
    return (this.mask & paramInt) > 0;
  }
  
  public final String toString()
  {
    return String.format("[BatteryCanary.BatteryConfig;mask=%d]", new Object[] { Integer.valueOf(this.mask) });
  }
  
  public static final class a
  {
    private int bmA = 120000;
    private int bmB = 20;
    private int bmC = 600000;
    private int bmD = 20;
    private int bmE = 12;
    private int bmz = 0;
    
    public final a ee(int paramInt)
    {
      this.bmz |= paramInt;
      return this;
    }
    
    public final a qP()
    {
      return new a(this.bmz, this.bmA, this.bmB, this.bmC, this.bmD, this.bmE, (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.a.a
 * JD-Core Version:    0.7.0.1
 */