package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"})
public final class e
  extends h
  implements k
{
  private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
  private boolean laO;
  
  public e()
  {
    super((byte)0);
  }
  
  public final com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(853);
    Log.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.laO);
    if (this.laO)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
      AppMethodBeat.o(853);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new a(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
    AppMethodBeat.o(853);
    return locala;
  }
  
  public final d cYH()
  {
    AppMethodBeat.i(202698);
    com.tencent.mm.media.j.b.a locala = this.kYb;
    Object localObject = locala;
    if (!(locala instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      localObject = ((k)localObject).cYH();
      AppMethodBeat.o(202698);
      return localObject;
    }
    AppMethodBeat.o(202698);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */