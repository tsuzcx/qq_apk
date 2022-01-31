package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class c$4
  implements DialogInterface.OnClickListener
{
  c$4(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.kbN != null) {
      this.kbN.onClick(paramDialogInterface, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.4
 * JD-Core Version:    0.7.0.1
 */