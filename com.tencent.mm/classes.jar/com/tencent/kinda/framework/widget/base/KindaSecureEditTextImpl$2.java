package com.tencent.kinda.framework.widget.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KSecureEditTextOnTextChangedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;

class KindaSecureEditTextImpl$2
  implements TextWatcher
{
  KindaSecureEditTextImpl$2(KindaSecureEditTextImpl paramKindaSecureEditTextImpl) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(144802);
    if ((KindaSecureEditTextImpl.access$300(this.this$0) != null) && (paramEditable != null)) {
      KindaSecureEditTextImpl.access$300(this.this$0).onTextChanged(paramEditable.toString());
    }
    AppMethodBeat.o(144802);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(144801);
    if (KindaSecureEditTextImpl.access$100(this.this$0) == ClearButtonMode.NEVER)
    {
      AppMethodBeat.o(144801);
      return;
    }
    if ((paramCharSequence.length() > 0) && (KindaSecureEditTextImpl.access$100(this.this$0) == ClearButtonMode.WHILEEDITING))
    {
      KindaSecureEditTextImpl.access$200(this.this$0).setVisibility(0);
      AppMethodBeat.o(144801);
      return;
    }
    KindaSecureEditTextImpl.access$200(this.this$0).setVisibility(4);
    AppMethodBeat.o(144801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl.2
 * JD-Core Version:    0.7.0.1
 */