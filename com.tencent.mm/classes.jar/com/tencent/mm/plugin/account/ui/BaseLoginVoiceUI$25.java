package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.t;
import java.util.List;

final class BaseLoginVoiceUI$25
  implements View.OnClickListener
{
  BaseLoginVoiceUI$25(BaseLoginVoiceUI paramBaseLoginVoiceUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(304967);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    BaseLoginVoiceUI.a(this.pZB, ((t)this.pZG.get(0)).getItemId());
    a.a(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.25
 * JD-Core Version:    0.7.0.1
 */