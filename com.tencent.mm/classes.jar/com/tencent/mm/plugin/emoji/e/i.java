package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.p;
import java.util.HashMap;

public final class i
{
  public int fTH;
  public boolean pDr;
  public long pDs;
  public int pDt;
  public p pDu;
  public HashMap<String, p> pDv;
  
  public i()
  {
    AppMethodBeat.i(108522);
    this.pDr = true;
    this.pDs = 863913600000L;
    this.pDt = 19;
    this.fTH = 79;
    this.pDv = new HashMap();
    AppMethodBeat.o(108522);
  }
  
  private void a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(108525);
    if (paramp == null)
    {
      ad.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
      AppMethodBeat.o(108525);
      return;
    }
    if ((this.pDu == null) || (this.pDu.field_prodcutID.equalsIgnoreCase(paramp.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.pDu.field_continuCount = 0;
        this.pDv.put(this.pDu.field_prodcutID, this.pDu);
        k.getEmojiStorageMgr().ILu.a(this.pDu);
      }
      this.pDu = paramp;
      if (!paramBoolean) {
        break;
      }
      this.pDu.field_modifyTime = 0L;
      this.pDu.field_showTipsTime = System.currentTimeMillis();
      this.pDu.field_totalCount = 0;
      this.pDu.field_continuCount = 0;
      this.pDv.put(this.pDu.field_prodcutID, this.pDu);
      k.getEmojiStorageMgr().ILu.a(this.pDu);
      AppMethodBeat.o(108525);
      return;
    }
    if (i != 0) {}
    for (this.pDu.field_continuCount += 1;; this.pDu.field_continuCount = 1)
    {
      this.pDu.field_totalCount += 1;
      this.pDu.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean abH(String paramString)
  {
    AppMethodBeat.i(108524);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(108524);
      return false;
    }
    if ((!this.pDr) && (!u.aAw()))
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.pDr), Boolean.valueOf(u.aAw()) });
      AppMethodBeat.o(108524);
      return false;
    }
    Object localObject;
    if ((this.pDv != null) && (this.pDv.containsKey(paramString))) {
      localObject = (p)this.pDv.get(paramString);
    }
    while (System.currentTimeMillis() - ((p)localObject).field_showTipsTime < this.pDs)
    {
      ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      cgG();
      AppMethodBeat.o(108524);
      return false;
      localObject = new p();
      ((p)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((p)localObject).field_setFlagTime > 86400000L)) {
      if ((this.pDu != null) && (paramString.equalsIgnoreCase(this.pDu.field_prodcutID)) && (this.pDu.field_continuCount >= this.pDt - 1) && (this.pDu.field_continuCount <= this.pDt + 5 - 1)) {
        com.tencent.mm.kernel.g.ajB().gAO.a(new o(paramString, o.pGh), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.pDu != null) && (paramString.equalsIgnoreCase(this.pDu.field_prodcutID)) && (this.pDu.field_continuCount >= this.pDt)) {
      if (((this.pDu.field_flag & o.pGi) == o.pGi) && ((this.pDu.field_flag & o.pGj) != o.pGj))
      {
        ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.pDu.field_continuCount) });
        a((p)localObject, true);
        com.tencent.mm.plugin.report.service.g.yhR.f(12953, new Object[] { Integer.valueOf(0), this.pDu.field_prodcutID });
        AppMethodBeat.o(108524);
        return true;
        if ((((p)localObject).field_totalCount >= this.fTH - 1) && (((p)localObject).field_totalCount <= this.fTH + 5 - 1))
        {
          com.tencent.mm.kernel.g.ajB().gAO.a(new o(paramString, o.pGh), 0);
          continue;
          if (this.pDu == null)
          {
            i = 0;
            if (this.pDu != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.pDu.field_totalCount)
          {
            ad.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.pDu.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.pDu.field_continuCount), Integer.valueOf(this.pDu.field_flag) });
        a((p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
      }
    }
    if ((localObject != null) && (((p)localObject).field_totalCount >= this.fTH))
    {
      if (((((p)localObject).field_flag & o.pGi) == o.pGi) && ((((p)localObject).field_flag & o.pGj) != o.pGj))
      {
        localBoolean = Boolean.TRUE;
        if (this.pDu == null)
        {
          i = 0;
          ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((p)localObject, true);
          localObject = com.tencent.mm.plugin.report.service.g.yhR;
          if (this.pDu != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.pDu.field_prodcutID)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject).f(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(108524);
          return true;
          i = this.pDu.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.pDu == null)
      {
        i = 0;
        if (this.pDu != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.pDu.field_flag)
      {
        ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
        i = this.pDu.field_totalCount;
        break;
      }
    }
    a((p)localObject, false);
    AppMethodBeat.o(108524);
    return false;
  }
  
  public final void cW(String paramString, int paramInt)
  {
    AppMethodBeat.i(108526);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(108526);
      return;
    }
    if ((this.pDv != null) && (this.pDv.containsKey(paramString)))
    {
      ((p)this.pDv.get(paramString)).field_flag = paramInt;
      ((p)this.pDv.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(108526);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(108526);
  }
  
  public final void cgG()
  {
    AppMethodBeat.i(108523);
    if (this.pDu != null)
    {
      this.pDu.field_continuCount = 0;
      this.pDv.put(this.pDu.field_prodcutID, this.pDu);
      k.getEmojiStorageMgr().ILu.a(this.pDu);
      this.pDu = null;
    }
    AppMethodBeat.o(108523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */