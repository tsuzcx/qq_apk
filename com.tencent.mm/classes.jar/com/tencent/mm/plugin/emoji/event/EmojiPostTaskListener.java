package com.tencent.mm.plugin.emoji.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.e.d;
import com.tencent.mm.plugin.emoji.e.u;
import com.tencent.mm.plugin.emoji.sync.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;

public class EmojiPostTaskListener
  extends IListener<se>
{
  public EmojiPostTaskListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161065);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(161065);
  }
  
  public static void dyo()
  {
    AppMethodBeat.i(108385);
    boolean bool = Util.nullAs((Boolean)h.baE().ban().d(348162, null), false);
    Object localObject;
    if ((!Util.nullAs((Boolean)h.baE().ban().get(at.a.acHU, null), false)) && (bool))
    {
      localObject = h.baE().ban().d(348163, null);
      if ((localObject == null) || (!(localObject instanceof Long))) {
        break label396;
      }
    }
    label396:
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 3600000L) {
        i = 1;
      }
      while (i != 0)
      {
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
        localObject = (ArrayList)com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.azf(0);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0))
        {
          Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
          h.baE().ban().B(348162, Boolean.FALSE);
          AppMethodBeat.o(108385);
          return;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          h.baE().ban().B(348163, Long.valueOf(System.currentTimeMillis()));
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
                  h.baD().mCm.a(new d(localArrayList), 0);
                }
                i += 1;
                break;
              }
            }
            AppMethodBeat.o(108385);
            return;
          }
          h.baD().mCm.a(new d((ArrayList)localObject), 0);
        }
      }
      AppMethodBeat.o(108385);
      return;
    }
  }
  
  public static void nY(boolean paramBoolean)
  {
    AppMethodBeat.i(108383);
    Object localObject = h.baE().ban().get(at.a.acHV, null);
    if ((localObject != null) && ((localObject instanceof Long))) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 86400000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        boolean bool = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.jdg();
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) || (paramBoolean))
        {
          localObject = new u(com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.jdh(), 1);
          h.baD().mCm.a((p)localObject, 0);
          AppMethodBeat.o(108383);
          return;
          i = 0;
        }
        else
        {
          h.baE().ban().set(at.a.acHY, Boolean.TRUE);
        }
      }
      AppMethodBeat.o(108383);
      return;
    }
  }
  
  public static void nZ(boolean paramBoolean)
  {
    AppMethodBeat.i(108384);
    Object localObject;
    if (Util.nullAs((Boolean)h.baE().ban().d(348165, null), false))
    {
      localObject = h.baE().ban().d(348166, null);
      if ((localObject == null) || (!(localObject instanceof Long))) {
        break label281;
      }
    }
    label256:
    label281:
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 3600000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        localObject = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.jdG();
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label256;
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
        com.tencent.mm.plugin.emoji.model.s.dAm().xPe.fc(localArrayList);
        com.tencent.mm.plugin.emoji.model.s.dAm().xPe.dAN();
      }
      for (;;)
      {
        h.baE().ban().B(348166, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(108384);
        return;
        Log.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
        h.baE().ban().B(348165, Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.event.EmojiPostTaskListener
 * JD-Core Version:    0.7.0.1
 */