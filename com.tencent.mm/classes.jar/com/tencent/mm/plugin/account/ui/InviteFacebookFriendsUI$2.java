package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InviteFacebookFriendsUI$2
  implements DialogInterface.OnClickListener
{
  InviteFacebookFriendsUI$2(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128022);
    Object localObject = new Intent(this.jmZ.getContext(), FacebookAuthUI.class);
    ((Intent)localObject).putExtra("is_force_unbind", true);
    paramDialogInterface = this.jmZ.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/account/ui/InviteFacebookFriendsUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.jmZ.finish();
    AppMethodBeat.o(128022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.2
 * JD-Core Version:    0.7.0.1
 */