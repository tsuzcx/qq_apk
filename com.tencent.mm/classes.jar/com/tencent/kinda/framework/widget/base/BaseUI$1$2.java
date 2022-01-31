package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseUI$1$2
  implements Runnable
{
  BaseUI$1$2(BaseUI.1 param1) {}
  
  public void run()
  {
    AppMethodBeat.i(144649);
    this.this$1.this$0.hideTenpayKB();
    ((InputMethodManager)BaseUI.access$000(this.this$1.this$0).getContext().getSystemService("input_method")).showSoftInput(this.this$1.val$hintTv, 0);
    AppMethodBeat.o(144649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI.1.2
 * JD-Core Version:    0.7.0.1
 */