package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureEditorContainer$5
  implements View.OnClickListener
{
  CaptureEditorContainer$5(CaptureEditorContainer paramCaptureEditorContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3029);
    CaptureEditorContainer.c(this.lzm).lsP = (System.currentTimeMillis() - CaptureEditorContainer.c(this.lzm).lsL);
    EmojiCaptureReporter.a(17, CaptureEditorContainer.c(this.lzm).eyh, 0L, 0L, CaptureEditorContainer.c(this.lzm).lsP, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.lzm).scene);
    EmojiCaptureReporter.uB(3);
    paramView = this.lzm.getPresenter();
    if (paramView != null)
    {
      paramView.bnC();
      AppMethodBeat.o(3029);
      return;
    }
    AppMethodBeat.o(3029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.5
 * JD-Core Version:    0.7.0.1
 */