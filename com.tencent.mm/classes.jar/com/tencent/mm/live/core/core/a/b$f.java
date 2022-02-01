package com.tencent.mm.live.core.core.a;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$refreshMicUserView$1$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$f
  implements TextureView.SurfaceTextureListener
{
  b$f(h paramh) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248154);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.LiveCoreAnchor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mMw.di(new Surface(paramSurfaceTexture));
    this.mMw.ej(paramInt1, paramInt2);
    AppMethodBeat.o(248154);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248165);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.LiveCoreAnchor", "customRender onSurfaceTextureDestroyed");
    this.mMw.bgH();
    AppMethodBeat.o(248165);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248160);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.LiveCoreAnchor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mMw.ej(paramInt1, paramInt2);
    AppMethodBeat.o(248160);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248170);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(248170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b.f
 * JD-Core Version:    0.7.0.1
 */