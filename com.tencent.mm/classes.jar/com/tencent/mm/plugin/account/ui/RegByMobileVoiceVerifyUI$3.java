package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.ui.base.h;

final class RegByMobileVoiceVerifyUI$3
  implements View.OnClickListener
{
  RegByMobileVoiceVerifyUI$3(RegByMobileVoiceVerifyUI paramRegByMobileVoiceVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125465);
    if ((RegByMobileVoiceVerifyUI.b(this.gIW) == 0) || (RegByMobileVoiceVerifyUI.b(this.gIW) == 2) || (RegByMobileVoiceVerifyUI.b(this.gIW) == 3))
    {
      RegByMobileVoiceVerifyUI.a(this.gIW, new a(RegByMobileVoiceVerifyUI.c(this.gIW), RegByMobileVoiceVerifyUI.d(this.gIW), "", 1, RegByMobileVoiceVerifyUI.a(this.gIW)));
      g.Rc().a(RegByMobileVoiceVerifyUI.e(this.gIW), 0);
      h.a(this.gIW, 2131297628, 2131297087, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125463);
          RegByMobileVoiceVerifyUI.3.this.gIW.finish();
          AppMethodBeat.o(125463);
        }
      });
      AppMethodBeat.o(125465);
      return;
    }
    if ((RegByMobileVoiceVerifyUI.b(this.gIW) == 4) || (RegByMobileVoiceVerifyUI.b(this.gIW) == 1))
    {
      RegByMobileVoiceVerifyUI.a(this.gIW, new x(RegByMobileVoiceVerifyUI.c(this.gIW), 1, "", 1, RegByMobileVoiceVerifyUI.a(this.gIW)));
      g.Rc().a(RegByMobileVoiceVerifyUI.f(this.gIW), 0);
      h.a(this.gIW, 2131297628, 2131297087, new RegByMobileVoiceVerifyUI.3.2(this));
    }
    AppMethodBeat.o(125465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */