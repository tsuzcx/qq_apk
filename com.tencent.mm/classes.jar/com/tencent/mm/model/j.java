package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.r;
import junit.framework.Assert;

public final class j
{
  public static int a(String paramString, final long paramLong, bl.a parama)
  {
    AppMethodBeat.i(123960);
    ae.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123957);
        Cursor localCursor = ((q)com.tencent.mm.kernel.g.ab(q.class)).azJ().ce(this.ggQ, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.hHI == null) || (!this.hHI.YT())))
          {
            bv localbv = new bv();
            localbv.convertFrom(localCursor);
            bl.x(localbv);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((q)com.tencent.mm.kernel.g.ab(q.class)).azJ().cd(this.ggQ, paramLong);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123956);
            if (j.1.this.hHI != null) {
              j.1.this.hHI.YU();
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
  
  public static void zm(String paramString)
  {
    AppMethodBeat.i(123959);
    if (!bu.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
      if ((localObject != null) && (!bu.isNullOrNil(((aw)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(123959);
      return;
    }
    ((an)localObject).setType(((aw)localObject).field_type | 0x800);
    x.G((an)localObject);
    if ((((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa(paramString) == null) && (((an)localObject).fug()))
    {
      if (!com.tencent.mm.al.g.Ep(paramString)) {
        break label254;
      }
      if (((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa("officialaccounts") == null)
      {
        localObject = new au("officialaccounts");
        ((au)localObject).fuK();
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().e((au)localObject);
      }
      localObject = new au(paramString);
      ((au)localObject).qH(System.currentTimeMillis());
      ((au)localObject).tY("officialaccounts");
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().e((au)localObject);
    }
    for (;;)
    {
      ae.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVg(paramString);
      AppMethodBeat.o(123959);
      return;
      label254:
      if (com.tencent.mm.al.g.Er(paramString))
      {
        localObject = com.tencent.mm.al.g.eX(paramString);
        if (((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa(((c)localObject).field_enterpriseFather) == null)
        {
          localau = new au(((c)localObject).field_enterpriseFather);
          localau.fuK();
          ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().e(localau);
        }
        au localau = new au(paramString);
        localau.qH(System.currentTimeMillis());
        localau.tY(((c)localObject).KD());
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().e(localau);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.j
 * JD-Core Version:    0.7.0.1
 */