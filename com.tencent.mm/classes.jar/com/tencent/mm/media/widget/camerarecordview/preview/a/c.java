package com.tencent.mm.media.widget.camerarecordview.preview.a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"})
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
  
  public final void b(final com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94365);
    p.h(parama, "renderer");
    super.b(parama);
    parama.hqa = ((b)new a(this, parama));
    ae.i(this.TAG, "setPreviewRenderer: " + parama.hashCode());
    AppMethodBeat.o(94365);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class a
    extends q
    implements b<SurfaceTexture, z>
  {
    a(c paramc, com.tencent.mm.media.j.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.c
 * JD-Core Version:    0.7.0.1
 */