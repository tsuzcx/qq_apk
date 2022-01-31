package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.ui.widget.MMEditText;

final class InputClearablePreference$4
  implements Runnable
{
  InputClearablePreference$4(InputClearablePreference paramInputClearablePreference) {}
  
  public final void run()
  {
    if (InputClearablePreference.b(this.lCD) != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)InputClearablePreference.b(this.lCD).getContext().getSystemService("input_method");
      InputClearablePreference.b(this.lCD).requestFocus();
      localInputMethodManager.showSoftInput(InputClearablePreference.b(this.lCD), 0);
      InputClearablePreference.b(this.lCD).setCursorVisible(false);
      InputClearablePreference.b(this.lCD).setCursorVisible(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.4
 * JD-Core Version:    0.7.0.1
 */