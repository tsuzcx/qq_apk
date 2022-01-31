package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.md;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.t;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public final class a
  extends c<md>
{
  public a()
  {
    this.udX = md.class.getName().hashCode();
  }
  
  public static void aGY()
  {
    boolean bool = bk.a((Boolean)g.DP().Dz().get(348162, null), false);
    Object localObject;
    if ((!bk.a((Boolean)g.DP().Dz().get(ac.a.unV, null), false)) && (bool))
    {
      localObject = g.DP().Dz().get(348163, null);
      if ((localObject == null) || (!(localObject instanceof Long))) {
        break label370;
      }
    }
    label232:
    label370:
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 3600000L) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          y.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
          localObject = (ArrayList)i.getEmojiStorageMgr().uBb.cwN();
          if (((ArrayList)localObject).size() > 0) {
            break;
          }
          y.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
          g.DP().Dz().o(348162, Boolean.valueOf(false));
        }
        return;
        i = 0;
        continue;
        i = 0;
      }
      g.DP().Dz().o(348163, Long.valueOf(System.currentTimeMillis()));
      y.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
      if (((ArrayList)localObject).size() > 50)
      {
        int k = ((ArrayList)localObject).size();
        int m = k / 50;
        y.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[] { Integer.valueOf(m) });
        i = 0;
        ArrayList localArrayList;
        int n;
        if (i <= m)
        {
          localArrayList = new ArrayList();
          n = i * 50;
          if ((i + 1) * 50 - 1 < k) {
            break label339;
          }
        }
        for (int j = k;; j = (i + 1) * 50)
        {
          y.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(j) });
          if (j > n)
          {
            localArrayList.addAll(((ArrayList)localObject).subList(n, j));
            g.DO().dJT.a(new com.tencent.mm.plugin.emoji.f.e(localArrayList), 0);
          }
          i += 1;
          break label232;
          break;
        }
      }
      g.DO().dJT.a(new com.tencent.mm.plugin.emoji.f.e((ArrayList)localObject), 0);
      return;
    }
  }
  
  public static void fa(boolean paramBoolean)
  {
    Object localObject = g.DP().Dz().get(ac.a.unW, null);
    if ((localObject != null) && ((localObject instanceof Long))) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 86400000L) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (paramBoolean))
        {
          boolean bool = i.getEmojiStorageMgr().uBc.cwt();
          y.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[] { Boolean.valueOf(bool) });
          if ((!bool) && (!paramBoolean)) {
            break;
          }
          localObject = new t(i.getEmojiStorageMgr().uBc.cwv(), 1);
          g.DO().dJT.a((m)localObject, 0);
        }
        return;
      }
      g.DP().Dz().c(ac.a.unZ, Boolean.valueOf(true));
      return;
    }
  }
  
  public static void fb(boolean paramBoolean)
  {
    Object localObject;
    if (bk.a((Boolean)g.DP().Dz().get(348165, null), false))
    {
      localObject = g.DP().Dz().get(348166, null);
      if ((localObject == null) || (!(localObject instanceof Long))) {
        break label265;
      }
    }
    label265:
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      int i;
      if (System.currentTimeMillis() - l > 3600000L) {
        i = 1;
      }
      while ((i != 0) || (paramBoolean))
      {
        localObject = i.getEmojiStorageMgr().uBb.cwR();
        if (((ArrayList)localObject).size() <= 0) {
          break label240;
        }
        y.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
        ArrayList localArrayList = new ArrayList();
        int j = ((ArrayList)localObject).size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.d((String)((ArrayList)localObject).get(i)));
            y.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[] { ((ArrayList)localObject).get(i) });
            i += 1;
            continue;
            i = 0;
            break;
            i = 0;
            break;
          }
        }
        i.aHQ().jan.ba(localArrayList);
        i.aHQ().jan.aIn();
      }
      for (;;)
      {
        g.DP().Dz().o(348166, Long.valueOf(System.currentTimeMillis()));
        return;
        label240:
        y.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
        g.DP().Dz().o(348165, Boolean.valueOf(false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.a
 * JD-Core Version:    0.7.0.1
 */