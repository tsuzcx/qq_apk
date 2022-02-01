package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;

public final class c
  extends d
{
  private String mKey;
  private e xPF;
  private p xPH;
  private EmojiInfo xPI;
  
  public c(String paramString)
  {
    AppMethodBeat.i(108781);
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
    }
    this.mKey = paramString;
    this.xPI = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(this.mKey);
    AppMethodBeat.o(108781);
  }
  
  public final void a(e parame)
  {
    this.xPF = parame;
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
    if (this.xPF != null) {
      this.xPF.aoN(this.mKey);
    }
    while (this.xPI == null)
    {
      this.xPF.r(this.mKey, 1, false);
      AppMethodBeat.o(108782);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
    }
    this.xPH = new g(this.xPI);
    h.baD().mCm.a(this.xPH, 0);
    AppMethodBeat.o(108782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */