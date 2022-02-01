package com.e.a.b;

public final class m
{
  long MI;
  String Zw;
  String cff;
  int cfh;
  int cfi;
  String yT;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.MI = paramLong;
    this.Zw = paramString1;
    this.cff = paramString2;
    this.yT = paramString3;
    this.cfh = paramInt1;
    this.cfi = paramInt2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.Zw).append(this.cff.replace('/', '.')).append(" - ").append(this.yT).append(":");
    String str;
    switch (this.cfi)
    {
    default: 
      str = String.valueOf(this.cfi);
    }
    for (;;)
    {
      return str;
      str = "No line number";
      continue;
      str = "Unknown line number";
      continue;
      str = "Compiled method";
      continue;
      str = "Native method";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.b.m
 * JD-Core Version:    0.7.0.1
 */