package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.sdk.platformtools.bk;

public enum a
{
  public final int fJy;
  
  private a(int paramInt)
  {
    this.fJy = paramInt;
  }
  
  public static a a(String paramString, a parama)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return parama;
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala.name().toLowerCase().equals(paramString)) {
          return locala;
        }
        i += 1;
      }
    }
  }
  
  public static a lx(int paramInt)
  {
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.fJy == paramInt) {
        return locala;
      }
      i += 1;
    }
    return gwE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a
 * JD-Core Version:    0.7.0.1
 */