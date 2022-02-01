package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.q;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.r;
import junit.framework.Assert;

public final class j
{
  public static int a(String paramString, final long paramLong, bj.a parama)
  {
    AppMethodBeat.i(123960);
    ad.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123957);
        Cursor localCursor = ((q)com.tencent.mm.kernel.g.ab(q.class)).azt().cd(this.geH, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.hEQ == null) || (!this.hEQ.YK())))
          {
            bu localbu = new bu();
            localbu.convertFrom(localCursor);
            bj.x(localbu);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((q)com.tencent.mm.kernel.g.ab(q.class)).azt().cc(this.geH, paramLong);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123956);
            if (j.1.this.hEQ != null) {
              j.1.this.hEQ.YL();
            }
            AppMethodBeat.o(123956);
          }
        });
        AppMethodBeat.o(123957);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(123958);
        String str = super.toString() + "|deleteMsgByTalker";
        AppMethodBeat.o(123958);
        return str;
      }
    });
    AppMethodBeat.o(123960);
    return 0;
  }
  
  public static void yC(String paramString)
  {
    AppMethodBeat.i(123959);
    if (!bt.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString);
      if ((localObject != null) && (!bt.isNullOrNil(((aw)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(123959);
      return;
    }
    ((am)localObject).setType(((aw)localObject).field_type | 0x800);
    w.z((am)localObject);
    if ((((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz(paramString) == null) && (((am)localObject).fqg()))
    {
      if (!com.tencent.mm.am.g.DN(paramString)) {
        break label254;
      }
      if (((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz("officialaccounts") == null)
      {
        localObject = new at("officialaccounts");
        ((at)localObject).fqK();
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().e((at)localObject);
      }
      localObject = new at(paramString);
      ((at)localObject).qu(System.currentTimeMillis());
      ((at)localObject).tD("officialaccounts");
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().e((at)localObject);
    }
    for (;;)
    {
      ad.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTF(paramString);
      AppMethodBeat.o(123959);
      return;
      label254:
      if (com.tencent.mm.am.g.DP(paramString))
      {
        localObject = com.tencent.mm.am.g.eS(paramString);
        if (((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz(((c)localObject).field_enterpriseFather) == null)
        {
          localat = new at(((c)localObject).field_enterpriseFather);
          localat.fqK();
          ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().e(localat);
        }
        at localat = new at(paramString);
        localat.qu(System.currentTimeMillis());
        localat.tD(((c)localObject).Kv());
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().e(localat);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.j
 * JD-Core Version:    0.7.0.1
 */