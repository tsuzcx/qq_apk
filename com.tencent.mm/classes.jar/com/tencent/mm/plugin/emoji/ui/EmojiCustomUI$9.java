package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(53308);
    int i = 0;
    while (i < this.llH.size())
    {
      ab.i("MicroMsg.emoji.EmojiCustomUI", "delete md5List md5:%s", new Object[] { this.llH.get(i) });
      EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().yNn.asP((String)this.llH.get(i));
      h.qsU.e(10613, new Object[] { this.llH.get(i), localEmojiInfo.field_groupId, localEmojiInfo.field_designerID, localEmojiInfo.field_activityid });
      i += 1;
    }
    AppMethodBeat.o(53308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.9
 * JD-Core Version:    0.7.0.1
 */