package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public final class a
  extends c<mv>
{
  public a()
  {
    AppMethodBeat.i(52807);
    this.__eventId = mv.class.getName().hashCode();
    AppMethodBeat.o(52807);
  }
  
  public static void bkK()
  {
    AppMethodBeat.i(52810);
    boolean bool = bo.a((Boolean)g.RL().Ru().get(348162, null), false);
    Object localObject;
    if ((!bo.a((Boolean)g.RL().Ru().get(ac.a.yxM, null), false)) && (bool))
    {
      localObject = g.RL().Ru().get(348163, null);
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
        ab.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
        localObject = (ArrayList)i.getEmojiStorageMgr().yNn.NF(0);
        if (((ArrayList)localObject).size() <= 0)
        {
          ab.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
          g.RL().Ru().set(348162, Boolean.FALSE);
          AppMethodBeat.o(52810);
          return;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          g.RL().Ru().set(348163, Long.valueOf(System.currentTimeMillis()));
          ab.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
          if (((ArrayList)localObject).size() > 50)
          {
            int k = ((ArrayList)localObject).size();
            int m = k / 50;
            ab.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[] { Integer.valueOf(m) });
            i = 0;
            if (i <= m)
            {
              ArrayList localArrayList = new ArrayList();
              int n = i * 50;
              if ((i + 1) * 50 - 1 >= k) {}
              for (int j = k;; j = (i + 1) * 50)
              {
                ab.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(j) });
                if (j > n)
                {
                  localArrayList.addAll(((ArrayList)localObject).subList(n, j));
                  g.RK().eHt.a(new com.tencent.mm.plugin.emoji.f.d(localArrayList), 0);
                }
                i += 1;
                break;
              }
            }
            AppMethodBeat.o(52810);
            return;
          }
          g.RK().eHt.a(new com.tencent.mm.plugin.emoji.f.d((ArrayList)localObject), 0);
        }
      }
      AppMethodBeat.o(52810);
      return;
    }
  }
  
  public static void gD(boolean paramBoolean)
  {
    AppMethodBeat.i(52808);
    Object localObject = g.RL().Ru().get(ac.a.yxN, null);
    if ((localObject != null) && ((localObject instanceof Long))) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 86400000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        boolean bool = i.getEmojiStorageMgr().yNo.dze();
        ab.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramBoolean))
        {
          localObject = new s(i.getEmojiStorageMgr().yNo.dzg(), 1);
          g.RK().eHt.a((m)localObject, 0);
          AppMethodBeat.o(52808);
          return;
          i = 0;
        }
        else
        {
          g.RL().Ru().set(ac.a.yxQ, Boolean.TRUE);
        }
      }
      AppMethodBeat.o(52808);
      return;
    }
  }
  
  public static void gE(boolean paramBoolean)
  {
    AppMethodBeat.i(52809);
    Object localObject;
    if (bo.a((Boolean)g.RL().Ru().get(348165, null), false))
    {
      localObject = g.RL().Ru().get(348166, null);
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
        localObject = i.getEmojiStorageMgr().yNn.dzC();
        if (((ArrayList)localObject).size() <= 0) {
          break label250;
        }
        ab.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
        ArrayList localArrayList = new ArrayList();
        int j = ((ArrayList)localObject).size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.d((String)((ArrayList)localObject).get(i)));
            ab.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[] { ((ArrayList)localObject).get(i) });
            i += 1;
            continue;
            i = 0;
            break;
            i = 0;
            break;
          }
        }
        i.blq().lje.bq(localArrayList);
        i.blq().lje.blM();
      }
      for (;;)
      {
        g.RL().Ru().set(348166, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(52809);
        return;
        label250:
        ab.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
        g.RL().Ru().set(348165, Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.a
 * JD-Core Version:    0.7.0.1
 */