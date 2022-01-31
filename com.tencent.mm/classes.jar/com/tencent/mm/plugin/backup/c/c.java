package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class c
{
  private int hFq;
  boolean hGc = false;
  b.b hGd;
  com.tencent.mm.plugin.backup.b.d hGe;
  long hGf = 0L;
  public long hGg = 0L;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.hGe = paramd;
    this.hFq = paramInt;
    this.hGd = paramb;
    this.hGc = false;
  }
  
  public final void a(LinkedList<f.a> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      y.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      e.c(new c.1(this, paramLinkedList, paramLong, paramBoolean), "backupPackThread", 10).start();
      return;
    }
  }
  
  final boolean a(f.a parama, c.c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.backup.h.d.avi().avj().FB().abv(parama.hFB);
    int i;
    long l5;
    int k;
    long l1;
    long l2;
    int j;
    if (localObject1 != null)
    {
      i = ((as)localObject1).field_unReadCount;
      y.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[] { Integer.valueOf(parama.hFC), parama.hFB, Long.valueOf(parama.startTime), Long.valueOf(parama.endTime), Integer.valueOf(i) });
      l5 = bk.UY();
      k = 0;
      l1 = 0L;
      l2 = 0L;
      l3 = 0L;
      j = i;
      i = k;
    }
    long l4;
    for (;;)
    {
      LinkedList localLinkedList1 = new LinkedList();
      l4 = bk.UY();
      localObject1 = com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().c(parama.hFB, parama.startTime, parama.endTime, i);
      Object localObject2;
      for (;;)
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break label251;
        }
        k = i + 1;
        if (this.hGc)
        {
          y.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg add msgInfoLinkedList is CANCELED!");
          ((Cursor)localObject1).close();
          return false;
          i = 0;
          break;
        }
        localObject2 = new bi();
        ((bi)localObject2).d((Cursor)localObject1);
        if (paramBoolean)
        {
          i = k;
          if (((bi)localObject2).getType() != 1) {}
        }
        else
        {
          localLinkedList1.add(localObject2);
          i = k;
        }
      }
      label251:
      ((Cursor)localObject1).close();
      l4 = l3 - l4 + bk.UY();
      if (localLinkedList1.size() == 0) {
        break label685;
      }
      k = 0;
      if (k < localLinkedList1.size())
      {
        if (this.hGc)
        {
          y.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg packMsg is CANCELED!");
          return false;
        }
        Object localObject3 = (bi)localLinkedList1.get(k);
        PLong localPLong = new PLong();
        LinkedList localLinkedList2 = new LinkedList();
        HashMap localHashMap = new HashMap();
        l3 = l2;
        for (;;)
        {
          for (;;)
          {
            boolean bool;
            try
            {
              l2 -= bk.UY();
              if (j > 0)
              {
                bool = true;
                l3 = l2;
                localObject1 = h.a((bi)localObject3, false, paramString, localPLong, localLinkedList2, localHashMap, bool, false, paramLong);
              }
            }
            catch (Exception localException1)
            {
              int m;
              localObject1 = null;
              l2 = l3;
            }
            try
            {
              l3 = bk.UY();
              l2 = l3 + l2;
              if (localObject1 != null) {
                break label672;
              }
              bool = true;
              y.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localLinkedList2.size()), Long.valueOf(localPLong.value), Integer.valueOf(localHashMap.size()), Long.valueOf(((cs)localObject3).field_msgSvrId), Integer.valueOf(((bi)localObject3).getType()), Long.valueOf(((cs)localObject3).field_createTime), ((cs)localObject3).field_talker });
              l3 = l1;
              m = j;
              if (localObject1 != null)
              {
                m = j - 1;
                l3 = bk.UY();
                long l6 = localPLong.value;
                long l7 = ((cs)localObject3).field_createTime;
                if (paramc.hGL == null)
                {
                  localObject2 = paramc.hGJ;
                  localObject3 = new c.b(paramc.hGk, paramc.hGp, parama);
                  paramc.hGL = ((c.b)localObject3);
                  ((LinkedBlockingQueue)localObject2).offer(localObject3);
                }
                if (paramc.hGL.a((fo)localObject1, l6, l7, localLinkedList2, localHashMap)) {
                  paramc.hGL = null;
                }
                l3 = l1 - l3 + bk.UY();
              }
              k += 1;
              l1 = l3;
              j = m;
            }
            catch (Exception localException2)
            {
              label656:
              label672:
              break label656;
            }
          }
          bool = false;
          continue;
          y.printErrStackTrace("MicroMsg.BackupPackAndSend", localException1, "backupPackSessionMsg packedMsg", new Object[0]);
          continue;
          bool = false;
        }
      }
      l3 = l4;
    }
    label685:
    paramLong = bk.UY();
    if (paramc.hGL == null)
    {
      paramString = paramc.hGJ;
      localObject1 = new c.b(paramc.hGk, paramc.hGp, parama);
      paramc.hGL = ((c.b)localObject1);
      paramString.offer(localObject1);
    }
    paramc.hGL.atD();
    paramc.hGL = null;
    long l3 = bk.UY();
    y.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[] { Integer.valueOf(parama.hFC), parama.hFB, Integer.valueOf(i), Long.valueOf(bk.co(l5)), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1 - paramLong + l3) });
    return true;
  }
  
  public final long atB()
  {
    return this.hGf / 1024L;
  }
  
  public final void atC()
  {
    y.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.ID = this.hGe.hFm;
    try
    {
      com.tencent.mm.plugin.backup.g.b.I(locald.toByteArray(), 8);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupPackAndSend", localException, "BackupFinishRequest to buf err.", new Object[0]);
    }
  }
  
  public final void cancel()
  {
    y.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { ak.cri() });
    this.hGc = true;
  }
  
  public final void ea(boolean paramBoolean)
  {
    y.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.hFq == 1)
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uum, Boolean.valueOf(false));
      localEditor = com.tencent.mm.plugin.backup.b.d.ats().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.hFq != 1) {
          break label145;
        }
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
    for (;;)
    {
      localEditor.commit();
      return;
      if (this.hFq != 2) {
        break;
      }
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uup, Boolean.valueOf(false));
      break;
      label145:
      if (this.hFq == 2)
      {
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
  }
  
  private final class a
  {
    volatile AtomicLong hGl = new AtomicLong(0L);
    af hGm = new af(true);
    af hGn = new af(true);
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */