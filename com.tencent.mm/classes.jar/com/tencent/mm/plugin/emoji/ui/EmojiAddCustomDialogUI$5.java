package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiAddCustomDialogUI$5
  implements DialogInterface.OnClickListener
{
  EmojiAddCustomDialogUI$5(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(207446);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.peS, EmojiStoreDetailUI.class);
    ((Intent)localObject).putExtra("extra_id", this.oZO);
    ((Intent)localObject).putExtra("preceding_scence", 20);
    paramDialogInterface = this.peS;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.peS.finish();
    AppMethodBeat.o(207446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.5
 * JD-Core Version:    0.7.0.1
 */