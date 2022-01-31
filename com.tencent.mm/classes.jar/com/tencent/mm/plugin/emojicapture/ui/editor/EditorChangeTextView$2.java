package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

public final class EditorChangeTextView$2
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable != null)
    {
      if (((CharSequence)paramEditable).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        EditorChangeTextView.a(this.jpR).setVisibility(0);
        return;
      }
    }
    EditorChangeTextView.a(this.jpR).setVisibility(8);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jpR.setTextChanged(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.2
 * JD-Core Version:    0.7.0.1
 */