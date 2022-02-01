package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class b
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String rcD;
  private d rdU;
  
  public b(String paramString)
  {
    AppMethodBeat.i(108778);
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.rcD = paramString;
    AppMethodBeat.o(108778);
  }
  
  public final void a(d paramd)
  {
    this.rdU = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108780);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!Util.isNullOrNil(this.rcD)) && (!Util.isNullOrNil(paramObject.getKey())) && (this.rcD.equals(paramObject.getKey())))
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
    if (this.rcD == null) {
      return "";
    }
    return this.rcD;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108779);
    if (this.rdU != null) {
      this.rdU.amU(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().OpO.di(EmojiGroupInfo.Uum, false);
      localEmojiGroupInfo.field_flag = 0;
      k.getEmojiStorageMgr().OpO.replace(localEmojiGroupInfo);
      if (this.rdU != null) {
        this.rdU.m(getKey(), 2, true);
      }
      AppMethodBeat.o(108779);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */