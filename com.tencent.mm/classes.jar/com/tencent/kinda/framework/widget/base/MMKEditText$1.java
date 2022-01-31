package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.TenpaySecureEditText;

class MMKEditText$1
  implements View.OnClickListener
{
  MMKEditText$1(MMKEditText paramMMKEditText) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144863);
    this.this$0.editText.setText("");
    AppMethodBeat.o(144863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKEditText.1
 * JD-Core Version:    0.7.0.1
 */