package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.i;

final class q$3
  implements View.OnClickListener
{
  q$3(q paramq, Activity paramActivity, Bundle paramBundle, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64395);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    ad.i("MicroMsg.WalletSoterService", "click faceid btn");
    localObject = new Intent(this.iNQ, WalletFaceIdAuthUI.class);
    ((Intent)localObject).putExtra("pwd", this.thr.getString("key_pwd1"));
    ((Intent)localObject).putExtra("key_scene", 1);
    paramView = this.iNQ;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.mBZ.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q.3
 * JD-Core Version:    0.7.0.1
 */