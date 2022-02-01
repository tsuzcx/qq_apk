package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;

public final class c
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String mKey;
  private d rdU;
  private q rdW;
  private EmojiInfo rdX;
  
  public c(String paramString)
  {
    AppMethodBeat.i(108781);
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
    }
    this.mKey = paramString;
    this.rdX = k.getEmojiStorageMgr().OpN.blk(this.mKey);
    AppMethodBeat.o(108781);
  }
  
  public final void a(d paramd)
  {
    this.rdU = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108783);
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((!Util.isNullOrNil(this.mKey)) && (!Util.isNullOrNil(paramObject.mKey)) && (this.mKey.equals(paramObject.mKey)))
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
    if (this.rdU != null) {
      this.rdU.amU(this.mKey);
    }
    while (this.rdX == null)
    {
      this.rdU.m(this.mKey, 1, false);
      AppMethodBeat.o(108782);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
    }
    this.rdW = new com.tencent.mm.plugin.emoji.f.g(this.rdX);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.rdW, 0);
    AppMethodBeat.o(108782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */