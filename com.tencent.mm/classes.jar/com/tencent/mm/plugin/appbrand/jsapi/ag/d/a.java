package com.tencent.mm.plugin.appbrand.jsapi.ag.d;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.Locale;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  private MMHandler mHandler;
  MMHandler mKp;
  volatile com.tencent.mm.plugin.appbrand.jsapi.k.a.b mKq;
  volatile SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(139533);
    this.mHandler = new MMHandler(String.format(Locale.ENGLISH, "MapThread_%d", new Object[] { Integer.valueOf(getId()) }));
    this.mKp = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(139533);
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(139535);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginDestroy %d", new Object[] { Integer.valueOf(getId()) });
    super.PQ();
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    AppMethodBeat.o(139535);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139534);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginReady %d", new Object[] { Integer.valueOf(getId()) });
    super.e(paramSurfaceTexture);
    this.mSurfaceTexture = paramSurfaceTexture;
    paramSurfaceTexture = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139527);
        if (a.this.mKq == null)
        {
          Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
          AppMethodBeat.o(139527);
          return;
        }
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onSurfaceChange");
        a.this.mKq.g(a.this.mSurfaceTexture);
        AppMethodBeat.o(139527);
      }
    };
    this.mHandler.post(paramSurfaceTexture);
    AppMethodBeat.o(139534);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139536);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = (com.tencent.mm.plugin.appbrand.h.b)parama;
      final com.tencent.mm.plugin.appbrand.jsapi.f localf = parama.lqg;
      final p localp = parama.lqf;
      final JSONObject localJSONObject = parama.lnV;
      final int i = parama.lqe;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { Lb(), localp.getName(), localJSONObject.toString() });
      parama = new Runnable()
      {
        public final void run()
        {
          int i = 0;
          AppMethodBeat.i(139529);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.f localf;
          JSONObject localJSONObject;
          Object localObject;
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
            e.xg(9);
            new SyncTask() {}.exec(a.this.mKp);
            locala = a.this;
            localf = localf;
            localJSONObject = localJSONObject;
            localObject = localp;
            localf.i(i, ((p)localObject).h("ok", null));
            e.xg(10);
            if ((localf instanceof h))
            {
              localObject = (h)localf;
              ((h)localObject).a(new a.3(locala));
              ((h)localObject).a(new a.4(locala));
              ((h)localObject).a(new a.5(locala, (h)localObject, localf, localJSONObject));
            }
            AppMethodBeat.o(139529);
            return;
          }
          if ((localp instanceof d))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
            e.xg(12);
            locala = a.this;
            localf = localf;
            localJSONObject = localJSONObject;
            localObject = localp;
            i = i;
            if ((locala.mKq != null) && (d.j(localf, localJSONObject)))
            {
              localf.i(i, ((p)localObject).h("ok", null));
              e.xg(13);
              AppMethodBeat.o(139529);
              return;
            }
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
            e.xg(14);
            localf.i(i, ((p)localObject).h("fail:internal error", null));
            AppMethodBeat.o(139529);
            return;
          }
          int j;
          if ((localp instanceof c))
          {
            e.xg(15);
            locala = a.this;
            localf = localf;
            localJSONObject = localJSONObject;
            localObject = localp;
            j = i;
            if (localJSONObject != null) {
              break label390;
            }
            Log.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
            if (i == 0) {
              break label429;
            }
            localf.i(j, ((p)localObject).h("ok", null));
            locala.mKq = null;
            e.xg(16);
          }
          for (;;)
          {
            locala.release();
            AppMethodBeat.o(139529);
            return;
            label390:
            Log.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", new Object[] { localJSONObject });
            g.dA(localf.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(localf, localJSONObject));
            i = 1;
            break;
            label429:
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
            e.xg(17);
            localf.i(j, ((p)localObject).h("fail:internal error", null));
          }
        }
      };
      if (this.mHandler.getLooper() != Looper.myLooper()) {
        break label114;
      }
      parama.run();
    }
    for (;;)
    {
      AppMethodBeat.o(139536);
      return null;
      label114:
      this.mHandler.post(parama);
    }
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139537);
    if (this.mKq != null) {
      this.mKq.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(139537);
  }
  
  final void release()
  {
    AppMethodBeat.i(139538);
    this.mHandler.quitSafely();
    AppMethodBeat.o(139538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a
 * JD-Core Version:    0.7.0.1
 */