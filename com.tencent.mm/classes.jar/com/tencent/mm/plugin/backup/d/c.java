package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
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
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c
  implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.g.b.d
{
  private static boolean aKG = false;
  private static int gLY = 0;
  private static boolean mUO = false;
  String cIZ;
  private boolean gRx;
  private Object lock;
  private long mSs;
  private long mSu;
  private long mSv;
  public com.tencent.mm.plugin.backup.b.b.d mTO;
  private boolean mTT;
  private com.tencent.mm.plugin.backup.c.d mUC;
  private long mUD;
  private long mUE;
  private long mUF;
  private LinkedList<String> mUG;
  private LinkedList<Long> mUH;
  private LinkedList<String> mUI;
  private LinkedList<Long> mUJ;
  public b.a mUK;
  private HashSet<String> mUL;
  private long mUM;
  private long mUN;
  private boolean mUP;
  private int mUQ;
  public boolean mUR;
  private boolean mUS;
  private boolean mUT;
  private boolean mUU;
  private boolean mUV;
  private int mUW;
  public String mUX;
  String mUY;
  int mUZ;
  private au mVa;
  final com.tencent.mm.ak.g mVb;
  private final com.tencent.mm.ak.g mVc;
  private final com.tencent.mm.ak.g mVd;
  public long mVe;
  private int mVf;
  b.c mVg;
  private final j.a mVh;
  private long recvSize;
  
