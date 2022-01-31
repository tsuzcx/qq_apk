package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.ak.f;
import com.tencent.mm.h.a.cv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.j;
import java.io.IOException;

public final class b
  extends d
{
  private String iZD;
  private boolean iZZ = false;
  private e jaU;
  private h jbe;
  
  public b(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.iZD = paramString;
  }
  
  public b(String paramString, byte paramByte)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.iZD = paramString;
    this.iZZ = true;
  }
  
  public final void a(e parame)
  {
    this.jaU = parame;
  }
  
  public final void cancel()
  {
    if ((this.jbe != null) && (!bk.bl(this.jbe.eoQ)))
    {
      f.Nd().lM(this.jbe.eoQ);
      y.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.jbe.eoQ });
      return;
    }
    y.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
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
    Object localObject;
    if (this.jaU != null)
    {
      this.jaU.AV(getKey());
      localObject = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBc.bE(getKey(), true);
      if ((this.iZZ) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break label117;
      }
      localObject = new cv();
      ((cv)localObject).bIV.bIW = getKey();
      ((cv)localObject).bIV.bHz = 2;
      ((cv)localObject).bIV.success = true;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
    for (;;)
    {
      return;
      y.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
      break;
      label117:
      this.jbe = new h(this.iZD);
      g.DO().dJT.a(this.jbe, 0);
      localObject = new afe();
      com.tencent.mm.storage.emotion.i locali = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBf.acI(this.iZD);
      if ((locali != null) && (locali.field_content != null)) {}
      try
      {
        ((afe)localObject).aH(locali.field_content);
        if (((afe)localObject).tcV != null) {
          continue;
        }
        localObject = new com.tencent.mm.plugin.emoji.f.m(this.iZD, 15);
        g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[] { bk.j(localIOException) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */