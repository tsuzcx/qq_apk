package com.tencent.mm.plugin.appbrand.widget.sms;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.y;

final class EditVerifyCodeView$1
  implements TextWatcher
{
  EditVerifyCodeView$1(EditVerifyCodeView paramEditVerifyCodeView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() == 0)) {
      return;
    }
    y.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", new Object[] { paramEditable.toString() });
    if (EditVerifyCodeView.a(this.hEb).length() < 6)
    {
      EditVerifyCodeView.a(this.hEb).append(paramEditable.toString());
      EditVerifyCodeView.b(this.hEb);
    }
    paramEditable.delete(0, paramEditable.length());
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.1
 * JD-Core Version:    0.7.0.1
 */