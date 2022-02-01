package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class PluginEmojiCapture$c
  implements DialogInterface.OnClickListener
{
  PluginEmojiCapture$c(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(192);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_emoji_panel_type", 1);
    d.b(this.cjo, "emoji", ".ui.EmojiCustomUI", paramDialogInterface);
    AppMethodBeat.o(192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture.c
 * JD-Core Version:    0.7.0.1
 */