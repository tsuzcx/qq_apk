package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;

public final class ImageSource
{
  public final Bitmap bitmap;
  boolean cached;
  private final u file;
  final Integer resource;
  public int sHeight;
  public Rect sRegion;
  public int sWidth;
  public boolean tile;
  
  private ImageSource(int paramInt)
  {
    AppMethodBeat.i(157373);
    this.bitmap = null;
    this.file = null;
    this.resource = Integer.valueOf(paramInt);
    this.tile = true;
    AppMethodBeat.o(157373);
  }
  
  private ImageSource(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(208476);
    this.bitmap = paramBitmap;
    this.file = null;
    this.resource = null;
    this.tile = false;
    this.sWidth = paramBitmap.getWidth();
    this.sHeight = paramBitmap.getHeight();
    this.cached = paramBoolean;
    AppMethodBeat.o(208476);
  }
  
  private ImageSource(u paramu)
  {
    this.bitmap = null;
    this.file = paramu;
    this.resource = null;
    this.tile = true;
  }
  
  public static ImageSource asset(String paramString)
  {
    AppMethodBeat.i(208498);
    if (paramString == null)
    {
      paramString = new NullPointerException("Asset name must not be null");
      AppMethodBeat.o(208498);
      throw paramString;
    }
    paramString = uri("assets:///".concat(String.valueOf(paramString)));
    AppMethodBeat.o(208498);
    return paramString;
  }
  
  public static ImageSource bitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(208508);
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("Bitmap must not be null");
      AppMethodBeat.o(208508);
      throw paramBitmap;
    }
    paramBitmap = new ImageSource(paramBitmap, false);
    AppMethodBeat.o(208508);
    return paramBitmap;
  }
  
  public static ImageSource cachedBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(182604);
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("Bitmap must not be null");
      AppMethodBeat.o(182604);
      throw paramBitmap;
    }
    paramBitmap = new ImageSource(paramBitmap, true);
    AppMethodBeat.o(182604);
    return paramBitmap;
  }
  
  public static ImageSource resource(int paramInt)
  {
    AppMethodBeat.i(208495);
    ImageSource localImageSource = new ImageSource(paramInt);
    AppMethodBeat.o(208495);
    return localImageSource;
  }
  
  public static ImageSource uri(String paramString)
  {
    AppMethodBeat.i(157374);
    if (paramString == null)
    {
      paramString = new NullPointerException("Uri must not be null");
      AppMethodBeat.o(157374);
      throw paramString;
    }
    paramString = new ImageSource(new u(paramString));
    AppMethodBeat.o(157374);
    return paramString;
  }
  
  public final Uri getUri()
  {
    if (this.file == null) {
      return null;
    }
    return this.file.mUri;
  }
  
  public final ImageSource tilingEnabled()
  {
    AppMethodBeat.i(208517);
    this.tile = true;
    AppMethodBeat.o(208517);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.ImageSource
 * JD-Core Version:    0.7.0.1
 */