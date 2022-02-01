package com.tencent.mm.b;

public final class p
  extends Number
{
  private int uin = 0;
  
  public p(int paramInt)
  {
    this.uin = paramInt;
  }
  
  public p(long paramLong)
  {
    this.uin = ((int)(0xFFFFFFFF & paramLong));
  }
  
  public static int dG(String paramString)
  {
    try
    {
      int i = new p(Long.valueOf(paramString).longValue()).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static String getString(int paramInt)
  {
    return new p(paramInt).toString();
  }
  
  public final double doubleValue()
  {
    return (this.uin | 0L) + 0.0D;
  }
  
  public final float floatValue()
  {
    return (float)((this.uin | 0L) + 0.0D);
  }
  
  public final int intValue()
  {
    return this.uin;
  }
  
  public final long longValue()
  {
    return this.uin & 0xFFFFFFFF;
  }
  
  public final String toString()
  {
    return String.valueOf(this.uin & 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.p
 * JD-Core Version:    0.7.0.1
 */