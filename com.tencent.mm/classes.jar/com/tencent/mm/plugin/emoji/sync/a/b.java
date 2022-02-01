package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public final class b
  extends d
{
  private String xOk;
  private e xPF;
  
  public b(String paramString)
  {
    AppMethodBeat.i(108778);
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.xOk = paramString;
    AppMethodBeat.o(108778);
  }
  
  public final void a(e parame)
  {
    this.xPF = parame;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108780);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!Util.isNullOrNil(this.xOk)) && (!Util.isNullOrNil(paramObject.getKey())) && (this.xOk.equals(paramObject.getKey())))
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
    if (this.xOk == null) {
      return "";
    }
    return this.xOk;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108779);
    if (this.xPF != null) {
      this.xPF.aoN(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = s.getEmojiStorageMgr().adjv.ec(EmojiGroupInfo.aklD, false);
      localEmojiGroupInfo.field_flag = 0;
      s.getEmojiStorageMgr().adjv.replace(localEmojiGroupInfo);
      if (this.xPF != null) {
        this.xPF.r(getKey(), 2, true);
      }
      AppMethodBeat.o(108779);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */