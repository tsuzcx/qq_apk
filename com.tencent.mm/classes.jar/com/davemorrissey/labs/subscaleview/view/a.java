package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a
{
  final Integer aLW;
  public boolean aLX;
  public int aLY;
  public int aLZ;
  public Rect aMa;
  boolean aMb;
  public final Bitmap bitmap;
  public final Uri uri;
  
  a(int paramInt)
  {
    AppMethodBeat.i(157373);
    this.bitmap = null;
    this.uri = null;
    this.aLW = Integer.valueOf(paramInt);
    this.aLX = true;
    AppMethodBeat.o(157373);
  }
  
  private a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(157371);
    this.bitmap = paramBitmap;
    this.uri = null;
    this.aLW = null;
    this.aLX = false;
    this.aLY = paramBitmap.getWidth();
    this.aLZ = paramBitmap.getHeight();
    this.aMb = true;
    AppMethodBeat.o(157371);
  }
  
  private a(Uri paramUri)
  {
    AppMethodBeat.i(157372);
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
      this.aLW = null;
      this.aLX = true;
      AppMethodBeat.o(157372);
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
    AppMethodBeat.i(157374);
    if (paramString == null)
    {
      paramString = new NullPointerException("Uri must not be null");
      AppMethodBeat.o(157374);
      throw paramString;
    }
    String str = paramString;
    if (!paramString.contains("://"))
    {
      str = paramString;
      if (paramString.startsWith("/")) {
        str = paramString.substring(1);
      }
      str = "file:///".concat(String.valueOf(str));
    }
    paramString = new a(Uri.parse(str));
    AppMethodBeat.o(157374);
    return paramString;
  }
  
  public static a l(Bitmap paramBitmap)
  {
    AppMethodBeat.i(182604);
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("Bitmap must not be null");
      AppMethodBeat.o(182604);
      throw paramBitmap;
    }
    paramBitmap = new a(paramBitmap);
    AppMethodBeat.o(182604);
    return paramBitmap;
  }
  
  public final a qb()
  {
    this.aLX = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.a
 * JD-Core Version:    0.7.0.1
 */