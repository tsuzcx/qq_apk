package com.tencent.mm.plugin.emoji.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.e;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(108572);
    Object localObject = k.getEmojiStorageMgr().ILp;
    String str = this.pDy;
    long l1;
    long l2;
    if (com.tencent.mm.plugin.emoji.h.b.aci(str))
    {
      l1 = ((e)localObject).IOg.getLong("274544".concat(String.valueOf(str)), 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 86400000L) {}
    }
    while (i != 0)
    {
      k.cgQ();
      localObject = this.pDy;
      if (bt.isNullOrNil((String)localObject))
      {
        ad.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
        AppMethodBeat.o(108572);
        return;
        if ((((e)localObject).aUI(str)) || (l2 - l1 < 3600000L)) {
          i = 0;
        }
      }
      else
      {
        localObject = new com.tencent.mm.plugin.emoji.f.k((String)localObject);
        g.ajB().gAO.a((n)localObject, 0);
      }
    }
    AppMethodBeat.o(108572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c.1
 * JD-Core Version:    0.7.0.1
 */