package com.tencent.mm.live.core.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/view/LivePreviewView$surfaceHolderCallback$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LivePreviewView$a
  implements TextureView.SurfaceTextureListener
{
  LivePreviewView$a(LivePreviewView paramLivePreviewView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247559);
    s.u(paramSurfaceTexture, "surface");
    Log.i(LivePreviewView.c(this.mWU), s.X("onSurfaceTextureAvailable ", paramSurfaceTexture));
    b localb = LivePreviewView.d(this.mWU);
    if (localb != null) {
      localb.invoke(paramSurfaceTexture);
    }
    paramSurfaceTexture = LivePreviewView.e(this.mWU);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(247559);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(247579);
    s.u(paramSurfaceTexture, "surface");
    Log.i(LivePreviewView.c(this.mWU), s.X("onSurfaceTextureDestroyed ", paramSurfaceTexture));
    AppMethodBeat.o(247579);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247570);
    s.u(paramSurfaceTexture, "surface");
    Log.i(LivePreviewView.c(this.mWU), "onSurfaceTextureSizeChanged width is " + paramInt1 + " and height is " + paramInt2 + ' ' + paramSurfaceTexture);
    paramSurfaceTexture = LivePreviewView.e(this.mWU);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(247570);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(247586);
    s.u(paramSurfaceTexture, "surface");
    Log.i(LivePreviewView.c(this.mWU), s.X("onSurfaceTextureUpdated ", paramSurfaceTexture));
    AppMethodBeat.o(247586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView.a
 * JD-Core Version:    0.7.0.1
 */