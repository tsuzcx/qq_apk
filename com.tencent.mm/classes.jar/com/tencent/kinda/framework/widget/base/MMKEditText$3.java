package com.tencent.kinda.framework.widget.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;
import com.tenpay.android.wechat.TenpaySecureEditText;

class MMKEditText$3
  implements a
{
  MMKEditText$3(MMKEditText paramMMKEditText) {}
  
  public void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(144867);
    if ((!paramBoolean) && (this.this$0.editText.isFocused())) {
      this.this$0.editText.clearFocus();
    }
    AppMethodBeat.o(144867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKEditText.3
 * JD-Core Version:    0.7.0.1
 */