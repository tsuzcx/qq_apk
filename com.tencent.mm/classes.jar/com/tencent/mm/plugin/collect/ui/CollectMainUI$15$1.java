package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aws;
import com.tencent.mm.sdk.platformtools.y;

final class CollectMainUI$15$1
  implements DialogInterface.OnClickListener
{
  CollectMainUI$15$1(CollectMainUI.15 param15) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.CollectMainUI", "save code from click");
    if (CollectMainUI.d(this.iLV.iLP) != null)
    {
      CollectMainUI.cF(CollectMainUI.d(this.iLV.iLP).username, CollectMainUI.d(this.iLV.iLP).ttj);
      h.nFQ.f(15387, new Object[] { Integer.valueOf(2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.15.1
 * JD-Core Version:    0.7.0.1
 */