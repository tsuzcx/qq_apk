package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;

public class my
  extends GroundOverlayInfo
  implements mo
{
  GroundOverlayOptions a;
  
  public my(Context paramContext, GroundOverlayOptions paramGroundOverlayOptions)
  {
    AppMethodBeat.i(221467);
    if (paramGroundOverlayOptions == null)
    {
      AppMethodBeat.o(221467);
      return;
    }
    this.a = paramGroundOverlayOptions;
    BitmapDescriptor localBitmapDescriptor = this.a.getBitmap();
    if (localBitmapDescriptor != null)
    {
      paramContext = localBitmapDescriptor.getBitmap(paramContext);
      if (paramContext != null)
      {
        this.mBitmapWidth = paramContext.getWidth();
        this.mBitmapHeight = paramContext.getHeight();
      }
      this.mBitmap = paramContext;
    }
    this.mAlpha = paramGroundOverlayOptions.getAlpha();
    this.mVisibility = paramGroundOverlayOptions.isVisible();
    this.mLevel = paramGroundOverlayOptions.getLevel();
    this.mZIndex = paramGroundOverlayOptions.getZIndex();
    if (paramGroundOverlayOptions.getPosition() != null) {
      a();
    }
    if (paramGroundOverlayOptions.getLatLngBounds() != null)
    {
      paramGroundOverlayOptions = paramGroundOverlayOptions.getLatLngBounds();
      paramContext = Parcel.obtain();
      paramContext.writeParcelable(paramGroundOverlayOptions, 0);
      paramContext.setDataPosition(0);
      paramGroundOverlayOptions = paramContext.readParcelable(paramGroundOverlayOptions.getClass().getClassLoader());
      paramContext.recycle();
      this.mLatLngBounds = ((LatLngBounds)paramGroundOverlayOptions);
    }
    AppMethodBeat.o(221467);
  }
  
  private GroundOverlayOptions b()
  {
    return this.a;
  }
  
  final void a()
  {
    AppMethodBeat.i(221487);
    if (this.a.getPosition() == null)
    {
      AppMethodBeat.o(221487);
      return;
    }
    float f1 = Math.max(0.0F, Math.min(1.0F, this.a.getAnchorU()));
    float f2 = Math.max(0.0F, Math.min(1.0F, this.a.getAnchorV()));
    double d1 = Math.pow(2.0D, 20.0F - Math.max(3.0F, Math.min(22.0F, this.a.getZoom())));
    fw localfw = new fw(268435456.0D);
    fl localfl2 = localfw.c(this.a.getPosition());
    fl localfl1 = new fl(localfl2.a - this.mBitmapWidth * f1 * d1, localfl2.b - this.mBitmapHeight * f2 * d1);
    double d2 = localfl2.a;
    double d3 = this.mBitmapWidth;
    double d4 = f1;
    double d5 = localfl2.b;
    double d6 = this.mBitmapHeight;
    localfl2 = new fl(d2 + d3 * (1.0D - d4) * d1, (1.0D - f2) * d6 * d1 + d5);
    this.mLatLngBounds = LatLngBounds.builder().include(localfw.b(localfl1)).include(localfw.b(localfl2)).build();
    AppMethodBeat.o(221487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.my
 * JD-Core Version:    0.7.0.1
 */