package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"})
public final class e
  extends h
  implements k
{
  private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
  private boolean hrS;
  
  public e()
  {
    super((byte)0);
  }
  
  public final com.tencent.mm.media.j.b.a amG()
  {
    AppMethodBeat.i(853);
    ae.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.hrS);
    if (this.hrS)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
      AppMethodBeat.o(853);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new a(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
    AppMethodBeat.o(853);
    return locala;
  }
  
  public final d clV()
  {
    AppMethodBeat.i(221779);
    com.tencent.mm.media.j.b.a locala = this.hpT;
    Object localObject = locala;
    if (!(locala instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      localObject = ((k)localObject).clV();
      AppMethodBeat.o(221779);
      return localObject;
    }
    AppMethodBeat.o(221779);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */