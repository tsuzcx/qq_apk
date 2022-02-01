package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;

final class EmojiCustomUI$10
  implements Runnable
{
  EmojiCustomUI$10(EmojiCustomUI paramEmojiCustomUI, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(270403);
    int i = 0;
    while (i < this.xSa.size())
    {
      Log.i("MicroMsg.emoji.EmojiCustomUI", "delete md5List md5:%s", new Object[] { this.xSa.get(i) });
      EmojiInfo localEmojiInfo = s.getEmojiStorageMgr().adju.bza((String)this.xSa.get(i));
      h.OAn.b(10613, new Object[] { this.xSa.get(i), localEmojiInfo.field_groupId, localEmojiInfo.field_designerID, localEmojiInfo.field_activityid });
      i += 1;
    }
    AppMethodBeat.o(270403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.10
 * JD-Core Version:    0.7.0.1
 */