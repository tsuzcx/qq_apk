package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class d
  extends c
{
  private final String TAG = "MicroMsg.emoji.EmojiListMineData";
  
  public d(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    super(paramf);
  }
  
  public final void aGX() {}
  
  public final void clear()
  {
    super.clear();
  }
  
  public final void notifyDataSetChanged()
  {
    try
    {
      Object localObject1 = i.getEmojiStorageMgr().uBc.cww();
      boolean bool = com.tencent.mm.plugin.emoji.h.a.aJh();
      this.mItemList = new ArrayList();
      y.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        vn localvn = ((EmojiGroupInfo)((Iterator)localObject1).next()).cwf();
        f localf = new f(localvn);
        if ((com.tencent.mm.plugin.emoji.h.a.d(localvn)) && (bool))
        {
          ar localar = new ar(localvn.syc);
          this.iVQ.put(localvn.syc, localar);
        }
        localf.setStatus(9);
        this.mItemList.add(localf);
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.d
 * JD-Core Version:    0.7.0.1
 */