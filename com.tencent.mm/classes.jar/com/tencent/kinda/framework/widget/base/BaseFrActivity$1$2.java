package com.tencent.kinda.framework.widget.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseFrActivity$1$2
  implements Runnable
{
  BaseFrActivity$1$2(BaseFrActivity.1 param1) {}
  
  public void run()
  {
    AppMethodBeat.i(144641);
    this.this$1.this$0.hideTenpayKB();
    if (BaseFrActivity.access$000(this.this$1.this$0) != null)
    {
      BaseFrActivity.access$000(this.this$1.this$0).scrollTo(0, 0);
      BaseFrActivity.access$002(this.this$1.this$0, null);
    }
    if (this.this$1.val$isShowSysKB) {
      ((InputMethodManager)this.this$1.this$0.getContext().getSystemService("input_method")).showSoftInput(this.this$1.val$hintTv, 0);
    }
    AppMethodBeat.o(144641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity.1.2
 * JD-Core Version:    0.7.0.1
 */