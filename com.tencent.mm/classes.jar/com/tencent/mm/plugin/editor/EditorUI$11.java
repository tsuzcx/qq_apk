package com.tencent.mm.plugin.editor;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EditorUI$11
  implements MenuItem.OnMenuItemClickListener
{
  EditorUI$11(EditorUI paramEditorUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(181527);
    this.qNX.goBack();
    AppMethodBeat.o(181527);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.11
 * JD-Core Version:    0.7.0.1
 */