package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c
  implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.g.b.d
{
  private static boolean aMx = false;
  private static int hiJ = 0;
  private static boolean nAG = false;
  String cVh;
  private boolean hmD;
  private Object lock;
  private LinkedList<String> nAA;
  private LinkedList<Long> nAB;
  public b.a nAC;
  private HashSet<String> nAD;
  private long nAE;
  private long nAF;
  private boolean nAH;
  private int nAI;
  public boolean nAJ;
  private boolean nAK;
  private boolean nAL;
  private boolean nAM;
  private boolean nAN;
  private int nAO;
  public String nAP;
  String nAQ;
  int nAR;
  private aw nAS;
  final com.tencent.mm.ak.f nAT;
  private final com.tencent.mm.ak.f nAU;
  private final com.tencent.mm.ak.f nAV;
  public long nAW;
  private int nAX;
  b.c nAY;
  private final j.a nAZ;
  private com.tencent.mm.plugin.backup.c.d nAu;
  private long nAv;
  private long nAw;
  private long nAx;
  private LinkedList<String> nAy;
  private LinkedList<Long> nAz;
  private long nyl;
  private long nyn;
  private long nyo;
  public com.tencent.mm.plugin.backup.b.b.d nzH;
  private boolean nzM;
  private long recvSize;
  
