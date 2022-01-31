package com.tencent.mm.plugin.emoji.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(53031);
    Object localObject = i.getEmojiStorageMgr().yNp;
    String str = this.lgI;
    long l1;
    long l2;
    if (com.tencent.mm.plugin.emoji.h.b.Lk(str))
    {
      l1 = ((com.tencent.mm.storage.emotion.c)localObject).yPW.getLong("274544".concat(String.valueOf(str)), 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 86400000L) {}
    }
    while (i != 0)
    {
      i.blp();
      localObject = this.lgI;
      if (bo.isNullOrNil((String)localObject))
      {
        ab.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
        AppMethodBeat.o(53031);
        return;
        if ((((com.tencent.mm.storage.emotion.c)localObject).asO(str)) || (l2 - l1 < 3600000L)) {
          i = 0;
        }
      }
      else
      {
        localObject = new k((String)localObject);
        g.RK().eHt.a((m)localObject, 0);
      }
    }
    AppMethodBeat.o(53031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c.1
 * JD-Core Version:    0.7.0.1
 */