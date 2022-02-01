package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"})
public final class e
  extends h
  implements k
{
  private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
  private boolean hpe;
  
  public e()
  {
    super((byte)0);
  }
  
  public final com.tencent.mm.media.j.b.a amr()
  {
    AppMethodBeat.i(853);
    ad.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.hpe);
    if (this.hpe)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
      AppMethodBeat.o(853);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new a(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
    AppMethodBeat.o(853);
    return locala;
  }
  
  public final d ckF()
  {
    AppMethodBeat.i(195145);
    com.tencent.mm.media.j.b.a locala = this.hnf;
    Object localObject = locala;
    if (!(locala instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      localObject = ((k)localObject).ckF();
      AppMethodBeat.o(195145);
      return localObject;
    }
    AppMethodBeat.o(195145);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */