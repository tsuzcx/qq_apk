package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsLuckyMoneyPrepareUI$11
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$11(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(283870);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((!this.Kwc.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      SnsLuckyMoneyPrepareUI.k(this.Kwc);
      SnsLuckyMoneyPrepareUI.b(this.Kwc, this.val$editMode);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283870);
      return;
      if (this.val$isShowSysKB)
      {
        this.Kwc.hideTenpayKB();
        ((InputMethodManager)this.Kwc.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.11
 * JD-Core Version:    0.7.0.1
 */