  public c()
  {
    AppMethodBeat.i(21315);
    this.nyn = 0L;
    this.nyo = -1L;
    this.nAv = 0L;
    this.nyl = 0L;
    this.recvSize = 0L;
    this.nAw = 0L;
    this.nAx = 0L;
    this.lock = new Object();
    this.hmD = false;
    this.nAy = new LinkedList();
    this.nAD = new HashSet();
    this.nAE = 0L;
    this.nAF = 0L;
    this.nAH = true;
    this.nAI = 0;
    this.nAJ = false;
    this.nAK = true;
    this.nAL = true;
    this.nzM = false;
    this.nAM = false;
    this.nAN = false;
    this.nAT = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21300);
        bc.ajj().b(595, c.a(c.this));
        com.tencent.mm.plugin.backup.b.d.xv(22);
        b.bIE().bHV().nye = 1;
        Object localObject2 = new Intent().setClassName(ak.getContext(), "com.tencent.mm.ui.LauncherUI");
        ((Intent)localObject2).addFlags(335544320);
        ((Intent)localObject2).putExtra("nofification_type", "backup_move_notification");
        Object localObject1 = ak.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 41L, 1L, false);
        paramAnonymousn = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bJP();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ae.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
          }
          bc.aCg();
          if (!bu.nullAsNil((String)com.tencent.mm.model.c.ajA().get(2, null)).equals(paramAnonymousn.FSW))
          {
            ae.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
            b.bIE().bHV().nye = -14;
            c.this.xu(-14);
            AppMethodBeat.o(21300);
            return;
          }
          b.bIE().bHV().nye = -5;
          c.this.xu(-5);
          AppMethodBeat.o(21300);
          return;
        }
        bc.aCg();
        if (!bu.nullAsNil((String)com.tencent.mm.model.c.ajA().get(2, null)).equals(paramAnonymousn.FSW))
        {
          ae.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
          b.bIE().bHV().nye = -5;
          c.this.xu(-14);
          AppMethodBeat.o(21300);
          return;
        }
        b.bIE().nxW = paramAnonymousn.ID;
        b.bIE().nxX = paramAnonymousn.FTc;
        b.bIE().nxY = paramAnonymousn.FTd;
        com.tencent.mm.plugin.backup.g.b.a(c.this.nAY);
        b.bIE().bHW();
        com.tencent.mm.plugin.backup.g.b.a(b.bIE().bIH());
        com.tencent.mm.plugin.backup.g.b.a(b.bIE().bIF());
        com.tencent.mm.plugin.backup.g.b.xv(2);
        com.tencent.mm.plugin.backup.g.b.a(c.b(c.this));
        paramAnonymousString = null;
        paramAnonymousInt1 = 0;
        if (paramAnonymousn.FST > 0)
        {
          localObject1 = (abj)paramAnonymousn.FSU.getFirst();
          paramAnonymousString = ((abj)localObject1).Gpn;
          paramAnonymousInt1 = ((Integer)((abj)localObject1).Gtd.getFirst()).intValue();
        }
        for (;;)
        {
          localObject1 = c.this;
          ((c)localObject1).nAP = paramAnonymousn.FSX;
          ((c)localObject1).nAQ = paramAnonymousString;
          ((c)localObject1).nAR = paramAnonymousInt1;
          ae.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousn.nJA), Integer.valueOf(paramAnonymousn.Scene), paramAnonymousn.FSX, paramAnonymousString, Integer.valueOf(paramAnonymousInt1) });
          c.access$202(false);
          ae.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramAnonymousString, paramAnonymousn.FSX, com.tencent.mm.plugin.backup.b.g.el(ak.getContext()) });
          c.bIP();
          c.a(c.this, paramAnonymousString, paramAnonymousInt1);
          AppMethodBeat.o(21300);
          return;
          ae.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
        }
      }
    };
    this.nAU = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21307);
        c.access$202(true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 42L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(11787, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.e(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
          b.bIE().bHV().nye = -5;
          c.this.xu(-5);
          c.this.xy(3);
          AppMethodBeat.o(21307);
          return;
        }
        ae.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        if (paramAnonymousString.nEl.Version < com.tencent.mm.plugin.backup.b.c.nxO)
        {
          ae.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramAnonymousString.nEl.Version) });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 104L, 1L, false);
          b.bIE().bHV().nye = -12;
          c.this.xu(-12);
          AppMethodBeat.o(21307);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.nEl.nJA;
        paramAnonymousn = c.this;
        boolean bool;
        if ((paramAnonymousString.nEl.nJB & com.tencent.mm.plugin.backup.b.c.nxS) == 0)
        {
          bool = false;
          c.a(paramAnonymousn, bool);
          ae.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramAnonymousString.nEl.Version), Integer.valueOf(paramAnonymousInt1), Boolean.valueOf(c.f(c.this)) });
          if ((paramAnonymousInt1 != com.tencent.mm.plugin.backup.b.c.nxQ) || (!c.bIJ())) {
            break label377;
          }
          c.b(c.this, true);
          ae.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
        }
        for (;;)
        {
          c.g(c.this);
          com.tencent.mm.plugin.backup.g.b.a(3, c.h(c.this));
          new com.tencent.mm.plugin.backup.g.k(b.bIE().nxW).bJH();
          b.bIE().bHV().nye = 22;
          c.this.xu(22);
          AppMethodBeat.o(21307);
          return;
          bool = true;
          break;
          label377:
          c.this.bIK();
          c.b(c.this, false);
          ae.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
        }
      }
    };
    this.nAV = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21308);
        com.tencent.mm.plugin.backup.g.b.b(3, c.h(c.this));
        ae.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          b.bIE().bHV().nye = -5;
          c.this.xu(-5);
          AppMethodBeat.o(21308);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.k)paramAnonymousn;
        paramAnonymousn = paramAnonymousString.nFs;
        if (!b.bIE().nxW.equals(paramAnonymousn.ID))
        {
          ae.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
          b.bIE().bHV().nye = -5;
          c.this.xu(-5);
          AppMethodBeat.o(21308);
          return;
        }
        b.bIE().bHV().nym = paramAnonymousn.nIT;
        c.this.cVh = paramAnonymousString.nFs.nIW.nIM;
        label339:
        label364:
        long l;
        if (paramAnonymousString.nFs.nIW.nIP.toLowerCase().contains("ios"))
        {
          c.a(c.this, 1);
          c.a(c.this, paramAnonymousString.nFs.nJa);
          c.b(c.this, paramAnonymousString.nFs.nJc);
          ae.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", new Object[] { Long.valueOf(paramAnonymousString.nFs.nIZ), Long.valueOf(paramAnonymousString.nFs.nJa / 1024L) });
          if ((c.i(c.this)) && (c.f(c.this)))
          {
            paramAnonymousn = com.tencent.mm.plugin.report.service.g.yxI;
            if ((!c.j(c.this)) && (c.k(c.this) != 1)) {
              break label601;
            }
            paramAnonymousInt1 = 66;
            paramAnonymousn.idkeyStat(485L, paramAnonymousInt1, 1L, false);
          }
          if (paramAnonymousString.nFs.nIY != 3) {
            break label607;
          }
          paramAnonymousInt1 = 1;
          if (paramAnonymousInt1 == 0) {
            break label612;
          }
          c.c(c.this, true);
          ae.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
          label384:
          paramAnonymousString = new PLong();
          paramAnonymousn = new PLong();
          bc.aCg();
          com.tencent.mm.plugin.backup.b.g.a(paramAnonymousString, paramAnonymousn, com.tencent.mm.model.c.getAccPath());
          l = c.l(c.this);
          if (c.l(c.this) * 0.1D <= 524288000.0D) {
            break label624;
          }
        }
        label601:
        label607:
        label612:
        label624:
        for (double d = 524288000.0D;; d = c.l(c.this) * 0.1D)
        {
          l = d + l;
          c.this.nAW = l;
          if (paramAnonymousn.value >= l) {
            break label641;
          }
          ae.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramAnonymousn.value), Long.valueOf(l), Long.valueOf(c.l(c.this)) });
          com.tencent.mm.plugin.report.service.g.yxI.f(11787, new Object[] { Integer.valueOf(5) });
          b.bIE().bIF().stop();
          b.bIE().bHV().nye = -13;
          c.this.xu(-13);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 5L, 1L, false);
          AppMethodBeat.o(21308);
          return;
          c.a(c.this, 2);
          break;
          paramAnonymousInt1 = 65;
          break label339;
          paramAnonymousInt1 = 0;
          break label364;
          c.c(c.this, false);
          break label384;
        }
        label641:
        c.b(c.this, bu.fpO());
        com.tencent.mm.plugin.backup.g.b.bJz();
        AppMethodBeat.o(21308);
      }
    };
    this.nAY = new b.c()
    {
      public final void bIT()
      {
        AppMethodBeat.i(21313);
        ae.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bJA();
        b.bIE().bHX();
        AppMethodBeat.o(21313);
      }
    };
    this.nAZ = new j.a()
    {
      public final void bIR()
      {
        AppMethodBeat.i(21301);
        c.this.xu(b.bIE().bHV().nye);
        AppMethodBeat.o(21301);
      }
      
      public final void bIS()
      {
        AppMethodBeat.i(21303);
        int i = b.bIE().bHV().nye;
        ae.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 23) || (i == 4))
        {
          c.this.b(true, false, -4);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 43L, 1L, false);
          c.this.xy(4);
          b.bIE().bIF().stop();
        }
        AppMethodBeat.o(21303);
      }
      
      public final void xz(int paramAnonymousInt)
      {
        AppMethodBeat.i(21302);
        int i = b.bIE().bHV().nye;
        if (paramAnonymousInt == 1)
        {
          if (i == 23)
          {
            ae.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
            b.bIE().bHV().nye = 4;
            c.this.xu(4);
            c.this.xy(8);
            AppMethodBeat.o(21302);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ae.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
          b.bIE().bHV().nye = 23;
          c.this.xu(23);
          c.this.xy(9);
        }
        AppMethodBeat.o(21302);
      }
    };
    AppMethodBeat.o(21315);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(21323);
    y localy = new y();
    localy.nJE = paramString;
    localy.nJF = paramInt1;
    localy.nJH = paramInt2;
    localy.nJI = paramInt3;
    localy.nJb = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21323);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21323);
    }
  }
  
  public static boolean bIJ()
  {
    AppMethodBeat.i(21316);
    boolean bool = bc.aCg().aAl().fsC();
    AppMethodBeat.o(21316);
    return bool;
  }
  
  private void bIL()
  {
    AppMethodBeat.i(21320);
    String str1 = this.nAP;
    String str2 = this.nAQ;
    String str3 = com.tencent.mm.plugin.backup.b.g.el(ak.getContext());
    ae.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(hiJ) });
    if ((str3 == null) || (str3.equals("")))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(11787, new Object[] { Integer.valueOf(1) });
      b.bIE().bHV().nye = -1;
      xu(-1);
      AppMethodBeat.o(21320);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(11787, new Object[] { Integer.valueOf(2) });
      b.bIE().bHV().nye = -2;
      xu(-2);
      AppMethodBeat.o(21320);
      return;
    }
    if (!com.tencent.mm.plugin.backup.b.g.WE(str2))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 3L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(11787, new Object[] { Integer.valueOf(3) });
      b.bIE().bHV().nye = -3;
      xu(-3);
      AppMethodBeat.o(21320);
      return;
    }
    if (hiJ <= 0)
    {
      b.bIE().bHV().nye = -5;
      xu(-5);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 4L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(21320);
      return;
    }
    hiJ -= 1;
    co(this.nAQ, this.nAR);
    AppMethodBeat.o(21320);
  }
  
  public static String bIN()
  {
    AppMethodBeat.i(21327);
    String str = com.tencent.mm.plugin.backup.g.b.bJD();
    AppMethodBeat.o(21327);
    return str;
  }
  
  private static void bIO()
  {
    AppMethodBeat.i(21328);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bIE().nxW;
    try
    {
      ae.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21328);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21328);
    }
  }
  
  private void co(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(21319);
    b.bIE().bIF().connect(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.nAU);
    for (;;)
    {
      try
      {
        if (bu.getInt(com.tencent.mm.n.g.acL().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.nAL = bool;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.bIE().nxX, b.bIE().nxY, com.tencent.mm.plugin.backup.b.d.bHZ(), b.bIE().nxW, com.tencent.mm.plugin.backup.b.c.nxO, 22);
      paramString.B(this.nAL, false);
      paramString.bJH();
      ae.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.nAS == null) {
        this.nAS = new aw(new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(21306);
            if (!c.aMx)
            {
              ae.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
              if (c.c(c.this) != null) {
                c.c(c.this).stopTimer();
              }
              c.d(c.this);
            }
            AppMethodBeat.o(21306);
            return true;
          }
        }, false);
      }
      this.nAS.ay(3000L, 3000L);
      AppMethodBeat.o(21319);
      return;
      bool = false;
    }
  }
  
  public final void a(boolean paramBoolean, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2)
  {
    AppMethodBeat.i(21321);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      ae.i("MicroMsg.BackupMoveRecoverServer", "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break label380;
      }
      paramInt1 = b.bIE().bHV().nye;
      ae.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      }
    }
    long l;
    for (;;)
    {
      AppMethodBeat.o(21321);
      return;
      i = paramArrayOfByte.length;
      break;
      b.bIE().bIF().stop();
      if (!aMx)
      {
        if (this.nAS != null)
        {
          ae.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.nAS.stopTimer();
        }
        bIL();
        AppMethodBeat.o(21321);
        return;
      }
      b.bIE().bHV().nye = -4;
      xu(-4);
      AppMethodBeat.o(21321);
      return;
      b.bIE().bIF().stop();
      AppMethodBeat.o(21321);
      return;
      b(true, false, -4);
      b.bIE().bIF().stop();
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 43L, 1L, false);
      xy(4);
      l = 0L;
      if (this.nAE != 0L) {
        l = bu.DD(this.nAE);
      }
      ae.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.nyl), Long.valueOf(this.recvSize), Long.valueOf(l) });
      AppMethodBeat.o(21321);
      return;
      b(true, false, 0);
    }
    label380:
    if (paramInt1 == 9)
    {
      com.tencent.mm.plugin.backup.i.e locale = (com.tencent.mm.plugin.backup.i.e)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.e(), paramArrayOfByte);
      if (locale == null)
      {
        ae.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bu.cG(paramArrayOfByte)) });
        AppMethodBeat.o(21321);
        return;
      }
      ae.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.nEQ) });
      paramArrayOfByte = new com.tencent.mm.plugin.backup.i.f();
      paramArrayOfByte.nEQ = locale.nEQ;
      try
      {
        ae.d("MicroMsg.BackupMoveRecoverServer", "onNotify send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.t(paramArrayOfByte.toByteArray(), 10, paramInt2);
        AppMethodBeat.o(21321);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ae.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramArrayOfByte, "onNotify buf to BackupHeartBeatResponse err.", new Object[0]);
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 10)
    {
      paramArrayOfByte = (com.tencent.mm.plugin.backup.i.f)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.nEQ;; l = -1L)
      {
        ae.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 51L, 1L, false);
      b(true, false, -100);
    }
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21309);
        if (paramInt1 == 11)
        {
          c.a(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21309);
          return;
        }
        if (paramInt1 == 6)
        {
          c.b(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21309);
          return;
        }
        if (paramInt1 == 13)
        {
          c.J(paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21309);
          return;
        }
        if (paramInt1 == 15)
        {
          c.c(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21309);
          return;
        }
        if (paramInt1 == 8)
        {
          c.a(c.this, paramArrayOfByte);
          AppMethodBeat.o(21309);
          return;
        }
        AppMethodBeat.o(21309);
      }
    });
    AppMethodBeat.o(21321);
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21318);
    ae.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), au.foQ() });
    if (!paramBoolean1) {
      bIO();
    }
    synchronized (this.lock)
    {
      this.hmD = true;
      if ((this.nAu != null) && (this.nAu.nzB))
      {
        this.nAu.x(paramBoolean2, paramInt);
        this.nAu = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bIE().bHV().nye = paramInt;
          xu(paramInt);
        }
        if (paramBoolean2) {
          bIK();
        }
        com.tencent.mm.plugin.backup.g.b.bJA();
        com.tencent.mm.plugin.backup.g.b.bJC();
        b.bIE().bHX();
        b.bIE().bIF().nyD = null;
        AppMethodBeat.o(21318);
        return;
      }
      i = 1;
    }
  }
  
  public final void bHU()
  {
    AppMethodBeat.i(21330);
    long l1 = bu.DD(this.nAF) / 1000L;
    long l2 = b.bIE().bHV().nyp;
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 49L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 50L, l1, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 72L, l2, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 52L, this.recvSize / 1024L, false);
    this.nAv = com.tencent.mm.vfs.o.aZR(com.tencent.mm.kernel.g.ajR().ajy());
    com.tencent.mm.plugin.report.service.g.yxI.f(17868, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.nAw / 1024L), Long.valueOf(this.nAx / 1024L), Long.valueOf(this.nyn / 1024L), Long.valueOf(this.nAv / 1024L), Long.valueOf(this.nyo), Long.valueOf(l2) });
    ae.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.nAw / 1024L), Long.valueOf(this.nAx / 1024L), Long.valueOf(this.nyn / 1024L), Long.valueOf(this.nAv / 1024L), Long.valueOf(this.nyo), Long.valueOf(l2) });
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IRG, Boolean.TRUE);
    ae.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    if (com.tencent.mm.plugin.backup.b.g.nyx)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      StringBuilder localStringBuilder = new StringBuilder("\nMerge Info:\n");
      localStringBuilder.append("mergeStartTime:").append(((SimpleDateFormat)localObject).format(new Date(this.nAF))).append("\n");
      localStringBuilder.append("mergeTime:").append(l1).append("\n");
      localStringBuilder.append("totalMsgCount:").append(l2).append("\n");
      localStringBuilder.append("recvSize:").append(this.recvSize / 1024L).append(" kB\n");
      com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.bIk(), "backupTestInfo.txt", localStringBuilder.toString().getBytes());
    }
    if (!this.nzM)
    {
      localObject = bc.aCg().aAk().fsE();
      if (((LinkedList)localObject).size() > 0) {
        break label583;
      }
      ae.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      bIK();
      com.tencent.mm.plugin.backup.g.b.xH(22);
      com.tencent.mm.plugin.backup.g.b.bJA();
      com.tencent.mm.plugin.backup.g.b.bJC();
      AppMethodBeat.o(21330);
      return;
      label583:
      ae.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      bc.aCg().aAj().i(this.cVh, (LinkedList)localObject);
    }
  }
  
  public final void bIK()
  {
    AppMethodBeat.i(21317);
    ae.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.nAD.clear();
    if (!com.tencent.mm.plugin.backup.b.g.nyx)
    {
      com.tencent.mm.plugin.backup.b.g.WA(com.tencent.mm.plugin.backup.b.g.bIi());
      com.tencent.mm.plugin.backup.b.g.bIg();
    }
    AppMethodBeat.o(21317);
  }
  
  public final void bIM()
  {
    AppMethodBeat.i(21325);
    b(true, false, 28);
    b.bIE().bIF().stop();
    AppMethodBeat.o(21325);
  }
  
  public final void iy(boolean paramBoolean)
  {
    AppMethodBeat.i(21326);
    synchronized (this.lock)
    {
      if ((this.nAu != null) && (this.nAu.nzB))
      {
        ae.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21326);
        return;
      }
      if (this.nAu != null) {
        this.nAu.x(false, 0);
      }
      if ((this.nAD == null) || (this.nAD.size() <= 0))
      {
        i = bc.aCg().aAl().fsD();
        b.bIE().bHV().nye = 26;
        b.bIE().bHV().nyh = 0;
        xu(26);
        com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
        this.nAF = bu.fpO();
        this.nAu = new com.tencent.mm.plugin.backup.c.d(b.bIE(), 2, this, i, false, new LinkedList(), new LinkedList());
        this.nAu.iy(paramBoolean);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(21326);
        return;
      }
      int i = this.nAD.size();
    }
  }
  
  public final void iz(boolean paramBoolean)
  {
    AppMethodBeat.i(21322);
    this.nAN = paramBoolean;
    Object localObject = new LinkedBlockingQueue();
    b.bIE().bIF().nyD = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21310);
        for (;;)
        {
          if (!c.m(c.this)) {}
          try
          {
            boolean bool = this.nBc.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              ae.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.nBc.size()) });
              AppMethodBeat.o(21310);
              return;
            }
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.MqF.aR(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "startSendRequestSessionResponse.onNotifyWorker";
      }
      
      public final void run()
      {
        AppMethodBeat.i(21311);
        for (;;)
        {
          if ((!c.m(c.this)) && (!c.bIQ())) {
            try
            {
              c.a locala = (c.a)this.nBc.poll(500L, TimeUnit.MILLISECONDS);
              ae.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.nBc.size()), locala });
              if (locala != null) {
                c.this.a(locala.dDV, locala.type, locala.buf, locala.iqb);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Object localObject = null;
              }
            }
          }
        }
        AppMethodBeat.o(21311);
      }
    });
    if ((!this.nzM) && (!paramBoolean))
    {
      localObject = this.nAA;
      LinkedList localLinkedList = this.nAB;
      this.nAA = new LinkedList();
      this.nAB = new LinkedList();
      bc.aCg().aAj().a(this.cVh, (LinkedList)localObject, localLinkedList, this.nAA, this.nAB);
    }
    localObject = new j();
    ((j)localObject).nIF = this.nAA;
    ((j)localObject).nIG = this.nAB;
    try
    {
      ae.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(((j)localObject).nIF.size()), Integer.valueOf(((j)localObject).nIG.size()) });
      com.tencent.mm.plugin.backup.g.b.t(((j)localObject).toByteArray(), 12, this.nAX);
      com.tencent.mm.plugin.backup.g.b.bJB();
      if (this.nAM)
      {
        b.bIE().bHV().R(23, 1, this.nAy.size());
        this.nyl = b.bIE().bHV().nyl;
        this.recvSize = b.bIE().bHV().nyi;
        this.nAw = b.bIE().bHV().nyj;
        this.nAx = b.bIE().bHV().nyk;
        this.nyn = b.bIE().bHV().nyn;
        this.nyo = b.bIE().bHV().nyo;
        com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
        this.nyo = -1L;
        com.tencent.e.h.MqF.aR(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "getMsgCount";
          }
          
          public final void run()
          {
            AppMethodBeat.i(21312);
            c.c(c.this, com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().dpa());
            b.bIE().bHV().nyo = c.n(c.this);
            AppMethodBeat.o(21312);
          }
        });
        xu(23);
        AppMethodBeat.o(21322);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupRequestSessionResponse err.", new Object[0]);
        continue;
        b.bIE().bHV().a(23, 1, this.nAy.size(), 0L, this.nyl, 0L, 0L);
        this.nyn = com.tencent.mm.vfs.o.aZR(com.tencent.mm.kernel.g.ajR().ajy());
        b.bIE().bHV().nyn = this.nyn;
      }
    }
  }
  
  public final void xu(final int paramInt)
  {
    AppMethodBeat.i(21329);
    if (this.nzH != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21304);
          if (c.o(c.this) != null) {
            c.o(c.this).xu(paramInt);
          }
          AppMethodBeat.o(21304);
        }
      });
    }
    if (this.nAC != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21305);
          if (c.p(c.this) != null) {
            c.p(c.this).xt(paramInt);
          }
          AppMethodBeat.o(21305);
        }
      });
    }
    AppMethodBeat.o(21329);
  }
  
  public final void xy(int paramInt)
  {
    AppMethodBeat.i(21324);
    long l = 0L;
    if (this.nAE != 0L) {
      l = bu.DD(this.nAE);
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.nAO), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.nyn / 1024L) });
    ae.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.nyl / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.nyn / 1024L) });
    AppMethodBeat.o(21324);
  }
  
  final class a
  {
    byte[] buf;
    boolean dDV;
    int iqb;
    int type;
    
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(21314);
      this.dDV = false;
      this.iqb = paramInt1;
      this.type = paramInt2;
      this.buf = ((byte[])paramArrayOfByte.clone());
      AppMethodBeat.o(21314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c
 * JD-Core Version:    0.7.0.1
 */