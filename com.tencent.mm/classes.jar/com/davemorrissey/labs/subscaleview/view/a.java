package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;

public final class a
{
  private final k aXd;
  final Integer aXe;
  public boolean aXf;
  public int aXg;
  public int aXh;
  public Rect aXi;
  boolean aXj;
  public final Bitmap bitmap;
  
  a(int paramInt)
  {
    AppMethodBeat.i(157373);
    this.bitmap = null;
    this.aXd = null;
    this.aXe = Integer.valueOf(paramInt);
    this.aXf = true;
    AppMethodBeat.o(157373);
  }
  
  private a(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(213535);
    this.bitmap = paramBitmap;
    this.aXd = null;
    this.aXe = null;
    this.aXf = false;
    this.aXg = paramBitmap.getWidth();
    this.aXh = paramBitmap.getHeight();
    this.aXj = paramBoolean;
    AppMethodBeat.o(213535);
  }
  
  private a(k paramk)
  {
    this.bitmap = null;
    this.aXd = paramk;
    this.aXe = null;
    this.aXf = true;
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
    paramString = new a(new k(paramString));
    AppMethodBeat.o(157374);
    return paramString;
  }
  
  public static a l(Bitmap paramBitmap)
  {
    AppMethodBeat.i(213536);
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("Bitmap must not be null");
      AppMethodBeat.o(213536);
      throw paramBitmap;
    }
    paramBitmap = new a(paramBitmap, false);
    AppMethodBeat.o(213536);
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
    if (this.aXd == null) {
      return null;
    }
    return this.aXd.mUri;
  }
  
  public final a rJ()
  {
    this.aXf = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.a
 * JD-Core Version:    0.7.0.1
 */