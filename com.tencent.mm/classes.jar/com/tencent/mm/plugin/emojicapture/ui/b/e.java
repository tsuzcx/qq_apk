package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCapturePreviewRenderer;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "()V", "TAG", "", "useCpuCrop", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getRecordTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends h
  implements k
{
  private final String TAG = "MicroMsg.EmojiCapturePreviewRenderer";
  private boolean nFT;
  
  public e()
  {
    super((byte)0);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(853);
    Log.i(this.TAG, s.X("doInitRenderProc, useCpuCrop:", Boolean.valueOf(this.nFT)));
    if (this.nFT)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
      AppMethodBeat.o(853);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new a(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
    AppMethodBeat.o(853);
    return locala;
  }
  
  public final d dEY()
  {
    AppMethodBeat.i(269449);
    Object localObject = this.nDm;
    if ((localObject instanceof k)) {}
    for (localObject = (k)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(269449);
      return null;
    }
    localObject = ((k)localObject).dEY();
    AppMethodBeat.o(269449);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.e
 * JD-Core Version:    0.7.0.1
 */