package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

final class MobileVerifyUI$8
  implements View.OnClickListener
{
  private final int iUW = 0;
  private final int iUX = 1;
  private final int iUY = 2;
  
  MobileVerifyUI$8(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128447);
    paramView = new com.tencent.mm.ui.tools.l(this.iUU);
    paramView.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(128445);
        paramAnonymousl.c(0, MobileVerifyUI.8.this.iUU.getString(2131761301));
        if (b.CO(MobileVerifyUI.8.this.iUU.dnz)) {
          paramAnonymousl.c(1, MobileVerifyUI.8.this.iUU.getString(2131756518));
        }
        if ((MobileVerifyUI.f(MobileVerifyUI.8.this.iUU) == 2) && (MobileVerifyUI.8.this.iUU.iUP)) {
          paramAnonymousl.c(2, MobileVerifyUI.8.this.iUU.getString(2131762331));
        }
        AppMethodBeat.o(128445);
      }
    };
    paramView.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(128446);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(128446);
          return;
        case 0: 
          MobileVerifyUI.g(MobileVerifyUI.8.this.iUU);
          AppMethodBeat.o(128446);
          return;
        }
        MobileVerifyUI.8.this.iUU.hideVKB();
        if (MobileVerifyUI.f(MobileVerifyUI.8.this.iUU) == 2) {
          com.tencent.mm.plugin.b.a.IL("R200_500");
        }
        for (;;)
        {
          paramAnonymousMenuItem = new Intent(MobileVerifyUI.8.this.iUU, RegByMobileVoiceVerifyUI.class);
          Object localObject = new Bundle();
          ((Bundle)localObject).putString("bindmcontact_mobile", MobileVerifyUI.8.this.iUU.dnz);
          ((Bundle)localObject).putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.8.this.iUU));
          paramAnonymousMenuItem.putExtras((Bundle)localObject);
          localObject = MobileVerifyUI.8.this.iUU;
          paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.aeD(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MobileVerifyUI)localObject).startActivity((Intent)paramAnonymousMenuItem.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          if (MobileVerifyUI.f(MobileVerifyUI.8.this.iUU) == 3) {
            com.tencent.mm.plugin.b.a.IL("F200_300");
          }
        }
      }
    };
    paramView.ftL();
    AppMethodBeat.o(128447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.8
 * JD-Core Version:    0.7.0.1
 */