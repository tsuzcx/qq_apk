package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class InputClearablePreference$4
  implements Runnable
{
  InputClearablePreference$4(InputClearablePreference paramInputClearablePreference) {}
  
  public final void run()
  {
    AppMethodBeat.i(22706);
    if (InputClearablePreference.b(this.nZP) != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)InputClearablePreference.b(this.nZP).getContext().getSystemService("input_method");
      InputClearablePreference.b(this.nZP).requestFocus();
      localInputMethodManager.showSoftInput(InputClearablePreference.b(this.nZP), 0);
      InputClearablePreference.b(this.nZP).setCursorVisible(false);
      InputClearablePreference.b(this.nZP).setCursorVisible(true);
    }
    AppMethodBeat.o(22706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.4
 * JD-Core Version:    0.7.0.1
 */