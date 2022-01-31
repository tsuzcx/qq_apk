package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.a.a;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class CaptureEditorContainer$k
  implements f.a
{
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    CaptureEditorContainer.g(this.jpF).setOneTimeVideoTextureUpdateCallback((a)new CaptureEditorContainer.k.a(this));
    this.jpF.setStartTick(bk.UZ());
    CaptureEditorContainer.g(this.jpF).start();
  }
  
  public final void onError(int paramInt1, int paramInt2) {}
  
  public final void ug()
  {
    y.i(CaptureEditorContainer.e(this.jpF), "onCompletion cost " + bk.cp(this.jpF.getStartTick()) + "ms");
    this.jpF.setStartTick(bk.UZ());
    Object localObject = CaptureEditorContainer.g(this.jpF);
    ((EmojiVideoPlayTextureView)localObject).joJ = true;
    localObject = ((EmojiVideoPlayTextureView)localObject).joI;
    if (localObject != null) {
      ((i)localObject).tP(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.k
 * JD-Core Version:    0.7.0.1
 */