package com.tencent.mm.plugin.label.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.widget.MMEditText;

final class InputClearablePreference$3
  implements View.OnTouchListener
{
  InputClearablePreference$3(InputClearablePreference paramInputClearablePreference) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (InputClearablePreference.b(this.lCD) != null) {
      InputClearablePreference.b(this.lCD).clearFocus();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.3
 * JD-Core Version:    0.7.0.1
 */