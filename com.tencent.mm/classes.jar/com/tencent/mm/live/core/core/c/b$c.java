package com.tencent.mm.live.core.core.c;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.f;
import com.tencent.mm.live.core.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
public final class b$c
  implements SurfaceHolder.Callback
{
  b$c(f paramf, long paramLong) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(196869);
    ae.i("MicroMsg.LiveCoreVisitor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
    f localf = this.gMO;
    if (paramSurfaceHolder != null) {}
    for (paramSurfaceHolder = paramSurfaceHolder.getSurface();; paramSurfaceHolder = null)
    {
      localf.bG(paramSurfaceHolder);
      this.gMO.cS(paramInt2, paramInt3);
      b.nr((int)bu.aO(this.gJW));
      AppMethodBeat.o(196869);
      return;
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(196870);
    ae.i("MicroMsg.LiveCoreVisitor", "float surface destroy");
    AppMethodBeat.o(196870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b.c
 * JD-Core Version:    0.7.0.1
 */