package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.f;

final class BaseLoginVoiceUI$2
  implements View.OnClickListener
{
  BaseLoginVoiceUI$2(BaseLoginVoiceUI paramBaseLoginVoiceUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305063);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.pZB.hideVKB();
    this.pZC.dDn();
    a.a(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.2
 * JD-Core Version:    0.7.0.1
 */