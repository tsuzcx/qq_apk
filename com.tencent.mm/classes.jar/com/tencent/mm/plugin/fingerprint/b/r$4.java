package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c;

final class r$4
  implements View.OnClickListener
{
  r$4(r paramr, c paramc, Bundle paramBundle, Activity paramActivity, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41564);
    ab.i("MicroMsg.WalletSoterService", "click fingerprint btn");
    if (this.mGA != null)
    {
      this.mGx.putBoolean("key_show_guide", false);
      paramView = new Intent();
      paramView.putExtras(this.mGx);
      d.b(this.gjR, "fingerprint", ".ui.FingerPrintAuthTransparentUI", paramView);
    }
    this.iMU.dismiss();
    AppMethodBeat.o(41564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.r.4
 * JD-Core Version:    0.7.0.1
 */