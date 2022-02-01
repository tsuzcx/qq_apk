package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c
  implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.g.b.d
{
  private static int kQn = 0;
  private static boolean rNH;
  private static boolean rNt = false;
  String fzB;
  private boolean kUn;
  private Object lock;
  private long rKZ;
  private long rLb;
  private long rLc;
  private boolean rMB;
  private boolean rNA;
  private int rNB;
  private int rNC;
  public String rND;
  String rNE;
  int rNF;
  private MTimerHandler rNG;
  public Set<com.tencent.mm.plugin.backup.b.b.d> rNI;
  public b.a rNJ;
  final com.tencent.mm.an.i rNK;
  private final com.tencent.mm.an.i rNL;
  private final com.tencent.mm.an.i rNM;
  public long rNN;
  private int rNO;
  b.c rNP;
  private final j.a rNQ;
  private com.tencent.mm.plugin.backup.c.d rNi;
  private long rNj;
  private long rNk;
  private long rNl;
  private LinkedList<String> rNm;
  private LinkedList<Long> rNn;
  private LinkedList<String> rNo;
  private LinkedList<Long> rNp;
  private HashSet<String> rNq;
  private long rNr;
  private long rNs;
  private boolean rNu;
  private int rNv;
  public boolean rNw;
  private boolean rNx;
  private boolean rNy;
  private boolean rNz;
  private long recvSize;
  
  static
  {
    rNH = false;
  }
  
