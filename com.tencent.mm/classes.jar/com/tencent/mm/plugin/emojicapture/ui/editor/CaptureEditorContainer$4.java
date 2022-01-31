package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.c.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureEditorContainer$4
  implements View.OnClickListener
{
  CaptureEditorContainer$4(CaptureEditorContainer paramCaptureEditorContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3028);
    paramView = this.lzm.getPresenter();
    if (paramView != null)
    {
      paramView.zY();
      AppMethodBeat.o(3028);
      return;
    }
    AppMethodBeat.o(3028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.4
 * JD-Core Version:    0.7.0.1
 */