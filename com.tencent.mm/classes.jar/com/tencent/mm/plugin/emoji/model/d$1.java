package com.tencent.mm.plugin.emoji.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

final class d$1
  implements Runnable
{
  d$1(d paramd, String paramString) {}
  
  public final void run()
  {
    int i = 1;
    Object localObject = i.getEmojiStorageMgr().uBd;
    String str = this.iXv;
    long l1;
    long l2;
    if ((!TextUtils.isEmpty(str)) && (!str.equals(EmojiGroupInfo.uCQ)))
    {
      l1 = ((c)localObject).uDp.getLong("274544" + str, 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 86400000L) {}
    }
    for (;;)
    {
      if (i != 0)
      {
        i.aHP();
        localObject = this.iXv;
        if (!bk.bl((String)localObject)) {
          break;
        }
        y.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
      }
      return;
      if ((((c)localObject).acB(str)) || (l2 - l1 < 3600000L)) {
        i = 0;
      }
    }
    localObject = new l((String)localObject);
    g.DO().dJT.a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d.1
 * JD-Core Version:    0.7.0.1
 */