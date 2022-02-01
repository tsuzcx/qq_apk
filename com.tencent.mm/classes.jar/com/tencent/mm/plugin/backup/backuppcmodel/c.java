package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class c
{
  private static boolean aMx = false;
  private static int hiJ = 2;
  private aw nAS;
  final f nAT;
  private final f nAU;
  b.c nAY;
  private final j.a nAZ;
  public int nDn;
  public String nDo;
  String nDp;
  int nDq;
  boolean nDr;
  private com.tencent.mm.bw.b nDs;
  public int nDt;
  public boolean nDu;
  private final b.d nDv;
  public final h.a nDw;
  
  public c()
  {
    AppMethodBeat.i(21569);
    this.nDn = 0;
    this.nDu = true;
    this.nAT = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21558);
        bc.ajj().b(595, c.a(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 111L, 1L, false);
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ae.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
          }
          b.bJh().bHV().nye = -5;
          b.bJh().bJj().tK(-5);
          AppMethodBeat.o(21558);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bJP();
        bc.aCg();
        if (!bu.nullAsNil((String)com.tencent.mm.model.c.ajA().get(2, null)).equals(paramAnonymousString.FSW))
        {
          ae.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
          b.bJh().bHV().nye = -5;
          b.bJh().bJj().tK(-5);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 112L, 1L, false);
          AppMethodBeat.o(21558);
          return;
        }
        if ((paramAnonymousString.FSU == null) || (paramAnonymousString.FSU.size() <= 0) || (paramAnonymousString.FSU.getFirst() == null))
        {
          paramAnonymousInt1 = paramAnonymousString.FST;
          if (paramAnonymousString.FSU == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousString.FSU.size())
          {
            ae.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
            b.bJh().bHV().nye = -5;
            b.bJh().bJj().tK(-5);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 113L, 1L, false);
            AppMethodBeat.o(21558);
            return;
          }
        }
        Object localObject = (abj)paramAnonymousString.FSU.getFirst();
        paramAnonymousn = ((abj)localObject).Gpn;
        paramAnonymousInt1 = ((Integer)((abj)localObject).Gtd.getFirst()).intValue();
        localObject = c.this;
        ((c)localObject).nDo = paramAnonymousString.FSX;
        ((c)localObject).nDp = paramAnonymousn;
        ((c)localObject).nDq = paramAnonymousInt1;
        ae.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousString.nJA), Integer.valueOf(paramAnonymousString.Scene), paramAnonymousString.FSX, paramAnonymousn, Integer.valueOf(paramAnonymousInt1) });
        b.bJh().nxW = paramAnonymousString.ID;
        b.bJh().nxX = paramAnonymousString.FTc;
        b.bJh().nxY = paramAnonymousString.FTd;
        b.bJh().nyc = paramAnonymousString.FSl.getBufferToBytes();
        c.b(c.this);
        AppMethodBeat.o(21558);
      }
    };
    this.nAU = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21560);
        c.bAv();
        com.tencent.mm.plugin.report.service.g.yxI.f(13736, new Object[] { Integer.valueOf(0), c.e(c.this), com.tencent.mm.plugin.backup.b.g.el(ak.getContext()), Integer.valueOf(0), Integer.valueOf(b.bJh().bJi().nDt) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.f(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          switch (paramAnonymousInt2)
          {
          case -2: 
          default: 
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 116L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(c.this)) });
            b.bJh().bHV().nye = -5;
            b.bJh().bJj().tK(-5);
            AppMethodBeat.o(21560);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 114L, 1L, false);
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 115L, 1L, false);
          }
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        boolean bool1;
        boolean bool2;
        label319:
        boolean bool3;
        if ((paramAnonymousString.nEl.nJB & com.tencent.mm.plugin.backup.b.c.nxT) == 0)
        {
          bool1 = false;
          if ((paramAnonymousString.nEl.nJB & com.tencent.mm.plugin.backup.b.c.nxU) != 0) {
            break label436;
          }
          bool2 = false;
          if ((paramAnonymousString.nEl.nJB & com.tencent.mm.plugin.backup.b.c.nxV) != 0) {
            break label442;
          }
          bool3 = false;
          label336:
          ae.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (!bool3) {
            break label466;
          }
          if (paramAnonymousString.nEl.nJD != null) {
            break label448;
          }
          paramAnonymousString = null;
          label388:
          if (paramAnonymousString == null) {
            break label459;
          }
          c.this.a(true, paramAnonymousString);
        }
        for (;;)
        {
          b.bJh().bJj().nDI = bool1;
          b.bJh().bJj().nDJ = bool2;
          AppMethodBeat.o(21560);
          return;
          bool1 = true;
          break;
          label436:
          bool2 = true;
          break label319;
          label442:
          bool3 = true;
          break label336;
          label448:
          paramAnonymousString = paramAnonymousString.nEl.nJD;
          break label388;
          label459:
          ae.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
          label466:
          c.this.a(false, null);
        }
      }
    };
    this.nDv = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21561);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label251;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.bJh().bHV().nye;
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            switch (paramAnonymousInt1)
            {
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21561);
          return;
          i = paramAnonymousArrayOfByte.length;
          break;
          if (!c.aMx)
          {
            if (c.c(c.this) != null)
            {
              ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
              c.c(c.this).stopTimer();
            }
            c.d(c.this);
            AppMethodBeat.o(21561);
            return;
          }
          b.bJh().bIF().stop();
          b.bJh().bHV().nye = -4;
          b.bJh().bJj().tK(-4);
          AppMethodBeat.o(21561);
          return;
          b.bJh().bIF().stop();
        }
        label251:
        com.tencent.mm.plugin.backup.i.b localb;
        if (paramAnonymousInt1 == 17) {
          localb = new com.tencent.mm.plugin.backup.i.b();
        }
        for (;;)
        {
          try
          {
            localb.parseFrom(paramAnonymousArrayOfByte);
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.nIp) });
            i = localb.nIp;
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ae.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramAnonymousArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
            continue;
            bc.aCg();
            if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IRA, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            b.bJh();
            paramAnonymousArrayOfByte = b.bIa().getString("BACKUP_PC_CHOOSE_SESSION", null);
            if (paramAnonymousArrayOfByte != null) {
              continue;
            }
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 29L, 1L, false);
            c.this.nDn = 3;
            paramAnonymousArrayOfByte = new LinkedList(Arrays.asList(com.tencent.mm.plugin.backup.b.g.ey(paramAnonymousArrayOfByte, ",")));
            b.bJh().bJj().init();
            b.bJh().bJj().H(paramAnonymousArrayOfByte);
            c.eF(5, paramAnonymousInt2);
            b.bJh().bJj().bHT();
            c.this.xD(6);
            paramAnonymousArrayOfByte = b.bJh().bJj();
            com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
            paramAnonymousArrayOfByte.tp(paramAnonymousArrayOfByte.nBd.size());
            continue;
            c.b(c.this, 3, paramAnonymousInt2);
            continue;
            bc.aCg();
            if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IRB, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            b.bJh().bJk();
            if (d.bIJ()) {
              continue;
            }
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 30L, 1L, false);
            c.this.nDn = 4;
            b.bJh().bJk().init();
            c.eF(7, paramAnonymousInt2);
            b.bJh().bJj().bHT();
            c.this.xD(8);
            continue;
            AppMethodBeat.o(21561);
          }
          if (paramAnonymousInt1 != 5) {
            continue;
          }
          ae.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
          com.tencent.mm.plugin.report.service.g.yxI.f(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.bJh().bJi().nDt) });
          b.bJh().bHV().nye = -100;
          b.bJh().bJj().tK(-100);
          AppMethodBeat.o(21561);
          return;
          c.a(c.this, 1, paramAnonymousInt2);
        }
      }
    };
    this.nAZ = new j.a()
    {
      public final void bIR()
      {
        AppMethodBeat.i(21563);
        int i = b.bJh().bJi().nDn;
        if ((1 == i) || (3 == i))
        {
          b.bJh().bJj().tK(b.bJh().bHV().nye);
          AppMethodBeat.o(21563);
          return;
        }
        if ((2 == i) || (4 == i)) {
          b.bJh().bJk().xu(b.bJh().bHV().nye);
        }
        AppMethodBeat.o(21563);
      }
      
      public final void bIS()
      {
        AppMethodBeat.i(21565);
        int i = b.bJh().bHV().nye;
        ae.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        int j = b.bJh().bJi().nDn;
        if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
        {
          b.bJh().bIF().stop();
          b.bJh().bJj().cancel(true);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 9L, 1L, false);
          b.bJh().bJj().xE(18);
          b.bJh().bHV().nye = -4;
          b.bJh().bJj().tK(-4);
          AppMethodBeat.o(21565);
          return;
        }
        if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
        {
          b.bJh().bIF().stop();
          b.bJh().bJk().b(true, false, -4);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 17L, 1L, false);
          b.bJh().bJk().xE(18);
        }
        AppMethodBeat.o(21565);
      }
      
      public final void xz(int paramAnonymousInt)
      {
        AppMethodBeat.i(21564);
        int i = b.bJh().bHV().nye;
        if (paramAnonymousInt == 1)
        {
          if (((1 == c.h(c.this)) || (3 == c.h(c.this))) && (i == 14))
          {
            ae.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bJh().bHV().nye = 4;
            b.bJh().bJj().tK(4);
            AppMethodBeat.o(21564);
            return;
          }
          if (((2 == c.h(c.this)) || (4 == c.h(c.this))) && (i == 23))
          {
            ae.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bJh().bHV().nye = 4;
            b.bJh().bJk().xu(4);
            AppMethodBeat.o(21564);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ae.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
          if ((1 == c.h(c.this)) || (3 == c.h(c.this)))
          {
            b.bJh().bHV().nye = 14;
            b.bJh().bJj().tK(14);
            AppMethodBeat.o(21564);
            return;
          }
          if ((2 == c.h(c.this)) || (4 == c.h(c.this)))
          {
            b.bJh().bHV().nye = 23;
            b.bJh().bJk().xu(23);
          }
        }
        AppMethodBeat.o(21564);
      }
    };
    this.nDw = new h.a()
    {
      public final void bJo()
      {
        AppMethodBeat.i(21566);
        ae.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        int i;
        if (b.bJh().bHV().nye != 5)
        {
          b.bJh().bHV().nye = 5;
          i = b.bJh().bJi().nDn;
          if ((1 != i) && (3 != i)) {
            break label82;
          }
          b.bJh().bJj().tK(5);
        }
        for (;;)
        {
          c.this.xD(9);
          AppMethodBeat.o(21566);
          return;
          label82:
          if ((2 == i) || (4 == i)) {
            b.bJh().bJk().xu(5);
          }
        }
      }
      
      public final void bJp()
      {
        AppMethodBeat.i(21567);
        int i = c.this.nDn;
        ae.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        if ((1 == i) || (3 == i))
        {
          b.bJh().bJj();
          e.bJs();
          b.bJh().bJj().cancel(true);
          b.bJh().bIF().stop();
          b.bJh().bHV().nye = -4;
          b.bJh().bJj().tK(-4);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 9L, 1L, false);
          b.bJh().bJj().xE(3);
          AppMethodBeat.o(21567);
          return;
        }
        if ((2 == i) || (4 == i))
        {
          b.bJh().bJk();
          d.bJq();
          b.bJh().bJk().b(true, false, -4);
          b.bJh().bIF().stop();
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 17L, 1L, false);
          b.bJh().bJk().xE(3);
        }
        AppMethodBeat.o(21567);
      }
    };
    this.nAY = new b.c()
    {
      public final void bIT()
      {
        AppMethodBeat.i(21568);
        ae.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
        com.tencent.mm.plugin.backup.g.b.bJA();
        b.bJh().bHX();
        AppMethodBeat.o(21568);
      }
    };
    AppMethodBeat.o(21569);
  }
  
  public static void bIO()
  {
    AppMethodBeat.i(21574);
    ae.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bJh().nxW;
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21574);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21574);
    }
  }
  
  private void bJm()
  {
    AppMethodBeat.i(21570);
    b.bJh().bIF().connect(this.nDp, this.nDq);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.nAU);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.bJh().nxX, b.bJh().nxY, com.tencent.mm.plugin.backup.b.d.bHZ(), b.bJh().nxW, 0, 1);
    locala.B(true, true);
    locala.nEk.nJC = 1;
    locala.bJH();
    ae.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.nAS == null) {
      this.nAS = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21559);
          if (!c.aMx)
          {
            ae.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
            if (c.c(c.this) != null) {
              c.c(c.this).stopTimer();
            }
            c.d(c.this);
          }
          AppMethodBeat.o(21559);
          return true;
        }
      }, false);
    }
    this.nAS.ay(3000L, 3000L);
    AppMethodBeat.o(21570);
  }
  
  public static String bJn()
  {
    AppMethodBeat.i(21571);
    String str = com.tencent.mm.plugin.backup.g.b.bJD();
    AppMethodBeat.o(21571);
    return str;
  }
  
  public static void eF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21573);
    ae.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.nIp = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localc.toByteArray(), 18, paramInt2);
      AppMethodBeat.o(21573);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
      AppMethodBeat.o(21573);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.bw.b paramb)
  {
    this.nDr = paramBoolean;
    this.nDs = paramb;
  }
  
  public final void xD(int paramInt)
  {
    AppMethodBeat.i(21572);
    ae.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.nIp = paramInt;
    if (paramInt == 9) {
      localb.nIq = this.nDs;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(localb.toByteArray(), 17);
      AppMethodBeat.o(21572);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */