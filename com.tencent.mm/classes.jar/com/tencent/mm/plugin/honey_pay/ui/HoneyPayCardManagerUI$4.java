package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ab;

final class HoneyPayCardManagerUI$4
  implements View.OnClickListener
{
  HoneyPayCardManagerUI$4(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41796);
    if (HoneyPayCardManagerUI.c(this.nIw) != null)
    {
      ab.d(this.nIw.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(this.nIw).xAE) });
      if (HoneyPayCardManagerUI.c(this.nIw).xAE)
      {
        HoneyPayCardManagerUI.e(this.nIw);
        AppMethodBeat.o(41796);
        return;
      }
      HoneyPayCardManagerUI.f(this.nIw);
    }
    AppMethodBeat.o(41796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.4
 * JD-Core Version:    0.7.0.1
 */