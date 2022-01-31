package com.tencent.mm.plugin.mall.ui;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.plugin.wallet_core.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class MallWalletUI$a
  extends a
{
  public TextView oAW;
  public TextView oAX;
  public ProgressBar oAY;
  public ProgressBar oAZ;
  boolean oBa = false;
  
  private MallWalletUI$a(MallWalletUI paramMallWalletUI) {}
  
  public final void a(a.a parama)
  {
    this.oBa = false;
  }
  
  public final void bOR()
  {
    AppMethodBeat.i(142112);
    ab.i("MicroMsg.MallWalletUI", "time expired: %s", new Object[] { Boolean.valueOf(this.oBa) });
    if (!this.oBa)
    {
      if (this.oAW != null) {
        this.oAW.setVisibility(8);
      }
      if (this.oAX != null) {
        this.oAX.setVisibility(8);
      }
      if (this.oAY != null) {
        this.oAY.setVisibility(0);
      }
      if (this.oAZ != null) {
        this.oAZ.setVisibility(0);
      }
    }
    AppMethodBeat.o(142112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI.a
 * JD-Core Version:    0.7.0.1
 */