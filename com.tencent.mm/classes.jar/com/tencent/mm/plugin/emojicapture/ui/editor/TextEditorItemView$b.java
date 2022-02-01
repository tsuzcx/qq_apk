package com.tencent.mm.plugin.emojicapture.ui.editor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class TextEditorItemView$b
  implements Runnable
{
  TextEditorItemView$b(TextEditorItemView paramTextEditorItemView) {}
  
  public final void run()
  {
    AppMethodBeat.i(785);
    EditorItemContainer localEditorItemContainer = this.pYb.getItemContainer();
    if (localEditorItemContainer != null)
    {
      localEditorItemContainer.setEditing((a)this.pYb);
      AppMethodBeat.o(785);
      return;
    }
    AppMethodBeat.o(785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView.b
 * JD-Core Version:    0.7.0.1
 */