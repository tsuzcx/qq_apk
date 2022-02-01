package com.tencent.mm.plugin.appbrand.jsapi.z.d;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.z.d.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bn;
import java.util.Locale;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.k.a.b.a
{
  ao lbi;
  volatile com.tencent.mm.plugin.appbrand.jsapi.f.a.b lbj;
  private ao mHandler;
  volatile SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(139533);
    this.mHandler = new ao(String.format(Locale.ENGLISH, "MapThread_%d", new Object[] { Integer.valueOf(getId()) }));
    this.lbi = new ao(Looper.getMainLooper());
    AppMethodBeat.o(139533);
  }
  
  public final void EC()
  {
    AppMethodBeat.i(139535);
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginDestroy %d", new Object[] { Integer.valueOf(getId()) });
    super.EC();
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
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginReady %d", new Object[] { Integer.valueOf(getId()) });
    super.e(paramSurfaceTexture);
    this.mSurfaceTexture = paramSurfaceTexture;
    paramSurfaceTexture = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139527);
        if (a.this.lbj == null)
        {
          ac.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
          AppMethodBeat.o(139527);
          return;
        }
        ac.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onSurfaceChange");
        a.this.lbj.g(a.this.mSurfaceTexture);
        AppMethodBeat.o(139527);
      }
    };
    this.mHandler.post(paramSurfaceTexture);
    AppMethodBeat.o(139534);
  }
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String h(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139536);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = (com.tencent.mm.plugin.appbrand.i.b)parama;
      final com.tencent.mm.plugin.appbrand.jsapi.c localc = parama.jOV;
      final m localm = parama.jOU;
      final JSONObject localJSONObject = parama.jML;
      final int i = parama.jOT;
      ac.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { Ap(), localm.getName(), localJSONObject.toString() });
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
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.z.d.a.b))
          {
            ac.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
            com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(9);
            new bn() {}.b(a.this.lbi);
            locala = a.this;
            localc = localc;
            localJSONObject = localJSONObject;
            localObject = localm;
            localc.h(i, ((m)localObject).e("ok", null));
            com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(10);
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
            ac.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
            com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(12);
            locala = a.this;
            localc = localc;
            localJSONObject = localJSONObject;
            localObject = localm;
            i = i;
            if ((locala.lbj != null) && (d.j(localc, localJSONObject)))
            {
              localc.h(i, ((m)localObject).e("ok", null));
              com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(13);
              AppMethodBeat.o(139529);
              return;
            }
            ac.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
            com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(14);
            localc.h(i, ((m)localObject).e("fail:internal error", null));
            AppMethodBeat.o(139529);
            return;
          }
          int j;
          if ((localm instanceof com.tencent.mm.plugin.appbrand.jsapi.z.d.a.c))
          {
            com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(15);
            locala = a.this;
            localc = localc;
            localJSONObject = localJSONObject;
            localObject = localm;
            j = i;
            if (localJSONObject != null) {
              break label390;
            }
            ac.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
            if (i == 0) {
              break label429;
            }
            localc.h(j, ((m)localObject).e("ok", null));
            locala.lbj = null;
            com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(16);
          }
          for (;;)
          {
            locala.release();
            AppMethodBeat.o(139529);
            return;
            label390:
            ac.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", new Object[] { localJSONObject });
            g.dh(localc.getAppId(), f.i(localc, localJSONObject));
            i = 1;
            break;
            label429:
            ac.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
            com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(17);
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
    if (this.lbj != null) {
      this.lbj.onTouchEvent(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.d.a
 * JD-Core Version:    0.7.0.1
 */