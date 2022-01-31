package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.sdk.platformtools.ab;

final class CollectMainUI$16$1
  implements DialogInterface.OnClickListener
{
  CollectMainUI$16$1(CollectMainUI.16 param16) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41269);
    ab.i("MicroMsg.CollectMainUI", "save code from click");
    if (CollectMainUI.d(this.kSG.kSz) != null)
    {
      CollectMainUI.dE(CollectMainUI.d(this.kSG.kSz).username, CollectMainUI.d(this.kSG.kSz).iFJ);
      h.qsU.e(15387, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(41269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.16.1
 * JD-Core Version:    0.7.0.1
 */