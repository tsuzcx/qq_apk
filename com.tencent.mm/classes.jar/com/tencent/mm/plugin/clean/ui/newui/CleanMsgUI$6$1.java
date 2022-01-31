package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;

final class CleanMsgUI$6$1
  implements DialogInterface.OnClickListener
{
  CleanMsgUI$6$1(CleanMsgUI.6 param6) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    CleanMsgUI.a(this.iEj.iEh, new e(d.aDO(), this.iEj.iEh, CleanMsgUI.aEj()));
    CleanMsgUI.b(this.iEj.iEh).start();
    CleanMsgUI.c(this.iEj.iEh).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.6.1
 * JD-Core Version:    0.7.0.1
 */