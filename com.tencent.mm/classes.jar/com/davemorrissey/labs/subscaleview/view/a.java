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
  final Integer arl;
  public boolean arm;
  public int arn;
  public int aro;
  public Rect arp;
  boolean arq;
  public final Bitmap bitmap;
  public final Uri uri;
  
  a(int paramInt)
  {
    AppMethodBeat.i(115638);
    this.bitmap = null;
    this.uri = null;
    this.arl = Integer.valueOf(paramInt);
    this.arm = true;
    AppMethodBeat.o(115638);
  }
  
  public a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115636);
    this.bitmap = paramBitmap;
    this.uri = null;
    this.arl = null;
    this.arm = false;
    this.arn = paramBitmap.getWidth();
    this.aro = paramBitmap.getHeight();
    this.arq = true;
    AppMethodBeat.o(115636);
  }
  
  private a(Uri paramUri)
  {
    AppMethodBeat.i(115637);
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
      this.arl = null;
      this.arm = true;
      AppMethodBeat.o(115637);
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
  
  public static a Y(String paramString)
  {
    AppMethodBeat.i(115639);
    if (paramString == null)
    {
      paramString = new NullPointerException("Uri must not be null");
      AppMethodBeat.o(115639);
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
    AppMethodBeat.o(115639);
    return paramString;
  }
  
  public final a lr()
  {
    this.arm = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.a
 * JD-Core Version:    0.7.0.1
 */