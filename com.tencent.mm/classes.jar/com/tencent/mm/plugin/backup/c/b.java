package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class b
{
  public boolean jzq = false;
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(17172);
    ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = bo.aoy();
    final LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.aUK().aUL().YF().c(t.flc, g.aSY(), "*");
    if (localCursor.getCount() == 0)
    {
      if (parama != null) {
        al.d(new b.1(this, parama, localLinkedList));
      }
      ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
      localCursor.close();
      AppMethodBeat.o(17172);
      return;
    }
    localCursor.moveToFirst();
    ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    for (;;)
    {
      if (this.jzq)
      {
        ab.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        AppMethodBeat.o(17172);
        return;
      }
      ak localak = new ak();
      localak.convertFrom(localCursor);
      int i;
      if (!bo.isNullOrNil(localak.field_username))
      {
        i = d.aUK().aUL().YC().TA(localak.field_username);
        if (i > 0) {
          break label299;
        }
        ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localak.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.jzq) && (parama != null)) {
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(17168);
              if ((!b.this.jzq) && (parama != null)) {
                parama.B(localLinkedList);
              }
              AppMethodBeat.o(17168);
            }
          });
        }
        ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(bo.hl(l)) });
        AppMethodBeat.o(17172);
        return;
        label299:
        aw.aaz();
        if (ad.Nt(c.YA().arw(localak.field_username).field_verifyFlag))
        {
          ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localak.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.jza = localak.field_username;
          localb.jzb = d.aUK().aUL().YC().TD(localak.field_username);
          localb.jzc = d.aUK().aUL().YC().TE(localak.field_username);
          ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.jza, Integer.valueOf(i), Long.valueOf(localb.jzb), Long.valueOf(localb.jzc) });
          localLinkedList.add(localb);
        }
      }
    }
  }
  
  public final boolean a(f.b paramb, String paramString, long paramLong)
  {
    AppMethodBeat.i(17173);
    if (paramb == null)
    {
      AppMethodBeat.o(17173);
      return false;
    }
    Cursor localCursor = d.aUK().aUL().YC().Tu(paramb.jza);
    ab.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.jza, Integer.valueOf(localCursor.getCount()) });
    if (localCursor.moveToFirst())
    {
      PLong localPLong1 = new PLong();
      PLong localPLong2 = new PLong();
      for (;;)
      {
        if (!localCursor.isAfterLast())
        {
          if (this.jzq)
          {
            ab.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
            localCursor.close();
            AppMethodBeat.o(17173);
            return true;
          }
          bi localbi = new bi();
          localbi.convertFrom(localCursor);
          try
          {
            com.tencent.mm.plugin.backup.f.h.a(localbi, true, paramString, localPLong1, null, null, false, false, paramLong);
            localPLong2.value += 1L;
            localCursor.moveToNext();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.BackupCalculator", localException, "packedMsg", new Object[0]);
            }
          }
        }
      }
      paramb.jzd = localPLong1.value;
      paramb.jze = localPLong2.value;
      ab.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.jza, Long.valueOf(paramb.jzd), Long.valueOf(paramb.jze) });
    }
    localCursor.close();
    AppMethodBeat.o(17173);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(17171);
    ab.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[] { bo.dtY() });
    this.jzq = true;
    AppMethodBeat.o(17171);
  }
  
  public static abstract interface a
  {
    public abstract void B(LinkedList<f.b> paramLinkedList);
  }
  
  public static abstract interface b
    extends b.a
  {
    public abstract void C(LinkedList<f.b> paramLinkedList);
    
    public abstract void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.b
 * JD-Core Version:    0.7.0.1
 */