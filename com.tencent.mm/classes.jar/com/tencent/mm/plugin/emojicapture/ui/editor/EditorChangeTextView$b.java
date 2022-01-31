package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class EditorChangeTextView$b
  implements Runnable
{
  EditorChangeTextView$b(EditorChangeTextView paramEditorChangeTextView) {}
  
  public final void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jpR.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput((View)EditorChangeTextView.b(this.jpR), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.b
 * JD-Core Version:    0.7.0.1
 */