package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;

public final class c
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String liu;
  private d ljD;
  
  public c(String paramString)
  {
    AppMethodBeat.i(53207);
    if (bo.isNullOrNil(paramString)) {
      ab.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.liu = paramString;
    AppMethodBeat.o(53207);
  }
  
  public final void a(d paramd)
  {
    this.ljD = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(53209);
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((!bo.isNullOrNil(this.liu)) && (!bo.isNullOrNil(paramObject.getKey())) && (this.liu.equals(paramObject.getKey())))
      {
        AppMethodBeat.o(53209);
        return true;
      }
    }
    AppMethodBeat.o(53209);
    return false;
  }
  
  public final String getKey()
  {
    if (this.liu == null) {
      return "";
    }
    return this.liu;
  }
  
  public final void run()
  {
    AppMethodBeat.i(53208);
    if (this.ljD != null) {
      this.ljD.KX(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = i.getEmojiStorageMgr().yNo.cg(EmojiGroupInfo.yPd, false);
      localEmojiGroupInfo.field_flag = 0;
      i.getEmojiStorageMgr().yNo.replace(localEmojiGroupInfo);
      if (this.ljD != null) {
        this.ljD.m(getKey(), 2, true);
      }
      AppMethodBeat.o(53208);
      return;
      ab.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */