package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class MMMoneyInputText$1
  implements View.OnClickListener
{
  private byte _hellAccFlag_;
  
  MMMoneyInputText$1(MMMoneyInputText paramMMMoneyInputText, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(19286);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/kinda/framework/widget/base/MMMoneyInputText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.val$context instanceof BaseFrActivity)) {
      ((BaseFrActivity)this.val$context).hideTenpayKB();
    }
    a.a(this, "com/tencent/kinda/framework/widget/base/MMMoneyInputText$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(19286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMMoneyInputText.1
 * JD-Core Version:    0.7.0.1
 */