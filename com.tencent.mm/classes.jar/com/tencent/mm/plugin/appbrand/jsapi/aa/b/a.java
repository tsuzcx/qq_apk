package com.tencent.mm.plugin.appbrand.jsapi.aa.b;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.f;
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
  extends com.tencent.luggage.k.a.b.a
{
  com.tencent.mm.plugin.appbrand.jsapi.e kyT;
  SkiaCanvasView kyU;
  a kyV;
  private List<com.tencent.luggage.k.a.a> kyW;
  private volatile boolean mIsInit;
  SurfaceTexture mSurfaceTexture;
  int mViewId;
  
  public a()
  {
    AppMethodBeat.i(139433);
    this.kyW = new ArrayList();
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(139433);
  }
  
  private void A(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139437);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      com.tencent.mm.plugin.appbrand.i.b localb = (com.tencent.mm.plugin.appbrand.i.b)parama;
      final com.tencent.mm.plugin.appbrand.jsapi.c localc = localb.joJ;
      final m localm = localb.joI;
      final JSONObject localJSONObject = localb.jmy;
      final int i = localb.joH;
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { AL(), localm.getName(), localJSONObject.toString() });
      b(localc, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139419);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.c localc;
          Object localObject;
          int i;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.b))
          {
            locala = a.this;
            parama.a(new a.3(locala));
            locala = a.this;
            localc = localc;
            localObject = localJSONObject;
            m localm = localm;
            i = i;
            locala.mViewId = ((JSONObject)localObject).optInt("viewId", 0);
            locala.kyU = new SkiaCanvasView(new a.4(locala, localc), locala.mSurfaceTexture, localc.getAppId(), locala.mViewId);
            locala.kyT = ((com.tencent.mm.plugin.appbrand.jsapi.e)localc);
            locala.kyV = new a.a(locala.kyT);
            locala.kyV.data = ((JSONObject)localObject).optString("data", "");
            locala.kyV.kzf = ((JSONObject)localObject).optBoolean("gesture", false);
            localc.h(i, localm.e("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.e))
          {
            locala = a.this;
            localc = localc;
            localObject = localm;
            i = i;
            if (locala.kyU == null)
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
            if (locala.kyU == null)
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
  
  private static void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(139438);
    if (paramc.aOe().getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(139438);
      return;
    }
    paramc.aOe().post(paramRunnable);
    AppMethodBeat.o(139438);
  }
  
  public final void EY()
  {
    AppMethodBeat.i(139435);
    super.EY();
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
      this.kyT.aOe().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139418);
          if (a.this.kyU != null)
          {
            a.this.kyU.swapSurface(a.this.mSurfaceTexture);
            if (a.this.kyT == null)
            {
              ad.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, return");
              AppMethodBeat.o(139418);
              return;
            }
            ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.this.mViewId) });
            com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.c.e(a.this.kyT, a.this.mViewId);
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
    if (this.kyW.size() > 0)
    {
      paramSurfaceTexture = this.kyW.iterator();
      while (paramSurfaceTexture.hasNext()) {
        A((com.tencent.luggage.k.a.a)paramSurfaceTexture.next());
      }
      this.kyW.clear();
    }
    this.mIsInit = true;
    AppMethodBeat.o(139434);
  }
  
  public final boolean h(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String i(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139436);
    ad.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.EC() });
    if (this.mIsInit) {
      A(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(139436);
      return null;
      this.kyW.add(parama);
    }
  }
  
  public final void n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139439);
    ad.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    a locala;
    if (this.kyV != null)
    {
      locala = this.kyV;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      locala.ktZ.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(139439);
      return;
      locala.G(paramMotionEvent);
      continue;
      locala.G(paramMotionEvent);
      continue;
      locala.a(a.kzb, a.F(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - locala.glk >= 20L)
      {
        locala.glk = System.currentTimeMillis();
        locala.a(a.kza, a.F(paramMotionEvent));
        continue;
        locala.H(paramMotionEvent);
        continue;
        locala.H(paramMotionEvent);
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(139440);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    if (this.kyU != null) {
      this.kyU.recycle();
    }
    AppMethodBeat.o(139440);
  }
  
  static final class a
  {
    static ar kyY;
    static ar kyZ;
    static ar kza;
    static ar kzb;
    static ar kzc;
    static ar kzd;
    static ar kze;
    public String data;
    long glk;
    GestureDetector ktZ;
    private com.tencent.mm.plugin.appbrand.jsapi.e kyT;
    public boolean kzf;
    
    static
    {
      AppMethodBeat.i(139432);
      kyY = new d.c();
      kyZ = new d.e();
      kza = new d.d();
      kzb = new d.b();
      kzc = new d.a();
      kzd = new a.b((byte)0);
      kze = new a.c((byte)0);
      AppMethodBeat.o(139432);
    }
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(139422);
      this.glk = 0L;
      this.kyT = parame;
      this.ktZ = new GestureDetector(this.kyT.getContext(), new GestureDetector.SimpleOnGestureListener()
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
    
    private static JSONObject E(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139423);
      int i = paramMotionEvent.getActionIndex();
      int j = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      paramMotionEvent = new d.f();
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
    
    private void b(ar paramar, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139427);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.kyT.b(paramar.C(localHashMap));
      AppMethodBeat.o(139427);
    }
    
    private void c(ar paramar, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139428);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.kyT.a(paramar.C(localHashMap));
      AppMethodBeat.o(139428);
    }
    
    private static d.f[] z(MotionEvent paramMotionEvent)
    {
      int j = 0;
      AppMethodBeat.i(139430);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramMotionEvent.getPointerCount())
      {
        d.f localf = new d.f();
        localf.id = paramMotionEvent.getPointerId(i);
        localf.x = paramMotionEvent.getX(i);
        localf.y = paramMotionEvent.getY(i);
        localArrayList.add(localf);
        i += 1;
      }
      paramMotionEvent = new d.f[localArrayList.size()];
      i = j;
      while (i < localArrayList.size())
      {
        paramMotionEvent[i] = ((d.f)localArrayList.get(i));
        i += 1;
      }
      AppMethodBeat.o(139430);
      return paramMotionEvent;
    }
    
    final void G(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139425);
      b(kyY, E(paramMotionEvent));
      AppMethodBeat.o(139425);
    }
    
    final void H(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139426);
      b(kyZ, E(paramMotionEvent));
      c(kze, E(paramMotionEvent));
      AppMethodBeat.o(139426);
    }
    
    final void a(ar paramar, JSONArray paramJSONArray)
    {
      AppMethodBeat.i(139429);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touches", paramJSONArray);
      this.kyT.b(paramar.C(localHashMap));
      AppMethodBeat.o(139429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b.a
 * JD-Core Version:    0.7.0.1
 */