package com.tencent.mm.plugin.appbrand.jsapi.al.d;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.d.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.al.d.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.g;
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
  volatile Surface mSurface;
  MMHandler sQa;
  volatile com.tencent.mm.plugin.appbrand.jsapi.o.a.b sQb;
  
  public a()
  {
    AppMethodBeat.i(139533);
    this.mHandler = new MMHandler(String.format(Locale.ENGLISH, "MapThread_%d", new Object[] { Integer.valueOf(getId()) }));
    this.sQa = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(139533);
  }
  
  public final void atW()
  {
    AppMethodBeat.i(139535);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginDestroy %d", new Object[] { Integer.valueOf(getId()) });
    super.atW();
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(139535);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139534);
    i(new Surface(paramSurfaceTexture));
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
      final com.tencent.mm.plugin.appbrand.jsapi.f localf = parama.rot;
      final p localp = parama.ros;
      final JSONObject localJSONObject = parama.rmi;
      final int i = parama.ror;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { key(), localp.getName(), localJSONObject.toString() });
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
          if ((localp instanceof com.tencent.mm.plugin.appbrand.jsapi.al.d.a.b))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
            e.AQ(9);
            new SyncTask() {}.exec(a.this.sQa);
            locala = a.this;
            localf = localf;
            localJSONObject = localJSONObject;
            localObject = localp;
            localf.callback(i, ((p)localObject).ZP("ok"));
            e.AQ(10);
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
            e.AQ(12);
            locala = a.this;
            localf = localf;
            localJSONObject = localJSONObject;
            localObject = localp;
            i = i;
            if ((locala.sQb != null) && (d.i(localf, localJSONObject)))
            {
              localf.callback(i, ((p)localObject).ZP("ok"));
              e.AQ(13);
              AppMethodBeat.o(139529);
              return;
            }
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
            e.AQ(14);
            localf.callback(i, ((p)localObject).ZP("fail:internal error"));
            AppMethodBeat.o(139529);
            return;
          }
          int j;
          if ((localp instanceof c))
          {
            e.AQ(15);
            locala = a.this;
            localf = localf;
            localJSONObject = localJSONObject;
            localObject = localp;
            j = i;
            if (localJSONObject != null) {
              break label386;
            }
            Log.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
            if (i == 0) {
              break label425;
            }
            localf.callback(j, ((p)localObject).ZP("ok"));
            locala.sQb = null;
            e.AQ(16);
          }
          for (;;)
          {
            locala.release();
            AppMethodBeat.o(139529);
            return;
            label386:
            Log.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", new Object[] { localJSONObject });
            g.ee(localf.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.o.a.f.h(localf, localJSONObject));
            i = 1;
            break;
            label425:
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
            e.AQ(17);
            localf.callback(j, ((p)localObject).ZP("fail:internal error"));
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
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(327078);
    super.i(paramSurface);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginReady %d", new Object[] { Integer.valueOf(getId()) });
    this.mSurface = paramSurface;
    paramSurface = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139527);
        if (a.this.sQb == null)
        {
          Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
          AppMethodBeat.o(139527);
          return;
        }
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onSurfaceChange");
        a.this.sQb.m(a.this.mSurface);
        AppMethodBeat.o(139527);
      }
    };
    this.mHandler.post(paramSurface);
    AppMethodBeat.o(327078);
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139537);
    if (this.sQb != null) {
      this.sQb.B(paramMotionEvent);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.d.a
 * JD-Core Version:    0.7.0.1
 */