package com.tencent.mm.plugin.appbrand.jsapi.ac.b;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.f;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
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
  com.tencent.mm.plugin.appbrand.jsapi.e lxh;
  SkiaCanvasView lxi;
  a lxj;
  private List<com.tencent.luggage.xweb_ext.extendplugin.a> lxk;
  private volatile boolean mIsInit;
  SurfaceTexture mSurfaceTexture;
  int mViewId;
  
  public a()
  {
    AppMethodBeat.i(139433);
    this.lxk = new ArrayList();
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(139433);
  }
  
  private static void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(139438);
    if (paramc.aYg().getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(139438);
      return;
    }
    paramc.aYg().post(paramRunnable);
    AppMethodBeat.o(139438);
  }
  
  private void z(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139437);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
      final com.tencent.mm.plugin.appbrand.jsapi.c localc = localb.kjg;
      final m localm = localb.kjf;
      final JSONObject localJSONObject = localb.kgW;
      final int i = localb.kje;
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { BM(), localm.getName(), localJSONObject.toString() });
      b(localc, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139419);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.c localc;
          Object localObject;
          int i;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.ac.b.b.b))
          {
            locala = a.this;
            parama.a(new a.3(locala));
            locala = a.this;
            localc = localc;
            localObject = localJSONObject;
            m localm = localm;
            i = i;
            locala.mViewId = ((JSONObject)localObject).optInt("viewId", 0);
            locala.lxi = new SkiaCanvasView(new a.4(locala, localc), locala.mSurfaceTexture, localc.getAppId(), locala.mViewId);
            locala.lxh = ((com.tencent.mm.plugin.appbrand.jsapi.e)localc);
            locala.lxj = new a.a(locala.lxh);
            locala.lxj.data = ((JSONObject)localObject).optString("data", "");
            locala.lxj.lxt = ((JSONObject)localObject).optBoolean("gesture", false);
            localc.h(i, localm.e("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.ac.b.b.e))
          {
            locala = a.this;
            localc = localc;
            localObject = localm;
            i = i;
            if (locala.lxi == null)
            {
              ad.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
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
            if (locala.lxi == null)
            {
              ad.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
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
  
  public final void Gb()
  {
    AppMethodBeat.i(139435);
    super.Gb();
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    AppMethodBeat.o(139435);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139434);
    super.e(paramSurfaceTexture);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.mIsInit)
    {
      this.lxh.aYg().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139418);
          if (a.this.lxi != null)
          {
            a.this.lxi.swapSurface(a.this.mSurfaceTexture);
            if (a.this.lxh == null)
            {
              ad.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, return");
              AppMethodBeat.o(139418);
              return;
            }
            ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.this.mViewId) });
            com.tencent.mm.plugin.appbrand.jsapi.ac.b.b.c.e(a.this.lxh, a.this.mViewId);
            AppMethodBeat.o(139418);
            return;
          }
          ad.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
          AppMethodBeat.o(139418);
        }
      });
      AppMethodBeat.o(139434);
      return;
    }
    if (this.lxk.size() > 0)
    {
      paramSurfaceTexture = this.lxk.iterator();
      while (paramSurfaceTexture.hasNext()) {
        z((com.tencent.luggage.xweb_ext.extendplugin.a)paramSurfaceTexture.next());
      }
      this.lxk.clear();
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
    ad.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.FE() });
    if (this.mIsInit) {
      z(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(139436);
      return null;
      this.lxk.add(parama);
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139439);
    ad.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    Object localObject;
    if (this.lxj != null)
    {
      localObject = this.lxj;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      localObject = ((a)localObject).lsn;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.ahp(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(139439);
      return;
      ((a)localObject).C(paramMotionEvent);
      continue;
      ((a)localObject).C(paramMotionEvent);
      continue;
      ((a)localObject).a(a.lxp, a.B(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - ((a)localObject).hfU >= 20L)
      {
        ((a)localObject).hfU = System.currentTimeMillis();
        ((a)localObject).a(a.lxo, a.B(paramMotionEvent));
        continue;
        ((a)localObject).D(paramMotionEvent);
        continue;
        ((a)localObject).D(paramMotionEvent);
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(139440);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    if (this.lxi != null) {
      this.lxi.recycle();
    }
    AppMethodBeat.o(139440);
  }
  
  static final class a
  {
    static at lxm;
    static at lxn;
    static at lxo;
    static at lxp;
    static at lxq;
    static at lxr;
    static at lxs;
    public String data;
    long hfU;
    GestureDetector lsn;
    private com.tencent.mm.plugin.appbrand.jsapi.e lxh;
    public boolean lxt;
    
    static
    {
      AppMethodBeat.i(139432);
      lxm = new e.c();
      lxn = new e.e();
      lxo = new e.d();
      lxp = new e.b();
      lxq = new e.a();
      lxr = new a.b((byte)0);
      lxs = new a.c((byte)0);
      AppMethodBeat.o(139432);
    }
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(139422);
      this.hfU = 0L;
      this.lxh = parame;
      this.lsn = new GestureDetector(this.lxh.getContext(), new a.a.1(this));
      AppMethodBeat.o(139422);
    }
    
    private static JSONObject A(MotionEvent paramMotionEvent)
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
    
    private void b(at paramat, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139427);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.lxh.b(paramat.B(localHashMap));
      AppMethodBeat.o(139427);
    }
    
    private void c(at paramat, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139428);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.lxh.a(paramat.B(localHashMap));
      AppMethodBeat.o(139428);
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
    
    final void C(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139425);
      b(lxm, A(paramMotionEvent));
      AppMethodBeat.o(139425);
    }
    
    final void D(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139426);
      b(lxn, A(paramMotionEvent));
      c(lxs, A(paramMotionEvent));
      AppMethodBeat.o(139426);
    }
    
    final void a(at paramat, JSONArray paramJSONArray)
    {
      AppMethodBeat.i(139429);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touches", paramJSONArray);
      this.lxh.b(paramat.B(localHashMap));
      AppMethodBeat.o(139429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b.a
 * JD-Core Version:    0.7.0.1
 */