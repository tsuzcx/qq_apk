package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ah;

final class y$3
  implements TextWatcher
{
  y$3(y paramy) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.hvH.hcZ.removeCallbacks(this.hvH.hvG);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y.3
 * JD-Core Version:    0.7.0.1
 */