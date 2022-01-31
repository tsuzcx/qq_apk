package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    Object localObject = i.getEmojiStorageMgr().uBb.cwT();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        if (d.a(this.iWF)) {
          this.iWF.c(localEmojiInfo, false);
        }
      }
    }
    if (d.a(this.iWF)) {
      g.DP().Dz().c(ac.a.uoi, Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d.1
 * JD-Core Version:    0.7.0.1
 */