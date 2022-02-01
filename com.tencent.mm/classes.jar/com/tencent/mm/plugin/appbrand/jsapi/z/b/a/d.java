package com.tencent.mm.plugin.appbrand.jsapi.z.b.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;

public class d
  extends TextureView
{
  private SkiaCanvasView laF;
  private int laG;
  private int laH;
  private a laI;
  private String mAppId;
  private int mViewId;
  private IXWebWorkingHandler mWorkingHandler;
  
  public d(Context paramContext, IXWebWorkingHandler paramIXWebWorkingHandler, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramContext);
    AppMethodBeat.i(206723);
    this.mViewId = paramInt1;
    this.mAppId = paramString;
    this.laG = paramInt2;
    this.laH = paramInt3;
    this.mWorkingHandler = paramIXWebWorkingHandler;
    setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(139457);
        ac.i("Luggage.SkiaCanvasTextureView", "surface:%s width:%d height:%d viewId%d", new Object[] { paramAnonymousSurfaceTexture, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(d.c(d.this)) });
        if (d.a(d.this) == null)
        {
          d.a(d.this, new SkiaCanvasView(d.d(d.this), paramAnonymousSurfaceTexture, d.e(d.this), d.c(d.this)));
          d.a(d.this).notifyTextureSizeChanged(d.f(d.this), d.g(d.this));
          if (d.b(d.this) != null) {
            d.b(d.this).onReady();
          }
        }
        AppMethodBeat.o(139457);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(139459);
        ac.i("Luggage.SkiaCanvasTextureView", "onSurfaceTextureDestroyed:%s", new Object[] { paramAnonymousSurfaceTexture });
        if (d.a(d.this) != null) {
          d.a(d.this).recycle();
        }
        AppMethodBeat.o(139459);
        return true;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(139458);
        ac.i("Luggage.SkiaCanvasTextureView", "onSurfaceTextureSizeChanged:%s width:%d height:%d viewId%d", new Object[] { paramAnonymousSurfaceTexture, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(d.c(d.this)) });
        if (d.a(d.this) != null) {
          d.a(d.this).notifyTextureSizeChanged(g.vd(paramAnonymousInt1), g.vd(paramAnonymousInt2));
        }
        AppMethodBeat.o(139458);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    });
    setOpaque(false);
    AppMethodBeat.o(206723);
  }
  
  public void setOnReadyListener(a parama)
  {
    AppMethodBeat.i(139461);
    this.laI = parama;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139456);
        if ((d.a(d.this) != null) && (d.b(d.this) != null)) {
          d.b(d.this).onReady();
        }
        AppMethodBeat.o(139456);
      }
    });
    AppMethodBeat.o(139461);
  }
  
  public static abstract interface a
  {
    public abstract void onReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b.a.d
 * JD-Core Version:    0.7.0.1
 */