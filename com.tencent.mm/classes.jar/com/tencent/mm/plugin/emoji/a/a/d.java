package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class d
  extends c
{
  private final String TAG = "MicroMsg.emoji.EmojiListMineData";
  
  public d(m paramm)
  {
    super(paramm);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108372);
    super.clear();
    AppMethodBeat.o(108372);
  }
  
  public final void dyn() {}
  
  public final void notifyDataSetChanged()
  {
    try
    {
      AppMethodBeat.i(108371);
      Object localObject1 = s.getEmojiStorageMgr().adjv.jdi();
      boolean bool = com.tencent.mm.plugin.emoji.g.c.dBJ();
      this.xHy = new ArrayList();
      Log.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        cjb localcjb = ((EmojiGroupInfo)((Iterator)localObject1).next()).kLX();
        f localf = new f(localcjb);
        if (localcjb != null)
        {
          if ((com.tencent.mm.plugin.emoji.g.c.i(localcjb)) && (bool))
          {
            bj localbj = new bj(localcjb.ProductID);
            this.xHA.put(localcjb.ProductID, localbj);
          }
          localf.setStatus(9);
          this.xHy.add(localf);
        }
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