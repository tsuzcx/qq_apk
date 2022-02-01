package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"})
public final class e
  extends h
  implements k
{
  private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
  private boolean gWY;
  
  public e()
  {
    super((byte)0);
  }
  
  public final com.tencent.mm.media.i.b.a ajF()
  {
    AppMethodBeat.i(853);
    ac.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.gWY);
    if (this.gWY)
    {
      locala = (com.tencent.mm.media.i.b.a)new f(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
      AppMethodBeat.o(853);
      return locala;
    }
    com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new a(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
    AppMethodBeat.o(853);
    return locala;
  }
  
  public final d cgb()
  {
    AppMethodBeat.i(195166);
    com.tencent.mm.media.i.b.a locala = this.gVc;
    Object localObject = locala;
    if (!(locala instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      localObject = ((k)localObject).cgb();
      AppMethodBeat.o(195166);
      return localObject;
    }
    AppMethodBeat.o(195166);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */