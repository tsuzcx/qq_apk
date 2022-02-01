package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.i;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean nBk = false;
  static boolean nDH = false;
  private static boolean nzM = false;
  final com.tencent.mm.ak.f nAV;
  LinkedList<String> nBd;
  private com.tencent.mm.plugin.backup.c.b nBe;
  com.tencent.mm.plugin.backup.c.c nBf;
  private long nBg;
  private long nBh;
  public b.a nDA;
  private boolean nDC;
  public boolean nDI;
  public boolean nDJ;
  final com.tencent.mm.ak.f nDK;
  private final b.d nDL;
  public Set<b.c> nDz;
  private com.tencent.mm.plugin.backup.b.b.b nyQ;
  
  public e()
  {
    AppMethodBeat.i(21612);
    this.nDz = new HashSet();
    this.nDC = false;
    this.nBg = 0L;
    this.nBh = 0L;
    this.nDI = false;
    this.nDJ = false;
    this.nAV = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21602);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.nAV);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 117L, 1L, false);
          b.bJh().bHV().nye = -5;
          e.this.tK(-5);
          AppMethodBeat.o(21602);
          return;
        }
        ae.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousn).nFs;
        if (!b.bJh().nxW.equals(paramAnonymousString.ID))
        {
          ae.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 118L, 1L, false);
          b.bJh().bHV().nye = -5;
          e.this.tK(-5);
          AppMethodBeat.o(21602);
          return;
        }
        b.bJh().bHV().nym = paramAnonymousString.nIT;
        ae.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.nIT) });
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.IRG, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.bJz();
        e.a(e.this);
        AppMethodBeat.o(21602);
      }
    };
    this.nDK = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21603);
        com.tencent.mm.plugin.backup.g.b.b(11, e.this.nDK);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 119L, 1L, false);
          e.this.cancel(false);
          b.bJh().bHV().nye = -5;
          e.this.tK(-5);
          AppMethodBeat.o(21603);
          return;
        }
        paramAnonymousString = (i)paramAnonymousn;
        paramAnonymousString = com.tencent.mm.plugin.backup.b.g.b(paramAnonymousString.nFg.nIF, paramAnonymousString.nFg.nIG);
        ae.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
        paramAnonymousn = e.b(e.this);
        b.bJh().bJi();
        paramAnonymousn.a(paramAnonymousString, b.bJh().bHV().nym, e.nzM);
        AppMethodBeat.o(21603);
      }
    };
    this.nDL = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21605);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Boolean.valueOf(e.blc()) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label506;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.bJh().bHV().nye;
            ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            switch (paramAnonymousInt1)
            {
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21605);
          return;
          i = paramAnonymousArrayOfByte.length;
          break;
          b.bJh().bIF().stop();
          b.bJh().bHV().nye = -100;
          e.this.tK(-100);
          AppMethodBeat.o(21605);
          return;
          b.bJh().bIF().stop();
          AppMethodBeat.o(21605);
          return;
          b.bJh().bIF().stop();
          b.bJh().bHV().nye = -100;
          e.this.tK(-100);
          AppMethodBeat.o(21605);
          return;
          if ((b.bJh().bJi().nDr) && (!e.blc()))
          {
            paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bJG();
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(21605);
              return;
              ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              e.this.xE(19);
              e.c(e.this);
              com.tencent.mm.plugin.backup.g.b.a(b.bJh().bJi().nDw);
              AppMethodBeat.o(21605);
              return;
              ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            }
          }
          ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
          e.this.cancel(true);
          b.bJh().bIF().stop();
          b.bJh().bHV().nye = -4;
          e.this.tK(-4);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 9L, 1L, false);
          e.this.xE(3);
          AppMethodBeat.o(21605);
          return;
          e.this.cancel(true);
        }
        label506:
        Object localObject;
        if ((1 == b.bJh().bJi().nDn) || (3 == b.bJh().bJi().nDn))
        {
          if (paramAnonymousInt1 == 10)
          {
            localObject = new com.tencent.mm.plugin.backup.i.f();
            try
            {
              ((com.tencent.mm.plugin.backup.i.f)localObject).parseFrom(paramAnonymousArrayOfByte);
              ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.backup.i.f)localObject).nEQ) });
              AppMethodBeat.o(21605);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
              }
            }
          }
          if (paramAnonymousInt1 == 5)
          {
            ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
            e.this.cancel(true);
            b.bJh().bHV().nye = -100;
            e.this.tK(-100);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 51L, 1L, false);
            e.this.xE(5);
            AppMethodBeat.o(21605);
            return;
          }
          if (paramAnonymousInt1 == 18)
          {
            localObject = new com.tencent.mm.plugin.backup.i.c();
            try
            {
              ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
              ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).nIp) });
              if (((com.tencent.mm.plugin.backup.i.c)localObject).nIp == 9)
              {
                paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bJG();
                if (paramAnonymousInt1 == 1)
                {
                  com.tencent.mm.plugin.backup.g.b.xI(2);
                  ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                  e.this.xE(20);
                  com.tencent.mm.plugin.backup.g.b.bJF();
                  b.bJh().bHV().nye = 14;
                  e.this.tK(14);
                  com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b()
                  {
                    public final void iD(boolean paramAnonymous2Boolean)
                    {
                      AppMethodBeat.i(21604);
                      if (paramAnonymous2Boolean)
                      {
                        ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                        com.tencent.mm.plugin.backup.g.b.xI(0);
                        AppMethodBeat.o(21604);
                        return;
                      }
                      e.this.tK(b.bJh().bHV().nye);
                      AppMethodBeat.o(21604);
                    }
                  });
                  AppMethodBeat.o(21605);
                  return;
                }
              }
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
              }
              ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              AppMethodBeat.o(21605);
              return;
            }
          }
          if (paramAnonymousInt1 == 17) {
            localObject = new com.tencent.mm.plugin.backup.i.b();
          }
        }
        try
        {
          ((com.tencent.mm.plugin.backup.i.b)localObject).parseFrom(paramAnonymousArrayOfByte);
          ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).nIp) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).nIp == 10)
          {
            paramAnonymousInt1 = b.bJh().bHV().nye;
            ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if ((paramAnonymousInt1 == 12) || (paramAnonymousInt1 == 14))
            {
              e.this.cancel(true);
              b.bJh().bIF().stop();
              b.bJh().bHV().nye = -4;
              e.this.tK(-4);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 51L, 1L, false);
              e.this.xE(5);
              long l = 0L;
              if (e.b(e.this).nyT != 0L) {
                l = bu.DD(e.b(e.this).nyT);
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(e.this).bIn()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
              ae.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(e.this).bIn()), Long.valueOf(l / 1000L) });
            }
          }
          AppMethodBeat.o(21605);
          return;
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
          }
        }
      }
    };
    this.nyQ = new com.tencent.mm.plugin.backup.b.b.b()
    {
      public final void bHR()
      {
        AppMethodBeat.i(21610);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 11L, 1L, false);
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (e.b(e.this) == null)
        {
          l = 0L;
          localg.idkeyStat(400L, 12L, l, false);
          localg = com.tencent.mm.plugin.report.service.g.yxI;
          if (e.b(e.this) != null) {
            break label136;
          }
        }
        label136:
        for (long l = 0L;; l = e.b(e.this).bIn())
        {
          localg.idkeyStat(400L, 13L, l, false);
          e.this.xE(0);
          com.tencent.mm.plugin.backup.g.b.xH(11);
          if (!e.f(e.this)) {
            e.this.xE(21);
          }
          AppMethodBeat.o(21610);
          return;
          l = bu.DD(e.b(e.this).nyT) / 1000L;
          break;
        }
      }
      
      public final void bHS()
      {
        AppMethodBeat.i(21611);
        ae.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
        e.this.cancel(false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 120L, 1L, false);
        AppMethodBeat.o(21611);
      }
      
      public final void xu(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21609);
        final HashSet localHashSet = new HashSet();
        localHashSet.addAll(e.d(e.this));
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21607);
            Iterator localIterator = localHashSet.iterator();
            while (localIterator.hasNext()) {
              ((b.c)localIterator.next()).xu(paramAnonymousInt);
            }
            AppMethodBeat.o(21607);
          }
        });
        if (e.e(e.this) != null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21608);
              if (e.e(e.this) != null) {
                e.e(e.this).xt(paramAnonymousInt);
              }
              AppMethodBeat.o(21608);
            }
          });
        }
        AppMethodBeat.o(21609);
      }
    };
    AppMethodBeat.o(21612);
  }
  
  public static void bJs()
  {
    nDH = true;
  }
  
  public static void f(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21616);
    ae.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.bJh();
    SharedPreferences.Editor localEditor = b.bIa().edit();
    if (1 == b.bJh().bJi().nDn)
    {
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", paramInt1);
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", paramLong1);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", paramLong2);
    }
    localEditor.commit();
    AppMethodBeat.o(21616);
  }
  
  public final void H(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(21615);
    this.nBd = paramLinkedList;
    b.bJh();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.bIa().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      nBk = true;
      b.bJh();
      this.nBg = b.bIa().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.bJh();
      this.nBh = b.bIa().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.bJh();
      if (b.bIa().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label249;
      }
      nzM = true;
      if (paramLinkedList != null) {
        break label256;
      }
      i = -1;
      ae.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(nBk), Boolean.valueOf(nzM), Long.valueOf(this.nBg), Long.valueOf(this.nBh) });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IRA, Boolean.TRUE);
      if (1 == b.bJh().bJi().nDn)
      {
        b.bJh();
        localEditor = b.bIa().edit();
        if (paramLinkedList != null) {
          break label264;
        }
      }
    }
    label256:
    label264:
    for (paramLinkedList = new String[0];; paramLinkedList = (String[])paramLinkedList.toArray(new String[paramLinkedList.size()]))
    {
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", com.tencent.mm.plugin.backup.b.g.b("", ",", paramLinkedList));
      localEditor.commit();
      AppMethodBeat.o(21615);
      return;
      nBk = false;
      break;
      label249:
      nzM = false;
      break label95;
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void bHT()
  {
    AppMethodBeat.i(21619);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.nDz);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21606);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).bHT();
        }
        AppMethodBeat.o(21606);
      }
    });
    AppMethodBeat.o(21619);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21614);
    ae.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), au.foQ() });
    nDH = true;
    if (!paramBoolean)
    {
      b.bJh().bJi();
      c.bIO();
    }
    this.nBf.cancel();
    if (this.nBe != null)
    {
      this.nBe.cancel();
      this.nBe = null;
    }
    com.tencent.mm.plugin.backup.g.b.bJA();
    com.tencent.mm.plugin.backup.g.b.bJC();
    com.tencent.mm.plugin.backup.g.b.bJF();
    b.bJh().bHX();
    AppMethodBeat.o(21614);
  }
  
  public final void init()
  {
    AppMethodBeat.i(21613);
    ae.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    nDH = false;
    this.nDC = false;
    com.tencent.mm.plugin.backup.g.b.a(this.nDL);
    this.nBf = new com.tencent.mm.plugin.backup.c.c(b.bJh(), 1, this.nyQ);
    AppMethodBeat.o(21613);
  }
  
  public final void tK(int paramInt)
  {
    AppMethodBeat.i(21620);
    this.nyQ.xu(paramInt);
    AppMethodBeat.o(21620);
  }
  
  public final void tp(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(21617);
    ae.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.nAV);
    k localk = new k(b.bJh().nxW);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    bc.aCg();
    com.tencent.mm.plugin.backup.b.g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (nzM) {}
    for (;;)
    {
      localk.a(paramLong, com.tencent.mm.plugin.backup.b.g.to(localPLong2.value), i);
      ae.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.bJH();
      AppMethodBeat.o(21617);
      return;
      bc.aCg();
      if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IRG, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void xE(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(21618);
    long l2;
    if (this.nBf != null)
    {
      if (this.nBf.nyT != 0L) {
        l1 = bu.DD(this.nBf.nyT);
      }
      long l3 = this.nBf.bIn();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.bJh().bJi().nDt) });
      ae.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
      AppMethodBeat.o(21618);
      return;
      l1 = 0L;
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e
 * JD-Core Version:    0.7.0.1
 */