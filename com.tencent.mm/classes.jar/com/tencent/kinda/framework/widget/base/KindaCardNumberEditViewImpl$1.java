package com.tencent.kinda.framework.widget.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.kinda.gen.KCardNumberEditViewOnTextChangedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KindaCardNumberEditViewImpl$1
  implements TextWatcher
{
  KindaCardNumberEditViewImpl$1(KindaCardNumberEditViewImpl paramKindaCardNumberEditViewImpl) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(144739);
    if (KindaCardNumberEditViewImpl.access$000(this.this$0) != null) {
      KindaCardNumberEditViewImpl.access$000(this.this$0).onTextChanged(paramCharSequence.toString());
    }
    AppMethodBeat.o(144739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCardNumberEditViewImpl.1
 * JD-Core Version:    0.7.0.1
 */