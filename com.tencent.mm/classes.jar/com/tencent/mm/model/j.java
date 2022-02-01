package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import junit.framework.Assert;

public final class j
{
  public static int a(String paramString, final long paramLong, bi.a parama)
  {
    AppMethodBeat.i(123960);
    ac.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123957);
        Cursor localCursor = ((com.tencent.mm.al.p)g.ab(com.tencent.mm.al.p.class)).awE().bZ(this.fLg, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.hmC == null) || (!this.hmC.Wr())))
          {
            bo localbo = new bo();
            localbo.convertFrom(localCursor);
            bi.v(localbo);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((com.tencent.mm.al.p)g.ab(com.tencent.mm.al.p.class)).awE().bY(this.fLg, paramLong);
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123956);
            if (j.1.this.hmC != null) {
              j.1.this.hmC.Ws();
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
  
  public static void vL(String paramString)
  {
    AppMethodBeat.i(123959);
    if (!bs.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((k)g.ab(k.class)).awB().aNt(paramString);
      if ((localObject != null) && (!bs.isNullOrNil(((av)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(123959);
      return;
    }
    ((ai)localObject).setType(((av)localObject).field_type | 0x800);
    w.z((ai)localObject);
    if ((((k)g.ab(k.class)).awG().aNI(paramString) == null) && (((ai)localObject).fad()))
    {
      if (!f.AO(paramString)) {
        break label254;
      }
      if (((k)g.ab(k.class)).awG().aNI("officialaccounts") == null)
      {
        localObject = new com.tencent.mm.storage.ap("officialaccounts");
        ((com.tencent.mm.storage.ap)localObject).faH();
        ((k)g.ab(k.class)).awG().e((com.tencent.mm.storage.ap)localObject);
      }
      localObject = new com.tencent.mm.storage.ap(paramString);
      ((com.tencent.mm.storage.ap)localObject).ou(System.currentTimeMillis());
      ((com.tencent.mm.storage.ap)localObject).qT("officialaccounts");
      ((k)g.ab(k.class)).awG().e((com.tencent.mm.storage.ap)localObject);
    }
    for (;;)
    {
      ac.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((k)g.ab(k.class)).awG().aNO(paramString);
      AppMethodBeat.o(123959);
      return;
      label254:
      if (f.AQ(paramString))
      {
        localObject = f.dX(paramString);
        if (((k)g.ab(k.class)).awG().aNI(((c)localObject).field_enterpriseFather) == null)
        {
          localap = new com.tencent.mm.storage.ap(((c)localObject).field_enterpriseFather);
          localap.faH();
          ((k)g.ab(k.class)).awG().e(localap);
        }
        com.tencent.mm.storage.ap localap = new com.tencent.mm.storage.ap(paramString);
        localap.ou(System.currentTimeMillis());
        localap.qT(((c)localObject).IV());
        ((k)g.ab(k.class)).awG().e(localap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.j
 * JD-Core Version:    0.7.0.1
 */