package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;

final class a$23
  implements TencentMap.TencentMapGestureListener
{
  a$23(a parama) {}
  
  public final boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean onDown(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146049);
    a.a(this.hOM, true);
    AppMethodBeat.o(146049);
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
    AppMethodBeat.i(146050);
    a.a(this.hOM, false);
    AppMethodBeat.o(146050);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.23
 * JD-Core Version:    0.7.0.1
 */