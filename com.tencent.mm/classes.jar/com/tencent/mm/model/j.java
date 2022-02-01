package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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
  public static void HO(String paramString)
  {
    AppMethodBeat.i(123959);
    if (!Util.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramString);
      if ((localObject != null) && (!Util.isNullOrNil(((ax)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(123959);
      return;
    }
    ((as)localObject).setType(((ax)localObject).field_type | 0x800);
    ab.G((as)localObject);
    if ((((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(paramString) == null) && (((as)localObject).gBM()))
    {
      if (!com.tencent.mm.al.g.Nd(paramString)) {
        break label254;
      }
      if (((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY("officialaccounts") == null)
      {
        localObject = new az("officialaccounts");
        ((az)localObject).gCr();
        ((l)com.tencent.mm.kernel.g.af(l.class)).aST().e((az)localObject);
      }
      localObject = new az(paramString);
      ((az)localObject).yA(System.currentTimeMillis());
      ((az)localObject).Co("officialaccounts");
      ((l)com.tencent.mm.kernel.g.af(l.class)).aST().e((az)localObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bke(paramString);
      AppMethodBeat.o(123959);
      return;
      label254:
      if (com.tencent.mm.al.g.Nf(paramString))
      {
        localObject = com.tencent.mm.al.g.fJ(paramString);
        if (((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(((c)localObject).field_enterpriseFather) == null)
        {
          localaz = new az(((c)localObject).field_enterpriseFather);
          localaz.gCr();
          ((l)com.tencent.mm.kernel.g.af(l.class)).aST().e(localaz);
        }
        az localaz = new az(paramString);
        localaz.yA(System.currentTimeMillis());
        localaz.Co(((c)localObject).UN());
        ((l)com.tencent.mm.kernel.g.af(l.class)).aST().e(localaz);
      }
    }
  }
  
  public static int a(String paramString, final long paramLong, bp.a parama)
  {
    AppMethodBeat.i(123960);
    Log.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123957);
        Cursor localCursor = ((q)com.tencent.mm.kernel.g.af(q.class)).aSR().ca(this.gMw, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.iBS == null) || (!this.iBS.amG())))
          {
            ca localca = new ca();
            localca.convertFrom(localCursor);
            bp.z(localca);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((q)com.tencent.mm.kernel.g.af(q.class)).aSR().bZ(this.gMw, paramLong);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123956);
            if (j.1.this.iBS != null) {
              j.1.this.iBS.amH();
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