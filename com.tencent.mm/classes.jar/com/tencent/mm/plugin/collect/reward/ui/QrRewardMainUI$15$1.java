package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class QrRewardMainUI$15$1
  implements DialogInterface.OnClickListener
{
  QrRewardMainUI$15$1(QrRewardMainUI.15 param15) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(63957);
    ad.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
    AppMethodBeat.o(63957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.15.1
 * JD-Core Version:    0.7.0.1
 */