package com.tencent.mm.plugin.editor;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EditorUI$3
  implements Runnable
{
  EditorUI$3(EditorUI paramEditorUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(181519);
    if (EditorUI.c(this.upk) != null)
    {
      EditorUI.c(this.upk).dismiss();
      EditorUI.d(this.upk);
    }
    AppMethodBeat.o(181519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.3
 * JD-Core Version:    0.7.0.1
 */