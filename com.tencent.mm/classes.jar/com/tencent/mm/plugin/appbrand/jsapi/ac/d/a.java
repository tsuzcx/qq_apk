package com.tencent.mm.plugin.appbrand.jsapi.ac.d;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.d.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  ap lyj;
  volatile com.tencent.mm.plugin.appbrand.jsapi.i.a.b lyk;
  private ap mHandler;
  volatile SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(139533);
    this.mHandler = new ap(String.format(Locale.ENGLISH, "MapThread_%d", new Object[] { Integer.valueOf(getId()) }));
    this.lyj = new ap(Looper.getMainLooper());
    AppMethodBeat.o(139533);
  }
  
  public final void Gb()
  {
    AppMethodBeat.i(139535);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginDestroy %d", new Object[] { Integer.valueOf(getId()) });
    super.Gb();
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
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginReady %d", new Object[] { Integer.valueOf(getId()) });
    super.e(paramSurfaceTexture);
    this.mSurfaceTexture = paramSurfaceTexture;
    paramSurfaceTexture = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139527);
        if (a.this.lyk == null)
        {
          ad.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
          AppMethodBeat.o(139527);
          return;
        }
        ad.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onSurfaceChange");
        a.this.lyk.g(a.this.mSurfaceTexture);
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
      final com.tencent.mm.plugin.appbrand.jsapi.c localc = parama.kjg;
      final m localm = parama.kjf;
      final JSONObject localJSONObject = parama.kgW;
      final int i = parama.kje;
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { BM(), localm.getName(), localJSONObject.toString() });
      parama = new Runnable()
      {
        public final void run()
        {
          int i = 0;
          AppMethodBeat.i(139529);
          a locala;
          com.tencent.mm.plugin.appbrand.jsapi.c localc;
          JSONObject localJSONObject;
          Object localObject;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.ac.d.a.b))
          {
            ad.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
            com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(9);
            new bo() {}.b(a.this.lyj);
            locala = a.this;
            localc = localc;
            localJSONObject = localJSONObject;
            localObject = localm;
            localc.h(i, ((m)localObject).e("ok", null));
            com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(10);
            if ((localc instanceof com.tencent.mm.plugin.appbrand.jsapi.e))
            {
              localObject = (com.tencent.mm.plugin.appbrand.jsapi.e)localc;
              ((com.tencent.mm.plugin.appbrand.jsapi.e)localObject).a(new a.3(locala));
              ((com.tencent.mm.plugin.appbrand.jsapi.e)localObject).a(new a.4(locala));
              ((com.tencent.mm.plugin.appbrand.jsapi.e)localObject).a(new a.5(locala, (com.tencent.mm.plugin.appbrand.jsapi.e)localObject, localc, localJSONObject));
            }
            AppMethodBeat.o(139529);
            return;
          }
          if ((localm instanceof d))
          {
            ad.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
            com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(12);
            locala = a.this;
            localc = localc;
            localJSONObject = localJSONObject;
            localObject = localm;
            i = i;
            if ((locala.lyk != null) && (d.j(localc, localJSONObject)))
            {
              localc.h(i, ((m)localObject).e("ok", null));
              com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(13);
              AppMethodBeat.o(139529);
              return;
            }
            ad.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
            com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(14);
            localc.h(i, ((m)localObject).e("fail:internal error", null));
            AppMethodBeat.o(139529);
            return;
          }
          int j;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.ac.d.a.c))
          {
            com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(15);
            locala = a.this;
            localc = localc;
            localJSONObject = localJSONObject;
            localObject = localm;
            j = i;
            if (localJSONObject != null) {
              break label390;
            }
            ad.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
            if (i == 0) {
              break label429;
            }
            localc.h(j, ((m)localObject).e("ok", null));
            locala.lyk = null;
            com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(16);
          }
          for (;;)
          {
            locala.release();
            AppMethodBeat.o(139529);
            return;
            label390:
            ad.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", new Object[] { localJSONObject });
            g.dj(localc.getAppId(), f.i(localc, localJSONObject));
            i = 1;
            break;
            label429:
            ad.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
            com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(17);
            localc.h(j, ((m)localObject).e("fail:internal error", null));
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
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139537);
    if (this.lyk != null) {
      this.lyk.onTouchEvent(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.d.a
 * JD-Core Version:    0.7.0.1
 */