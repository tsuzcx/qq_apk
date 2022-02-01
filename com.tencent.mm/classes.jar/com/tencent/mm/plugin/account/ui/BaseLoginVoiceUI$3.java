package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class BaseLoginVoiceUI$3
  implements View.OnClickListener
{
  BaseLoginVoiceUI$3(BaseLoginVoiceUI paramBaseLoginVoiceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305060);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    BaseLoginVoiceUI.U(this.pZB, this.pZB.getString(r.j.wechat_help_center_url) + LocaleUtil.getApplicationLanguage());
    a.a(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.3
 * JD-Core Version:    0.7.0.1
 */