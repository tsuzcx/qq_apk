package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorChangeTextView$7
  implements View.OnClickListener
{
  EditorChangeTextView$7(EditorChangeTextView paramEditorChangeTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3061);
    EditorChangeTextView.b(this.lzA).requestFocus();
    EditorChangeTextView.a(this.lzA, true);
    AppMethodBeat.o(3061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.7
 * JD-Core Version:    0.7.0.1
 */