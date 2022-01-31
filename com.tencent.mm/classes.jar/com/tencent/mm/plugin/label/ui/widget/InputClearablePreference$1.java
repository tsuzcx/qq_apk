package com.tencent.mm.plugin.label.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class InputClearablePreference$1
  implements TextWatcher
{
  InputClearablePreference$1(InputClearablePreference paramInputClearablePreference) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    if (paramEditable != null)
    {
      paramEditable = paramEditable.toString();
      InputClearablePreference.a(this.lCD, paramEditable);
      InputClearablePreference localInputClearablePreference = this.lCD;
      if (bk.bl(paramEditable)) {}
      for (;;)
      {
        InputClearablePreference.a(localInputClearablePreference, bool);
        InputClearablePreference.b(this.lCD, paramEditable);
        return;
        bool = true;
      }
    }
    InputClearablePreference.a(this.lCD, false);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence != null)
    {
      y.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", new Object[] { paramCharSequence.toString() });
      if (InputClearablePreference.a(this.lCD) != null) {
        InputClearablePreference.a(this.lCD).Gs(paramCharSequence.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.1
 * JD-Core Version:    0.7.0.1
 */