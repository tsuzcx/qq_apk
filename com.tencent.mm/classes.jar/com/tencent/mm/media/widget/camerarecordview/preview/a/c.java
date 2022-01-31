package com.tencent.mm.media.widget.camerarecordview.preview.a;

import a.f.a.b;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.d;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private final String TAG;
  
  public c(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(152146);
    this.TAG = "MicroMsg.GPUPreviewController";
    AppMethodBeat.o(152146);
  }
  
  public final void b(com.tencent.mm.media.h.a parama)
  {
    AppMethodBeat.i(13313);
    j.q(parama, "renderer");
    super.b(parama);
    parama.eYg = ((b)new c.a(this, parama));
    ab.i(this.TAG, "setPreviewRenderer: " + parama.hashCode());
    AppMethodBeat.o(13313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.c
 * JD-Core Version:    0.7.0.1
 */