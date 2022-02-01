package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class c
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String oyw;
  private d ozL;
  
  public c(String paramString)
  {
    AppMethodBeat.i(108778);
    if (bt.isNullOrNil(paramString)) {
      ad.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.oyw = paramString;
    AppMethodBeat.o(108778);
  }
  
  public final void a(d paramd)
  {
    this.ozL = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108780);
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((!bt.isNullOrNil(this.oyw)) && (!bt.isNullOrNil(paramObject.getKey())) && (this.oyw.equals(paramObject.getKey())))
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
    if (this.oyw == null) {
      return "";
    }
    return this.oyw;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108779);
    if (this.ozL != null) {
      this.ozL.Ue(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().FyZ.cy(EmojiGroupInfo.LBN, false);
      localEmojiGroupInfo.field_flag = 0;
      k.getEmojiStorageMgr().FyZ.replace(localEmojiGroupInfo);
      if (this.ozL != null) {
        this.ozL.l(getKey(), 2, true);
      }
      AppMethodBeat.o(108779);
      return;
      ad.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */