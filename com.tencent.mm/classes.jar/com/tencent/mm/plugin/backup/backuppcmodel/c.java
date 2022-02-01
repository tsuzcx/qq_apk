package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class c
{
  private static boolean aJQ = false;
  private static int gll = 2;
  private av msY;
  final com.tencent.mm.al.g msZ;
  private final com.tencent.mm.al.g mta;
  b.c mte;
  private final j.a mtf;
  public int mvA;
  public boolean mvB;
  private final b.d mvC;
  public final h.a mvD;
  public int mvu;
  public String mvv;
  String mvw;
  int mvx;
  boolean mvy;
  private com.tencent.mm.bx.b mvz;
  
  public c()
  {
    AppMethodBeat.i(21569);
    this.mvu = 0;
    this.mvB = true;
    this.msZ = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21558);
        az.aeS().b(595, c.a(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.vKh.idkeyStat(400L, 111L, 1L, false);
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ad.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
          }
          b.bxe().bvT().mqj = -5;
          b.bxe().bxg().sm(-5);
          AppMethodBeat.o(21558);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bxM();
        az.arV();
        if (!bt.nullAsNil((String)com.tencent.mm.model.c.afk().get(2, null)).equals(paramAnonymousString.CCI))
        {
          ad.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
          b.bxe().bvT().mqj = -5;
          b.bxe().bxg().sm(-5);
          h.vKh.idkeyStat(400L, 112L, 1L, false);
          AppMethodBeat.o(21558);
          return;
        }
        if ((paramAnonymousString.CCG == null) || (paramAnonymousString.CCG.size() <= 0) || (paramAnonymousString.CCG.getFirst() == null))
        {
          paramAnonymousInt1 = paramAnonymousString.CCF;
          if (paramAnonymousString.CCG == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousString.CCG.size())
          {
            ad.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
            b.bxe().bvT().mqj = -5;
            b.bxe().bxg().sm(-5);
            h.vKh.idkeyStat(400L, 113L, 1L, false);
            AppMethodBeat.o(21558);
            return;
          }
        }
        Object localObject = (yf)paramAnonymousString.CCG.getFirst();
        paramAnonymousn = ((yf)localObject).CWU;
        paramAnonymousInt1 = ((Integer)((yf)localObject).Dai.getFirst()).intValue();
        localObject = c.this;
        ((c)localObject).mvv = paramAnonymousString.CCJ;
        ((c)localObject).mvw = paramAnonymousn;
        ((c)localObject).mvx = paramAnonymousInt1;
        ad.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousString.mBH), Integer.valueOf(paramAnonymousString.Scene), paramAnonymousString.CCJ, paramAnonymousn, Integer.valueOf(paramAnonymousInt1) });
        b.bxe().mqb = paramAnonymousString.ID;
        b.bxe().mqc = paramAnonymousString.CCO;
        b.bxe().mqd = paramAnonymousString.CCP;
        b.bxe().mqh = paramAnonymousString.CBW.getBufferToBytes();
        c.b(c.this);
        AppMethodBeat.o(21558);
      }
    };
    this.mta = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21560);
        c.boz();
        h.vKh.f(13736, new Object[] { Integer.valueOf(0), c.e(c.this), com.tencent.mm.plugin.backup.b.g.dZ(aj.getContext()), Integer.valueOf(0), Integer.valueOf(b.bxe().bxf().mvA) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.f(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          switch (paramAnonymousInt2)
          {
          case -2: 
          default: 
            h.vKh.idkeyStat(400L, 116L, 1L, false);
          }
          for (;;)
          {
            h.vKh.f(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(c.this)) });
            b.bxe().bvT().mqj = -5;
            b.bxe().bxg().sm(-5);
            AppMethodBeat.o(21560);
            return;
            h.vKh.idkeyStat(400L, 114L, 1L, false);
            continue;
            h.vKh.idkeyStat(400L, 115L, 1L, false);
          }
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        boolean bool1;
        boolean bool2;
        label319:
        boolean bool3;
        if ((paramAnonymousString.mws.mBI & com.tencent.mm.plugin.backup.b.c.mpY) == 0)
        {
          bool1 = false;
          if ((paramAnonymousString.mws.mBI & com.tencent.mm.plugin.backup.b.c.mpZ) != 0) {
            break label436;
          }
          bool2 = false;
          if ((paramAnonymousString.mws.mBI & com.tencent.mm.plugin.backup.b.c.mqa) != 0) {
            break label442;
          }
          bool3 = false;
          label336:
          ad.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (!bool3) {
            break label466;
          }
          if (paramAnonymousString.mws.mBK != null) {
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
          b.bxe().bxg().mvP = bool1;
          b.bxe().bxg().mvQ = bool2;
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
          paramAnonymousString = paramAnonymousString.mws.mBK;
          break label388;
          label459:
          ad.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
          label466:
          c.this.a(false, null);
        }
      }
    };
    this.mvC = new b.d()
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
            paramAnonymousInt1 = b.bxe().bvT().mqj;
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
          if (!c.aJQ)
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
          b.bxe().bwD().stop();
          b.bxe().bvT().mqj = -4;
          b.bxe().bxg().sm(-4);
          AppMethodBeat.o(21561);
          return;
          b.bxe().bwD().stop();
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
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.mAw) });
            i = localb.mAw;
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramAnonymousArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
            continue;
            az.arV();
            if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FmV, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            b.bxe();
            paramAnonymousArrayOfByte = b.bvY().getString("BACKUP_PC_CHOOSE_SESSION", null);
            if (paramAnonymousArrayOfByte != null) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
            h.vKh.idkeyStat(400L, 29L, 1L, false);
            c.this.mvu = 3;
            paramAnonymousArrayOfByte = new LinkedList(Arrays.asList(com.tencent.mm.plugin.backup.b.g.ea(paramAnonymousArrayOfByte, ",")));
            b.bxe().bxg().init();
            b.bxe().bxg().H(paramAnonymousArrayOfByte);
            c.ez(5, paramAnonymousInt2);
            b.bxe().bxg().bvR();
            c.this.wc(6);
            paramAnonymousArrayOfByte = b.bxe().bxg();
            com.tencent.mm.plugin.backup.h.d.bxT().bxW();
            paramAnonymousArrayOfByte.nq(paramAnonymousArrayOfByte.mtj.size());
            continue;
            c.b(c.this, 3, paramAnonymousInt2);
            continue;
            az.arV();
            if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FmW, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            b.bxe().bxh();
            if (d.bwH()) {
              continue;
            }
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
            h.vKh.idkeyStat(400L, 30L, 1L, false);
            c.this.mvu = 4;
            b.bxe().bxh().init();
            c.ez(7, paramAnonymousInt2);
            b.bxe().bxg().bvR();
            c.this.wc(8);
            continue;
            AppMethodBeat.o(21561);
          }
          if (paramAnonymousInt1 != 5) {
            continue;
          }
          ad.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
          h.vKh.f(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.bxe().bxf().mvA) });
          b.bxe().bvT().mqj = -100;
          b.bxe().bxg().sm(-100);
          AppMethodBeat.o(21561);
          return;
          c.a(c.this, 1, paramAnonymousInt2);
        }
      }
    };
    this.mtf = new j.a()
    {
      public final void bwO()
      {
        AppMethodBeat.i(21563);
        int i = b.bxe().bxf().mvu;
        if ((1 == i) || (3 == i))
        {
          b.bxe().bxg().sm(b.bxe().bvT().mqj);
          AppMethodBeat.o(21563);
          return;
        }
        if ((2 == i) || (4 == i)) {
          b.bxe().bxh().vS(b.bxe().bvT().mqj);
        }
        AppMethodBeat.o(21563);
      }
      
      public final void bwP()
      {
        AppMethodBeat.i(21565);
        int i = b.bxe().bvT().mqj;
        ad.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        int j = b.bxe().bxf().mvu;
        if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
        {
          b.bxe().bwD().stop();
          b.bxe().bxg().cancel(true);
          h.vKh.idkeyStat(400L, 9L, 1L, false);
          b.bxe().bxg().wd(18);
          b.bxe().bvT().mqj = -4;
          b.bxe().bxg().sm(-4);
          AppMethodBeat.o(21565);
          return;
        }
        if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
        {
          b.bxe().bwD().stop();
          b.bxe().bxh().b(true, false, -4);
          h.vKh.idkeyStat(400L, 17L, 1L, false);
          b.bxe().bxh().wd(18);
        }
        AppMethodBeat.o(21565);
      }
      
      public final void vX(int paramAnonymousInt)
      {
        AppMethodBeat.i(21564);
        int i = b.bxe().bvT().mqj;
        if (paramAnonymousInt == 1)
        {
          if (((1 == c.h(c.this)) || (3 == c.h(c.this))) && (i == 14))
          {
            ad.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bxe().bvT().mqj = 4;
            b.bxe().bxg().sm(4);
            AppMethodBeat.o(21564);
            return;
          }
          if (((2 == c.h(c.this)) || (4 == c.h(c.this))) && (i == 23))
          {
            ad.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bxe().bvT().mqj = 4;
            b.bxe().bxh().vS(4);
            AppMethodBeat.o(21564);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ad.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
          if ((1 == c.h(c.this)) || (3 == c.h(c.this)))
          {
            b.bxe().bvT().mqj = 14;
            b.bxe().bxg().sm(14);
            AppMethodBeat.o(21564);
            return;
          }
          if ((2 == c.h(c.this)) || (4 == c.h(c.this)))
          {
            b.bxe().bvT().mqj = 23;
            b.bxe().bxh().vS(23);
          }
        }
        AppMethodBeat.o(21564);
      }
    };
    this.mvD = new h.a()
    {
      public final void bxl()
      {
        AppMethodBeat.i(21566);
        ad.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        int i;
        if (b.bxe().bvT().mqj != 5)
        {
          b.bxe().bvT().mqj = 5;
          i = b.bxe().bxf().mvu;
          if ((1 != i) && (3 != i)) {
            break label82;
          }
          b.bxe().bxg().sm(5);
        }
        for (;;)
        {
          c.this.wc(9);
          AppMethodBeat.o(21566);
          return;
          label82:
          if ((2 == i) || (4 == i)) {
            b.bxe().bxh().vS(5);
          }
        }
      }
      
      public final void bxm()
      {
        AppMethodBeat.i(21567);
        int i = c.this.mvu;
        ad.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        if ((1 == i) || (3 == i))
        {
          b.bxe().bxg();
          e.bxp();
          b.bxe().bxg().cancel(true);
          b.bxe().bwD().stop();
          b.bxe().bvT().mqj = -4;
          b.bxe().bxg().sm(-4);
          h.vKh.idkeyStat(400L, 9L, 1L, false);
          b.bxe().bxg().wd(3);
          AppMethodBeat.o(21567);
          return;
        }
        if ((2 == i) || (4 == i))
        {
          b.bxe().bxh();
          d.bxn();
          b.bxe().bxh().b(true, false, -4);
          b.bxe().bwD().stop();
          h.vKh.idkeyStat(400L, 17L, 1L, false);
          b.bxe().bxh().wd(3);
        }
        AppMethodBeat.o(21567);
      }
    };
    this.mte = new b.c()
    {
      public final void bwQ()
      {
        AppMethodBeat.i(21568);
        ad.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
        com.tencent.mm.plugin.backup.g.b.bxx();
        b.bxe().bvV();
        AppMethodBeat.o(21568);
      }
    };
    AppMethodBeat.o(21569);
  }
  
  public static void bwM()
  {
    AppMethodBeat.i(21574);
    ad.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bxe().mqb;
    try
    {
      com.tencent.mm.plugin.backup.g.b.N(locala.toByteArray(), 5);
      AppMethodBeat.o(21574);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21574);
    }
  }
  
  private void bxj()
  {
    AppMethodBeat.i(21570);
    b.bxe().bwD().connect(this.mvw, this.mvx);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.mta);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.bxe().mqc, b.bxe().mqd, com.tencent.mm.plugin.backup.b.d.bvX(), b.bxe().mqb, 0, 1);
    locala.A(true, true);
    locala.mwr.mBJ = 1;
    locala.bxE();
    ad.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.msY == null) {
      this.msY = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21559);
          if (!c.aJQ)
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
    this.msY.av(3000L, 3000L);
    AppMethodBeat.o(21570);
  }
  
  public static String bxk()
  {
    AppMethodBeat.i(21571);
    String str = com.tencent.mm.plugin.backup.g.b.bxA();
    AppMethodBeat.o(21571);
    return str;
  }
  
  public static void ez(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21573);
    ad.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.mAw = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.u(localc.toByteArray(), 18, paramInt2);
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
    this.mvy = paramBoolean;
    this.mvz = paramb;
  }
  
  public final void wc(int paramInt)
  {
    AppMethodBeat.i(21572);
    ad.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.mAw = paramInt;
    if (paramInt == 9) {
      localb.mAx = this.mvz;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.N(localb.toByteArray(), 17);
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