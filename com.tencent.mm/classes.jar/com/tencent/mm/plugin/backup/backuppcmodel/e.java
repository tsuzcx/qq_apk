package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean rMB = false;
  private static boolean rOe = false;
  static boolean rQB = false;
  private com.tencent.mm.plugin.backup.b.b.b rLE;
  final com.tencent.mm.an.i rNM;
  LinkedList<String> rNX;
  private com.tencent.mm.plugin.backup.c.b rNY;
  com.tencent.mm.plugin.backup.c.c rNZ;
  private long rOa;
  private long rOb;
  public boolean rQC;
  public boolean rQD;
  final com.tencent.mm.an.i rQE;
  private final b.d rQF;
  public Set<b.c> rQu;
  public b.a rQv;
  private boolean rQx;
  
  public e()
  {
    AppMethodBeat.i(21612);
    this.rQu = new HashSet();
    this.rQx = false;
    this.rOa = 0L;
    this.rOb = 0L;
    this.rQC = false;
    this.rQD = false;
    this.rNM = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21602);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.rNM);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.IzE.idkeyStat(400L, 117L, 1L, false);
          b.ctm().crZ().rKS = -5;
          e.this.Bg(-5);
          AppMethodBeat.o(21602);
          return;
        }
        Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousq).rSm;
        if (!b.ctm().rKK.equals(paramAnonymousString.ID))
        {
          Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          h.IzE.idkeyStat(400L, 118L, 1L, false);
          b.ctm().crZ().rKS = -5;
          e.this.Bg(-5);
          AppMethodBeat.o(21602);
          return;
        }
        b.ctm().crZ().rLa = paramAnonymousString.rVM;
        Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.rVM) });
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.VnI, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.ctE();
        e.a(e.this);
        AppMethodBeat.o(21602);
      }
    };
    this.rQE = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21603);
        com.tencent.mm.plugin.backup.g.b.b(11, e.this.rQE);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.IzE.idkeyStat(400L, 119L, 1L, false);
          e.this.cancel(false);
          b.ctm().crZ().rKS = -5;
          e.this.Bg(-5);
          AppMethodBeat.o(21603);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.i)paramAnonymousq;
        paramAnonymousString = g.b(paramAnonymousString.rSa.rVz, paramAnonymousString.rSa.rVA);
        Log.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
        paramAnonymousq = e.b(e.this);
        b.ctm().ctn();
        paramAnonymousq.a(paramAnonymousString, b.ctm().crZ().rLa, e.rMB);
        AppMethodBeat.o(21603);
      }
    };
    this.rQF = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21605);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Boolean.valueOf(e.bSX()) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label506;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.ctm().crZ().rKS;
            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          b.ctm().csJ().stop();
          b.ctm().crZ().rKS = -100;
          e.this.Bg(-100);
          AppMethodBeat.o(21605);
          return;
          b.ctm().csJ().stop();
          AppMethodBeat.o(21605);
          return;
          b.ctm().csJ().stop();
          b.ctm().crZ().rKS = -100;
          e.this.Bg(-100);
          AppMethodBeat.o(21605);
          return;
          if ((b.ctm().ctn().rQl) && (!e.bSX()))
          {
            paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.ctL();
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(21605);
              return;
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              e.this.EL(19);
              e.c(e.this);
              com.tencent.mm.plugin.backup.g.b.a(b.ctm().ctn().rQq);
              AppMethodBeat.o(21605);
              return;
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            }
          }
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
          e.this.cancel(true);
          b.ctm().csJ().stop();
          b.ctm().crZ().rKS = -4;
          e.this.Bg(-4);
          h.IzE.idkeyStat(400L, 9L, 1L, false);
          e.this.EL(3);
          AppMethodBeat.o(21605);
          return;
          e.this.cancel(true);
        }
        label506:
        Object localObject;
        if ((1 == b.ctm().ctn().rQh) || (3 == b.ctm().ctn().rQh))
        {
          if (paramAnonymousInt1 == 10)
          {
            localObject = new f();
            try
            {
              ((f)localObject).parseFrom(paramAnonymousArrayOfByte);
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((f)localObject).rRK) });
              AppMethodBeat.o(21605);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
              }
            }
          }
          if (paramAnonymousInt1 == 5)
          {
            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
            e.this.cancel(true);
            b.ctm().crZ().rKS = -100;
            e.this.Bg(-100);
            h.IzE.idkeyStat(400L, 51L, 1L, false);
            e.this.EL(5);
            AppMethodBeat.o(21605);
            return;
          }
          if (paramAnonymousInt1 == 18)
          {
            localObject = new com.tencent.mm.plugin.backup.i.c();
            try
            {
              ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).rVj) });
              if (((com.tencent.mm.plugin.backup.i.c)localObject).rVj == 9)
              {
                paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.ctL();
                if (paramAnonymousInt1 == 1)
                {
                  com.tencent.mm.plugin.backup.g.b.EP(2);
                  Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                  e.this.EL(20);
                  com.tencent.mm.plugin.backup.g.b.ctK();
                  b.ctm().crZ().rKS = 14;
                  e.this.Bg(14);
                  com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b()
                  {
                    public final void kP(boolean paramAnonymous2Boolean)
                    {
                      AppMethodBeat.i(21604);
                      if (paramAnonymous2Boolean)
                      {
                        Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                        com.tencent.mm.plugin.backup.g.b.EP(0);
                        AppMethodBeat.o(21604);
                        return;
                      }
                      e.this.Bg(b.ctm().crZ().rKS);
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
                Log.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
              }
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).rVj) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).rVj == 10)
          {
            paramAnonymousInt1 = b.ctm().crZ().rKS;
            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if ((paramAnonymousInt1 == 12) || (paramAnonymousInt1 == 14))
            {
              e.this.cancel(true);
              b.ctm().csJ().stop();
              b.ctm().crZ().rKS = -4;
              e.this.Bg(-4);
              h.IzE.idkeyStat(400L, 51L, 1L, false);
              e.this.EL(5);
              long l = 0L;
              if (e.b(e.this).rLH != 0L) {
                l = Util.milliSecondsToNow(e.b(e.this).rLH);
              }
              h.IzE.a(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(e.this).csr()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(e.this).csr()), Long.valueOf(l / 1000L) });
            }
          }
          AppMethodBeat.o(21605);
          return;
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
          }
        }
      }
    };
    this.rLE = new com.tencent.mm.plugin.backup.b.b.b()
    {
      public final void EB(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21609);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21607);
            Iterator localIterator = this.rNT.iterator();
            while (localIterator.hasNext()) {
              ((b.c)localIterator.next()).EB(paramAnonymousInt);
            }
            AppMethodBeat.o(21607);
          }
        });
        if (e.e(e.this) != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21608);
              if (e.e(e.this) != null) {
                e.e(e.this).EA(paramAnonymousInt);
              }
              AppMethodBeat.o(21608);
            }
          });
        }
        AppMethodBeat.o(21609);
      }
      
      public final void crV()
      {
        AppMethodBeat.i(21610);
        h.IzE.idkeyStat(400L, 11L, 1L, false);
        h localh = h.IzE;
        if (e.b(e.this) == null)
        {
          l = 0L;
          localh.idkeyStat(400L, 12L, l, false);
          localh = h.IzE;
          if (e.b(e.this) != null) {
            break label136;
          }
        }
        label136:
        for (long l = 0L;; l = e.b(e.this).csr())
        {
          localh.idkeyStat(400L, 13L, l, false);
          e.this.EL(0);
          com.tencent.mm.plugin.backup.g.b.EO(11);
          if (!e.f(e.this)) {
            e.this.EL(21);
          }
          AppMethodBeat.o(21610);
          return;
          l = Util.milliSecondsToNow(e.b(e.this).rLH) / 1000L;
          break;
        }
      }
      
      public final void crW()
      {
        AppMethodBeat.i(21611);
        Log.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
        e.this.cancel(false);
        h.IzE.idkeyStat(400L, 120L, 1L, false);
        AppMethodBeat.o(21611);
      }
    };
    AppMethodBeat.o(21612);
  }
  
  public static void ctx()
  {
    rQB = true;
  }
  
  public static void f(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21616);
    Log.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.ctm();
    SharedPreferences.Editor localEditor = b.cse().edit();
    if (1 == b.ctm().ctn().rQh)
    {
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", paramInt1);
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", paramLong1);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", paramLong2);
    }
    localEditor.commit();
    AppMethodBeat.o(21616);
  }
  
  public final void Bg(int paramInt)
  {
    AppMethodBeat.i(21620);
    this.rLE.EB(paramInt);
    AppMethodBeat.o(21620);
  }
  
  public final void EL(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(21618);
    long l2;
    if (this.rNZ != null)
    {
      if (this.rNZ.rLH != 0L) {
        l1 = Util.milliSecondsToNow(this.rNZ.rLH);
      }
      long l3 = this.rNZ.csr();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      h.IzE.a(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.ctm().ctn().rQn) });
      Log.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
      AppMethodBeat.o(21618);
      return;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public final void H(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(21615);
    this.rNX = paramLinkedList;
    b.ctm();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.cse().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      rOe = true;
      b.ctm();
      this.rOa = b.cse().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.ctm();
      this.rOb = b.cse().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.ctm();
      if (b.cse().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label250;
      }
      rMB = true;
      if (paramLinkedList != null) {
        break label257;
      }
      i = -1;
      Log.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(rOe), Boolean.valueOf(rMB), Long.valueOf(this.rOa), Long.valueOf(this.rOb) });
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnC, Boolean.TRUE);
      if (1 == b.ctm().ctn().rQh)
      {
        b.ctm();
        localEditor = b.cse().edit();
        if (paramLinkedList != null) {
          break label265;
        }
      }
    }
    label257:
    label265:
    for (paramLinkedList = new String[0];; paramLinkedList = (String[])paramLinkedList.toArray(new String[paramLinkedList.size()]))
    {
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", g.c("", ",", paramLinkedList));
      localEditor.commit();
      AppMethodBeat.o(21615);
      return;
      rOe = false;
      break;
      label250:
      rMB = false;
      break label95;
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void HI(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(21617);
    Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.rNM);
    k localk = new k(b.ctm().rKK);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    bh.beI();
    g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (rMB) {}
    for (;;)
    {
      localk.a(paramLong, g.HH(localPLong2.value), i);
      Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.ctM();
      AppMethodBeat.o(21617);
      return;
      bh.beI();
      if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnI, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21614);
    Log.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), MMStack.getCaller() });
    rQB = true;
    if (!paramBoolean)
    {
      b.ctm().ctn();
      c.csS();
    }
    this.rNZ.cancel();
    if (this.rNY != null)
    {
      this.rNY.cancel();
      this.rNY = null;
    }
    com.tencent.mm.plugin.backup.g.b.ctF();
    com.tencent.mm.plugin.backup.g.b.ctH();
    com.tencent.mm.plugin.backup.g.b.ctK();
    b.ctm().csb();
    AppMethodBeat.o(21614);
  }
  
  public final void crX()
  {
    AppMethodBeat.i(21619);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21606);
        Iterator localIterator = this.rNT.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).crX();
        }
        AppMethodBeat.o(21606);
      }
    });
    AppMethodBeat.o(21619);
  }
  
  public final void init()
  {
    AppMethodBeat.i(21613);
    Log.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    rQB = false;
    this.rQx = false;
    com.tencent.mm.plugin.backup.g.b.a(this.rQF);
    this.rNZ = new com.tencent.mm.plugin.backup.c.c(b.ctm(), 1, this.rLE);
    AppMethodBeat.o(21613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e
 * JD-Core Version:    0.7.0.1
 */