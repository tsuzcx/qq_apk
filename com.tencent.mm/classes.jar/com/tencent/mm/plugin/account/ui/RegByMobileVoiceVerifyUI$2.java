package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RegByMobileVoiceVerifyUI$2
  implements View.OnClickListener
{
  RegByMobileVoiceVerifyUI$2(RegByMobileVoiceVerifyUI paramRegByMobileVoiceVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128625);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.jpP.startActivityForResult(new Intent(this.jpP, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.a(this.jpP)), 10000);
    a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */