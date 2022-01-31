package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMMoneyInputText$1
  implements View.OnClickListener
{
  MMMoneyInputText$1(MMMoneyInputText paramMMMoneyInputText, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(145122);
    if ((this.val$context instanceof BaseFrActivity)) {
      ((BaseFrActivity)this.val$context).hideTenpayKB();
    }
    AppMethodBeat.o(145122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMMoneyInputText.1
 * JD-Core Version:    0.7.0.1
 */