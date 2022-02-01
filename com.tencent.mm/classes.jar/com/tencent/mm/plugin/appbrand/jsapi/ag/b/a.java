package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  volatile h mJd;
  SkiaCanvasView mJe;
  a.a mJf;
  volatile SurfaceTexture mSurfaceTexture;
  int mViewId;
  
  public a()
  {
    AppMethodBeat.i(139433);
    this.mSurfaceTexture = new SurfaceTexture(0);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(139433);
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(139435);
    super.PQ();
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    AppMethodBeat.o(139435);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139434);
    super.e(paramSurfaceTexture);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.mJd == null)
    {
      Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, updateSurfaceTextureIfNeed return");
      AppMethodBeat.o(139434);
      return;
    }
    this.mJd.getAsyncHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139418);
        if (a.this.mJe != null)
        {
          a.this.mJe.swapSurface(a.this.mSurfaceTexture);
          if (a.this.mJd == null)
          {
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, onXWebCanvasSurfaceChange return");
            AppMethodBeat.o(139418);
            return;
          }
          Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.this.mViewId) });
          c.e(a.this.mJd, a.this.mViewId);
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
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.Pt() });
    final f localf;
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
      localf = localb.lqg;
      final p localp = localb.lqf;
      final JSONObject localJSONObject = localb.lnV;
      final int i = localb.lqe;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { Lb(), localp.getName(), localJSONObject.toString() });
      parama = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139419);
          a locala;
          f localf;
          Object localObject;
          int i;
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.b))
          {
            locala = a.this;
            parama.a(new a.3(locala));
            locala = a.this;
            localf = localf;
            localObject = localJSONObject;
            p localp = localp;
            i = i;
            locala.mViewId = ((JSONObject)localObject).optInt("viewId", 0);
            if (d.G(localf) == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "app is null, fail return");
              localf.i(i, localp.h("fail", null));
              AppMethodBeat.o(139419);
              return;
            }
            locala.mJd = ((h)localf);
            locala.mJe = new SkiaCanvasView(d.G(localf), locala.mSurfaceTexture, localf.getAppId(), locala.mViewId);
            b.a(locala.mViewId, locala.mJe);
            locala.mJf = new a.a(locala.mJd);
            locala.mJf.data = ((JSONObject)localObject).optString("data", "");
            locala.mJf.mJo = ((JSONObject)localObject).optBoolean("gesture", false);
            localf.i(i, localp.h("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localp instanceof e))
          {
            locala = a.this;
            localf = localf;
            localObject = localp;
            i = i;
            if (locala.mJe == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
              localf.i(i, ((p)localObject).h("fail:internal error", null));
              AppMethodBeat.o(139419);
              return;
            }
            localf.i(i, ((p)localObject).h("ok", null));
            AppMethodBeat.o(139419);
            return;
          }
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.d))
          {
            locala = a.this;
            localf = localf;
            localObject = localp;
            i = i;
            if (locala.mJe == null)
            {
              Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
              localf.i(i, ((p)localObject).h("fail:internal error", null));
              AppMethodBeat.o(139419);
              return;
            }
            locala.release();
            localf.i(i, ((p)localObject).h("ok", null));
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
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139439);
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    Object localObject;
    if (this.mJf != null)
    {
      localObject = this.mJf;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      localObject = ((a.a)localObject).mDJ;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(139439);
      return;
      ((a.a)localObject).b(a.a.mJh, a.a.E(paramMotionEvent));
      continue;
      ((a.a)localObject).a(a.a.mJk, a.a.F(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - ((a.a)localObject).hwQ >= 20L)
      {
        ((a.a)localObject).hwQ = System.currentTimeMillis();
        ((a.a)localObject).a(a.a.mJj, a.a.F(paramMotionEvent));
        continue;
        ((a.a)localObject).b(a.a.mJi, a.a.E(paramMotionEvent));
        ((a.a)localObject).c(a.a.mJn, a.a.E(paramMotionEvent));
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(139440);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    if (this.mJe != null) {
      this.mJe.recycle();
    }
    b.remove(this.mViewId);
    AppMethodBeat.o(139440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b.a
 * JD-Core Version:    0.7.0.1
 */