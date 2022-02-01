package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.aw;
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
  
  public final void bUx() {}
  
  public final void clear()
  {
    AppMethodBeat.i(108372);
    super.clear();
    AppMethodBeat.o(108372);
  }
  
  public final void notifyDataSetChanged()
  {
    try
    {
      AppMethodBeat.i(108371);
      Object localObject1 = k.getEmojiStorageMgr().FyZ.eNt();
      boolean bool = a.bWs();
      this.mItemList = new ArrayList();
      ad.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        EmotionSummary localEmotionSummary = ((EmojiGroupInfo)((Iterator)localObject1).next()).fZL();
        f localf = new f(localEmotionSummary);
        if ((a.g(localEmotionSummary)) && (bool))
        {
          au localau = new au(localEmotionSummary.ProductID);
          this.ouH.put(localEmotionSummary.ProductID, localau);
        }
        localf.setStatus(9);
        this.mItemList.add(localf);
      }
      AppMethodBeat.o(108371);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.d
 * JD-Core Version:    0.7.0.1
 */