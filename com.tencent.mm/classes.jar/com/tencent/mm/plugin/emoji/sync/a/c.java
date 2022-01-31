package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;

public final class c
  extends d
{
  private String iZD;
  private e jaU;
  
  public c(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
    }
    this.iZD = paramString;
  }
  
  public final void a(e parame)
  {
    this.jaU = parame;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof c)))
    {
      paramObject = (c)paramObject;
      if ((!bk.bl(this.iZD)) && (!bk.bl(paramObject.getKey())) && (this.iZD.equals(paramObject.getKey()))) {
        return true;
      }
    }
    return false;
  }
  
  public final String getKey()
  {
    if (this.iZD == null) {
      return "";
    }
    return this.iZD;
  }
  
  public final void run()
  {
    if (this.jaU != null) {
      this.jaU.AV(getKey());
    }
    for (;;)
    {
      EmojiGroupInfo localEmojiGroupInfo = i.getEmojiStorageMgr().uBc.bE(EmojiGroupInfo.uCQ, false);
      localEmojiGroupInfo.field_flag = 0;
      i.getEmojiStorageMgr().uBc.a(localEmojiGroupInfo);
      if (this.jaU != null) {
        this.jaU.m(getKey(), 2, true);
      }
      return;
      y.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.c
 * JD-Core Version:    0.7.0.1
 */