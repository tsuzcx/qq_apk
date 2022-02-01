package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;

public final class b
{
  public boolean mSO = false;
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(21230);
    ac.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = bs.eWj();
    final LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.bEP().bEQ().awG().c(w.hmN, g.bDg(), "*");
    if (localCursor.getCount() == 0)
    {
      if (parama != null) {
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
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
      ac.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
      localCursor.close();
      AppMethodBeat.o(21230);
      return;
    }
    localCursor.moveToFirst();
    ac.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    for (;;)
    {
      if (this.mSO)
      {
        ac.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        AppMethodBeat.o(21230);
        return;
      }
      com.tencent.mm.storage.ap localap = new com.tencent.mm.storage.ap();
      localap.convertFrom(localCursor);
      int i;
      if (!bs.isNullOrNil(localap.field_username))
      {
        i = d.bEP().bEQ().awD().aly(localap.field_username);
        if (i > 0) {
          break label299;
        }
        ac.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localap.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.mSO) && (parama != null)) {
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21226);
              if ((!b.this.mSO) && (parama != null)) {
                parama.C(localLinkedList);
              }
              AppMethodBeat.o(21226);
            }
          });
        }
        ac.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(bs.Ap(l)) });
        AppMethodBeat.o(21230);
        return;
        label299:
        com.tencent.mm.model.az.ayM();
        if (ai.YI(c.awB().aNt(localap.field_username).field_verifyFlag))
        {
          ac.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localap.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.mSz = localap.field_username;
          localb.mSA = d.bEP().bEQ().awD().alB(localap.field_username);
          localb.mSB = d.bEP().bEQ().awD().alC(localap.field_username);
          ac.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.mSz, Integer.valueOf(i), Long.valueOf(localb.mSA), Long.valueOf(localb.mSB) });
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
    Cursor localCursor = d.bEP().bEQ().awD().als(paramb.mSz);
    ac.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.mSz, Integer.valueOf(localCursor.getCount()) });
    PLong localPLong1;
    PLong localPLong2;
    if (localCursor.moveToFirst())
    {
      localPLong1 = new PLong();
      localPLong2 = new PLong();
    }
    for (;;)
    {
      if (this.mSO)
      {
        ac.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
        localCursor.close();
        AppMethodBeat.o(21231);
        return true;
      }
      bo localbo = new bo();
      localbo.convertFrom(localCursor);
      try
      {
        com.tencent.mm.plugin.backup.f.h.a(localbo, true, paramString, localPLong1, null, null, false, false, paramLong);
        localPLong2.value += 1L;
        if (localCursor.moveToNext()) {
          continue;
        }
        paramb.mSC = localPLong1.value;
        paramb.mSD = localPLong2.value;
        ac.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.mSz, Long.valueOf(paramb.mSC), Long.valueOf(paramb.mSD) });
        localCursor.close();
        AppMethodBeat.o(21231);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.BackupCalculator", localException, "packedMsg", new Object[0]);
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21229);
    ac.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[] { bs.eWi() });
    this.mSO = true;
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