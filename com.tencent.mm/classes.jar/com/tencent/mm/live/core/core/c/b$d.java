package com.tencent.mm.live.core.core.c;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.f;
import com.tencent.mm.live.core.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
public final class b$d
  implements TextureView.SurfaceTextureListener
{
  b$d(f paramf, long paramLong) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196871);
    p.h(paramSurfaceTexture, "surfaceTexture");
    ae.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gMP.bG(new Surface(paramSurfaceTexture));
    this.gMP.cS(paramInt1, paramInt2);
    b.nq((int)bu.aO(this.gMQ));
    AppMethodBeat.o(196871);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(196873);
    p.h(paramSurfaceTexture, "surfaceTexture");
    ae.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
    this.gMP.amK();
    AppMethodBeat.o(196873);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196872);
    p.h(paramSurfaceTexture, "surfaceTexture");
    ae.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gMP.cS(paramInt1, paramInt2);
    AppMethodBeat.o(196872);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(196874);
    p.h(paramSurfaceTexture, "surface");
    AppMethodBeat.o(196874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b.d
 * JD-Core Version:    0.7.0.1
 */