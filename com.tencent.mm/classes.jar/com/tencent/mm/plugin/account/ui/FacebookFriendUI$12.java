package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookFriendUI$12
  implements View.OnClickListener
{
  FacebookFriendUI$12(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127970);
    paramView = this.iqA;
    Object localObject = new Intent(this.iqA, FacebookAuthUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(127970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.12
 * JD-Core Version:    0.7.0.1
 */