package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;

public final class b
{
  public boolean uWI = false;
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(21230);
    Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = Util.nowMilliSecond();
    final LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.cWK().cWL().bzG().a(1, g.cVa(), "*");
    if (localCursor.getCount() == 0)
    {
      if (parama != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21225);
            if (parama != null) {
              parama.G(localLinkedList);
            }
            AppMethodBeat.o(21225);
          }
        });
      }
      Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
      localCursor.close();
      AppMethodBeat.o(21230);
      return;
    }
    localCursor.moveToFirst();
    Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    for (;;)
    {
      if (this.uWI)
      {
        Log.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        AppMethodBeat.o(21230);
        return;
      }
      bb localbb = new bb();
      localbb.convertFrom(localCursor);
      int i;
      if (!Util.isNullOrNil(localbb.field_username))
      {
        i = d.cWK().cWL().bzD().aLW(localbb.field_username);
        if (i > 0) {
          break label297;
        }
        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localbb.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.uWI) && (parama != null)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21226);
              if ((!b.this.uWI) && (parama != null)) {
                parama.G(localLinkedList);
              }
              AppMethodBeat.o(21226);
            }
          });
        }
        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
        AppMethodBeat.o(21230);
        return;
        label297:
        bh.bCz();
        if (au.ayS(c.bzA().JE(localbb.field_username).field_verifyFlag))
        {
          Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localbb.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.uWu = localbb.field_username;
          localb.uWv = d.cWK().cWL().bzD().aLZ(localbb.field_username);
          localb.uWw = d.cWK().cWL().bzD().Hq(localbb.field_username);
          Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.uWu, Integer.valueOf(i), Long.valueOf(localb.uWv), Long.valueOf(localb.uWw) });
          localLinkedList.add(localb);
        }
      }
    }
  }
  
  public final boolean a(f.b paramb, String paramString, long paramLong)
  {
    AppMethodBeat.i(21231);
    if (paramb == null)
    {
      AppMethodBeat.o(21231);
      return false;
    }
    Cursor localCursor = d.cWK().cWL().bzD().aLQ(paramb.uWu);
    Log.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.uWu, Integer.valueOf(localCursor.getCount()) });
    PLong localPLong1;
    PLong localPLong2;
    if (localCursor.moveToFirst())
    {
      localPLong1 = new PLong();
      localPLong2 = new PLong();
    }
    for (;;)
    {
      if (this.uWI)
      {
        Log.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
        localCursor.close();
        AppMethodBeat.o(21231);
        return true;
      }
      cc localcc = new cc();
      localcc.convertFrom(localCursor);
      try
      {
        h.a(localcc, true, paramString, localPLong1, null, null, false, false, paramLong);
        localPLong2.value += 1L;
        if (localCursor.moveToNext()) {
          continue;
        }
        paramb.uWx = localPLong1.value;
        paramb.uWy = localPLong2.value;
        Log.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.uWu, Long.valueOf(paramb.uWx), Long.valueOf(paramb.uWy) });
        localCursor.close();
        AppMethodBeat.o(21231);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.BackupCalculator", localException, "packedMsg", new Object[0]);
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21229);
    Log.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[] { Util.getStack() });
    this.uWI = true;
    AppMethodBeat.o(21229);
  }
  
  public static abstract interface a
  {
    public abstract void G(LinkedList<f.b> paramLinkedList);
  }
  
  public static abstract interface b
    extends b.a
  {
    public abstract void H(LinkedList<f.b> paramLinkedList);
    
    public abstract void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.b
 * JD-Core Version:    0.7.0.1
 */