package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean mrR = false;
  private static boolean mtq = false;
  static boolean mvO = false;
  private com.tencent.mm.plugin.backup.b.b.b mqV;
  final com.tencent.mm.al.g mtb;
  LinkedList<String> mtj;
  private com.tencent.mm.plugin.backup.c.b mtk;
  com.tencent.mm.plugin.backup.c.c mtl;
  private long mtm;
  private long mtn;
  public Set<b.c> mvG;
  public b.a mvH;
  private boolean mvJ;
  public boolean mvP;
  public boolean mvQ;
  final com.tencent.mm.al.g mvR;
  private final b.d mvS;
  
  public e()
  {
    AppMethodBeat.i(21612);
    this.mvG = new HashSet();
    this.mvJ = false;
    this.mtm = 0L;
    this.mtn = 0L;
    this.mvP = false;
    this.mvQ = false;
    this.mtb = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21602);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.mtb);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.vKh.idkeyStat(400L, 117L, 1L, false);
          b.bxe().bvT().mqj = -5;
          e.this.sm(-5);
          AppMethodBeat.o(21602);
          return;
        }
        ad.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousn).mxz;
        if (!b.bxe().mqb.equals(paramAnonymousString.ID))
        {
          ad.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          h.vKh.idkeyStat(400L, 118L, 1L, false);
          b.bxe().bvT().mqj = -5;
          e.this.sm(-5);
          AppMethodBeat.o(21602);
          return;
        }
        b.bxe().bvT().mqr = paramAnonymousString.mBa;
        ad.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.mBa) });
        az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.Fnb, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.bxw();
        e.a(e.this);
        AppMethodBeat.o(21602);
      }
    };
    this.mvR = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21603);
        com.tencent.mm.plugin.backup.g.b.b(11, e.this.mvR);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.vKh.idkeyStat(400L, 119L, 1L, false);
          e.this.cancel(false);
          b.bxe().bvT().mqj = -5;
          e.this.sm(-5);
          AppMethodBeat.o(21603);
          return;
        }
        paramAnonymousString = (i)paramAnonymousn;
        paramAnonymousString = com.tencent.mm.plugin.backup.b.g.b(paramAnonymousString.mxn.mAM, paramAnonymousString.mxn.mAN);
        ad.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
        paramAnonymousn = e.b(e.this);
        b.bxe().bxf();
        paramAnonymousn.a(paramAnonymousString, b.bxe().bvT().mqr, e.mrR);
        AppMethodBeat.o(21603);
      }
    };
    this.mvS = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21605);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Boolean.valueOf(e.baI()) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label506;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.bxe().bvT().mqj;
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
          b.bxe().bwD().stop();
          b.bxe().bvT().mqj = -100;
          e.this.sm(-100);
          AppMethodBeat.o(21605);
          return;
          b.bxe().bwD().stop();
          AppMethodBeat.o(21605);
          return;
          b.bxe().bwD().stop();
          b.bxe().bvT().mqj = -100;
          e.this.sm(-100);
          AppMethodBeat.o(21605);
          return;
          if ((b.bxe().bxf().mvy) && (!e.baI()))
          {
            paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bxD();
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(21605);
              return;
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              e.this.wd(19);
              e.c(e.this);
              com.tencent.mm.plugin.backup.g.b.a(b.bxe().bxf().mvD);
              AppMethodBeat.o(21605);
              return;
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            }
          }
          ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
          e.this.cancel(true);
          b.bxe().bwD().stop();
          b.bxe().bvT().mqj = -4;
          e.this.sm(-4);
          h.vKh.idkeyStat(400L, 9L, 1L, false);
          e.this.wd(3);
          AppMethodBeat.o(21605);
          return;
          e.this.cancel(true);
        }
        label506:
        Object localObject;
        if ((1 == b.bxe().bxf().mvu) || (3 == b.bxe().bxf().mvu))
        {
          if (paramAnonymousInt1 == 10)
          {
            localObject = new f();
            try
            {
              ((f)localObject).parseFrom(paramAnonymousArrayOfByte);
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((f)localObject).mwX) });
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
            b.bxe().bvT().mqj = -100;
            e.this.sm(-100);
            h.vKh.idkeyStat(400L, 51L, 1L, false);
            e.this.wd(5);
            AppMethodBeat.o(21605);
            return;
          }
          if (paramAnonymousInt1 == 18)
          {
            localObject = new com.tencent.mm.plugin.backup.i.c();
            try
            {
              ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).mAw) });
              if (((com.tencent.mm.plugin.backup.i.c)localObject).mAw == 9)
              {
                paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bxD();
                if (paramAnonymousInt1 == 1)
                {
                  com.tencent.mm.plugin.backup.g.b.wh(2);
                  ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                  e.this.wd(20);
                  com.tencent.mm.plugin.backup.g.b.bxC();
                  b.bxe().bvT().mqj = 14;
                  e.this.sm(14);
                  com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b()
                  {
                    public final void hW(boolean paramAnonymous2Boolean)
                    {
                      AppMethodBeat.i(21604);
                      if (paramAnonymous2Boolean)
                      {
                        ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                        com.tencent.mm.plugin.backup.g.b.wh(0);
                        AppMethodBeat.o(21604);
                        return;
                      }
                      e.this.sm(b.bxe().bvT().mqj);
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
          ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).mAw) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).mAw == 10)
          {
            paramAnonymousInt1 = b.bxe().bvT().mqj;
            ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if ((paramAnonymousInt1 == 12) || (paramAnonymousInt1 == 14))
            {
              e.this.cancel(true);
              b.bxe().bwD().stop();
              b.bxe().bvT().mqj = -4;
              e.this.sm(-4);
              h.vKh.idkeyStat(400L, 51L, 1L, false);
              e.this.wd(5);
              long l = 0L;
              if (e.b(e.this).mqY != 0L) {
                l = bt.vM(e.b(e.this).mqY);
              }
              h.vKh.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(e.this).bwl()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
              ad.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(e.this).bwl()), Long.valueOf(l / 1000L) });
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
    this.mqV = new com.tencent.mm.plugin.backup.b.b.b()
    {
      public final void bvP()
      {
        AppMethodBeat.i(21610);
        h.vKh.idkeyStat(400L, 11L, 1L, false);
        h localh = h.vKh;
        if (e.b(e.this) == null)
        {
          l = 0L;
          localh.idkeyStat(400L, 12L, l, false);
          localh = h.vKh;
          if (e.b(e.this) != null) {
            break label136;
          }
        }
        label136:
        for (long l = 0L;; l = e.b(e.this).bwl())
        {
          localh.idkeyStat(400L, 13L, l, false);
          e.this.wd(0);
          com.tencent.mm.plugin.backup.g.b.wg(11);
          if (!e.f(e.this)) {
            e.this.wd(21);
          }
          AppMethodBeat.o(21610);
          return;
          l = bt.vM(e.b(e.this).mqY) / 1000L;
          break;
        }
      }
      
      public final void bvQ()
      {
        AppMethodBeat.i(21611);
        ad.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
        e.this.cancel(false);
        h.vKh.idkeyStat(400L, 120L, 1L, false);
        AppMethodBeat.o(21611);
      }
      
      public final void vS(final int paramAnonymousInt)
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
              ((b.c)localIterator.next()).vS(paramAnonymousInt);
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
                e.e(e.this).vR(paramAnonymousInt);
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
  
  public static void bxp()
  {
    mvO = true;
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
    b.bxe();
    SharedPreferences.Editor localEditor = b.bvY().edit();
    if (1 == b.bxe().bxf().mvu)
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
    this.mtj = paramLinkedList;
    b.bxe();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.bvY().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      mtq = true;
      b.bxe();
      this.mtm = b.bvY().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.bxe();
      this.mtn = b.bvY().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.bxe();
      if (b.bvY().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label249;
      }
      mrR = true;
      if (paramLinkedList != null) {
        break label256;
      }
      i = -1;
      ad.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(mtq), Boolean.valueOf(mrR), Long.valueOf(this.mtm), Long.valueOf(this.mtn) });
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FmV, Boolean.TRUE);
      if (1 == b.bxe().bxf().mvu)
      {
        b.bxe();
        localEditor = b.bvY().edit();
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
      mtq = false;
      break;
      label249:
      mrR = false;
      break label95;
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void bvR()
  {
    AppMethodBeat.i(21619);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.mvG);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21606);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).bvR();
        }
        AppMethodBeat.o(21606);
      }
    });
    AppMethodBeat.o(21619);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21614);
    ad.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), at.eFT() });
    mvO = true;
    if (!paramBoolean)
    {
      b.bxe().bxf();
      c.bwM();
    }
    this.mtl.cancel();
    if (this.mtk != null)
    {
      this.mtk.cancel();
      this.mtk = null;
    }
    com.tencent.mm.plugin.backup.g.b.bxx();
    com.tencent.mm.plugin.backup.g.b.bxz();
    com.tencent.mm.plugin.backup.g.b.bxC();
    b.bxe().bvV();
    AppMethodBeat.o(21614);
  }
  
  public final void init()
  {
    AppMethodBeat.i(21613);
    ad.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    mvO = false;
    this.mvJ = false;
    com.tencent.mm.plugin.backup.g.b.a(this.mvS);
    this.mtl = new com.tencent.mm.plugin.backup.c.c(b.bxe(), 1, this.mqV);
    AppMethodBeat.o(21613);
  }
  
  public final void nq(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(21617);
    ad.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.mtb);
    k localk = new k(b.bxe().mqb);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    az.arV();
    com.tencent.mm.plugin.backup.b.g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (mrR) {}
    for (;;)
    {
      localk.a(paramLong, com.tencent.mm.plugin.backup.b.g.np(localPLong2.value), i);
      ad.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.bxE();
      AppMethodBeat.o(21617);
      return;
      az.arV();
      if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fnb, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void sm(int paramInt)
  {
    AppMethodBeat.i(21620);
    this.mqV.vS(paramInt);
    AppMethodBeat.o(21620);
  }
  
  public final void wd(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(21618);
    long l2;
    if (this.mtl != null)
    {
      if (this.mtl.mqY != 0L) {
        l1 = bt.vM(this.mtl.mqY);
      }
      long l3 = this.mtl.bwl();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      h.vKh.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.bxe().bxf().mvA) });
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