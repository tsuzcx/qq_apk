package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MallWalletSectionCellView$1
  implements Runnable
{
  MallWalletSectionCellView$1(MallWalletSectionCellView paramMallWalletSectionCellView) {}
  
  public final void run()
  {
    AppMethodBeat.i(43249);
    ab.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(this.oAI.oAy.getX()), Integer.valueOf(this.oAI.oAy.getLeft()) });
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
    localLayoutParams.leftMargin = this.oAI.oAy.getLeft();
    this.oAI.ksW.setLayoutParams(localLayoutParams);
    this.oAI.ksW.setVisibility(0);
    AppMethodBeat.o(43249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView.1
 * JD-Core Version:    0.7.0.1
 */