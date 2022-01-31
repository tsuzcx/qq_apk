package com.tencent.mm.plugin.address.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.y;

final class AddrEditView$3
  implements TextWatcher
{
  AddrEditView$3(AddrEditView paramAddrEditView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = this.fuv.YL();
    if ((bool != AddrEditView.a(this.fuv)) && (AddrEditView.b(this.fuv) != null))
    {
      y.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(this.fuv) + ", editType:" + AddrEditView.d(this.fuv) + " inputValid change to " + bool);
      AddrEditView.a(this.fuv, bool);
      AddrEditView.b(this.fuv).YI();
    }
    AddrEditView.b(this.fuv, AddrEditView.e(this.fuv).isFocused());
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView.3
 * JD-Core Version:    0.7.0.1
 */