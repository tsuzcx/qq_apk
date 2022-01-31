package com.tencent.mm.plugin.appbrand.appusage;

public enum l$c
{
  private int blr;
  
  private l$c(int paramInt)
  {
    this.blr = paramInt;
  }
  
  public static c ky(int paramInt)
  {
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (paramInt == localc.blr) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l.c
 * JD-Core Version:    0.7.0.1
 */