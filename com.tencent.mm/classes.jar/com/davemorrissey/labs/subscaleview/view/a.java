package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a
{
  final Integer aoR;
  public boolean aoS;
  public int aoT;
  public int aoU;
  public Rect aoV;
  boolean aoW;
  public final Bitmap bitmap;
  public final Uri uri;
  
  a(int paramInt)
  {
    this.bitmap = null;
    this.uri = null;
    this.aoR = Integer.valueOf(paramInt);
    this.aoS = true;
  }
  
  public a(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    this.uri = null;
    this.aoR = null;
    this.aoS = false;
    this.aoT = paramBitmap.getWidth();
    this.aoU = paramBitmap.getHeight();
    this.aoW = true;
  }
  
  private a(Uri paramUri)
  {
    String str = paramUri.toString();
    Uri localUri1 = paramUri;
    if (str.startsWith("file:///"))
    {
      localUri1 = paramUri;
      if (new File(str.substring(7)).exists()) {}
    }
    try
    {
      localUri1 = Uri.parse(URLDecoder.decode(str, "UTF-8"));
      this.bitmap = null;
      this.uri = localUri1;
      this.aoR = null;
      this.aoS = true;
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Uri localUri2 = paramUri;
      }
    }
  }
  
  public static a U(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Uri must not be null");
    }
    String str = paramString;
    if (!paramString.contains("://"))
    {
      str = paramString;
      if (paramString.startsWith("/")) {
        str = paramString.substring(1);
      }
      str = "file:///" + str;
    }
    return new a(Uri.parse(str));
  }
  
  public final a jx()
  {
    this.aoS = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.a
 * JD-Core Version:    0.7.0.1
 */