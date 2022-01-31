package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean jAv = false;
  private static boolean jBV = false;
  static boolean jEu = false;
  final f jBG;
  LinkedList<String> jBO;
  private com.tencent.mm.plugin.backup.c.b jBP;
  com.tencent.mm.plugin.backup.c.c jBQ;
  private long jBR;
  private long jBS;
  public Set<b.c> jEm;
  public b.a jEn;
  private boolean jEp;
  public boolean jEv;
  public boolean jEw;
  final f jEx;
  private final b.d jEy;
  private b.b jzz;
  
  public e()
  {
    AppMethodBeat.i(17553);
    this.jEm = new HashSet();
    this.jEp = false;
    this.jBR = 0L;
    this.jBS = 0L;
    this.jEv = false;
    this.jEw = false;
    this.jBG = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(17543);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.jBG);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ab.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.qsU.idkeyStat(400L, 117L, 1L, false);
          b.aTX().aSL().jyN = -5;
          e.this.rl(-5);
          AppMethodBeat.o(17543);
          return;
        }
        ab.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousm).jGg;
        if (!b.aTX().jyF.equals(paramAnonymousString.ID))
        {
          ab.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          h.qsU.idkeyStat(400L, 118L, 1L, false);
          b.aTX().aSL().jyN = -5;
          e.this.rl(-5);
          AppMethodBeat.o(17543);
          return;
        }
        b.aTX().aSL().jyV = paramAnonymousString.jJK;
        ab.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.jJK) });
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yEv, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.aUn();
        e.a(e.this);
        AppMethodBeat.o(17543);
      }
    };
    this.jEx = new e.2(this);
    this.jEy = new e.3(this);
    this.jzz = new e.5(this);
    AppMethodBeat.o(17553);
  }
  
  public static void aUh()
  {
    jEu = true;
  }
  
  public static void f(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(17557);
    ab.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.aTX();
    SharedPreferences.Editor localEditor = b.aSQ().edit();
    if (1 == b.aTX().aTY().jEa)
    {
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", paramInt1);
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", paramLong1);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", paramLong2);
    }
    localEditor.commit();
    AppMethodBeat.o(17557);
  }
  
  public final void G(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(17556);
    this.jBO = paramLinkedList;
    b.aTX();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.aSQ().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      jBV = true;
      b.aTX();
      this.jBR = b.aSQ().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.aTX();
      this.jBS = b.aSQ().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.aTX();
      if (b.aSQ().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label246;
      }
      jAv = true;
      if (paramLinkedList != null) {
        break label253;
      }
      i = -1;
      ab.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(jBV), Boolean.valueOf(jAv), Long.valueOf(this.jBR), Long.valueOf(this.jBS) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEp, Boolean.TRUE);
      if (1 == b.aTX().aTY().jEa)
      {
        b.aTX();
        localEditor = b.aSQ().edit();
        if (paramLinkedList != null) {
          break label261;
        }
      }
    }
    label261:
    for (paramLinkedList = new String[0];; paramLinkedList = (String[])paramLinkedList.toArray(new String[paramLinkedList.size()]))
    {
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", g.a("", ",", paramLinkedList));
      localEditor.commit();
      AppMethodBeat.o(17556);
      return;
      jBV = false;
      break;
      label246:
      jAv = false;
      break label95;
      label253:
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void aSJ()
  {
    AppMethodBeat.i(17560);
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jEm);
    al.d(new e.4(this, localHashSet));
    AppMethodBeat.o(17560);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(17555);
    ab.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), an.dtg() });
    jEu = true;
    if (!paramBoolean)
    {
      b.aTX().aTY();
      c.aTB();
    }
    this.jBQ.cancel();
    if (this.jBP != null)
    {
      this.jBP.cancel();
      this.jBP = null;
    }
    com.tencent.mm.plugin.backup.g.b.aUo();
    com.tencent.mm.plugin.backup.g.b.aUq();
    com.tencent.mm.plugin.backup.g.b.aUt();
    b.aTX().aSN();
    AppMethodBeat.o(17555);
  }
  
  public final void hJ(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(17558);
    ab.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.jBG);
    k localk = new k(b.aTX().jyF);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    aw.aaz();
    g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (jAv) {}
    for (;;)
    {
      localk.a(paramLong, g.hI(localPLong2.value), i);
      ab.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.aUv();
      AppMethodBeat.o(17558);
      return;
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yEv, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(17554);
    ab.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    jEu = false;
    this.jEp = false;
    com.tencent.mm.plugin.backup.g.b.a(this.jEy);
    this.jBQ = new com.tencent.mm.plugin.backup.c.c(b.aTX(), 1, this.jzz);
    AppMethodBeat.o(17554);
  }
  
  public final void rl(int paramInt)
  {
    AppMethodBeat.i(17561);
    this.jzz.rf(paramInt);
    AppMethodBeat.o(17561);
  }
  
  public final void rr(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(17559);
    long l2;
    if (this.jBQ != null)
    {
      if (this.jBQ.jzC != 0L) {
        l1 = bo.hl(this.jBQ.jzC);
      }
      long l3 = this.jBQ.aSZ();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      h.qsU.e(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.aTX().aTY().jEg) });
      ab.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
      AppMethodBeat.o(17559);
      return;
      l1 = 0L;
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e
 * JD-Core Version:    0.7.0.1
 */