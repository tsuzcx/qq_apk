package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoMixRenderer;", "Lcom/tencent/mm/media/render/MixRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "videoHeight", "videoWidth", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setVideoSize", "", "width", "height", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.media.j.c
{
  final String TAG = "MicroMsg.FinderVideoMixRenderer";
  int videoHeight;
  int videoWidth;
  
  public k(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 4);
  }
  
  public final com.tencent.mm.media.j.b.a amr()
  {
    AppMethodBeat.i(204823);
    Object localObject = new c(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
    ((com.tencent.mm.media.j.b.a)localObject).hnr = this.hnr;
    int i = this.videoWidth;
    int j = this.videoHeight;
    ((c)localObject).videoWidth = i;
    ((c)localObject).videoHeight = j;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(204823);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.k
 * JD-Core Version:    0.7.0.1
 */