package com.tencent.mm.plugin.appbrand.jsapi.ai.b;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.o;
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
  int Go;
  volatile SurfaceTexture mSurfaceTexture;
  volatile g pJV;
  SkiaCanvasView pJW;
  a pJX;
  
  public a()
  {
    AppMethodBeat.i(139433);
    this.mSurfaceTexture = new SurfaceTexture(0);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(139433);
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(139435);
    super.Tr();
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.Go) });
    AppMethodBeat.o(139435);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139434);
    super.e(paramSurfaceTexture);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.Go) });
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.pJV == null)
    {
      Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, updateSurfaceTextureIfNeed return");
      AppMethodBeat.o(139434);
      return;
    }
    this.pJV.getAsyncHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139418);
        if (a.this.pJW != null)
        {
          a.this.pJW.swapSurface(a.this.mSurfaceTexture);
          if (a.this.pJV == null)
          {
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, onXWebCanvasSurfaceChange return");
            AppMethodBeat.o(139418);
            return;
          }
          Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.this.Go) });
          c.e(a.this.pJV, a.this.Go);
          AppMethodBeat.o(139418);
          return;
        }
        Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
        AppMethodBeat.o(139418);
      }
    });
    AppMethodBeat.o(139434);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139436);
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.SS() });
    final com.tencent.mm.plugin.appbrand.jsapi.e locale;
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
      locale = localb.okQ;
      final o localo = localb.okP;
      final JSONObject localJSONObject = localb.oiG;
      final int i = localb.okO;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { key(), localo.getName(), localJSONObject.toString() });
      parama = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139419);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.e locale;
          Object localObject;
          int i;
          if ((localo instanceof com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.b))
          {
            locala = a.this;
            parama.a(new a.3(locala));
            locala = a.this;
            locale = locale;
            localObject = localJSONObject;
            o localo = localo;
            i = i;
            locala.Go = ((JSONObject)localObject).optInt("viewId", 0);
            if (d.J(locale) == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "app is null, fail return");
              locale.j(i, localo.h("fail", null));
              AppMethodBeat.o(139419);
              return;
            }
            locala.pJV = ((g)locale);
            locala.pJW = new SkiaCanvasView(d.J(locale), locala.mSurfaceTexture, locale.getAppId(), locala.Go);
            b.a(locala.Go, locala.pJW);
            locala.pJX = new a.a(locala.pJV);
            locala.pJX.data = ((JSONObject)localObject).optString("data", "");
            locala.pJX.pKg = ((JSONObject)localObject).optBoolean("gesture", false);
            locale.j(i, localo.h("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localo instanceof com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.e))
          {
            locala = a.this;
            locale = locale;
            localObject = localo;
            i = i;
            if (locala.pJW == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
              locale.j(i, ((o)localObject).h("fail:internal error", null));
              AppMethodBeat.o(139419);
              return;
            }
            locale.j(i, ((o)localObject).h("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localo instanceof com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.d))
          {
            locala = a.this;
            locale = locale;
            localObject = localo;
            i = i;
            if (locala.pJW == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
              locale.j(i, ((o)localObject).h("fail:internal error", null));
              AppMethodBeat.o(139419);
              return;
            }
            locala.release();
            locale.j(i, ((o)localObject).h("ok", null));
          }
          AppMethodBeat.o(139419);
        }
      };
      if (locale.getAsyncHandler().getLooper() != Looper.myLooper()) {
        break label142;
      }
      parama.run();
    }
    for (;;)
    {
      AppMethodBeat.o(139436);
      return null;
      label142:
      locale.getAsyncHandler().post(parama);
    }
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139439);
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    Object localObject;
    if (this.pJX != null)
    {
      localObject = this.pJX;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      localObject = ((a)localObject).pCU;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMotionEvent.aFh(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(139439);
      return;
      ((a)localObject).b(a.pJZ, a.D(paramMotionEvent));
      continue;
      ((a)localObject).a(a.pKc, a.E(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - ((a)localObject).kje >= 20L)
      {
        ((a)localObject).kje = System.currentTimeMillis();
        ((a)localObject).a(a.pKb, a.E(paramMotionEvent));
        continue;
        ((a)localObject).b(a.pKa, a.D(paramMotionEvent));
        ((a)localObject).c(a.pKf, a.D(paramMotionEvent));
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(139440);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    if (this.pJW != null) {
      this.pJW.recycle();
    }
    b.remove(this.Go);
    AppMethodBeat.o(139440);
  }
  
  static final class a
  {
    static az pJZ;
    static az pKa;
    static az pKb;
    static az pKc;
    static az pKd;
    static az pKe;
    static az pKf;
    public String data;
    long kje;
    GestureDetector pCU;
    private g pJV;
    public boolean pKg;
    
    static
    {
      AppMethodBeat.i(139432);
      pJZ = new e.c();
      pKa = new e.e();
      pKb = new e.d();
      pKc = new e.b();
      pKd = new e.a();
      pKe = new a.b((byte)0);
      pKf = new a.c((byte)0);
      AppMethodBeat.o(139432);
    }
    
    public a(g paramg)
    {
      AppMethodBeat.i(139422);
      this.kje = 0L;
      this.pJV = paramg;
      this.pCU = new GestureDetector(this.pJV.getContext(), new a.a.1(this));
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
    
    static JSONObject D(MotionEvent paramMotionEvent)
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
    
    static JSONArray E(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(139424);
      JSONArray localJSONArray = new JSONArray();
      paramMotionEvent = A(paramMotionEvent);
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
    
    final void a(az paramaz, JSONArray paramJSONArray)
    {
      AppMethodBeat.i(139429);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touches", paramJSONArray);
      this.pJV.a(paramaz.E(localHashMap), null);
      AppMethodBeat.o(139429);
    }
    
    final void b(az paramaz, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139427);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.pJV.a(paramaz.E(localHashMap), null);
      AppMethodBeat.o(139427);
    }
    
    final void c(az paramaz, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139428);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("data", this.data);
      localHashMap.put("touch", paramJSONObject);
      this.pJV.a(paramaz.E(localHashMap));
      AppMethodBeat.o(139428);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.b.a
 * JD-Core Version:    0.7.0.1
 */