  public c()
  {
    AppMethodBeat.i(21315);
    this.mSu = 0L;
    this.mSv = -1L;
    this.mUD = 0L;
    this.mSs = 0L;
    this.recvSize = 0L;
    this.mUE = 0L;
    this.mUF = 0L;
    this.lock = new Object();
    this.gRx = false;
    this.mUG = new LinkedList();
    this.mUL = new HashSet();
    this.mUM = 0L;
    this.mUN = 0L;
    this.mUP = true;
    this.mUQ = 0;
    this.mUR = false;
    this.mUS = true;
    this.mUT = true;
    this.mTT = false;
    this.mUU = false;
    this.mUV = false;
    this.mVb = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21300);
        az.agi().b(595, c.a(c.this));
        com.tencent.mm.plugin.backup.b.d.wK(22);
        b.bDy().bCP().mSk = 1;
        Object localObject2 = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
        ((Intent)localObject2).addFlags(335544320);
        ((Intent)localObject2).putExtra("nofification_type", "backup_move_notification");
        Object localObject1 = ai.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 41L, 1L, false);
        paramAnonymousn = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousn).bEI();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            ac.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
          }
          az.ayM();
          if (!bs.nullAsNil((String)com.tencent.mm.model.c.agA().get(2, null)).equals(paramAnonymousn.DVf))
          {
            ac.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
            b.bDy().bCP().mSk = -14;
            c.this.wJ(-14);
            AppMethodBeat.o(21300);
            return;
          }
          b.bDy().bCP().mSk = -5;
          c.this.wJ(-5);
          AppMethodBeat.o(21300);
          return;
        }
        az.ayM();
        if (!bs.nullAsNil((String)com.tencent.mm.model.c.agA().get(2, null)).equals(paramAnonymousn.DVf))
        {
          ac.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
          b.bDy().bCP().mSk = -5;
          c.this.wJ(-14);
          AppMethodBeat.o(21300);
          return;
        }
        b.bDy().mSc = paramAnonymousn.ID;
        b.bDy().mSd = paramAnonymousn.DVl;
        b.bDy().mSe = paramAnonymousn.DVm;
        com.tencent.mm.plugin.backup.g.b.a(c.this.mVg);
        b.bDy().bCQ();
        com.tencent.mm.plugin.backup.g.b.a(b.bDy().bDB());
        com.tencent.mm.plugin.backup.g.b.a(b.bDy().bDz());
        com.tencent.mm.plugin.backup.g.b.wK(2);
        com.tencent.mm.plugin.backup.g.b.a(c.b(c.this));
        paramAnonymousString = null;
        paramAnonymousInt1 = 0;
        if (paramAnonymousn.DVc > 0)
        {
          localObject1 = (za)paramAnonymousn.DVd.getFirst();
          paramAnonymousString = ((za)localObject1).EpD;
          paramAnonymousInt1 = ((Integer)((za)localObject1).Etf.getFirst()).intValue();
        }
        for (;;)
        {
          localObject1 = c.this;
          ((c)localObject1).mUX = paramAnonymousn.DVg;
          ((c)localObject1).mUY = paramAnonymousString;
          ((c)localObject1).mUZ = paramAnonymousInt1;
          ac.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousn.ndI), Integer.valueOf(paramAnonymousn.Scene), paramAnonymousn.DVg, paramAnonymousString, Integer.valueOf(paramAnonymousInt1) });
          c.access$202(false);
          ac.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramAnonymousString, paramAnonymousn.DVg, com.tencent.mm.plugin.backup.b.g.eh(ai.getContext()) });
          c.bDJ();
          c.a(c.this, paramAnonymousString, paramAnonymousInt1);
          AppMethodBeat.o(21300);
          return;
          ac.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
        }
      }
    };
    this.mVc = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21307);
        c.access$202(true);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 42L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.f(11787, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.e(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
          b.bDy().bCP().mSk = -5;
          c.this.wJ(-5);
          c.this.wN(3);
          AppMethodBeat.o(21307);
          return;
        }
        ac.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousn;
        if (paramAnonymousString.mYt.Version < com.tencent.mm.plugin.backup.b.c.mRU)
        {
          ac.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramAnonymousString.mYt.Version) });
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 104L, 1L, false);
          b.bDy().bCP().mSk = -12;
          c.this.wJ(-12);
          AppMethodBeat.o(21307);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.mYt.ndI;
        paramAnonymousn = c.this;
        boolean bool;
        if ((paramAnonymousString.mYt.ndJ & com.tencent.mm.plugin.backup.b.c.mRY) == 0)
        {
          bool = false;
          c.a(paramAnonymousn, bool);
          ac.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramAnonymousString.mYt.Version), Integer.valueOf(paramAnonymousInt1), Boolean.valueOf(c.f(c.this)) });
          if ((paramAnonymousInt1 != com.tencent.mm.plugin.backup.b.c.mRW) || (!c.bDD())) {
            break label377;
          }
          c.b(c.this, true);
          ac.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
        }
        for (;;)
        {
          c.g(c.this);
          com.tencent.mm.plugin.backup.g.b.a(3, c.h(c.this));
          new com.tencent.mm.plugin.backup.g.k(b.bDy().mSc).bEA();
          b.bDy().bCP().mSk = 22;
          c.this.wJ(22);
          AppMethodBeat.o(21307);
          return;
          bool = true;
          break;
          label377:
          c.this.bDE();
          c.b(c.this, false);
          ac.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
        }
      }
    };
    this.mVd = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21308);
        com.tencent.mm.plugin.backup.g.b.b(3, c.h(c.this));
        ac.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          b.bDy().bCP().mSk = -5;
          c.this.wJ(-5);
          AppMethodBeat.o(21308);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.k)paramAnonymousn;
        paramAnonymousn = paramAnonymousString.mZA;
        if (!b.bDy().mSc.equals(paramAnonymousn.ID))
        {
          ac.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
          b.bDy().bCP().mSk = -5;
          c.this.wJ(-5);
          AppMethodBeat.o(21308);
          return;
        }
        b.bDy().bCP().mSt = paramAnonymousn.ndb;
        c.this.cIZ = paramAnonymousString.mZA.nde.ncU;
        label339:
        label364:
        long l;
        if (paramAnonymousString.mZA.nde.ncX.toLowerCase().contains("ios"))
        {
          c.a(c.this, 1);
          c.a(c.this, paramAnonymousString.mZA.ndi);
          c.b(c.this, paramAnonymousString.mZA.ndk);
          ac.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", new Object[] { Long.valueOf(paramAnonymousString.mZA.ndh), Long.valueOf(paramAnonymousString.mZA.ndi / 1024L) });
          if ((c.i(c.this)) && (c.f(c.this)))
          {
            paramAnonymousn = com.tencent.mm.plugin.report.service.h.wUl;
            if ((!c.j(c.this)) && (c.k(c.this) != 1)) {
              break label601;
            }
            paramAnonymousInt1 = 66;
            paramAnonymousn.idkeyStat(485L, paramAnonymousInt1, 1L, false);
          }
          if (paramAnonymousString.mZA.ndg != 3) {
            break label607;
          }
          paramAnonymousInt1 = 1;
          if (paramAnonymousInt1 == 0) {
            break label612;
          }
          c.c(c.this, true);
          ac.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
          label384:
          paramAnonymousString = new PLong();
          paramAnonymousn = new PLong();
          az.ayM();
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
          c.this.mVe = l;
          if (paramAnonymousn.value >= l) {
            break label641;
          }
          ac.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramAnonymousn.value), Long.valueOf(l), Long.valueOf(c.l(c.this)) });
          com.tencent.mm.plugin.report.service.h.wUl.f(11787, new Object[] { Integer.valueOf(5) });
          b.bDy().bDz().stop();
          b.bDy().bCP().mSk = -13;
          c.this.wJ(-13);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 5L, 1L, false);
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
        c.b(c.this, bs.eWj());
        com.tencent.mm.plugin.backup.g.b.bEs();
        AppMethodBeat.o(21308);
      }
    };
    this.mVg = new b.c()
    {
      public final void bDM()
      {
        AppMethodBeat.i(21313);
        ac.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bEt();
        b.bDy().bCR();
        AppMethodBeat.o(21313);
      }
    };
    this.mVh = new j.a()
    {
      public final void bDK()
      {
        AppMethodBeat.i(21301);
        c.this.wJ(b.bDy().bCP().mSk);
        AppMethodBeat.o(21301);
      }
      
      public final void bDL()
      {
        AppMethodBeat.i(21303);
        int i = b.bDy().bCP().mSk;
        ac.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 23) || (i == 4))
        {
          c.this.b(true, false, -4);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 43L, 1L, false);
          c.this.wN(4);
          b.bDy().bDz().stop();
        }
        AppMethodBeat.o(21303);
      }
      
      public final void wO(int paramAnonymousInt)
      {
        AppMethodBeat.i(21302);
        int i = b.bDy().bCP().mSk;
        if (paramAnonymousInt == 1)
        {
          if (i == 23)
          {
            ac.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
            b.bDy().bCP().mSk = 4;
            c.this.wJ(4);
            c.this.wN(8);
            AppMethodBeat.o(21302);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ac.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
          b.bDy().bCP().mSk = 23;
          c.this.wJ(23);
          c.this.wN(9);
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
    localy.ndM = paramString;
    localy.ndN = paramInt1;
    localy.ndP = paramInt2;
    localy.ndQ = paramInt3;
    localy.ndj = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21323);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21323);
    }
  }
  
  public static boolean bDD()
  {
    AppMethodBeat.i(21316);
    boolean bool = az.ayM().axg().eYZ();
    AppMethodBeat.o(21316);
    return bool;
  }
  
  private void bDF()
  {
    AppMethodBeat.i(21320);
    String str1 = this.mUX;
    String str2 = this.mUY;
    String str3 = com.tencent.mm.plugin.backup.b.g.eh(ai.getContext());
    ac.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(gLY) });
    if ((str3 == null) || (str3.equals("")))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.f(11787, new Object[] { Integer.valueOf(1) });
      b.bDy().bCP().mSk = -1;
      wJ(-1);
      AppMethodBeat.o(21320);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.f(11787, new Object[] { Integer.valueOf(2) });
      b.bDy().bCP().mSk = -2;
      wJ(-2);
      AppMethodBeat.o(21320);
      return;
    }
    if (!com.tencent.mm.plugin.backup.b.g.Su(str2))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 3L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.f(11787, new Object[] { Integer.valueOf(3) });
      b.bDy().bCP().mSk = -3;
      wJ(-3);
      AppMethodBeat.o(21320);
      return;
    }
    if (gLY <= 0)
    {
      b.bDy().bCP().mSk = -5;
      wJ(-5);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 4L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.f(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(21320);
      return;
    }
    gLY -= 1;
    ch(this.mUY, this.mUZ);
    AppMethodBeat.o(21320);
  }
  
  public static String bDH()
  {
    AppMethodBeat.i(21327);
    String str = com.tencent.mm.plugin.backup.g.b.bEw();
    AppMethodBeat.o(21327);
    return str;
  }
  
  private static void bDI()
  {
    AppMethodBeat.i(21328);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bDy().mSc;
    try
    {
      ac.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21328);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21328);
    }
  }
  
  private void ch(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(21319);
    b.bDy().bDz().connect(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.mVc);
    for (;;)
    {
      try
      {
        if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.mUT = bool;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.bDy().mSd, b.bDy().mSe, com.tencent.mm.plugin.backup.b.d.bCT(), b.bDy().mSc, com.tencent.mm.plugin.backup.b.c.mRU, 22);
      paramString.B(this.mUT, false);
      paramString.bEA();
      ac.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.mVa == null) {
        this.mVa = new au(new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(21306);
            if (!c.aKG)
            {
              ac.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
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
      this.mVa.au(3000L, 3000L);
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
      ac.i("MicroMsg.BackupMoveRecoverServer", "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break label380;
      }
      paramInt1 = b.bDy().bCP().mSk;
      ac.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(paramInt1) });
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
      b.bDy().bDz().stop();
      if (!aKG)
      {
        if (this.mVa != null)
        {
          ac.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.mVa.stopTimer();
        }
        bDF();
        AppMethodBeat.o(21321);
        return;
      }
      b.bDy().bCP().mSk = -4;
      wJ(-4);
      AppMethodBeat.o(21321);
      return;
      b.bDy().bDz().stop();
      AppMethodBeat.o(21321);
      return;
      b(true, false, -4);
      b.bDy().bDz().stop();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 43L, 1L, false);
      wN(4);
      l = 0L;
      if (this.mUM != 0L) {
        l = bs.Ap(this.mUM);
      }
      ac.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.mSs), Long.valueOf(this.recvSize), Long.valueOf(l) });
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
        ac.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bs.cw(paramArrayOfByte)) });
        AppMethodBeat.o(21321);
        return;
      }
      ac.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.mYY) });
      paramArrayOfByte = new f();
      paramArrayOfByte.mYY = locale.mYY;
      try
      {
        ac.d("MicroMsg.BackupMoveRecoverServer", "onNotify send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.t(paramArrayOfByte.toByteArray(), 10, paramInt2);
        AppMethodBeat.o(21321);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ac.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramArrayOfByte, "onNotify buf to BackupHeartBeatResponse err.", new Object[0]);
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 10)
    {
      paramArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.mYY;; l = -1L)
      {
        ac.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 51L, 1L, false);
      b(true, false, -100);
    }
    az.agU().az(new Runnable()
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
    ac.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), as.eVo() });
    if (!paramBoolean1) {
      bDI();
    }
    synchronized (this.lock)
    {
      this.gRx = true;
      if ((this.mUC != null) && (this.mUC.mTI))
      {
        this.mUC.x(paramBoolean2, paramInt);
        this.mUC = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bDy().bCP().mSk = paramInt;
          wJ(paramInt);
        }
        if (paramBoolean2) {
          bDE();
        }
        com.tencent.mm.plugin.backup.g.b.bEt();
        com.tencent.mm.plugin.backup.g.b.bEv();
        b.bDy().bCR();
        b.bDy().bDz().mSK = null;
        AppMethodBeat.o(21318);
        return;
      }
      i = 1;
    }
  }
  
  public final void bCO()
  {
    AppMethodBeat.i(21330);
    long l1 = bs.Ap(this.mUN) / 1000L;
    long l2 = b.bDy().bCP().mSw;
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 49L, 1L, false);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 50L, l1, false);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 72L, l2, false);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 52L, this.recvSize / 1024L, false);
    this.mUD = com.tencent.mm.vfs.i.aSp(com.tencent.mm.kernel.g.agR().agy());
    com.tencent.mm.plugin.report.service.h.wUl.f(17868, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.mUE / 1024L), Long.valueOf(this.mUF / 1024L), Long.valueOf(this.mSu / 1024L), Long.valueOf(this.mUD / 1024L), Long.valueOf(this.mSv), Long.valueOf(l2) });
    ac.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.mUE / 1024L), Long.valueOf(this.mUF / 1024L), Long.valueOf(this.mSu / 1024L), Long.valueOf(this.mUD / 1024L), Long.valueOf(this.mSv), Long.valueOf(l2) });
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GKQ, Boolean.TRUE);
    ac.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    if (com.tencent.mm.plugin.backup.b.g.mSE)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      StringBuilder localStringBuilder = new StringBuilder("\nMerge Info:\n");
      localStringBuilder.append("mergeStartTime:").append(((SimpleDateFormat)localObject).format(new Date(this.mUN))).append("\n");
      localStringBuilder.append("mergeTime:").append(l1).append("\n");
      localStringBuilder.append("totalMsgCount:").append(l2).append("\n");
      localStringBuilder.append("recvSize:").append(this.recvSize / 1024L).append(" kB\n");
      com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.bDe(), "backupTestInfo.txt", localStringBuilder.toString().getBytes());
    }
    if (!this.mTT)
    {
      localObject = az.ayM().axf().eZb();
      if (((LinkedList)localObject).size() > 0) {
        break label583;
      }
      ac.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      bDE();
      com.tencent.mm.plugin.backup.g.b.wX(22);
      com.tencent.mm.plugin.backup.g.b.bEt();
      com.tencent.mm.plugin.backup.g.b.bEv();
      AppMethodBeat.o(21330);
      return;
      label583:
      ac.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      az.ayM().axe().j(this.cIZ, (LinkedList)localObject);
    }
  }
  
  public final void bDE()
  {
    AppMethodBeat.i(21317);
    ac.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.mUL.clear();
    if (!com.tencent.mm.plugin.backup.b.g.mSE)
    {
      com.tencent.mm.plugin.backup.b.g.Sq(com.tencent.mm.plugin.backup.b.g.bDc());
      com.tencent.mm.plugin.backup.b.g.bDa();
    }
    AppMethodBeat.o(21317);
  }
  
  public final void bDG()
  {
    AppMethodBeat.i(21325);
    b(true, false, 28);
    b.bDy().bDz().stop();
    AppMethodBeat.o(21325);
  }
  
  public final void ir(boolean paramBoolean)
  {
    AppMethodBeat.i(21326);
    synchronized (this.lock)
    {
      if ((this.mUC != null) && (this.mUC.mTI))
      {
        ac.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21326);
        return;
      }
      if (this.mUC != null) {
        this.mUC.x(false, 0);
      }
      if ((this.mUL == null) || (this.mUL.size() <= 0))
      {
        i = az.ayM().axg().eZa();
        b.bDy().bCP().mSk = 26;
        b.bDy().bCP().mSn = 0;
        wJ(26);
        com.tencent.mm.plugin.backup.h.d.bEP().bES();
        this.mUN = bs.eWj();
        this.mUC = new com.tencent.mm.plugin.backup.c.d(b.bDy(), 2, this, i, false, new LinkedList(), new LinkedList());
        this.mUC.ir(paramBoolean);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(21326);
        return;
      }
      int i = this.mUL.size();
    }
  }
  
  public final void is(boolean paramBoolean)
  {
    AppMethodBeat.i(21322);
    this.mUV = paramBoolean;
    Object localObject = new LinkedBlockingQueue();
    b.bDy().bDz().mSK = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21310);
        for (;;)
        {
          if (!c.m(c.this)) {}
          try
          {
            boolean bool = this.mVk.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              ac.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.mVk.size()) });
              AppMethodBeat.o(21310);
              return;
            }
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
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
          if ((!c.m(c.this)) && (!c.bhx())) {
            try
            {
              c.a locala = (c.a)this.mVk.poll(500L, TimeUnit.MILLISECONDS);
              ac.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.mVk.size()), locala });
              if (locala != null) {
                c.this.a(locala.dqZ, locala.type, locala.buf, locala.hTM);
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
    if ((!this.mTT) && (!paramBoolean))
    {
      localObject = this.mUI;
      LinkedList localLinkedList = this.mUJ;
      this.mUI = new LinkedList();
      this.mUJ = new LinkedList();
      az.ayM().axe().a(this.cIZ, (LinkedList)localObject, localLinkedList, this.mUI, this.mUJ);
    }
    localObject = new j();
    ((j)localObject).ncN = this.mUI;
    ((j)localObject).ncO = this.mUJ;
    try
    {
      ac.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(((j)localObject).ncN.size()), Integer.valueOf(((j)localObject).ncO.size()) });
      com.tencent.mm.plugin.backup.g.b.t(((j)localObject).toByteArray(), 12, this.mVf);
      com.tencent.mm.plugin.backup.g.b.bEu();
      if (this.mUU)
      {
        b.bDy().bCP().P(23, 1, this.mUG.size());
        this.mSs = b.bDy().bCP().mSs;
        this.recvSize = b.bDy().bCP().mSp;
        this.mUE = b.bDy().bCP().mSq;
        this.mUF = b.bDy().bCP().mSr;
        this.mSu = b.bDy().bCP().mSu;
        this.mSv = b.bDy().bCP().mSv;
        com.tencent.mm.plugin.backup.h.d.bEP().bES();
        this.mSv = -1L;
        com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "getMsgCount";
          }
          
          public final void run()
          {
            AppMethodBeat.i(21312);
            c.c(c.this, com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().dcH());
            b.bDy().bCP().mSv = c.n(c.this);
            AppMethodBeat.o(21312);
          }
        });
        wJ(23);
        AppMethodBeat.o(21322);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupRequestSessionResponse err.", new Object[0]);
        continue;
        b.bDy().bCP().a(23, 1, this.mUG.size(), 0L, this.mSs, 0L, 0L);
        this.mSu = com.tencent.mm.vfs.i.aSp(com.tencent.mm.kernel.g.agR().agy());
        b.bDy().bCP().mSu = this.mSu;
      }
    }
  }
  
  public final void wJ(final int paramInt)
  {
    AppMethodBeat.i(21329);
    if (this.mTO != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21304);
          if (c.o(c.this) != null) {
            c.o(c.this).wJ(paramInt);
          }
          AppMethodBeat.o(21304);
        }
      });
    }
    if (this.mUK != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21305);
          if (c.p(c.this) != null) {
            c.p(c.this).wI(paramInt);
          }
          AppMethodBeat.o(21305);
        }
      });
    }
    AppMethodBeat.o(21329);
  }
  
  public final void wN(int paramInt)
  {
    AppMethodBeat.i(21324);
    long l = 0L;
    if (this.mUM != 0L) {
      l = bs.Ap(this.mUM);
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.mUW), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.mSu / 1024L) });
    ac.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.mSs / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.mSu / 1024L) });
    AppMethodBeat.o(21324);
  }
  
  final class a
  {
    byte[] buf;
    boolean dqZ;
    int hTM;
    int type;
    
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(21314);
      this.dqZ = false;
      this.hTM = paramInt1;
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