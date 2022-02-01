package com.h.a.b;

public final class m
{
  String bAz;
  long dI;
  int ebE;
  int ebF;
  String ie;
  String mSignature;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.dI = paramLong;
    this.ie = paramString1;
    this.mSignature = paramString2;
    this.bAz = paramString3;
    this.ebE = paramInt1;
    this.ebF = paramInt2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.ie).append(this.mSignature.replace('/', '.')).append(" - ").append(this.bAz).append(":");
    String str;
    switch (this.ebF)
    {
    default: 
      str = String.valueOf(this.ebF);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.h.a.b.m
 * JD-Core Version:    0.7.0.1
 */