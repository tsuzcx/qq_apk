package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class BaseLoginVoiceUI$29
  implements View.OnClickListener
{
  BaseLoginVoiceUI$29(BaseLoginVoiceUI paramBaseLoginVoiceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(304997);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = this.pZB.getString(r.j.freeze_account_url, new Object[] { LocaleUtil.getApplicationLanguage() });
    BaseLoginVoiceUI.U(this.pZB, paramView);
    a.a(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.29
 * JD-Core Version:    0.7.0.1
 */