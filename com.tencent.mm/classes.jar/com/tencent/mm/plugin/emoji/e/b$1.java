package com.tencent.mm.plugin.emoji.e;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.b;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(52822);
    Object localObject1 = com.tencent.mm.emoji.a.d.Oz().ci(true);
    ((List)localObject1).addAll(at.dxt().yNn.dzE());
    Object localObject2 = ((List)localObject1).iterator();
    long l1;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (EmojiInfo)((Iterator)localObject2).next();
        l1 = System.currentTimeMillis();
        localObject3 = f.bkQ().l((EmojiInfo)localObject3);
        long l2 = System.currentTimeMillis() - l1;
        try
        {
          if (r.bX((byte[])localObject3)) {
            new h((byte[])localObject3);
          }
          for (;;)
          {
            label100:
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "run: %s, %s", new Object[] { Long.valueOf(l2), Long.valueOf(System.currentTimeMillis() - l1 - l2) });
            break;
            new com.tencent.mm.plugin.gif.d((byte[])localObject3);
          }
        }
        catch (Exception localException)
        {
          break label100;
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmojiInfo)((Iterator)localObject1).next();
      l1 = System.currentTimeMillis();
      e.avI(((EmojiInfo)localObject2).dQB());
      b localb = MMGIFJNIFactory.Companion.getDecoder((EmojiInfo)localObject2);
      localb.Om();
      localb.destroy();
      ab.i("MicroMsg.emoji.EmojiCommandMgr", "run: time is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      e.um("/sdcard/temp/emoji/");
      l1 = System.currentTimeMillis();
      BitmapFactory.decodeFile("/sdcard/temp/emoji/" + ((EmojiInfo)localObject2).field_md5 + ".jpg");
      ab.i("MicroMsg.emoji.EmojiCommandMgr", "run: file time is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    }
    AppMethodBeat.o(52822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.1
 * JD-Core Version:    0.7.0.1
 */