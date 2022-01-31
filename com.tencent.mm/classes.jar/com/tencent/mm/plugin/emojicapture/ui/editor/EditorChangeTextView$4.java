package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.plugin.emojicapture.f.a;
import com.tencent.mm.plugin.emojicapture.f.a.a;

final class EditorChangeTextView$4
  implements View.OnClickListener
{
  EditorChangeTextView$4(EditorChangeTextView paramEditorChangeTextView) {}
  
  public final void onClick(View paramView)
  {
    paramView = EditorChangeTextView.b(this.jpR).getText();
    EditorChangeTextView.a locala = this.jpR.getCallback();
    if (locala != null) {
      locala.a((CharSequence)paramView, EditorChangeTextView.c(this.jpR), EditorChangeTextView.d(this.jpR));
    }
    EditorChangeTextView.b(this.jpR).clearFocus();
    if (this.jpR.getTextChanged())
    {
      paramView = a.jnW;
      a.a.a(16, 0L, 0L, 0L);
    }
    paramView = a.jnW;
    a.a.a(15, 0L, 0L, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.4
 * JD-Core Version:    0.7.0.1
 */