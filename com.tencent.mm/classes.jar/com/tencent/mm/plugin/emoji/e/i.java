package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.p;
import java.util.HashMap;

public final class i
{
  public int fVN;
  public boolean pJV;
  public long pJW;
  public int pJX;
  public p pJY;
  public HashMap<String, p> pJZ;
  
  public i()
  {
    AppMethodBeat.i(108522);
    this.pJV = true;
    this.pJW = 863913600000L;
    this.pJX = 19;
    this.fVN = 79;
    this.pJZ = new HashMap();
    AppMethodBeat.o(108522);
  }
  
  private void a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(108525);
    if (paramp == null)
    {
      ae.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
      AppMethodBeat.o(108525);
      return;
    }
    if ((this.pJY == null) || (this.pJY.field_prodcutID.equalsIgnoreCase(paramp.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.pJY.field_continuCount = 0;
        this.pJZ.put(this.pJY.field_prodcutID, this.pJY);
        k.getEmojiStorageMgr().Jgb.a(this.pJY);
      }
      this.pJY = paramp;
      if (!paramBoolean) {
        break;
      }
      this.pJY.field_modifyTime = 0L;
      this.pJY.field_showTipsTime = System.currentTimeMillis();
      this.pJY.field_totalCount = 0;
      this.pJY.field_continuCount = 0;
      this.pJZ.put(this.pJY.field_prodcutID, this.pJY);
      k.getEmojiStorageMgr().Jgb.a(this.pJY);
      AppMethodBeat.o(108525);
      return;
    }
    if (i != 0) {}
    for (this.pJY.field_continuCount += 1;; this.pJY.field_continuCount = 1)
    {
      this.pJY.field_totalCount += 1;
      this.pJY.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean acy(String paramString)
  {
    AppMethodBeat.i(108524);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(108524);
      return false;
    }
    if ((!this.pJV) && (!v.aAM()))
    {
      ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.pJV), Boolean.valueOf(v.aAM()) });
      AppMethodBeat.o(108524);
      return false;
    }
    Object localObject;
    if ((this.pJZ != null) && (this.pJZ.containsKey(paramString))) {
      localObject = (p)this.pJZ.get(paramString);
    }
    while (System.currentTimeMillis() - ((p)localObject).field_showTipsTime < this.pJW)
    {
      ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      chW();
      AppMethodBeat.o(108524);
      return false;
      localObject = new p();
      ((p)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((p)localObject).field_setFlagTime > 86400000L)) {
      if ((this.pJY != null) && (paramString.equalsIgnoreCase(this.pJY.field_prodcutID)) && (this.pJY.field_continuCount >= this.pJX - 1) && (this.pJY.field_continuCount <= this.pJX + 5 - 1)) {
        com.tencent.mm.kernel.g.ajQ().gDv.a(new o(paramString, o.pML), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.pJY != null) && (paramString.equalsIgnoreCase(this.pJY.field_prodcutID)) && (this.pJY.field_continuCount >= this.pJX)) {
      if (((this.pJY.field_flag & o.pMM) == o.pMM) && ((this.pJY.field_flag & o.pMN) != o.pMN))
      {
        ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.pJY.field_continuCount) });
        a((p)localObject, true);
        com.tencent.mm.plugin.report.service.g.yxI.f(12953, new Object[] { Integer.valueOf(0), this.pJY.field_prodcutID });
        AppMethodBeat.o(108524);
        return true;
        if ((((p)localObject).field_totalCount >= this.fVN - 1) && (((p)localObject).field_totalCount <= this.fVN + 5 - 1))
        {
          com.tencent.mm.kernel.g.ajQ().gDv.a(new o(paramString, o.pML), 0);
          continue;
          if (this.pJY == null)
          {
            i = 0;
            if (this.pJY != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.pJY.field_totalCount)
          {
            ae.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.pJY.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.pJY.field_continuCount), Integer.valueOf(this.pJY.field_flag) });
        a((p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
      }
    }
    if ((localObject != null) && (((p)localObject).field_totalCount >= this.fVN))
    {
      if (((((p)localObject).field_flag & o.pMM) == o.pMM) && ((((p)localObject).field_flag & o.pMN) != o.pMN))
      {
        localBoolean = Boolean.TRUE;
        if (this.pJY == null)
        {
          i = 0;
          ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((p)localObject, true);
          localObject = com.tencent.mm.plugin.report.service.g.yxI;
          if (this.pJY != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.pJY.field_prodcutID)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject).f(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(108524);
          return true;
          i = this.pJY.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.pJY == null)
      {
        i = 0;
        if (this.pJY != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.pJY.field_flag)
      {
        ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
        i = this.pJY.field_totalCount;
        break;
      }
    }
    a((p)localObject, false);
    AppMethodBeat.o(108524);
    return false;
  }
  
  public final void chW()
  {
    AppMethodBeat.i(108523);
    if (this.pJY != null)
    {
      this.pJY.field_continuCount = 0;
      this.pJZ.put(this.pJY.field_prodcutID, this.pJY);
      k.getEmojiStorageMgr().Jgb.a(this.pJY);
      this.pJY = null;
    }
    AppMethodBeat.o(108523);
  }
  
  public final void da(String paramString, int paramInt)
  {
    AppMethodBeat.i(108526);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(108526);
      return;
    }
    if ((this.pJZ != null) && (this.pJZ.containsKey(paramString)))
    {
      ((p)this.pJZ.get(paramString)).field_flag = paramInt;
      ((p)this.pJZ.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(108526);
      return;
    }
    ae.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(108526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */