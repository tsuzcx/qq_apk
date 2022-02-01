package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class GroundOverlayInfo
{
  protected float mAlpha = 1.0F;
  protected Bitmap mBitmap;
  protected int mBitmapHeight;
  protected int mBitmapWidth;
  protected LatLngBounds mLatLngBounds;
  protected int mLevel = OverlayLevel.OverlayLevelAboveBuildings;
  protected boolean mVisibility = true;
  protected int mZIndex;
  
  public void setAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(191271);
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.mBitmapWidth = this.mBitmap.getWidth();
      this.mBitmapHeight = this.mBitmap.getHeight();
    }
    AppMethodBeat.o(191271);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.models.GroundOverlayInfo
 * JD-Core Version:    0.7.0.1
 */