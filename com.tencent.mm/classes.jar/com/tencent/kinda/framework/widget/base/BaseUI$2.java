package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseUI$2
  implements View.OnClickListener
{
  BaseUI$2(BaseUI paramBaseUI, boolean paramBoolean, int paramInt, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144651);
    if ((!this.this$0.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      this.this$0.showTenpayKB();
      this.this$0.setKBMode(this.val$editMode);
      AppMethodBeat.o(144651);
      return;
    }
    if (this.val$isShowSysKB)
    {
      this.this$0.hideTenpayKB();
      ((InputMethodManager)BaseUI.access$000(this.this$0).getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
    }
    AppMethodBeat.o(144651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI.2
 * JD-Core Version:    0.7.0.1
 */