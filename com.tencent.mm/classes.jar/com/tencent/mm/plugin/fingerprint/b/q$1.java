package com.tencent.mm.plugin.fingerprint.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.ui.MMActivity;

final class q$1
  implements DialogInterface.OnClickListener
{
  q$1(q paramq, MMActivity paramMMActivity, Bundle paramBundle) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64393);
    Object localObject = new Intent(this.val$activity, WalletFaceIdAuthUI.class);
    ((Intent)localObject).putExtra("pwd", this.thr.getString("key_pwd1"));
    ((Intent)localObject).putExtra("key_scene", 1);
    paramDialogInterface = this.val$activity;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(64393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q.1
 * JD-Core Version:    0.7.0.1
 */