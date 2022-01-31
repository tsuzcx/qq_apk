package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorChangeTextView$3
  implements View.OnClickListener
{
  EditorChangeTextView$3(EditorChangeTextView paramEditorChangeTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3057);
    this.lzA.cancel();
    AppMethodBeat.o(3057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.3
 * JD-Core Version:    0.7.0.1
 */