package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class BaseUI$3
  implements View.OnClickListener
{
  private byte _hellAccFlag_;
  
  BaseUI$3(BaseUI paramBaseUI) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(18768);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/kinda/framework/widget/base/BaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.this$0.hideTenpayKB();
    a.a(this, "com/tencent/kinda/framework/widget/base/BaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(18768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI.3
 * JD-Core Version:    0.7.0.1
 */