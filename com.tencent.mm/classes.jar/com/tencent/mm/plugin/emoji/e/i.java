package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.q;
import java.util.HashMap;

public final class i
{
  public int cSs;
  public int raA;
  public com.tencent.mm.storage.emotion.p raB;
  public HashMap<String, com.tencent.mm.storage.emotion.p> raC;
  public boolean ray;
  public long raz;
  
  public i()
  {
    AppMethodBeat.i(108522);
    this.ray = true;
    this.raz = 863913600000L;
    this.raA = 19;
    this.cSs = 79;
    this.raC = new HashMap();
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
    if ((this.raB == null) || (this.raB.field_prodcutID.equalsIgnoreCase(paramp.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.raB.field_continuCount = 0;
        this.raC.put(this.raB.field_prodcutID, this.raB);
        k.getEmojiStorageMgr().OpU.a(this.raB);
      }
      this.raB = paramp;
      if (!paramBoolean) {
        break;
      }
      this.raB.field_modifyTime = 0L;
      this.raB.field_showTipsTime = System.currentTimeMillis();
      this.raB.field_totalCount = 0;
      this.raB.field_continuCount = 0;
      this.raC.put(this.raB.field_prodcutID, this.raB);
      k.getEmojiStorageMgr().OpU.a(this.raB);
      AppMethodBeat.o(108525);
      return;
    }
    if (i != 0) {}
    for (this.raB.field_continuCount += 1;; this.raB.field_continuCount = 1)
    {
      this.raB.field_totalCount += 1;
      this.raB.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean amF(String paramString)
  {
    AppMethodBeat.i(108524);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(108524);
      return false;
    }
    if ((!this.ray) && (!z.aUj()))
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.ray), Boolean.valueOf(z.aUj()) });
      AppMethodBeat.o(108524);
      return false;
    }
    Object localObject;
    if ((this.raC != null) && (this.raC.containsKey(paramString))) {
      localObject = (com.tencent.mm.storage.emotion.p)this.raC.get(paramString);
    }
    while (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.p)localObject).field_showTipsTime < this.raz)
    {
      Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      cFU();
      AppMethodBeat.o(108524);
      return false;
      localObject = new com.tencent.mm.storage.emotion.p();
      ((com.tencent.mm.storage.emotion.p)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((com.tencent.mm.storage.emotion.p)localObject).field_setFlagTime > 86400000L)) {
      if ((this.raB != null) && (paramString.equalsIgnoreCase(this.raB.field_prodcutID)) && (this.raB.field_continuCount >= this.raA - 1) && (this.raB.field_continuCount <= this.raA + 5 - 1)) {
        g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.p(paramString, com.tencent.mm.plugin.emoji.f.p.rdf), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.raB != null) && (paramString.equalsIgnoreCase(this.raB.field_prodcutID)) && (this.raB.field_continuCount >= this.raA)) {
      if (((this.raB.field_flag & com.tencent.mm.plugin.emoji.f.p.rdg) == com.tencent.mm.plugin.emoji.f.p.rdg) && ((this.raB.field_flag & com.tencent.mm.plugin.emoji.f.p.rdh) != com.tencent.mm.plugin.emoji.f.p.rdh))
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.raB.field_continuCount) });
        a((com.tencent.mm.storage.emotion.p)localObject, true);
        h.CyF.a(12953, new Object[] { Integer.valueOf(0), this.raB.field_prodcutID });
        AppMethodBeat.o(108524);
        return true;
        if ((((com.tencent.mm.storage.emotion.p)localObject).field_totalCount >= this.cSs - 1) && (((com.tencent.mm.storage.emotion.p)localObject).field_totalCount <= this.cSs + 5 - 1))
        {
          g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.p(paramString, com.tencent.mm.plugin.emoji.f.p.rdf), 0);
          continue;
          if (this.raB == null)
          {
            i = 0;
            if (this.raB != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.raB.field_totalCount)
          {
            Log.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.raB.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.raB.field_continuCount), Integer.valueOf(this.raB.field_flag) });
        a((com.tencent.mm.storage.emotion.p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
      }
    }
    if ((localObject != null) && (((com.tencent.mm.storage.emotion.p)localObject).field_totalCount >= this.cSs))
    {
      if (((((com.tencent.mm.storage.emotion.p)localObject).field_flag & com.tencent.mm.plugin.emoji.f.p.rdg) == com.tencent.mm.plugin.emoji.f.p.rdg) && ((((com.tencent.mm.storage.emotion.p)localObject).field_flag & com.tencent.mm.plugin.emoji.f.p.rdh) != com.tencent.mm.plugin.emoji.f.p.rdh))
      {
        localBoolean = Boolean.TRUE;
        if (this.raB == null)
        {
          i = 0;
          Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((com.tencent.mm.storage.emotion.p)localObject, true);
          localObject = h.CyF;
          if (this.raB != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.raB.field_prodcutID)
        {
          ((h)localObject).a(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(108524);
          return true;
          i = this.raB.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.raB == null)
      {
        i = 0;
        if (this.raB != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.raB.field_flag)
      {
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((com.tencent.mm.storage.emotion.p)localObject, false);
        AppMethodBeat.o(108524);
        return false;
        i = this.raB.field_totalCount;
        break;
      }
    }
    a((com.tencent.mm.storage.emotion.p)localObject, false);
    AppMethodBeat.o(108524);
    return false;
  }
  
  public final void cFU()
  {
    AppMethodBeat.i(108523);
    if (this.raB != null)
    {
      this.raB.field_continuCount = 0;
      this.raC.put(this.raB.field_prodcutID, this.raB);
      k.getEmojiStorageMgr().OpU.a(this.raB);
      this.raB = null;
    }
    AppMethodBeat.o(108523);
  }
  
  public final void dg(String paramString, int paramInt)
  {
    AppMethodBeat.i(108526);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(108526);
      return;
    }
    if ((this.raC != null) && (this.raC.containsKey(paramString)))
    {
      ((com.tencent.mm.storage.emotion.p)this.raC.get(paramString)).field_flag = paramInt;
      ((com.tencent.mm.storage.emotion.p)this.raC.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(108526);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(108526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */