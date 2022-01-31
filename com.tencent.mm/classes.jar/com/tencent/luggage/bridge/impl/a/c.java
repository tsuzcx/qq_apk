package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.d.a.b;

public class c
  extends a
{
  public Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    return null;
  }
  
  public boolean match(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
    } while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")));
    return true;
  }
  
  public final String pU()
  {
    return "NetworkImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.c
 * JD-Core Version:    0.7.0.1
 */