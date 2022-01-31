package com.tencent.mm.plugin.collect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView.e;

final class CollectBillListUI$2
  implements MMPullDownView.e
{
  CollectBillListUI$2(CollectBillListUI paramCollectBillListUI) {}
  
  public final boolean bik()
  {
    AppMethodBeat.i(41187);
    ab.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[] { Boolean.valueOf(CollectBillListUI.g(this.kQS)), Boolean.valueOf(CollectBillListUI.h(this.kQS)) });
    if ((!CollectBillListUI.g(this.kQS)) && (!CollectBillListUI.h(this.kQS)))
    {
      CollectBillListUI.i(this.kQS);
      CollectBillListUI.j(this.kQS);
      AppMethodBeat.o(41187);
      return false;
    }
    AppMethodBeat.o(41187);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.2
 * JD-Core Version:    0.7.0.1
 */