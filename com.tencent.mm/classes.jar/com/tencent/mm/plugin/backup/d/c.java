package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static int hfV = 0;
  private static boolean nvl = false;
  String cUi;
  private boolean hjP;
  private Object lock;
  private long nsQ;
  private long nsS;
  private long nsT;
  private com.tencent.mm.plugin.backup.c.d nuZ;
  public com.tencent.mm.plugin.backup.b.b.d num;
  private boolean nur;
  private final com.tencent.mm.al.f nvA;
  public long nvB;
  private int nvC;
  b.c nvD;
  private final j.a nvE;
  private long nva;
  private long nvb;
  private long nvc;
  private LinkedList<String> nvd;
  private LinkedList<Long> nve;
  private LinkedList<String> nvf;
  private LinkedList<Long> nvg;
  public b.a nvh;
  private HashSet<String> nvi;
  private long nvj;
  private long nvk;
  private boolean nvm;
  private int nvn;
  public boolean nvo;
  private boolean nvp;
  private boolean nvq;
  private boolean nvr;
  private boolean nvs;
  private int nvt;
  public String nvu;
  String nvv;
  int nvw;
  private av nvx;
  final com.tencent.mm.al.f nvy;
  private final com.tencent.mm.al.f nvz;
  private long recvSize;
  
  public c()
  {
    AppMethodBeat.i(21315);
    this.nsS = 0L;
    this.nsT = -1L;
    this.nva = 0L;
    this.nsQ = 0L;
    this.recvSize = 0L;
    this.nvb = 0L;
    this.nvc = 0L;
    this.lock = new Object();
    this.hjP = false;
    this.nvd = new LinkedList();
    this.nvi = new HashSet();
    this.nvj = 0L;
    this.nvk = 0L;
    this.nvm = true;
    this.nvn = 0;
    this.nvo = false;
    this.nvp = true;
    this.nvq = true;
    this.nur = false;
    this.nvr = false;
    this.nvs = false;
    this.nvy = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21300);
        ba.aiU().b(595, c.a(c.this));
        com.tencent.mm.plugin.backup.b.d.xq(22);
        b.bHG().bGX().nsJ = 1;
        Object localObject2 = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
        ((Intent)localObject2).addFlags(335544320);
        ((Intent)localObject2).putExtra("nofification_type", "backup_move_notification");
        Object localObject1 = aj.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 41L, 1L, false);
        paramAnonymousn = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bIR();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
          }
          ba.aBQ();
          if (!bt.nullAsNil((String)com.tencent.mm.model.c.ajl().get(2, null)).equals(paramAnonymousn.FAA))
          {
            ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
            b.bHG().bGX().nsJ = -14;
            c.this.xp(-14);
            AppMethodBeat.o(21300);
            return;
          }
          b.bHG().bGX().nsJ = -5;
          c.this.xp(-5);
          AppMethodBeat.o(21300);
          return;
        }
        ba.aBQ();
        if (!bt.nullAsNil((String)com.tencent.mm.model.c.ajl().get(2, null)).equals(paramAnonymousn.FAA))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
          b.bHG().bGX().nsJ = -5;
          c.this.xp(-14);
          AppMethodBeat.o(21300);
          return;
        }
        b.bHG().nsB = paramAnonymousn.ID;
        b.bHG().nsC = paramAnonymousn.FAG;
        b.bHG().nsD = paramAnonymousn.FAH;
        com.tencent.mm.plugin.backup.g.b.a(c.this.nvD);
        b.bHG().bGY();
        com.tencent.mm.plugin.backup.g.b.a(b.bHG().bHJ());
        com.tencent.mm.plugin.backup.g.b.a(b.bHG().bHH());
        com.tencent.mm.plugin.backup.g.b.xq(2);
        com.tencent.mm.plugin.backup.g.b.a(c.b(c.this));
        paramAnonymousString = null;
        paramAnonymousInt1 = 0;
        if (paramAnonymousn.FAx > 0)
        {
          localObject1 = (aba)paramAnonymousn.FAy.getFirst();
          paramAnonymousString = ((aba)localObject1).FWO;
          paramAnonymousInt1 = ((Integer)((aba)localObject1).Gaw.getFirst()).intValue();
        }
        for (;;)
        {
          localObject1 = c.this;
          ((c)localObject1).nvu = paramAnonymousn.FAB;
          ((c)localObject1).nvv = paramAnonymousString;
          ((c)localObject1).nvw = paramAnonymousInt1;
          ad.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousn.nEf), Integer.valueOf(paramAnonymousn.Scene), paramAnonymousn.FAB, paramAnonymousString, Integer.valueOf(paramAnonymousInt1) });
          c.access$202(false);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramAnonymousString, paramAnonymousn.FAB, com.tencent.mm.plugin.backup.b.g.eh(aj.getContext()) });
          c.bHR();
          c.a(c.this, paramAnonymousString, paramAnonymousInt1);
          AppMethodBeat.o(21300);
          return;
          ad.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
        }
      }
    };
    this.nvz = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21307);
        c.access$202(true);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 42L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(11787, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.e(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
          b.bHG().bGX().nsJ = -5;
          c.this.xp(-5);
          c.this.xt(3);
          AppMethodBeat.o(21307);
          return;
        }
        ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        if (paramAnonymousString.nyQ.Version < com.tencent.mm.plugin.backup.b.c.nst)
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramAnonymousString.nyQ.Version) });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 104L, 1L, false);
          b.bHG().bGX().nsJ = -12;
          c.this.xp(-12);
          AppMethodBeat.o(21307);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.nyQ.nEf;
        paramAnonymousn = c.this;
        boolean bool;
        if ((paramAnonymousString.nyQ.nEg & com.tencent.mm.plugin.backup.b.c.nsx) == 0)
        {
          bool = false;
          c.a(paramAnonymousn, bool);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramAnonymousString.nyQ.Version), Integer.valueOf(paramAnonymousInt1), Boolean.valueOf(c.f(c.this)) });
          if ((paramAnonymousInt1 != com.tencent.mm.plugin.backup.b.c.nsv) || (!c.bHL())) {
            break label377;
          }
          c.b(c.this, true);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
        }
        for (;;)
        {
          c.g(c.this);
          com.tencent.mm.plugin.backup.g.b.a(3, c.h(c.this));
          new com.tencent.mm.plugin.backup.g.k(b.bHG().nsB).bIJ();
          b.bHG().bGX().nsJ = 22;
          c.this.xp(22);
          AppMethodBeat.o(21307);
          return;
          bool = true;
          break;
          label377:
          c.this.bHM();
          c.b(c.this, false);
          ad.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
        }
      }
    };
    this.nvA = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21308);
        com.tencent.mm.plugin.backup.g.b.b(3, c.h(c.this));
        ad.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          b.bHG().bGX().nsJ = -5;
          c.this.xp(-5);
          AppMethodBeat.o(21308);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.k)paramAnonymousn;
        paramAnonymousn = paramAnonymousString.nzX;
        if (!b.bHG().nsB.equals(paramAnonymousn.ID))
        {
          ad.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
          b.bHG().bGX().nsJ = -5;
          c.this.xp(-5);
          AppMethodBeat.o(21308);
          return;
        }
        b.bHG().bGX().nsR = paramAnonymousn.nDy;
        c.this.cUi = paramAnonymousString.nzX.nDB.nDr;
        label339:
        label364:
        long l;
        if (paramAnonymousString.nzX.nDB.nDu.toLowerCase().contains("ios"))
        {
          c.a(c.this, 1);
          c.a(c.this, paramAnonymousString.nzX.nDF);
          c.b(c.this, paramAnonymousString.nzX.nDH);
          ad.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", new Object[] { Long.valueOf(paramAnonymousString.nzX.nDE), Long.valueOf(paramAnonymousString.nzX.nDF / 1024L) });
          if ((c.i(c.this)) && (c.f(c.this)))
          {
            paramAnonymousn = com.tencent.mm.plugin.report.service.g.yhR;
            if ((!c.j(c.this)) && (c.k(c.this) != 1)) {
              break label601;
            }
            paramAnonymousInt1 = 66;
            paramAnonymousn.idkeyStat(485L, paramAnonymousInt1, 1L, false);
          }
          if (paramAnonymousString.nzX.nDD != 3) {
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
          ba.aBQ();
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
          c.this.nvB = l;
          if (paramAnonymousn.value >= l) {
            break label641;
          }
          ad.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramAnonymousn.value), Long.valueOf(l), Long.valueOf(c.l(c.this)) });
          com.tencent.mm.plugin.report.service.g.yhR.f(11787, new Object[] { Integer.valueOf(5) });
          b.bHG().bHH().stop();
          b.bHG().bGX().nsJ = -13;
          c.this.xp(-13);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 5L, 1L, false);
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
        c.b(c.this, bt.flT());
        com.tencent.mm.plugin.backup.g.b.bIB();
        AppMethodBeat.o(21308);
      }
    };
    this.nvD = new b.c()
    {
      public final void bHV()
      {
        AppMethodBeat.i(21313);
        ad.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bIC();
        b.bHG().bGZ();
        AppMethodBeat.o(21313);
      }
    };
    this.nvE = new j.a()
    {
      public final void bHT()
      {
        AppMethodBeat.i(21301);
        c.this.xp(b.bHG().bGX().nsJ);
        AppMethodBeat.o(21301);
      }
      
      public final void bHU()
      {
        AppMethodBeat.i(21303);
        int i = b.bHG().bGX().nsJ;
        ad.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 23) || (i == 4))
        {
          c.this.b(true, false, -4);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 43L, 1L, false);
          c.this.xt(4);
          b.bHG().bHH().stop();
        }
        AppMethodBeat.o(21303);
      }
      
      public final void xu(int paramAnonymousInt)
      {
        AppMethodBeat.i(21302);
        int i = b.bHG().bGX().nsJ;
        if (paramAnonymousInt == 1)
        {
          if (i == 23)
          {
            ad.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
            b.bHG().bGX().nsJ = 4;
            c.this.xp(4);
            c.this.xt(8);
            AppMethodBeat.o(21302);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
          b.bHG().bGX().nsJ = 23;
          c.this.xp(23);
          c.this.xt(9);
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
    localy.nEj = paramString;
    localy.nEk = paramInt1;
    localy.nEm = paramInt2;
    localy.nEn = paramInt3;
    localy.nDG = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21323);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21323);
    }
  }
  
  public static boolean bHL()
  {
    AppMethodBeat.i(21316);
    boolean bool = ba.aBQ().azV().foJ();
    AppMethodBeat.o(21316);
    return bool;
  }
  
  private void bHN()
  {
    AppMethodBeat.i(21320);
    String str1 = this.nvu;
    String str2 = this.nvv;
    String str3 = com.tencent.mm.plugin.backup.b.g.eh(aj.getContext());
    ad.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(hfV) });
    if ((str3 == null) || (str3.equals("")))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(11787, new Object[] { Integer.valueOf(1) });
      b.bHG().bGX().nsJ = -1;
      xp(-1);
      AppMethodBeat.o(21320);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(11787, new Object[] { Integer.valueOf(2) });
      b.bHG().bGX().nsJ = -2;
      xp(-2);
      AppMethodBeat.o(21320);
      return;
    }
    if (!com.tencent.mm.plugin.backup.b.g.VS(str2))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 3L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(11787, new Object[] { Integer.valueOf(3) });
      b.bHG().bGX().nsJ = -3;
      xp(-3);
      AppMethodBeat.o(21320);
      return;
    }
    if (hfV <= 0)
    {
      b.bHG().bGX().nsJ = -5;
      xp(-5);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 4L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(21320);
      return;
    }
    hfV -= 1;
    ck(this.nvv, this.nvw);
    AppMethodBeat.o(21320);
  }
  
  public static String bHP()
  {
    AppMethodBeat.i(21327);
    String str = com.tencent.mm.plugin.backup.g.b.bIF();
    AppMethodBeat.o(21327);
    return str;
  }
  
  private static void bHQ()
  {
    AppMethodBeat.i(21328);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bHG().nsB;
    try
    {
      ad.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21328);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21328);
    }
  }
  
  private void ck(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(21319);
    b.bHG().bHH().connect(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.nvz);
    for (;;)
    {
      try
      {
        if (bt.getInt(com.tencent.mm.n.g.acA().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.nvq = bool;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.bHG().nsC, b.bHG().nsD, com.tencent.mm.plugin.backup.b.d.bHb(), b.bHG().nsB, com.tencent.mm.plugin.backup.b.c.nst, 22);
      paramString.B(this.nvq, false);
      paramString.bIJ();
      ad.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.nvx == null) {
        this.nvx = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(21306);
            if (!c.aMx)
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
      this.nvx.az(3000L, 3000L);
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
      paramInt1 = b.bHG().bGX().nsJ;
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
      b.bHG().bHH().stop();
      if (!aMx)
      {
        if (this.nvx != null)
        {
          ad.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.nvx.stopTimer();
        }
        bHN();
        AppMethodBeat.o(21321);
        return;
      }
      b.bHG().bGX().nsJ = -4;
      xp(-4);
      AppMethodBeat.o(21321);
      return;
      b.bHG().bHH().stop();
      AppMethodBeat.o(21321);
      return;
      b(true, false, -4);
      b.bHG().bHH().stop();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 43L, 1L, false);
      xt(4);
      l = 0L;
      if (this.nvj != 0L) {
        l = bt.Df(this.nvj);
      }
      ad.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.nsQ), Long.valueOf(this.recvSize), Long.valueOf(l) });
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
        ad.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cD(paramArrayOfByte)) });
        AppMethodBeat.o(21321);
        return;
      }
      ad.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.nzv) });
      paramArrayOfByte = new com.tencent.mm.plugin.backup.i.f();
      paramArrayOfByte.nzv = locale.nzv;
      try
      {
        ad.d("MicroMsg.BackupMoveRecoverServer", "onNotify send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.t(paramArrayOfByte.toByteArray(), 10, paramInt2);
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
      paramArrayOfByte = (com.tencent.mm.plugin.backup.i.f)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.nzv;; l = -1L)
      {
        ad.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 51L, 1L, false);
      b(true, false, -100);
    }
    ba.ajF().ay(new Runnable()
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
    ad.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), at.fkV() });
    if (!paramBoolean1) {
      bHQ();
    }
    synchronized (this.lock)
    {
      this.hjP = true;
      if ((this.nuZ != null) && (this.nuZ.nug))
      {
        this.nuZ.w(paramBoolean2, paramInt);
        this.nuZ = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bHG().bGX().nsJ = paramInt;
          xp(paramInt);
        }
        if (paramBoolean2) {
          bHM();
        }
        com.tencent.mm.plugin.backup.g.b.bIC();
        com.tencent.mm.plugin.backup.g.b.bIE();
        b.bHG().bGZ();
        b.bHG().bHH().nti = null;
        AppMethodBeat.o(21318);
        return;
      }
      i = 1;
    }
  }
  
  public final void bGW()
  {
    AppMethodBeat.i(21330);
    long l1 = bt.Df(this.nvk) / 1000L;
    long l2 = b.bHG().bGX().nsU;
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 49L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 50L, l1, false);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 72L, l2, false);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 52L, this.recvSize / 1024L, false);
    this.nva = com.tencent.mm.vfs.i.aYo(com.tencent.mm.kernel.g.ajC().ajj());
    com.tencent.mm.plugin.report.service.g.yhR.f(17868, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.nvb / 1024L), Long.valueOf(this.nvc / 1024L), Long.valueOf(this.nsS / 1024L), Long.valueOf(this.nva / 1024L), Long.valueOf(this.nsT), Long.valueOf(l2) });
    ad.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.nvb / 1024L), Long.valueOf(this.nvc / 1024L), Long.valueOf(this.nsS / 1024L), Long.valueOf(this.nva / 1024L), Long.valueOf(this.nsT), Long.valueOf(l2) });
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Ixi, Boolean.TRUE);
    ad.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    if (com.tencent.mm.plugin.backup.b.g.ntc)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      StringBuilder localStringBuilder = new StringBuilder("\nMerge Info:\n");
      localStringBuilder.append("mergeStartTime:").append(((SimpleDateFormat)localObject).format(new Date(this.nvk))).append("\n");
      localStringBuilder.append("mergeTime:").append(l1).append("\n");
      localStringBuilder.append("totalMsgCount:").append(l2).append("\n");
      localStringBuilder.append("recvSize:").append(this.recvSize / 1024L).append(" kB\n");
      com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.bHm(), "backupTestInfo.txt", localStringBuilder.toString().getBytes());
    }
    if (!this.nur)
    {
      localObject = ba.aBQ().azU().foL();
      if (((LinkedList)localObject).size() > 0) {
        break label583;
      }
      ad.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      bHM();
      com.tencent.mm.plugin.backup.g.b.xD(22);
      com.tencent.mm.plugin.backup.g.b.bIC();
      com.tencent.mm.plugin.backup.g.b.bIE();
      AppMethodBeat.o(21330);
      return;
      label583:
      ad.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      ba.aBQ().azT().i(this.cUi, (LinkedList)localObject);
    }
  }
  
  public final void bHM()
  {
    AppMethodBeat.i(21317);
    ad.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.nvi.clear();
    if (!com.tencent.mm.plugin.backup.b.g.ntc)
    {
      com.tencent.mm.plugin.backup.b.g.VO(com.tencent.mm.plugin.backup.b.g.bHk());
      com.tencent.mm.plugin.backup.b.g.bHi();
    }
    AppMethodBeat.o(21317);
  }
  
  public final void bHO()
  {
    AppMethodBeat.i(21325);
    b(true, false, 28);
    b.bHG().bHH().stop();
    AppMethodBeat.o(21325);
  }
  
  public final void iA(boolean paramBoolean)
  {
    AppMethodBeat.i(21326);
    synchronized (this.lock)
    {
      if ((this.nuZ != null) && (this.nuZ.nug))
      {
        ad.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21326);
        return;
      }
      if (this.nuZ != null) {
        this.nuZ.w(false, 0);
      }
      if ((this.nvi == null) || (this.nvi.size() <= 0))
      {
        i = ba.aBQ().azV().foK();
        b.bHG().bGX().nsJ = 26;
        b.bHG().bGX().nsM = 0;
        xp(26);
        com.tencent.mm.plugin.backup.h.d.bIY().bJb();
        this.nvk = bt.flT();
        this.nuZ = new com.tencent.mm.plugin.backup.c.d(b.bHG(), 2, this, i, false, new LinkedList(), new LinkedList());
        this.nuZ.iA(paramBoolean);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(21326);
        return;
      }
      int i = this.nvi.size();
    }
  }
  
  public final void iB(boolean paramBoolean)
  {
    AppMethodBeat.i(21322);
    this.nvs = paramBoolean;
    Object localObject = new LinkedBlockingQueue();
    b.bHG().bHH().nti = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21310);
        for (;;)
        {
          if (!c.m(c.this)) {}
          try
          {
            boolean bool = this.nvH.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              ad.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.nvH.size()) });
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
    com.tencent.e.h.LTJ.aU(new com.tencent.e.i.h()
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
          if ((!c.m(c.this)) && (!c.bHS())) {
            try
            {
              c.a locala = (c.a)this.nvH.poll(500L, TimeUnit.MILLISECONDS);
              ad.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.nvH.size()), locala });
              if (locala != null) {
                c.this.a(locala.dCQ, locala.type, locala.buf, locala.inh);
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
    if ((!this.nur) && (!paramBoolean))
    {
      localObject = this.nvf;
      LinkedList localLinkedList = this.nvg;
      this.nvf = new LinkedList();
      this.nvg = new LinkedList();
      ba.aBQ().azT().a(this.cUi, (LinkedList)localObject, localLinkedList, this.nvf, this.nvg);
    }
    localObject = new j();
    ((j)localObject).nDk = this.nvf;
    ((j)localObject).nDl = this.nvg;
    try
    {
      ad.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(((j)localObject).nDk.size()), Integer.valueOf(((j)localObject).nDl.size()) });
      com.tencent.mm.plugin.backup.g.b.t(((j)localObject).toByteArray(), 12, this.nvC);
      com.tencent.mm.plugin.backup.g.b.bID();
      if (this.nvr)
      {
        b.bHG().bGX().R(23, 1, this.nvd.size());
        this.nsQ = b.bHG().bGX().nsQ;
        this.recvSize = b.bHG().bGX().nsN;
        this.nvb = b.bHG().bGX().nsO;
        this.nvc = b.bHG().bGX().nsP;
        this.nsS = b.bHG().bGX().nsS;
        this.nsT = b.bHG().bGX().nsT;
        com.tencent.mm.plugin.backup.h.d.bIY().bJb();
        this.nsT = -1L;
        com.tencent.e.h.LTJ.aU(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "getMsgCount";
          }
          
          public final void run()
          {
            AppMethodBeat.i(21312);
            c.c(c.this, com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().dmb());
            b.bHG().bGX().nsT = c.n(c.this);
            AppMethodBeat.o(21312);
          }
        });
        xp(23);
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
        b.bHG().bGX().a(23, 1, this.nvd.size(), 0L, this.nsQ, 0L, 0L);
        this.nsS = com.tencent.mm.vfs.i.aYo(com.tencent.mm.kernel.g.ajC().ajj());
        b.bHG().bGX().nsS = this.nsS;
      }
    }
  }
  
  public final void xp(final int paramInt)
  {
    AppMethodBeat.i(21329);
    if (this.num != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21304);
          if (c.o(c.this) != null) {
            c.o(c.this).xp(paramInt);
          }
          AppMethodBeat.o(21304);
        }
      });
    }
    if (this.nvh != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21305);
          if (c.p(c.this) != null) {
            c.p(c.this).xo(paramInt);
          }
          AppMethodBeat.o(21305);
        }
      });
    }
    AppMethodBeat.o(21329);
  }
  
  public final void xt(int paramInt)
  {
    AppMethodBeat.i(21324);
    long l = 0L;
    if (this.nvj != 0L) {
      l = bt.Df(this.nvj);
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.nvt), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.nsS / 1024L) });
    ad.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.nsQ / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.nsS / 1024L) });
    AppMethodBeat.o(21324);
  }
  
  final class a
  {
    byte[] buf;
    boolean dCQ;
    int inh;
    int type;
    
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(21314);
      this.dCQ = false;
      this.inh = paramInt1;
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