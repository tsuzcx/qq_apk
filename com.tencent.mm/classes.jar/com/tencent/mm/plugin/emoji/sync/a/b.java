package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class b
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String pMk;
  private d pNA;
  
  public b(String paramString)
  {
    AppMethodBeat.i(108778);
    if (bu.isNullOrNil(paramString)) {
      ae.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.pMk = paramString;
    AppMethodBeat.o(108778);
  }
  
  public final void a(d paramd)
  {
    this.pNA = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108780);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!bu.isNullOrNil(this.pMk)) && (!bu.isNullOrNil(paramObject.getKey())) && (this.pMk.equals(paramObject.getKey())))
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
    if (this.pMk == null) {
      return "";
    }
    return this.pMk;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108779);
    if (this.pNA != null) {
      this.pNA.acN(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().JfV.cN(EmojiGroupInfo.OzR, false);
      localEmojiGroupInfo.field_flag = 0;
      k.getEmojiStorageMgr().JfV.replace(localEmojiGroupInfo);
      if (this.pNA != null) {
        this.pNA.l(getKey(), 2, true);
      }
      AppMethodBeat.o(108779);
      return;
      ae.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */