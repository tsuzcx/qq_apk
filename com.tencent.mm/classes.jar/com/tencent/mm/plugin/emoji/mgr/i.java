package com.tencent.mm.plugin.emoji.mgr;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.q;
import java.util.HashMap;

public final class i
{
  public int eQx;
  public boolean xLQ;
  public long xLR;
  public int xLS;
  public com.tencent.mm.storage.emotion.p xLT;
  public HashMap<String, com.tencent.mm.storage.emotion.p> xLU;
  
  public i()
  {
    AppMethodBeat.i(108522);
    this.xLQ = true;
    this.xLR = 863913600000L;
    this.xLS = 19;
    this.eQx = 79;
    this.xLU = new HashMap();
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
    if ((this.xLT == null) || (this.xLT.field_prodcutID.equalsIgnoreCase(paramp.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.xLT.field_continuCount = 0;
        this.xLU.put(this.xLT.field_prodcutID, this.xLT);
        com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjC.a(this.xLT);
      }
      this.xLT = paramp;
      if (!paramBoolean) {
        break;
      }
      this.xLT.field_modifyTime = 0L;
      this.xLT.field_showTipsTime = System.currentTimeMillis();
      this.xLT.field_totalCount = 0;
      this.xLT.field_continuCount = 0;
      this.xLU.put(this.xLT.field_prodcutID, this.xLT);
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjC.a(this.xLT);
      AppMethodBeat.o(108525);
      return;
    }
    if (i != 0) {}
    for (this.xLT.field_continuCount += 1;; this.xLT.field_continuCount = 1)
    {
      this.xLT.field_totalCount += 1;
      this.xLT.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean aoy(String paramString)
  {
    AppMethodBeat.i(108524);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(108524);
      return false;
    }
    if ((!this.xLQ) && (!z.bBd()))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.xLQ), Boolean.valueOf(z.bBd()) });
      AppMethodBeat.o(108524);
      return false;
    }
    Object localObject;
    if ((this.xLU != null) && (this.xLU.containsKey(paramString))) {
      localObject = (com.tencent.mm.storage.emotion.p)this.xLU.get(paramString);
    }
    while (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.p)localObject).field_showTipsTime < this.xLR)
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      dzI();
      AppMethodBeat.o(108524);
      return false;
      localObject = new com.tencent.mm.storage.emotion.p();
      ((com.tencent.mm.storage.emotion.p)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.p)localObject).field_setFlagTime > 86400000L)) {
      if ((this.xLT != null) && (paramString.equalsIgnoreCase(this.xLT.field_prodcutID)) && (this.xLT.field_continuCount >= this.xLS - 1) && (this.xLT.field_continuCount <= this.xLS + 5 - 1)) {
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.emoji.e.p(paramString, com.tencent.mm.plugin.emoji.e.p.xOP), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.xLT != null) && (paramString.equalsIgnoreCase(this.xLT.field_prodcutID)) && (this.xLT.field_continuCount >= this.xLS)) {
      if (((this.xLT.field_flag & com.tencent.mm.plugin.emoji.e.p.xOQ) == com.tencent.mm.plugin.emoji.e.p.xOQ) && ((this.xLT.field_flag & com.tencent.mm.plugin.emoji.e.p.xOR) != com.tencent.mm.plugin.emoji.e.p.xOR))
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.xLT.field_continuCount) });
        a((com.tencent.mm.storage.emotion.p)localObject, true);
        com.tencent.mm.plugin.report.service.h.OAn.b(12953, new Object[] { Integer.valueOf(0), this.xLT.field_prodcutID });
        AppMethodBeat.o(108524);
        return true;
        if ((((com.tencent.mm.storage.emotion.p)localObject).field_totalCount >= this.eQx - 1) && (((com.tencent.mm.storage.emotion.p)localObject).field_totalCount <= this.eQx + 5 - 1))
        {
          com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.emoji.e.p(paramString, com.tencent.mm.plugin.emoji.e.p.xOP), 0);
          continue;
          if (this.xLT == null)
          {
            i = 0;
            if (this.xLT != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.xLT.field_totalCount)
          {
            Log.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.xLT.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.xLT.field_continuCount), Integer.valueOf(this.xLT.field_flag) });
        a((com.tencent.mm.storage.emotion.p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
      }
    }
    if ((localObject != null) && (((com.tencent.mm.storage.emotion.p)localObject).field_totalCount >= this.eQx))
    {
      if (((((com.tencent.mm.storage.emotion.p)localObject).field_flag & com.tencent.mm.plugin.emoji.e.p.xOQ) == com.tencent.mm.plugin.emoji.e.p.xOQ) && ((((com.tencent.mm.storage.emotion.p)localObject).field_flag & com.tencent.mm.plugin.emoji.e.p.xOR) != com.tencent.mm.plugin.emoji.e.p.xOR))
      {
        localBoolean = Boolean.TRUE;
        if (this.xLT == null)
        {
          i = 0;
          Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((com.tencent.mm.storage.emotion.p)localObject, true);
          localObject = com.tencent.mm.plugin.report.service.h.OAn;
          if (this.xLT != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.xLT.field_prodcutID)
        {
          ((com.tencent.mm.plugin.report.service.h)localObject).b(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(108524);
          return true;
          i = this.xLT.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.xLT == null)
      {
        i = 0;
        if (this.xLT != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.xLT.field_flag)
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((com.tencent.mm.storage.emotion.p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
        i = this.xLT.field_totalCount;
        break;
      }
    }
    a((com.tencent.mm.storage.emotion.p)localObject, false);
    AppMethodBeat.o(108524);
    return false;
  }
  
  public final void dzI()
  {
    AppMethodBeat.i(108523);
    if (this.xLT != null)
    {
      this.xLT.field_continuCount = 0;
      this.xLU.put(this.xLT.field_prodcutID, this.xLT);
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjC.a(this.xLT);
      this.xLT = null;
    }
    AppMethodBeat.o(108523);
  }
  
  public final void ec(String paramString, int paramInt)
  {
    AppMethodBeat.i(108526);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(108526);
      return;
    }
    if ((this.xLU != null) && (this.xLU.containsKey(paramString)))
    {
      ((com.tencent.mm.storage.emotion.p)this.xLU.get(paramString)).field_flag = paramInt;
      ((com.tencent.mm.storage.emotion.p)this.xLU.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(108526);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(108526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.i
 * JD-Core Version:    0.7.0.1
 */