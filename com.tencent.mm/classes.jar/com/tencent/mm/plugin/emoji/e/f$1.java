package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;

final class f$1
  implements Runnable
{
  f$1(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(52864);
    if (!g.RG())
    {
      AppMethodBeat.o(52864);
      return;
    }
    Object localObject = i.getEmojiStorageMgr().yNn.dzE();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        if (f.a(this.lfN)) {
          this.lfN.c(localEmojiInfo, false);
        }
      }
    }
    if (f.a(this.lfN)) {
      g.RL().Ru().set(ac.a.yyb, Long.valueOf(System.currentTimeMillis()));
    }
    AppMethodBeat.o(52864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f.1
 * JD-Core Version:    0.7.0.1
 */