package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;

final class EmojiAddCustomDialogUI$4
  implements DialogInterface.OnClickListener
{
  EmojiAddCustomDialogUI$4(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    h.nFQ.f(11596, new Object[] { Integer.valueOf(3) });
    paramDialogInterface.setClass(EmojiAddCustomDialogUI.g(this.jcr), EmojiCustomUI.class);
    this.jcr.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.4
 * JD-Core Version:    0.7.0.1
 */