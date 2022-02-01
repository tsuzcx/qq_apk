package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.i;

final class q$4
  implements View.OnClickListener
{
  q$4(q paramq, com.tencent.mm.wallet_core.d paramd, Bundle paramBundle, Activity paramActivity, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64396);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.WalletSoterService", "click fingerprint btn");
    if (this.thu != null)
    {
      this.thr.putBoolean("key_show_guide", false);
      paramView = new Intent();
      paramView.putExtras(this.thr);
      com.tencent.mm.bs.d.b(this.iNQ, "fingerprint", ".ui.FingerPrintAuthTransparentUI", paramView);
    }
    this.mBZ.dismiss();
    a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q.4
 * JD-Core Version:    0.7.0.1
 */