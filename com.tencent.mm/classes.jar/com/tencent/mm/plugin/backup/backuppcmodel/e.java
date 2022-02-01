package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
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
  private static boolean oKK = false;
  private static boolean oMj = false;
  static boolean oOE = false;
  private com.tencent.mm.plugin.backup.b.b.b oJO;
  final com.tencent.mm.ak.i oLU;
  LinkedList<String> oMc;
  private com.tencent.mm.plugin.backup.c.b oMd;
  com.tencent.mm.plugin.backup.c.c oMe;
  private long oMf;
  private long oMg;
  public boolean oOF;
  public boolean oOG;
  final com.tencent.mm.ak.i oOH;
  private final b.d oOI;
  public Set<b.c> oOw;
  public b.a oOx;
  private boolean oOz;
  
  public e()
  {
    AppMethodBeat.i(21612);
    this.oOw = new HashSet();
    this.oOz = false;
    this.oMf = 0L;
    this.oMg = 0L;
    this.oOF = false;
    this.oOG = false;
    this.oLU = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21602);
        com.tencent.mm.plugin.backup.g.b.b(3, e.this.oLU);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.CyF.idkeyStat(400L, 117L, 1L, false);
          b.cga().ceM().oJc = -5;
          e.this.xI(-5);
          AppMethodBeat.o(21602);
          return;
        }
        Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramAnonymousString });
        paramAnonymousString = ((k)paramAnonymousq).oQp;
        if (!b.cga().oIU.equals(paramAnonymousString.ID))
        {
          Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
          h.CyF.idkeyStat(400L, 118L, 1L, false);
          b.cga().ceM().oJc = -5;
          e.this.xI(-5);
          AppMethodBeat.o(21602);
          return;
        }
        b.cga().ceM().oJk = paramAnonymousString.oTO;
        Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramAnonymousString.oTO) });
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.NZI, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.cgs();
        e.a(e.this);
        AppMethodBeat.o(21602);
      }
    };
    this.oOH = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21603);
        com.tencent.mm.plugin.backup.g.b.b(11, e.this.oOH);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.CyF.idkeyStat(400L, 119L, 1L, false);
          e.this.cancel(false);
          b.cga().ceM().oJc = -5;
          e.this.xI(-5);
          AppMethodBeat.o(21603);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.i)paramAnonymousq;
        paramAnonymousString = g.b(paramAnonymousString.oQd.oTB, paramAnonymousString.oQd.oTC);
        Log.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
        paramAnonymousq = e.b(e.this);
        b.cga().cgb();
        paramAnonymousq.a(paramAnonymousString, b.cga().ceM().oJk, e.oKK);
        AppMethodBeat.o(21603);
      }
    };
    this.oOI = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21605);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Boolean.valueOf(e.bHp()) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label506;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.cga().ceM().oJc;
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
          b.cga().cfw().stop();
          b.cga().ceM().oJc = -100;
          e.this.xI(-100);
          AppMethodBeat.o(21605);
          return;
          b.cga().cfw().stop();
          AppMethodBeat.o(21605);
          return;
          b.cga().cfw().stop();
          b.cga().ceM().oJc = -100;
          e.this.xI(-100);
          AppMethodBeat.o(21605);
          return;
          if ((b.cga().cgb().oOo) && (!e.bHp()))
          {
            paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.cgz();
            switch (paramAnonymousInt1)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(21605);
              return;
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              e.this.Bk(19);
              e.c(e.this);
              com.tencent.mm.plugin.backup.g.b.a(b.cga().cgb().oOt);
              AppMethodBeat.o(21605);
              return;
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            }
          }
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
          e.this.cancel(true);
          b.cga().cfw().stop();
          b.cga().ceM().oJc = -4;
          e.this.xI(-4);
          h.CyF.idkeyStat(400L, 9L, 1L, false);
          e.this.Bk(3);
          AppMethodBeat.o(21605);
          return;
          e.this.cancel(true);
        }
        label506:
        Object localObject;
        if ((1 == b.cga().cgb().oOk) || (3 == b.cga().cgb().oOk))
        {
          if (paramAnonymousInt1 == 10)
          {
            localObject = new f();
            try
            {
              ((f)localObject).parseFrom(paramAnonymousArrayOfByte);
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((f)localObject).oPN) });
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
            b.cga().ceM().oJc = -100;
            e.this.xI(-100);
            h.CyF.idkeyStat(400L, 51L, 1L, false);
            e.this.Bk(5);
            AppMethodBeat.o(21605);
            return;
          }
          if (paramAnonymousInt1 == 18)
          {
            localObject = new com.tencent.mm.plugin.backup.i.c();
            try
            {
              ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).oTl) });
              if (((com.tencent.mm.plugin.backup.i.c)localObject).oTl == 9)
              {
                paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.cgz();
                if (paramAnonymousInt1 == 1)
                {
                  com.tencent.mm.plugin.backup.g.b.Bo(2);
                  Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                  e.this.Bk(20);
                  com.tencent.mm.plugin.backup.g.b.cgy();
                  b.cga().ceM().oJc = 14;
                  e.this.xI(14);
                  com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b()
                  {
                    public final void jE(boolean paramAnonymous2Boolean)
                    {
                      AppMethodBeat.i(21604);
                      if (paramAnonymous2Boolean)
                      {
                        Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                        com.tencent.mm.plugin.backup.g.b.Bo(0);
                        AppMethodBeat.o(21604);
                        return;
                      }
                      e.this.xI(b.cga().ceM().oJc);
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
          Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).oTl) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).oTl == 10)
          {
            paramAnonymousInt1 = b.cga().ceM().oJc;
            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if ((paramAnonymousInt1 == 12) || (paramAnonymousInt1 == 14))
            {
              e.this.cancel(true);
              b.cga().cfw().stop();
              b.cga().ceM().oJc = -4;
              e.this.xI(-4);
              h.CyF.idkeyStat(400L, 51L, 1L, false);
              e.this.Bk(5);
              long l = 0L;
              if (e.b(e.this).oJR != 0L) {
                l = Util.milliSecondsToNow(e.b(e.this).oJR);
              }
              h.CyF.a(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(e.this).cfe()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
              Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(e.this).cfe()), Long.valueOf(l / 1000L) });
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
    this.oJO = new com.tencent.mm.plugin.backup.b.b.b()
    {
      public final void Ba(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21609);
        final HashSet localHashSet = new HashSet();
        localHashSet.addAll(e.d(e.this));
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21607);
            Iterator localIterator = localHashSet.iterator();
            while (localIterator.hasNext()) {
              ((b.c)localIterator.next()).Ba(paramAnonymousInt);
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
                e.e(e.this).AZ(paramAnonymousInt);
              }
              AppMethodBeat.o(21608);
            }
          });
        }
        AppMethodBeat.o(21609);
      }
      
      public final void ceI()
      {
        AppMethodBeat.i(21610);
        h.CyF.idkeyStat(400L, 11L, 1L, false);
        h localh = h.CyF;
        if (e.b(e.this) == null)
        {
          l = 0L;
          localh.idkeyStat(400L, 12L, l, false);
          localh = h.CyF;
          if (e.b(e.this) != null) {
            break label136;
          }
        }
        label136:
        for (long l = 0L;; l = e.b(e.this).cfe())
        {
          localh.idkeyStat(400L, 13L, l, false);
          e.this.Bk(0);
          com.tencent.mm.plugin.backup.g.b.Bn(11);
          if (!e.f(e.this)) {
            e.this.Bk(21);
          }
          AppMethodBeat.o(21610);
          return;
          l = Util.milliSecondsToNow(e.b(e.this).oJR) / 1000L;
          break;
        }
      }
      
      public final void ceJ()
      {
        AppMethodBeat.i(21611);
        Log.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[] { Boolean.FALSE });
        e.this.cancel(false);
        h.CyF.idkeyStat(400L, 120L, 1L, false);
        AppMethodBeat.o(21611);
      }
    };
    AppMethodBeat.o(21612);
  }
  
  public static void cgl()
  {
    oOE = true;
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
    b.cga();
    SharedPreferences.Editor localEditor = b.ceR().edit();
    if (1 == b.cga().cgb().oOk)
    {
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", paramInt1);
      localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", paramLong1);
      localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", paramLong2);
    }
    localEditor.commit();
    AppMethodBeat.o(21616);
  }
  
  public final void Bk(int paramInt)
  {
    long l1 = 0L;
    AppMethodBeat.i(21618);
    long l2;
    if (this.oMe != null)
    {
      if (this.oMe.oJR != 0L) {
        l1 = Util.milliSecondsToNow(this.oMe.oJR);
      }
      long l3 = this.oMe.cfe();
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      h.CyF.a(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L), Integer.valueOf(1), Integer.valueOf(b.cga().cgb().oOq) });
      Log.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2 / 1000L) });
      AppMethodBeat.o(21618);
      return;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public final void Bv(long paramLong)
  {
    int i = 3;
    AppMethodBeat.i(21617);
    Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
    com.tencent.mm.plugin.backup.g.b.a(3, this.oLU);
    k localk = new k(b.cga().oIU);
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    bg.aVF();
    g.a(localPLong1, localPLong2, com.tencent.mm.model.c.getAccPath());
    if (oKK) {}
    for (;;)
    {
      localk.a(paramLong, g.Bu(localPLong2.value), i);
      Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      localk.cgA();
      AppMethodBeat.o(21617);
      return;
      bg.aVF();
      if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NZI, Boolean.FALSE)).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void G(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(21615);
    this.oMc = paramLinkedList;
    b.cga();
    label95:
    int i;
    label101:
    SharedPreferences.Editor localEditor;
    if (b.ceR().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1)
    {
      oMj = true;
      b.cga();
      this.oMf = b.ceR().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      b.cga();
      this.oMg = b.ceR().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      b.cga();
      if (b.ceR().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
        break label250;
      }
      oKK = true;
      if (paramLinkedList != null) {
        break label257;
      }
      i = -1;
      Log.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", new Object[] { Integer.valueOf(i), Boolean.valueOf(oMj), Boolean.valueOf(oKK), Long.valueOf(this.oMf), Long.valueOf(this.oMg) });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZC, Boolean.TRUE);
      if (1 == b.cga().cgb().oOk)
      {
        b.cga();
        localEditor = b.ceR().edit();
        if (paramLinkedList != null) {
          break label265;
        }
      }
    }
    label257:
    label265:
    for (paramLinkedList = new String[0];; paramLinkedList = (String[])paramLinkedList.toArray(new String[paramLinkedList.size()]))
    {
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", g.b("", ",", paramLinkedList));
      localEditor.commit();
      AppMethodBeat.o(21615);
      return;
      oMj = false;
      break;
      label250:
      oKK = false;
      break label95;
      i = paramLinkedList.size();
      break label101;
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21614);
    Log.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[] { Boolean.valueOf(paramBoolean), MMStack.getCaller() });
    oOE = true;
    if (!paramBoolean)
    {
      b.cga().cgb();
      c.cfF();
    }
    this.oMe.cancel();
    if (this.oMd != null)
    {
      this.oMd.cancel();
      this.oMd = null;
    }
    com.tencent.mm.plugin.backup.g.b.cgt();
    com.tencent.mm.plugin.backup.g.b.cgv();
    com.tencent.mm.plugin.backup.g.b.cgy();
    b.cga().ceO();
    AppMethodBeat.o(21614);
  }
  
  public final void ceK()
  {
    AppMethodBeat.i(21619);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.oOw);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21606);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).ceK();
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
    oOE = false;
    this.oOz = false;
    com.tencent.mm.plugin.backup.g.b.a(this.oOI);
    this.oMe = new com.tencent.mm.plugin.backup.c.c(b.cga(), 1, this.oJO);
    AppMethodBeat.o(21613);
  }
  
  public final void xI(int paramInt)
  {
    AppMethodBeat.i(21620);
    this.oJO.Ba(paramInt);
    AppMethodBeat.o(21620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e
 * JD-Core Version:    0.7.0.1
 */