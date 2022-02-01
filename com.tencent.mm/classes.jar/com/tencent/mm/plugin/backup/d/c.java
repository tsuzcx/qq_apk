package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c
  implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.g.b.d
{
  private static boolean aJQ = false;
  private static int gll = 0;
  private static boolean msM = false;
  String cLR;
  private boolean gqP;
  private Object lock;
  private long mqq;
  private long mqs;
  private long mqt;
  public com.tencent.mm.plugin.backup.b.b.d mrM;
  private boolean mrR;
  private com.tencent.mm.plugin.backup.c.d msA;
  private long msB;
  private long msC;
  private long msD;
  private LinkedList<String> msE;
  private LinkedList<Long> msF;
  private LinkedList<String> msG;
  private LinkedList<Long> msH;
  public b.a msI;
  private HashSet<String> msJ;
  private long msK;
  private long msL;
  private boolean msN;
  private int msO;
  public boolean msP;
  private boolean msQ;
  private boolean msR;
  private boolean msS;
  private boolean msT;
  private int msU;
  public String msV;
  String msW;
  int msX;
  private av msY;
  final com.tencent.mm.al.g msZ;
  private final com.tencent.mm.al.g mta;
  private final com.tencent.mm.al.g mtb;
  public long mtc;
  private int mtd;
  b.c mte;
  private final j.a mtf;
  private long recvSize;
  
