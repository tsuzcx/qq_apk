package com.tencent.mm.plugin.fingerprint.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.i;

final class r$5
  implements View.OnClickListener
{
  r$5(r paramr, CheckBox paramCheckBox, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41565);
    ab.i("MicroMsg.WalletSoterService", "click cancel btn");
    if (this.mGB.isChecked()) {
      g.RL().Ru().set(ac.a.yzA, Boolean.TRUE);
    }
    this.iMU.dismiss();
    AppMethodBeat.o(41565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.r.5
 * JD-Core Version:    0.7.0.1
 */