package com.tencent.mm.plugin.address.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mm.R.e;
import com.tencent.mm.sdk.platformtools.y;

final class InvoiceEditView$3
  implements TextWatcher
{
  InvoiceEditView$3(InvoiceEditView paramInvoiceEditView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if ((InvoiceEditView.a(this.fuC) == 5) && (InvoiceEditView.b(this.fuC) != paramEditable.toString().length()))
    {
      InvoiceEditView.a(this.fuC, paramEditable.toString().length());
      this.fuC.setBankNumberValStr(paramEditable.toString());
    }
    boolean bool = this.fuC.YL();
    if ((bool != this.fuC.fup) && (InvoiceEditView.c(this.fuC) != null))
    {
      y.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(this.fuC) + ", editType:" + InvoiceEditView.a(this.fuC) + " inputValid change to " + bool);
      this.fuC.fup = bool;
      InvoiceEditView.c(this.fuC).YI();
    }
    if (((!this.fuC.fuw) || (this.fuC.fup)) && (this.fuC.fuw) && (this.fuC.fup)) {
      InvoiceEditView.e(this.fuC).setTextColor(this.fuC.getResources().getColor(R.e.black));
    }
    InvoiceEditView.a(this.fuC, InvoiceEditView.e(this.fuC).isFocused());
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceEditView.3
 * JD-Core Version:    0.7.0.1
 */