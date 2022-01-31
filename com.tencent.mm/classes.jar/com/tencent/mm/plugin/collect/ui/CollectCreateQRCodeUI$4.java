package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a;

final class CollectCreateQRCodeUI$4
  implements View.OnClickListener
{
  CollectCreateQRCodeUI$4(CollectCreateQRCodeUI paramCollectCreateQRCodeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41236);
    this.kRn.hideTenpayKB();
    a.a(this.kRn, this.kRn.getString(2131298441), CollectCreateQRCodeUI.b(this.kRn), "", 32, new CollectCreateQRCodeUI.4.1(this), new CollectCreateQRCodeUI.4.2(this));
    AppMethodBeat.o(41236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.4
 * JD-Core Version:    0.7.0.1
 */