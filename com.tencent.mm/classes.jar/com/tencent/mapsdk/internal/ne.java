package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import java.util.Arrays;

public class ne
  extends IntersectionOverlayInfo
  implements mo
{
  public ne(IntersectionOverlayOptions paramIntersectionOverlayOptions)
  {
    AppMethodBeat.i(221385);
    this.mBounds = paramIntersectionOverlayOptions.getBounds();
    if (paramIntersectionOverlayOptions.getData() != null) {}
    for (this.mData = Arrays.copyOf(paramIntersectionOverlayOptions.getData(), paramIntersectionOverlayOptions.getData().length);; this.mData = new byte[0])
    {
      this.mVisibility = paramIntersectionOverlayOptions.isVisibility();
      this.mDistance = paramIntersectionOverlayOptions.getDistance();
      this.mIsDarkMode = paramIntersectionOverlayOptions.isDarkMode();
      AppMethodBeat.o(221385);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ne
 * JD-Core Version:    0.7.0.1
 */