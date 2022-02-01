package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import junit.framework.Assert;

public final class j
{
  public static int a(String paramString, final long paramLong, bi.a parama)
  {
    AppMethodBeat.i(123960);
    ad.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123957);
        Cursor localCursor = ((com.tencent.mm.am.p)g.ab(com.tencent.mm.am.p.class)).apP().bX(this.fHA, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.gMc == null) || (!this.gMc.Vt())))
          {
            bl localbl = new bl();
            localbl.convertFrom(localCursor);
            bi.v(localbl);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((com.tencent.mm.am.p)g.ab(com.tencent.mm.am.p.class)).apP().bW(this.fHA, paramLong);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123956);
            if (j.1.this.gMc != null) {
              j.1.this.gMc.Vu();
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
  
  public static void rI(String paramString)
  {
    AppMethodBeat.i(123959);
    if (!bt.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((k)g.ab(k.class)).apM().aHY(paramString);
      if ((localObject != null) && (!bt.isNullOrNil(((au)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(123959);
      return;
    }
    ((af)localObject).setType(((au)localObject).field_type | 0x800);
    w.z((af)localObject);
    if ((((k)g.ab(k.class)).apR().aIn(paramString) == null) && (((af)localObject).eKB()))
    {
      if (!f.wI(paramString)) {
        break label254;
      }
      if (((k)g.ab(k.class)).apR().aIn("officialaccounts") == null)
      {
        localObject = new am("officialaccounts");
        ((am)localObject).eLf();
        ((k)g.ab(k.class)).apR().e((am)localObject);
      }
      localObject = new am(paramString);
      ((am)localObject).kS(System.currentTimeMillis());
      ((am)localObject).nN("officialaccounts");
      ((k)g.ab(k.class)).apR().e((am)localObject);
    }
    for (;;)
    {
      ad.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((k)g.ab(k.class)).apR().aIt(paramString);
      AppMethodBeat.o(123959);
      return;
      label254:
      if (f.wK(paramString))
      {
        localObject = f.ei(paramString);
        if (((k)g.ab(k.class)).apR().aIn(((c)localObject).field_enterpriseFather) == null)
        {
          localam = new am(((c)localObject).field_enterpriseFather);
          localam.eLf();
          ((k)g.ab(k.class)).apR().e(localam);
        }
        am localam = new am(paramString);
        localam.kS(System.currentTimeMillis());
        localam.nN(((c)localObject).Jm());
        ((k)g.ab(k.class)).apR().e(localam);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.j
 * JD-Core Version:    0.7.0.1
 */