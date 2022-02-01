package com.tencent.mm.media.widget.camerarecordview.preview.a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  private final String TAG;
  
  public c(com.tencent.mm.media.widget.camerarecordview.preview.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(94366);
    this.TAG = "MicroMsg.GPUPreviewController";
    AppMethodBeat.o(94366);
  }
  
  public final void b(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94365);
    s.u(parama, "renderer");
    super.b(parama);
    parama.nDt = ((b)new a(parama, this));
    Log.i(this.TAG, s.X("setPreviewRenderer: ", Integer.valueOf(parama.hashCode())));
    AppMethodBeat.o(94365);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<SurfaceTexture, ah>
  {
    a(com.tencent.mm.media.j.a parama, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.c
 * JD-Core Version:    0.7.0.1
 */