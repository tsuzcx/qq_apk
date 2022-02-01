package com.tencent.luggage.k.a.a;

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
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.Future;

public abstract class d
  implements com.tencent.mm.plugin.appbrand.jsapi.o.i<TextureView>
{
  private static e cjQ = new e()
  {
    public final boolean EJ()
    {
      return true;
    }
  };
  private static Handler sMainHandler = null;
  protected final String cjP = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();
  private SparseArray<TextureView.SurfaceTextureListener> cjR = new SparseArray();
  private SparseArray<Pair<Surface, SurfaceTexture>> cjS = new SparseArray();
  
  public final e EI()
  {
    return cjQ;
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.utils.i parami, final SurfaceTexture paramSurfaceTexture)
  {
    ad.i(this.cjP, "scheduleAfterTransferFromTask, schedule afterTransferFromTask");
    paramSurfaceTexture = p.d(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      parami = new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void run()
        {
          AppMethodBeat.i(194924);
          if (parami.lMl)
          {
            ad.w(d.this.cjP, "scheduleAfterTransferFromTask, has run");
            AppMethodBeat.o(194924);
            return;
          }
          Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
          {
            private int Zh = 0;
            
            public final void doFrame(long paramAnonymous2Long)
            {
              AppMethodBeat.i(194923);
              ad.i(d.this.cjP, "scheduleAfterTransferFromTask, doFrame");
              this.Zh += 1;
              if (2 <= this.Zh)
              {
                d.2.this.cjU.cancel(true);
                d.2.this.cjT.run();
                AppMethodBeat.o(194923);
                return;
              }
              Choreographer.getInstance().postFrameCallback(this);
              AppMethodBeat.o(194923);
            }
          });
          AppMethodBeat.o(194924);
        }
      }
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(194925);
          ad.i(d.this.cjP, "scheduleAfterTransferFromTask, onFrameAvailable");
          this.cjX.run();
          paramSurfaceTexture.a(this);
          AppMethodBeat.o(194925);
        }
      };
      if (sMainHandler == null) {
        sMainHandler = new Handler(Looper.getMainLooper());
      }
      paramSurfaceTexture.a(parami, sMainHandler);
      return;
    }
    ad.i(this.cjP, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
    h.Iye.p(parami, 50L);
  }
  
  protected abstract a c(TextureView paramTextureView);
  
  public abstract class a
    implements TextureView.SurfaceTextureListener
  {
    protected final TextureView cjZ;
    private final int cka;
    
    protected a(TextureView paramTextureView)
    {
      this.cjZ = paramTextureView;
      this.cka = paramTextureView.hashCode();
    }
    
    private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Pair localPair = (Pair)d.a(d.this).get(this.cka);
      Surface localSurface;
      if ((localPair != null) && (localPair.second == paramSurfaceTexture)) {
        localSurface = (Surface)localPair.first;
      }
      for (paramSurfaceTexture = localPair;; paramSurfaceTexture = Pair.create(localSurface, paramSurfaceTexture))
      {
        if (b(localSurface, paramInt1, paramInt2)) {
          d.a(d.this).put(this.cka, paramSurfaceTexture);
        }
        return;
        localSurface = new Surface(paramSurfaceTexture);
      }
    }
    
    protected abstract void EK();
    
    protected abstract boolean b(Surface paramSurface, int paramInt1, int paramInt2);
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      ad.d(d.this.cjP, this.cjZ + " onSurfaceTextureAvailable, surfaceTexture: " + paramSurfaceTexture);
      a(paramSurfaceTexture, paramInt1, paramInt2);
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      ad.d(d.this.cjP, this.cjZ + " onSurfaceTextureDestroyed, surfaceTexture: " + paramSurfaceTexture);
      EK();
      paramSurfaceTexture = (Pair)d.a(d.this).get(this.cka);
      if (paramSurfaceTexture == null) {
        return true;
      }
      d.a(d.this).remove(this.cka);
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
 * Qualified Name:     com.tencent.luggage.k.a.a.d
 * JD-Core Version:    0.7.0.1
 */