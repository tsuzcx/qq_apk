package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginIndepPass$14
  implements MenuItem.OnMenuItemClickListener
{
  LoginIndepPass$14(LoginIndepPass paramLoginIndepPass) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(128160);
    com.tencent.mm.plugin.b.a.TA("L200_100");
    Object localObject = new Intent(this.qbg, MobileInputUI.class);
    ((Intent)localObject).putExtra("mobile_input_purpose", 1);
    ((Intent)localObject).addFlags(67108864);
    paramMenuItem = this.qbg;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.qbg.finish();
    AppMethodBeat.o(128160);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.14
 * JD-Core Version:    0.7.0.1
 */