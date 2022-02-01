package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class c
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String pbW;
  private d pdl;
  
  public c(String paramString)
  {
    AppMethodBeat.i(108778);
    if (bs.isNullOrNil(paramString)) {
      ac.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.pbW = paramString;
    AppMethodBeat.o(108778);
  }
  
  public final void a(d paramd)
  {
    this.pdl = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108780);
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((!bs.isNullOrNil(this.pbW)) && (!bs.isNullOrNil(paramObject.getKey())) && (this.pbW.equals(paramObject.getKey())))
      {
        AppMethodBeat.o(108780);
        return true;
      }
    }
    AppMethodBeat.o(108780);
    return false;
  }
  
  public final String getKey()
  {
    if (this.pbW == null) {
      return "";
    }
    return this.pbW;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108779);
    if (this.pdl != null) {
      this.pdl.Yq(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().GYa.cE(EmojiGroupInfo.Jsp, false);
      localEmojiGroupInfo.field_flag = 0;
      k.getEmojiStorageMgr().GYa.replace(localEmojiGroupInfo);
      if (this.pdl != null) {
        this.pdl.l(getKey(), 2, true);
      }
      AppMethodBeat.o(108779);
      return;
      ac.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */