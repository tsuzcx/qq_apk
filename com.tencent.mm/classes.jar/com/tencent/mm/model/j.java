package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g;
import com.tencent.mm.an.q;
import com.tencent.mm.api.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.t;
import junit.framework.Assert;

public final class j
{
  public static void HW(String paramString)
  {
    AppMethodBeat.i(123959);
    if (!Util.isNullOrNil(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((n)h.ax(n.class)).bzA().JE(paramString);
      if ((localObject != null) && (!Util.isNullOrNil(((az)localObject).field_username))) {
        break;
      }
      AppMethodBeat.o(123959);
      return;
    }
    ((au)localObject).setType(((az)localObject).field_type | 0x800);
    ab.N((au)localObject);
    if ((((n)h.ax(n.class)).bzG().bxM(paramString) == null) && (((au)localObject).iZC()))
    {
      if (!g.My(paramString)) {
        break label254;
      }
      if (((n)h.ax(n.class)).bzG().bxM("officialaccounts") == null)
      {
        localObject = new bb("officialaccounts");
        ((bb)localObject).jaJ();
        ((n)h.ax(n.class)).bzG().h((bb)localObject);
      }
      localObject = new bb(paramString);
      ((bb)localObject).gR(System.currentTimeMillis());
      ((bb)localObject).BH("officialaccounts");
      ((n)h.ax(n.class)).bzG().h((bb)localObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(paramString)));
      ((n)h.ax(n.class)).bzG().bxT(paramString);
      AppMethodBeat.o(123959);
      return;
      label254:
      if (g.MA(paramString))
      {
        localObject = g.hU(paramString);
        if (((n)h.ax(n.class)).bzG().bxM(((c)localObject).field_enterpriseFather) == null)
        {
          localbb = new bb(((c)localObject).field_enterpriseFather);
          localbb.jaJ();
          ((n)h.ax(n.class)).bzG().h(localbb);
        }
        bb localbb = new bb(paramString);
        localbb.gR(System.currentTimeMillis());
        localbb.BH(((c)localObject).aAX());
        ((n)h.ax(n.class)).bzG().h(localbb);
      }
    }
  }
  
  public static int a(String paramString, final long paramLong, br.a parama)
  {
    AppMethodBeat.i(123960);
    Log.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123957);
        Cursor localCursor = ((q)h.ax(q.class)).bzE().ct(j.this, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.oiY == null) || (!this.oiY.aMJ())))
          {
            cc localcc = new cc();
            localcc.convertFrom(localCursor);
            br.D(localcc);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((q)h.ax(q.class)).bzE().cs(j.this, paramLong);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123956);
            if (j.1.this.oiY != null) {
              j.1.this.oiY.aMK();
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