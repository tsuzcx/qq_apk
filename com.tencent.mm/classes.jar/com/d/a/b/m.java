package com.d.a.b;

public final class m
{
  String Ud;
  int clj;
  int clk;
  long dI;
  String hi;
  String mSignature;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.dI = paramLong;
    this.hi = paramString1;
    this.mSignature = paramString2;
    this.Ud = paramString3;
    this.clj = paramInt1;
    this.clk = paramInt2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.hi).append(this.mSignature.replace('/', '.')).append(" - ").append(this.Ud).append(":");
    String str;
    switch (this.clk)
    {
    default: 
      str = String.valueOf(this.clk);
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
 * Qualified Name:     com.d.a.b.m
 * JD-Core Version:    0.7.0.1
 */