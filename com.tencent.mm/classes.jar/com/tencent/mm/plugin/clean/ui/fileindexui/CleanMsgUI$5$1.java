package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.clean.c.j;

final class CleanMsgUI$5$1
  implements Runnable
{
  CleanMsgUI$5$1(CleanMsgUI.5 param5, long paramLong) {}
  
  public final void run()
  {
    long l2 = 0L;
    if (CleanMsgUI.a(this.iDx.iDv) != null) {
      CleanMsgUI.a(this.iDx.iDv).dismiss();
    }
    long l3 = j.aEb().iBm;
    long l1 = j.aEb().iBm - this.iCV;
    if (l1 < 0L) {}
    for (l1 = j.aEb().iBk - l3;; l1 = l3)
    {
      j.aEb().iBm = l2;
      j.aEb().iBk = l1;
      CleanMsgUI.a(this.iDx.iDv, j.aEb().iBk, j.aEb().iBl, j.aEb().iBm);
      return;
      l3 = j.aEb().iBk - this.iCV;
      l2 = l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI.5.1
 * JD-Core Version:    0.7.0.1
 */