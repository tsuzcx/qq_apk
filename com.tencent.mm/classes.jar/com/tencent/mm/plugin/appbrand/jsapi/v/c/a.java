package com.tencent.mm.plugin.appbrand.jsapi.v.c;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  volatile c bDN;
  volatile com.tencent.mm.plugin.appbrand.jsapi.g.a.b iiF;
  Object iiG;
  volatile SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(155141);
    this.iiG = new Object();
    AppMethodBeat.o(155141);
  }
  
  public final String a(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140061);
    Object localObject;
    if ((parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      localObject = (com.tencent.mm.plugin.appbrand.f.b)parama;
      parama = ((com.tencent.mm.plugin.appbrand.f.b)localObject).hrA;
      m localm = ((com.tencent.mm.plugin.appbrand.f.b)localObject).hrz;
      JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.f.b)localObject).hpr;
      int i = ((com.tencent.mm.plugin.appbrand.f.b)localObject).hry;
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { tX(), localm.getName(), localJSONObject.toString() });
      localObject = new a.2(this, localm, parama, localJSONObject, i);
      if (parama.aAP().getLooper() != Looper.myLooper()) {
        break label116;
      }
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      AppMethodBeat.o(140061);
      return null;
      label116:
      parama.aAP().post((Runnable)localObject);
    }
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(117345);
    super.d(paramSurfaceTexture);
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginReady");
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.bDN != null)
    {
      paramSurfaceTexture = new a.1(this);
      this.bDN.aAP().post(paramSurfaceTexture);
    }
    AppMethodBeat.o(117345);
  }
  
  public final void m(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117348);
    if (this.iiF != null) {
      this.iiF.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(117348);
  }
  
  public final boolean xp()
  {
    return true;
  }
  
  public final void xq()
  {
    AppMethodBeat.i(117346);
    super.xq();
    if (this.mSurfaceTexture != null)
    {
      this.mSurfaceTexture.release();
      this.mSurfaceTexture = null;
    }
    AppMethodBeat.o(117346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a
 * JD-Core Version:    0.7.0.1
 */