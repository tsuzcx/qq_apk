package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;

public final class a
{
  final Integer aGn;
  public boolean aGo;
  public int aGp;
  public int aGq;
  public Rect aGr;
  boolean aGs;
  public final Bitmap bitmap;
  private final q file;
  
  private a(int paramInt)
  {
    AppMethodBeat.i(157373);
    this.bitmap = null;
    this.file = null;
    this.aGn = Integer.valueOf(paramInt);
    this.aGo = true;
    AppMethodBeat.o(157373);
  }
  
  private a(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(209623);
    this.bitmap = paramBitmap;
    this.file = null;
    this.aGn = null;
    this.aGo = false;
    this.aGp = paramBitmap.getWidth();
    this.aGq = paramBitmap.getHeight();
    this.aGs = paramBoolean;
    AppMethodBeat.o(209623);
  }
  
  private a(q paramq)
  {
    this.bitmap = null;
    this.file = paramq;
    this.aGn = null;
    this.aGo = true;
  }
  
  public static a aY(String paramString)
  {
    AppMethodBeat.i(209626);
    if (paramString == null)
    {
      paramString = new NullPointerException("Asset name must not be null");
      AppMethodBeat.o(209626);
      throw paramString;
    }
    paramString = aZ("assets:///".concat(String.valueOf(paramString)));
    AppMethodBeat.o(209626);
    return paramString;
  }
  
  public static a aZ(String paramString)
  {
    AppMethodBeat.i(157374);
    if (paramString == null)
    {
      paramString = new NullPointerException("Uri must not be null");
      AppMethodBeat.o(157374);
      throw paramString;
    }
    paramString = new a(new q(paramString));
    AppMethodBeat.o(157374);
    return paramString;
  }
  
  public static a dK(int paramInt)
  {
    AppMethodBeat.i(209625);
    a locala = new a(paramInt);
    AppMethodBeat.o(209625);
    return locala;
  }
  
  public static a g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(209629);
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("Bitmap must not be null");
      AppMethodBeat.o(209629);
      throw paramBitmap;
    }
    paramBitmap = new a(paramBitmap, false);
    AppMethodBeat.o(209629);
    return paramBitmap;
  }
  
  public static a h(Bitmap paramBitmap)
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
    AppMethodBeat.i(209633);
    if (this.file == null)
    {
      AppMethodBeat.o(209633);
      return null;
    }
    Uri localUri = this.file.getUri();
    AppMethodBeat.o(209633);
    return localUri;
  }
  
  public final a pA()
  {
    this.aGo = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.a
 * JD-Core Version:    0.7.0.1
 */