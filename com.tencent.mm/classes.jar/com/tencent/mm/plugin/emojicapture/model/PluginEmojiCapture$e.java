package com.tencent.mm.plugin.emojicapture.model;

import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class PluginEmojiCapture$e
  implements DialogInterface.OnClickListener
{
  PluginEmojiCapture$e(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(2620);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_emoji_panel_type", 1);
    d.b(this.hEq, "emoji", ".ui.EmojiCustomUI", paramDialogInterface);
    AppMethodBeat.o(2620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture.e
 * JD-Core Version:    0.7.0.1
 */