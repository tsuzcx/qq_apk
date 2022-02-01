package com.tencent.map.lib.models;

import android.graphics.Point;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class Polygon2D
{
  public static final int GLPOLYGONMODE2D_BORDER = 2;
  public static final int GLPOLYGONMODE2D_FILL = 1;
  public int borderColor;
  public float borderWidth;
  public int borldLineId;
  public int centerX;
  public int centerY;
  public int color;
  public int level = OverlayLevel.OverlayLevelAboveLabels;
  public int maxScaleLevel = 30;
  public int minScaleLevel;
  public float originalRadius;
  public Point[] points;
  public int pointsCount;
  public int polygonId;
  public int polygonMode;
  public float scale = 1.0F;
  public float zIndex = 0.0F;
  
  public String toString()
  {
    AppMethodBeat.i(195062);
    StringBuffer localStringBuffer1 = new StringBuffer("Polygon2D{");
    localStringBuffer1.append("polygonMode=").append(this.polygonMode);
    localStringBuffer1.append(", color=").append(this.color);
    localStringBuffer1.append(", borderColor=").append(this.borderColor);
    localStringBuffer1.append(", borderWidth=").append(this.borderWidth);
    StringBuffer localStringBuffer2 = localStringBuffer1.append(", points=");
    if (this.points == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.points.length))
    {
      localStringBuffer2.append(localObject);
      localStringBuffer1.append(", polygonId=").append(this.polygonId);
      localStringBuffer1.append(", borldLineId=").append(this.borldLineId);
      localStringBuffer1.append(", centerX=").append(this.centerX);
      localStringBuffer1.append(", centerY=").append(this.centerY);
      localStringBuffer1.append(", pointsCount=").append(this.pointsCount);
      localStringBuffer1.append(", originalRadius=").append(this.originalRadius);
      localStringBuffer1.append(", scale=").append(this.scale);
      localStringBuffer1.append(", zIndex=").append(this.zIndex);
      localStringBuffer1.append(", level=").append(this.level);
      localStringBuffer1.append('}');
      localObject = localStringBuffer1.toString();
      AppMethodBeat.o(195062);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.models.Polygon2D
 * JD-Core Version:    0.7.0.1
 */