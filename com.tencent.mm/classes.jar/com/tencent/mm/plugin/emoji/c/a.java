package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;

public final class a
  extends IListener<ps>
{
  public a()
  {
    AppMethodBeat.i(161065);
    this.__eventId = ps.class.getName().hashCode();
    AppMethodBeat.o(161065);
  }
  
  public static void cFr()
  {
    AppMethodBeat.i(108385);
    boolean bool = Util.nullAs((Boolean)g.aAh().azQ().get(348162, null), false);
    Object localObject;
    if ((!Util.nullAs((Boolean)g.aAh().azQ().get(ar.a.NSH, null), false)) && (bool))
    {
      localObject = g.aAh().azQ().get(348163, null);
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
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
        localObject = (ArrayList)k.getEmojiStorageMgr().OpN.aks(0);
        if (((ArrayList)localObject).size() <= 0)
        {
          Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
          g.aAh().azQ().set(348162, Boolean.FALSE);
          AppMethodBeat.o(108385);
          return;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          g.aAh().azQ().set(348163, Long.valueOf(System.currentTimeMillis()));
          Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
          if (((ArrayList)localObject).size() > 50)
          {
            int k = ((ArrayList)localObject).size();
            int m = k / 50;
            Log.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[] { Integer.valueOf(m) });
            i = 0;
            if (i <= m)
            {
              ArrayList localArrayList = new ArrayList();
              int n = i * 50;
              if ((i + 1) * 50 - 1 >= k) {}
              for (int j = k;; j = (i + 1) * 50)
              {
                Log.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(j) });
                if (j > n)
                {
                  localArrayList.addAll(((ArrayList)localObject).subList(n, j));
                  g.aAg().hqi.a(new d(localArrayList), 0);
                }
                i += 1;
                break;
              }
            }
            AppMethodBeat.o(108385);
            return;
          }
          g.aAg().hqi.a(new d((ArrayList)localObject), 0);
        }
      }
      AppMethodBeat.o(108385);
      return;
    }
  }
  
  public static void lq(boolean paramBoolean)
  {
    AppMethodBeat.i(108383);
    Object localObject = g.aAh().azQ().get(ar.a.NSI, null);
    if ((localObject != null) && ((localObject instanceof Long))) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 86400000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        boolean bool = k.getEmojiStorageMgr().OpO.gEP();
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramBoolean))
        {
          localObject = new com.tencent.mm.plugin.emoji.f.t(k.getEmojiStorageMgr().OpO.gER(), 1);
          g.aAg().hqi.a((q)localObject, 0);
          AppMethodBeat.o(108383);
          return;
          i = 0;
        }
        else
        {
          g.aAh().azQ().set(ar.a.NSL, Boolean.TRUE);
        }
      }
      AppMethodBeat.o(108383);
      return;
    }
  }
  
  public static void lr(boolean paramBoolean)
  {
    AppMethodBeat.i(108384);
    Object localObject;
    if (Util.nullAs((Boolean)g.aAh().azQ().get(348165, null), false))
    {
      localObject = g.aAh().azQ().get(348166, null);
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
        localObject = k.getEmojiStorageMgr().OpN.gFn();
        if (((ArrayList)localObject).size() <= 0) {
          break label250;
        }
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
        ArrayList localArrayList = new ArrayList();
        int j = ((ArrayList)localObject).size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.c((String)((ArrayList)localObject).get(i)));
            Log.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[] { ((ArrayList)localObject).get(i) });
            i += 1;
            continue;
            i = 0;
            break;
            i = 0;
            break;
          }
        }
        k.cGg().rds.dh(localArrayList);
        k.cGg().rds.cGC();
      }
      for (;;)
      {
        g.aAh().azQ().set(348166, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(108384);
        return;
        label250:
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
        g.aAh().azQ().set(348165, Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.a
 * JD-Core Version:    0.7.0.1
 */