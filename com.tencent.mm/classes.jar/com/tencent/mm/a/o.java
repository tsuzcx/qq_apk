package com.tencent.mm.a;

public final class o
  extends Number
{
  private int uin = 0;
  
  public o(int paramInt)
  {
    this.uin = paramInt;
  }
  
  public o(long paramLong)
  {
    this.uin = ((int)(0xFFFFFFFF & paramLong));
  }
  
  public static int bS(String paramString)
  {
    try
    {
      int i = new o(Long.valueOf(paramString).longValue()).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static String getString(int paramInt)
  {
    return new o(paramInt).toString();
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
 * Qualified Name:     com.tencent.mm.a.o
 * JD-Core Version:    0.7.0.1
 */