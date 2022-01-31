package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureEditorContainer$3
  implements View.OnClickListener
{
  CaptureEditorContainer$3(CaptureEditorContainer paramCaptureEditorContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3027);
    EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.lzm).eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.lzm).scene);
    paramView = this.lzm;
    if (!this.lzm.bnF()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.gT(bool);
      AppMethodBeat.o(3027);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.3
 * JD-Core Version:    0.7.0.1
 */