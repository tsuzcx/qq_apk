package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

public class GroundOverlayInfo
{
  protected float mAlpha = 1.0F;
  protected Bitmap mBitmap;
  protected int mBitmapHeight;
  protected int mBitmapWidth;
  protected LatLngBounds mLatLngBounds;
  protected int mLevel = 1;
  protected boolean mVisibility = true;
  protected int mZIndex;
  
  public boolean checkValid()
  {
    return this.mBitmap != null;
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(210955);
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.mBitmapWidth = this.mBitmap.getWidth();
      this.mBitmapHeight = this.mBitmap.getHeight();
    }
    AppMethodBeat.o(210955);
  }
  
  public void setLatLngBounds(LatLngBounds paramLatLngBounds)
  {
    this.mLatLngBounds = paramLatLngBounds;
  }
  
  public void setLevel(int paramInt)
  {
    this.mLevel = paramInt;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
  }
  
  public void setZIndex(int paramInt)
  {
    this.mZIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.lib.models.GroundOverlayInfo
 * JD-Core Version:    0.7.0.1
 */