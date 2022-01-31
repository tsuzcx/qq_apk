package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class TextEditorItemView$b
  implements Runnable
{
  TextEditorItemView$b(TextEditorItemView paramTextEditorItemView) {}
  
  public final void run()
  {
    AppMethodBeat.i(3110);
    EditorItemContainer localEditorItemContainer = this.lAu.getItemContainer();
    if (localEditorItemContainer != null)
    {
      localEditorItemContainer.setEditing((a)this.lAu);
      AppMethodBeat.o(3110);
      return;
    }
    AppMethodBeat.o(3110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView.b
 * JD-Core Version:    0.7.0.1
 */