package com.tencent.mm.plugin.appbrand.jsapi.al.b;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.al.b.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.al.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  int bms;
  volatile Surface mSurface;
  volatile h sOO;
  SkiaCanvasView sOP;
  a sOQ;
  
  public a()
  {
    AppMethodBeat.i(139433);
    this.mSurface = new Surface(new SurfaceTexture(0));
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(139433);
  }
  
  public final void atW()
  {
    AppMethodBeat.i(139435);
    super.atW();
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.bms) });
    AppMethodBeat.o(139435);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139434);
    i(new Surface(paramSurfaceTexture));
    AppMethodBeat.o(139434);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139436);
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.atx() });
    final f localf;
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
      localf = localb.rot;
      final p localp = localb.ros;
      final JSONObject localJSONObject = localb.rmi;
      final int i = localb.ror;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { key(), localp.getName(), localJSONObject.toString() });
      parama = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139419);
          a locala;
          f localf;
          Object localObject;
          int i;
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.al.b.b.b))
          {
            locala = a.this;
            parama.a(new a.3(locala));
            locala = a.this;
            localf = localf;
            localObject = localJSONObject;
            p localp = localp;
            i = i;
            locala.bms = ((JSONObject)localObject).optInt("viewId", 0);
            if (d.L(localf) == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "app is null, fail return");
              localf.callback(i, localp.ZP("fail"));
              AppMethodBeat.o(139419);
              return;
            }
            locala.sOO = ((h)localf);
            locala.sOP = new SkiaCanvasView(d.L(localf), locala.mSurface, localf.getAppId(), locala.bms);
            b.a(locala.bms, locala.sOP);
            locala.sOQ = new a.a(locala.sOO);
            locala.sOQ.data = ((JSONObject)localObject).optString("data", "");
            locala.sOQ.sOZ = ((JSONObject)localObject).optBoolean("gesture", false);
            localf.callback(i, localp.ZP("ok"));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localp instanceof e))
          {
            locala = a.this;
            localf = localf;
            localObject = localp;
            i = i;
            if (locala.sOP == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
              localf.callback(i, ((p)localObject).ZP("fail:internal error"));
              AppMethodBeat.o(139419);
              return;
            }
            localf.callback(i, ((p)localObject).ZP("ok"));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.al.b.b.d))
          {
            locala = a.this;
            localf = localf;
            localObject = localp;
            i = i;
            if (locala.sOP == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
              localf.callback(i, ((p)localObject).ZP("fail:internal error"));
              AppMethodBeat.o(139419);
              return;
            }
            locala.release();
            localf.callback(i, ((p)localObject).ZP("ok"));
          }
          AppMethodBeat.o(139419);
        }
      };
      if (localf.getAsyncHandler().getLooper() != Looper.myLooper()) {
        break label142;
      }
      parama.run();
    }
    for (;;)
    {
      AppMethodBeat.o(139436);
      return null;
      label142:
      localf.getAsyncHandler().post(parama);
    }
  }
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(327041);
    super.i(paramSurface);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.bms) });
    this.mSurface = paramSurface;
    if (this.sOO == null)
    {
      Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, updateSurfaceTextureIfNeed return");
      AppMethodBeat.o(327041);
      return;
    }
    this.sOO.getAsyncHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139418);
        if (a.this.sOP != null)
        {
          a.this.sOP.swapSurface(a.this.mSurface);
          if (a.this.sOO == null)
          {
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, onXWebCanvasSurfaceChange return");
            AppMethodBeat.o(139418);
            return;
          }
          Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.this.bms) });
          c.k(a.this.sOO, a.this.bms);
          AppMethodBeat.o(139418);
          return;
        }
        Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
        AppMethodBeat.o(139418);
      }
    });
    AppMethodBeat.o(327041);
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139439);
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    Object localObject;
    if (this.sOQ != null)
    {
      localObject = this.sOQ;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      localObject = ((a)localObject).mQj;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMotionEvent.aYi(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(139439);
      return;
      ((a)localObject).b(((a)localObject).sOS, a.C(paramMotionEvent));
      continue;
      ((a)localObject).a(((a)localObject).sOV, a.D(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - ((a)localObject).mJI >= 20L)
      {
        ((a)localObject).mJI = System.currentTimeMillis();
        ((a)localObject).a(((a)localObject).sOU, a.D(paramMotionEvent));
        continue;
        ((a)localObject).b(((a)localObject).sOT, a.C(paramMotionEvent));
        ((a)localObject).c(((a)localObject).sOY, a.C(paramMotionEvent));
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(139440);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    if (this.sOP != null) {
      this.sOP.recycle();
    }
    b.remove(this.bms);
    AppMethodBeat.o(139440);
  }
  
  static final class a
  {
    public String data;
    long mJI;
    GestureDetector mQj;
    private h sOO;
    bc sOS;
    bc sOT;
    bc sOU;
    bc sOV;
    bc sOW;
    bc sOX;
    bc sOY;
    public boolean sOZ;
    
    public a(h paramh)
    {
      AppMethodBeat.i(139422);
      this.sOS = new e.c();
      this.sOT = new e.e();
      this.sOU = new e.d();
      this.sOV = new e.b();
      this.sOW = new e.a();
      this.sOX = new a.b((byte)0);
      this.sOY = new a.c((byte)0);
      this.mJI = 0L;
      this.sOO = paramh;
      this.mQj = new GestureDetector(this.sOO.getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(327038);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(327038);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(327032);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(327032);
          return bool;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(139421);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = a.a.this;
          ((a.a)localObject).b(((a.a)localObject).sOW, a.a.C(paramAnonymousMotionEvent));
          ((a.a)localObject).c(((a.a)localObject).sOX, a.a.C(paramAnonymousMotionEvent));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(139421);
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(327028);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
          boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(327028);
          return bool;
        }
      });
      AppMethodBeat.o(139422);
    }
    
    private static e.f[] A(MotionEvent paramMotionEvent)
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
    
    static JSONObject C(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139423);
      int i = paramMotionEvent.getActionIndex();
      int j = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      paramMotionEvent = new e.f();
      paramMotionEvent.c(j, f1, f2);
      paramMotionEvent = paramMotionEvent.aZh();
      AppMethodBeat.o(139423);
      return paramMotionEvent;
    }
    
    static JSONArray D(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139424);
      JSONArray localJSONArray = new JSONArray();
      paramMotionEvent = A(paramMotionEvent);
      if ((paramMotionEvent != null) && (paramMotionEvent.length > 0))
      {
        int i = 0;
        while (i < paramMotionEvent.length)
        {
          localJSONArray.put(paramMotionEvent[i].aZh());
          i += 1;
        }
      }
      AppMethodBeat.o(139424);
      return localJSONArray;
    }
    
    final void a(bc parambc, JSONArray paramJSONArray)
    {
      AppMethodBeat.i(139429);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touches", paramJSONArray);
      this.sOO.a(parambc.L(localHashMap), null);
      AppMethodBeat.o(139429);
    }
    
    final void b(bc parambc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139427);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.sOO.a(parambc.L(localHashMap), null);
      AppMethodBeat.o(139427);
    }
    
    final void c(bc parambc, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139428);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.sOO.a(parambc.L(localHashMap));
      AppMethodBeat.o(139428);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.a
 * JD-Core Version:    0.7.0.1
 */