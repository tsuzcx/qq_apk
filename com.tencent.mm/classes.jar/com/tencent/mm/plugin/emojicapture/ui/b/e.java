package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"})
public final class e
  extends h
  implements k
{
  private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
  private boolean ilO;
  
  public e()
  {
    super((byte)0);
  }
  
  public final com.tencent.mm.media.j.b.a aEC()
  {
    AppMethodBeat.i(853);
    Log.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.ilO);
    if (this.ilO)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
      AppMethodBeat.o(853);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new a(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
    AppMethodBeat.o(853);
    return locala;
  }
  
  public final d cJX()
  {
    AppMethodBeat.i(256451);
    com.tencent.mm.media.j.b.a locala = this.ijo;
    Object localObject = locala;
    if (!(locala instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      localObject = ((k)localObject).cJX();
      AppMethodBeat.o(256451);
      return localObject;
    }
    AppMethodBeat.o(256451);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */