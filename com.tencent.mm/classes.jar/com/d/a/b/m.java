package com.d.a.b;

public final class m
{
  long JV;
  String WM;
  String bXk;
  int bXl;
  int bXm;
  String wd;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.JV = paramLong;
    this.WM = paramString1;
    this.bXk = paramString2;
    this.wd = paramString3;
    this.bXl = paramInt1;
    this.bXm = paramInt2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.WM).append(this.bXk.replace('/', '.')).append(" - ").append(this.wd).append(":");
    String str;
    switch (this.bXm)
    {
    default: 
      str = String.valueOf(this.bXm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.d.a.b.m
 * JD-Core Version:    0.7.0.1
 */