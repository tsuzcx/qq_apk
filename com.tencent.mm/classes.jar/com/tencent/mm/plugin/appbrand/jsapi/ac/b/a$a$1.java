package com.tencent.mm.plugin.appbrand.jsapi.ac.b;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class a$a$1
  extends GestureDetector.SimpleOnGestureListener
{
  a$a$1(a.a parama) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186900);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(186900);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186899);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(186899);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139421);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    a.a.a(this.lxu, paramMotionEvent);
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(139421);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186898);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(186898);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */