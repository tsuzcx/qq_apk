package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class Overlay
{
  protected static final float SHADOW_X_SKEW = -0.89F;
  protected static final float SHADOW_Y_SCALE = 0.5F;
  
  protected void draw(Canvas paramCanvas, MapView paramMapView) {}
  
  protected void onEmptyTap(GeoPoint paramGeoPoint) {}
  
  protected boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  protected boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  protected boolean onLongPress(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  protected void onRemoveOverlay() {}
  
  protected boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    return false;
  }
  
  protected boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.Overlay
 * JD-Core Version:    0.7.0.1
 */