package com.tencent.mm.plugin.appbrand.h;

import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;

public final class b
{
  public static void a(InputStream paramInputStream, String paramString)
  {
    if ((paramInputStream == null) || (!bK(paramString))) {
      return;
    }
    paramString = new android.support.d.a(paramString);
    a.a(new android.support.d.a(paramInputStream), paramString);
    paramString.setAttribute("Orientation", null);
    paramString.setAttribute("ImageWidth", null);
    paramString.setAttribute("ThumbnailImageWidth", null);
    paramString.saveAttributes();
  }
  
  private static boolean bK(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists());
  }
  
  public static void bv(String paramString1, String paramString2)
  {
    if ((!bK(paramString1)) || (!bK(paramString2))) {
      return;
    }
    paramString2 = new android.support.d.a(paramString2);
    a.a(new android.support.d.a(paramString1), paramString2);
    paramString2.setAttribute("Orientation", null);
    paramString2.setAttribute("ImageWidth", null);
    paramString2.setAttribute("ThumbnailImageWidth", null);
    paramString2.saveAttributes();
  }
  
  public static int v(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return 0;
    }
    try
    {
      int i = new android.support.d.a(paramInputStream).getAttributeInt("Orientation", 1);
      return i;
    }
    catch (Exception paramInputStream) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b
 * JD-Core Version:    0.7.0.1
 */