package com.tencent.mm.plugin.emoji.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.e;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(108572);
    Object localObject = k.getEmojiStorageMgr().JfW;
    String str = this.pKc;
    long l1;
    long l2;
    if (com.tencent.mm.plugin.emoji.h.b.acZ(str))
    {
      l1 = ((e)localObject).JiM.getLong("274544".concat(String.valueOf(str)), 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 86400000L) {}
    }
    while (i != 0)
    {
      k.cig();
      localObject = this.pKc;
      if (bu.isNullOrNil((String)localObject))
      {
        ae.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
        AppMethodBeat.o(108572);
        return;
        if ((((e)localObject).aWj(str)) || (l2 - l1 < 3600000L)) {
          i = 0;
        }
      }
      else
      {
        localObject = new com.tencent.mm.plugin.emoji.f.k((String)localObject);
        g.ajQ().gDv.a((n)localObject, 0);
      }
    }
    AppMethodBeat.o(108572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c.1
 * JD-Core Version:    0.7.0.1
 */