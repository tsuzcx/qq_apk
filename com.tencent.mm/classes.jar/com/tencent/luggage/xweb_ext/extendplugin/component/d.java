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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Future;

public abstract class d<TextureImageViewLike extends View,  extends h>
  implements com.tencent.mm.plugin.appbrand.jsapi.s.h<TextureImageViewLike>
{
  private static com.tencent.mm.plugin.appbrand.jsapi.s.d cDX = new com.tencent.mm.plugin.appbrand.jsapi.s.d()
  {
    public final boolean PB()
    {
      return true;
    }
  };
  private static Handler sMainHandler = null;
  protected final String cDW = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();
  private SparseArray<TextureView.SurfaceTextureListener> cDY = new SparseArray();
  private SparseArray<Pair<Surface, SurfaceTexture>> cDZ = new SparseArray();
  private boolean cEa = false;
  
  private static Handler PA()
  {
    if (sMainHandler == null) {
      sMainHandler = new Handler(Looper.getMainLooper());
    }
    return sMainHandler;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.d Pz()
  {
    return cDX;
  }
  
  protected final void a(final Runnable paramRunnable, final SurfaceTexture paramSurfaceTexture)
  {
    Log.i(this.cDW, "scheduleAfterTransferFromTask");
    paramSurfaceTexture = q.d(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      Log.i(this.cDW, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
      paramSurfaceTexture.a(new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void run()
        {
          AppMethodBeat.i(215540);
          Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
          {
            private int acf = 0;
            
            public final void doFrame(long paramAnonymous2Long)
            {
              AppMethodBeat.i(215539);
              Log.i(d.this.cDW, "scheduleAfterTransferFromTask, doFrame");
              this.acf += 1;
              if (2 <= this.acf)
              {
                d.3.this.cEb.cancel(true);
                d.3.this.cEf.run();
                AppMethodBeat.o(215539);
                return;
              }
              Choreographer.getInstance().postFrameCallback(this);
              AppMethodBeat.o(215539);
            }
          });
          AppMethodBeat.o(215540);
        }
      }
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(215541);
          Log.i(d.this.cDW, "scheduleAfterTransferFromTask, onFrameAvailable");
          this.cEh.run();
          paramSurfaceTexture.a(this);
          AppMethodBeat.o(215541);
        }
      }, PA());
      return;
    }
    Log.i(this.cDW, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
    com.tencent.f.h.RTc.n(paramRunnable, 50L);
  }
  
  protected abstract a c(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable);
  
  public final void cf(TextureImageViewLike paramTextureImageViewLike)
  {
    Log.d(this.cDW, "recycleVideoContainerView");
    int i = paramTextureImageViewLike.hashCode();
    this.cDY.remove(i);
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(null);
  }
  
  public final void cg(TextureImageViewLike paramTextureImageViewLike)
  {
    Log.i(this.cDW, "onPlayEndWorkaround, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    if (!this.cEa) {
      Log.i(this.cDW, "onPlayEndWorkaround, video is not in pip container");
    }
    Bitmap localBitmap = ((h)paramTextureImageViewLike).getBitmap();
    if (localBitmap == null)
    {
      Log.w(this.cDW, "onPlayEndWorkaround, bitmap is null");
      return;
    }
    ((h)paramTextureImageViewLike).setImageBitmap(localBitmap);
  }
  
  public final void d(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    Log.i(this.cDW, "transferTo, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    this.cEa = true;
    ((h)paramTextureImageViewLike).setImageBitmap(null);
    int i = paramTextureImageViewLike.hashCode();
    TextureView.SurfaceTextureListener localSurfaceTextureListener = (TextureView.SurfaceTextureListener)this.cDY.get(i);
    if (localSurfaceTextureListener != null)
    {
      Log.w(this.cDW, "transferTo, surfaceTextureListener is not null");
      SurfaceTexture localSurfaceTexture = ((h)paramTextureImageViewLike).getSurfaceTexture();
      if (localSurfaceTexture != null) {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(localSurfaceTexture, paramTextureImageViewLike.getWidth(), paramTextureImageViewLike.getHeight());
      }
      if (paramRunnable != null)
      {
        Log.i(this.cDW, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
        paramRunnable.run();
      }
      return;
    }
    paramRunnable = c(paramTextureImageViewLike, paramRunnable);
    Log.d(this.cDW, "transferTo, setSurfaceTextureListener");
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(paramRunnable);
    this.cDY.put(i, paramRunnable);
  }
  
  public void e(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    this.cEa = false;
  }
  
  public abstract class a<TextureImageViewLike>
    implements TextureView.SurfaceTextureListener
  {
    protected final TextureImageViewLike cEi;
    private final int cEj;
    private volatile Runnable cEk;
    
    protected a(Runnable paramRunnable)
    {
      this.cEi = paramRunnable;
      this.cEj = paramRunnable.hashCode();
      Object localObject;
      this.cEk = localObject;
    }
    
    private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Pair localPair = (Pair)d.b(d.this).get(this.cEj);
      Surface localSurface;
      if ((localPair != null) && (localPair.second == paramSurfaceTexture)) {
        localSurface = (Surface)localPair.first;
      }
      for (paramSurfaceTexture = localPair;; paramSurfaceTexture = Pair.create(localSurface, paramSurfaceTexture))
      {
        if (b(localSurface, paramInt1, paramInt2)) {
          d.b(d.this).put(this.cEj, paramSurfaceTexture);
        }
        return;
        localSurface = new Surface(paramSurfaceTexture);
      }
    }
    
    protected abstract void PC();
    
    protected abstract boolean b(Surface paramSurface, int paramInt1, int paramInt2);
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Log.d(d.this.cDW, this.cEi + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramSurfaceTexture, paramInt1, paramInt2);
      Runnable localRunnable = this.cEk;
      this.cEk = null;
      if (localRunnable != null) {
        d.a(d.this, localRunnable, paramSurfaceTexture);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      Log.d(d.this.cDW, this.cEi + " onSurfaceTextureDestroyed, surfaceTexture: " + paramSurfaceTexture);
      PC();
      paramSurfaceTexture = (Pair)d.b(d.this).get(this.cEj);
      if (paramSurfaceTexture == null) {
        return true;
      }
      d.b(d.this).remove(this.cEj);
      ((Surface)paramSurfaceTexture.first).release();
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      if (!d.a(d.this))
      {
        Log.w(d.this.cDW, "onSurfaceTextureSizeChanged, video is not in pip container");
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