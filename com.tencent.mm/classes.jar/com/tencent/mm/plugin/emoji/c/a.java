package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;

public final class a
  extends com.tencent.mm.sdk.b.c<oh>
{
  public a()
  {
    AppMethodBeat.i(161065);
    this.__eventId = oh.class.getName().hashCode();
    AppMethodBeat.o(161065);
  }
  
  public static void bUy()
  {
    AppMethodBeat.i(108385);
    boolean bool = bt.a((Boolean)g.afB().afk().get(348162, null), false);
    Object localObject;
    if ((!bt.a((Boolean)g.afB().afk().get(ae.a.Fgg, null), false)) && (bool))
    {
      localObject = g.afB().afk().get(348163, null);
      if ((localObject == null) || (!(localObject instanceof Long))) {
        break label391;
      }
    }
    label391:
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 3600000L) {
        i = 1;
      }
      while (i != 0)
      {
        ad.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
        localObject = (ArrayList)k.getEmojiStorageMgr().FyY.WJ(0);
        if (((ArrayList)localObject).size() <= 0)
        {
          ad.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
          g.afB().afk().set(348162, Boolean.FALSE);
          AppMethodBeat.o(108385);
          return;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          g.afB().afk().set(348163, Long.valueOf(System.currentTimeMillis()));
          ad.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
          if (((ArrayList)localObject).size() > 50)
          {
            int k = ((ArrayList)localObject).size();
            int m = k / 50;
            ad.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[] { Integer.valueOf(m) });
            i = 0;
            if (i <= m)
            {
              ArrayList localArrayList = new ArrayList();
              int n = i * 50;
              if ((i + 1) * 50 - 1 >= k) {}
              for (int j = k;; j = (i + 1) * 50)
              {
                ad.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(j) });
                if (j > n)
                {
                  localArrayList.addAll(((ArrayList)localObject).subList(n, j));
                  g.afA().gcy.a(new com.tencent.mm.plugin.emoji.f.d(localArrayList), 0);
                }
                i += 1;
                break;
              }
            }
            AppMethodBeat.o(108385);
            return;
          }
          g.afA().gcy.a(new com.tencent.mm.plugin.emoji.f.d((ArrayList)localObject), 0);
        }
      }
      AppMethodBeat.o(108385);
      return;
    }
  }
  
  public static void jB(boolean paramBoolean)
  {
    AppMethodBeat.i(108383);
    Object localObject = g.afB().afk().get(ae.a.Fgh, null);
    if ((localObject != null) && ((localObject instanceof Long))) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 86400000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        boolean bool = k.getEmojiStorageMgr().FyZ.eNq();
        ad.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramBoolean))
        {
          localObject = new s(k.getEmojiStorageMgr().FyZ.eNs(), 1);
          g.afA().gcy.a((n)localObject, 0);
          AppMethodBeat.o(108383);
          return;
          i = 0;
        }
        else
        {
          g.afB().afk().set(ae.a.Fgk, Boolean.TRUE);
        }
      }
      AppMethodBeat.o(108383);
      return;
    }
  }
  
  public static void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(108384);
    Object localObject;
    if (bt.a((Boolean)g.afB().afk().get(348165, null), false))
    {
      localObject = g.afB().afk().get(348166, null);
      if ((localObject == null) || (!(localObject instanceof Long))) {
        break label275;
      }
    }
    label275:
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 3600000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        localObject = k.getEmojiStorageMgr().FyY.eNN();
        if (((ArrayList)localObject).size() <= 0) {
          break label250;
        }
        ad.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
        ArrayList localArrayList = new ArrayList();
        int j = ((ArrayList)localObject).size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.d((String)((ArrayList)localObject).get(i)));
            ad.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[] { ((ArrayList)localObject).get(i) });
            i += 1;
            continue;
            i = 0;
            break;
            i = 0;
            break;
          }
        }
        k.bVa().ozk.cN(localArrayList);
        k.bVa().ozk.bVx();
      }
      for (;;)
      {
        g.afB().afk().set(348166, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(108384);
        return;
        label250:
        ad.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
        g.afB().afk().set(348165, Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.a
 * JD-Core Version:    0.7.0.1
 */