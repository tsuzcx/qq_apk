package com.tencent.mm.live.core.core.f;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$c
  implements TextureView.SurfaceTextureListener
{
  d$c(h paramh, long paramLong) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248017);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mMw.di(new Surface(paramSurfaceTexture));
    this.mMw.ej(paramInt1, paramInt2);
    c.ts((int)Util.ticksToNow(this.mMu));
    AppMethodBeat.o(248017);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248027);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
    this.mMw.bgH();
    AppMethodBeat.o(248027);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248022);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mMw.ej(paramInt1, paramInt2);
    AppMethodBeat.o(248022);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248033);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(248033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f.d.c
 * JD-Core Version:    0.7.0.1
 */