package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a;
import com.tencent.mm.plugin.report.service.h;

final class EmojiCustomUI$8
  implements DialogInterface.OnClickListener
{
  EmojiCustomUI$8(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = i.aHQ().jan;
    paramDialogInterface.jaA = true;
    paramDialogInterface.aIn();
    h.nFQ.f(11595, new Object[] { Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.8
 * JD-Core Version:    0.7.0.1
 */