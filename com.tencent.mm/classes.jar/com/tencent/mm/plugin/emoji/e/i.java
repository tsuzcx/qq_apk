package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.q;
import java.util.HashMap;

public final class i
{
  public int cUX;
  public int uDA;
  public com.tencent.mm.storage.emotion.p uDB;
  public HashMap<String, com.tencent.mm.storage.emotion.p> uDC;
  public boolean uDy;
  public long uDz;
  
  public i()
  {
    AppMethodBeat.i(108522);
    this.uDy = true;
    this.uDz = 863913600000L;
    this.uDA = 19;
    this.cUX = 79;
    this.uDC = new HashMap();
    AppMethodBeat.o(108522);
  }
  
  private void a(com.tencent.mm.storage.emotion.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(108525);
    if (paramp == null)
    {
      Log.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
      AppMethodBeat.o(108525);
      return;
    }
    if ((this.uDB == null) || (this.uDB.field_prodcutID.equalsIgnoreCase(paramp.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.uDB.field_continuCount = 0;
        this.uDC.put(this.uDB.field_prodcutID, this.uDB);
        com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFO.a(this.uDB);
      }
      this.uDB = paramp;
      if (!paramBoolean) {
        break;
      }
      this.uDB.field_modifyTime = 0L;
      this.uDB.field_showTipsTime = System.currentTimeMillis();
      this.uDB.field_totalCount = 0;
      this.uDB.field_continuCount = 0;
      this.uDC.put(this.uDB.field_prodcutID, this.uDB);
      com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFO.a(this.uDB);
      AppMethodBeat.o(108525);
      return;
    }
    if (i != 0) {}
    for (this.uDB.field_continuCount += 1;; this.uDB.field_continuCount = 1)
    {
      this.uDB.field_totalCount += 1;
      this.uDB.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean auz(String paramString)
  {
    AppMethodBeat.i(108524);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(108524);
      return false;
    }
    if ((!this.uDy) && (!z.bdl()))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.uDy), Boolean.valueOf(z.bdl()) });
      AppMethodBeat.o(108524);
      return false;
    }
    Object localObject;
    if ((this.uDC != null) && (this.uDC.containsKey(paramString))) {
      localObject = (com.tencent.mm.storage.emotion.p)this.uDC.get(paramString);
    }
    while (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.p)localObject).field_showTipsTime < this.uDz)
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      cUB();
      AppMethodBeat.o(108524);
      return false;
      localObject = new com.tencent.mm.storage.emotion.p();
      ((com.tencent.mm.storage.emotion.p)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.p)localObject).field_setFlagTime > 86400000L)) {
      if ((this.uDB != null) && (paramString.equalsIgnoreCase(this.uDB.field_prodcutID)) && (this.uDB.field_continuCount >= this.uDA - 1) && (this.uDB.field_continuCount <= this.uDA + 5 - 1)) {
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.emoji.f.p(paramString, com.tencent.mm.plugin.emoji.f.p.uGl), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.uDB != null) && (paramString.equalsIgnoreCase(this.uDB.field_prodcutID)) && (this.uDB.field_continuCount >= this.uDA)) {
      if (((this.uDB.field_flag & com.tencent.mm.plugin.emoji.f.p.uGm) == com.tencent.mm.plugin.emoji.f.p.uGm) && ((this.uDB.field_flag & com.tencent.mm.plugin.emoji.f.p.uGn) != com.tencent.mm.plugin.emoji.f.p.uGn))
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.uDB.field_continuCount) });
        a((com.tencent.mm.storage.emotion.p)localObject, true);
        com.tencent.mm.plugin.report.service.h.IzE.a(12953, new Object[] { Integer.valueOf(0), this.uDB.field_prodcutID });
        AppMethodBeat.o(108524);
        return true;
        if ((((com.tencent.mm.storage.emotion.p)localObject).field_totalCount >= this.cUX - 1) && (((com.tencent.mm.storage.emotion.p)localObject).field_totalCount <= this.cUX + 5 - 1))
        {
          com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.emoji.f.p(paramString, com.tencent.mm.plugin.emoji.f.p.uGl), 0);
          continue;
          if (this.uDB == null)
          {
            i = 0;
            if (this.uDB != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.uDB.field_totalCount)
          {
            Log.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.uDB.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.uDB.field_continuCount), Integer.valueOf(this.uDB.field_flag) });
        a((com.tencent.mm.storage.emotion.p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
      }
    }
    if ((localObject != null) && (((com.tencent.mm.storage.emotion.p)localObject).field_totalCount >= this.cUX))
    {
      if (((((com.tencent.mm.storage.emotion.p)localObject).field_flag & com.tencent.mm.plugin.emoji.f.p.uGm) == com.tencent.mm.plugin.emoji.f.p.uGm) && ((((com.tencent.mm.storage.emotion.p)localObject).field_flag & com.tencent.mm.plugin.emoji.f.p.uGn) != com.tencent.mm.plugin.emoji.f.p.uGn))
      {
        localBoolean = Boolean.TRUE;
        if (this.uDB == null)
        {
          i = 0;
          Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((com.tencent.mm.storage.emotion.p)localObject, true);
          localObject = com.tencent.mm.plugin.report.service.h.IzE;
          if (this.uDB != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.uDB.field_prodcutID)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject).a(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(108524);
          return true;
          i = this.uDB.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.uDB == null)
      {
        i = 0;
        if (this.uDB != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.uDB.field_flag)
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((com.tencent.mm.storage.emotion.p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
        i = this.uDB.field_totalCount;
        break;
      }
    }
    a((com.tencent.mm.storage.emotion.p)localObject, false);
    AppMethodBeat.o(108524);
    return false;
  }
  
  public final void cUB()
  {
    AppMethodBeat.i(108523);
    if (this.uDB != null)
    {
      this.uDB.field_continuCount = 0;
      this.uDC.put(this.uDB.field_prodcutID, this.uDB);
      com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFO.a(this.uDB);
      this.uDB = null;
    }
    AppMethodBeat.o(108523);
  }
  
  public final void dB(String paramString, int paramInt)
  {
    AppMethodBeat.i(108526);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(108526);
      return;
    }
    if ((this.uDC != null) && (this.uDC.containsKey(paramString)))
    {
      ((com.tencent.mm.storage.emotion.p)this.uDC.get(paramString)).field_flag = paramInt;
      ((com.tencent.mm.storage.emotion.p)this.uDC.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(108526);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(108526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */