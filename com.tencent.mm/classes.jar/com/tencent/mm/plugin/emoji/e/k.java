package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.n;
import java.util.HashMap;

public final class k
{
  public int ejZ;
  public boolean lgB;
  public long lgC;
  public int lgD;
  public m lgE;
  public HashMap<String, m> lgF;
  
  public k()
  {
    AppMethodBeat.i(52977);
    this.lgB = true;
    this.lgC = 863913600000L;
    this.lgD = 19;
    this.ejZ = 79;
    this.lgF = new HashMap();
    AppMethodBeat.o(52977);
  }
  
  private void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(52980);
    if (paramm == null)
    {
      ab.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
      AppMethodBeat.o(52980);
      return;
    }
    if ((this.lgE == null) || (this.lgE.field_prodcutID.equalsIgnoreCase(paramm.field_prodcutID))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.lgE.field_continuCount = 0;
        this.lgF.put(this.lgE.field_prodcutID, this.lgE);
        i.getEmojiStorageMgr().yNu.a(this.lgE);
      }
      this.lgE = paramm;
      if (!paramBoolean) {
        break;
      }
      this.lgE.field_modifyTime = 0L;
      this.lgE.field_showTipsTime = System.currentTimeMillis();
      this.lgE.field_totalCount = 0;
      this.lgE.field_continuCount = 0;
      this.lgF.put(this.lgE.field_prodcutID, this.lgE);
      i.getEmojiStorageMgr().yNu.a(this.lgE);
      AppMethodBeat.o(52980);
      return;
    }
    if (i != 0) {}
    for (this.lgE.field_continuCount += 1;; this.lgE.field_continuCount = 1)
    {
      this.lgE.field_totalCount += 1;
      this.lgE.field_modifyTime = System.currentTimeMillis();
      break;
    }
  }
  
  public final boolean KI(String paramString)
  {
    AppMethodBeat.i(52979);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
      AppMethodBeat.o(52979);
      return false;
    }
    if ((!this.lgB) && (!r.Zw()))
    {
      ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[] { Boolean.valueOf(this.lgB), Boolean.valueOf(r.Zw()) });
      AppMethodBeat.o(52979);
      return false;
    }
    Object localObject;
    if ((this.lgF != null) && (this.lgF.containsKey(paramString))) {
      localObject = (m)this.lgF.get(paramString);
    }
    while (System.currentTimeMillis() - ((m)localObject).field_showTipsTime < this.lgC)
    {
      ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
      blj();
      AppMethodBeat.o(52979);
      return false;
      localObject = new m();
      ((m)localObject).field_prodcutID = paramString;
    }
    if ((localObject != null) && (System.currentTimeMillis() - ((m)localObject).field_setFlagTime > 86400000L)) {
      if ((this.lgE != null) && (paramString.equalsIgnoreCase(this.lgE.field_prodcutID)) && (this.lgE.field_continuCount >= this.lgD - 1) && (this.lgE.field_continuCount <= this.lgD + 5 - 1)) {
        g.RK().eHt.a(new o(paramString, o.liT), 0);
      }
    }
    int i;
    label469:
    int j;
    while ((this.lgE != null) && (paramString.equalsIgnoreCase(this.lgE.field_prodcutID)) && (this.lgE.field_continuCount >= this.lgD)) {
      if (((this.lgE.field_flag & o.liU) == o.liU) && ((this.lgE.field_flag & o.liV) != o.liV))
      {
        ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(this.lgE.field_continuCount) });
        a((m)localObject, true);
        h.qsU.e(12953, new Object[] { Integer.valueOf(0), this.lgE.field_prodcutID });
        AppMethodBeat.o(52979);
        return true;
        if ((((m)localObject).field_totalCount >= this.ejZ - 1) && (((m)localObject).field_totalCount <= this.ejZ + 5 - 1))
        {
          g.RK().eHt.a(new o(paramString, o.liT), 0);
          continue;
          if (this.lgE == null)
          {
            i = 0;
            if (this.lgE != null) {
              break label517;
            }
          }
          label517:
          for (j = 0;; j = this.lgE.field_totalCount)
          {
            ab.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = this.lgE.field_continuCount;
            break label469;
          }
        }
      }
      else
      {
        ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", new Object[] { Boolean.FALSE, paramString, Integer.valueOf(this.lgE.field_continuCount), Integer.valueOf(this.lgE.field_flag) });
        a((m)localObject, false);
        AppMethodBeat.o(52979);
        return false;
      }
    }
    if ((localObject != null) && (((m)localObject).field_totalCount >= this.ejZ))
    {
      if (((((m)localObject).field_flag & o.liU) == o.liU) && ((((m)localObject).field_flag & o.liV) != o.liV))
      {
        localBoolean = Boolean.TRUE;
        if (this.lgE == null)
        {
          i = 0;
          ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", new Object[] { localBoolean, paramString, Integer.valueOf(i) });
          a((m)localObject, true);
          localObject = h.qsU;
          if (this.lgE != null) {
            break label740;
          }
        }
        label740:
        for (paramString = "";; paramString = this.lgE.field_prodcutID)
        {
          ((h)localObject).e(12953, new Object[] { Integer.valueOf(0), paramString });
          AppMethodBeat.o(52979);
          return true;
          i = this.lgE.field_totalCount;
          break;
        }
      }
      Boolean localBoolean = Boolean.FALSE;
      if (this.lgE == null)
      {
        i = 0;
        if (this.lgE != null) {
          break label833;
        }
      }
      label833:
      for (j = 0;; j = this.lgE.field_flag)
      {
        ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", new Object[] { localBoolean, paramString, Integer.valueOf(i), Integer.valueOf(j) });
        a((m)localObject, false);
        AppMethodBeat.o(52979);
        return false;
        i = this.lgE.field_totalCount;
        break;
      }
    }
    a((m)localObject, false);
    AppMethodBeat.o(52979);
    return false;
  }
  
  public final void blj()
  {
    AppMethodBeat.i(52978);
    if (this.lgE != null)
    {
      this.lgE.field_continuCount = 0;
      this.lgF.put(this.lgE.field_prodcutID, this.lgE);
      i.getEmojiStorageMgr().yNu.a(this.lgE);
      this.lgE = null;
    }
    AppMethodBeat.o(52978);
  }
  
  public final void cc(String paramString, int paramInt)
  {
    AppMethodBeat.i(52981);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
      AppMethodBeat.o(52981);
      return;
    }
    if ((this.lgF != null) && (this.lgF.containsKey(paramString)))
    {
      ((m)this.lgF.get(paramString)).field_flag = paramInt;
      ((m)this.lgF.get(paramString)).field_setFlagTime = System.currentTimeMillis();
      AppMethodBeat.o(52981);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[] { paramString });
    AppMethodBeat.o(52981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.k
 * JD-Core Version:    0.7.0.1
 */