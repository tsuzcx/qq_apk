package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

final class MobileVerifyUI$8
  implements View.OnClickListener
{
  private final int jof = 0;
  private final int jog = 1;
  private final int joh = 2;
  
  MobileVerifyUI$8(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128447);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new com.tencent.mm.ui.tools.l(this.jod);
    paramView.KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(128445);
        paramAnonymousl.c(0, MobileVerifyUI.8.this.jod.getString(2131761301));
        if (com.tencent.mm.ax.b.FS(MobileVerifyUI.8.this.jod.dzn)) {
          paramAnonymousl.c(1, MobileVerifyUI.8.this.jod.getString(2131756518));
        }
        if ((MobileVerifyUI.f(MobileVerifyUI.8.this.jod) == 2) && (MobileVerifyUI.8.this.jod.jnY)) {
          paramAnonymousl.c(2, MobileVerifyUI.8.this.jod.getString(2131762331));
        }
        AppMethodBeat.o(128445);
      }
    };
    paramView.KJz = new n.e()
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
          MobileVerifyUI.g(MobileVerifyUI.8.this.jod);
          AppMethodBeat.o(128446);
          return;
        }
        MobileVerifyUI.8.this.jod.hideVKB();
        if (MobileVerifyUI.f(MobileVerifyUI.8.this.jod) == 2) {
          com.tencent.mm.plugin.b.a.Ma("R200_500");
        }
        for (;;)
        {
          paramAnonymousMenuItem = new Intent(MobileVerifyUI.8.this.jod, RegByMobileVoiceVerifyUI.class);
          Object localObject = new Bundle();
          ((Bundle)localObject).putString("bindmcontact_mobile", MobileVerifyUI.8.this.jod.dzn);
          ((Bundle)localObject).putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.8.this.jod));
          paramAnonymousMenuItem.putExtras((Bundle)localObject);
          localObject = MobileVerifyUI.8.this.jod;
          paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.ahp(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MobileVerifyUI)localObject).startActivity((Intent)paramAnonymousMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          if (MobileVerifyUI.f(MobileVerifyUI.8.this.jod) == 3) {
            com.tencent.mm.plugin.b.a.Ma("F200_300");
          }
        }
      }
    };
    paramView.fKy();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.8
 * JD-Core Version:    0.7.0.1
 */