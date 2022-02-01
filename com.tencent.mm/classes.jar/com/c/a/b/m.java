package com.c.a.b;

public final class m
{
  long MS;
  String ZJ;
  int cpJ;
  int cpK;
  String mSignature;
  String yZ;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.MS = paramLong;
    this.ZJ = paramString1;
    this.mSignature = paramString2;
    this.yZ = paramString3;
    this.cpJ = paramInt1;
    this.cpK = paramInt2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.ZJ).append(this.mSignature.replace('/', '.')).append(" - ").append(this.yZ).append(":");
    String str;
    switch (this.cpK)
    {
    default: 
      str = String.valueOf(this.cpK);
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
 * Qualified Name:     com.c.a.b.m
 * JD-Core Version:    0.7.0.1
 */