  public c()
  {
    AppMethodBeat.i(21315);
    this.mqs = 0L;
    this.mqt = -1L;
    this.msB = 0L;
    this.mqq = 0L;
    this.recvSize = 0L;
    this.msC = 0L;
    this.msD = 0L;
    this.lock = new Object();
    this.gqP = false;
    this.msE = new LinkedList();
    this.msJ = new HashSet();
    this.msK = 0L;
    this.msL = 0L;
    this.msN = true;
    this.msO = 0;
    this.msP = false;
    this.msQ = true;
    this.msR = true;
    this.mrR = false;
    this.msS = false;
    this.msT = false;
    this.msZ = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21300);
        az.aeS().b(595, c.a(c.this));
        com.tencent.mm.plugin.backup.b.d.vT(22);
        b.bwC().bvT().mqj = 1;
        Object localObject2 = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
        ((Intent)localObject2).addFlags(335544320);
        ((Intent)localObject2).putExtra("nofification_type", "backup_move_notification");
        Object localObject1 = aj.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 41L, 1L, false);
        paramAnonymousn = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bxM();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
          }
          az.arV();
          if (!bt.nullAsNil((String)com.tencent.mm.model.c.afk().get(2, null)).equals(paramAnonymousn.CCI))
          {
            ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
            b.bwC().bvT().mqj = -14;
            c.this.vS(-14);
            AppMethodBeat.o(21300);
            return;
          }
          b.bwC().bvT().mqj = -5;
          c.this.vS(-5);
          AppMethodBeat.o(21300);
          return;
        }
        az.arV();
        if (!bt.nullAsNil((String)com.tencent.mm.model.c.afk().get(2, null)).equals(paramAnonymousn.CCI))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
          b.bwC().bvT().mqj = -5;
          c.this.vS(-14);
          AppMethodBeat.o(21300);
          return;
        }
        b.bwC().mqb = paramAnonymousn.ID;
        b.bwC().mqc = paramAnonymousn.CCO;
        b.bwC().mqd = paramAnonymousn.CCP;
        com.tencent.mm.plugin.backup.g.b.a(c.this.mte);
        b.bwC().bvU();
        com.tencent.mm.plugin.backup.g.b.a(b.bwC().bwF());
        com.tencent.mm.plugin.backup.g.b.a(b.bwC().bwD());
        com.tencent.mm.plugin.backup.g.b.vT(2);
        com.tencent.mm.plugin.backup.g.b.a(c.b(c.this));
        paramAnonymousString = null;
        paramAnonymousInt1 = 0;
        if (paramAnonymousn.CCF > 0)
        {
          localObject1 = (yf)paramAnonymousn.CCG.getFirst();
          paramAnonymousString = ((yf)localObject1).CWU;
          paramAnonymousInt1 = ((Integer)((yf)localObject1).Dai.getFirst()).intValue();
        }
        for (;;)
        {
          localObject1 = c.this;
          ((c)localObject1).msV = paramAnonymousn.CCJ;
          ((c)localObject1).msW = paramAnonymousString;
          ((c)localObject1).msX = paramAnonymousInt1;
          ad.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousn.mBH), Integer.valueOf(paramAnonymousn.Scene), paramAnonymousn.CCJ, paramAnonymousString, Integer.valueOf(paramAnonymousInt1) });
          c.access$202(false);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramAnonymousString, paramAnonymousn.CCJ, com.tencent.mm.plugin.backup.b.g.dZ(aj.getContext()) });
          c.bwN();
          c.a(c.this, paramAnonymousString, paramAnonymousInt1);
          AppMethodBeat.o(21300);
          return;
          ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
        }
      }
    };
    this.mta = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21307);
        c.access$202(true);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 42L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.f(11787, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.e(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
          b.bwC().bvT().mqj = -5;
          c.this.vS(-5);
          c.this.vW(3);
          AppMethodBeat.o(21307);
          return;
        }
        ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        if (paramAnonymousString.mws.Version < com.tencent.mm.plugin.backup.b.c.mpT)
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramAnonymousString.mws.Version) });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 104L, 1L, false);
          b.bwC().bvT().mqj = -12;
          c.this.vS(-12);
          AppMethodBeat.o(21307);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.mws.mBH;
        paramAnonymousn = c.this;
        boolean bool;
        if ((paramAnonymousString.mws.mBI & com.tencent.mm.plugin.backup.b.c.mpX) == 0)
        {
          bool = false;
          c.a(paramAnonymousn, bool);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramAnonymousString.mws.Version), Integer.valueOf(paramAnonymousInt1), Boolean.valueOf(c.f(c.this)) });
          if ((paramAnonymousInt1 != com.tencent.mm.plugin.backup.b.c.mpV) || (!c.bwH())) {
            break label377;
          }
          c.b(c.this, true);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
        }
        for (;;)
        {
          c.g(c.this);
          com.tencent.mm.plugin.backup.g.b.a(3, c.h(c.this));
          new com.tencent.mm.plugin.backup.g.k(b.bwC().mqb).bxE();
          b.bwC().bvT().mqj = 22;
          c.this.vS(22);
          AppMethodBeat.o(21307);
          return;
          bool = true;
          break;
          label377:
          c.this.bwI();
          c.b(c.this, false);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
        }
      }
    };
    this.mtb = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21308);
        com.tencent.mm.plugin.backup.g.b.b(3, c.h(c.this));
        ad.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          b.bwC().bvT().mqj = -5;
          c.this.vS(-5);
          AppMethodBeat.o(21308);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.k)paramAnonymousn;
        paramAnonymousn = paramAnonymousString.mxz;
        if (!b.bwC().mqb.equals(paramAnonymousn.ID))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
          b.bwC().bvT().mqj = -5;
          c.this.vS(-5);
          AppMethodBeat.o(21308);
          return;
        }
        b.bwC().bvT().mqr = paramAnonymousn.mBa;
        c.this.cLR = paramAnonymousString.mxz.mBd.mAT;
        label339:
        label364:
        long l;
        if (paramAnonymousString.mxz.mBd.mAW.toLowerCase().contains("ios"))
        {
          c.a(c.this, 1);
          c.a(c.this, paramAnonymousString.mxz.mBh);
          c.b(c.this, paramAnonymousString.mxz.mBj);
          ad.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", new Object[] { Long.valueOf(paramAnonymousString.mxz.mBg), Long.valueOf(paramAnonymousString.mxz.mBh / 1024L) });
          if ((c.i(c.this)) && (c.f(c.this)))
          {
            paramAnonymousn = com.tencent.mm.plugin.report.service.h.vKh;
            if ((!c.j(c.this)) && (c.k(c.this) != 1)) {
              break label601;
            }
            paramAnonymousInt1 = 66;
            paramAnonymousn.idkeyStat(485L, paramAnonymousInt1, 1L, false);
          }
          if (paramAnonymousString.mxz.mBf != 3) {
            break label607;
          }
          paramAnonymousInt1 = 1;
          if (paramAnonymousInt1 == 0) {
            break label612;
          }
          c.c(c.this, true);
          ad.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
          label384:
          paramAnonymousString = new PLong();
          paramAnonymousn = new PLong();
          az.arV();
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
          c.this.mtc = l;
          if (paramAnonymousn.value >= l) {
            break label641;
          }
          ad.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramAnonymousn.value), Long.valueOf(l), Long.valueOf(c.l(c.this)) });
          com.tencent.mm.plugin.report.service.h.vKh.f(11787, new Object[] { Integer.valueOf(5) });
          b.bwC().bwD().stop();
          b.bwC().bvT().mqj = -13;
          c.this.vS(-13);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 5L, 1L, false);
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
        c.b(c.this, bt.eGO());
        com.tencent.mm.plugin.backup.g.b.bxw();
        AppMethodBeat.o(21308);
      }
    };
    this.mte = new b.c()
    {
      public final void bwQ()
      {
        AppMethodBeat.i(21313);
        ad.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bxx();
        b.bwC().bvV();
        AppMethodBeat.o(21313);
      }
    };
    this.mtf = new j.a()
    {
      public final void bwO()
      {
        AppMethodBeat.i(21301);
        c.this.vS(b.bwC().bvT().mqj);
        AppMethodBeat.o(21301);
      }
      
      public final void bwP()
      {
        AppMethodBeat.i(21303);
        int i = b.bwC().bvT().mqj;
        ad.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 23) || (i == 4))
        {
          c.this.b(true, false, -4);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 43L, 1L, false);
          c.this.vW(4);
          b.bwC().bwD().stop();
        }
        AppMethodBeat.o(21303);
      }
      
      public final void vX(int paramAnonymousInt)
      {
        AppMethodBeat.i(21302);
        int i = b.bwC().bvT().mqj;
        if (paramAnonymousInt == 1)
        {
          if (i == 23)
          {
            ad.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
            b.bwC().bvT().mqj = 4;
            c.this.vS(4);
            c.this.vW(8);
            AppMethodBeat.o(21302);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
          b.bwC().bvT().mqj = 23;
          c.this.vS(23);
          c.this.vW(9);
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
    localy.mBL = paramString;
    localy.mBM = paramInt1;
    localy.mBO = paramInt2;
    localy.mBP = paramInt3;
    localy.mBi = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.u(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21323);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21323);
    }
  }
  
  public static boolean bwH()
  {
    AppMethodBeat.i(21316);
    boolean bool = az.arV().aqr().eJC();
    AppMethodBeat.o(21316);
    return bool;
  }
  
  private void bwJ()
  {
    AppMethodBeat.i(21320);
    String str1 = this.msV;
    String str2 = this.msW;
    String str3 = com.tencent.mm.plugin.backup.b.g.dZ(aj.getContext());
    ad.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(gll) });
    if ((str3 == null) || (str3.equals("")))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.f(11787, new Object[] { Integer.valueOf(1) });
      b.bwC().bvT().mqj = -1;
      vS(-1);
      AppMethodBeat.o(21320);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.f(11787, new Object[] { Integer.valueOf(2) });
      b.bwC().bvT().mqj = -2;
      vS(-2);
      AppMethodBeat.o(21320);
      return;
    }
    if (!com.tencent.mm.plugin.backup.b.g.Ok(str2))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 3L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.f(11787, new Object[] { Integer.valueOf(3) });
      b.bwC().bvT().mqj = -3;
      vS(-3);
      AppMethodBeat.o(21320);
      return;
    }
    if (gll <= 0)
    {
      b.bwC().bvT().mqj = -5;
      vS(-5);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 4L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.f(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(21320);
      return;
    }
    gll -= 1;
    cc(this.msW, this.msX);
    AppMethodBeat.o(21320);
  }
  
  public static String bwL()
  {
    AppMethodBeat.i(21327);
    String str = com.tencent.mm.plugin.backup.g.b.bxA();
    AppMethodBeat.o(21327);
    return str;
  }
  
  private static void bwM()
  {
    AppMethodBeat.i(21328);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bwC().mqb;
    try
    {
      ad.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.N(locala.toByteArray(), 5);
      AppMethodBeat.o(21328);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21328);
    }
  }
  
  private void cc(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(21319);
    b.bwC().bwD().connect(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.mta);
    for (;;)
    {
      try
      {
        if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.msR = bool;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.bwC().mqc, b.bwC().mqd, com.tencent.mm.plugin.backup.b.d.bvX(), b.bwC().mqb, com.tencent.mm.plugin.backup.b.c.mpT, 22);
      paramString.A(this.msR, false);
      paramString.bxE();
      ad.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.msY == null) {
        this.msY = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(21306);
            if (!c.aJQ)
            {
              ad.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
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
      this.msY.av(3000L, 3000L);
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
      ad.i("MicroMsg.BackupMoveRecoverServer", "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break label380;
      }
      paramInt1 = b.bwC().bvT().mqj;
      ad.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(paramInt1) });
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
      b.bwC().bwD().stop();
      if (!aJQ)
      {
        if (this.msY != null)
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.msY.stopTimer();
        }
        bwJ();
        AppMethodBeat.o(21321);
        return;
      }
      b.bwC().bvT().mqj = -4;
      vS(-4);
      AppMethodBeat.o(21321);
      return;
      b.bwC().bwD().stop();
      AppMethodBeat.o(21321);
      return;
      b(true, false, -4);
      b.bwC().bwD().stop();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 43L, 1L, false);
      vW(4);
      l = 0L;
      if (this.msK != 0L) {
        l = bt.vM(this.msK);
      }
      ad.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.mqq), Long.valueOf(this.recvSize), Long.valueOf(l) });
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
        ad.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cx(paramArrayOfByte)) });
        AppMethodBeat.o(21321);
        return;
      }
      ad.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.mwX) });
      paramArrayOfByte = new f();
      paramArrayOfByte.mwX = locale.mwX;
      try
      {
        ad.d("MicroMsg.BackupMoveRecoverServer", "onNotify send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.u(paramArrayOfByte.toByteArray(), 10, paramInt2);
        AppMethodBeat.o(21321);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramArrayOfByte, "onNotify buf to BackupHeartBeatResponse err.", new Object[0]);
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 10)
    {
      paramArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.mwX;; l = -1L)
      {
        ad.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 51L, 1L, false);
      b(true, false, -100);
    }
    az.afE().ax(new Runnable()
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
          c.L(paramArrayOfByte, paramInt2);
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
    ad.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), at.eFT() });
    if (!paramBoolean1) {
      bwM();
    }
    synchronized (this.lock)
    {
      this.gqP = true;
      if ((this.msA != null) && (this.msA.mrG))
      {
        this.msA.w(paramBoolean2, paramInt);
        this.msA = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bwC().bvT().mqj = paramInt;
          vS(paramInt);
        }
        if (paramBoolean2) {
          bwI();
        }
        com.tencent.mm.plugin.backup.g.b.bxx();
        com.tencent.mm.plugin.backup.g.b.bxz();
        b.bwC().bvV();
        b.bwC().bwD().mqI = null;
        AppMethodBeat.o(21318);
        return;
      }
      i = 1;
    }
  }
  
  public final void bvS()
  {
    AppMethodBeat.i(21330);
    long l1 = bt.vM(this.msL) / 1000L;
    long l2 = b.bwC().bvT().mqu;
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 49L, 1L, false);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 50L, l1, false);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 72L, l2, false);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 52L, this.recvSize / 1024L, false);
    this.msB = com.tencent.mm.vfs.i.aMN(com.tencent.mm.kernel.g.afB().afi());
    com.tencent.mm.plugin.report.service.h.vKh.f(17868, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.msC / 1024L), Long.valueOf(this.msD / 1024L), Long.valueOf(this.mqs / 1024L), Long.valueOf(this.msB / 1024L), Long.valueOf(this.mqt), Long.valueOf(l2) });
    ad.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.msC / 1024L), Long.valueOf(this.msD / 1024L), Long.valueOf(this.mqs / 1024L), Long.valueOf(this.msB / 1024L), Long.valueOf(this.mqt), Long.valueOf(l2) });
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.Fnb, Boolean.TRUE);
    ad.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    if (com.tencent.mm.plugin.backup.b.g.mqC)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      StringBuilder localStringBuilder = new StringBuilder("\nMerge Info:\n");
      localStringBuilder.append("mergeStartTime:").append(((SimpleDateFormat)localObject).format(new Date(this.msL))).append("\n");
      localStringBuilder.append("mergeTime:").append(l1).append("\n");
      localStringBuilder.append("totalMsgCount:").append(l2).append("\n");
      localStringBuilder.append("recvSize:").append(this.recvSize / 1024L).append(" kB\n");
      com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.bwi(), "backupTestInfo.txt", localStringBuilder.toString().getBytes());
    }
    if (!this.mrR)
    {
      localObject = az.arV().aqq().eJE();
      if (((LinkedList)localObject).size() > 0) {
        break label583;
      }
      ad.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      bwI();
      com.tencent.mm.plugin.backup.g.b.wg(22);
      com.tencent.mm.plugin.backup.g.b.bxx();
      com.tencent.mm.plugin.backup.g.b.bxz();
      AppMethodBeat.o(21330);
      return;
      label583:
      ad.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      az.arV().aqp().j(this.cLR, (LinkedList)localObject);
    }
  }
  
  public final void bwI()
  {
    AppMethodBeat.i(21317);
    ad.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.msJ.clear();
    if (!com.tencent.mm.plugin.backup.b.g.mqC)
    {
      com.tencent.mm.plugin.backup.b.g.Og(com.tencent.mm.plugin.backup.b.g.bwg());
      com.tencent.mm.plugin.backup.b.g.bwe();
    }
    AppMethodBeat.o(21317);
  }
  
  public final void bwK()
  {
    AppMethodBeat.i(21325);
    b(true, false, 28);
    b.bwC().bwD().stop();
    AppMethodBeat.o(21325);
  }
  
  public final void hR(boolean paramBoolean)
  {
    AppMethodBeat.i(21326);
    synchronized (this.lock)
    {
      if ((this.msA != null) && (this.msA.mrG))
      {
        ad.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21326);
        return;
      }
      if (this.msA != null) {
        this.msA.w(false, 0);
      }
      if ((this.msJ == null) || (this.msJ.size() <= 0))
      {
        i = az.arV().aqr().eJD();
        b.bwC().bvT().mqj = 26;
        b.bwC().bvT().mqm = 0;
        vS(26);
        com.tencent.mm.plugin.backup.h.d.bxT().bxW();
        this.msL = bt.eGO();
        this.msA = new com.tencent.mm.plugin.backup.c.d(b.bwC(), 2, this, i, false, new LinkedList(), new LinkedList());
        this.msA.hR(paramBoolean);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(21326);
        return;
      }
      int i = this.msJ.size();
    }
  }
  
  public final void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(21322);
    this.msT = paramBoolean;
    Object localObject = new LinkedBlockingQueue();
    b.bwC().bwD().mqI = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21310);
        for (;;)
        {
          if (!c.m(c.this)) {}
          try
          {
            boolean bool = this.mti.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              ad.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.mti.size()) });
              AppMethodBeat.o(21310);
              return;
            }
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.Iye.aS(new com.tencent.e.i.h()
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
          if ((!c.m(c.this)) && (!c.baE())) {
            try
            {
              c.a locala = (c.a)this.mti.poll(500L, TimeUnit.MILLISECONDS);
              ad.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.mti.size()), locala });
              if (locala != null) {
                c.this.a(locala.dtp, locala.type, locala.buf, locala.htk);
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
    if ((!this.mrR) && (!paramBoolean))
    {
      localObject = this.msG;
      LinkedList localLinkedList = this.msH;
      this.msG = new LinkedList();
      this.msH = new LinkedList();
      az.arV().aqp().a(this.cLR, (LinkedList)localObject, localLinkedList, this.msG, this.msH);
    }
    localObject = new j();
    ((j)localObject).mAM = this.msG;
    ((j)localObject).mAN = this.msH;
    try
    {
      ad.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(((j)localObject).mAM.size()), Integer.valueOf(((j)localObject).mAN.size()) });
      com.tencent.mm.plugin.backup.g.b.u(((j)localObject).toByteArray(), 12, this.mtd);
      com.tencent.mm.plugin.backup.g.b.bxy();
      if (this.msS)
      {
        b.bwC().bvT().O(23, 1, this.msE.size());
        this.mqq = b.bwC().bvT().mqq;
        this.recvSize = b.bwC().bvT().mqn;
        this.msC = b.bwC().bvT().mqo;
        this.msD = b.bwC().bvT().mqp;
        this.mqs = b.bwC().bvT().mqs;
        this.mqt = b.bwC().bvT().mqt;
        com.tencent.mm.plugin.backup.h.d.bxT().bxW();
        this.mqt = -1L;
        com.tencent.e.h.Iye.aS(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "getMsgCount";
          }
          
          public final void run()
          {
            AppMethodBeat.i(21312);
            c.c(c.this, com.tencent.mm.plugin.backup.h.d.bxT().bxU().apO().cOY());
            b.bwC().bvT().mqt = c.n(c.this);
            AppMethodBeat.o(21312);
          }
        });
        vS(23);
        AppMethodBeat.o(21322);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupRequestSessionResponse err.", new Object[0]);
        continue;
        b.bwC().bvT().a(23, 1, this.msE.size(), 0L, this.mqq, 0L, 0L);
        this.mqs = com.tencent.mm.vfs.i.aMN(com.tencent.mm.kernel.g.afB().afi());
        b.bwC().bvT().mqs = this.mqs;
      }
    }
  }
  
  public final void vS(final int paramInt)
  {
    AppMethodBeat.i(21329);
    if (this.mrM != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21304);
          if (c.o(c.this) != null) {
            c.o(c.this).vS(paramInt);
          }
          AppMethodBeat.o(21304);
        }
      });
    }
    if (this.msI != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21305);
          if (c.p(c.this) != null) {
            c.p(c.this).vR(paramInt);
          }
          AppMethodBeat.o(21305);
        }
      });
    }
    AppMethodBeat.o(21329);
  }
  
  public final void vW(int paramInt)
  {
    AppMethodBeat.i(21324);
    long l = 0L;
    if (this.msK != 0L) {
      l = bt.vM(this.msK);
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.msU), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.mqs / 1024L) });
    ad.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.mqq / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.mqs / 1024L) });
    AppMethodBeat.o(21324);
  }
  
  final class a
  {
    byte[] buf;
    boolean dtp;
    int htk;
    int type;
    
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(21314);
      this.dtp = false;
      this.htk = paramInt1;
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