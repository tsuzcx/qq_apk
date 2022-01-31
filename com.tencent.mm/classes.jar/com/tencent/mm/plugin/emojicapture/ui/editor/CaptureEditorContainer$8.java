package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$8", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"})
public final class CaptureEditorContainer$8
  implements EditorItemContainer.b
{
  public final void gY(boolean paramBoolean)
  {
    AppMethodBeat.i(3033);
    if (paramBoolean)
    {
      CaptureEditorContainer.m(this.lzm).setVisibility(8);
      AppMethodBeat.o(3033);
      return;
    }
    CaptureEditorContainer.m(this.lzm).setVisibility(0);
    AppMethodBeat.o(3033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.8
 * JD-Core Version:    0.7.0.1
 */