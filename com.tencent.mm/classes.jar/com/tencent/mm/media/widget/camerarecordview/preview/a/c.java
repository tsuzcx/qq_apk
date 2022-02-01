package com.tencent.mm.media.widget.camerarecordview.preview.a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private final String TAG;
  
  public c(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(94366);
    this.TAG = "MicroMsg.GPUPreviewController";
    AppMethodBeat.o(94366);
  }
  
  public final void b(final com.tencent.mm.media.i.a parama)
  {
    AppMethodBeat.i(94365);
    k.h(parama, "renderer");
    super.b(parama);
    parama.gVj = ((b)new a(this, parama));
    ac.i(this.TAG, "setPreviewRenderer: " + parama.hashCode());
    AppMethodBeat.o(94365);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<SurfaceTexture, y>
  {
    a(c paramc, com.tencent.mm.media.i.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.c
 * JD-Core Version:    0.7.0.1
 */