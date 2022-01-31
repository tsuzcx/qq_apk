package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.skia_canvas.demo.SkiaCanvasView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  private static SparseArray<WeakReference<a>> iid;
  private e ihZ;
  private SkiaCanvasView iia;
  private a.a iib;
  private List<com.tencent.luggage.xweb_ext.extendplugin.a> iic;
  public int mHeight;
  private volatile boolean mIsInit;
  private SurfaceTexture mSurfaceTexture;
  private int mViewId;
  public int mWidth;
  
  static
  {
    AppMethodBeat.i(154459);
    iid = new SparseArray();
    AppMethodBeat.o(154459);
  }
  
  public a()
  {
    AppMethodBeat.i(154446);
    this.iic = new ArrayList();
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
    AppMethodBeat.o(154446);
  }
  
  private static void a(c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(154451);
    if (paramc.aAP().getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(154451);
      return;
    }
    paramc.aAP().post(paramRunnable);
    AppMethodBeat.o(154451);
  }
  
  private void i(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(154450);
    if ((parama instanceof b))
    {
      b localb = (b)parama;
      c localc = localb.hrA;
      m localm = localb.hrz;
      JSONObject localJSONObject = localb.hpr;
      int i = localb.hry;
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { tX(), localm.getName(), localJSONObject.toString() });
      a(localc, new a.2(this, localm, parama, localc, localJSONObject, i));
    }
    AppMethodBeat.o(154450);
  }
  
  public static a ov(int paramInt)
  {
    AppMethodBeat.i(154445);
    if (iid.get(paramInt) == null)
    {
      AppMethodBeat.o(154445);
      return null;
    }
    a locala = (a)((WeakReference)iid.get(paramInt)).get();
    AppMethodBeat.o(154445);
    return locala;
  }
  
  private void release()
  {
    AppMethodBeat.i(154453);
    if (this.iia != null) {
      this.iia.recycle();
    }
    iid.remove(this.mViewId);
    AppMethodBeat.o(154453);
  }
  
  public final String a(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(154449);
    ab.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.xl() });
    if (this.mIsInit) {
      i(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(154449);
      return null;
      this.iic.add(parama);
    }
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(154447);
    super.d(paramSurfaceTexture);
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    if (this.mIsInit)
    {
      this.ihZ.aAP().post(new a.1(this, paramSurfaceTexture));
      AppMethodBeat.o(154447);
      return;
    }
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.iic.size() > 0)
    {
      paramSurfaceTexture = this.iic.iterator();
      while (paramSurfaceTexture.hasNext()) {
        i((com.tencent.luggage.xweb_ext.extendplugin.a)paramSurfaceTexture.next());
      }
      this.iic.clear();
    }
    this.mIsInit = true;
    AppMethodBeat.o(154447);
  }
  
  public final void m(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(154452);
    ab.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    a.a locala;
    if (this.iib != null)
    {
      locala = this.iib;
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      locala.idY.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(154452);
      return;
      locala.F(paramMotionEvent);
      continue;
      locala.F(paramMotionEvent);
      continue;
      locala.a(a.a.iij, a.a.E(paramMotionEvent));
      continue;
      if (System.currentTimeMillis() - locala.ePF >= 20L)
      {
        locala.ePF = System.currentTimeMillis();
        locala.a(a.a.iii, a.a.E(paramMotionEvent));
        continue;
        locala.G(paramMotionEvent);
        continue;
        locala.G(paramMotionEvent);
      }
    }
  }
  
  public final boolean xp()
  {
    return true;
  }
  
  public final void xq()
  {
    AppMethodBeat.i(154448);
    super.xq();
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.mViewId) });
    AppMethodBeat.o(154448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.a
 * JD-Core Version:    0.7.0.1
 */