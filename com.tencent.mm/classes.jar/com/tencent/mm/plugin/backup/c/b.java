package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;

public final class b
{
  public boolean ntm = false;
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(21230);
    ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = bt.flT();
    final LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.bIY().bIZ().azv().c(w.hFd, g.bHo(), "*");
    if (localCursor.getCount() == 0)
    {
      if (parama != null) {
        aq.f(new Runnable()
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
      ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
      localCursor.close();
      AppMethodBeat.o(21230);
      return;
    }
    localCursor.moveToFirst();
    ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    for (;;)
    {
      if (this.ntm)
      {
        ad.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        AppMethodBeat.o(21230);
        return;
      }
      at localat = new at();
      localat.convertFrom(localCursor);
      int i;
      if (!bt.isNullOrNil(localat.field_username))
      {
        i = d.bIY().bIZ().azs().aqm(localat.field_username);
        if (i > 0) {
          break label299;
        }
        ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localat.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.ntm) && (parama != null)) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21226);
              if ((!b.this.ntm) && (parama != null)) {
                parama.C(localLinkedList);
              }
              AppMethodBeat.o(21226);
            }
          });
        }
        ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(bt.Df(l)) });
        AppMethodBeat.o(21230);
        return;
        label299:
        com.tencent.mm.model.ba.aBQ();
        if (am.aaR(c.azp().Bf(localat.field_username).field_verifyFlag))
        {
          ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localat.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.nsX = localat.field_username;
          localb.nsY = d.bIY().bIZ().azs().aqp(localat.field_username);
          localb.nsZ = d.bIY().bIZ().azs().aqq(localat.field_username);
          ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.nsX, Integer.valueOf(i), Long.valueOf(localb.nsY), Long.valueOf(localb.nsZ) });
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
    Cursor localCursor = d.bIY().bIZ().azs().aqg(paramb.nsX);
    ad.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.nsX, Integer.valueOf(localCursor.getCount()) });
    PLong localPLong1;
    PLong localPLong2;
    if (localCursor.moveToFirst())
    {
      localPLong1 = new PLong();
      localPLong2 = new PLong();
    }
    for (;;)
    {
      if (this.ntm)
      {
        ad.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
        localCursor.close();
        AppMethodBeat.o(21231);
        return true;
      }
      bu localbu = new bu();
      localbu.convertFrom(localCursor);
      try
      {
        h.a(localbu, true, paramString, localPLong1, null, null, false, false, paramLong);
        localPLong2.value += 1L;
        if (localCursor.moveToNext()) {
          continue;
        }
        paramb.nta = localPLong1.value;
        paramb.ntb = localPLong2.value;
        ad.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.nsX, Long.valueOf(paramb.nta), Long.valueOf(paramb.ntb) });
        localCursor.close();
        AppMethodBeat.o(21231);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.BackupCalculator", localException, "packedMsg", new Object[0]);
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21229);
    ad.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[] { bt.flS() });
    this.ntm = true;
    AppMethodBeat.o(21229);
  }
  
  public static abstract interface a
  {
    public abstract void C(LinkedList<f.b> paramLinkedList);
  }
  
  public static abstract interface b
    extends b.a
  {
    public abstract void D(LinkedList<f.b> paramLinkedList);
    
    public abstract void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.b
 * JD-Core Version:    0.7.0.1
 */