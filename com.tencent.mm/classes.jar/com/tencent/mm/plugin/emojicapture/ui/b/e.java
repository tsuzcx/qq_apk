package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"})
public final class e
  extends h
  implements k
{
  private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
  private boolean gwB;
  
  public e()
  {
    super((byte)0);
  }
  
  public final com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(853);
    ad.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.gwB);
    if (this.gwB)
    {
      locala = (com.tencent.mm.media.i.b.a)new f(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
      AppMethodBeat.o(853);
      return locala;
    }
    com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new a(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
    AppMethodBeat.o(853);
    return locala;
  }
  
  public final d fRl()
  {
    AppMethodBeat.i(205006);
    com.tencent.mm.media.i.b.a locala = this.gux;
    Object localObject = locala;
    if (!(locala instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      localObject = ((k)localObject).fRl();
      AppMethodBeat.o(205006);
      return localObject;
    }
    AppMethodBeat.o(205006);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */