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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.Future;

public abstract class d<TextureImageViewLike extends View,  extends h>
  implements com.tencent.mm.plugin.appbrand.jsapi.q.h<TextureImageViewLike>
{
  private static com.tencent.mm.plugin.appbrand.jsapi.q.d crH = new com.tencent.mm.plugin.appbrand.jsapi.q.d()
  {
    public final boolean FS()
    {
      return true;
    }
  };
  private static Handler sMainHandler = null;
  protected final String crG = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();
  private SparseArray<TextureView.SurfaceTextureListener> crI = new SparseArray();
  private SparseArray<Pair<Surface, SurfaceTexture>> crJ = new SparseArray();
  private boolean crK = false;
  
  private static Handler FR()
  {
    if (sMainHandler == null) {
      sMainHandler = new Handler(Looper.getMainLooper());
    }
    return sMainHandler;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.d FQ()
  {
    return crH;
  }
  
  protected final void a(final Runnable paramRunnable, final SurfaceTexture paramSurfaceTexture)
  {
    ae.i(this.crG, "scheduleAfterTransferFromTask");
    paramSurfaceTexture = q.d(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      ae.i(this.crG, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
      paramSurfaceTexture.a(new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void run()
        {
          AppMethodBeat.i(220403);
          Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
          {
            private int abS = 0;
            
            public final void doFrame(long paramAnonymous2Long)
            {
              AppMethodBeat.i(220402);
              ae.i(d.this.crG, "scheduleAfterTransferFromTask, doFrame");
              this.abS += 1;
              if (2 <= this.abS)
              {
                d.3.this.crL.cancel(true);
                d.3.this.crP.run();
                AppMethodBeat.o(220402);
                return;
              }
              Choreographer.getInstance().postFrameCallback(this);
              AppMethodBeat.o(220402);
            }
          });
          AppMethodBeat.o(220403);
        }
      }
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(220404);
          ae.i(d.this.crG, "scheduleAfterTransferFromTask, onFrameAvailable");
          this.crR.run();
          paramSurfaceTexture.a(this);
          AppMethodBeat.o(220404);
        }
      }, FR());
      return;
    }
    ae.i(this.crG, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
    com.tencent.e.h.MqF.q(paramRunnable, 50L);
  }
  
  protected abstract a c(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable);
  
  public final void cq(TextureImageViewLike paramTextureImageViewLike)
  {
    ae.d(this.crG, "recycleVideoContainerView");
    int i = paramTextureImageViewLike.hashCode();
    this.crI.remove(i);
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(null);
  }
  
  public final void cr(TextureImageViewLike paramTextureImageViewLike)
  {
    ae.i(this.crG, "onPlayEndWorkaround, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    if (!this.crK) {
      ae.i(this.crG, "onPlayEndWorkaround, video is not in pip container");
    }
    Bitmap localBitmap = ((h)paramTextureImageViewLike).getBitmap();
    if (localBitmap == null)
    {
      ae.w(this.crG, "onPlayEndWorkaround, bitmap is null");
      return;
    }
    ((h)paramTextureImageViewLike).setImageBitmap(localBitmap);
  }
  
  public final void d(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    ae.i(this.crG, "transferTo, textureImageViewLike: ".concat(String.valueOf(paramTextureImageViewLike)));
    this.crK = true;
    ((h)paramTextureImageViewLike).setImageBitmap(null);
    int i = paramTextureImageViewLike.hashCode();
    TextureView.SurfaceTextureListener localSurfaceTextureListener = (TextureView.SurfaceTextureListener)this.crI.get(i);
    if (localSurfaceTextureListener != null)
    {
      ae.w(this.crG, "transferTo, surfaceTextureListener is not null");
      SurfaceTexture localSurfaceTexture = ((h)paramTextureImageViewLike).getSurfaceTexture();
      if (localSurfaceTexture != null) {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(localSurfaceTexture, paramTextureImageViewLike.getWidth(), paramTextureImageViewLike.getHeight());
      }
      if (paramRunnable != null)
      {
        ae.i(this.crG, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
        paramRunnable.run();
      }
      return;
    }
    paramRunnable = c(paramTextureImageViewLike, paramRunnable);
    ae.d(this.crG, "transferTo, setSurfaceTextureListener");
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(paramRunnable);
    this.crI.put(i, paramRunnable);
  }
  
  public void e(TextureImageViewLike paramTextureImageViewLike, Runnable paramRunnable)
  {
    this.crK = false;
  }
  
  public abstract class a<TextureImageViewLike>
    implements TextureView.SurfaceTextureListener
  {
    protected final TextureImageViewLike crS;
    private final int crT;
    private volatile Runnable crU;
    
    protected a(Runnable paramRunnable)
    {
      this.crS = paramRunnable;
      this.crT = paramRunnable.hashCode();
      Object localObject;
      this.crU = localObject;
    }
    
    private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Pair localPair = (Pair)d.a(d.this).get(this.crT);
      Surface localSurface;
      if ((localPair != null) && (localPair.second == paramSurfaceTexture)) {
        localSurface = (Surface)localPair.first;
      }
      for (paramSurfaceTexture = localPair;; paramSurfaceTexture = Pair.create(localSurface, paramSurfaceTexture))
      {
        if (b(localSurface, paramInt1, paramInt2)) {
          d.a(d.this).put(this.crT, paramSurfaceTexture);
        }
        return;
        localSurface = new Surface(paramSurfaceTexture);
      }
    }
    
    protected abstract void FT();
    
    protected abstract boolean b(Surface paramSurface, int paramInt1, int paramInt2);
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      ae.d(d.this.crG, this.crS + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramSurfaceTexture, paramInt1, paramInt2);
      Runnable localRunnable = this.crU;
      this.crU = null;
      if (localRunnable != null) {
        d.a(d.this, localRunnable, paramSurfaceTexture);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      ae.d(d.this.crG, this.crS + " onSurfaceTextureDestroyed, surfaceTexture: " + paramSurfaceTexture);
      FT();
      paramSurfaceTexture = (Pair)d.a(d.this).get(this.crT);
      if (paramSurfaceTexture == null) {
        return true;
      }
      d.a(d.this).remove(this.crT);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.d
 * JD-Core Version:    0.7.0.1
 */