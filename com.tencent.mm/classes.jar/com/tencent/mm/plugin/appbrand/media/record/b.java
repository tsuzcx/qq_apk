package com.tencent.mm.plugin.appbrand.media.record;

public enum b
{
  public int gNu;
  
  private b(int paramInt)
  {
    this.gNu = paramInt;
  }
  
  public static b a(String paramString, b paramb)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    do
    {
      return paramb;
      paramString = valueOf(paramString);
    } while (paramString == null);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.b
 * JD-Core Version:    0.7.0.1
 */