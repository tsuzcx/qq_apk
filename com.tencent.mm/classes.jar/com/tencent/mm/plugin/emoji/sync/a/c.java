package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class c
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String mKey;
  private d pGW;
  private n pGY;
  private EmojiInfo pGZ;
  
  public c(String paramString)
  {
    AppMethodBeat.i(108781);
    if (bt.isNullOrNil(paramString)) {
      ad.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
    }
    this.mKey = paramString;
    this.pGZ = k.getEmojiStorageMgr().ILn.aUK(this.mKey);
    AppMethodBeat.o(108781);
  }
  
  public final void a(d paramd)
  {
    this.pGW = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108783);
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((!bt.isNullOrNil(this.mKey)) && (!bt.isNullOrNil(paramObject.mKey)) && (this.mKey.equals(paramObject.mKey)))
      {
        AppMethodBeat.o(108783);
        return true;
      }
    }
    AppMethodBeat.o(108783);
    return false;
  }
  
  public final String getKey()
  {
    return this.mKey;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108782);
    if (this.pGW != null) {
      this.pGW.abW(this.mKey);
    }
    while (this.pGZ == null)
    {
      this.pGW.l(this.mKey, 1, false);
      AppMethodBeat.o(108782);
      return;
      ad.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
    }
    this.pGY = new com.tencent.mm.plugin.emoji.f.f(this.pGZ);
    g.ajB().gAO.a(this.pGY, 0);
    AppMethodBeat.o(108782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */