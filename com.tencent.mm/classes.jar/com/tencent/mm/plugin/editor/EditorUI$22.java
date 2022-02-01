package com.tencent.mm.plugin.editor;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EditorUI$22
  implements DialogInterface.OnCancelListener
{
  EditorUI$22(EditorUI paramEditorUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(181540);
    if (EditorUI.c(this.upk) != null)
    {
      EditorUI.c(this.upk).dismiss();
      EditorUI.d(this.upk);
    }
    AppMethodBeat.o(181540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.22
 * JD-Core Version:    0.7.0.1
 */