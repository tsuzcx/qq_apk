package com.tencent.mm.plugin.editor;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EditorUI$6
  implements DialogInterface.OnClickListener
{
  EditorUI$6(EditorUI paramEditorUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(181522);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(181522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.6
 * JD-Core Version:    0.7.0.1
 */