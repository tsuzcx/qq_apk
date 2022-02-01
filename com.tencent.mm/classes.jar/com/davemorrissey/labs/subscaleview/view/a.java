package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;

public final class a
{
  final Integer aWV;
  public boolean aWW;
  public int aWX;
  public int aWY;
  public Rect aWZ;
  boolean aXa;
  public final Bitmap bitmap;
  private final o file;
  
  a(int paramInt)
  {
    AppMethodBeat.i(157373);
    this.bitmap = null;
    this.file = null;
    this.aWV = Integer.valueOf(paramInt);
    this.aWW = true;
    AppMethodBeat.o(157373);
  }
  
  private a(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(208712);
    this.bitmap = paramBitmap;
    this.file = null;
    this.aWV = null;
    this.aWW = false;
    this.aWX = paramBitmap.getWidth();
    this.aWY = paramBitmap.getHeight();
    this.aXa = paramBoolean;
    AppMethodBeat.o(208712);
  }
  
  private a(o paramo)
  {
    this.bitmap = null;
    this.file = paramo;
    this.aWV = null;
    this.aWW = true;
  }
  
  public static a aP(String paramString)
  {
    AppMethodBeat.i(157374);
    if (paramString == null)
    {
      paramString = new NullPointerException("Uri must not be null");
      AppMethodBeat.o(157374);
      throw paramString;
    }
    paramString = new a(new o(paramString));
    AppMethodBeat.o(157374);
    return paramString;
  }
  
  public static a l(Bitmap paramBitmap)
  {
    AppMethodBeat.i(208713);
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("Bitmap must not be null");
      AppMethodBeat.o(208713);
      throw paramBitmap;
    }
    paramBitmap = new a(paramBitmap, false);
    AppMethodBeat.o(208713);
    return paramBitmap;
  }
  
  public static a m(Bitmap paramBitmap)
  {
    AppMethodBeat.i(182604);
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("Bitmap must not be null");
      AppMethodBeat.o(182604);
      throw paramBitmap;
    }
    paramBitmap = new a(paramBitmap, true);
    AppMethodBeat.o(182604);
    return paramBitmap;
  }
  
  public final Uri getUri()
  {
    if (this.file == null) {
      return null;
    }
    return this.file.mUri;
  }
  
  public final a rM()
  {
    this.aWW = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.a
 * JD-Core Version:    0.7.0.1
 */