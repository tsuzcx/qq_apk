package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoMixRenderer;", "Lcom/tencent/mm/media/render/MixRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "videoHeight", "videoWidth", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setVideoSize", "", "width", "height", "plugin-finder_release"})
public final class m
  extends com.tencent.mm.media.j.c
{
  final String TAG = "MicroMsg.FinderVideoMixRenderer";
  int videoHeight;
  int videoWidth;
  
  public m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 4);
  }
  
  public final com.tencent.mm.media.j.b.a aEC()
  {
    AppMethodBeat.i(254334);
    Object localObject = new c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
    ((com.tencent.mm.media.j.b.a)localObject).ijA = this.ijA;
    int i = this.videoWidth;
    int j = this.videoHeight;
    ((c)localObject).videoWidth = i;
    ((c)localObject).videoHeight = j;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(254334);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.m
 * JD-Core Version:    0.7.0.1
 */