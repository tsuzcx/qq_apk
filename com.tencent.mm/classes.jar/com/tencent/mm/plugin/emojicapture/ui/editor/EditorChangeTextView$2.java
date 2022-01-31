package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-emojicapture_release"})
public final class EditorChangeTextView$2
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(3055);
    if (paramEditable != null)
    {
      if (((CharSequence)paramEditable).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        EditorChangeTextView.a(this.lzA).setVisibility(0);
        AppMethodBeat.o(3055);
        return;
      }
    }
    EditorChangeTextView.a(this.lzA).setVisibility(8);
    AppMethodBeat.o(3055);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(3056);
    this.lzA.setTextChanged(true);
    AppMethodBeat.o(3056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.2
 * JD-Core Version:    0.7.0.1
 */