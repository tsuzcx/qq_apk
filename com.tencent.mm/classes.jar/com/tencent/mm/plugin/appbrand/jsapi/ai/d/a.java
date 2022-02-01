package com.tencent.mm.plugin.appbrand.jsapi.ai.d;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.d.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ai.d.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.Locale;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  private MMHandler mHandler;
  volatile SurfaceTexture mSurfaceTexture;
  MMHandler pLh;
  volatile com.tencent.mm.plugin.appbrand.jsapi.l.a.b pLi;
  
  public a()
  {
    AppMethodBeat.i(139533);
    this.mHandler = new MMHandler(String.format(Locale.ENGLISH, "MapThread_%d", new Object[] { Integer.valueOf(getId()) }));
    this.pLh = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(139533);
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(139535);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginDestroy %d", new Object[] { Integer.valueOf(getId()) });
    super.Tr();
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
        if (a.this.pLi == null)
        {
          Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
          AppMethodBeat.o(139527);
          return;
        }
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onSurfaceChange");
        a.this.pLi.h(a.this.mSurfaceTexture);
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
      final com.tencent.mm.plugin.appbrand.jsapi.e locale = parama.okQ;
      final o localo = parama.okP;
      final JSONObject localJSONObject = parama.oiG;
      final int i = parama.okO;
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { key(), localo.getName(), localJSONObject.toString() });
      parama = new Runnable()
      {
        public final void run()
        {
          int i = 0;
          AppMethodBeat.i(139529);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.e locale;
          JSONObject localJSONObject;
          Object localObject;
          if ((localo instanceof com.tencent.mm.plugin.appbrand.jsapi.ai.d.a.b))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
            com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(9);
            new SyncTask() {}.exec(a.this.pLh);
            locala = a.this;
            locale = locale;
            localJSONObject = localJSONObject;
            localObject = localo;
            locale.j(i, ((o)localObject).h("ok", null));
            com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(10);
            if ((locale instanceof com.tencent.mm.plugin.appbrand.jsapi.g))
            {
              localObject = (com.tencent.mm.plugin.appbrand.jsapi.g)locale;
              ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject).a(new a.3(locala));
              ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject).a(new a.4(locala));
              ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject).a(new a.5(locala, (com.tencent.mm.plugin.appbrand.jsapi.g)localObject, locale, localJSONObject));
            }
            AppMethodBeat.o(139529);
            return;
          }
          if ((localo instanceof d))
          {
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
            com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(12);
            locala = a.this;
            locale = locale;
            localJSONObject = localJSONObject;
            localObject = localo;
            i = i;
            if ((locala.pLi != null) && (d.i(locale, localJSONObject)))
            {
              locale.j(i, ((o)localObject).h("ok", null));
              com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(13);
              AppMethodBeat.o(139529);
              return;
            }
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
            com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(14);
            locale.j(i, ((o)localObject).h("fail:internal error", null));
            AppMethodBeat.o(139529);
            return;
          }
          int j;
          if ((localo instanceof c))
          {
            com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(15);
            locala = a.this;
            locale = locale;
            localJSONObject = localJSONObject;
            localObject = localo;
            j = i;
            if (localJSONObject != null) {
              break label390;
            }
            Log.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
            if (i == 0) {
              break label429;
            }
            locale.j(j, ((o)localObject).h("ok", null));
            locala.pLi = null;
            com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(16);
          }
          for (;;)
          {
            locala.release();
            AppMethodBeat.o(139529);
            return;
            label390:
            Log.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", new Object[] { localJSONObject });
            com.tencent.mm.plugin.appbrand.jsapi.l.a.g.dL(locale.getAppId(), f.h(locale, localJSONObject));
            i = 1;
            break;
            label429:
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
            com.tencent.mm.plugin.appbrand.jsapi.l.a.e.AC(17);
            locale.j(j, ((o)localObject).h("fail:internal error", null));
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
    if (this.pLi != null) {
      this.pLi.B(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.d.a
 * JD-Core Version:    0.7.0.1
 */