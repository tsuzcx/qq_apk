package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class b
{
  public boolean hFU = false;
  
  public final void a(b.a parama)
  {
    y.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
    long l = bk.UY();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = d.avi().avj().FB().c(s.dUT, com.tencent.mm.plugin.backup.b.g.atA(), "*");
    if (localCursor.getCount() == 0)
    {
      if (parama != null) {
        ai.d(new b.1(this, parama, localLinkedList));
      }
      y.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
      localCursor.close();
      return;
    }
    localCursor.moveToFirst();
    y.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    for (;;)
    {
      if (this.hFU)
      {
        y.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        localCursor.close();
        return;
      }
      ak localak = new ak();
      localak.d(localCursor);
      int i;
      if (!bk.bl(localak.field_username))
      {
        i = d.avi().avj().Fy().HP(localak.field_username);
        if (i > 0) {
          break label275;
        }
        y.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[] { localak.field_username });
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        if ((!this.hFU) && (parama != null)) {
          ai.d(new b.2(this, parama, localLinkedList));
        }
        y.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[] { Long.valueOf(bk.co(l)) });
        return;
        label275:
        au.Hx();
        if (ad.Fn(c.Fw().abl(localak.field_username).field_verifyFlag))
        {
          y.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[] { localak.field_username, Integer.valueOf(i) });
        }
        else
        {
          f.b localb = new f.b();
          localb.hFD = localak.field_username;
          localb.hFE = d.avi().avj().Fy().HU(localak.field_username);
          localb.hFF = d.avi().avj().Fy().HV(localak.field_username);
          y.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[] { localb.hFD, Integer.valueOf(i), Long.valueOf(localb.hFE), Long.valueOf(localb.hFF) });
          localLinkedList.add(localb);
        }
      }
    }
  }
  
  public final boolean a(f.b paramb, String paramString, long paramLong)
  {
    if (paramb == null) {
      return false;
    }
    Cursor localCursor = d.avi().avj().Fy().HJ(paramb.hFD);
    y.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[] { paramb.hFD, Integer.valueOf(localCursor.getCount()) });
    if (localCursor.moveToFirst())
    {
      PLong localPLong1 = new PLong();
      PLong localPLong2 = new PLong();
      for (;;)
      {
        if (!localCursor.isAfterLast())
        {
          if (this.hFU)
          {
            y.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
            localCursor.close();
            return true;
          }
          bi localbi = new bi();
          localbi.d(localCursor);
          try
          {
            h.a(localbi, true, paramString, localPLong1, null, null, false, false, paramLong);
            localPLong2.value += 1L;
            localCursor.moveToNext();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.BackupCalculator", localException, "packedMsg", new Object[0]);
            }
          }
        }
      }
      paramb.hFG = localPLong1.value;
      paramb.hFH = localPLong2.value;
      y.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[] { paramb.hFD, Long.valueOf(paramb.hFG), Long.valueOf(paramb.hFH) });
    }
    localCursor.close();
    return false;
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[] { bk.csb() });
    this.hFU = true;
  }
  
  public static abstract interface b
    extends b.a
  {
    public abstract void B(LinkedList<f.b> paramLinkedList);
    
    public abstract void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.b
 * JD-Core Version:    0.7.0.1
 */