package com.tencent.mm.plugin.label.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class InputClearablePreference$1
  implements TextWatcher
{
  InputClearablePreference$1(InputClearablePreference paramInputClearablePreference) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    AppMethodBeat.i(22703);
    if (paramEditable != null)
    {
      paramEditable = paramEditable.toString();
      InputClearablePreference.a(this.nZP, paramEditable);
      InputClearablePreference localInputClearablePreference = this.nZP;
      if (bo.isNullOrNil(paramEditable)) {}
      for (;;)
      {
        InputClearablePreference.a(localInputClearablePreference, bool);
        InputClearablePreference.b(this.nZP, paramEditable);
        AppMethodBeat.o(22703);
        return;
        bool = true;
      }
    }
    InputClearablePreference.a(this.nZP, false);
    AppMethodBeat.o(22703);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(22702);
    if (paramCharSequence != null)
    {
      ab.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", new Object[] { paramCharSequence.toString() });
      if (InputClearablePreference.a(this.nZP) != null) {
        InputClearablePreference.a(this.nZP).RV(paramCharSequence.toString());
      }
    }
    AppMethodBeat.o(22702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.1
 * JD-Core Version:    0.7.0.1
 */