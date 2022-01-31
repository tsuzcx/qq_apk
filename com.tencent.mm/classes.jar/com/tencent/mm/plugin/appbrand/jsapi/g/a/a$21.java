package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;

final class a$21
  implements TencentMap.TencentMapGestureListener
{
  a$21(a parama) {}
  
  public final boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean onDown(float paramFloat1, float paramFloat2)
  {
    this.gtW.gtI = true;
    return false;
  }
  
  public final boolean onFling(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean onLongPress(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onMapStable()
  {
    this.gtW.gtI = false;
  }
  
  public final boolean onScroll(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean onSingleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean onUp(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.21
 * JD-Core Version:    0.7.0.1
 */