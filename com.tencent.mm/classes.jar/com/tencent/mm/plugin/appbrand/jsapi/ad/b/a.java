package com.tencent.mm.plugin.appbrand.jsapi.ad.b;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  com.tencent.mm.plugin.appbrand.jsapi.e lBF;
  SkiaCanvasView lBG;
  a lBH;
  private List<com.tencent.luggage.xweb_ext.extendplugin.a> lBI;
  private volatile boolean mIsInit;
  SurfaceTexture mSurfaceTexture;
  int mViewId;
  
  public a()
  {
    AppMethodBeat.i(139433);
    this.lBI = new ArrayList();
    ae.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(139433);
  }
  
  private static void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(139438);
    if (paramc.aYA().getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(139438);
      return;
    }
    paramc.aYA().post(paramRunnable);
    AppMethodBeat.o(139438);
  }
  
  private void z(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139437);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
      final com.tencent.mm.plugin.appbrand.jsapi.c localc = localb.kmw;
      final m localm = localb.kmv;
      final JSONObject localJSONObject = localb.kkm;
      final int i = localb.kmu;
      ae.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { BN(), localm.getName(), localJSONObject.toString() });
      b(localc, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139419);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.c localc;
          Object localObject;
          int i;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.b))
          {
            locala = a.this;
            parama.a(new a.3(locala));
            locala = a.this;
            localc = localc;
            localObject = localJSONObject;
            m localm = localm;
            i = i;
            locala.mViewId = ((JSONObject)localObject).optInt("viewId", 0);
            locala.lBG = new SkiaCanvasView(c.F(localc), locala.mSurfaceTexture, localc.getAppId(), locala.mViewId);
            locala.lBF = ((com.tencent.mm.plugin.appbrand.jsapi.e)localc);
            locala.lBH = new a.a(locala.lBF);
            locala.lBH.data = ((JSONObject)localObject).optString("data", "");
            locala.lBH.lBR = ((JSONObject)localObject).optBoolean("gesture", false);
            localc.h(i, localm.e("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.e))
          {
            locala = a.this;
            localc = localc;
            localObject = localm;
            i = i;
            if (locala.lBG == null)
            {
              ae.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
              localc.h(i, ((m)localObject).e("fail:internal error", null));
              AppMethodBeat.o(139419);
              return;
            }
            localc.h(i, ((m)localObject).e("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localm instanceof d))
          {
            locala = a.this;
            localc = localc;
            localObject = localm;
            i = i;
            if (locala.lBG == null)
            {
              ae.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
              localc.h(i, ((m)localObject).e("fail:internal error", null));
              AppMethodBeat.o(139419);
              return;
            }
            locala.release();
            localc.h(i, ((m)localObject).e("ok", null));
          }
          AppMethodBeat.o(139419);
        }
      });
    }
    AppMethodBeat.o(139437);
  }
  
  public final void Gh()
  {
    AppMethodBeat.i(139435);
    super.Gh();
    ae.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    AppMethodBeat.o(139435);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139434);
    super.e(paramSurfaceTexture);
    ae.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.mIsInit)
    {
      this.lBF.aYA().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139418);
          if (a.this.lBG != null)
          {
            a.this.lBG.swapSurface(a.this.mSurfaceTexture);
            if (a.this.lBF == null)
            {
              ae.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, return");
              AppMethodBeat.o(139418);
              return;
            }
            ae.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.this.mViewId) });
            com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.c.e(a.this.lBF, a.this.mViewId);
            AppMethodBeat.o(139418);
            return;
          }
          ae.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
          AppMethodBeat.o(139418);
        }
      });
      AppMethodBeat.o(139434);
      return;
    }
    if (this.lBI.size() > 0)
    {
      paramSurfaceTexture = this.lBI.iterator();
      while (paramSurfaceTexture.hasNext()) {
        z((com.tencent.luggage.xweb_ext.extendplugin.a)paramSurfaceTexture.next());
      }
      this.lBI.clear();
    }
    this.mIsInit = true;
    AppMethodBeat.o(139434);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139436);
    ae.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.FK() });
    if (this.mIsInit) {
      z(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(139436);
      return null;
      this.lBI.add(parama);
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139439);
    ae.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    Object localObject;
    if (this.lBH != null)
    {
      localObject = this.lBH;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      localObject = ((a)localObject).lwM;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.ahE(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(139439);
      return;
      ((a)localObject).b(a.lBK, a.A(paramMotionEvent));
      continue;
      ((a)localObject).a(a.lBN, a.B(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - ((a)localObject).hiI >= 20L)
      {
        ((a)localObject).hiI = System.currentTimeMillis();
        ((a)localObject).a(a.lBM, a.B(paramMotionEvent));
        continue;
        ((a)localObject).b(a.lBL, a.A(paramMotionEvent));
        ((a)localObject).c(a.lBQ, a.A(paramMotionEvent));
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(139440);
    ae.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    if (this.lBG != null) {
      this.lBG.recycle();
    }
    AppMethodBeat.o(139440);
  }
  
  static final class a
  {
    static at lBK;
    static at lBL;
    static at lBM;
    static at lBN;
    static at lBO;
    static at lBP;
    static at lBQ;
    public String data;
    long hiI;
    private com.tencent.mm.plugin.appbrand.jsapi.e lBF;
    public boolean lBR;
    GestureDetector lwM;
    
    static
    {
      AppMethodBeat.i(139432);
      lBK = new e.c();
      lBL = new e.e();
      lBM = new e.d();
      lBN = new e.b();
      lBO = new e.a();
      lBP = new a.b((byte)0);
      lBQ = new a.c((byte)0);
      AppMethodBeat.o(139432);
    }
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(139422);
      this.hiI = 0L;
      this.lBF = parame;
      this.lwM = new GestureDetector(this.lBF.getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(220591);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(220591);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(220590);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(220590);
          return bool;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(139421);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
          a.a.a(a.a.this, paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(139421);
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(220589);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
          boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(220589);
          return bool;
        }
      });
      AppMethodBeat.o(139422);
    }
    
    static JSONObject A(MotionEvent paramMotionEvent)
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
    
    static JSONArray B(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139424);
      JSONArray localJSONArray = new JSONArray();
      paramMotionEvent = v(paramMotionEvent);
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
    
    private static e.f[] v(MotionEvent paramMotionEvent)
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
    
    final void a(at paramat, JSONArray paramJSONArray)
    {
      AppMethodBeat.i(139429);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touches", paramJSONArray);
      this.lBF.b(paramat.I(localHashMap));
      AppMethodBeat.o(139429);
    }
    
    final void b(at paramat, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139427);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.lBF.b(paramat.I(localHashMap));
      AppMethodBeat.o(139427);
    }
    
    final void c(at paramat, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139428);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.lBF.a(paramat.I(localHashMap));
      AppMethodBeat.o(139428);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b.a
 * JD-Core Version:    0.7.0.1
 */