package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  public d(e parame)
  {
    super(parame);
  }
  
  public final void bkJ() {}
  
  public final void clear()
  {
    AppMethodBeat.i(52796);
    super.clear();
    AppMethodBeat.o(52796);
  }
  
  public final void notifyDataSetChanged()
  {
    try
    {
      AppMethodBeat.i(52795);
      Object localObject1 = i.getEmojiStorageMgr().yNo.dzh();
      boolean bool = com.tencent.mm.plugin.emoji.h.a.bmI();
      this.mItemList = new ArrayList();
      ab.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        EmotionSummary localEmotionSummary = ((EmojiGroupInfo)((Iterator)localObject1).next()).dzm();
        f localf = new f(localEmotionSummary);
        if ((com.tencent.mm.plugin.emoji.h.a.g(localEmotionSummary)) && (bool))
        {
          ar localar = new ar(localEmotionSummary.ProductID);
          this.leW.put(localEmotionSummary.ProductID, localar);
        }
        localf.setStatus(9);
        this.mItemList.add(localf);
      }
      AppMethodBeat.o(52795);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.d
 * JD-Core Version:    0.7.0.1
 */