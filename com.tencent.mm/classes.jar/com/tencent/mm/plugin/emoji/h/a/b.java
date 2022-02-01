package com.tencent.mm.plugin.emoji.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public final class b
  extends d
{
  private String uFI;
  private e uGZ;
  
  public b(String paramString)
  {
    AppMethodBeat.i(108778);
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.uFI = paramString;
    AppMethodBeat.o(108778);
  }
  
  public final void a(e parame)
  {
    this.uGZ = parame;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108780);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!Util.isNullOrNil(this.uFI)) && (!Util.isNullOrNil(paramObject.getKey())) && (this.uFI.equals(paramObject.getKey())))
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
    if (this.uFI == null) {
      return "";
    }
    return this.uFI;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108779);
    if (this.uGZ != null) {
      this.uGZ.auO(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = p.getEmojiStorageMgr().VFI.dt(EmojiGroupInfo.YCu, false);
      localEmojiGroupInfo.field_flag = 0;
      p.getEmojiStorageMgr().VFI.replace(localEmojiGroupInfo);
      if (this.uGZ != null) {
        this.uGZ.q(getKey(), 2, true);
      }
      AppMethodBeat.o(108779);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.a.b
 * JD-Core Version:    0.7.0.1
 */