package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d
  extends com.tencent.mm.plugin.emoji.sync.d
{
  private e jaU;
  private m jbf;
  private EmojiInfo jbg;
  private String mKey;
  
  public d(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
    }
    this.mKey = paramString;
    this.jbg = i.getEmojiStorageMgr().uBb.acC(this.mKey);
  }
  
  public final void a(e parame)
  {
    this.jaU = parame;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof d)))
    {
      paramObject = (d)paramObject;
      if ((!bk.bl(this.mKey)) && (!bk.bl(paramObject.mKey)) && (this.mKey.equals(paramObject.mKey))) {
        return true;
      }
    }
    return false;
  }
  
  public final String getKey()
  {
    return this.mKey;
  }
  
  public final void run()
  {
    if (this.jaU != null) {
      this.jaU.AV(this.mKey);
    }
    while (this.jbg == null)
    {
      this.jaU.m(this.mKey, 1, false);
      return;
      y.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
    }
    this.jbf = new com.tencent.mm.plugin.emoji.f.g(this.jbg);
    com.tencent.mm.kernel.g.DO().dJT.a(this.jbf, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.d
 * JD-Core Version:    0.7.0.1
 */