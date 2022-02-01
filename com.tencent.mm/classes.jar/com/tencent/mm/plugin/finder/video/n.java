package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoMixRenderer;", "Lcom/tencent/mm/media/render/MixRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "videoHeight", "videoWidth", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setVideoSize", "", "width", "height", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends b
{
  final String TAG = "MicroMsg.FinderVideoMixRenderer";
  int videoHeight;
  int videoWidth;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 4);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(334782);
    Object localObject = new c(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
    ((com.tencent.mm.media.j.b.a)localObject).nDB = this.nDB;
    int i = this.videoWidth;
    int j = this.videoHeight;
    ((c)localObject).videoWidth = i;
    ((c)localObject).videoHeight = j;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(334782);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.n
 * JD-Core Version:    0.7.0.1
 */