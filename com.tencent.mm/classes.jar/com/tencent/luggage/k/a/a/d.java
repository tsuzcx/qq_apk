package com.tencent.luggage.k.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.Future;

public abstract class d
  implements com.tencent.mm.plugin.appbrand.jsapi.n.h<TextureView>
{
  private static com.tencent.mm.plugin.appbrand.jsapi.n.d cgM = new com.tencent.mm.plugin.appbrand.jsapi.n.d()
  {
    public final boolean En()
    {
      return true;
    }
  };
  private static Handler sMainHandler = null;
  protected final String cgL = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();
  private SparseArray<TextureView.SurfaceTextureListener> cgN = new SparseArray();
  private SparseArray<Pair<Surface, SurfaceTexture>> cgO = new SparseArray();
  private boolean cgP = false;
  
  private static Handler Em()
  {
    if (sMainHandler == null) {
      sMainHandler = new Handler(Looper.getMainLooper());
    }
    return sMainHandler;
  }
  
  protected abstract void Ek();
  
  public final com.tencent.mm.plugin.appbrand.jsapi.n.d El()
  {
    return cgM;
  }
  
  protected abstract a a(TextureView paramTextureView, Runnable paramRunnable);
  
  protected final void a(final Runnable paramRunnable, final SurfaceTexture paramSurfaceTexture)
  {
    ac.i(this.cgL, "scheduleAfterTransferFromTask");
    paramSurfaceTexture = m.d(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      ac.i(this.cgL, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
      paramSurfaceTexture.a(new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void run()
        {
          AppMethodBeat.i(206508);
          Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
          {
            private int aac = 0;
            
            public final void doFrame(long paramAnonymous2Long)
            {
              AppMethodBeat.i(206507);
              ac.i(d.this.cgL, "scheduleAfterTransferFromTask, doFrame");
              this.aac += 1;
              if (2 <= this.aac)
              {
                d.4.this.cgS.cancel(true);
                d.4.this.cgV.run();
                AppMethodBeat.o(206507);
                return;
              }
              Choreographer.getInstance().postFrameCallback(this);
              AppMethodBeat.o(206507);
            }
          });
          AppMethodBeat.o(206508);
        }
      }
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(206509);
          ac.i(d.this.cgL, "scheduleAfterTransferFromTask, onFrameAvailable");
          this.cgX.run();
          paramSurfaceTexture.a(this);
          AppMethodBeat.o(206509);
        }
      }, Em());
      return;
    }
    ac.i(this.cgL, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
    com.tencent.e.h.JZN.p(paramRunnable, 50L);
  }
  
  public void b(TextureView paramTextureView, Runnable paramRunnable)
  {
    this.cgP = false;
  }
  
  public abstract class a
    implements TextureView.SurfaceTextureListener
  {
    protected final TextureView cgY;
    private final int cgZ;
    private volatile Runnable cha;
    
    protected a(TextureView paramTextureView, Runnable paramRunnable)
    {
      this.cgY = paramTextureView;
      this.cgZ = paramTextureView.hashCode();
      this.cha = paramRunnable;
    }
    
    private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Pair localPair = (Pair)d.a(d.this).get(this.cgZ);
      Surface localSurface;
      if ((localPair != null) && (localPair.second == paramSurfaceTexture)) {
        localSurface = (Surface)localPair.first;
      }
      for (paramSurfaceTexture = localPair;; paramSurfaceTexture = Pair.create(localSurface, paramSurfaceTexture))
      {
        if (b(localSurface, paramInt1, paramInt2)) {
          d.a(d.this).put(this.cgZ, paramSurfaceTexture);
        }
        return;
        localSurface = new Surface(paramSurfaceTexture);
      }
    }
    
    protected abstract void Eo();
    
    protected abstract boolean b(Surface paramSurface, int paramInt1, int paramInt2);
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      ac.d(d.this.cgL, this.cgY + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a(paramSurfaceTexture, paramInt1, paramInt2);
      Runnable localRunnable = this.cha;
      this.cha = null;
      if (localRunnable != null) {
        d.a(d.this, localRunnable, paramSurfaceTexture);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      ac.d(d.this.cgL, this.cgY + " onSurfaceTextureDestroyed, surfaceTexture: " + paramSurfaceTexture);
      Eo();
      paramSurfaceTexture = (Pair)d.a(d.this).get(this.cgZ);
      if (paramSurfaceTexture == null) {
        return true;
      }
      d.a(d.this).remove(this.cgZ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.d
 * JD-Core Version:    0.7.0.1
 */