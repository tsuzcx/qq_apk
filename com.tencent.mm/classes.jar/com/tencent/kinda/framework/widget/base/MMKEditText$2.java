package com.tencent.kinda.framework.widget.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback;
import com.tencent.kinda.gen.KEditTextOnTextChangedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;

class MMKEditText$2
  implements TextWatcher
{
  MMKEditText$2(MMKEditText paramMMKEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(144866);
    if ((this.this$0.onTextChangedCallback != null) && (paramEditable != null)) {
      this.this$0.onTextChangedCallback.onTextChanged(paramEditable.toString());
    }
    AppMethodBeat.o(144866);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(144864);
    if ((this.this$0.onTextBeginChangeCallback != null) && (paramCharSequence != null)) {
      this.this$0.onTextBeginChangeCallback.onTextBeginChange(paramCharSequence.toString());
    }
    AppMethodBeat.o(144864);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(144865);
    if (MMKEditText.access$000(this.this$0) == ClearButtonMode.NEVER)
    {
      MMKEditText.access$100(this.this$0).setVisibility(8);
      AppMethodBeat.o(144865);
      return;
    }
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && (MMKEditText.access$000(this.this$0) == ClearButtonMode.WHILEEDITING))
    {
      MMKEditText.access$100(this.this$0).setVisibility(0);
      AppMethodBeat.o(144865);
      return;
    }
    MMKEditText.access$100(this.this$0).setVisibility(4);
    AppMethodBeat.o(144865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKEditText.2
 * JD-Core Version:    0.7.0.1
 */