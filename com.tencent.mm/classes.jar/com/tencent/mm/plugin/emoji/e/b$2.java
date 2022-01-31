package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.a;

final class b$2
  implements Runnable
{
  b$2(b paramb, EmojiInfo paramEmojiInfo, Context paramContext) {}
  
  public final void run()
  {
    int i = 1;
    if ((this.iWy != null) && (!this.iWy.cwK()))
    {
      Object localObject = this.iWy.field_groupId;
      if (bk.bl((String)localObject)) {
        break label86;
      }
      localObject = i.getEmojiStorageMgr().uBc.bE((String)localObject, true);
      if ((localObject == null) || (((EmojiGroupInfo)localObject).field_sync <= 0)) {
        break label86;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        b.a(this.iWz, this.val$context, this.iWy);
        return;
      }
      b.a(this.iWy, false);
      return;
      label86:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.2
 * JD-Core Version:    0.7.0.1
 */