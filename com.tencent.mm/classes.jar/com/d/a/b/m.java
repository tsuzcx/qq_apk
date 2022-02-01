package com.d.a.b;

public final class m
{
  long KQ;
  String XH;
  String bUS;
  int bUT;
  int bUU;
  String xb;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.KQ = paramLong;
    this.XH = paramString1;
    this.bUS = paramString2;
    this.xb = paramString3;
    this.bUT = paramInt1;
    this.bUU = paramInt2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.XH).append(this.bUS.replace('/', '.')).append(" - ").append(this.xb).append(":");
    String str;
    switch (this.bUU)
    {
    default: 
      str = String.valueOf(this.bUU);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.b.m
 * JD-Core Version:    0.7.0.1
 */