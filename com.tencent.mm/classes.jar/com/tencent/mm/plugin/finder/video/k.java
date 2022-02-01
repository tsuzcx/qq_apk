package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoMixRenderer;", "Lcom/tencent/mm/media/render/MixRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "videoHeight", "videoWidth", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setVideoSize", "", "width", "height", "plugin-finder_release"})
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
  
  public final com.tencent.mm.media.j.b.a amG()
  {
    AppMethodBeat.i(205448);
    Object localObject = new c(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
    ((com.tencent.mm.media.j.b.a)localObject).hqf = this.hqf;
    int i = this.videoWidth;
    int j = this.videoHeight;
    ((c)localObject).videoWidth = i;
    ((c)localObject).videoHeight = j;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(205448);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.k
 * JD-Core Version:    0.7.0.1
 */