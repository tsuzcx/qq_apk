package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.concurrent.Future;

public abstract class d<TextureImageViewLike extends View,  extends h>
  implements com.tencent.mm.plugin.appbrand.jsapi.w.h<TextureImageViewLike>
{
  private static com.tencent.mm.plugin.appbrand.jsapi.w.d exP = new com.tencent.mm.plugin.appbrand.jsapi.w.d()
  {
    public final boolean atG()
    {
      return true;
    }
  };
  private static Handler sMainHandler = null;
  protected final String exO = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();
  private SparseArray<TextureView.SurfaceTextureListener> exQ = new SparseArray();
  private SparseArray<Pair<Surface, SurfaceTexture>> exR = new SparseArray();
  private boolean exS = false;
  
  private static Handler atF()
  {
    if (sMainHandler == null) {
      sMainHandler = new Handler(Looper.getMainLooper());
    }
    return sMainHandler;
  }
  
  protected final void a(final Runnable paramRunnable, final SurfaceTexture paramSurfaceTexture)
  {
    Log.i(this.exO, "scheduleAfterTransferFromTask");
    paramSurfaceTexture = q.d(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      Log.i(this.exO, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
      paramSurfaceTexture.a(new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void run()
        {
          AppMethodBeat.i(220627);
          Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
          {
            private int jI = 0;
            
            public final void doFrame(long paramAnonymous2Long)
            {
              AppMethodBeat.i(220630);
              Log.i(d.this.exO, "scheduleAfterTransferFromTask, doFrame");
              this.jI += 1;
              if (2 <= this.jI)
              {
                d.3.this.exT.cancel(true);
                d.3.this.exX.run();
                AppMethodBeat.o(220630);
                return;
              }
              Choreographer.getInstance().postFrameCallback(this);
              AppMethodBeat.o(220630);
            }
          });
          AppMethodBeat.o(220627);
        }
      }
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(220620);
          Log.i(d.this.exO, "scheduleAfterTransferFromTask, onFrameAvailable");
          this.exZ.run();
          paramSurfaceTexture.a(this);
          AppMethodBeat.o(220620);
        }
      }, atF());
      return;
    }
    Log.i(this.exO, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
    com.tencent.threadpool.h.ahAA.o(paramRunnable, 50L);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.w.d atE()
  {
    return exP;
  }
  
  protected abstract a c(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable);
  
  public final void cR(TextureImageViewLike paramTextureImageViewLike)
  {
    Log.d(this.exO, "recycleVideoContainerView");
    int i = paramTextureImageViewLike.hashCode();
    this.exQ.remove(i);
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(null);
  }
  
  public final void cS(TextureImageViewLike paramTextureImageViewLike)
  {
    Log.i(this.exO, "onPlayEndWorkaround, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    if (!this.exS) {
      Log.i(this.exO, "onPlayEndWorkaround, video is not in pip container");
    }
    Bitmap localBitmap = ((h)paramTextureImageViewLike).getBitmap();
    if (localBitmap == null)
    {
      Log.w(this.exO, "onPlayEndWorkaround, bitmap is null");
      return;
    }
    ((h)paramTextureImageViewLike).setImageBitmap(localBitmap);
  }
  
  public final void d(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    Log.i(this.exO, "transferTo, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    this.exS = true;
    ((h)paramTextureImageViewLike).setImageBitmap(null);
    int i = paramTextureImageViewLike.hashCode();
    TextureView.SurfaceTextureListener localSurfaceTextureListener = (TextureView.SurfaceTextureListener)this.exQ.get(i);
    if (localSurfaceTextureListener != null)
    {
      Log.w(this.exO, "transferTo, surfaceTextureListener is not null");
      SurfaceTexture localSurfaceTexture = ((h)paramTextureImageViewLike).getSurfaceTexture();
      if (localSurfaceTexture != null) {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(localSurfaceTexture, paramTextureImageViewLike.getWidth(), paramTextureImageViewLike.getHeight());
      }
      if (paramRunnable != null)
      {
        Log.i(this.exO, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
        paramRunnable.run();
      }
      return;
    }
    paramRunnable = c(paramTextureImageViewLike, paramRunnable);
    Log.d(this.exO, "transferTo, setSurfaceTextureListener");
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(paramRunnable);
    this.exQ.put(i, paramRunnable);
  }
  
  public void e(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    this.exS = false;
  }
  
  public abstract class a<TextureImageViewLike>
    implements TextureView.SurfaceTextureListener
  {
    protected final TextureImageViewLike eya;
    private final int eyb;
    private volatile Runnable eyc;
    
    protected a(Runnable paramRunnable)
    {
      this.eya = paramRunnable;
      this.eyb = paramRunnable.hashCode();
      Object localObject;
      this.eyc = localObject;
    }
    
    private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Pair localPair = (Pair)d.b(d.this).get(this.eyb);
      Surface localSurface;
      if ((localPair != null) && (localPair.second == paramSurfaceTexture)) {
        localSurface = (Surface)localPair.first;
      }
      for (paramSurfaceTexture = localPair;; paramSurfaceTexture = Pair.create(localSurface, paramSurfaceTexture))
      {
        if (c(localSurface, paramInt1, paramInt2)) {
          d.b(d.this).put(this.eyb, paramSurfaceTexture);
        }
        return;
        localSurface = new Surface(paramSurfaceTexture);
      }
    }
    
    protected abstract void atH();
    
    protected abstract boolean c(Surface paramSurface, int paramInt1, int paramInt2);
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Log.d(d.this.exO, this.eya + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramSurfaceTexture, paramInt1, paramInt2);
      Runnable localRunnable = this.eyc;
      this.eyc = null;
      if (localRunnable != null) {
        d.a(d.this, localRunnable, paramSurfaceTexture);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      Log.d(d.this.exO, this.eya + " onSurfaceTextureDestroyed, surfaceTexture: " + paramSurfaceTexture);
      atH();
      paramSurfaceTexture = (Pair)d.b(d.this).get(this.eyb);
      if (paramSurfaceTexture == null) {
        return true;
      }
      d.b(d.this).remove(this.eyb);
      ((Surface)paramSurfaceTexture.first).release();
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      if (!d.a(d.this))
      {
        Log.w(d.this.exO, "onSurfaceTextureSizeChanged, video is not in pip container");
        return;
      }
      a(paramSurfaceTexture, paramInt1, paramInt2);
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.d
 * JD-Core Version:    0.7.0.1
 */