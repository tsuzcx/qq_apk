package com.tencent.mapsdk.raster.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BitmapDescriptor
  implements Cloneable
{
  int h;
  Bitmap mBitmap;
  int w;
  
  public BitmapDescriptor(Bitmap paramBitmap)
  {
    AppMethodBeat.i(101150);
    this.w = 0;
    this.h = 0;
    if (paramBitmap != null)
    {
      this.w = paramBitmap.getWidth();
      this.h = paramBitmap.getHeight();
      this.mBitmap = paramBitmap;
    }
    AppMethodBeat.o(101150);
  }
  
  private BitmapDescriptor(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.w = 0;
    this.h = 0;
    this.w = paramInt1;
    this.h = paramInt2;
    this.mBitmap = paramBitmap;
  }
  
  public final BitmapDescriptor clone()
  {
    AppMethodBeat.i(101151);
    BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(Bitmap.createBitmap(this.mBitmap), this.w, this.h);
    AppMethodBeat.o(101151);
    return localBitmapDescriptor;
  }
  
  public final Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public final int getHeight()
  {
    return this.h;
  }
  
  public final int getWidth()
  {
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.BitmapDescriptor
 * JD-Core Version:    0.7.0.1
 */