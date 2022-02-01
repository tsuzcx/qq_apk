package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class c
{
  private static int nrQ = 2;
  private static boolean uYV = false;
  private MTimerHandler uYU;
  final com.tencent.mm.am.h uYY;
  private final com.tencent.mm.am.h uYZ;
  b.c uZd;
  private final j.a uZe;
  boolean vbA;
  private com.tencent.mm.bx.b vbB;
  public int vbC;
  public boolean vbD;
  private final b.d vbE;
  public final h.a vbF;
  public int vbw;
  public String vbx;
  String vby;
  int vbz;
  
  public c()
  {
    AppMethodBeat.i(21569);
    this.vbw = 0;
    this.vbD = true;
    this.uYY = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21558);
        bh.aZW().b(595, c.a(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 111L, 1L, false);
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
          }
          b.cVW().cUJ().uWg = -5;
          b.cVW().cVY().Bt(-5);
          AppMethodBeat.o(21558);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousp).cWE();
        bh.bCz();
        if (!Util.nullAsNil((String)com.tencent.mm.model.c.ban().d(2, null)).equals(paramAnonymousString.YKN))
        {
          Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
          b.cVW().cUJ().uWg = -5;
          b.cVW().cVY().Bt(-5);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 112L, 1L, false);
          AppMethodBeat.o(21558);
          return;
        }
        if ((paramAnonymousString.YKL == null) || (paramAnonymousString.YKL.size() <= 0) || (paramAnonymousString.YKL.getFirst() == null))
        {
          paramAnonymousInt1 = paramAnonymousString.YKK;
          if (paramAnonymousString.YKL == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousString.YKL.size())
          {
            Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
            b.cVW().cUJ().uWg = -5;
            b.cVW().cVY().Bt(-5);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 113L, 1L, false);
            AppMethodBeat.o(21558);
            return;
          }
        }
        Object localObject = (afx)paramAnonymousString.YKL.getFirst();
        paramAnonymousp = ((afx)localObject).Zjq;
        paramAnonymousInt1 = ((Integer)((afx)localObject).ZoN.getFirst()).intValue();
        localObject = c.this;
        ((c)localObject).vbx = paramAnonymousString.YKO;
        ((c)localObject).vby = paramAnonymousp;
        ((c)localObject).vbz = paramAnonymousInt1;
        Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousString.vhJ), Integer.valueOf(paramAnonymousString.IJG), paramAnonymousString.YKO, paramAnonymousp, Integer.valueOf(paramAnonymousInt1) });
        b.cVW().uVY = paramAnonymousString.vgy;
        b.cVW().uVZ = paramAnonymousString.YKT;
        b.cVW().uWa = paramAnonymousString.YKU;
        b.cVW().uWe = paramAnonymousString.YKf.aaxD.Op;
        c.b(c.this);
        AppMethodBeat.o(21558);
      }
    };
    this.uYZ = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21560);
        c.cth();
        com.tencent.mm.plugin.report.service.h.OAn.b(13736, new Object[] { Integer.valueOf(0), c.e(c.this), g.fC(MMApplicationContext.getContext()), Integer.valueOf(0), Integer.valueOf(b.cVW().cVX().vbC) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.f(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          switch (paramAnonymousInt2)
          {
          case -2: 
          default: 
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 116L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(c.this)) });
            b.cVW().cUJ().uWg = -5;
            b.cVW().cVY().Bt(-5);
            AppMethodBeat.o(21560);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 114L, 1L, false);
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 115L, 1L, false);
          }
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousp;
        boolean bool1;
        boolean bool2;
        label319:
        boolean bool3;
        if ((paramAnonymousString.vcu.vhK & com.tencent.mm.plugin.backup.b.c.uVV) == 0)
        {
          bool1 = false;
          if ((paramAnonymousString.vcu.vhK & com.tencent.mm.plugin.backup.b.c.uVW) != 0) {
            break label436;
          }
          bool2 = false;
          if ((paramAnonymousString.vcu.vhK & com.tencent.mm.plugin.backup.b.c.uVX) != 0) {
            break label442;
          }
          bool3 = false;
          label336:
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (!bool3) {
            break label466;
          }
          if (paramAnonymousString.vcu.vhM != null) {
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
          b.cVW().cVY().vbR = bool1;
          b.cVW().cVY().vbS = bool2;
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
          paramAnonymousString = paramAnonymousString.vcu.vhM;
          break label388;
          label459:
          Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
          label466:
          c.this.a(false, null);
        }
      }
    };
    this.vbE = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21561);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label251;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.cVW().cUJ().uWg;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          if (!c.ayB())
          {
            if (c.c(c.this) != null)
            {
              Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
              c.c(c.this).stopTimer();
            }
            c.d(c.this);
            AppMethodBeat.o(21561);
            return;
          }
          b.cVW().cVt().stop();
          b.cVW().cUJ().uWg = -4;
          b.cVW().cVY().Bt(-4);
          AppMethodBeat.o(21561);
          return;
          b.cVW().cVt().stop();
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
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.vgz) });
            i = localb.vgz;
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramAnonymousArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
            continue;
            bh.bCz();
            if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acOX, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            b.cVW();
            paramAnonymousArrayOfByte = b.cUO().getString("BACKUP_PC_CHOOSE_SESSION", null);
            if (paramAnonymousArrayOfByte != null) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 29L, 1L, false);
            c.this.vbw = 3;
            paramAnonymousArrayOfByte = new LinkedList(Arrays.asList(g.fv(paramAnonymousArrayOfByte, ",")));
            b.cVW().cVY().init();
            b.cVW().cVY().K(paramAnonymousArrayOfByte);
            c.gk(5, paramAnonymousInt2);
            b.cVW().cVY().cUH();
            c.this.Fl(6);
            paramAnonymousArrayOfByte = b.cVW().cVY();
            com.tencent.mm.plugin.backup.h.d.cWK().cWN();
            paramAnonymousArrayOfByte.jZ(paramAnonymousArrayOfByte.uZl.size());
            continue;
            c.b(c.this, 3, paramAnonymousInt2);
            continue;
            bh.bCz();
            if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acOY, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            b.cVW().cVZ();
            if (d.cVx()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 30L, 1L, false);
            c.this.vbw = 4;
            b.cVW().cVZ().init();
            c.gk(7, paramAnonymousInt2);
            b.cVW().cVY().cUH();
            c.this.Fl(8);
            continue;
            AppMethodBeat.o(21561);
          }
          if (paramAnonymousInt1 != 5) {
            continue;
          }
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
          com.tencent.mm.plugin.report.service.h.OAn.b(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.cVW().cVX().vbC) });
          b.cVW().cUJ().uWg = -100;
          b.cVW().cVY().Bt(-100);
          AppMethodBeat.o(21561);
          return;
          c.a(c.this, 1, paramAnonymousInt2);
        }
      }
    };
    this.uZe = new j.a()
    {
      public final void Fh(int paramAnonymousInt)
      {
        AppMethodBeat.i(300741);
        int i = b.cVW().cUJ().uWg;
        if (paramAnonymousInt == 1)
        {
          if (((1 == c.h(c.this)) || (3 == c.h(c.this))) && (i == 14))
          {
            Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.cVW().cUJ().uWg = 4;
            b.cVW().cVY().Bt(4);
            AppMethodBeat.o(300741);
            return;
          }
          if (((2 == c.h(c.this)) || (4 == c.h(c.this))) && (i == 23))
          {
            Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.cVW().cUJ().uWg = 4;
            b.cVW().cVZ().Fc(4);
            AppMethodBeat.o(300741);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
          if ((1 == c.h(c.this)) || (3 == c.h(c.this)))
          {
            b.cVW().cUJ().uWg = 14;
            b.cVW().cVY().Bt(14);
            AppMethodBeat.o(300741);
            return;
          }
          if ((2 == c.h(c.this)) || (4 == c.h(c.this)))
          {
            b.cVW().cUJ().uWg = 23;
            b.cVW().cVZ().Fc(23);
          }
        }
        AppMethodBeat.o(300741);
      }
      
      public final void cVG()
      {
        AppMethodBeat.i(300739);
        int i = b.cVW().cVX().vbw;
        if ((1 == i) || (3 == i))
        {
          b.cVW().cVY().Bt(b.cVW().cUJ().uWg);
          AppMethodBeat.o(300739);
          return;
        }
        if ((2 == i) || (4 == i)) {
          b.cVW().cVZ().Fc(b.cVW().cUJ().uWg);
        }
        AppMethodBeat.o(300739);
      }
      
      public final void cVH()
      {
        AppMethodBeat.i(300742);
        int i = b.cVW().cUJ().uWg;
        Log.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        int j = b.cVW().cVX().vbw;
        if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
        {
          b.cVW().cVt().stop();
          b.cVW().cVY().cancel(true);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 9L, 1L, false);
          b.cVW().cVY().Fm(18);
          b.cVW().cUJ().uWg = -4;
          b.cVW().cVY().Bt(-4);
          AppMethodBeat.o(300742);
          return;
        }
        if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
        {
          b.cVW().cVt().stop();
          b.cVW().cVZ().a(true, false, -4);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 17L, 1L, false);
          b.cVW().cVZ().Fm(18);
        }
        AppMethodBeat.o(300742);
      }
    };
    this.vbF = new h.a()
    {
      public final void cWd()
      {
        AppMethodBeat.i(300737);
        Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        int i;
        if (b.cVW().cUJ().uWg != 5)
        {
          b.cVW().cUJ().uWg = 5;
          i = b.cVW().cVX().vbw;
          if ((1 != i) && (3 != i)) {
            break label80;
          }
          b.cVW().cVY().Bt(5);
        }
        for (;;)
        {
          c.this.Fl(9);
          AppMethodBeat.o(300737);
          return;
          label80:
          if ((2 == i) || (4 == i)) {
            b.cVW().cVZ().Fc(5);
          }
        }
      }
      
      public final void cWe()
      {
        AppMethodBeat.i(300740);
        int i = c.this.vbw;
        Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        if ((1 == i) || (3 == i))
        {
          b.cVW().cVY();
          e.cWh();
          b.cVW().cVY().cancel(true);
          b.cVW().cVt().stop();
          b.cVW().cUJ().uWg = -4;
          b.cVW().cVY().Bt(-4);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 9L, 1L, false);
          b.cVW().cVY().Fm(3);
          AppMethodBeat.o(300740);
          return;
        }
        if ((2 == i) || (4 == i))
        {
          b.cVW().cVZ();
          d.cWf();
          b.cVW().cVZ().a(true, false, -4);
          b.cVW().cVt().stop();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 17L, 1L, false);
          b.cVW().cVZ().Fm(3);
        }
        AppMethodBeat.o(300740);
      }
    };
    this.uZd = new b.c()
    {
      public final void cVF()
      {
        AppMethodBeat.i(300738);
        Log.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
        com.tencent.mm.plugin.backup.g.b.cWp();
        b.cVW().cUL();
        AppMethodBeat.o(300738);
      }
    };
    AppMethodBeat.o(21569);
  }
  
  public static void cVC()
  {
    AppMethodBeat.i(21574);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.vgy = b.cVW().uVY;
    try
    {
      com.tencent.mm.plugin.backup.g.b.N(locala.toByteArray(), 5);
      AppMethodBeat.o(21574);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21574);
    }
  }
  
  private void cWb()
  {
    AppMethodBeat.i(21570);
    b.cVW().cVt().ds(this.vby, this.vbz);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.uYZ);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.cVW().uVZ, b.cVW().uWa, com.tencent.mm.plugin.backup.b.d.cUN(), b.cVW().uVY, 0, 1, false);
    locala.K(true, true);
    locala.vct.vhL = 1;
    locala.cWw();
    Log.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.uYU == null) {
      this.uYU = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21559);
          if (!c.ayB())
          {
            Log.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
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
    this.uYU.startTimer(3000L);
    AppMethodBeat.o(21570);
  }
  
  public static String cWc()
  {
    AppMethodBeat.i(21571);
    String str = com.tencent.mm.plugin.backup.g.b.cWs();
    AppMethodBeat.o(21571);
    return str;
  }
  
  public static void gk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21573);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.vgz = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.D(localc.toByteArray(), 18, paramInt2);
      AppMethodBeat.o(21573);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
      AppMethodBeat.o(21573);
    }
  }
  
  public final void Fl(int paramInt)
  {
    AppMethodBeat.i(21572);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.vgz = paramInt;
    if (paramInt == 9) {
      localb.vgA = this.vbB;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.N(localb.toByteArray(), 17);
      AppMethodBeat.o(21572);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21572);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.bx.b paramb)
  {
    this.vbA = paramBoolean;
    this.vbB = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */