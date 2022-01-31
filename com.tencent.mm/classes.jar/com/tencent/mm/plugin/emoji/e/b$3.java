package com.tencent.mm.plugin.emoji.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class b$3
  implements DialogInterface.OnClickListener
{
  b$3(b paramb, EmojiInfo paramEmojiInfo) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.a(this.iWz, this.iWy);
    this.iWz.iWx = true;
    y.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[] { this.iWy.field_groupId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.3
 * JD-Core Version:    0.7.0.1
 */