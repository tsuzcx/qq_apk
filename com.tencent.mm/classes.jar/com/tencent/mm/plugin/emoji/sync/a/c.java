package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class c
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private String mKey;
  private d pNA;
  private n pNC;
  private EmojiInfo pND;
  
  public c(String paramString)
  {
    AppMethodBeat.i(108781);
    if (bu.isNullOrNil(paramString)) {
      ae.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
    }
    this.mKey = paramString;
    this.pND = k.getEmojiStorageMgr().JfU.aWl(this.mKey);
    AppMethodBeat.o(108781);
  }
  
  public final void a(d paramd)
  {
    this.pNA = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108783);
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((!bu.isNullOrNil(this.mKey)) && (!bu.isNullOrNil(paramObject.mKey)) && (this.mKey.equals(paramObject.mKey)))
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
    if (this.pNA != null) {
      this.pNA.acN(this.mKey);
    }
    while (this.pND == null)
    {
      this.pNA.l(this.mKey, 1, false);
      AppMethodBeat.o(108782);
      return;
      ae.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
    }
    this.pNC = new com.tencent.mm.plugin.emoji.f.f(this.pND);
    g.ajQ().gDv.a(this.pNC, 0);
    AppMethodBeat.o(108782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */