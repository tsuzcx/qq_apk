package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.i;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean mTT = false;
  private static boolean mVs = false;
  static boolean mXP = false;
  private com.tencent.mm.plugin.backup.b.b.b mSX;
  final com.tencent.mm.ak.g mVd;
  LinkedList<String> mVl;
  private com.tencent.mm.plugin.backup.c.b mVm;
  com.tencent.mm.plugin.backup.c.c mVn;
  private long mVo;
  private long mVp;
  public Set<b.c> mXH;
  public b.a mXI;
  private boolean mXK;
  public boolean mXQ;
  public boolean mXR;
  final com.tencent.mm.ak.g mXS;
  private final b.d mXT;
  
  public e()
  {
    AppMethodBeat.i(21612);
    this.mXH = new HashSet();
    this.mXK = false;
    this.mVo = 0L;
    this.mVp = 0L;
    this.mXQ = false;
    this.mXR = false;
    this.mVd = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21602);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.mVd);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.wUl.idkeyStat(400L, 117L, 1L, false);
          b.bEa().bCP().mSk = -5;
          e.this.tc(-5);
          AppMethodBeat.o(21602);
          return;
        }
        ac.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousn).mZA;
        if (!b.bEa().mSc.equals(paramAnonymousString.ID))
        {
          ac.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          h.wUl.idkeyStat(400L, 118L, 1L, false);
          b.bEa().bCP().mSk = -5;
          e.this.tc(-5);
          AppMethodBeat.o(21602);
          return;
        }
        b.bEa().bCP().mSt = paramAnonymousString.ndb;
        ac.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.ndb) });
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GKQ, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.bEs();
        e.a(e.this);
        AppMethodBeat.o(21602);
      }
    };
    this.mXS = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21603);
        com.tencent.mm.plugin.backup.g.b.b(11, e.this.mXS);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.wUl.idkeyStat(400L, 119L, 1L, false);
          e.this.cancel(false);
          b.bEa().bCP().mSk = -5;
          e.this.tc(-5);
          AppMethodBeat.o(21603);
          return;
        }
        paramAnonymousString = (i)paramAnonymousn;
        paramAnonymousString = com.tencent.mm.plugin.backup.b.g.b(paramAnonymousString.mZo.ncN, paramAnonymousString.mZo.ncO);
        ac.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
        paramAnonymousn = e.b(e.this);
        b.bEa().bEb();
        paramAnonymousn.a(paramAnonymousString, b.bEa().bCP().mSt, e.mTT);
        AppMethodBeat.o(21603);
      }
    };
    this.mXT = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21605);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Boolean.valueOf(e.bhB()) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label506;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.bEa().bCP().mSk;
            ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          b.bEa().bDz().stop();
          b.bEa().bCP().mSk = -100;
          e.this.tc(-100);
          AppMethodBeat.o(21605);
          return;
          b.bEa().bDz().stop();
          AppMethodBeat.o(21605);
          return;
          b.bEa().bDz().stop();
          b.bEa().bCP().mSk = -100;
          e.this.tc(-100);
          AppMethodBeat.o(21605);
          return;
          if ((b.bEa().bEb().mXz) && (!e.bhB()))
          {
            paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bEz();
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(21605);
              return;
              ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              e.this.wU(19);
              e.c(e.this);
              com.tencent.mm.plugin.backup.g.b.a(b.bEa().bEb().mXE);
              AppMethodBeat.o(21605);
              return;
              ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            }
          }
          ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
          e.this.cancel(true);
          b.bEa().bDz().stop();
          b.bEa().bCP().mSk = -4;
          e.this.tc(-4);
          h.wUl.idkeyStat(400L, 9L, 1L, false);
          e.this.wU(3);
          AppMethodBeat.o(21605);
          return;
          e.this.cancel(true);
        }
        label506:
        Object localObject;
        if ((1 == b.bEa().bEb().mXv) || (3 == b.bEa().bEb().mXv))
        {
          if (paramAnonymousInt1 == 10)
          {
            localObject = new f();
            try
            {
              ((f)localObject).parseFrom(paramAnonymousArrayOfByte);
              ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((f)localObject).mYY) });
              AppMethodBeat.o(21605);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
              }
            }
          }
          if (paramAnonymousInt1 == 5)
          {
            ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
            e.this.cancel(true);
            b.bEa().bCP().mSk = -100;
            e.this.tc(-100);
            h.wUl.idkeyStat(400L, 51L, 1L, false);
            e.this.wU(5);
            AppMethodBeat.o(21605);
            return;
          }
          if (paramAnonymousInt1 == 18)
          {
            localObject = new com.tencent.mm.plugin.backup.i.c();
            try
            {
              ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
              ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).ncx) });
              if (((com.tencent.mm.plugin.backup.i.c)localObject).ncx == 9)
              {
                paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bEz();
                if (paramAnonymousInt1 == 1)
                {
                  com.tencent.mm.plugin.backup.g.b.wY(2);
                  ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                  e.this.wU(20);
                  com.tencent.mm.plugin.backup.g.b.bEy();
                  b.bEa().bCP().mSk = 14;
                  e.this.tc(14);
                  com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b()
                  {
                    public final void iw(boolean paramAnonymous2Boolean)
                    {
                      AppMethodBeat.i(21604);
                      if (paramAnonymous2Boolean)
                      {
                        ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                        com.tencent.mm.plugin.backup.g.b.wY(0);
                        AppMethodBeat.o(21604);
                        return;
                      }
                      e.this.tc(b.bEa().bCP().mSk);
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
                ac.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
              }
              ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).ncx) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).ncx == 10)
          {
            paramAnonymousInt1 = b.bEa().bCP().mSk;
            ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if ((paramAnonymousInt1 == 12) || (paramAnonymousInt1 == 14))
            {
              e.this.cancel(true);
              b.bEa().bDz().stop();
              b.bEa().bCP().mSk = -4;
              e.this.tc(-4);
              h.wUl.idkeyStat(400L, 51L, 1L, false);
              e.this.wU(5);
              long l = 0L;
              if (e.b(e.this).mTa != 0L) {
                l = bs.Ap(e.b(e.this).mTa);
              }
              h.wUl.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(e.this).bDh()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
              ac.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(e.this).bDh()), Long.valueOf(l / 1000L) });
            }
          }
          AppMethodBeat.o(21605);
          return;
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.BackupPcServer", paramAnonymousArrayOfByte, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
          }
        }
      }
    };
    this.mSX = new com.tencent.mm.plugin.backup.b.b.b()
    {
      public final void bCL()
      {
        AppMethodBeat.i(21610);
        h.wUl.idkeyStat(400L, 11L, 1L, false);
        h localh = h.wUl;
        if (e.b(e.this) == null)
        {
          l = 0L;
          localh.idkeyStat(400L, 12L, l, false);
          localh = h.wUl;
          if (e.b(e.this) != null) {
            break label136;
          }
        }
        label136:
        for (long l = 0L;; l = e.b(e.this).bDh())
        {
          localh.idkeyStat(400L, 13L, l, false);
          e.this.wU(0);
          com.tencent.mm.plugin.backup.g.b.wX(11);
          if (!e.f(e.this)) {
            e.this.wU(21);
          }
          AppMethodBeat.o(21610);
          return;
          l = bs.Ap(e.b(e.this).mTa) / 1000L;
          break;
        }
      }
      
      public final void bCM()
      {
        AppMethodBeat.i(21611);
        ac.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
        e.this.cancel(false);
        h.wUl.idkeyStat(400L, 120L, 1L, false);
        AppMethodBeat.o(21611);
      }
      
      public final void wJ(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21609);
        final HashSet localHashSet = new HashSet();
        localHashSet.addAll(e.d(e.this));
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21607);
            Iterator localIterator = localHashSet.iterator();
            while (localIterator.hasNext()) {
              ((b.c)localIterator.next()).wJ(paramAnonymousInt);
            }
            AppMethodBeat.o(21607);
          }
        });
        if (e.e(e.this) != null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21608);
              if (e.e(e.this) != null) {
                e.e(e.this).wI(paramAnonymousInt);
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
  
  public static void bEl()
  {
    mXP = true;
  }
  
  public static void f(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21616);
    ac.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.bEa();
    SharedPreferences.Editor localEditor = b.bCU().edit();
    if (1 == b.bEa().bEb().mXv)
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
    this.mVl = paramLinkedList;
    b.bEa();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.bCU().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      mVs = true;
      b.bEa();
      this.mVo = b.bCU().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.bEa();
      this.mVp = b.bCU().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.bEa();
      if (b.bCU().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label249;
      }
      mTT = true;
      if (paramLinkedList != null) {
        break label256;
      }
      i = -1;
      ac.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(mVs), Boolean.valueOf(mTT), Long.valueOf(this.mVo), Long.valueOf(this.mVp) });
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GKK, Boolean.TRUE);
      if (1 == b.bEa().bEb().mXv)
      {
        b.bEa();
        localEditor = b.bCU().edit();
        if (paramLinkedList != null) {
          break label264;
        }
      }
    }
    label256:
    label264:
    for (paramLinkedList = new String[0];; paramLinkedList = (String[])paramLinkedList.toArray(new String[paramLinkedList.size()]))
    {
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", com.tencent.mm.plugin.backup.b.g.a("", ",", paramLinkedList));
      localEditor.commit();
      AppMethodBeat.o(21615);
      return;
      mVs = false;
      break;
      label249:
      mTT = false;
      break label95;
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void bCN()
  {
    AppMethodBeat.i(21619);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.mXH);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21606);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).bCN();
        }
        AppMethodBeat.o(21606);
      }
    });
    AppMethodBeat.o(21619);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21614);
    ac.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), as.eVo() });
    mXP = true;
    if (!paramBoolean)
    {
      b.bEa().bEb();
      c.bDI();
    }
    this.mVn.cancel();
    if (this.mVm != null)
    {
      this.mVm.cancel();
      this.mVm = null;
    }
    com.tencent.mm.plugin.backup.g.b.bEt();
    com.tencent.mm.plugin.backup.g.b.bEv();
    com.tencent.mm.plugin.backup.g.b.bEy();
    b.bEa().bCR();
    AppMethodBeat.o(21614);
  }
  
  public final void init()
  {
    AppMethodBeat.i(21613);
    ac.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    mXP = false;
    this.mXK = false;
    com.tencent.mm.plugin.backup.g.b.a(this.mXT);
    this.mVn = new com.tencent.mm.plugin.backup.c.c(b.bEa(), 1, this.mSX);
    AppMethodBeat.o(21613);
  }
  
  public final void rc(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(21617);
    ac.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.mVd);
    k localk = new k(b.bEa().mSc);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    az.ayM();
    com.tencent.mm.plugin.backup.b.g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (mTT) {}
    for (;;)
    {
      localk.a(paramLong, com.tencent.mm.plugin.backup.b.g.rb(localPLong2.value), i);
      ac.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.bEA();
      AppMethodBeat.o(21617);
      return;
      az.ayM();
      if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKQ, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void tc(int paramInt)
  {
    AppMethodBeat.i(21620);
    this.mSX.wJ(paramInt);
    AppMethodBeat.o(21620);
  }
  
  public final void wU(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(21618);
    long l2;
    if (this.mVn != null)
    {
      if (this.mVn.mTa != 0L) {
        l1 = bs.Ap(this.mVn.mTa);
      }
      long l3 = this.mVn.bDh();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      h.wUl.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.bEa().bEb().mXB) });
      ac.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
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