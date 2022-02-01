package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class c
{
  private static int kQn = 2;
  private static boolean rNH = false;
  private MTimerHandler rNG;
  final i rNK;
  private final i rNL;
  b.c rNP;
  private final j.a rNQ;
  public int rQh;
  public String rQi;
  String rQj;
  int rQk;
  boolean rQl;
  private com.tencent.mm.cd.b rQm;
  public int rQn;
  public boolean rQo;
  private final b.d rQp;
  public final h.a rQq;
  
  public c()
  {
    AppMethodBeat.i(21569);
    this.rQh = 0;
    this.rQo = true;
    this.rNK = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21558);
        bh.aGY().b(595, c.a(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.IzE.idkeyStat(400L, 111L, 1L, false);
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
          }
          b.ctm().crZ().rKS = -5;
          b.ctm().cto().Bg(-5);
          AppMethodBeat.o(21558);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousq).ctU();
        bh.beI();
        if (!Util.nullAsNil((String)com.tencent.mm.model.c.aHp().b(2, null)).equals(paramAnonymousString.RNz))
        {
          Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
          b.ctm().crZ().rKS = -5;
          b.ctm().cto().Bg(-5);
          h.IzE.idkeyStat(400L, 112L, 1L, false);
          AppMethodBeat.o(21558);
          return;
        }
        if ((paramAnonymousString.RNx == null) || (paramAnonymousString.RNx.size() <= 0) || (paramAnonymousString.RNx.getFirst() == null))
        {
          paramAnonymousInt1 = paramAnonymousString.RNw;
          if (paramAnonymousString.RNx == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousString.RNx.size())
          {
            Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
            b.ctm().crZ().rKS = -5;
            b.ctm().cto().Bg(-5);
            h.IzE.idkeyStat(400L, 113L, 1L, false);
            AppMethodBeat.o(21558);
            return;
          }
        }
        Object localObject = (adp)paramAnonymousString.RNx.getFirst();
        paramAnonymousq = ((adp)localObject).Slg;
        paramAnonymousInt1 = ((Integer)((adp)localObject).SpS.getFirst()).intValue();
        localObject = c.this;
        ((c)localObject).rQi = paramAnonymousString.RNA;
        ((c)localObject).rQj = paramAnonymousq;
        ((c)localObject).rQk = paramAnonymousInt1;
        Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousString.rWu), Integer.valueOf(paramAnonymousString.CPw), paramAnonymousString.RNA, paramAnonymousq, Integer.valueOf(paramAnonymousInt1) });
        b.ctm().rKK = paramAnonymousString.ID;
        b.ctm().rKL = paramAnonymousString.RNF;
        b.ctm().rKM = paramAnonymousString.RNG;
        b.ctm().rKQ = paramAnonymousString.RMR.Tkb.UH;
        c.b(c.this);
        AppMethodBeat.o(21558);
      }
    };
    this.rNL = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21560);
        c.cjY();
        h.IzE.a(13736, new Object[] { Integer.valueOf(0), c.e(c.this), g.eH(MMApplicationContext.getContext()), Integer.valueOf(0), Integer.valueOf(b.ctm().ctn().rQn) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.f(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          switch (paramAnonymousInt2)
          {
          case -2: 
          default: 
            h.IzE.idkeyStat(400L, 116L, 1L, false);
          }
          for (;;)
          {
            h.IzE.a(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(c.this)) });
            b.ctm().crZ().rKS = -5;
            b.ctm().cto().Bg(-5);
            AppMethodBeat.o(21560);
            return;
            h.IzE.idkeyStat(400L, 114L, 1L, false);
            continue;
            h.IzE.idkeyStat(400L, 115L, 1L, false);
          }
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousq;
        boolean bool1;
        boolean bool2;
        label319:
        boolean bool3;
        if ((paramAnonymousString.rRf.rWv & com.tencent.mm.plugin.backup.b.c.rKH) == 0)
        {
          bool1 = false;
          if ((paramAnonymousString.rRf.rWv & com.tencent.mm.plugin.backup.b.c.rKI) != 0) {
            break label436;
          }
          bool2 = false;
          if ((paramAnonymousString.rRf.rWv & com.tencent.mm.plugin.backup.b.c.rKJ) != 0) {
            break label442;
          }
          bool3 = false;
          label336:
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (!bool3) {
            break label466;
          }
          if (paramAnonymousString.rRf.rWx != null) {
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
          b.ctm().cto().rQC = bool1;
          b.ctm().cto().rQD = bool2;
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
          paramAnonymousString = paramAnonymousString.rRf.rWx;
          break label388;
          label459:
          Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
          label466:
          c.this.a(false, null);
        }
      }
    };
    this.rQp = new b.d()
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
            paramAnonymousInt1 = b.ctm().crZ().rKS;
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
          if (!c.rNH)
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
          b.ctm().csJ().stop();
          b.ctm().crZ().rKS = -4;
          b.ctm().cto().Bg(-4);
          AppMethodBeat.o(21561);
          return;
          b.ctm().csJ().stop();
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
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.rVj) });
            i = localb.rVj;
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramAnonymousArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
            continue;
            bh.beI();
            if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnC, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            b.ctm();
            paramAnonymousArrayOfByte = b.cse().getString("BACKUP_PC_CHOOSE_SESSION", null);
            if (paramAnonymousArrayOfByte != null) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
            h.IzE.idkeyStat(400L, 29L, 1L, false);
            c.this.rQh = 3;
            paramAnonymousArrayOfByte = new LinkedList(Arrays.asList(g.fe(paramAnonymousArrayOfByte, ",")));
            b.ctm().cto().init();
            b.ctm().cto().H(paramAnonymousArrayOfByte);
            c.fr(5, paramAnonymousInt2);
            b.ctm().cto().crX();
            c.this.EK(6);
            paramAnonymousArrayOfByte = b.ctm().cto();
            com.tencent.mm.plugin.backup.h.d.cua().cud();
            paramAnonymousArrayOfByte.HI(paramAnonymousArrayOfByte.rNX.size());
            continue;
            c.b(c.this, 3, paramAnonymousInt2);
            continue;
            bh.beI();
            if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnD, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            b.ctm().ctp();
            if (d.csN()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
            h.IzE.idkeyStat(400L, 30L, 1L, false);
            c.this.rQh = 4;
            b.ctm().ctp().init();
            c.fr(7, paramAnonymousInt2);
            b.ctm().cto().crX();
            c.this.EK(8);
            continue;
            AppMethodBeat.o(21561);
          }
          if (paramAnonymousInt1 != 5) {
            continue;
          }
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
          h.IzE.a(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.ctm().ctn().rQn) });
          b.ctm().crZ().rKS = -100;
          b.ctm().cto().Bg(-100);
          AppMethodBeat.o(21561);
          return;
          c.a(c.this, 1, paramAnonymousInt2);
        }
      }
    };
    this.rNQ = new j.a()
    {
      public final void EG(int paramAnonymousInt)
      {
        AppMethodBeat.i(288270);
        int i = b.ctm().crZ().rKS;
        if (paramAnonymousInt == 1)
        {
          if (((1 == c.h(c.this)) || (3 == c.h(c.this))) && (i == 14))
          {
            Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.ctm().crZ().rKS = 4;
            b.ctm().cto().Bg(4);
            AppMethodBeat.o(288270);
            return;
          }
          if (((2 == c.h(c.this)) || (4 == c.h(c.this))) && (i == 23))
          {
            Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.ctm().crZ().rKS = 4;
            b.ctm().ctp().EB(4);
            AppMethodBeat.o(288270);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
          if ((1 == c.h(c.this)) || (3 == c.h(c.this)))
          {
            b.ctm().crZ().rKS = 14;
            b.ctm().cto().Bg(14);
            AppMethodBeat.o(288270);
            return;
          }
          if ((2 == c.h(c.this)) || (4 == c.h(c.this)))
          {
            b.ctm().crZ().rKS = 23;
            b.ctm().ctp().EB(23);
          }
        }
        AppMethodBeat.o(288270);
      }
      
      public final void csW()
      {
        AppMethodBeat.i(288269);
        int i = b.ctm().ctn().rQh;
        if ((1 == i) || (3 == i))
        {
          b.ctm().cto().Bg(b.ctm().crZ().rKS);
          AppMethodBeat.o(288269);
          return;
        }
        if ((2 == i) || (4 == i)) {
          b.ctm().ctp().EB(b.ctm().crZ().rKS);
        }
        AppMethodBeat.o(288269);
      }
      
      public final void csX()
      {
        AppMethodBeat.i(288271);
        int i = b.ctm().crZ().rKS;
        Log.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        int j = b.ctm().ctn().rQh;
        if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
        {
          b.ctm().csJ().stop();
          b.ctm().cto().cancel(true);
          h.IzE.idkeyStat(400L, 9L, 1L, false);
          b.ctm().cto().EL(18);
          b.ctm().crZ().rKS = -4;
          b.ctm().cto().Bg(-4);
          AppMethodBeat.o(288271);
          return;
        }
        if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
        {
          b.ctm().csJ().stop();
          b.ctm().ctp().a(true, false, -4);
          h.IzE.idkeyStat(400L, 17L, 1L, false);
          b.ctm().ctp().EL(18);
        }
        AppMethodBeat.o(288271);
      }
    };
    this.rQq = new h.a()
    {
      public final void ctt()
      {
        AppMethodBeat.i(284589);
        Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        int i;
        if (b.ctm().crZ().rKS != 5)
        {
          b.ctm().crZ().rKS = 5;
          i = b.ctm().ctn().rQh;
          if ((1 != i) && (3 != i)) {
            break label80;
          }
          b.ctm().cto().Bg(5);
        }
        for (;;)
        {
          c.this.EK(9);
          AppMethodBeat.o(284589);
          return;
          label80:
          if ((2 == i) || (4 == i)) {
            b.ctm().ctp().EB(5);
          }
        }
      }
      
      public final void ctu()
      {
        AppMethodBeat.i(284590);
        int i = c.this.rQh;
        Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        if ((1 == i) || (3 == i))
        {
          b.ctm().cto();
          e.ctx();
          b.ctm().cto().cancel(true);
          b.ctm().csJ().stop();
          b.ctm().crZ().rKS = -4;
          b.ctm().cto().Bg(-4);
          h.IzE.idkeyStat(400L, 9L, 1L, false);
          b.ctm().cto().EL(3);
          AppMethodBeat.o(284590);
          return;
        }
        if ((2 == i) || (4 == i))
        {
          b.ctm().ctp();
          d.ctv();
          b.ctm().ctp().a(true, false, -4);
          b.ctm().csJ().stop();
          h.IzE.idkeyStat(400L, 17L, 1L, false);
          b.ctm().ctp().EL(3);
        }
        AppMethodBeat.o(284590);
      }
    };
    this.rNP = new b.c()
    {
      public final void csV()
      {
        AppMethodBeat.i(279935);
        Log.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
        com.tencent.mm.plugin.backup.g.b.ctF();
        b.ctm().csb();
        AppMethodBeat.o(279935);
      }
    };
    AppMethodBeat.o(21569);
  }
  
  public static void csS()
  {
    AppMethodBeat.i(21574);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.ctm().rKK;
    try
    {
      com.tencent.mm.plugin.backup.g.b.O(locala.toByteArray(), 5);
      AppMethodBeat.o(21574);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21574);
    }
  }
  
  private void ctr()
  {
    AppMethodBeat.i(21570);
    b.ctm().csJ().cQ(this.rQj, this.rQk);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.rNL);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.ctm().rKL, b.ctm().rKM, com.tencent.mm.plugin.backup.b.d.csd(), b.ctm().rKK, 0, 1, false);
    locala.E(true, true);
    locala.rRe.rWw = 1;
    locala.ctM();
    Log.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.rNG == null) {
      this.rNG = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21559);
          if (!c.rNH)
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
    this.rNG.startTimer(3000L);
    AppMethodBeat.o(21570);
  }
  
  public static String cts()
  {
    AppMethodBeat.i(21571);
    String str = com.tencent.mm.plugin.backup.g.b.ctI();
    AppMethodBeat.o(21571);
    return str;
  }
  
  public static void fr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21573);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.rVj = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.F(localc.toByteArray(), 18, paramInt2);
      AppMethodBeat.o(21573);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
      AppMethodBeat.o(21573);
    }
  }
  
  public final void EK(int paramInt)
  {
    AppMethodBeat.i(21572);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.rVj = paramInt;
    if (paramInt == 9) {
      localb.rVk = this.rQm;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.O(localb.toByteArray(), 17);
      AppMethodBeat.o(21572);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21572);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.cd.b paramb)
  {
    this.rQl = paramBoolean;
    this.rQm = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */