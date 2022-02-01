package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class c
{
  private static boolean aMx = false;
  private static int hfV = 2;
  b.c nvD;
  private final j.a nvE;
  private av nvx;
  final f nvy;
  private final f nvz;
  public int nxS;
  public String nxT;
  String nxU;
  int nxV;
  boolean nxW;
  private com.tencent.mm.bx.b nxX;
  public int nxY;
  public boolean nxZ;
  private final b.d nya;
  public final h.a nyb;
  
  public c()
  {
    AppMethodBeat.i(21569);
    this.nxS = 0;
    this.nxZ = true;
    this.nvy = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21558);
        ba.aiU().b(595, c.a(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 111L, 1L, false);
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ad.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
          }
          b.bIj().bGX().nsJ = -5;
          b.bIj().bIl().tF(-5);
          AppMethodBeat.o(21558);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bIR();
        ba.aBQ();
        if (!bt.nullAsNil((String)com.tencent.mm.model.c.ajl().get(2, null)).equals(paramAnonymousString.FAA))
        {
          ad.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
          b.bIj().bGX().nsJ = -5;
          b.bIj().bIl().tF(-5);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 112L, 1L, false);
          AppMethodBeat.o(21558);
          return;
        }
        if ((paramAnonymousString.FAy == null) || (paramAnonymousString.FAy.size() <= 0) || (paramAnonymousString.FAy.getFirst() == null))
        {
          paramAnonymousInt1 = paramAnonymousString.FAx;
          if (paramAnonymousString.FAy == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousString.FAy.size())
          {
            ad.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
            b.bIj().bGX().nsJ = -5;
            b.bIj().bIl().tF(-5);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 113L, 1L, false);
            AppMethodBeat.o(21558);
            return;
          }
        }
        Object localObject = (aba)paramAnonymousString.FAy.getFirst();
        paramAnonymousn = ((aba)localObject).FWO;
        paramAnonymousInt1 = ((Integer)((aba)localObject).Gaw.getFirst()).intValue();
        localObject = c.this;
        ((c)localObject).nxT = paramAnonymousString.FAB;
        ((c)localObject).nxU = paramAnonymousn;
        ((c)localObject).nxV = paramAnonymousInt1;
        ad.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousString.nEf), Integer.valueOf(paramAnonymousString.Scene), paramAnonymousString.FAB, paramAnonymousn, Integer.valueOf(paramAnonymousInt1) });
        b.bIj().nsB = paramAnonymousString.ID;
        b.bIj().nsC = paramAnonymousString.FAG;
        b.bIj().nsD = paramAnonymousString.FAH;
        b.bIj().nsH = paramAnonymousString.FzN.getBufferToBytes();
        c.b(c.this);
        AppMethodBeat.o(21558);
      }
    };
    this.nvz = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21560);
        c.bzA();
        com.tencent.mm.plugin.report.service.g.yhR.f(13736, new Object[] { Integer.valueOf(0), c.e(c.this), com.tencent.mm.plugin.backup.b.g.eh(aj.getContext()), Integer.valueOf(0), Integer.valueOf(b.bIj().bIk().nxY) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.f(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          switch (paramAnonymousInt2)
          {
          case -2: 
          default: 
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 116L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(c.this)) });
            b.bIj().bGX().nsJ = -5;
            b.bIj().bIl().tF(-5);
            AppMethodBeat.o(21560);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 114L, 1L, false);
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 115L, 1L, false);
          }
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        boolean bool1;
        boolean bool2;
        label319:
        boolean bool3;
        if ((paramAnonymousString.nyQ.nEg & com.tencent.mm.plugin.backup.b.c.nsy) == 0)
        {
          bool1 = false;
          if ((paramAnonymousString.nyQ.nEg & com.tencent.mm.plugin.backup.b.c.nsz) != 0) {
            break label436;
          }
          bool2 = false;
          if ((paramAnonymousString.nyQ.nEg & com.tencent.mm.plugin.backup.b.c.nsA) != 0) {
            break label442;
          }
          bool3 = false;
          label336:
          ad.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (!bool3) {
            break label466;
          }
          if (paramAnonymousString.nyQ.nEi != null) {
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
          b.bIj().bIl().nyn = bool1;
          b.bIj().bIl().nyo = bool2;
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
          paramAnonymousString = paramAnonymousString.nyQ.nEi;
          break label388;
          label459:
          ad.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
          label466:
          c.this.a(false, null);
        }
      }
    };
    this.nya = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21561);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label251;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.bIj().bGX().nsJ;
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
              ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
              c.c(c.this).stopTimer();
            }
            c.d(c.this);
            AppMethodBeat.o(21561);
            return;
          }
          b.bIj().bHH().stop();
          b.bIj().bGX().nsJ = -4;
          b.bIj().bIl().tF(-4);
          AppMethodBeat.o(21561);
          return;
          b.bIj().bHH().stop();
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
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.nCU) });
            i = localb.nCU;
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramAnonymousArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
            continue;
            ba.aBQ();
            if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixc, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            b.bIj();
            paramAnonymousArrayOfByte = b.bHc().getString("BACKUP_PC_CHOOSE_SESSION", null);
            if (paramAnonymousArrayOfByte != null) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 29L, 1L, false);
            c.this.nxS = 3;
            paramAnonymousArrayOfByte = new LinkedList(Arrays.asList(com.tencent.mm.plugin.backup.b.g.ev(paramAnonymousArrayOfByte, ",")));
            b.bIj().bIl().init();
            b.bIj().bIl().H(paramAnonymousArrayOfByte);
            c.eF(5, paramAnonymousInt2);
            b.bIj().bIl().bGV();
            c.this.xz(6);
            paramAnonymousArrayOfByte = b.bIj().bIl();
            com.tencent.mm.plugin.backup.h.d.bIY().bJb();
            paramAnonymousArrayOfByte.tb(paramAnonymousArrayOfByte.nvI.size());
            continue;
            c.b(c.this, 3, paramAnonymousInt2);
            continue;
            ba.aBQ();
            if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixd, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            b.bIj().bIm();
            if (d.bHL()) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 30L, 1L, false);
            c.this.nxS = 4;
            b.bIj().bIm().init();
            c.eF(7, paramAnonymousInt2);
            b.bIj().bIl().bGV();
            c.this.xz(8);
            continue;
            AppMethodBeat.o(21561);
          }
          if (paramAnonymousInt1 != 5) {
            continue;
          }
          ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
          com.tencent.mm.plugin.report.service.g.yhR.f(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.bIj().bIk().nxY) });
          b.bIj().bGX().nsJ = -100;
          b.bIj().bIl().tF(-100);
          AppMethodBeat.o(21561);
          return;
          c.a(c.this, 1, paramAnonymousInt2);
        }
      }
    };
    this.nvE = new j.a()
    {
      public final void bHT()
      {
        AppMethodBeat.i(21563);
        int i = b.bIj().bIk().nxS;
        if ((1 == i) || (3 == i))
        {
          b.bIj().bIl().tF(b.bIj().bGX().nsJ);
          AppMethodBeat.o(21563);
          return;
        }
        if ((2 == i) || (4 == i)) {
          b.bIj().bIm().xp(b.bIj().bGX().nsJ);
        }
        AppMethodBeat.o(21563);
      }
      
      public final void bHU()
      {
        AppMethodBeat.i(21565);
        int i = b.bIj().bGX().nsJ;
        ad.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        int j = b.bIj().bIk().nxS;
        if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
        {
          b.bIj().bHH().stop();
          b.bIj().bIl().cancel(true);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 9L, 1L, false);
          b.bIj().bIl().xA(18);
          b.bIj().bGX().nsJ = -4;
          b.bIj().bIl().tF(-4);
          AppMethodBeat.o(21565);
          return;
        }
        if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
        {
          b.bIj().bHH().stop();
          b.bIj().bIm().b(true, false, -4);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 17L, 1L, false);
          b.bIj().bIm().xA(18);
        }
        AppMethodBeat.o(21565);
      }
      
      public final void xu(int paramAnonymousInt)
      {
        AppMethodBeat.i(21564);
        int i = b.bIj().bGX().nsJ;
        if (paramAnonymousInt == 1)
        {
          if (((1 == c.h(c.this)) || (3 == c.h(c.this))) && (i == 14))
          {
            ad.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bIj().bGX().nsJ = 4;
            b.bIj().bIl().tF(4);
            AppMethodBeat.o(21564);
            return;
          }
          if (((2 == c.h(c.this)) || (4 == c.h(c.this))) && (i == 23))
          {
            ad.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bIj().bGX().nsJ = 4;
            b.bIj().bIm().xp(4);
            AppMethodBeat.o(21564);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ad.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
          if ((1 == c.h(c.this)) || (3 == c.h(c.this)))
          {
            b.bIj().bGX().nsJ = 14;
            b.bIj().bIl().tF(14);
            AppMethodBeat.o(21564);
            return;
          }
          if ((2 == c.h(c.this)) || (4 == c.h(c.this)))
          {
            b.bIj().bGX().nsJ = 23;
            b.bIj().bIm().xp(23);
          }
        }
        AppMethodBeat.o(21564);
      }
    };
    this.nyb = new h.a()
    {
      public final void bIq()
      {
        AppMethodBeat.i(21566);
        ad.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        int i;
        if (b.bIj().bGX().nsJ != 5)
        {
          b.bIj().bGX().nsJ = 5;
          i = b.bIj().bIk().nxS;
          if ((1 != i) && (3 != i)) {
            break label82;
          }
          b.bIj().bIl().tF(5);
        }
        for (;;)
        {
          c.this.xz(9);
          AppMethodBeat.o(21566);
          return;
          label82:
          if ((2 == i) || (4 == i)) {
            b.bIj().bIm().xp(5);
          }
        }
      }
      
      public final void bIr()
      {
        AppMethodBeat.i(21567);
        int i = c.this.nxS;
        ad.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        if ((1 == i) || (3 == i))
        {
          b.bIj().bIl();
          e.bIu();
          b.bIj().bIl().cancel(true);
          b.bIj().bHH().stop();
          b.bIj().bGX().nsJ = -4;
          b.bIj().bIl().tF(-4);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 9L, 1L, false);
          b.bIj().bIl().xA(3);
          AppMethodBeat.o(21567);
          return;
        }
        if ((2 == i) || (4 == i))
        {
          b.bIj().bIm();
          d.bIs();
          b.bIj().bIm().b(true, false, -4);
          b.bIj().bHH().stop();
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 17L, 1L, false);
          b.bIj().bIm().xA(3);
        }
        AppMethodBeat.o(21567);
      }
    };
    this.nvD = new b.c()
    {
      public final void bHV()
      {
        AppMethodBeat.i(21568);
        ad.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
        com.tencent.mm.plugin.backup.g.b.bIC();
        b.bIj().bGZ();
        AppMethodBeat.o(21568);
      }
    };
    AppMethodBeat.o(21569);
  }
  
  public static void bHQ()
  {
    AppMethodBeat.i(21574);
    ad.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bIj().nsB;
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21574);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21574);
    }
  }
  
  private void bIo()
  {
    AppMethodBeat.i(21570);
    b.bIj().bHH().connect(this.nxU, this.nxV);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.nvz);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.bIj().nsC, b.bIj().nsD, com.tencent.mm.plugin.backup.b.d.bHb(), b.bIj().nsB, 0, 1);
    locala.B(true, true);
    locala.nyP.nEh = 1;
    locala.bIJ();
    ad.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.nvx == null) {
      this.nvx = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21559);
          if (!c.aMx)
          {
            ad.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
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
    this.nvx.az(3000L, 3000L);
    AppMethodBeat.o(21570);
  }
  
  public static String bIp()
  {
    AppMethodBeat.i(21571);
    String str = com.tencent.mm.plugin.backup.g.b.bIF();
    AppMethodBeat.o(21571);
    return str;
  }
  
  public static void eF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21573);
    ad.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.nCU = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localc.toByteArray(), 18, paramInt2);
      AppMethodBeat.o(21573);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
      AppMethodBeat.o(21573);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.bx.b paramb)
  {
    this.nxW = paramBoolean;
    this.nxX = paramb;
  }
  
  public final void xz(int paramInt)
  {
    AppMethodBeat.i(21572);
    ad.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.nCU = paramInt;
    if (paramInt == 9) {
      localb.nCV = this.nxX;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(localb.toByteArray(), 17);
      AppMethodBeat.o(21572);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */