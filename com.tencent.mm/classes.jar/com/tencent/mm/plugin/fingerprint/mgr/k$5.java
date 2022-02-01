package com.tencent.mm.plugin.fingerprint.mgr;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.i;

final class k$5
  implements View.OnClickListener
{
  k$5(k paramk, CheckBox paramCheckBox, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64397);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletSoterService", "click cancel btn");
    if (this.Hgt.isChecked()) {
      h.baE().ban().set(at.a.acJU, Boolean.TRUE);
    }
    this.ubf.dismiss();
    a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.k.5
 * JD-Core Version:    0.7.0.1
 */