  public c()
  {
    AppMethodBeat.i(21315);
    this.rLb = 0L;
    this.rLc = -1L;
    this.rNj = 0L;
    this.rKZ = 0L;
    this.recvSize = 0L;
    this.rNk = 0L;
    this.rNl = 0L;
    this.lock = new Object();
    this.kUn = false;
    this.rNm = new LinkedList();
    this.rNq = new HashSet();
    this.rNr = 0L;
    this.rNs = 0L;
    this.rNu = true;
    this.rNv = 0;
    this.rNw = false;
    this.rNx = true;
    this.rNy = true;
    this.rMB = false;
    this.rNz = false;
    this.rNA = false;
    this.rNB = 0;
    this.rNI = new HashSet();
    this.rNK = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(197165);
        bh.aGY().b(595, c.a(c.this));
        com.tencent.mm.plugin.backup.b.d.EC(22);
        b.csI().crZ().rKS = 1;
        Object localObject2 = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
        ((Intent)localObject2).addFlags(335544320);
        ((Intent)localObject2).putExtra("nofification_type", "backup_move_notification");
        Object localObject1 = MMApplicationContext.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 41L, 1L, false);
        paramAnonymousq = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousq).ctU();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
          }
          bh.beI();
          if (!Util.nullAsNil((String)com.tencent.mm.model.c.aHp().b(2, null)).equals(paramAnonymousq.RNz))
          {
            Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
            b.csI().crZ().rKS = -14;
            c.this.EB(-14);
            AppMethodBeat.o(197165);
            return;
          }
          b.csI().crZ().rKS = -5;
          c.this.EB(-5);
          AppMethodBeat.o(197165);
          return;
        }
        bh.beI();
        if (!Util.nullAsNil((String)com.tencent.mm.model.c.aHp().b(2, null)).equals(paramAnonymousq.RNz))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
          b.csI().crZ().rKS = -5;
          c.this.EB(-14);
          AppMethodBeat.o(197165);
          return;
        }
        b.csI().rKK = paramAnonymousq.ID;
        b.csI().rKL = paramAnonymousq.RNF;
        b.csI().rKM = paramAnonymousq.RNG;
        com.tencent.mm.plugin.backup.g.b.a(c.this.rNP);
        b.csI().csa();
        com.tencent.mm.plugin.backup.g.b.a(b.csI().csL());
        com.tencent.mm.plugin.backup.g.b.a(b.csI().csJ());
        com.tencent.mm.plugin.backup.g.b.EC(2);
        com.tencent.mm.plugin.backup.g.b.a(c.b(c.this));
        paramAnonymousString = null;
        paramAnonymousInt1 = 0;
        if (paramAnonymousq.RNw > 0)
        {
          localObject1 = (adp)paramAnonymousq.RNx.getFirst();
          paramAnonymousString = ((adp)localObject1).Slg;
          paramAnonymousInt1 = ((Integer)((adp)localObject1).SpS.getFirst()).intValue();
        }
        for (;;)
        {
          localObject1 = c.this;
          ((c)localObject1).rND = paramAnonymousq.RNA;
          ((c)localObject1).rNE = paramAnonymousString;
          ((c)localObject1).rNF = paramAnonymousInt1;
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousq.rWu), Integer.valueOf(paramAnonymousq.CPw), paramAnonymousq.RNA, paramAnonymousString, Integer.valueOf(paramAnonymousInt1) });
          c.access$202(false);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramAnonymousString, paramAnonymousq.RNA, g.eH(MMApplicationContext.getContext()) });
          c.csT();
          c.a(c.this, paramAnonymousString, paramAnonymousInt1);
          AppMethodBeat.o(197165);
          return;
          Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
        }
      }
    };
    this.rNL = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21308);
        c.access$202(true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 42L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.a(11787, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.e(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
          b.csI().crZ().rKS = -5;
          c.this.EB(-5);
          c.this.EF(3);
          AppMethodBeat.o(21308);
          return;
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousq;
        if (paramAnonymousString.rRf.rWt < com.tencent.mm.plugin.backup.b.c.rKC)
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramAnonymousString.rRf.rWt) });
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 104L, 1L, false);
          b.csI().crZ().rKS = -12;
          c.this.EB(-12);
          AppMethodBeat.o(21308);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.rRf.rWu;
        paramAnonymousq = c.this;
        if ((paramAnonymousString.rRf.rWv & com.tencent.mm.plugin.backup.b.c.rKG) == 0) {}
        for (boolean bool = false;; bool = true)
        {
          c.a(paramAnonymousq, bool);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramAnonymousString.rRf.rWt), Integer.valueOf(paramAnonymousInt1), Boolean.valueOf(c.f(c.this)) });
          if (paramAnonymousInt1 != com.tencent.mm.plugin.backup.b.c.rKE) {
            break label387;
          }
          if (!c.csN()) {
            break;
          }
          c.b(c.this, true);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
          c.a(c.this, 4);
          c.g(c.this);
          AppMethodBeat.o(21308);
          return;
        }
        c.b(c.this, false);
        Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
        c.a(c.this, 2);
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276536);
            c.this.csO();
            c.g(c.this);
            AppMethodBeat.o(276536);
          }
        });
        AppMethodBeat.o(21308);
        return;
        label387:
        if (c.csN()) {
          c.a(c.this, 3);
        }
        for (;;)
        {
          c.b(c.this, false);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
          com.tencent.e.h.ZvG.be(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(285792);
              c.this.csO();
              c.g(c.this);
              AppMethodBeat.o(285792);
            }
          });
          AppMethodBeat.o(21308);
          return;
          c.a(c.this, 1);
        }
      }
    };
    this.rNM = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(276916);
        com.tencent.mm.plugin.backup.g.b.b(3, c.h(c.this));
        Log.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          b.csI().crZ().rKS = -5;
          c.this.EB(-5);
          AppMethodBeat.o(276916);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.k)paramAnonymousq;
        paramAnonymousq = paramAnonymousString.rSm;
        if (!b.csI().rKK.equals(paramAnonymousq.ID))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
          b.csI().crZ().rKS = -5;
          c.this.EB(-5);
          AppMethodBeat.o(276916);
          return;
        }
        b.csI().crZ().rLa = paramAnonymousq.rVM;
        c.this.fzB = paramAnonymousString.rSm.rVP.rVF;
        label349:
        label374:
        long l;
        if (paramAnonymousString.rSm.rVP.rVI.toLowerCase().contains("ios"))
        {
          c.b(c.this, 1);
          c.a(c.this, paramAnonymousString.rSm.rVT);
          c.c(c.this, paramAnonymousString.rSm.rVV);
          Log.i("MicroMsg.BackupMoveRecoverServer", "move recover backupMoveDevice[%d], totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", new Object[] { Integer.valueOf(c.i(c.this)), Long.valueOf(paramAnonymousString.rSm.rVS), Long.valueOf(paramAnonymousString.rSm.rVT / 1024L) });
          if ((c.j(c.this)) && (c.f(c.this)))
          {
            paramAnonymousq = com.tencent.mm.plugin.report.service.h.IzE;
            if ((!c.k(c.this)) && (c.l(c.this) != 1)) {
              break label610;
            }
            paramAnonymousInt1 = 66;
            paramAnonymousq.idkeyStat(485L, paramAnonymousInt1, 1L, false);
          }
          if (paramAnonymousString.rSm.rVR != 3) {
            break label616;
          }
          paramAnonymousInt1 = 1;
          if (paramAnonymousInt1 == 0) {
            break label621;
          }
          c.c(c.this, true);
          Log.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
          label394:
          paramAnonymousString = new PLong();
          paramAnonymousq = new PLong();
          bh.beI();
          g.a(paramAnonymousString, paramAnonymousq, com.tencent.mm.model.c.getAccPath());
          l = c.m(c.this);
          if (c.m(c.this) * 0.1D <= 524288000.0D) {
            break label633;
          }
        }
        label610:
        label616:
        label621:
        label633:
        for (double d = 524288000.0D;; d = c.m(c.this) * 0.1D)
        {
          l = d + l;
          c.this.rNN = l;
          if (paramAnonymousq.value >= l) {
            break label650;
          }
          Log.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramAnonymousq.value), Long.valueOf(l), Long.valueOf(c.m(c.this)) });
          com.tencent.mm.plugin.report.service.h.IzE.a(11787, new Object[] { Integer.valueOf(5) });
          b.csI().csJ().stop();
          b.csI().crZ().rKS = -13;
          c.this.EB(-13);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 5L, 1L, false);
          AppMethodBeat.o(276916);
          return;
          c.b(c.this, 2);
          break;
          paramAnonymousInt1 = 65;
          break label349;
          paramAnonymousInt1 = 0;
          break label374;
          c.c(c.this, false);
          break label394;
        }
        label650:
        c.b(c.this, Util.nowMilliSecond());
        com.tencent.mm.plugin.backup.g.b.ctE();
        AppMethodBeat.o(276916);
      }
    };
    this.rNP = new b.c()
    {
      public final void csV()
      {
        AppMethodBeat.i(290881);
        Log.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.ctF();
        b.csI().csb();
        AppMethodBeat.o(290881);
      }
    };
    this.rNQ = new j.a()
    {
      public final void EG(int paramAnonymousInt)
      {
        AppMethodBeat.i(263850);
        int i = b.csI().crZ().rKS;
        if (paramAnonymousInt == 1)
        {
          if (i == 23)
          {
            Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
            b.csI().crZ().rKS = 4;
            c.this.EB(4);
            c.this.EF(8);
            AppMethodBeat.o(263850);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
          b.csI().crZ().rKS = 23;
          c.this.EB(23);
          c.this.EF(9);
        }
        AppMethodBeat.o(263850);
      }
      
      public final void csW()
      {
        AppMethodBeat.i(263849);
        c.this.EB(b.csI().crZ().rKS);
        AppMethodBeat.o(263849);
      }
      
      public final void csX()
      {
        AppMethodBeat.i(263851);
        int i = b.csI().crZ().rKS;
        Log.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 23) || (i == 4))
        {
          c.this.a(true, false, -4);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 43L, 1L, false);
          c.this.EF(4);
          b.csI().csJ().stop();
        }
        AppMethodBeat.o(263851);
      }
    };
    AppMethodBeat.o(21315);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(21323);
    y localy = new y();
    localy.rWy = paramString;
    localy.rWz = paramInt1;
    localy.rWB = paramInt2;
    localy.rWC = paramInt3;
    localy.rVU = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.F(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21323);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21323);
    }
  }
  
  private void cR(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(21319);
    b.csI().csJ().cQ(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.rNL);
    for (;;)
    {
      try
      {
        if (Util.getInt(com.tencent.mm.n.h.axc().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.rNy = bool;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.csI().rKL, b.csI().rKM, com.tencent.mm.plugin.backup.b.d.csd(), b.csI().rKK, com.tencent.mm.plugin.backup.b.c.rKC, 22, csN());
      paramString.E(this.rNy, false);
      paramString.ctM();
      Log.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.rNG == null) {
        this.rNG = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(290879);
            if (!c.rNH)
            {
              Log.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
              if (c.c(c.this) != null) {
                c.c(c.this).stopTimer();
              }
              c.d(c.this);
            }
            AppMethodBeat.o(290879);
            return true;
          }
        }, false);
      }
      this.rNG.startTimer(3000L);
      AppMethodBeat.o(21319);
      return;
      bool = false;
    }
  }
  
  public static boolean csN()
  {
    AppMethodBeat.i(21316);
    boolean bool = bh.beI().bcr().hvD();
    AppMethodBeat.o(21316);
    return bool;
  }
  
  private void csP()
  {
    AppMethodBeat.i(21320);
    String str1 = this.rND;
    String str2 = this.rNE;
    String str3 = g.eH(MMApplicationContext.getContext());
    Log.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(kQn) });
    if ((str3 == null) || (str3.equals("")))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(11787, new Object[] { Integer.valueOf(1) });
      b.csI().crZ().rKS = -1;
      EB(-1);
      AppMethodBeat.o(21320);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(11787, new Object[] { Integer.valueOf(2) });
      b.csI().crZ().rKS = -2;
      EB(-2);
      AppMethodBeat.o(21320);
      return;
    }
    if (!g.aoe(str2))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 3L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(11787, new Object[] { Integer.valueOf(3) });
      b.csI().crZ().rKS = -3;
      EB(-3);
      AppMethodBeat.o(21320);
      return;
    }
    if (kQn <= 0)
    {
      b.csI().crZ().rKS = -5;
      EB(-5);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 4L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(21320);
      return;
    }
    kQn -= 1;
    cR(this.rNE, this.rNF);
    AppMethodBeat.o(21320);
  }
  
  public static String csR()
  {
    AppMethodBeat.i(21327);
    String str = com.tencent.mm.plugin.backup.g.b.ctI();
    AppMethodBeat.o(21327);
    return str;
  }
  
  private static void csS()
  {
    AppMethodBeat.i(21328);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.csI().rKK;
    try
    {
      Log.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.O(locala.toByteArray(), 5);
      AppMethodBeat.o(21328);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21328);
    }
  }
  
  public final void EB(final int paramInt)
  {
    AppMethodBeat.i(21329);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202407);
        Iterator localIterator = this.rNT.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.backup.b.b.d)localIterator.next()).EB(paramInt);
        }
        AppMethodBeat.o(202407);
      }
    });
    if (this.rNJ != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(259000);
          if (c.p(c.this) != null) {
            c.p(c.this).EA(paramInt);
          }
          AppMethodBeat.o(259000);
        }
      });
    }
    AppMethodBeat.o(21329);
  }
  
  public final void EF(int paramInt)
  {
    AppMethodBeat.i(21324);
    long l = 0L;
    if (this.rNr != 0L) {
      l = Util.milliSecondsToNow(this.rNr);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.rNC), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.rLb / 1024L), Integer.valueOf(this.rNB) });
    Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.rKZ / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.rLb / 1024L) });
    AppMethodBeat.o(21324);
  }
  
  public final void a(boolean paramBoolean, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2)
  {
    AppMethodBeat.i(21321);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break label380;
      }
      paramInt1 = b.csI().crZ().rKS;
      Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(paramInt1) });
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
      b.csI().csJ().stop();
      if (!rNH)
      {
        if (this.rNG != null)
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.rNG.stopTimer();
        }
        csP();
        AppMethodBeat.o(21321);
        return;
      }
      b.csI().crZ().rKS = -4;
      EB(-4);
      AppMethodBeat.o(21321);
      return;
      b.csI().csJ().stop();
      AppMethodBeat.o(21321);
      return;
      a(true, false, -4);
      b.csI().csJ().stop();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 43L, 1L, false);
      EF(4);
      l = 0L;
      if (this.rNr != 0L) {
        l = Util.milliSecondsToNow(this.rNr);
      }
      Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.rKZ), Long.valueOf(this.recvSize), Long.valueOf(l) });
      AppMethodBeat.o(21321);
      return;
      a(true, false, 0);
    }
    label380:
    if (paramInt1 == 9)
    {
      com.tencent.mm.plugin.backup.i.e locale = (com.tencent.mm.plugin.backup.i.e)g.a(new com.tencent.mm.plugin.backup.i.e(), paramArrayOfByte);
      if (locale == null)
      {
        Log.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramArrayOfByte)) });
        AppMethodBeat.o(21321);
        return;
      }
      Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.rRK) });
      paramArrayOfByte = new com.tencent.mm.plugin.backup.i.f();
      paramArrayOfByte.rRK = locale.rRK;
      try
      {
        Log.d("MicroMsg.BackupMoveRecoverServer", "onNotify send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.F(paramArrayOfByte.toByteArray(), 10, paramInt2);
        AppMethodBeat.o(21321);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramArrayOfByte, "onNotify buf to BackupHeartBeatResponse err.", new Object[0]);
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 10)
    {
      paramArrayOfByte = (com.tencent.mm.plugin.backup.i.f)g.a(new com.tencent.mm.plugin.backup.i.f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.rRK;; l = -1L)
      {
        Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 51L, 1L, false);
      a(true, false, -100);
    }
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(283751);
        if (paramInt1 == 11)
        {
          c.a(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(283751);
          return;
        }
        if (paramInt1 == 6)
        {
          c.b(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(283751);
          return;
        }
        if (paramInt1 == 13)
        {
          c.L(paramArrayOfByte, paramInt2);
          AppMethodBeat.o(283751);
          return;
        }
        if (paramInt1 == 15)
        {
          c.c(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(283751);
          return;
        }
        if (paramInt1 == 8)
        {
          c.a(c.this, paramArrayOfByte);
          AppMethodBeat.o(283751);
          return;
        }
        AppMethodBeat.o(283751);
      }
    });
    AppMethodBeat.o(21321);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21318);
    Log.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), MMStack.getCaller() });
    if (!paramBoolean1) {
      csS();
    }
    synchronized (this.lock)
    {
      this.kUn = true;
      if ((this.rNi != null) && (this.rNi.rMp))
      {
        this.rNi.C(paramBoolean2, paramInt);
        this.rNi = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.csI().crZ().rKS = paramInt;
          EB(paramInt);
        }
        if (paramBoolean2) {
          com.tencent.e.h.ZvG.be(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275311);
              c.this.csO();
              AppMethodBeat.o(275311);
            }
          });
        }
        com.tencent.mm.plugin.backup.g.b.ctF();
        com.tencent.mm.plugin.backup.g.b.ctH();
        b.csI().csb();
        b.csI().csJ().rLr = null;
        AppMethodBeat.o(21318);
        return;
      }
      i = 1;
    }
  }
  
  public final void crY()
  {
    AppMethodBeat.i(21330);
    long l1 = Util.milliSecondsToNow(this.rNs) / 1000L;
    long l2 = b.csI().crZ().rLd;
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 49L, 1L, false);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 50L, l1, false);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 72L, l2, false);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 52L, this.recvSize / 1024L, false);
    this.rNj = u.bBQ(com.tencent.mm.kernel.h.aHG().aHn());
    com.tencent.mm.plugin.report.service.h.IzE.a(17868, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.rNk / 1024L), Long.valueOf(this.rNl / 1024L), Long.valueOf(this.rLb / 1024L), Long.valueOf(this.rNj / 1024L), Long.valueOf(this.rLc), Long.valueOf(l2) });
    Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.rNk / 1024L), Long.valueOf(this.rNl / 1024L), Long.valueOf(this.rLb / 1024L), Long.valueOf(this.rNj / 1024L), Long.valueOf(this.rLc), Long.valueOf(l2) });
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.VnI, Boolean.TRUE);
    Log.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    if (g.rLl)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      StringBuilder localStringBuilder = new StringBuilder("\nMerge Info:\n");
      localStringBuilder.append("mergeStartTime:").append(((SimpleDateFormat)localObject).format(new Date(this.rNs))).append("\n");
      localStringBuilder.append("mergeTime:").append(l1).append("\n");
      localStringBuilder.append("totalMsgCount:").append(l2).append("\n");
      localStringBuilder.append("recvSize:").append(this.recvSize / 1024L).append(" kB\n");
      g.a(g.cso(), "backupTestInfo.txt", localStringBuilder.toString().getBytes());
    }
    if (!this.rMB)
    {
      localObject = bh.beI().bcq().hvF();
      if (((LinkedList)localObject).size() > 0) {
        break label596;
      }
      Log.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(287923);
          c.this.csO();
          AppMethodBeat.o(287923);
        }
      });
      com.tencent.mm.plugin.backup.g.b.EO(22);
      com.tencent.mm.plugin.backup.g.b.ctF();
      com.tencent.mm.plugin.backup.g.b.ctH();
      AppMethodBeat.o(21330);
      return;
      label596:
      Log.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      bh.beI().bcp().j(this.fzB, (LinkedList)localObject);
    }
  }
  
  public final void csO()
  {
    AppMethodBeat.i(21317);
    Log.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.rNq.clear();
    if (!g.rLl)
    {
      g.aoa(g.csm());
      g.csk();
    }
    AppMethodBeat.o(21317);
  }
  
  public final void csQ()
  {
    AppMethodBeat.i(21325);
    a(true, false, 28);
    b.csI().csJ().stop();
    AppMethodBeat.o(21325);
  }
  
  public final void kK(boolean paramBoolean)
  {
    AppMethodBeat.i(21326);
    synchronized (this.lock)
    {
      if ((this.rNi != null) && (this.rNi.rMp))
      {
        Log.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21326);
        return;
      }
      if (this.rNi != null)
      {
        final com.tencent.mm.plugin.backup.c.d locald = this.rNi;
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(269363);
            locald.C(false, 0);
            AppMethodBeat.o(269363);
          }
        });
      }
      if ((this.rNq == null) || (this.rNq.size() <= 0))
      {
        i = bh.beI().bcr().hvE();
        b.csI().crZ().rKS = 26;
        b.csI().crZ().rKV = 0;
        EB(26);
        com.tencent.mm.plugin.backup.h.d.cua().cud();
        this.rNs = Util.nowMilliSecond();
        this.rNi = new com.tencent.mm.plugin.backup.c.d(b.csI(), 2, this, i, false, new LinkedList(), new LinkedList());
        this.rNi.kK(paramBoolean);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(21326);
        return;
      }
      int i = this.rNq.size();
    }
  }
  
  public final void kL(boolean paramBoolean)
  {
    AppMethodBeat.i(21322);
    Log.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse, isChooseAll:%s, isResumeMove:%s, isQuickBackup:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.rNz), Boolean.valueOf(this.rMB) });
    this.rNA = paramBoolean;
    Object localObject1 = new LinkedBlockingQueue();
    b.csI().csJ().rLr = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(279254);
        for (;;)
        {
          if (!c.n(c.this)) {}
          try
          {
            boolean bool = this.rNW.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              Log.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.rNW.size()) });
              AppMethodBeat.o(279254);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.ZvG.bh(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "startSendRequestSessionResponse.onNotifyWorker";
      }
      
      public final void run()
      {
        AppMethodBeat.i(21312);
        for (;;)
        {
          if ((!c.n(c.this)) && (!c.csU())) {
            try
            {
              c.a locala = (c.a)this.rNW.poll(500L, TimeUnit.MILLISECONDS);
              Log.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.rNW.size()), locala });
              if (locala != null) {
                c.this.a(locala.fEF, locala.type, locala.buf, locala.mbp);
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
        AppMethodBeat.o(21312);
      }
    });
    if (paramBoolean) {
      bh.beI().bcp().aPo();
    }
    Object localObject2;
    if ((!this.rNz) && (!this.rMB) && (!paramBoolean))
    {
      localObject1 = this.rNo;
      localObject2 = this.rNp;
      this.rNo = new LinkedList();
      this.rNp = new LinkedList();
      bh.beI().bcp().a(this.fzB, (LinkedList)localObject1, (LinkedList)localObject2, this.rNo, this.rNp);
    }
    localObject1 = new j();
    ((j)localObject1).rVz = this.rNo;
    ((j)localObject1).rVA = this.rNp;
    try
    {
      Log.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(((j)localObject1).rVz.size()), Integer.valueOf(((j)localObject1).rVA.size()) });
      com.tencent.mm.plugin.backup.g.b.F(((j)localObject1).toByteArray(), 12, this.rNO);
      try
      {
        localObject1 = this.rNp.iterator();
        localObject2 = this.rNo.iterator();
        while (((Iterator)localObject2).hasNext()) {
          Log.i("MicroMsg.BackupMoveRecoverServer", "session:%s, startTime:%s, endTime:%s", new Object[] { (String)((Iterator)localObject2).next(), ((Iterator)localObject1).next(), ((Iterator)localObject1).next() });
        }
        b.csI().crZ().T(23, 1, this.rNm.size());
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.BackupMoveRecoverServer", "TimeInterval size error. e:%s", new Object[] { localException1 });
        com.tencent.mm.plugin.backup.g.b.ctG();
        if (!this.rNz) {
          break label511;
        }
      }
      this.rKZ = b.csI().crZ().rKZ;
      this.recvSize = b.csI().crZ().rKW;
      this.rNk = b.csI().crZ().rKX;
      this.rNl = b.csI().crZ().rKY;
      this.rLb = b.csI().crZ().rLb;
      this.rLc = b.csI().crZ().rLc;
      com.tencent.mm.plugin.backup.h.d.cua().cud();
      this.rLc = -1L;
      com.tencent.e.h.ZvG.bh(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "getMsgCount";
        }
        
        public final void run()
        {
          AppMethodBeat.i(277381);
          c.c(c.this, com.tencent.mm.plugin.backup.h.d.cua().cub().bbO().eSv());
          b.csI().crZ().rLc = c.o(c.this);
          AppMethodBeat.o(277381);
        }
      });
      EB(23);
      AppMethodBeat.o(21322);
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException2, "buf to BackupRequestSessionResponse err.", new Object[0]);
        continue;
        label511:
        b.csI().crZ().a(23, 1, this.rNm.size(), 0L, this.rKZ, 0L, 0L);
        this.rLb = u.bBQ(com.tencent.mm.kernel.h.aHG().aHn());
        b.csI().crZ().rLb = this.rLb;
      }
    }
  }
  
  final class a
  {
    byte[] buf;
    boolean fEF;
    int mbp;
    int type;
    
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(21314);
      this.fEF = false;
      this.mbp = paramInt1;
      this.type = paramInt2;
      this.buf = ((byte[])paramArrayOfByte.clone());
      AppMethodBeat.o(21314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c
 * JD-Core Version:    0.7.0.1
 */