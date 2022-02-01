package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;

final class EmojiCustomUI$9
  implements Runnable
{
  EmojiCustomUI$9(EmojiCustomUI paramEmojiCustomUI, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(108868);
    int i = 0;
    while (i < this.pIZ.size())
    {
      ad.i("MicroMsg.emoji.EmojiCustomUI", "delete md5List md5:%s", new Object[] { this.pIZ.get(i) });
      EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().ILn.aUK((String)this.pIZ.get(i));
      g.yhR.f(10613, new Object[] { this.pIZ.get(i), localEmojiInfo.field_groupId, localEmojiInfo.field_designerID, localEmojiInfo.field_activityid });
      i += 1;
    }
    AppMethodBeat.o(108868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.9
 * JD-Core Version:    0.7.0.1
 */