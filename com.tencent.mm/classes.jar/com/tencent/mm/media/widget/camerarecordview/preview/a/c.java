package com.tencent.mm.media.widget.camerarecordview.preview.a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"})
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
    parama.ijv = ((b)new a(this, parama));
    Log.i(this.TAG, "setPreviewRenderer: " + parama.hashCode());
    AppMethodBeat.o(94365);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class a
    extends q
    implements b<SurfaceTexture, x>
  {
    a(c paramc, com.tencent.mm.media.j.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.c
 * JD-Core Version:    0.7.0.1
 */