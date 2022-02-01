package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;

public final class b
{
  public boolean mqM = false;
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(21230);
    ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = bt.eGO();
    final LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.bxT().bxU().apR().c(w.gMn, g.bwk(), "*");
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
      if (this.mqM)
      {
        ad.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        AppMethodBeat.o(21230);
        return;
      }
      am localam = new am();
      localam.convertFrom(localCursor);
      int i;
      if (!bt.isNullOrNil(localam.field_username))
      {
        i = d.bxT().bxU().apO().agE(localam.field_username);
        if (i > 0) {
          break label299;
        }
        ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localam.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.mqM) && (parama != null)) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21226);
              if ((!b.this.mqM) && (parama != null)) {
                parama.C(localLinkedList);
              }
              AppMethodBeat.o(21226);
            }
          });
        }
        ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(bt.vM(l)) });
        AppMethodBeat.o(21230);
        return;
        label299:
        az.arV();
        if (af.Wy(c.apM().aHY(localam.field_username).field_verifyFlag))
        {
          ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localam.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.mqx = localam.field_username;
          localb.mqy = d.bxT().bxU().apO().agH(localam.field_username);
          localb.mqz = d.bxT().bxU().apO().agI(localam.field_username);
          ad.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.mqx, Integer.valueOf(i), Long.valueOf(localb.mqy), Long.valueOf(localb.mqz) });
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
    Cursor localCursor = d.bxT().bxU().apO().agy(paramb.mqx);
    ad.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.mqx, Integer.valueOf(localCursor.getCount()) });
    if (localCursor.moveToFirst())
    {
      PLong localPLong1 = new PLong();
      PLong localPLong2 = new PLong();
      for (;;)
      {
        if (!localCursor.isAfterLast())
        {
          if (this.mqM)
          {
            ad.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
            localCursor.close();
            AppMethodBeat.o(21231);
            return true;
          }
          bl localbl = new bl();
          localbl.convertFrom(localCursor);
          try
          {
            com.tencent.mm.plugin.backup.f.h.a(localbl, true, paramString, localPLong1, null, null, false, false, paramLong);
            localPLong2.value += 1L;
            localCursor.moveToNext();
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
      paramb.mqA = localPLong1.value;
      paramb.mqB = localPLong2.value;
      ad.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.mqx, Long.valueOf(paramb.mqA), Long.valueOf(paramb.mqB) });
    }
    localCursor.close();
    AppMethodBeat.o(21231);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21229);
    ad.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[] { bt.eGN() });
    this.mqM = true;
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