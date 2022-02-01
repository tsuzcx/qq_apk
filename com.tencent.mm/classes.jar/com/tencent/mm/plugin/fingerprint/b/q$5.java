package com.tencent.mm.plugin.fingerprint.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.i;

final class q$5
  implements View.OnClickListener
{
  q$5(q paramq, CheckBox paramCheckBox, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64397);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.WalletSoterService", "click cancel btn");
    if (this.thv.isChecked()) {
      g.ajC().ajl().set(al.a.Isc, Boolean.TRUE);
    }
    this.mBZ.dismiss();
    a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q.5
 * JD-Core Version:    0.7.0.1
 */