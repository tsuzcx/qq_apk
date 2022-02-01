package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.i;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static boolean uXO = false;
  private static boolean uZs = false;
  static boolean vbQ = false;
  private com.tencent.mm.plugin.backup.b.b.b uWR;
  final com.tencent.mm.am.h uZa;
  LinkedList<String> uZl;
  private com.tencent.mm.plugin.backup.c.b uZm;
  com.tencent.mm.plugin.backup.c.c uZn;
  private long uZo;
  private long uZp;
  public Set<b.c> vbJ;
  public b.a vbK;
  private boolean vbM;
  public boolean vbR;
  public boolean vbS;
  final com.tencent.mm.am.h vbT;
  private final b.d vbU;
  
  public e()
  {
    AppMethodBeat.i(21612);
    this.vbJ = new HashSet();
    this.vbM = false;
    this.uZo = 0L;
    this.uZp = 0L;
    this.vbR = false;
    this.vbS = false;
    this.uZa = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21602);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.uZa);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 117L, 1L, false);
          b.cVW().cUJ().uWg = -5;
          e.this.Bt(-5);
          AppMethodBeat.o(21602);
          return;
        }
        Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousp).vdC;
        if (!b.cVW().uVY.equals(paramAnonymousString.vgy))
        {
          Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 118L, 1L, false);
          b.cVW().cUJ().uWg = -5;
          e.this.Bt(-5);
          AppMethodBeat.o(21602);
          return;
        }
        b.cVW().cUJ().uWo = paramAnonymousString.vhc;
        Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.vhc) });
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acPd, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.cWo();
        e.a(e.this);
        AppMethodBeat.o(21602);
      }
    };
    this.vbT = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21603);
        com.tencent.mm.plugin.backup.g.b.b(11, e.this.vbT);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 119L, 1L, false);
          e.this.cancel(false);
          b.cVW().cUJ().uWg = -5;
          e.this.Bt(-5);
          AppMethodBeat.o(21603);
          return;
        }
        paramAnonymousString = (i)paramAnonymousp;
        paramAnonymousString = g.b(paramAnonymousString.vdq.vgP, paramAnonymousString.vdq.vgQ);
        Log.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
        paramAnonymousp = e.b(e.this);
        b.cVW().cVX();
        paramAnonymousp.a(paramAnonymousString, b.cVW().cUJ().uWo, e.uXO);
        AppMethodBeat.o(21603);
      }
    };
    this.vbU = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21605);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Boolean.valueOf(e.XU()) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label506;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.cVW().cUJ().uWg;
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
          b.cVW().cVt().stop();
          b.cVW().cUJ().uWg = -100;
          e.this.Bt(-100);
          AppMethodBeat.o(21605);
          return;
          b.cVW().cVt().stop();
          AppMethodBeat.o(21605);
          return;
          b.cVW().cVt().stop();
          b.cVW().cUJ().uWg = -100;
          e.this.Bt(-100);
          AppMethodBeat.o(21605);
          return;
          if ((b.cVW().cVX().vbA) && (!e.XU()))
          {
            paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.cWv();
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(21605);
              return;
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              e.this.Fm(19);
              e.c(e.this);
              com.tencent.mm.plugin.backup.g.b.a(b.cVW().cVX().vbF);
              AppMethodBeat.o(21605);
              return;
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            }
          }
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
          e.this.cancel(true);
          b.cVW().cVt().stop();
          b.cVW().cUJ().uWg = -4;
          e.this.Bt(-4);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 9L, 1L, false);
          e.this.Fm(3);
          AppMethodBeat.o(21605);
          return;
          e.this.cancel(true);
        }
        label506:
        Object localObject;
        if ((1 == b.cVW().cVX().vbw) || (3 == b.cVW().cVX().vbw))
        {
          if (paramAnonymousInt1 == 10)
          {
            localObject = new f();
            try
            {
              ((f)localObject).parseFrom(paramAnonymousArrayOfByte);
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((f)localObject).vda) });
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
            b.cVW().cUJ().uWg = -100;
            e.this.Bt(-100);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 51L, 1L, false);
            e.this.Fm(5);
            AppMethodBeat.o(21605);
            return;
          }
          if (paramAnonymousInt1 == 18)
          {
            localObject = new com.tencent.mm.plugin.backup.i.c();
            try
            {
              ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).vgz) });
              if (((com.tencent.mm.plugin.backup.i.c)localObject).vgz == 9)
              {
                paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.cWv();
                if (paramAnonymousInt1 == 1)
                {
                  com.tencent.mm.plugin.backup.g.b.Fq(2);
                  Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                  e.this.Fm(20);
                  com.tencent.mm.plugin.backup.g.b.cWu();
                  b.cVW().cUJ().uWg = 14;
                  e.this.Bt(14);
                  com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b()
                  {
                    public final void mc(boolean paramAnonymous2Boolean)
                    {
                      AppMethodBeat.i(21604);
                      if (paramAnonymous2Boolean)
                      {
                        Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                        com.tencent.mm.plugin.backup.g.b.Fq(0);
                        AppMethodBeat.o(21604);
                        return;
                      }
                      e.this.Bt(b.cVW().cUJ().uWg);
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
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).vgz) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).vgz == 10)
          {
            paramAnonymousInt1 = b.cVW().cUJ().uWg;
            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if ((paramAnonymousInt1 == 12) || (paramAnonymousInt1 == 14))
            {
              e.this.cancel(true);
              b.cVW().cVt().stop();
              b.cVW().cUJ().uWg = -4;
              e.this.Bt(-4);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 51L, 1L, false);
              e.this.Fm(5);
              long l = 0L;
              if (e.b(e.this).uWU != 0L) {
                l = Util.milliSecondsToNow(e.b(e.this).uWU);
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(e.this).cVb()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(e.this).cVb()), Long.valueOf(l / 1000L) });
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
    this.uWR = new com.tencent.mm.plugin.backup.b.b.b()
    {
      public final void Fc(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21609);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21607);
            Iterator localIterator = this.uZh.iterator();
            while (localIterator.hasNext()) {
              ((b.c)localIterator.next()).Fc(paramAnonymousInt);
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
                e.e(e.this).Fb(paramAnonymousInt);
              }
              AppMethodBeat.o(21608);
            }
          });
        }
        AppMethodBeat.o(21609);
      }
      
      public final void cUF()
      {
        AppMethodBeat.i(21610);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 11L, 1L, false);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (e.b(e.this) == null)
        {
          l = 0L;
          localh.idkeyStat(400L, 12L, l, false);
          localh = com.tencent.mm.plugin.report.service.h.OAn;
          if (e.b(e.this) != null) {
            break label136;
          }
        }
        label136:
        for (long l = 0L;; l = e.b(e.this).cVb())
        {
          localh.idkeyStat(400L, 13L, l, false);
          e.this.Fm(0);
          com.tencent.mm.plugin.backup.g.b.Fp(11);
          if (!e.f(e.this)) {
            e.this.Fm(21);
          }
          AppMethodBeat.o(21610);
          return;
          l = Util.milliSecondsToNow(e.b(e.this).uWU) / 1000L;
          break;
        }
      }
      
      public final void cUG()
      {
        AppMethodBeat.i(21611);
        Log.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
        e.this.cancel(false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 120L, 1L, false);
        AppMethodBeat.o(21611);
      }
    };
    AppMethodBeat.o(21612);
  }
  
  public static void cWh()
  {
    vbQ = true;
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
    b.cVW();
    SharedPreferences.Editor localEditor = b.cUO().edit();
    if (1 == b.cVW().cVX().vbw)
    {
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", paramInt1);
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", paramLong1);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", paramLong2);
    }
    localEditor.commit();
    AppMethodBeat.o(21616);
  }
  
  public final void Bt(int paramInt)
  {
    AppMethodBeat.i(21620);
    this.uWR.Fc(paramInt);
    AppMethodBeat.o(21620);
  }
  
  public final void Fm(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(21618);
    long l2;
    if (this.uZn != null)
    {
      if (this.uZn.uWU != 0L) {
        l1 = Util.milliSecondsToNow(this.uZn.uWU);
      }
      long l3 = this.uZn.cVb();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.cVW().cVX().vbC) });
      Log.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
      AppMethodBeat.o(21618);
      return;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public final void K(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(21615);
    this.uZl = paramLinkedList;
    b.cVW();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.cUO().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      uZs = true;
      b.cVW();
      this.uZo = b.cUO().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.cVW();
      this.uZp = b.cUO().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.cVW();
      if (b.cUO().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label250;
      }
      uXO = true;
      if (paramLinkedList != null) {
        break label257;
      }
      i = -1;
      Log.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(uZs), Boolean.valueOf(uXO), Long.valueOf(this.uZo), Long.valueOf(this.uZp) });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acOX, Boolean.TRUE);
      if (1 == b.cVW().cVX().vbw)
      {
        b.cVW();
        localEditor = b.cUO().edit();
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
      uZs = false;
      break;
      label250:
      uXO = false;
      break label95;
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void cUH()
  {
    AppMethodBeat.i(21619);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21606);
        Iterator localIterator = this.uZh.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).cUH();
        }
        AppMethodBeat.o(21606);
      }
    });
    AppMethodBeat.o(21619);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21614);
    Log.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), MMStack.getCaller() });
    vbQ = true;
    if (!paramBoolean)
    {
      b.cVW().cVX();
      c.cVC();
    }
    this.uZn.cancel();
    if (this.uZm != null)
    {
      this.uZm.cancel();
      this.uZm = null;
    }
    com.tencent.mm.plugin.backup.g.b.cWp();
    com.tencent.mm.plugin.backup.g.b.cWr();
    com.tencent.mm.plugin.backup.g.b.cWu();
    b.cVW().cUL();
    AppMethodBeat.o(21614);
  }
  
  public final void init()
  {
    AppMethodBeat.i(21613);
    Log.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
    vbQ = false;
    this.vbM = false;
    com.tencent.mm.plugin.backup.g.b.a(this.vbU);
    this.uZn = new com.tencent.mm.plugin.backup.c.c(b.cVW(), 1, this.uWR);
    AppMethodBeat.o(21613);
  }
  
  public final void jZ(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(21617);
    Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.uZa);
    k localk = new k(b.cVW().uVY);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    bh.bCz();
    g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (uXO) {}
    for (;;)
    {
      localk.a(paramLong, g.jY(localPLong2.value), i);
      Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.cWw();
      AppMethodBeat.o(21617);
      return;
      bh.bCz();
      if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acPd, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e
 * JD-Core Version:    0.7.0.1
 */