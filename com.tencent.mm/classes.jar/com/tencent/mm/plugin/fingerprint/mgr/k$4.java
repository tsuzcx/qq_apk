package com.tencent.mm.plugin.fingerprint.mgr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.mm.wallet_core.e;

final class k$4
  implements View.OnClickListener
{
  k$4(k paramk, e parame, Bundle paramBundle, Activity paramActivity, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64396);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletSoterService", "click fingerprint btn");
    if (this.Hgs != null)
    {
      this.Hgp.putBoolean("key_show_guide", false);
      paramView = new Intent();
      paramView.putExtras(this.Hgp);
      c.b(this.hkm, "fingerprint", ".ui.FingerPrintAuthTransparentUI", paramView);
    }
    this.ubf.dismiss();
    a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.k.4
 * JD-Core Version:    0.7.0.1
 */