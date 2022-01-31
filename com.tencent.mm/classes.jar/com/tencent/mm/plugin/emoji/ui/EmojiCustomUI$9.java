package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.util.ArrayList;

final class EmojiCustomUI$9
  implements Runnable
{
  EmojiCustomUI$9(EmojiCustomUI paramEmojiCustomUI, ArrayList paramArrayList) {}
  
  public final void run()
  {
    int i = 0;
    while (i < this.jcU.size())
    {
      y.i("MicroMsg.emoji.EmojiCustomUI", "delete md5List md5:%s", new Object[] { this.jcU.get(i) });
      EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().uBb.acC((String)this.jcU.get(i));
      h.nFQ.f(10613, new Object[] { this.jcU.get(i), localEmojiInfo.field_groupId, localEmojiInfo.field_designerID, localEmojiInfo.field_activityid });
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.9
 * JD-Core Version:    0.7.0.1
 */