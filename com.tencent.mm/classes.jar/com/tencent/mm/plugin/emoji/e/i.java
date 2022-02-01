package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.p;
import java.util.HashMap;

public final class i
{
  public int fAr;
  public boolean oZH;
  public long oZI;
  public int oZJ;
  public p oZK;
  public HashMap<String, p> oZL;
  
  public i()
  {
    AppMethodBeat.i(108522);
    this.oZH = true;
    this.oZI = 863913600000L;
    this.oZJ = 19;
    this.fAr = 79;
    this.oZL = new HashMap();
    AppMethodBeat.o(108522);
  }
  
  private void a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(108525);
    if (paramp == null)
    {
      ac.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
      AppMethodBeat.o(108525);
      return;
    }
    if ((this.oZK == null) || (this.oZK.field_prodcutID.equalsIgnoreCase(paramp.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.oZK.field_continuCount = 0;
        this.oZL.put(this.oZK.field_prodcutID, this.oZK);
        k.getEmojiStorageMgr().GYg.a(this.oZK);
      }
      this.oZK = paramp;
      if (!paramBoolean) {
        break;
      }
      this.oZK.field_modifyTime = 0L;
      this.oZK.field_showTipsTime = System.currentTimeMillis();
      this.oZK.field_totalCount = 0;
      this.oZK.field_continuCount = 0;
      this.oZL.put(this.oZK.field_prodcutID, this.oZK);
      k.getEmojiStorageMgr().GYg.a(this.oZK);
      AppMethodBeat.o(108525);
      return;
    }
    if (i != 0) {}
    for (this.oZK.field_continuCount += 1;; this.oZK.field_continuCount = 1)
    {
      this.oZK.field_totalCount += 1;
      this.oZK.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean Yb(String paramString)
  {
    AppMethodBeat.i(108524);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(108524);
      return false;
    }
    if ((!this.oZH) && (!u.axG()))
    {
      ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.oZH), Boolean.valueOf(u.axG()) });
      AppMethodBeat.o(108524);
      return false;
    }
    Object localObject;
    if ((this.oZL != null) && (this.oZL.containsKey(paramString))) {
      localObject = (p)this.oZL.get(paramString);
    }
    while (System.currentTimeMillis() - ((p)localObject).field_showTipsTime < this.oZI)
    {
      ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      ccc();
      AppMethodBeat.o(108524);
      return false;
      localObject = new p();
      ((p)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((p)localObject).field_setFlagTime > 86400000L)) {
      if ((this.oZK != null) && (paramString.equalsIgnoreCase(this.oZK.field_prodcutID)) && (this.oZK.field_continuCount >= this.oZJ - 1) && (this.oZK.field_continuCount <= this.oZJ + 5 - 1)) {
        g.agQ().ghe.a(new o(paramString, o.pcx), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.oZK != null) && (paramString.equalsIgnoreCase(this.oZK.field_prodcutID)) && (this.oZK.field_continuCount >= this.oZJ)) {
      if (((this.oZK.field_flag & o.pcy) == o.pcy) && ((this.oZK.field_flag & o.pcz) != o.pcz))
      {
        ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.oZK.field_continuCount) });
        a((p)localObject, true);
        h.wUl.f(12953, new Object[] { Integer.valueOf(0), this.oZK.field_prodcutID });
        AppMethodBeat.o(108524);
        return true;
        if ((((p)localObject).field_totalCount >= this.fAr - 1) && (((p)localObject).field_totalCount <= this.fAr + 5 - 1))
        {
          g.agQ().ghe.a(new o(paramString, o.pcx), 0);
          continue;
          if (this.oZK == null)
          {
            i = 0;
            if (this.oZK != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.oZK.field_totalCount)
          {
            ac.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.oZK.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.oZK.field_continuCount), Integer.valueOf(this.oZK.field_flag) });
        a((p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
      }
    }
    if ((localObject != null) && (((p)localObject).field_totalCount >= this.fAr))
    {
      if (((((p)localObject).field_flag & o.pcy) == o.pcy) && ((((p)localObject).field_flag & o.pcz) != o.pcz))
      {
        localBoolean = Boolean.TRUE;
        if (this.oZK == null)
        {
          i = 0;
          ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((p)localObject, true);
          localObject = h.wUl;
          if (this.oZK != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.oZK.field_prodcutID)
        {
          ((h)localObject).f(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(108524);
          return true;
          i = this.oZK.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.oZK == null)
      {
        i = 0;
        if (this.oZK != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.oZK.field_flag)
      {
        ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
        i = this.oZK.field_totalCount;
        break;
      }
    }
    a((p)localObject, false);
    AppMethodBeat.o(108524);
    return false;
  }
  
  public final void cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(108526);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(108526);
      return;
    }
    if ((this.oZL != null) && (this.oZL.containsKey(paramString)))
    {
      ((p)this.oZL.get(paramString)).field_flag = paramInt;
      ((p)this.oZL.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(108526);
      return;
    }
    ac.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(108526);
  }
  
  public final void ccc()
  {
    AppMethodBeat.i(108523);
    if (this.oZK != null)
    {
      this.oZK.field_continuCount = 0;
      this.oZL.put(this.oZK.field_prodcutID, this.oZK);
      k.getEmojiStorageMgr().GYg.a(this.oZK);
      this.oZK = null;
    }
    AppMethodBeat.o(108523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */