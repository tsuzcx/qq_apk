package com.tencent.mm.plugin.emojicapture.ui;

import a.d.b.g;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class EmojiCaptureUI$d
  implements DialogInterface.OnClickListener
{
  EmojiCaptureUI$d(EmojiCaptureUI paramEmojiCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.k(paramDialogInterface, "dialog");
    paramDialogInterface.dismiss();
    this.jos.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.d
 * JD-Core Version:    0.7.0.1
 */