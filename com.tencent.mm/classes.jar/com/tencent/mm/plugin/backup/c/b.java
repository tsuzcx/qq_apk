package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;

public final class b
{
  public boolean nyH = false;
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(21230);
    ae.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = bu.fpO();
    final LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.bJW().bJX().azL().c(x.hHV, g.bIm(), "*");
    if (localCursor.getCount() == 0)
    {
      if (parama != null) {
        ar.f(new Runnable()
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
      ae.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
      localCursor.close();
      AppMethodBeat.o(21230);
      return;
    }
    localCursor.moveToFirst();
    ae.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    for (;;)
    {
      if (this.nyH)
      {
        ae.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        AppMethodBeat.o(21230);
        return;
      }
      au localau = new au();
      localau.convertFrom(localCursor);
      int i;
      if (!bu.isNullOrNil(localau.field_username))
      {
        i = d.bJW().bJX().azI().arr(localau.field_username);
        if (i > 0) {
          break label299;
        }
        ae.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localau.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.nyH) && (parama != null)) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21226);
              if ((!b.this.nyH) && (parama != null)) {
                parama.C(localLinkedList);
              }
              AppMethodBeat.o(21226);
            }
          });
        }
        ae.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(bu.DD(l)) });
        AppMethodBeat.o(21230);
        return;
        label299:
        bc.aCg();
        if (an.abz(c.azF().BH(localau.field_username).field_verifyFlag))
        {
          ae.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localau.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.nys = localau.field_username;
          localb.nyt = d.bJW().bJX().azI().aru(localau.field_username);
          localb.nyu = d.bJW().bJX().azI().arv(localau.field_username);
          ae.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.nys, Integer.valueOf(i), Long.valueOf(localb.nyt), Long.valueOf(localb.nyu) });
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
    Cursor localCursor = d.bJW().bJX().azI().arl(paramb.nys);
    ae.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.nys, Integer.valueOf(localCursor.getCount()) });
    PLong localPLong1;
    PLong localPLong2;
    if (localCursor.moveToFirst())
    {
      localPLong1 = new PLong();
      localPLong2 = new PLong();
    }
    for (;;)
    {
      if (this.nyH)
      {
        ae.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
        localCursor.close();
        AppMethodBeat.o(21231);
        return true;
      }
      bv localbv = new bv();
      localbv.convertFrom(localCursor);
      try
      {
        h.a(localbv, true, paramString, localPLong1, null, null, false, false, paramLong);
        localPLong2.value += 1L;
        if (localCursor.moveToNext()) {
          continue;
        }
        paramb.nyv = localPLong1.value;
        paramb.nyw = localPLong2.value;
        ae.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.nys, Long.valueOf(paramb.nyv), Long.valueOf(paramb.nyw) });
        localCursor.close();
        AppMethodBeat.o(21231);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.BackupCalculator", localException, "packedMsg", new Object[0]);
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21229);
    ae.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[] { bu.fpN() });
    this.nyH = true;
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