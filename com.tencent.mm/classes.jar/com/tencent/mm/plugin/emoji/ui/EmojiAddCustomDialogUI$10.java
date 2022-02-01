package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class EmojiAddCustomDialogUI$10
  implements DialogInterface.OnClickListener
{
  EmojiAddCustomDialogUI$10(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(270433);
    Object localObject = new Intent();
    h.OAn.b(11596, new Object[] { Integer.valueOf(3) });
    ((Intent)localObject).setClass(EmojiAddCustomDialogUI.a(this.xRw), EmojiCustomUI.class);
    ((Intent)localObject).putExtra("key_emoji_panel_type", 0);
    paramDialogInterface = this.xRw;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(270433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.10
 * JD-Core Version:    0.7.0.1
 */