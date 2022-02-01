package com.tencent.mm.plugin.appbrand.jsapi.al.b.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;

public class d
  extends TextureView
{
  private int bms;
  private SkiaCanvasApp mApp;
  private String mAppId;
  private SkiaCanvasView sPo;
  private a sPp;
  
  public d(Context paramContext, SkiaCanvasApp paramSkiaCanvasApp, int paramInt, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(327055);
    this.mApp = paramSkiaCanvasApp;
    this.bms = paramInt;
    this.mAppId = paramString;
    setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(139457);
        Log.i("Luggage.SkiaCanvasTextureView", "surface:%s width:%d height:%d viewId%d", new Object[] { paramAnonymousSurfaceTexture, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(d.c(d.this)) });
        if (d.a(d.this) == null)
        {
          d.a(d.this, new SkiaCanvasView(d.d(d.this), new Surface(paramAnonymousSurfaceTexture), d.e(d.this), d.c(d.this)));
          if (d.b(d.this) != null) {
            d.b(d.this).onReady();
          }
          b.a(d.c(d.this), d.a(d.this));
        }
        AppMethodBeat.o(139457);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(139459);
        Log.i("Luggage.SkiaCanvasTextureView", "onSurfaceTextureDestroyed:%s", new Object[] { paramAnonymousSurfaceTexture });
        if (d.a(d.this) != null) {
          d.a(d.this).recycle();
        }
        AppMethodBeat.o(139459);
        return true;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(139458);
        Log.i("Luggage.SkiaCanvasTextureView", "onSurfaceTextureSizeChanged:%s width:%d height:%d viewId%d", new Object[] { paramAnonymousSurfaceTexture, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(d.c(d.this)) });
        AppMethodBeat.o(139458);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    });
    setOpaque(false);
    AppMethodBeat.o(327055);
  }
  
  public final void notifyVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(327079);
    if (this.sPo != null) {
      this.sPo.notifyVisibilityChanged(paramBoolean);
    }
    AppMethodBeat.o(327079);
  }
  
  public final void release()
  {
    AppMethodBeat.i(327081);
    if (this.sPo != null)
    {
      this.sPo.recycle();
      b.remove(this.bms);
    }
    AppMethodBeat.o(327081);
  }
  
  public void setOnReadyListener(a parama)
  {
    AppMethodBeat.i(139461);
    this.sPp = parama;
    MMHandlerThread.postToMainThread(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.a.d
 * JD-Core Version:    0.7.0.1
 */