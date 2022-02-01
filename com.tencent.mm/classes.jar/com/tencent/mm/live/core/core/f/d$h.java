package com.tencent.mm.live.core.core.f;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$setupMiniWindowRenderView$2", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$h
  implements TextureView.SurfaceTextureListener
{
  d$h(h paramh, long paramLong) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248055);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
    this.mMw.di(paramSurfaceTexture);
    this.mMw.ej(paramInt1, paramInt2);
    c.tt((int)Util.ticksToNow(this.mMu));
    AppMethodBeat.o(248055);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248042);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureDestroyed");
    AppMethodBeat.o(248042);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248032);
    s.u(paramSurfaceTexture, "surface");
    this.mMw.ej(paramInt1, paramInt2);
    AppMethodBeat.o(248032);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248037);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(248037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f.d.h
 * JD-Core Version:    0.7.0.1
 */