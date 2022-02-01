package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class c
{
  private static boolean aKG = false;
  private static int gLY = 2;
  private au mVa;
  final com.tencent.mm.ak.g mVb;
  private final com.tencent.mm.ak.g mVc;
  b.c mVg;
  private final j.a mVh;
  private com.tencent.mm.bw.b mXA;
  public int mXB;
  public boolean mXC;
  private final b.d mXD;
  public final h.a mXE;
  public int mXv;
  public String mXw;
  String mXx;
  int mXy;
  boolean mXz;
  
  public c()
  {
    AppMethodBeat.i(21569);
    this.mXv = 0;
    this.mXC = true;
    this.mVb = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21558);
        az.agi().b(595, c.a(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.wUl.idkeyStat(400L, 111L, 1L, false);
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ac.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
          }
          b.bEa().bCP().mSk = -5;
          b.bEa().bEc().tc(-5);
          AppMethodBeat.o(21558);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bEI();
        az.ayM();
        if (!bs.nullAsNil((String)com.tencent.mm.model.c.agA().get(2, null)).equals(paramAnonymousString.DVf))
        {
          ac.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
          b.bEa().bCP().mSk = -5;
          b.bEa().bEc().tc(-5);
          h.wUl.idkeyStat(400L, 112L, 1L, false);
          AppMethodBeat.o(21558);
          return;
        }
        if ((paramAnonymousString.DVd == null) || (paramAnonymousString.DVd.size() <= 0) || (paramAnonymousString.DVd.getFirst() == null))
        {
          paramAnonymousInt1 = paramAnonymousString.DVc;
          if (paramAnonymousString.DVd == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousString.DVd.size())
          {
            ac.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
            b.bEa().bCP().mSk = -5;
            b.bEa().bEc().tc(-5);
            h.wUl.idkeyStat(400L, 113L, 1L, false);
            AppMethodBeat.o(21558);
            return;
          }
        }
        Object localObject = (za)paramAnonymousString.DVd.getFirst();
        paramAnonymousn = ((za)localObject).EpD;
        paramAnonymousInt1 = ((Integer)((za)localObject).Etf.getFirst()).intValue();
        localObject = c.this;
        ((c)localObject).mXw = paramAnonymousString.DVg;
        ((c)localObject).mXx = paramAnonymousn;
        ((c)localObject).mXy = paramAnonymousInt1;
        ac.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousString.ndI), Integer.valueOf(paramAnonymousString.Scene), paramAnonymousString.DVg, paramAnonymousn, Integer.valueOf(paramAnonymousInt1) });
        b.bEa().mSc = paramAnonymousString.ID;
        b.bEa().mSd = paramAnonymousString.DVl;
        b.bEa().mSe = paramAnonymousString.DVm;
        b.bEa().mSi = paramAnonymousString.DUt.getBufferToBytes();
        c.b(c.this);
        AppMethodBeat.o(21558);
      }
    };
    this.mVc = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21560);
        c.bvu();
        h.wUl.f(13736, new Object[] { Integer.valueOf(0), c.e(c.this), com.tencent.mm.plugin.backup.b.g.eh(ai.getContext()), Integer.valueOf(0), Integer.valueOf(b.bEa().bEb().mXB) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.f(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          switch (paramAnonymousInt2)
          {
          case -2: 
          default: 
            h.wUl.idkeyStat(400L, 116L, 1L, false);
          }
          for (;;)
          {
            h.wUl.f(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(c.this)) });
            b.bEa().bCP().mSk = -5;
            b.bEa().bEc().tc(-5);
            AppMethodBeat.o(21560);
            return;
            h.wUl.idkeyStat(400L, 114L, 1L, false);
            continue;
            h.wUl.idkeyStat(400L, 115L, 1L, false);
          }
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        boolean bool1;
        boolean bool2;
        label319:
        boolean bool3;
        if ((paramAnonymousString.mYt.ndJ & com.tencent.mm.plugin.backup.b.c.mRZ) == 0)
        {
          bool1 = false;
          if ((paramAnonymousString.mYt.ndJ & com.tencent.mm.plugin.backup.b.c.mSa) != 0) {
            break label436;
          }
          bool2 = false;
          if ((paramAnonymousString.mYt.ndJ & com.tencent.mm.plugin.backup.b.c.mSb) != 0) {
            break label442;
          }
          bool3 = false;
          label336:
          ac.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (!bool3) {
            break label466;
          }
          if (paramAnonymousString.mYt.ndL != null) {
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
          b.bEa().bEc().mXQ = bool1;
          b.bEa().bEc().mXR = bool2;
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
          paramAnonymousString = paramAnonymousString.mYt.ndL;
          break label388;
          label459:
          ac.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
          label466:
          c.this.a(false, null);
        }
      }
    };
    this.mXD = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21561);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label251;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.bEa().bCP().mSk;
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          if (!c.aKG)
          {
            if (c.c(c.this) != null)
            {
              ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
              c.c(c.this).stopTimer();
            }
            c.d(c.this);
            AppMethodBeat.o(21561);
            return;
          }
          b.bEa().bDz().stop();
          b.bEa().bCP().mSk = -4;
          b.bEa().bEc().tc(-4);
          AppMethodBeat.o(21561);
          return;
          b.bEa().bDz().stop();
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
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.ncx) });
            i = localb.ncx;
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ac.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramAnonymousArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
            continue;
            az.ayM();
            if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKK, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            b.bEa();
            paramAnonymousArrayOfByte = b.bCU().getString("BACKUP_PC_CHOOSE_SESSION", null);
            if (paramAnonymousArrayOfByte != null) {
              continue;
            }
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
            h.wUl.idkeyStat(400L, 29L, 1L, false);
            c.this.mXv = 3;
            paramAnonymousArrayOfByte = new LinkedList(Arrays.asList(com.tencent.mm.plugin.backup.b.g.em(paramAnonymousArrayOfByte, ",")));
            b.bEa().bEc().init();
            b.bEa().bEc().H(paramAnonymousArrayOfByte);
            c.eC(5, paramAnonymousInt2);
            b.bEa().bEc().bCN();
            c.this.wT(6);
            paramAnonymousArrayOfByte = b.bEa().bEc();
            com.tencent.mm.plugin.backup.h.d.bEP().bES();
            paramAnonymousArrayOfByte.rc(paramAnonymousArrayOfByte.mVl.size());
            continue;
            c.b(c.this, 3, paramAnonymousInt2);
            continue;
            az.ayM();
            if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKL, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            b.bEa().bEd();
            if (d.bDD()) {
              continue;
            }
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
            h.wUl.idkeyStat(400L, 30L, 1L, false);
            c.this.mXv = 4;
            b.bEa().bEd().init();
            c.eC(7, paramAnonymousInt2);
            b.bEa().bEc().bCN();
            c.this.wT(8);
            continue;
            AppMethodBeat.o(21561);
          }
          if (paramAnonymousInt1 != 5) {
            continue;
          }
          ac.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
          h.wUl.f(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.bEa().bEb().mXB) });
          b.bEa().bCP().mSk = -100;
          b.bEa().bEc().tc(-100);
          AppMethodBeat.o(21561);
          return;
          c.a(c.this, 1, paramAnonymousInt2);
        }
      }
    };
    this.mVh = new j.a()
    {
      public final void bDK()
      {
        AppMethodBeat.i(21563);
        int i = b.bEa().bEb().mXv;
        if ((1 == i) || (3 == i))
        {
          b.bEa().bEc().tc(b.bEa().bCP().mSk);
          AppMethodBeat.o(21563);
          return;
        }
        if ((2 == i) || (4 == i)) {
          b.bEa().bEd().wJ(b.bEa().bCP().mSk);
        }
        AppMethodBeat.o(21563);
      }
      
      public final void bDL()
      {
        AppMethodBeat.i(21565);
        int i = b.bEa().bCP().mSk;
        ac.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        int j = b.bEa().bEb().mXv;
        if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
        {
          b.bEa().bDz().stop();
          b.bEa().bEc().cancel(true);
          h.wUl.idkeyStat(400L, 9L, 1L, false);
          b.bEa().bEc().wU(18);
          b.bEa().bCP().mSk = -4;
          b.bEa().bEc().tc(-4);
          AppMethodBeat.o(21565);
          return;
        }
        if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
        {
          b.bEa().bDz().stop();
          b.bEa().bEd().b(true, false, -4);
          h.wUl.idkeyStat(400L, 17L, 1L, false);
          b.bEa().bEd().wU(18);
        }
        AppMethodBeat.o(21565);
      }
      
      public final void wO(int paramAnonymousInt)
      {
        AppMethodBeat.i(21564);
        int i = b.bEa().bCP().mSk;
        if (paramAnonymousInt == 1)
        {
          if (((1 == c.h(c.this)) || (3 == c.h(c.this))) && (i == 14))
          {
            ac.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bEa().bCP().mSk = 4;
            b.bEa().bEc().tc(4);
            AppMethodBeat.o(21564);
            return;
          }
          if (((2 == c.h(c.this)) || (4 == c.h(c.this))) && (i == 23))
          {
            ac.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.bEa().bCP().mSk = 4;
            b.bEa().bEd().wJ(4);
            AppMethodBeat.o(21564);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ac.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
          if ((1 == c.h(c.this)) || (3 == c.h(c.this)))
          {
            b.bEa().bCP().mSk = 14;
            b.bEa().bEc().tc(14);
            AppMethodBeat.o(21564);
            return;
          }
          if ((2 == c.h(c.this)) || (4 == c.h(c.this)))
          {
            b.bEa().bCP().mSk = 23;
            b.bEa().bEd().wJ(23);
          }
        }
        AppMethodBeat.o(21564);
      }
    };
    this.mXE = new h.a()
    {
      public final void bEh()
      {
        AppMethodBeat.i(21566);
        ac.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        int i;
        if (b.bEa().bCP().mSk != 5)
        {
          b.bEa().bCP().mSk = 5;
          i = b.bEa().bEb().mXv;
          if ((1 != i) && (3 != i)) {
            break label82;
          }
          b.bEa().bEc().tc(5);
        }
        for (;;)
        {
          c.this.wT(9);
          AppMethodBeat.o(21566);
          return;
          label82:
          if ((2 == i) || (4 == i)) {
            b.bEa().bEd().wJ(5);
          }
        }
      }
      
      public final void bEi()
      {
        AppMethodBeat.i(21567);
        int i = c.this.mXv;
        ac.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        if ((1 == i) || (3 == i))
        {
          b.bEa().bEc();
          e.bEl();
          b.bEa().bEc().cancel(true);
          b.bEa().bDz().stop();
          b.bEa().bCP().mSk = -4;
          b.bEa().bEc().tc(-4);
          h.wUl.idkeyStat(400L, 9L, 1L, false);
          b.bEa().bEc().wU(3);
          AppMethodBeat.o(21567);
          return;
        }
        if ((2 == i) || (4 == i))
        {
          b.bEa().bEd();
          d.bEj();
          b.bEa().bEd().b(true, false, -4);
          b.bEa().bDz().stop();
          h.wUl.idkeyStat(400L, 17L, 1L, false);
          b.bEa().bEd().wU(3);
        }
        AppMethodBeat.o(21567);
      }
    };
    this.mVg = new b.c()
    {
      public final void bDM()
      {
        AppMethodBeat.i(21568);
        ac.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
        com.tencent.mm.plugin.backup.g.b.bEt();
        b.bEa().bCR();
        AppMethodBeat.o(21568);
      }
    };
    AppMethodBeat.o(21569);
  }
  
  public static void bDI()
  {
    AppMethodBeat.i(21574);
    ac.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bEa().mSc;
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21574);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21574);
    }
  }
  
  private void bEf()
  {
    AppMethodBeat.i(21570);
    b.bEa().bDz().connect(this.mXx, this.mXy);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.mVc);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.bEa().mSd, b.bEa().mSe, com.tencent.mm.plugin.backup.b.d.bCT(), b.bEa().mSc, 0, 1);
    locala.B(true, true);
    locala.mYs.ndK = 1;
    locala.bEA();
    ac.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.mVa == null) {
      this.mVa = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21559);
          if (!c.aKG)
          {
            ac.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
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
    this.mVa.au(3000L, 3000L);
    AppMethodBeat.o(21570);
  }
  
  public static String bEg()
  {
    AppMethodBeat.i(21571);
    String str = com.tencent.mm.plugin.backup.g.b.bEw();
    AppMethodBeat.o(21571);
    return str;
  }
  
  public static void eC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21573);
    ac.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.ncx = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localc.toByteArray(), 18, paramInt2);
      AppMethodBeat.o(21573);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
      AppMethodBeat.o(21573);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.bw.b paramb)
  {
    this.mXz = paramBoolean;
    this.mXA = paramb;
  }
  
  public final void wT(int paramInt)
  {
    AppMethodBeat.i(21572);
    ac.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.ncx = paramInt;
    if (paramInt == 9) {
      localb.ncy = this.mXA;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(localb.toByteArray(), 17);
      AppMethodBeat.o(21572);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */