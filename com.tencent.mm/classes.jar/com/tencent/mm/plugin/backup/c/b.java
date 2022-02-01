package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class b
{
  public boolean oJF = false;
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(21230);
    Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = Util.nowMilliSecond();
    final LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.cgP().cgQ().aST().c(ab.iCF, g.cfd(), "*");
    if (localCursor.getCount() == 0)
    {
      if (parama != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21225);
            if (parama != null) {
              parama.C(localLinkedList);
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
      if (this.oJF)
      {
        Log.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        AppMethodBeat.o(21230);
        return;
      }
      az localaz = new az();
      localaz.convertFrom(localCursor);
      int i;
      if (!Util.isNullOrNil(localaz.field_username))
      {
        i = d.cgP().cgQ().aSQ().aEM(localaz.field_username);
        if (i > 0) {
          break label299;
        }
        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localaz.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.oJF) && (parama != null)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21226);
              if ((!b.this.oJF) && (parama != null)) {
                parama.C(localLinkedList);
              }
              AppMethodBeat.o(21226);
            }
          });
        }
        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
        AppMethodBeat.o(21230);
        return;
        label299:
        bg.aVF();
        if (as.akh(c.aSN().Kn(localaz.field_username).field_verifyFlag))
        {
          Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localaz.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.oJq = localaz.field_username;
          localb.oJr = d.cgP().cgQ().aSQ().aEP(localaz.field_username);
          localb.oJs = d.cgP().cgQ().aSQ().aEQ(localaz.field_username);
          Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.oJq, Integer.valueOf(i), Long.valueOf(localb.oJr), Long.valueOf(localb.oJs) });
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
    Cursor localCursor = d.cgP().cgQ().aSQ().aEG(paramb.oJq);
    Log.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.oJq, Integer.valueOf(localCursor.getCount()) });
    PLong localPLong1;
    PLong localPLong2;
    if (localCursor.moveToFirst())
    {
      localPLong1 = new PLong();
      localPLong2 = new PLong();
    }
    for (;;)
    {
      if (this.oJF)
      {
        Log.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
        localCursor.close();
        AppMethodBeat.o(21231);
        return true;
      }
      ca localca = new ca();
      localca.convertFrom(localCursor);
      try
      {
        h.a(localca, true, paramString, localPLong1, null, null, false, false, paramLong);
        localPLong2.value += 1L;
        if (localCursor.moveToNext()) {
          continue;
        }
        paramb.oJt = localPLong1.value;
        paramb.oJu = localPLong2.value;
        Log.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.oJq, Long.valueOf(paramb.oJt), Long.valueOf(paramb.oJu) });
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
    this.oJF = true;
    AppMethodBeat.o(21229);
  }
  
  public static abstract interface a
  {
    public abstract void C(LinkedList<f.b> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.b
 * JD-Core Version:    0.7.0.1
 */