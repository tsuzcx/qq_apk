package com.tencent.mm.plugin.label.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class InputClearablePreference$2
  implements View.OnClickListener
{
  InputClearablePreference$2(InputClearablePreference paramInputClearablePreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22704);
    if (InputClearablePreference.b(this.nZP) != null)
    {
      InputClearablePreference.b(this.nZP).setText("");
      InputClearablePreference.b(this.nZP, "");
    }
    AppMethodBeat.o(22704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.2
 * JD-Core Version:    0.7.0.1
 */