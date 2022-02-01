package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$createRender$1$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$b$1
  extends com.tencent.mm.media.j.a
{
  d$b$1(int paramInt1, int paramInt2)
  {
    super(0, 0, paramInt1, paramInt2, 15);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(237647);
    Object localObject = com.tencent.mm.media.widget.a.c.nGn;
    if (com.tencent.mm.media.widget.a.c.bsQ())
    {
      localObject = (com.tencent.mm.media.j.b.a)new e(this.mVd, this.mVe, this.mWn, this.mWo, this.nJK, getScaleType());
      AppMethodBeat.o(237647);
      return localObject;
    }
    localObject = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.mVd, this.mVe, this.mWn, this.mWo, this.nJK, getScaleType());
    AppMethodBeat.o(237647);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.1
 * JD-Core Version:    0.7.0.1
 */