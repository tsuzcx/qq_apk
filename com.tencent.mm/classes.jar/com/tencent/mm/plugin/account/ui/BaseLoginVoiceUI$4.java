package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseLoginVoiceUI$4
  implements View.OnClickListener
{
  BaseLoginVoiceUI$4(BaseLoginVoiceUI paramBaseLoginVoiceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305057);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    BaseLoginVoiceUI.e(this.pZB);
    a.a(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.4
 * JD-Core Version:    0.7.0.1
 */