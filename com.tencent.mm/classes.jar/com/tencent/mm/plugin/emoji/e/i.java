package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.n;
import java.util.HashMap;

public final class i
{
  public int dsr = 79;
  public boolean iXo = true;
  public long iXp = 863913600000L;
  public int iXq = 19;
  public m iXr;
  public HashMap<String, m> iXs = new HashMap();
  
  public final void a(m paramm, boolean paramBoolean)
  {
    if (paramm == null)
    {
      y.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
      return;
    }
    if ((this.iXr == null) || (this.iXr.field_prodcutID.equalsIgnoreCase(paramm.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.iXr.field_continuCount = 0;
        this.iXs.put(this.iXr.field_prodcutID, this.iXr);
        com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.a(this.iXr);
      }
      this.iXr = paramm;
      if (!paramBoolean) {
        break;
      }
      this.iXr.field_modifyTime = 0L;
      this.iXr.field_showTipsTime = System.currentTimeMillis();
      this.iXr.field_totalCount = 0;
      this.iXr.field_continuCount = 0;
      this.iXs.put(this.iXr.field_prodcutID, this.iXr);
      com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.a(this.iXr);
      return;
    }
    if (i != 0) {}
    for (this.iXr.field_continuCount += 1;; this.iXr.field_continuCount = 1)
    {
      this.iXr.field_totalCount += 1;
      this.iXr.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final void aHy()
  {
    if (this.iXr != null)
    {
      this.iXr.field_continuCount = 0;
      this.iXs.put(this.iXr.field_prodcutID, this.iXr);
      com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBi.a(this.iXr);
      this.iXr = null;
    }
  }
  
  public final void bw(String paramString, int paramInt)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      return;
    }
    if ((this.iXs != null) && (this.iXs.containsKey(paramString)))
    {
      ((m)this.iXs.get(paramString)).field_flag = paramInt;
      ((m)this.iXs.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      return;
    }
    y.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */