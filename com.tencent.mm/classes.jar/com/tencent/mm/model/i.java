package com.tencent.mm.model;

import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import junit.framework.Assert;

public final class i
{
  public static int a(String paramString, long paramLong, bd.a parama)
  {
    y.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    g.DS().O(new i.1(paramString, paramLong, parama));
    return 0;
  }
  
  public static void gz(String paramString)
  {
    if (!bk.bl(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((j)g.r(j.class)).Fw().abl(paramString);
      if ((localObject != null) && (!bk.bl(((ao)localObject).field_username))) {
        break;
      }
      return;
    }
    ((ad)localObject).setType(((ao)localObject).field_type | 0x800);
    s.u((ad)localObject);
    if ((((j)g.r(j.class)).FB().abv(paramString) == null) && (((ad)localObject).cua()))
    {
      if (!f.kZ(paramString)) {
        break label246;
      }
      if (((j)g.r(j.class)).FB().abv("officialaccounts") == null)
      {
        localObject = new ak("officialaccounts");
        ((ak)localObject).cuB();
        ((j)g.r(j.class)).FB().d((ak)localObject);
      }
      localObject = new ak(paramString);
      ((ak)localObject).ba(System.currentTimeMillis());
      ((ak)localObject).dS("officialaccounts");
      ((j)g.r(j.class)).FB().d((ak)localObject);
    }
    for (;;)
    {
      y.i("MicroMsg.BizConversationLogic", "setPlacedTop username = " + paramString);
      ((j)g.r(j.class)).FB().abB(paramString);
      return;
      label246:
      if ((f.lb(paramString)) && (!f.eW(paramString)))
      {
        localObject = f.kX(paramString);
        if (((j)g.r(j.class)).FB().abv(((d)localObject).field_enterpriseFather) == null)
        {
          localak = new ak(((d)localObject).field_enterpriseFather);
          localak.cuB();
          ((j)g.r(j.class)).FB().d(localak);
        }
        ak localak = new ak(paramString);
        localak.ba(System.currentTimeMillis());
        localak.dS(((d)localObject).LG());
        ((j)g.r(j.class)).FB().d(localak);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.i
 * JD-Core Version:    0.7.0.1
 */