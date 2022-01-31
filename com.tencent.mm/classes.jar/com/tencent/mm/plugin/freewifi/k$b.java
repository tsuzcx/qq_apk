package com.tencent.mm.plugin.freewifi;

public enum k$b
{
  public long knD;
  String knE;
  public String name;
  
  private k$b(long paramLong, String paramString1, String paramString2)
  {
    if ((paramLong > 999L) || (paramLong < 0L)) {
      throw new IllegalArgumentException("code must be between 0 and 999");
    }
    this.knD = paramLong;
    this.name = paramString1;
    this.knE = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.k.b
 * JD-Core Version:    0.7.0.1
 */