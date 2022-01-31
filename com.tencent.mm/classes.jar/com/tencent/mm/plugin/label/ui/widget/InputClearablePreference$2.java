package com.tencent.mm.plugin.label.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.MMEditText;

final class InputClearablePreference$2
  implements View.OnClickListener
{
  InputClearablePreference$2(InputClearablePreference paramInputClearablePreference) {}
  
  public final void onClick(View paramView)
  {
    if (InputClearablePreference.b(this.lCD) != null)
    {
      InputClearablePreference.b(this.lCD).setText("");
      InputClearablePreference.b(this.lCD, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.2
 * JD-Core Version:    0.7.0.1
 */