package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.TenpaySecureEditText;

class KindaSecureEditTextImpl$1
  implements View.OnClickListener
{
  KindaSecureEditTextImpl$1(KindaSecureEditTextImpl paramKindaSecureEditTextImpl) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144800);
    KindaSecureEditTextImpl.access$000(this.this$0).setText("");
    AppMethodBeat.o(144800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSecureEditTextImpl.1
 * JD-Core Version:    0.7.0.1
 */