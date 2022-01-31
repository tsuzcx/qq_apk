package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import junit.framework.Assert;

public final class i
{
  public static int a(String paramString, final long paramLong, bf.a parama)
  {
    AppMethodBeat.i(11229);
    ab.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(11226);
        Cursor localCursor = ((com.tencent.mm.aj.o)g.E(com.tencent.mm.aj.o.class)).YD().be(this.euc, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.fkS == null) || (!this.fkS.JS())))
          {
            bi localbi = new bi();
            localbi.convertFrom(localCursor);
            bf.m(localbi);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((com.tencent.mm.aj.o)g.E(com.tencent.mm.aj.o.class)).YD().bd(this.euc, paramLong);
        al.d(new i.1.1(this));
        AppMethodBeat.o(11226);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(11227);
        String str = super.toString() + "|deleteMsgByTalker";
        AppMethodBeat.o(11227);
        return str;
      }
    });
    AppMethodBeat.o(11229);
    return 0;
  }
  
  public static void nh(String paramString)
  {
    AppMethodBeat.i(11228);
    if (!bo.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((j)g.E(j.class)).YA().arw(paramString);
      if ((localObject != null) && (!bo.isNullOrNil(((aq)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(11228);
      return;
    }
    ((ad)localObject).setType(((aq)localObject).field_type | 0x800);
    t.u((ad)localObject);
    if ((((j)g.E(j.class)).YF().arH(paramString) == null) && (((ad)localObject).dwz()))
    {
      if (!f.rU(paramString)) {
        break label257;
      }
      if (((j)g.E(j.class)).YF().arH("officialaccounts") == null)
      {
        localObject = new ak("officialaccounts");
        ((ak)localObject).dxc();
        ((j)g.E(j.class)).YF().d((ak)localObject);
      }
      localObject = new ak(paramString);
      ((ak)localObject).fK(System.currentTimeMillis());
      ((ak)localObject).jY("officialaccounts");
      ((j)g.E(j.class)).YF().d((ak)localObject);
    }
    for (;;)
    {
      ab.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((j)g.E(j.class)).YF().arN(paramString);
      AppMethodBeat.o(11228);
      return;
      label257:
      if ((f.rW(paramString)) && (!f.lg(paramString)))
      {
        localObject = f.rS(paramString);
        if (((j)g.E(j.class)).YF().arH(((d)localObject).field_enterpriseFather) == null)
        {
          localak = new ak(((d)localObject).field_enterpriseFather);
          localak.dxc();
          ((j)g.E(j.class)).YF().d(localak);
        }
        ak localak = new ak(paramString);
        localak.fK(System.currentTimeMillis());
        localak.jY(((d)localObject).aeo());
        ((j)g.E(j.class)).YF().d(localak);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.i
 * JD-Core Version:    0.7.0.1
 */