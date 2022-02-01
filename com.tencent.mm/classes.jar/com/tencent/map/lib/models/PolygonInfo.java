package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class PolygonInfo
{
  public int borderColor;
  public int borderLineId;
  public float borderWidth;
  public int color;
  public int level = OverlayLevel.OverlayLevelAboveLabels;
  public int maxScaleLevel = 30;
  public int minScaleLevel;
  public int[] pattern;
  public LatLng[] points;
  public int polygonId;
  public String textureName;
  public int textureSpacing;
  public float zIndex = 0.0F;
  
  public String toString()
  {
    AppMethodBeat.i(193500);
    StringBuffer localStringBuffer1 = new StringBuffer("Polygon2D{");
    localStringBuffer1.append(", color=").append(this.color);
    localStringBuffer1.append(", borderColor=").append(this.borderColor);
    localStringBuffer1.append(", borderWidth=").append(this.borderWidth);
    StringBuffer localStringBuffer2 = localStringBuffer1.append(", points=");
    if (this.points == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.points.length))
    {
      localStringBuffer2.append(localObject);
      localStringBuffer1.append(", polygonId=").append(this.polygonId);
      localStringBuffer1.append(", borderLineId=").append(this.borderLineId);
      localStringBuffer1.append(", zIndex=").append(this.zIndex);
      localStringBuffer1.append(", level=").append(this.level);
      localStringBuffer1.append('}');
      localObject = localStringBuffer1.toString();
      AppMethodBeat.o(193500);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.models.PolygonInfo
 * JD-Core Version:    0.7.0.1
 */