package com.tencent.mm.media.widget.camerarecordview;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.b.c;
import com.tencent.mm.media.h.b.e;
import com.tencent.mm.media.h.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
public final class a$c
  extends d
{
  a$c(int paramInt) {}
  
  public final com.tencent.mm.media.h.b.a Ve()
  {
    AppMethodBeat.i(152123);
    if (this.fbe.fbc.Xn())
    {
      locala = (com.tencent.mm.media.h.b.a)new e(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
      AppMethodBeat.o(152123);
      return locala;
    }
    com.tencent.mm.media.h.b.a locala = (com.tencent.mm.media.h.b.a)new c(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
    AppMethodBeat.o(152123);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.c
 * JD-Core Version:    0.7.0.1
 */