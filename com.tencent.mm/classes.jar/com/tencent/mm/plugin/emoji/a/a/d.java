package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class d
  extends c
{
  private final String TAG = "MicroMsg.emoji.EmojiListMineData";
  
  public d(l paraml)
  {
    super(paraml);
  }
  
  public final void cTS() {}
  
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
      Object localObject1 = p.getEmojiStorageMgr().VFI.hBh();
      boolean bool = a.cWg();
      this.mItemList = new ArrayList();
      Log.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        akh localakh = ((EmojiGroupInfo)((Iterator)localObject1).next()).hBn();
        f localf = new f(localakh);
        if ((a.g(localakh)) && (bool))
        {
          bh localbh = new bh(localakh.ProductID);
          this.uAW.put(localakh.ProductID, localbh);
        }
        localf.setStatus(9);
        this.mItemList.add(localf);
      }
      AppMethodBeat.o(108371);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.d
 * JD-Core Version:    0.7.0.1
 */