package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean nur = false;
  private static boolean nvP = false;
  static boolean nym = false;
  private com.tencent.mm.plugin.backup.b.b.b ntv;
  final com.tencent.mm.al.f nvA;
  LinkedList<String> nvI;
  private com.tencent.mm.plugin.backup.c.b nvJ;
  com.tencent.mm.plugin.backup.c.c nvK;
  private long nvL;
  private long nvM;
  public Set<b.c> nye;
  public b.a nyf;
  private boolean nyh;
  public boolean nyn;
  public boolean nyo;
  final com.tencent.mm.al.f nyp;
  private final b.d nyq;
  
  public e()
  {
    AppMethodBeat.i(21612);
    this.nye = new HashSet();
    this.nyh = false;
    this.nvL = 0L;
    this.nvM = 0L;
    this.nyn = false;
    this.nyo = false;
    this.nvA = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21602);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.nvA);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 117L, 1L, false);
          b.bIj().bGX().nsJ = -5;
          e.this.tF(-5);
          AppMethodBeat.o(21602);
          return;
        }
        ad.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousn).nzX;
        if (!b.bIj().nsB.equals(paramAnonymousString.ID))
        {
          ad.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 118L, 1L, false);
          b.bIj().bGX().nsJ = -5;
          e.this.tF(-5);
          AppMethodBeat.o(21602);
          return;
        }
        b.bIj().bGX().nsR = paramAnonymousString.nDy;
        ad.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.nDy) });
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.Ixi, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.bIB();
        e.a(e.this);
        AppMethodBeat.o(21602);
      }
    };
    this.nyp = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21603);
        com.tencent.mm.plugin.backup.g.b.b(11, e.this.nyp);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 119L, 1L, false);
          e.this.cancel(false);
          b.bIj().bGX().nsJ = -5;
          e.this.tF(-5);
          AppMethodBeat.o(21603);
          return;
        }
        paramAnonymousString = (i)paramAnonymousn;
        paramAnonymousString = com.tencent.mm.plugin.backup.b.g.b(paramAnonymousString.nzL.nDk, paramAnonymousString.nzL.nDl);
        ad.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
        paramAnonymousn = e.b(e.this);
        b.bIj().bIk();
        paramAnonymousn.a(paramAnonymousString, b.bIj().bGX().nsR, e.nur);
        AppMethodBeat.o(21603);
      }
    };
    this.nyq = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21605);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Boolean.valueOf(e.bli()) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label506;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.bIj().bGX().nsJ;
            ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          b.bIj().bHH().stop();
          b.bIj().bGX().nsJ = -100;
          e.this.tF(-100);
          AppMethodBeat.o(21605);
          return;
          b.bIj().bHH().stop();
          AppMethodBeat.o(21605);
          return;
          b.bIj().bHH().stop();
          b.bIj().bGX().nsJ = -100;
          e.this.tF(-100);
          AppMethodBeat.o(21605);
          return;
          if ((b.bIj().bIk().nxW) && (!e.bli()))
          {
            paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bII();
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(21605);
              return;
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              e.this.xA(19);
              e.c(e.this);
              com.tencent.mm.plugin.backup.g.b.a(b.bIj().bIk().nyb);
              AppMethodBeat.o(21605);
              return;
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            }
          }
          ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
          e.this.cancel(true);
          b.bIj().bHH().stop();
          b.bIj().bGX().nsJ = -4;
          e.this.tF(-4);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 9L, 1L, false);
          e.this.xA(3);
          AppMethodBeat.o(21605);
          return;
          e.this.cancel(true);
        }
        label506:
        Object localObject;
        if ((1 == b.bIj().bIk().nxS) || (3 == b.bIj().bIk().nxS))
        {
          if (paramAnonymousInt1 == 10)
          {
            localObject = new com.tencent.mm.plugin.backup.i.f();
            try
            {
              ((com.tencent.mm.plugin.backup.i.f)localObject).parseFrom(paramAnonymousArrayOfByte);
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.backup.i.f)localObject).nzv) });
              AppMethodBeat.o(21605);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
              }
            }
          }
          if (paramAnonymousInt1 == 5)
          {
            ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
            e.this.cancel(true);
            b.bIj().bGX().nsJ = -100;
            e.this.tF(-100);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 51L, 1L, false);
            e.this.xA(5);
            AppMethodBeat.o(21605);
            return;
          }
          if (paramAnonymousInt1 == 18)
          {
            localObject = new com.tencent.mm.plugin.backup.i.c();
            try
            {
              ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).nCU) });
              if (((com.tencent.mm.plugin.backup.i.c)localObject).nCU == 9)
              {
                paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bII();
                if (paramAnonymousInt1 == 1)
                {
                  com.tencent.mm.plugin.backup.g.b.xE(2);
                  ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                  e.this.xA(20);
                  com.tencent.mm.plugin.backup.g.b.bIH();
                  b.bIj().bGX().nsJ = 14;
                  e.this.tF(14);
                  com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b()
                  {
                    public final void iF(boolean paramAnonymous2Boolean)
                    {
                      AppMethodBeat.i(21604);
                      if (paramAnonymous2Boolean)
                      {
                        ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                        com.tencent.mm.plugin.backup.g.b.xE(0);
                        AppMethodBeat.o(21604);
                        return;
                      }
                      e.this.tF(b.bIj().bGX().nsJ);
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
                ad.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
              }
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).nCU) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).nCU == 10)
          {
            paramAnonymousInt1 = b.bIj().bGX().nsJ;
            ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if ((paramAnonymousInt1 == 12) || (paramAnonymousInt1 == 14))
            {
              e.this.cancel(true);
              b.bIj().bHH().stop();
              b.bIj().bGX().nsJ = -4;
              e.this.tF(-4);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 51L, 1L, false);
              e.this.xA(5);
              long l = 0L;
              if (e.b(e.this).nty != 0L) {
                l = bt.Df(e.b(e.this).nty);
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(e.this).bHp()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(e.this).bHp()), Long.valueOf(l / 1000L) });
            }
          }
          AppMethodBeat.o(21605);
          return;
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
          }
        }
      }
    };
    this.ntv = new com.tencent.mm.plugin.backup.b.b.b()
    {
      public final void bGT()
      {
        AppMethodBeat.i(21610);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 11L, 1L, false);
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (e.b(e.this) == null)
        {
          l = 0L;
          localg.idkeyStat(400L, 12L, l, false);
          localg = com.tencent.mm.plugin.report.service.g.yhR;
          if (e.b(e.this) != null) {
            break label136;
          }
        }
        label136:
        for (long l = 0L;; l = e.b(e.this).bHp())
        {
          localg.idkeyStat(400L, 13L, l, false);
          e.this.xA(0);
          com.tencent.mm.plugin.backup.g.b.xD(11);
          if (!e.f(e.this)) {
            e.this.xA(21);
          }
          AppMethodBeat.o(21610);
          return;
          l = bt.Df(e.b(e.this).nty) / 1000L;
          break;
        }
      }
      
      public final void bGU()
      {
        AppMethodBeat.i(21611);
        ad.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
        e.this.cancel(false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 120L, 1L, false);
        AppMethodBeat.o(21611);
      }
      
      public final void xp(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21609);
        final HashSet localHashSet = new HashSet();
        localHashSet.addAll(e.d(e.this));
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21607);
            Iterator localIterator = localHashSet.iterator();
            while (localIterator.hasNext()) {
              ((b.c)localIterator.next()).xp(paramAnonymousInt);
            }
            AppMethodBeat.o(21607);
          }
        });
        if (e.e(e.this) != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21608);
              if (e.e(e.this) != null) {
                e.e(e.this).xo(paramAnonymousInt);
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
  
  public static void bIu()
  {
    nym = true;
  }
  
  public static void f(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21616);
    ad.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.bIj();
    SharedPreferences.Editor localEditor = b.bHc().edit();
    if (1 == b.bIj().bIk().nxS)
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
    this.nvI = paramLinkedList;
    b.bIj();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.bHc().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      nvP = true;
      b.bIj();
      this.nvL = b.bHc().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.bIj();
      this.nvM = b.bHc().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.bIj();
      if (b.bHc().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label249;
      }
      nur = true;
      if (paramLinkedList != null) {
        break label256;
      }
      i = -1;
      ad.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(nvP), Boolean.valueOf(nur), Long.valueOf(this.nvL), Long.valueOf(this.nvM) });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixc, Boolean.TRUE);
      if (1 == b.bIj().bIk().nxS)
      {
        b.bIj();
        localEditor = b.bHc().edit();
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
      nvP = false;
      break;
      label249:
      nur = false;
      break label95;
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void bGV()
  {
    AppMethodBeat.i(21619);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.nye);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21606);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).bGV();
        }
        AppMethodBeat.o(21606);
      }
    });
    AppMethodBeat.o(21619);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21614);
    ad.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), at.fkV() });
    nym = true;
    if (!paramBoolean)
    {
      b.bIj().bIk();
      c.bHQ();
    }
    this.nvK.cancel();
    if (this.nvJ != null)
    {
      this.nvJ.cancel();
      this.nvJ = null;
    }
    com.tencent.mm.plugin.backup.g.b.bIC();
    com.tencent.mm.plugin.backup.g.b.bIE();
    com.tencent.mm.plugin.backup.g.b.bIH();
    b.bIj().bGZ();
    AppMethodBeat.o(21614);
  }
  
  public final void init()
  {
    AppMethodBeat.i(21613);
    ad.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    nym = false;
    this.nyh = false;
    com.tencent.mm.plugin.backup.g.b.a(this.nyq);
    this.nvK = new com.tencent.mm.plugin.backup.c.c(b.bIj(), 1, this.ntv);
    AppMethodBeat.o(21613);
  }
  
  public final void tF(int paramInt)
  {
    AppMethodBeat.i(21620);
    this.ntv.xp(paramInt);
    AppMethodBeat.o(21620);
  }
  
  public final void tb(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(21617);
    ad.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.nvA);
    k localk = new k(b.bIj().nsB);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    ba.aBQ();
    com.tencent.mm.plugin.backup.b.g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (nur) {}
    for (;;)
    {
      localk.a(paramLong, com.tencent.mm.plugin.backup.b.g.ta(localPLong2.value), i);
      ad.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.bIJ();
      AppMethodBeat.o(21617);
      return;
      ba.aBQ();
      if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixi, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void xA(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(21618);
    long l2;
    if (this.nvK != null)
    {
      if (this.nvK.nty != 0L) {
        l1 = bt.Df(this.nvK.nty);
      }
      long l3 = this.nvK.bHp();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.bIj().bIk().nxY) });
      ad.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
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