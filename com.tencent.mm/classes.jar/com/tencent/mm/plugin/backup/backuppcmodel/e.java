package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean hGZ = false;
  private static boolean hIx = false;
  static boolean hKR = false;
  private b.b hGd = new e.5(this);
  final f hIi = new e.1(this);
  LinkedList<String> hIq;
  private com.tencent.mm.plugin.backup.c.b hIr;
  com.tencent.mm.plugin.backup.c.c hIs;
  private long hIt = 0L;
  private long hIu = 0L;
  public Set<b.c> hKJ = new HashSet();
  public b.a hKK;
  private boolean hKM = false;
  public boolean hKS = false;
  public boolean hKT = false;
  final f hKU = new e.2(this);
  private final b.d hKV = new e.3(this);
  
  public static void auG()
  {
    hKR = true;
  }
  
  public static void e(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    y.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.auw();
    SharedPreferences.Editor localEditor = b.ats().edit();
    if (1 == b.auw().aux().hKx)
    {
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", paramInt1);
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", paramLong1);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", paramLong2);
    }
    localEditor.commit();
  }
  
  public final void F(LinkedList<String> paramLinkedList)
  {
    this.hIq = paramLinkedList;
    b.auw();
    label89:
    int i;
    label95:
    SharedPreferences.Editor localEditor;
    if (b.ats().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      hIx = true;
      b.auw();
      this.hIt = b.ats().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.auw();
      this.hIu = b.ats().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.auw();
      if (b.ats().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label235;
      }
      hGZ = true;
      if (paramLinkedList != null) {
        break label242;
      }
      i = -1;
      y.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(hIx), Boolean.valueOf(hGZ), Long.valueOf(this.hIt), Long.valueOf(this.hIu) });
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uum, Boolean.valueOf(true));
      if (1 == b.auw().aux().hKx)
      {
        b.auw();
        localEditor = b.ats().edit();
        if (paramLinkedList != null) {
          break label250;
        }
      }
    }
    label235:
    label242:
    label250:
    for (paramLinkedList = new String[0];; paramLinkedList = (String[])paramLinkedList.toArray(new String[paramLinkedList.size()]))
    {
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", g.a("", ",", paramLinkedList));
      localEditor.commit();
      return;
      hIx = false;
      break;
      hGZ = false;
      break label89;
      i = paramLinkedList.size();
      break label95;
    }
  }
  
  public final void atl()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.hKJ);
    ai.d(new e.4(this, localHashSet));
  }
  
  public final void cH(long paramLong)
  {
    int i = 3;
    y.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.hIi);
    k localk = new k(b.auw().hFm);
    Object localObject = new PLong();
    PLong localPLong = new PLong();
    au.Hx();
    g.a((PLong)localObject, localPLong, com.tencent.mm.model.c.FU());
    if (hGZ) {}
    for (;;)
    {
      localObject = g.cG(localPLong.value);
      localk.hMD.hQi = 0L;
      localk.hMD.hQj = paramLong;
      localk.hMD.hQk = 0L;
      localk.hMD.hQl = ((m)localObject);
      localk.hMD.hQm = 0L;
      localk.hMD.hQn = i;
      y.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.auT();
      return;
      au.Hx();
      if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uus, Boolean.valueOf(false))).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    y.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), ak.cri() });
    hKR = true;
    if (!paramBoolean)
    {
      b.auw().aux();
      c.auc();
    }
    this.hIs.cancel();
    if (this.hIr != null)
    {
      this.hIr.cancel();
      this.hIr = null;
    }
    com.tencent.mm.plugin.backup.g.b.auM();
    com.tencent.mm.plugin.backup.g.b.auO();
    com.tencent.mm.plugin.backup.g.b.auR();
  }
  
  public final void init()
  {
    y.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    hKR = false;
    this.hKM = false;
    com.tencent.mm.plugin.backup.g.b.a(this.hKV);
    this.hIs = new com.tencent.mm.plugin.backup.c.c(b.auw(), 1, this.hGd);
  }
  
  public final void nC(int paramInt)
  {
    long l1 = 0L;
    long l2;
    if (this.hIs != null)
    {
      if (this.hIs.hGg != 0L) {
        l1 = bk.co(this.hIs.hGg);
      }
      long l3 = this.hIs.atB();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      h.nFQ.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.auw().aux().hKD) });
      y.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
      return;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public final void nD(int paramInt)
  {
    this.hGd.nt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e
 * JD-Core Version:    0.7.0.1
 */