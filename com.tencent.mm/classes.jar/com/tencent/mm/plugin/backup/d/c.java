package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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
  private static int nrQ = 0;
  private static boolean uYH = false;
  private static boolean uYV = false;
  String hEl;
  private Object lock;
  private boolean nzW;
  private long recvSize;
  private long uWn;
  private long uWp;
  private long uWq;
  private boolean uXO;
  private LinkedList<String> uYA;
  private LinkedList<Long> uYB;
  private LinkedList<String> uYC;
  private LinkedList<Long> uYD;
  private HashSet<String> uYE;
  private long uYF;
  private long uYG;
  private boolean uYI;
  private int uYJ;
  public boolean uYK;
  private boolean uYL;
  private boolean uYM;
  private boolean uYN;
  private boolean uYO;
  private int uYP;
  private int uYQ;
  public String uYR;
  String uYS;
  int uYT;
  private MTimerHandler uYU;
  public Set<com.tencent.mm.plugin.backup.b.b.d> uYW;
  public b.a uYX;
  final com.tencent.mm.am.h uYY;
  private final com.tencent.mm.am.h uYZ;
  private com.tencent.mm.plugin.backup.c.d uYw;
  private long uYx;
  private long uYy;
  private long uYz;
  private final com.tencent.mm.am.h uZa;
  public long uZb;
  private int uZc;
  b.c uZd;
  private final j.a uZe;
  
  public c()
  {
    AppMethodBeat.i(21315);
    this.uWp = 0L;
    this.uWq = -1L;
    this.uYx = 0L;
    this.uWn = 0L;
    this.recvSize = 0L;
    this.uYy = 0L;
    this.uYz = 0L;
    this.lock = new Object();
    this.nzW = false;
    this.uYA = new LinkedList();
    this.uYE = new HashSet();
    this.uYF = 0L;
    this.uYG = 0L;
    this.uYI = true;
    this.uYJ = 0;
    this.uYK = false;
    this.uYL = true;
    this.uYM = true;
    this.uXO = false;
    this.uYN = false;
    this.uYO = false;
    this.uYP = 0;
    this.uYW = new HashSet();
    this.uYY = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(300757);
        bh.aZW().b(595, c.a(c.this));
        com.tencent.mm.plugin.backup.b.d.Fd(22);
        b.cVs().cUJ().uWg = 1;
        Object localObject2 = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
        ((Intent)localObject2).addFlags(335544320);
        ((Intent)localObject2).putExtra("nofification_type", "backup_move_notification");
        Object localObject1 = MMApplicationContext.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 41L, 1L, false);
        paramAnonymousp = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousp).cWE();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
          }
          bh.bCz();
          if (!Util.nullAsNil((String)com.tencent.mm.model.c.ban().d(2, null)).equals(paramAnonymousp.YKN))
          {
            Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
            b.cVs().cUJ().uWg = -14;
            c.this.Fc(-14);
            AppMethodBeat.o(300757);
            return;
          }
          b.cVs().cUJ().uWg = -5;
          c.this.Fc(-5);
          AppMethodBeat.o(300757);
          return;
        }
        bh.bCz();
        if (!Util.nullAsNil((String)com.tencent.mm.model.c.ban().d(2, null)).equals(paramAnonymousp.YKN))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
          b.cVs().cUJ().uWg = -5;
          c.this.Fc(-14);
          AppMethodBeat.o(300757);
          return;
        }
        b.cVs().uVY = paramAnonymousp.vgy;
        b.cVs().uVZ = paramAnonymousp.YKT;
        b.cVs().uWa = paramAnonymousp.YKU;
        com.tencent.mm.plugin.backup.g.b.a(c.this.uZd);
        b.cVs().cUK();
        com.tencent.mm.plugin.backup.g.b.a(b.cVs().cVv());
        com.tencent.mm.plugin.backup.g.b.a(b.cVs().cVt());
        com.tencent.mm.plugin.backup.g.b.Fd(2);
        com.tencent.mm.plugin.backup.g.b.a(c.b(c.this));
        paramAnonymousString = null;
        paramAnonymousInt1 = 0;
        if (paramAnonymousp.YKK > 0)
        {
          localObject1 = (afx)paramAnonymousp.YKL.getFirst();
          paramAnonymousString = ((afx)localObject1).Zjq;
          paramAnonymousInt1 = ((Integer)((afx)localObject1).ZoN.getFirst()).intValue();
        }
        for (;;)
        {
          localObject1 = c.this;
          ((c)localObject1).uYR = paramAnonymousp.YKO;
          ((c)localObject1).uYS = paramAnonymousString;
          ((c)localObject1).uYT = paramAnonymousInt1;
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousp.vhJ), Integer.valueOf(paramAnonymousp.IJG), paramAnonymousp.YKO, paramAnonymousString, Integer.valueOf(paramAnonymousInt1) });
          c.dA(false);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramAnonymousString, paramAnonymousp.YKO, g.fC(MMApplicationContext.getContext()) });
          c.cVD();
          c.a(c.this, paramAnonymousString, paramAnonymousInt1);
          AppMethodBeat.o(300757);
          return;
          Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
        }
      }
    };
    this.uYZ = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21308);
        c.dA(true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 42L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(11787, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.e(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
          b.cVs().cUJ().uWg = -5;
          c.this.Fc(-5);
          c.this.Fg(3);
          AppMethodBeat.o(21308);
          return;
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousp;
        if (paramAnonymousString.vcu.crz < com.tencent.mm.plugin.backup.b.c.uVQ)
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramAnonymousString.vcu.crz) });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 104L, 1L, false);
          b.cVs().cUJ().uWg = -12;
          c.this.Fc(-12);
          AppMethodBeat.o(21308);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.vcu.vhJ;
        paramAnonymousp = c.this;
        if ((paramAnonymousString.vcu.vhK & com.tencent.mm.plugin.backup.b.c.uVU) == 0) {}
        for (boolean bool = false;; bool = true)
        {
          c.a(paramAnonymousp, bool);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramAnonymousString.vcu.crz), Integer.valueOf(paramAnonymousInt1), Boolean.valueOf(c.f(c.this)) });
          if (paramAnonymousInt1 != com.tencent.mm.plugin.backup.b.c.uVS) {
            break label387;
          }
          if (!c.cVx()) {
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
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(300761);
            c.this.cVy();
            c.g(c.this);
            AppMethodBeat.o(300761);
          }
        });
        AppMethodBeat.o(21308);
        return;
        label387:
        if (c.cVx()) {
          c.a(c.this, 3);
        }
        for (;;)
        {
          c.b(c.this, false);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(300760);
              c.this.cVy();
              c.g(c.this);
              AppMethodBeat.o(300760);
            }
          });
          AppMethodBeat.o(21308);
          return;
          c.a(c.this, 1);
        }
      }
    };
    this.uZa = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(300746);
        com.tencent.mm.plugin.backup.g.b.b(3, c.h(c.this));
        Log.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          b.cVs().cUJ().uWg = -5;
          c.this.Fc(-5);
          AppMethodBeat.o(300746);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.k)paramAnonymousp;
        paramAnonymousp = paramAnonymousString.vdC;
        if (!b.cVs().uVY.equals(paramAnonymousp.vgy))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
          b.cVs().cUJ().uWg = -5;
          c.this.Fc(-5);
          AppMethodBeat.o(300746);
          return;
        }
        b.cVs().cUJ().uWo = paramAnonymousp.vhc;
        c.this.hEl = paramAnonymousString.vdC.vhf.vgV;
        label349:
        label374:
        long l;
        if (paramAnonymousString.vdC.vhf.vgY.toLowerCase().contains("ios"))
        {
          c.b(c.this, 1);
          c.a(c.this, paramAnonymousString.vdC.vhj);
          c.c(c.this, paramAnonymousString.vdC.vhl);
          Log.i("MicroMsg.BackupMoveRecoverServer", "move recover backupMoveDevice[%d], totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", new Object[] { Integer.valueOf(c.i(c.this)), Long.valueOf(paramAnonymousString.vdC.vhi), Long.valueOf(paramAnonymousString.vdC.vhj / 1024L) });
          if ((c.j(c.this)) && (c.f(c.this)))
          {
            paramAnonymousp = com.tencent.mm.plugin.report.service.h.OAn;
            if ((!c.k(c.this)) && (c.l(c.this) != 1)) {
              break label610;
            }
            paramAnonymousInt1 = 66;
            paramAnonymousp.idkeyStat(485L, paramAnonymousInt1, 1L, false);
          }
          if (paramAnonymousString.vdC.vhh != 3) {
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
          paramAnonymousp = new PLong();
          bh.bCz();
          g.a(paramAnonymousString, paramAnonymousp, com.tencent.mm.model.c.getAccPath());
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
          c.this.uZb = l;
          if (paramAnonymousp.value >= l) {
            break label650;
          }
          Log.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramAnonymousp.value), Long.valueOf(l), Long.valueOf(c.m(c.this)) });
          com.tencent.mm.plugin.report.service.h.OAn.b(11787, new Object[] { Integer.valueOf(5) });
          b.cVs().cVt().stop();
          b.cVs().cUJ().uWg = -13;
          c.this.Fc(-13);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 5L, 1L, false);
          AppMethodBeat.o(300746);
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
        com.tencent.mm.plugin.backup.g.b.cWo();
        AppMethodBeat.o(300746);
      }
    };
    this.uZd = new b.c()
    {
      public final void cVF()
      {
        AppMethodBeat.i(300750);
        Log.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.cWp();
        b.cVs().cUL();
        AppMethodBeat.o(300750);
      }
    };
    this.uZe = new j.a()
    {
      public final void Fh(int paramAnonymousInt)
      {
        AppMethodBeat.i(300755);
        int i = b.cVs().cUJ().uWg;
        if (paramAnonymousInt == 1)
        {
          if (i == 23)
          {
            Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
            b.cVs().cUJ().uWg = 4;
            c.this.Fc(4);
            c.this.Fg(8);
            AppMethodBeat.o(300755);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
          b.cVs().cUJ().uWg = 23;
          c.this.Fc(23);
          c.this.Fg(9);
        }
        AppMethodBeat.o(300755);
      }
      
      public final void cVG()
      {
        AppMethodBeat.i(300752);
        c.this.Fc(b.cVs().cUJ().uWg);
        AppMethodBeat.o(300752);
      }
      
      public final void cVH()
      {
        AppMethodBeat.i(300759);
        int i = b.cVs().cUJ().uWg;
        Log.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 23) || (i == 4))
        {
          c.this.a(true, false, -4);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 43L, 1L, false);
          c.this.Fg(4);
          b.cVs().cVt().stop();
        }
        AppMethodBeat.o(300759);
      }
    };
    AppMethodBeat.o(21315);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(21323);
    com.tencent.mm.plugin.backup.i.y localy = new com.tencent.mm.plugin.backup.i.y();
    localy.vhN = paramString;
    localy.vhO = paramInt1;
    localy.vhQ = paramInt2;
    localy.vhR = paramInt3;
    localy.vhk = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.D(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21323);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21323);
    }
  }
  
  public static String cVB()
  {
    AppMethodBeat.i(21327);
    String str = com.tencent.mm.plugin.backup.g.b.cWs();
    AppMethodBeat.o(21327);
    return str;
  }
  
  private static void cVC()
  {
    AppMethodBeat.i(21328);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.vgy = b.cVs().uVY;
    try
    {
      Log.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.N(locala.toByteArray(), 5);
      AppMethodBeat.o(21328);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21328);
    }
  }
  
  public static boolean cVx()
  {
    AppMethodBeat.i(21316);
    boolean bool = bh.bCz().bAg().iXd();
    AppMethodBeat.o(21316);
    return bool;
  }
  
  private void cVz()
  {
    AppMethodBeat.i(21320);
    String str1 = this.uYR;
    String str2 = this.uYS;
    String str3 = g.fC(MMApplicationContext.getContext());
    Log.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(nrQ) });
    if ((str3 == null) || (str3.equals("")))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.b(11787, new Object[] { Integer.valueOf(1) });
      b.cVs().cUJ().uWg = -1;
      Fc(-1);
      AppMethodBeat.o(21320);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.b(11787, new Object[] { Integer.valueOf(2) });
      b.cVs().cUJ().uWg = -2;
      Fc(-2);
      AppMethodBeat.o(21320);
      return;
    }
    if (!g.ahB(str2))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 3L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.b(11787, new Object[] { Integer.valueOf(3) });
      b.cVs().cUJ().uWg = -3;
      Fc(-3);
      AppMethodBeat.o(21320);
      return;
    }
    if (nrQ <= 0)
    {
      b.cVs().cUJ().uWg = -5;
      Fc(-5);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 4L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.b(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(21320);
      return;
    }
    nrQ -= 1;
    dt(this.uYS, this.uYT);
    AppMethodBeat.o(21320);
  }
  
  private void dt(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(21319);
    b.cVs().cVt().ds(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.uYZ);
    for (;;)
    {
      try
      {
        if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.uYM = bool;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.cVs().uVZ, b.cVs().uWa, com.tencent.mm.plugin.backup.b.d.cUN(), b.cVs().uVY, com.tencent.mm.plugin.backup.b.c.uVQ, 22, cVx());
      paramString.K(this.uYM, false);
      paramString.cWw();
      Log.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.uYU == null) {
        this.uYU = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(300758);
            if (!c.ayB())
            {
              Log.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
              if (c.c(c.this) != null) {
                c.c(c.this).stopTimer();
              }
              c.d(c.this);
            }
            AppMethodBeat.o(300758);
            return true;
          }
        }, false);
      }
      this.uYU.startTimer(3000L);
      AppMethodBeat.o(21319);
      return;
      bool = false;
    }
  }
  
  public final void Fc(final int paramInt)
  {
    AppMethodBeat.i(21329);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(300756);
        Iterator localIterator = this.uZh.iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.backup.b.b.d)localIterator.next()).Fc(paramInt);
        }
        AppMethodBeat.o(300756);
      }
    });
    if (this.uYX != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300749);
          if (c.p(c.this) != null) {
            c.p(c.this).Fb(paramInt);
          }
          AppMethodBeat.o(300749);
        }
      });
    }
    AppMethodBeat.o(21329);
  }
  
  public final void Fg(int paramInt)
  {
    AppMethodBeat.i(21324);
    long l = 0L;
    if (this.uYF != 0L) {
      l = Util.milliSecondsToNow(this.uYF);
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.uYQ), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.uWp / 1024L), Integer.valueOf(this.uYP) });
    Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.uWn / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.uWp / 1024L) });
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
      paramInt1 = b.cVs().cUJ().uWg;
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
      b.cVs().cVt().stop();
      if (!uYV)
      {
        if (this.uYU != null)
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.uYU.stopTimer();
        }
        cVz();
        AppMethodBeat.o(21321);
        return;
      }
      b.cVs().cUJ().uWg = -4;
      Fc(-4);
      AppMethodBeat.o(21321);
      return;
      b.cVs().cVt().stop();
      AppMethodBeat.o(21321);
      return;
      a(true, false, -4);
      b.cVs().cVt().stop();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 43L, 1L, false);
      Fg(4);
      l = 0L;
      if (this.uYF != 0L) {
        l = Util.milliSecondsToNow(this.uYF);
      }
      Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.uWn), Long.valueOf(this.recvSize), Long.valueOf(l) });
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
      Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.vda) });
      paramArrayOfByte = new com.tencent.mm.plugin.backup.i.f();
      paramArrayOfByte.vda = locale.vda;
      try
      {
        Log.d("MicroMsg.BackupMoveRecoverServer", "onNotify send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.D(paramArrayOfByte.toByteArray(), 10, paramInt2);
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
      for (l = paramArrayOfByte.vda;; l = -1L)
      {
        Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 51L, 1L, false);
      a(true, false, -100);
    }
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(300743);
        if (paramInt1 == 11)
        {
          c.a(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(300743);
          return;
        }
        if (paramInt1 == 6)
        {
          c.b(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(300743);
          return;
        }
        if (paramInt1 == 13)
        {
          c.K(paramArrayOfByte, paramInt2);
          AppMethodBeat.o(300743);
          return;
        }
        if (paramInt1 == 15)
        {
          c.c(c.this, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(300743);
          return;
        }
        if (paramInt1 == 8)
        {
          c.a(c.this, paramArrayOfByte);
          AppMethodBeat.o(300743);
          return;
        }
        AppMethodBeat.o(300743);
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
      cVC();
    }
    synchronized (this.lock)
    {
      this.nzW = true;
      if ((this.uYw != null) && (this.uYw.uXC))
      {
        this.uYw.A(paramBoolean2, paramInt);
        this.uYw = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.cVs().cUJ().uWg = paramInt;
          Fc(paramInt);
        }
        if (paramBoolean2) {
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(300754);
              c.this.cVy();
              AppMethodBeat.o(300754);
            }
          });
        }
        com.tencent.mm.plugin.backup.g.b.cWp();
        com.tencent.mm.plugin.backup.g.b.cWr();
        b.cVs().cUL();
        b.cVs().cVt().uWE = null;
        AppMethodBeat.o(21318);
        return;
      }
      i = 1;
    }
  }
  
  public final void cUI()
  {
    AppMethodBeat.i(21330);
    long l1 = Util.milliSecondsToNow(this.uYG) / 1000L;
    long l2 = b.cVs().cUJ().uWr;
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 49L, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 50L, l1, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 72L, l2, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 52L, this.recvSize / 1024L, false);
    this.uYx = com.tencent.mm.vfs.y.bEl(com.tencent.mm.kernel.h.baE().bal());
    com.tencent.mm.plugin.report.service.h.OAn.b(17868, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.uYy / 1024L), Long.valueOf(this.uYz / 1024L), Long.valueOf(this.uWp / 1024L), Long.valueOf(this.uYx / 1024L), Long.valueOf(this.uWq), Long.valueOf(l2) });
    Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.uYy / 1024L), Long.valueOf(this.uYz / 1024L), Long.valueOf(this.uWp / 1024L), Long.valueOf(this.uYx / 1024L), Long.valueOf(this.uWq), Long.valueOf(l2) });
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acPd, Boolean.TRUE);
    Log.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    if (g.uWz)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      StringBuilder localStringBuilder = new StringBuilder("\nMerge Info:\n");
      localStringBuilder.append("mergeStartTime:").append(((SimpleDateFormat)localObject).format(new Date(this.uYG))).append("\n");
      localStringBuilder.append("mergeTime:").append(l1).append("\n");
      localStringBuilder.append("totalMsgCount:").append(l2).append("\n");
      localStringBuilder.append("recvSize:").append(this.recvSize / 1024L).append(" kB\n");
      g.b(g.cUY(), "backupTestInfo.txt", localStringBuilder.toString().getBytes());
    }
    if (!this.uXO)
    {
      localObject = bh.bCz().bAf().iXf();
      if ((localObject != null) && (((LinkedList)localObject).size() > 0)) {
        break label601;
      }
      Log.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300747);
          c.this.cVy();
          AppMethodBeat.o(300747);
        }
      });
      com.tencent.mm.plugin.backup.g.b.Fp(22);
      com.tencent.mm.plugin.backup.g.b.cWp();
      com.tencent.mm.plugin.backup.g.b.cWr();
      AppMethodBeat.o(21330);
      return;
      label601:
      Log.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      bh.bCz().bAe().j(this.hEl, (LinkedList)localObject);
    }
  }
  
  public final void cVA()
  {
    AppMethodBeat.i(21325);
    a(true, false, 28);
    b.cVs().cVt().stop();
    AppMethodBeat.o(21325);
  }
  
  public final void cVy()
  {
    AppMethodBeat.i(21317);
    Log.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.uYE.clear();
    if (!g.uWz)
    {
      g.ahx(g.cUW());
      g.cUU();
    }
    AppMethodBeat.o(21317);
  }
  
  public final void lX(boolean paramBoolean)
  {
    AppMethodBeat.i(21326);
    synchronized (this.lock)
    {
      if ((this.uYw != null) && (this.uYw.uXC))
      {
        Log.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21326);
        return;
      }
      if (this.uYw != null)
      {
        com.tencent.mm.plugin.backup.c.d locald = this.uYw;
        com.tencent.threadpool.h.ahAA.bm(new c.2(this, locald));
      }
      if ((this.uYE == null) || (this.uYE.size() <= 0))
      {
        i = bh.bCz().bAg().iXe();
        b.cVs().cUJ().uWg = 26;
        b.cVs().cUJ().uWj = 0;
        Fc(26);
        com.tencent.mm.plugin.backup.h.d.cWK().cWN();
        this.uYG = Util.nowMilliSecond();
        this.uYw = new com.tencent.mm.plugin.backup.c.d(b.cVs(), 2, this, i, false, new LinkedList(), new LinkedList());
        this.uYw.lX(paramBoolean);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(21326);
        return;
      }
      int i = this.uYE.size();
    }
  }
  
  public final void lY(boolean paramBoolean)
  {
    AppMethodBeat.i(21322);
    Log.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse, isChooseAll:%s, isResumeMove:%s, isQuickBackup:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uYN), Boolean.valueOf(this.uXO) });
    this.uYO = paramBoolean;
    Object localObject1 = new LinkedBlockingQueue();
    b.cVs().cVt().uWE = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(300744);
        for (;;)
        {
          if (!c.n(c.this)) {}
          try
          {
            boolean bool = this.uZk.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              Log.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.uZk.size()) });
              AppMethodBeat.o(300744);
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
    com.tencent.threadpool.h.ahAA.bp(new com.tencent.threadpool.i.h()
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
          if ((!c.n(c.this)) && (!c.cVE())) {
            try
            {
              c.a locala = (c.a)this.uZk.poll(500L, TimeUnit.MILLISECONDS);
              Log.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.uZk.size()), locala });
              if (locala != null) {
                c.this.a(locala.hJv, locala.type, locala.buf, locala.oUj);
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
      bh.bCz().bAe().bjb();
    }
    Object localObject2;
    if ((!this.uYN) && (!this.uXO) && (!paramBoolean))
    {
      localObject1 = this.uYC;
      localObject2 = this.uYD;
      this.uYC = new LinkedList();
      this.uYD = new LinkedList();
      bh.bCz().bAe().a(this.hEl, (LinkedList)localObject1, (LinkedList)localObject2, this.uYC, this.uYD);
    }
    localObject1 = new j();
    ((j)localObject1).vgP = this.uYC;
    ((j)localObject1).vgQ = this.uYD;
    try
    {
      Log.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(((j)localObject1).vgP.size()), Integer.valueOf(((j)localObject1).vgQ.size()) });
      com.tencent.mm.plugin.backup.g.b.D(((j)localObject1).toByteArray(), 12, this.uZc);
      try
      {
        localObject1 = this.uYD.iterator();
        localObject2 = this.uYC.iterator();
        while (((Iterator)localObject2).hasNext()) {
          Log.i("MicroMsg.BackupMoveRecoverServer", "session:%s, startTime:%s, endTime:%s", new Object[] { (String)((Iterator)localObject2).next(), ((Iterator)localObject1).next(), ((Iterator)localObject1).next() });
        }
        b.cVs().cUJ().ak(23, 1, this.uYA.size());
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.BackupMoveRecoverServer", "TimeInterval size error. e:%s", new Object[] { localException1 });
        com.tencent.mm.plugin.backup.g.b.cWq();
        if (!this.uYN) {
          break label511;
        }
      }
      this.uWn = b.cVs().cUJ().uWn;
      this.recvSize = b.cVs().cUJ().uWk;
      this.uYy = b.cVs().cUJ().uWl;
      this.uYz = b.cVs().cUJ().uWm;
      this.uWp = b.cVs().cUJ().uWp;
      this.uWq = b.cVs().cUJ().uWq;
      com.tencent.mm.plugin.backup.h.d.cWK().cWN();
      this.uWq = -1L;
      com.tencent.threadpool.h.ahAA.bp(new c.15(this));
      Fc(23);
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
        b.cVs().cUJ().a(23, 1, this.uYA.size(), 0L, this.uWn, 0L, 0L);
        this.uWp = com.tencent.mm.vfs.y.bEl(com.tencent.mm.kernel.h.baE().bal());
        b.cVs().cUJ().uWp = this.uWp;
      }
    }
  }
  
  final class a
  {
    byte[] buf;
    boolean hJv;
    int oUj;
    int type;
    
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(21314);
      this.hJv = false;
      this.oUj = paramInt1;
      this.type = paramInt2;
      this.buf = ((byte[])paramArrayOfByte.clone());
      AppMethodBeat.o(21314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c
 * JD-Core Version:    0.7.0.1
 */