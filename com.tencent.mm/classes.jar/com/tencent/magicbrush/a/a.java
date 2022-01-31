package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import java.io.InputStream;

public final class a
{
  private static a.a bki = new a.a()
  {
    public final IBitmap<NativeBitmapStruct> a(String paramAnonymousString, InputStream paramAnonymousInputStream)
    {
      return null;
    }
  };
  
  public static void a(a.a parama)
  {
    bki = parama;
  }
  
  public static a.a qE()
  {
    return bki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.a.a
 * JD-Core Version:    0.7.0.1
 */