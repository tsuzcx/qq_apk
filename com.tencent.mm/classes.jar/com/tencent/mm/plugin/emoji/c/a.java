package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;

public final class a
  extends IListener<qq>
{
  public a()
  {
    AppMethodBeat.i(161065);
    this.__eventId = qq.class.getName().hashCode();
    AppMethodBeat.o(161065);
  }
  
  public static void cTT()
  {
    AppMethodBeat.i(108385);
    boolean bool = Util.nullAs((Boolean)h.aHG().aHp().b(348162, null), false);
    Object localObject;
    if ((!Util.nullAs((Boolean)h.aHG().aHp().get(ar.a.VgF, null), false)) && (bool))
    {
      localObject = h.aHG().aHp().b(348163, null);
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
        localObject = (ArrayList)p.getEmojiStorageMgr().VFH.asQ(0);
        if (((ArrayList)localObject).size() <= 0)
        {
          Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
          h.aHG().aHp().i(348162, Boolean.FALSE);
          AppMethodBeat.o(108385);
          return;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          h.aHG().aHp().i(348163, Long.valueOf(System.currentTimeMillis()));
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
                  h.aHF().kcd.a(new d(localArrayList), 0);
                }
                i += 1;
                break;
              }
            }
            AppMethodBeat.o(108385);
            return;
          }
          h.aHF().kcd.a(new d((ArrayList)localObject), 0);
        }
      }
      AppMethodBeat.o(108385);
      return;
    }
  }
  
  public static void mC(boolean paramBoolean)
  {
    AppMethodBeat.i(108383);
    Object localObject = h.aHG().aHp().get(ar.a.VgG, null);
    if ((localObject != null) && ((localObject instanceof Long))) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 86400000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        boolean bool = p.getEmojiStorageMgr().VFI.hBf();
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramBoolean))
        {
          localObject = new com.tencent.mm.plugin.emoji.f.t(p.getEmojiStorageMgr().VFI.hBg(), 1);
          h.aHF().kcd.a((q)localObject, 0);
          AppMethodBeat.o(108383);
          return;
          i = 0;
        }
        else
        {
          h.aHG().aHp().set(ar.a.VgJ, Boolean.TRUE);
        }
      }
      AppMethodBeat.o(108383);
      return;
    }
  }
  
  public static void mD(boolean paramBoolean)
  {
    AppMethodBeat.i(108384);
    Object localObject;
    if (Util.nullAs((Boolean)h.aHG().aHp().b(348165, null), false))
    {
      localObject = h.aHG().aHp().b(348166, null);
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
        localObject = p.getEmojiStorageMgr().VFH.hBG();
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
            localArrayList.add(new com.tencent.mm.plugin.emoji.h.a.c((String)((ArrayList)localObject).get(i)));
            Log.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[] { ((ArrayList)localObject).get(i) });
            i += 1;
            continue;
            i = 0;
            break;
            i = 0;
            break;
          }
        }
        p.cUP().uGy.dg(localArrayList);
        p.cUP().uGy.cVn();
      }
      for (;;)
      {
        h.aHG().aHp().i(348166, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(108384);
        return;
        label250:
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
        h.aHG().aHp().i(348165, Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.a
 * JD-Core Version:    0.7.0.1
 */