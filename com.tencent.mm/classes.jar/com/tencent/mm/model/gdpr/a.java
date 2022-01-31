package com.tencent.mm.model.gdpr;

import com.tencent.mm.sdk.platformtools.bk;

public enum a
{
  public final String dYw;
  public final int dYx;
  
  private a(String paramString, int paramInt)
  {
    this.dYw = paramString;
    this.dYx = paramInt;
  }
  
  public static boolean jf(String paramString)
  {
    return jg(paramString) != null;
  }
  
  public static a jg(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return null;
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (paramString.equals(locala.dYw)) {
          return locala;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.a
 * JD-Core Version:    0.7.0.1
 */