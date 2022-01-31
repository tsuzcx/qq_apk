package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.k;
import android.view.View;

public final class EditorItemContainer$d
  implements Runnable
{
  public EditorItemContainer$d(EditorItemContainer paramEditorItemContainer) {}
  
  public final void run()
  {
    EditorItemContainer localEditorItemContainer = this.jqa;
    a locala = EditorItemContainer.a(this.jqa);
    if (locala == null) {
      throw new k("null cannot be cast to non-null type android.view.View");
    }
    localEditorItemContainer.removeView((View)locala);
    EditorItemContainer.b(this.jqa);
    EditorItemContainer.d(this.jqa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer.d
 * JD-Core Version:    0.7.0.1
 */