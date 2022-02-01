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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.Future;

public abstract class d<TextureImageViewLike extends View,  extends h>
  implements com.tencent.mm.plugin.appbrand.jsapi.q.h<TextureImageViewLike>
{
  private static com.tencent.mm.plugin.appbrand.jsapi.q.d cre = new com.tencent.mm.plugin.appbrand.jsapi.q.d()
  {
    public final boolean FM()
    {
      return true;
    }
  };
  private static Handler sMainHandler = null;
  protected final String crd = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();
  private SparseArray<TextureView.SurfaceTextureListener> crf = new SparseArray();
  private SparseArray<Pair<Surface, SurfaceTexture>> crg = new SparseArray();
  private boolean crh = false;
  
  private static Handler FL()
  {
    if (sMainHandler == null) {
      sMainHandler = new Handler(Looper.getMainLooper());
    }
    return sMainHandler;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.d FK()
  {
    return cre;
  }
  
  protected final void a(final Runnable paramRunnable, final SurfaceTexture paramSurfaceTexture)
  {
    ad.i(this.crd, "scheduleAfterTransferFromTask");
    paramSurfaceTexture = q.d(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      ad.i(this.crd, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
      paramSurfaceTexture.a(new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void run()
        {
          AppMethodBeat.i(186720);
          Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
          {
            private int abS = 0;
            
            public final void doFrame(long paramAnonymous2Long)
            {
              AppMethodBeat.i(186719);
              ad.i(d.this.crd, "scheduleAfterTransferFromTask, doFrame");
              this.abS += 1;
              if (2 <= this.abS)
              {
                d.3.this.cri.cancel(true);
                d.3.this.crm.run();
                AppMethodBeat.o(186719);
                return;
              }
              Choreographer.getInstance().postFrameCallback(this);
              AppMethodBeat.o(186719);
            }
          });
          AppMethodBeat.o(186720);
        }
      }
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(186721);
          ad.i(d.this.crd, "scheduleAfterTransferFromTask, onFrameAvailable");
          this.cro.run();
          paramSurfaceTexture.a(this);
          AppMethodBeat.o(186721);
        }
      }, FL());
      return;
    }
    ad.i(this.crd, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
    com.tencent.e.h.LTJ.q(paramRunnable, 50L);
  }
  
  protected abstract a c(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable);
  
  public final void cq(TextureImageViewLike paramTextureImageViewLike)
  {
    ad.d(this.crd, "recycleVideoContainerView");
    int i = paramTextureImageViewLike.hashCode();
    this.crf.remove(i);
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(null);
  }
  
  public final void cr(TextureImageViewLike paramTextureImageViewLike)
  {
    ad.i(this.crd, "onPlayEndWorkaround, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    if (!this.crh) {
      ad.i(this.crd, "onPlayEndWorkaround, video is not in pip container");
    }
    Bitmap localBitmap = ((h)paramTextureImageViewLike).getBitmap();
    if (localBitmap == null)
    {
      ad.w(this.crd, "onPlayEndWorkaround, bitmap is null");
      return;
    }
    ((h)paramTextureImageViewLike).setImageBitmap(localBitmap);
  }
  
  public final void d(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    ad.i(this.crd, "transferTo, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    this.crh = true;
    ((h)paramTextureImageViewLike).setImageBitmap(null);
    int i = paramTextureImageViewLike.hashCode();
    TextureView.SurfaceTextureListener localSurfaceTextureListener = (TextureView.SurfaceTextureListener)this.crf.get(i);
    if (localSurfaceTextureListener != null)
    {
      ad.w(this.crd, "transferTo, surfaceTextureListener is not null");
      SurfaceTexture localSurfaceTexture = ((h)paramTextureImageViewLike).getSurfaceTexture();
      if (localSurfaceTexture != null) {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(localSurfaceTexture, paramTextureImageViewLike.getWidth(), paramTextureImageViewLike.getHeight());
      }
      if (paramRunnable != null)
      {
        ad.i(this.crd, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
        paramRunnable.run();
      }
      return;
    }
    paramRunnable = c(paramTextureImageViewLike, paramRunnable);
    ad.d(this.crd, "transferTo, setSurfaceTextureListener");
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(paramRunnable);
    this.crf.put(i, paramRunnable);
  }
  
  public void e(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    this.crh = false;
  }
  
  public abstract class a<TextureImageViewLike>
    implements TextureView.SurfaceTextureListener
  {
    protected final TextureImageViewLike crp;
    private final int crq;
    private volatile Runnable crr;
    
    protected a(Runnable paramRunnable)
    {
      this.crp = paramRunnable;
      this.crq = paramRunnable.hashCode();
      Object localObject;
      this.crr = localObject;
    }
    
    private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Pair localPair = (Pair)d.a(d.this).get(this.crq);
      Surface localSurface;
      if ((localPair != null) && (localPair.second == paramSurfaceTexture)) {
        localSurface = (Surface)localPair.first;
      }
      for (paramSurfaceTexture = localPair;; paramSurfaceTexture = Pair.create(localSurface, paramSurfaceTexture))
      {
        if (b(localSurface, paramInt1, paramInt2)) {
          d.a(d.this).put(this.crq, paramSurfaceTexture);
        }
        return;
        localSurface = new Surface(paramSurfaceTexture);
      }
    }
    
    protected abstract void FN();
    
    protected abstract boolean b(Surface paramSurface, int paramInt1, int paramInt2);
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      ad.d(d.this.crd, this.crp + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramSurfaceTexture, paramInt1, paramInt2);
      Runnable localRunnable = this.crr;
      this.crr = null;
      if (localRunnable != null) {
        d.a(d.this, localRunnable, paramSurfaceTexture);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      ad.d(d.this.crd, this.crp + " onSurfaceTextureDestroyed, surfaceTexture: " + paramSurfaceTexture);
      FN();
      paramSurfaceTexture = (Pair)d.a(d.this).get(this.crq);
      if (paramSurfaceTexture == null) {
        return true;
      }
      d.a(d.this).remove(this.crq);
      ((Surface)paramSurfaceTexture.first).release();
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      a(paramSurfaceTexture, paramInt1, paramInt2);
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.d
 * JD-Core Version:    0.7.0.1
 */