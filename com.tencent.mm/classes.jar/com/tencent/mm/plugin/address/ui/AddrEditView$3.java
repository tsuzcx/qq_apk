package com.tencent.mm.plugin.address.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AddrEditView$3
  implements TextWatcher
{
  AddrEditView$3(AddrEditView paramAddrEditView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(16807);
    boolean bool = this.gLX.asv();
    if ((bool != AddrEditView.a(this.gLX)) && (AddrEditView.b(this.gLX) != null))
    {
      ab.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(this.gLX) + ", editType:" + AddrEditView.d(this.gLX) + " inputValid change to " + bool);
      AddrEditView.a(this.gLX, bool);
      paramEditable = AddrEditView.b(this.gLX);
      AddrEditView.a(this.gLX);
      paramEditable.ass();
    }
    AddrEditView.b(this.gLX, AddrEditView.e(this.gLX).isFocused());
    AppMethodBeat.o(16807);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView.3
 * JD-Core Version:    0.7.0.1
 */