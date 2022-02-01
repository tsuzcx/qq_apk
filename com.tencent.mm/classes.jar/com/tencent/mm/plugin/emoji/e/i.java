package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.p;
import java.util.HashMap;

public final class i
{
  public int fwK;
  public boolean owh;
  public long owi;
  public int owj;
  public com.tencent.mm.storage.emotion.o owk;
  public HashMap<String, com.tencent.mm.storage.emotion.o> owl;
  
  public i()
  {
    AppMethodBeat.i(108522);
    this.owh = true;
    this.owi = 863913600000L;
    this.owj = 19;
    this.fwK = 79;
    this.owl = new HashMap();
    AppMethodBeat.o(108522);
  }
  
  private void a(com.tencent.mm.storage.emotion.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(108525);
    if (paramo == null)
    {
      ad.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
      AppMethodBeat.o(108525);
      return;
    }
    if ((this.owk == null) || (this.owk.field_prodcutID.equalsIgnoreCase(paramo.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.owk.field_continuCount = 0;
        this.owl.put(this.owk.field_prodcutID, this.owk);
        k.getEmojiStorageMgr().Fzf.a(this.owk);
      }
      this.owk = paramo;
      if (!paramBoolean) {
        break;
      }
      this.owk.field_modifyTime = 0L;
      this.owk.field_showTipsTime = System.currentTimeMillis();
      this.owk.field_totalCount = 0;
      this.owk.field_continuCount = 0;
      this.owl.put(this.owk.field_prodcutID, this.owk);
      k.getEmojiStorageMgr().Fzf.a(this.owk);
      AppMethodBeat.o(108525);
      return;
    }
    if (i != 0) {}
    for (this.owk.field_continuCount += 1;; this.owk.field_continuCount = 1)
    {
      this.owk.field_totalCount += 1;
      this.owk.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean TP(String paramString)
  {
    AppMethodBeat.i(108524);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(108524);
      return false;
    }
    if ((!this.owh) && (!u.aqQ()))
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.owh), Boolean.valueOf(u.aqQ()) });
      AppMethodBeat.o(108524);
      return false;
    }
    Object localObject;
    if ((this.owl != null) && (this.owl.containsKey(paramString))) {
      localObject = (com.tencent.mm.storage.emotion.o)this.owl.get(paramString);
    }
    while (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.o)localObject).field_showTipsTime < this.owi)
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      bUP();
      AppMethodBeat.o(108524);
      return false;
      localObject = new com.tencent.mm.storage.emotion.o();
      ((com.tencent.mm.storage.emotion.o)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.o)localObject).field_setFlagTime > 86400000L)) {
      if ((this.owk != null) && (paramString.equalsIgnoreCase(this.owk.field_prodcutID)) && (this.owk.field_continuCount >= this.owj - 1) && (this.owk.field_continuCount <= this.owj + 5 - 1)) {
        g.afA().gcy.a(new com.tencent.mm.plugin.emoji.f.o(paramString, com.tencent.mm.plugin.emoji.f.o.oyX), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.owk != null) && (paramString.equalsIgnoreCase(this.owk.field_prodcutID)) && (this.owk.field_continuCount >= this.owj)) {
      if (((this.owk.field_flag & com.tencent.mm.plugin.emoji.f.o.oyY) == com.tencent.mm.plugin.emoji.f.o.oyY) && ((this.owk.field_flag & com.tencent.mm.plugin.emoji.f.o.oyZ) != com.tencent.mm.plugin.emoji.f.o.oyZ))
      {
        ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.owk.field_continuCount) });
        a((com.tencent.mm.storage.emotion.o)localObject, true);
        h.vKh.f(12953, new Object[] { Integer.valueOf(0), this.owk.field_prodcutID });
        AppMethodBeat.o(108524);
        return true;
        if ((((com.tencent.mm.storage.emotion.o)localObject).field_totalCount >= this.fwK - 1) && (((com.tencent.mm.storage.emotion.o)localObject).field_totalCount <= this.fwK + 5 - 1))
        {
          g.afA().gcy.a(new com.tencent.mm.plugin.emoji.f.o(paramString, com.tencent.mm.plugin.emoji.f.o.oyX), 0);
          continue;
          if (this.owk == null)
          {
            i = 0;
            if (this.owk != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.owk.field_totalCount)
          {
            ad.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.owk.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.owk.field_continuCount), Integer.valueOf(this.owk.field_flag) });
        a((com.tencent.mm.storage.emotion.o)localObject, false);
        AppMethodBeat.o(108524);
        return false;
      }
    }
    if ((localObject != null) && (((com.tencent.mm.storage.emotion.o)localObject).field_totalCount >= this.fwK))
    {
      if (((((com.tencent.mm.storage.emotion.o)localObject).field_flag & com.tencent.mm.plugin.emoji.f.o.oyY) == com.tencent.mm.plugin.emoji.f.o.oyY) && ((((com.tencent.mm.storage.emotion.o)localObject).field_flag & com.tencent.mm.plugin.emoji.f.o.oyZ) != com.tencent.mm.plugin.emoji.f.o.oyZ))
      {
        localBoolean = Boolean.TRUE;
        if (this.owk == null)
        {
          i = 0;
          ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((com.tencent.mm.storage.emotion.o)localObject, true);
          localObject = h.vKh;
          if (this.owk != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.owk.field_prodcutID)
        {
          ((h)localObject).f(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(108524);
          return true;
          i = this.owk.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.owk == null)
      {
        i = 0;
        if (this.owk != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.owk.field_flag)
      {
        ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((com.tencent.mm.storage.emotion.o)localObject, false);
        AppMethodBeat.o(108524);
        return false;
        i = this.owk.field_totalCount;
        break;
      }
    }
    a((com.tencent.mm.storage.emotion.o)localObject, false);
    AppMethodBeat.o(108524);
    return false;
  }
  
  public final void bUP()
  {
    AppMethodBeat.i(108523);
    if (this.owk != null)
    {
      this.owk.field_continuCount = 0;
      this.owl.put(this.owk.field_prodcutID, this.owk);
      k.getEmojiStorageMgr().Fzf.a(this.owk);
      this.owk = null;
    }
    AppMethodBeat.o(108523);
  }
  
  public final void cO(String paramString, int paramInt)
  {
    AppMethodBeat.i(108526);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(108526);
      return;
    }
    if ((this.owl != null) && (this.owl.containsKey(paramString)))
    {
      ((com.tencent.mm.storage.emotion.o)this.owl.get(paramString)).field_flag = paramInt;
      ((com.tencent.mm.storage.emotion.o)this.owl.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(108526);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(108526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */