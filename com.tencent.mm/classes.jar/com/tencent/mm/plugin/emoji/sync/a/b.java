package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class b
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String pFG;
  private d pGW;
  
  public b(String paramString)
  {
    AppMethodBeat.i(108778);
    if (bt.isNullOrNil(paramString)) {
      ad.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.pFG = paramString;
    AppMethodBeat.o(108778);
  }
  
  public final void a(d paramd)
  {
    this.pGW = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108780);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!bt.isNullOrNil(this.pFG)) && (!bt.isNullOrNil(paramObject.getKey())) && (this.pFG.equals(paramObject.getKey())))
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
    if (this.pFG == null) {
      return "";
    }
    return this.pFG;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108779);
    if (this.pGW != null) {
      this.pGW.abW(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().ILo.cJ(EmojiGroupInfo.OeK, false);
      localEmojiGroupInfo.field_flag = 0;
      k.getEmojiStorageMgr().ILo.replace(localEmojiGroupInfo);
      if (this.pGW != null) {
        this.pGW.l(getKey(), 2, true);
      }
      AppMethodBeat.o(108779);
      return;
      ad.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */