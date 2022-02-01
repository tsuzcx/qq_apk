package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class a$a
{
  static bc mJh;
  static bc mJi;
  static bc mJj;
  static bc mJk;
  static bc mJl;
  static bc mJm;
  static bc mJn;
  public String data;
  long hwQ;
  GestureDetector mDJ;
  private h mJd;
  public boolean mJo;
  
  static
  {
    AppMethodBeat.i(139432);
    mJh = new e.c();
    mJi = new e.e();
    mJj = new e.d();
    mJk = new e.b();
    mJl = new e.a();
    mJm = new a.b((byte)0);
    mJn = new a.c((byte)0);
    AppMethodBeat.o(139432);
  }
  
  public a$a(h paramh)
  {
    AppMethodBeat.i(139422);
    this.hwQ = 0L;
    this.mJd = paramh;
    this.mDJ = new GestureDetector(this.mJd.getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(215807);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(215807);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(215806);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(215806);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(139421);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        a.a.a(a.a.this, paramAnonymousMotionEvent);
        a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(139421);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(215805);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(215805);
        return bool;
      }
    });
    AppMethodBeat.o(139422);
  }
  
  static JSONObject E(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139423);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    paramMotionEvent = new e.f();
    paramMotionEvent.b(j, f1, f2);
    paramMotionEvent = paramMotionEvent.toJSONObject();
    AppMethodBeat.o(139423);
    return paramMotionEvent;
  }
  
  static JSONArray F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139424);
    JSONArray localJSONArray = new JSONArray();
    paramMotionEvent = z(paramMotionEvent);
    if (paramMotionEvent.length > 0)
    {
      int i = 0;
      while (i < paramMotionEvent.length)
      {
        localJSONArray.put(paramMotionEvent[i].toJSONObject());
        i += 1;
      }
    }
    AppMethodBeat.o(139424);
    return localJSONArray;
  }
  
  private static e.f[] z(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(139430);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      e.f localf = new e.f();
      localf.id = paramMotionEvent.getPointerId(i);
      localf.x = paramMotionEvent.getX(i);
      localf.y = paramMotionEvent.getY(i);
      localArrayList.add(localf);
      i += 1;
    }
    paramMotionEvent = new e.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((e.f)localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(139430);
    return paramMotionEvent;
  }
  
  final void a(bc parambc, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(139429);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.data);
    localHashMap.put("touches", paramJSONArray);
    this.mJd.a(parambc.L(localHashMap), null);
    AppMethodBeat.o(139429);
  }
  
  final void b(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139427);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.data);
    localHashMap.put("touch", paramJSONObject);
    this.mJd.a(parambc.L(localHashMap), null);
    AppMethodBeat.o(139427);
  }
  
  final void c(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139428);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.data);
    localHashMap.put("touch", paramJSONObject);
    this.mJd.a(parambc.L(localHashMap));
    AppMethodBeat.o(139428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a
 * JD-Core Version:    0.7.0.1
 */