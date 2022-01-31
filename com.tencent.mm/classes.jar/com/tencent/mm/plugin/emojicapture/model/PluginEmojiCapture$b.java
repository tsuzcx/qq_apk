package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;

final class PluginEmojiCapture$b
  implements DialogInterface.OnDismissListener
{
  PluginEmojiCapture$b(Context paramContext, Intent paramIntent) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jkr.startActivity(this.jks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture.b
 * JD-Core Version:    0.7.0.1
 */