package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d
  extends c
{
  private com.tencent.mm.plugin.emoji.sync.d ljD;
  private m ljO;
  private EmojiInfo ljP;
  private String mKey;
  
  public d(String paramString)
  {
    AppMethodBeat.i(53210);
    if (bo.isNullOrNil(paramString)) {
      ab.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
    }
    this.mKey = paramString;
    this.ljP = i.getEmojiStorageMgr().yNn.asP(this.mKey);
    AppMethodBeat.o(53210);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.sync.d paramd)
  {
    this.ljD = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(53212);
    if ((paramObject != null) && ((paramObject instanceof d)))
    {
      paramObject = (d)paramObject;
      if ((!bo.isNullOrNil(this.mKey)) && (!bo.isNullOrNil(paramObject.mKey)) && (this.mKey.equals(paramObject.mKey)))
      {
        AppMethodBeat.o(53212);
        return true;
      }
    }
    AppMethodBeat.o(53212);
    return false;
  }
  
  public final String getKey()
  {
    return this.mKey;
  }
  
  public final void run()
  {
    AppMethodBeat.i(53211);
    if (this.ljD != null) {
      this.ljD.KX(this.mKey);
    }
    while (this.ljP == null)
    {
      this.ljD.m(this.mKey, 1, false);
      AppMethodBeat.o(53211);
      return;
      ab.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
    }
    this.ljO = new f(this.ljP);
    g.RK().eHt.a(this.ljO, 0);
    AppMethodBeat.o(53211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.d
 * JD-Core Version:    0.7.0.1
 */