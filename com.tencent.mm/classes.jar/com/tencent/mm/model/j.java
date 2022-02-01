package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.q;
import com.tencent.mm.api.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.t;
import junit.framework.Assert;

public final class j
{
  public static void Pd(String paramString)
  {
    AppMethodBeat.i(123959);
    if (!Util.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((n)h.ae(n.class)).bbL().RG(paramString);
      if ((localObject != null) && (!Util.isNullOrNil(((ax)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(123959);
      return;
    }
    ((as)localObject).setType(((ax)localObject).field_type | 0x800);
    ab.M((as)localObject);
    if ((((n)h.ae(n.class)).bbR().bwx(paramString) == null) && (((as)localObject).hxX()))
    {
      if (!g.Uz(paramString)) {
        break label254;
      }
      if (((n)h.ae(n.class)).bbR().bwx("officialaccounts") == null)
      {
        localObject = new az("officialaccounts");
        ((az)localObject).hyE();
        ((n)h.ae(n.class)).bbR().e((az)localObject);
      }
      localObject = new az(paramString);
      ((az)localObject).EB(System.currentTimeMillis());
      ((az)localObject).Jc("officialaccounts");
      ((n)h.ae(n.class)).bbR().e((az)localObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((n)h.ae(n.class)).bbR().bwD(paramString);
      AppMethodBeat.o(123959);
      return;
      label254:
      if (g.UB(paramString))
      {
        localObject = g.gu(paramString);
        if (((n)h.ae(n.class)).bbR().bwx(((c)localObject).field_enterpriseFather) == null)
        {
          localaz = new az(((c)localObject).field_enterpriseFather);
          localaz.hyE();
          ((n)h.ae(n.class)).bbR().e(localaz);
        }
        az localaz = new az(paramString);
        localaz.EB(System.currentTimeMillis());
        localaz.Jc(((c)localObject).Zf());
        ((n)h.ae(n.class)).bbR().e(localaz);
      }
    }
  }
  
  public static int a(String paramString, final long paramLong, bq.a parama)
  {
    AppMethodBeat.i(123960);
    Log.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123957);
        Cursor localCursor = ((q)h.ae(q.class)).bbP().ch(this.jwL, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.lrx == null) || (!this.lrx.asH())))
          {
            ca localca = new ca();
            localca.convertFrom(localCursor);
            bq.B(localca);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((q)h.ae(q.class)).bbP().cg(this.jwL, paramLong);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123956);
            if (j.1.this.lrx != null) {
              j.1.this.lrx.asI();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.j
 * JD-Core Version:    0.7.0.1
 */