package com.tencent.mm.plugin.emojicapture.ui;

import a.d.b.g;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class EmojiCaptureUI$c
  implements DialogInterface.OnClickListener
{
  EmojiCaptureUI$c(EmojiCaptureUI paramEmojiCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.k(paramDialogInterface, "dialog");
    paramDialogInterface.dismiss();
    this.jos.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.c
 * JD-Core Version:    0.7.0.1
 */