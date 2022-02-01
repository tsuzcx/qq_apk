package com.davemorrissey.labs.subscaleview.view;

import android.graphics.PointF;
import java.io.Serializable;

public class ImageViewState
  implements Serializable
{
  private float centerX;
  private float centerY;
  int orientation;
  float scale;
  
  public ImageViewState(float paramFloat, PointF paramPointF, int paramInt)
  {
    this.scale = paramFloat;
    this.centerX = paramPointF.x;
    this.centerY = paramPointF.y;
    this.orientation = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.ImageViewState
 * JD-Core Version:    0.7.0.1
 */