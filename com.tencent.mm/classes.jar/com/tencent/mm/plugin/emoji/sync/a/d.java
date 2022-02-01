package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d
  extends c
{
  private String mKey;
  private com.tencent.mm.plugin.emoji.sync.d pdl;
  private n pdw;
  private EmojiInfo pdx;
  
  public d(String paramString)
  {
    AppMethodBeat.i(108781);
    if (bs.isNullOrNil(paramString)) {
      ac.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
    }
    this.mKey = paramString;
    this.pdx = k.getEmojiStorageMgr().GXZ.aOT(this.mKey);
    AppMethodBeat.o(108781);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.sync.d paramd)
  {
    this.pdl = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108783);
    if ((paramObject != null) && ((paramObject instanceof d)))
    {
      paramObject = (d)paramObject;
      if ((!bs.isNullOrNil(this.mKey)) && (!bs.isNullOrNil(paramObject.mKey)) && (this.mKey.equals(paramObject.mKey)))
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
    if (this.pdl != null) {
      this.pdl.Yq(this.mKey);
    }
    while (this.pdx == null)
    {
      this.pdl.l(this.mKey, 1, false);
      AppMethodBeat.o(108782);
      return;
      ac.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
    }
    this.pdw = new com.tencent.mm.plugin.emoji.f.f(this.pdx);
    g.agQ().ghe.a(this.pdw, 0);
    AppMethodBeat.o(108782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.d
 * JD-Core Version:    0.7.0.1
 */