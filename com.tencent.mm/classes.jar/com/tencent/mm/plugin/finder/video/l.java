package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoMixRenderer;", "Lcom/tencent/mm/media/render/MixRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "videoHeight", "videoWidth", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setVideoSize", "", "width", "height", "plugin-finder_release"})
public final class l
  extends c
{
  int videoHeight;
  int videoWidth;
  
  public l(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 4);
  }
  
  public final com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(199810);
    Object localObject = new f(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
    ((com.tencent.mm.media.i.b.a)localObject).guP = this.guP;
    int i = this.videoWidth;
    int j = this.videoHeight;
    ((f)localObject).videoWidth = i;
    ((f)localObject).videoHeight = j;
    localObject = (com.tencent.mm.media.i.b.a)localObject;
    AppMethodBeat.o(199810);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.l
 * JD-Core Version:    0.7.0.1
 */