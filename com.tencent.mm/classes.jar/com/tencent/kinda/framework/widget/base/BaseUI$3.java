package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseUI$3
  implements View.OnClickListener
{
  BaseUI$3(BaseUI paramBaseUI) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144652);
    this.this$0.hideTenpayKB();
    AppMethodBeat.o(144652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI.3
 * JD-Core Version:    0.7.0.1
 */