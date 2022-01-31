package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorItemContainer$c
  implements Runnable
{
  EditorItemContainer$c(EditorItemContainer paramEditorItemContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(3073);
    if (EditorItemContainer.d(this.lzL) != null)
    {
      EditorItemContainer localEditorItemContainer = this.lzL;
      a locala = EditorItemContainer.d(this.lzL);
      if (locala == null) {
        j.ebi();
      }
      localEditorItemContainer.a(locala, false);
    }
    AppMethodBeat.o(3073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer.c
 * JD-Core Version:    0.7.0.1
 */