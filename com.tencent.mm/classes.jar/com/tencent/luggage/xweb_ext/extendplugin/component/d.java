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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Future;

public abstract class d<TextureImageViewLike extends View,  extends h>
  implements com.tencent.mm.plugin.appbrand.jsapi.t.h<TextureImageViewLike>
{
  private static com.tencent.mm.plugin.appbrand.jsapi.t.d cEE = new com.tencent.mm.plugin.appbrand.jsapi.t.d()
  {
    public final boolean Tb()
    {
      return true;
    }
  };
  private static Handler sMainHandler = null;
  protected final String cED = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();
  private SparseArray<TextureView.SurfaceTextureListener> cEF = new SparseArray();
  private SparseArray<Pair<Surface, SurfaceTexture>> cEG = new SparseArray();
  private boolean cEH = false;
  
  private static Handler Ta()
  {
    if (sMainHandler == null) {
      sMainHandler = new Handler(Looper.getMainLooper());
    }
    return sMainHandler;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.d SZ()
  {
    return cEE;
  }
  
  protected final void a(final Runnable paramRunnable, final SurfaceTexture paramSurfaceTexture)
  {
    Log.i(this.cED, "scheduleAfterTransferFromTask");
    paramSurfaceTexture = q.d(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      Log.i(this.cED, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
      paramSurfaceTexture.a(new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void run()
        {
          AppMethodBeat.i(224937);
          Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
          {
            private int iN = 0;
            
            public final void doFrame(long paramAnonymous2Long)
            {
              AppMethodBeat.i(226320);
              Log.i(d.this.cED, "scheduleAfterTransferFromTask, doFrame");
              this.iN += 1;
              if (2 <= this.iN)
              {
                d.3.this.cEI.cancel(true);
                d.3.this.cEM.run();
                AppMethodBeat.o(226320);
                return;
              }
              Choreographer.getInstance().postFrameCallback(this);
              AppMethodBeat.o(226320);
            }
          });
          AppMethodBeat.o(224937);
        }
      }
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(221928);
          Log.i(d.this.cED, "scheduleAfterTransferFromTask, onFrameAvailable");
          this.cEO.run();
          paramSurfaceTexture.a(this);
          AppMethodBeat.o(221928);
        }
      }, Ta());
      return;
    }
    Log.i(this.cED, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
    com.tencent.e.h.ZvG.n(paramRunnable, 50L);
  }
  
  protected abstract a c(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable);
  
  public final void cx(TextureImageViewLike paramTextureImageViewLike)
  {
    Log.d(this.cED, "recycleVideoContainerView");
    int i = paramTextureImageViewLike.hashCode();
    this.cEF.remove(i);
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(null);
  }
  
  public final void cy(TextureImageViewLike paramTextureImageViewLike)
  {
    Log.i(this.cED, "onPlayEndWorkaround, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    if (!this.cEH) {
      Log.i(this.cED, "onPlayEndWorkaround, video is not in pip container");
    }
    Bitmap localBitmap = ((h)paramTextureImageViewLike).getBitmap();
    if (localBitmap == null)
    {
      Log.w(this.cED, "onPlayEndWorkaround, bitmap is null");
      return;
    }
    ((h)paramTextureImageViewLike).setImageBitmap(localBitmap);
  }
  
  public final void d(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    Log.i(this.cED, "transferTo, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    this.cEH = true;
    ((h)paramTextureImageViewLike).setImageBitmap(null);
    int i = paramTextureImageViewLike.hashCode();
    TextureView.SurfaceTextureListener localSurfaceTextureListener = (TextureView.SurfaceTextureListener)this.cEF.get(i);
    if (localSurfaceTextureListener != null)
    {
      Log.w(this.cED, "transferTo, surfaceTextureListener is not null");
      SurfaceTexture localSurfaceTexture = ((h)paramTextureImageViewLike).getSurfaceTexture();
      if (localSurfaceTexture != null) {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(localSurfaceTexture, paramTextureImageViewLike.getWidth(), paramTextureImageViewLike.getHeight());
      }
      if (paramRunnable != null)
      {
        Log.i(this.cED, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
        paramRunnable.run();
      }
      return;
    }
    paramRunnable = c(paramTextureImageViewLike, paramRunnable);
    Log.d(this.cED, "transferTo, setSurfaceTextureListener");
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(paramRunnable);
    this.cEF.put(i, paramRunnable);
  }
  
  public void e(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    this.cEH = false;
  }
  
  public abstract class a<TextureImageViewLike>
    implements TextureView.SurfaceTextureListener
  {
    protected final TextureImageViewLike cEP;
    private final int cEQ;
    private volatile Runnable cER;
    
    protected a(Runnable paramRunnable)
    {
      this.cEP = paramRunnable;
      this.cEQ = paramRunnable.hashCode();
      Object localObject;
      this.cER = localObject;
    }
    
    private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Pair localPair = (Pair)d.b(d.this).get(this.cEQ);
      Surface localSurface;
      if ((localPair != null) && (localPair.second == paramSurfaceTexture)) {
        localSurface = (Surface)localPair.first;
      }
      for (paramSurfaceTexture = localPair;; paramSurfaceTexture = Pair.create(localSurface, paramSurfaceTexture))
      {
        if (b(localSurface, paramInt1, paramInt2)) {
          d.b(d.this).put(this.cEQ, paramSurfaceTexture);
        }
        return;
        localSurface = new Surface(paramSurfaceTexture);
      }
    }
    
    protected abstract void Tc();
    
    protected abstract boolean b(Surface paramSurface, int paramInt1, int paramInt2);
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Log.d(d.this.cED, this.cEP + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramSurfaceTexture, paramInt1, paramInt2);
      Runnable localRunnable = this.cER;
      this.cER = null;
      if (localRunnable != null) {
        d.a(d.this, localRunnable, paramSurfaceTexture);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      Log.d(d.this.cED, this.cEP + " onSurfaceTextureDestroyed, surfaceTexture: " + paramSurfaceTexture);
      Tc();
      paramSurfaceTexture = (Pair)d.b(d.this).get(this.cEQ);
      if (paramSurfaceTexture == null) {
        return true;
      }
      d.b(d.this).remove(this.cEQ);
      ((Surface)paramSurfaceTexture.first).release();
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      if (!d.a(d.this))
      {
        Log.w(d.this.cED, "onSurfaceTextureSizeChanged, video is not in pip container");
        return;
      }
      a(paramSurfaceTexture, paramInt1, paramInt2);
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.d
 * JD-Core Version:    0.7.0.1
 */