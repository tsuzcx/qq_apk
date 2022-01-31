package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorChangeTextView$b
  implements Runnable
{
  EditorChangeTextView$b(EditorChangeTextView paramEditorChangeTextView) {}
  
  public final void run()
  {
    AppMethodBeat.i(3062);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.lzA.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.showSoftInput((View)EditorChangeTextView.b(this.lzA), 0);
      AppMethodBeat.o(3062);
      return;
    }
    AppMethodBeat.o(3062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.b
 * JD-Core Version:    0.7.0.1
 */