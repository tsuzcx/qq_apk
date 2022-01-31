package com.tencent.mm.plugin.address.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class InvoiceEditView$3
  implements TextWatcher
{
  InvoiceEditView$3(InvoiceEditView paramInvoiceEditView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(16832);
    if ((InvoiceEditView.a(this.gMe) == 5) && (InvoiceEditView.b(this.gMe) != paramEditable.toString().length()))
    {
      InvoiceEditView.a(this.gMe, paramEditable.toString().length());
      this.gMe.setBankNumberValStr(paramEditable.toString());
    }
    boolean bool = this.gMe.asv();
    if ((bool != this.gMe.gLR) && (InvoiceEditView.c(this.gMe) != null))
    {
      ab.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(this.gMe) + ", editType:" + InvoiceEditView.a(this.gMe) + " inputValid change to " + bool);
      this.gMe.gLR = bool;
      InvoiceEditView.c(this.gMe).ass();
    }
    if (((!this.gMe.gLY) || (this.gMe.gLR)) && (this.gMe.gLY) && (this.gMe.gLR)) {
      InvoiceEditView.e(this.gMe).setTextColor(this.gMe.getResources().getColor(2131689763));
    }
    InvoiceEditView.a(this.gMe, InvoiceEditView.e(this.gMe).isFocused());
    AppMethodBeat.o(16832);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView.3
 * JD-Core Version:    0.7.0.1
 */