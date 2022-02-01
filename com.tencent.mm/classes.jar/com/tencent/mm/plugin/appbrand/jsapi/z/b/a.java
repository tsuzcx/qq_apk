package com.tencent.mm.plugin.appbrand.jsapi.z.b;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.w.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.w.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.w.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.w.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.w.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.z.b.b.d;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
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
  extends com.tencent.luggage.k.a.b.a
{
  com.tencent.mm.plugin.appbrand.jsapi.e lag;
  SkiaCanvasView lah;
  a lai;
  private List<com.tencent.luggage.k.a.a> laj;
  private volatile boolean mIsInit;
  SurfaceTexture mSurfaceTexture;
  int mViewId;
  
  public a()
  {
    AppMethodBeat.i(139433);
    this.laj = new ArrayList();
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(139433);
  }
  
  private static void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(139438);
    if (paramc.aUU().getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(139438);
      return;
    }
    paramc.aUU().post(paramRunnable);
    AppMethodBeat.o(139438);
  }
  
  private void z(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139437);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      com.tencent.mm.plugin.appbrand.i.b localb = (com.tencent.mm.plugin.appbrand.i.b)parama;
      final com.tencent.mm.plugin.appbrand.jsapi.c localc = localb.jOV;
      final m localm = localb.jOU;
      final JSONObject localJSONObject = localb.jML;
      final int i = localb.jOT;
      ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { Ap(), localm.getName(), localJSONObject.toString() });
      b(localc, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139419);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.c localc;
          Object localObject;
          int i;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.z.b.b.b))
          {
            locala = a.this;
            parama.a(new a.3(locala));
            locala = a.this;
            localc = localc;
            localObject = localJSONObject;
            m localm = localm;
            i = i;
            locala.mViewId = ((JSONObject)localObject).optInt("viewId", 0);
            locala.lah = new SkiaCanvasView(new a.4(locala, localc), locala.mSurfaceTexture, localc.getAppId(), locala.mViewId);
            locala.lag = ((com.tencent.mm.plugin.appbrand.jsapi.e)localc);
            locala.lai = new a.a(locala.lag);
            locala.lai.data = ((JSONObject)localObject).optString("data", "");
            locala.lai.las = ((JSONObject)localObject).optBoolean("gesture", false);
            localc.h(i, localm.e("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.z.b.b.e))
          {
            locala = a.this;
            localc = localc;
            localObject = localm;
            i = i;
            if (locala.lah == null)
            {
              ac.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
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
            if (locala.lah == null)
            {
              ac.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
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
  
  public final void EC()
  {
    AppMethodBeat.i(139435);
    super.EC();
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    AppMethodBeat.o(139435);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139434);
    super.e(paramSurfaceTexture);
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.mIsInit)
    {
      this.lag.aUU().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139418);
          if (a.this.lah != null)
          {
            a.this.lah.swapSurface(a.this.mSurfaceTexture);
            if (a.this.lag == null)
            {
              ac.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, return");
              AppMethodBeat.o(139418);
              return;
            }
            ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.this.mViewId) });
            com.tencent.mm.plugin.appbrand.jsapi.z.b.b.c.e(a.this.lag, a.this.mViewId);
            AppMethodBeat.o(139418);
            return;
          }
          ac.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
          AppMethodBeat.o(139418);
        }
      });
      AppMethodBeat.o(139434);
      return;
    }
    if (this.laj.size() > 0)
    {
      paramSurfaceTexture = this.laj.iterator();
      while (paramSurfaceTexture.hasNext()) {
        z((com.tencent.luggage.k.a.a)paramSurfaceTexture.next());
      }
      this.laj.clear();
    }
    this.mIsInit = true;
    AppMethodBeat.o(139434);
  }
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String h(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139436);
    ac.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.Ef() });
    if (this.mIsInit) {
      z(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(139436);
      return null;
      this.laj.add(parama);
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139439);
    ac.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    a locala;
    if (this.lai != null)
    {
      locala = this.lai;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      locala.kVo.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(139439);
      return;
      locala.E(paramMotionEvent);
      continue;
      locala.E(paramMotionEvent);
      continue;
      locala.a(a.lao, a.D(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - locala.gLX >= 20L)
      {
        locala.gLX = System.currentTimeMillis();
        locala.a(a.lan, a.D(paramMotionEvent));
        continue;
        locala.F(paramMotionEvent);
        continue;
        locala.F(paramMotionEvent);
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(139440);
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    if (this.lah != null) {
      this.lah.recycle();
    }
    AppMethodBeat.o(139440);
  }
  
  static final class a
  {
    static ar lal;
    static ar lam;
    static ar lan;
    static ar lao;
    static ar lap;
    static ar laq;
    static ar lar;
    public String data;
    long gLX;
    GestureDetector kVo;
    private com.tencent.mm.plugin.appbrand.jsapi.e lag;
    public boolean las;
    
    static
    {
      AppMethodBeat.i(139432);
      lal = new e.c();
      lam = new e.e();
      lan = new e.d();
      lao = new e.b();
      lap = new e.a();
      laq = new a.b((byte)0);
      lar = new a.c((byte)0);
      AppMethodBeat.o(139432);
    }
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(139422);
      this.gLX = 0L;
      this.lag = parame;
      this.kVo = new GestureDetector(this.lag.getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(139421);
          a.a.a(a.a.this, paramAnonymousMotionEvent);
          AppMethodBeat.o(139421);
        }
      });
      AppMethodBeat.o(139422);
    }
    
    private static JSONObject C(MotionEvent paramMotionEvent)
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
    
    static JSONArray D(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139424);
      JSONArray localJSONArray = new JSONArray();
      paramMotionEvent = x(paramMotionEvent);
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
    
    private void b(ar paramar, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139427);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.lag.b(paramar.B(localHashMap));
      AppMethodBeat.o(139427);
    }
    
    private void c(ar paramar, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139428);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.lag.a(paramar.B(localHashMap));
      AppMethodBeat.o(139428);
    }
    
    private static e.f[] x(MotionEvent paramMotionEvent)
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
    
    final void E(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139425);
      b(lal, C(paramMotionEvent));
      AppMethodBeat.o(139425);
    }
    
    final void F(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139426);
      b(lam, C(paramMotionEvent));
      c(lar, C(paramMotionEvent));
      AppMethodBeat.o(139426);
    }
    
    final void a(ar paramar, JSONArray paramJSONArray)
    {
      AppMethodBeat.i(139429);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touches", paramJSONArray);
      this.lag.b(paramar.B(localHashMap));
      AppMethodBeat.o(139429);
    }
  }
  
  static final class b
    extends ar
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onSkiaCanvasLongPress";
  }
  
  static final class c
    extends ar
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onSkiaCanvasTouchEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b.a
 * JD-Core Version:    0.7.0.1
 */