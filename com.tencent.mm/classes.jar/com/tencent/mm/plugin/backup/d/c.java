package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c
  implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.g.b.d
{
  private static boolean aMp = false;
  private static int ibG = 0;
  private static boolean oLE = false;
  String dGL;
  private boolean ifz;
  private Object lock;
  private long oJj;
  private long oJl;
  private long oJm;
  public com.tencent.mm.plugin.backup.b.b.d oKF;
  private boolean oKK;
  public b.a oLA;
  private HashSet<String> oLB;
  private long oLC;
  private long oLD;
  private boolean oLF;
  private int oLG;
  public boolean oLH;
  private boolean oLI;
  private boolean oLJ;
  private boolean oLK;
  private boolean oLL;
  private int oLM;
  private int oLN;
  public String oLO;
  String oLP;
  int oLQ;
  private MTimerHandler oLR;
  final com.tencent.mm.ak.i oLS;
  private final com.tencent.mm.ak.i oLT;
  private final com.tencent.mm.ak.i oLU;
  public long oLV;
  private int oLW;
  b.c oLX;
  private final j.a oLY;
  private com.tencent.mm.plugin.backup.c.d oLs;
  private long oLt;
  private long oLu;
  private long oLv;
  private LinkedList<String> oLw;
  private LinkedList<Long> oLx;
  private LinkedList<String> oLy;
  private LinkedList<Long> oLz;
  private long recvSize;
  
  public c()
  {
    AppMethodBeat.i(21315);
    this.oJl = 0L;
    this.oJm = -1L;
    this.oLt = 0L;
    this.oJj = 0L;
    this.recvSize = 0L;
    this.oLu = 0L;
    this.oLv = 0L;
    this.lock = new Object();
    this.ifz = false;
    this.oLw = new LinkedList();
    this.oLB = new HashSet();
    this.oLC = 0L;
    this.oLD = 0L;
    this.oLF = true;
    this.oLG = 0;
    this.oLH = false;
    this.oLI = true;
    this.oLJ = true;
    this.oKK = false;
    this.oLK = false;
    this.oLL = false;
    this.oLM = 0;
    this.oLS = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21300);
        bg.azz().b(595, c.a(c.this));
        com.tencent.mm.plugin.backup.b.d.Bb(22);
        b.cfv().ceM().oJc = 1;
        Object localObject2 = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
        ((Intent)localObject2).addFlags(335544320);
        ((Intent)localObject2).putExtra("nofification_type", "backup_move_notification");
        Object localObject1 = MMApplicationContext.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 41L, 1L, false);
        paramAnonymousq = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousq).cgI();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
          }
          bg.aVF();
          if (!Util.nullAsNil((String)com.tencent.mm.model.c.azQ().get(2, null)).equals(paramAnonymousq.KMF))
          {
            Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
            b.cfv().ceM().oJc = -14;
            c.this.Ba(-14);
            AppMethodBeat.o(21300);
            return;
          }
          b.cfv().ceM().oJc = -5;
          c.this.Ba(-5);
          AppMethodBeat.o(21300);
          return;
        }
        bg.aVF();
        if (!Util.nullAsNil((String)com.tencent.mm.model.c.azQ().get(2, null)).equals(paramAnonymousq.KMF))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
          b.cfv().ceM().oJc = -5;
          c.this.Ba(-14);
          AppMethodBeat.o(21300);
          return;
        }
        b.cfv().oIU = paramAnonymousq.ID;
        b.cfv().oIV = paramAnonymousq.KML;
        b.cfv().oIW = paramAnonymousq.KMM;
        com.tencent.mm.plugin.backup.g.b.a(c.this.oLX);
        b.cfv().ceN();
        com.tencent.mm.plugin.backup.g.b.a(b.cfv().cfy());
        com.tencent.mm.plugin.backup.g.b.a(b.cfv().cfw());
        com.tencent.mm.plugin.backup.g.b.Bb(2);
        com.tencent.mm.plugin.backup.g.b.a(c.b(c.this));
        paramAnonymousString = null;
        paramAnonymousInt1 = 0;
        if (paramAnonymousq.KMC > 0)
        {
          localObject1 = (adi)paramAnonymousq.KMD.getFirst();
          paramAnonymousString = ((adi)localObject1).LjZ;
          paramAnonymousInt1 = ((Integer)((adi)localObject1).Low.getFirst()).intValue();
        }
        for (;;)
        {
          localObject1 = c.this;
          ((c)localObject1).oLO = paramAnonymousq.KMG;
          ((c)localObject1).oLP = paramAnonymousString;
          ((c)localObject1).oLQ = paramAnonymousInt1;
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousq.oUv), Integer.valueOf(paramAnonymousq.Scene), paramAnonymousq.KMG, paramAnonymousString, Integer.valueOf(paramAnonymousInt1) });
          c.access$202(false);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramAnonymousString, paramAnonymousq.KMG, com.tencent.mm.plugin.backup.b.g.eE(MMApplicationContext.getContext()) });
          c.cfG();
          c.a(c.this, paramAnonymousString, paramAnonymousInt1);
          AppMethodBeat.o(21300);
          return;
          Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
        }
      }
    };
    this.oLT = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21307);
        c.access$202(true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 42L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.a(11787, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.e(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
          b.cfv().ceM().oJc = -5;
          c.this.Ba(-5);
          c.this.Be(3);
          AppMethodBeat.o(21307);
          return;
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousq;
        if (paramAnonymousString.oPi.Version < com.tencent.mm.plugin.backup.b.c.oIM)
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramAnonymousString.oPi.Version) });
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 104L, 1L, false);
          b.cfv().ceM().oJc = -12;
          c.this.Ba(-12);
          AppMethodBeat.o(21307);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.oPi.oUv;
        paramAnonymousq = c.this;
        boolean bool;
        if ((paramAnonymousString.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIQ) == 0)
        {
          bool = false;
          c.a(paramAnonymousq, bool);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramAnonymousString.oPi.Version), Integer.valueOf(paramAnonymousInt1), Boolean.valueOf(c.f(c.this)) });
          if (paramAnonymousInt1 != com.tencent.mm.plugin.backup.b.c.oIO) {
            break label433;
          }
          if (!c.cfA()) {
            break label398;
          }
          c.b(c.this, true);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
          c.a(c.this, 4);
        }
        for (;;)
        {
          c.g(c.this);
          com.tencent.mm.plugin.backup.g.b.a(3, c.h(c.this));
          paramAnonymousString = new com.tencent.mm.plugin.backup.g.k(b.cfv().oIU);
          paramAnonymousString.a(0L, com.tencent.mm.plugin.backup.b.g.Bu(0L), 0);
          paramAnonymousString.cgA();
          b.cfv().ceM().oJc = 22;
          c.this.Ba(22);
          AppMethodBeat.o(21307);
          return;
          bool = true;
          break;
          label398:
          c.this.cfB();
          c.b(c.this, false);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
          c.a(c.this, 2);
        }
        label433:
        if (c.cfA()) {
          c.a(c.this, 3);
        }
        for (;;)
        {
          c.this.cfB();
          c.b(c.this, false);
          Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
          break;
          c.a(c.this, 1);
        }
      }
    };
    this.oLU = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21308);
        com.tencent.mm.plugin.backup.g.b.b(3, c.h(c.this));
        Log.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          b.cfv().ceM().oJc = -5;
          c.this.Ba(-5);
          AppMethodBeat.o(21308);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.k)paramAnonymousq;
        paramAnonymousq = paramAnonymousString.oQp;
        if (!b.cfv().oIU.equals(paramAnonymousq.ID))
        {
          Log.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
          b.cfv().ceM().oJc = -5;
          c.this.Ba(-5);
          AppMethodBeat.o(21308);
          return;
        }
        b.cfv().ceM().oJk = paramAnonymousq.oTO;
        c.this.dGL = paramAnonymousString.oQp.oTR.oTH;
        label352:
        label377:
        long l;
        if (paramAnonymousString.oQp.oTR.oTK.toLowerCase().contains("ios"))
        {
          c.b(c.this, 1);
          c.a(c.this, paramAnonymousString.oQp.oTV);
          c.c(c.this, paramAnonymousString.oQp.oTX);
          Log.i("MicroMsg.BackupMoveRecoverServer", "move recover backupMoveDevice[%d], totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", new Object[] { Integer.valueOf(c.i(c.this)), Long.valueOf(paramAnonymousString.oQp.oTU), Long.valueOf(paramAnonymousString.oQp.oTV / 1024L) });
          if ((c.j(c.this)) && (c.f(c.this)))
          {
            paramAnonymousq = com.tencent.mm.plugin.report.service.h.CyF;
            if ((!c.k(c.this)) && (c.l(c.this) != 1)) {
              break label614;
            }
            paramAnonymousInt1 = 66;
            paramAnonymousq.idkeyStat(485L, paramAnonymousInt1, 1L, false);
          }
          if (paramAnonymousString.oQp.oTT != 3) {
            break label620;
          }
          paramAnonymousInt1 = 1;
          if (paramAnonymousInt1 == 0) {
            break label625;
          }
          c.c(c.this, true);
          Log.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
          label397:
          paramAnonymousString = new PLong();
          paramAnonymousq = new PLong();
          bg.aVF();
          com.tencent.mm.plugin.backup.b.g.a(paramAnonymousString, paramAnonymousq, com.tencent.mm.model.c.getAccPath());
          l = c.m(c.this);
          if (c.m(c.this) * 0.1D <= 524288000.0D) {
            break label637;
          }
        }
        label614:
        label620:
        label625:
        label637:
        for (double d = 524288000.0D;; d = c.m(c.this) * 0.1D)
        {
          l = d + l;
          c.this.oLV = l;
          if (paramAnonymousq.value >= l) {
            break label654;
          }
          Log.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramAnonymousq.value), Long.valueOf(l), Long.valueOf(c.m(c.this)) });
          com.tencent.mm.plugin.report.service.h.CyF.a(11787, new Object[] { Integer.valueOf(5) });
          b.cfv().cfw().stop();
          b.cfv().ceM().oJc = -13;
          c.this.Ba(-13);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 5L, 1L, false);
          AppMethodBeat.o(21308);
          return;
          c.b(c.this, 2);
          break;
          paramAnonymousInt1 = 65;
          break label352;
          paramAnonymousInt1 = 0;
          break label377;
          c.c(c.this, false);
          break label397;
        }
        label654:
        c.b(c.this, Util.nowMilliSecond());
        com.tencent.mm.plugin.backup.g.b.cgs();
        AppMethodBeat.o(21308);
      }
    };
    this.oLX = new b.c()
    {
      public final void cfK()
      {
        AppMethodBeat.i(21313);
        Log.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.cgt();
        b.cfv().ceO();
        AppMethodBeat.o(21313);
      }
    };
    this.oLY = new j.a()
    {
      public final void Bf(int paramAnonymousInt)
      {
        AppMethodBeat.i(21302);
        int i = b.cfv().ceM().oJc;
        if (paramAnonymousInt == 1)
        {
          if (i == 23)
          {
            Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
            b.cfv().ceM().oJc = 4;
            c.this.Ba(4);
            c.this.Be(8);
            AppMethodBeat.o(21302);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
          b.cfv().ceM().oJc = 23;
          c.this.Ba(23);
          c.this.Be(9);
        }
        AppMethodBeat.o(21302);
      }
      
      public final void cfI()
      {
        AppMethodBeat.i(21301);
        c.this.Ba(b.cfv().ceM().oJc);
        AppMethodBeat.o(21301);
      }
      
      public final void cfJ()
      {
        AppMethodBeat.i(21303);
        int i = b.cfv().ceM().oJc;
        Log.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 23) || (i == 4))
        {
          c.this.a(true, false, -4);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 43L, 1L, false);
          c.this.Be(4);
          b.cfv().cfw().stop();
        }
        AppMethodBeat.o(21303);
      }
    };
    AppMethodBeat.o(21315);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(21323);
    y localy = new y();
    localy.oUz = paramString;
    localy.oUA = paramInt1;
    localy.oUC = paramInt2;
    localy.oUD = paramInt3;
    localy.oTW = paramInt4;
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
  
  public static boolean cfA()
  {
    AppMethodBeat.i(21316);
    boolean bool = bg.aVF().aTt().gzD();
    AppMethodBeat.o(21316);
    return bool;
  }
  
  private void cfC()
  {
    AppMethodBeat.i(21320);
    String str1 = this.oLO;
    String str2 = this.oLP;
    String str3 = com.tencent.mm.plugin.backup.b.g.eE(MMApplicationContext.getContext());
    Log.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(ibG) });
    if ((str3 == null) || (str3.equals("")))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.a(11787, new Object[] { Integer.valueOf(1) });
      b.cfv().ceM().oJc = -1;
      Ba(-1);
      AppMethodBeat.o(21320);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.a(11787, new Object[] { Integer.valueOf(2) });
      b.cfv().ceM().oJc = -2;
      Ba(-2);
      AppMethodBeat.o(21320);
      return;
    }
    if (!com.tencent.mm.plugin.backup.b.g.agA(str2))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 3L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.a(11787, new Object[] { Integer.valueOf(3) });
      b.cfv().ceM().oJc = -3;
      Ba(-3);
      AppMethodBeat.o(21320);
      return;
    }
    if (ibG <= 0)
    {
      b.cfv().ceM().oJc = -5;
      Ba(-5);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 4L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.a(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(21320);
      return;
    }
    ibG -= 1;
    cw(this.oLP, this.oLQ);
    AppMethodBeat.o(21320);
  }
  
  public static String cfE()
  {
    AppMethodBeat.i(21327);
    String str = com.tencent.mm.plugin.backup.g.b.cgw();
    AppMethodBeat.o(21327);
    return str;
  }
  
  private static void cfF()
  {
    AppMethodBeat.i(21328);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.cfv().oIU;
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
  
  private void cw(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(21319);
    b.cfv().cfw().connect(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.oLT);
    for (;;)
    {
      try
      {
        if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.oLJ = bool;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.cfv().oIV, b.cfv().oIW, com.tencent.mm.plugin.backup.b.d.ceQ(), b.cfv().oIU, com.tencent.mm.plugin.backup.b.c.oIM, 22, cfA());
      paramString.A(this.oLJ, false);
      paramString.cgA();
      Log.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.oLR == null) {
        this.oLR = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(21306);
            if (!c.aMp)
            {
              Log.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
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
      this.oLR.startTimer(3000L);
      AppMethodBeat.o(21319);
      return;
      bool = false;
    }
  }
  
  public final void Ba(final int paramInt)
  {
    AppMethodBeat.i(21329);
    if (this.oKF != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21304);
          if (c.p(c.this) != null) {
            c.p(c.this).Ba(paramInt);
          }
          AppMethodBeat.o(21304);
        }
      });
    }
    if (this.oLA != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21305);
          if (c.q(c.this) != null) {
            c.q(c.this).AZ(paramInt);
          }
          AppMethodBeat.o(21305);
        }
      });
    }
    AppMethodBeat.o(21329);
  }
  
  public final void Be(int paramInt)
  {
    AppMethodBeat.i(21324);
    long l = 0L;
    if (this.oLC != 0L) {
      l = Util.milliSecondsToNow(this.oLC);
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.oLN), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.oJl / 1024L), Integer.valueOf(this.oLM) });
    Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.oJj / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.oJl / 1024L) });
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
      paramInt1 = b.cfv().ceM().oJc;
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
      b.cfv().cfw().stop();
      if (!aMp)
      {
        if (this.oLR != null)
        {
          Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.oLR.stopTimer();
        }
        cfC();
        AppMethodBeat.o(21321);
        return;
      }
      b.cfv().ceM().oJc = -4;
      Ba(-4);
      AppMethodBeat.o(21321);
      return;
      b.cfv().cfw().stop();
      AppMethodBeat.o(21321);
      return;
      a(true, false, -4);
      b.cfv().cfw().stop();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 43L, 1L, false);
      Be(4);
      l = 0L;
      if (this.oLC != 0L) {
        l = Util.milliSecondsToNow(this.oLC);
      }
      Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.oJj), Long.valueOf(this.recvSize), Long.valueOf(l) });
      AppMethodBeat.o(21321);
      return;
      a(true, false, 0);
    }
    label380:
    if (paramInt1 == 9)
    {
      com.tencent.mm.plugin.backup.i.e locale = (com.tencent.mm.plugin.backup.i.e)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.e(), paramArrayOfByte);
      if (locale == null)
      {
        Log.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(Util.getLength(paramArrayOfByte)) });
        AppMethodBeat.o(21321);
        return;
      }
      Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.oPN) });
      paramArrayOfByte = new com.tencent.mm.plugin.backup.i.f();
      paramArrayOfByte.oPN = locale.oPN;
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
      paramArrayOfByte = (com.tencent.mm.plugin.backup.i.f)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.oPN;; l = -1L)
      {
        Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(21321);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 51L, 1L, false);
      a(true, false, -100);
    }
    bg.aAk().postToWorker(new Runnable()
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
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21318);
    Log.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), MMStack.getCaller() });
    if (!paramBoolean1) {
      cfF();
    }
    synchronized (this.lock)
    {
      this.ifz = true;
      if ((this.oLs != null) && (this.oLs.oKz))
      {
        this.oLs.x(paramBoolean2, paramInt);
        this.oLs = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.cfv().ceM().oJc = paramInt;
          Ba(paramInt);
        }
        if (paramBoolean2) {
          cfB();
        }
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        b.cfv().ceO();
        b.cfv().cfw().oJB = null;
        AppMethodBeat.o(21318);
        return;
      }
      i = 1;
    }
  }
  
  public final void ceL()
  {
    AppMethodBeat.i(21330);
    long l1 = Util.milliSecondsToNow(this.oLD) / 1000L;
    long l2 = b.cfv().ceM().oJn;
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 49L, 1L, false);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 50L, l1, false);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 72L, l2, false);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 52L, this.recvSize / 1024L, false);
    this.oLt = s.boW(com.tencent.mm.kernel.g.aAh().azO());
    com.tencent.mm.plugin.report.service.h.CyF.a(17868, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.oLu / 1024L), Long.valueOf(this.oLv / 1024L), Long.valueOf(this.oJl / 1024L), Long.valueOf(this.oLt / 1024L), Long.valueOf(this.oJm), Long.valueOf(l2) });
    Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(this.recvSize / 1024L), Long.valueOf(this.oLu / 1024L), Long.valueOf(this.oLv / 1024L), Long.valueOf(this.oJl / 1024L), Long.valueOf(this.oLt / 1024L), Long.valueOf(this.oJm), Long.valueOf(l2) });
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NZI, Boolean.TRUE);
    Log.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    if (com.tencent.mm.plugin.backup.b.g.oJv)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      StringBuilder localStringBuilder = new StringBuilder("\nMerge Info:\n");
      localStringBuilder.append("mergeStartTime:").append(((SimpleDateFormat)localObject).format(new Date(this.oLD))).append("\n");
      localStringBuilder.append("mergeTime:").append(l1).append("\n");
      localStringBuilder.append("totalMsgCount:").append(l2).append("\n");
      localStringBuilder.append("recvSize:").append(this.recvSize / 1024L).append(" kB\n");
      com.tencent.mm.plugin.backup.b.g.a(com.tencent.mm.plugin.backup.b.g.cfb(), "backupTestInfo.txt", localStringBuilder.toString().getBytes());
    }
    if (!this.oKK)
    {
      localObject = bg.aVF().aTs().gzF();
      if (((LinkedList)localObject).size() > 0) {
        break label583;
      }
      Log.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      cfB();
      com.tencent.mm.plugin.backup.g.b.Bn(22);
      com.tencent.mm.plugin.backup.g.b.cgt();
      com.tencent.mm.plugin.backup.g.b.cgv();
      AppMethodBeat.o(21330);
      return;
      label583:
      Log.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      bg.aVF().aTr().i(this.dGL, (LinkedList)localObject);
    }
  }
  
  public final void cfB()
  {
    AppMethodBeat.i(21317);
    Log.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.oLB.clear();
    if (!com.tencent.mm.plugin.backup.b.g.oJv)
    {
      com.tencent.mm.plugin.backup.b.g.agw(com.tencent.mm.plugin.backup.b.g.ceZ());
      com.tencent.mm.plugin.backup.b.g.ceX();
    }
    AppMethodBeat.o(21317);
  }
  
  public final void cfD()
  {
    AppMethodBeat.i(21325);
    a(true, false, 28);
    b.cfv().cfw().stop();
    AppMethodBeat.o(21325);
  }
  
  public final void jA(boolean paramBoolean)
  {
    AppMethodBeat.i(21322);
    this.oLL = paramBoolean;
    Object localObject = new LinkedBlockingQueue();
    b.cfv().cfw().oJB = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21310);
        for (;;)
        {
          if (!c.n(c.this)) {}
          try
          {
            boolean bool = this.oMb.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              Log.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.oMb.size()) });
              AppMethodBeat.o(21310);
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
    com.tencent.f.h.RTc.ba(new com.tencent.f.i.h()
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
          if ((!c.n(c.this)) && (!c.cfH())) {
            try
            {
              c.a locala = (c.a)this.oMb.poll(500L, TimeUnit.MILLISECONDS);
              Log.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.oMb.size()), locala });
              if (locala != null) {
                c.this.a(locala.dLQ, locala.type, locala.buf, locala.jlm);
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
    if ((!this.oKK) && (!paramBoolean))
    {
      localObject = this.oLy;
      LinkedList localLinkedList = this.oLz;
      this.oLy = new LinkedList();
      this.oLz = new LinkedList();
      bg.aVF().aTr().a(this.dGL, (LinkedList)localObject, localLinkedList, this.oLy, this.oLz);
    }
    localObject = new j();
    ((j)localObject).oTB = this.oLy;
    ((j)localObject).oTC = this.oLz;
    try
    {
      Log.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(((j)localObject).oTB.size()), Integer.valueOf(((j)localObject).oTC.size()) });
      com.tencent.mm.plugin.backup.g.b.D(((j)localObject).toByteArray(), 12, this.oLW);
      com.tencent.mm.plugin.backup.g.b.cgu();
      if (this.oLK)
      {
        b.cfv().ceM().S(23, 1, this.oLw.size());
        this.oJj = b.cfv().ceM().oJj;
        this.recvSize = b.cfv().ceM().oJg;
        this.oLu = b.cfv().ceM().oJh;
        this.oLv = b.cfv().ceM().oJi;
        this.oJl = b.cfv().ceM().oJl;
        this.oJm = b.cfv().ceM().oJm;
        com.tencent.mm.plugin.backup.h.d.cgP().cgS();
        this.oJm = -1L;
        com.tencent.f.h.RTc.ba(new com.tencent.f.i.h()
        {
          public final String getKey()
          {
            return "getMsgCount";
          }
          
          public final void run()
          {
            AppMethodBeat.i(21312);
            c.c(c.this, com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().eiP());
            b.cfv().ceM().oJm = c.o(c.this);
            AppMethodBeat.o(21312);
          }
        });
        Ba(23);
        AppMethodBeat.o(21322);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupRequestSessionResponse err.", new Object[0]);
        continue;
        b.cfv().ceM().a(23, 1, this.oLw.size(), 0L, this.oJj, 0L, 0L);
        this.oJl = s.boW(com.tencent.mm.kernel.g.aAh().azO());
        b.cfv().ceM().oJl = this.oJl;
      }
    }
  }
  
  public final void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(21326);
    synchronized (this.lock)
    {
      if ((this.oLs != null) && (this.oLs.oKz))
      {
        Log.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21326);
        return;
      }
      if (this.oLs != null) {
        this.oLs.x(false, 0);
      }
      if ((this.oLB == null) || (this.oLB.size() <= 0))
      {
        i = bg.aVF().aTt().gzE();
        b.cfv().ceM().oJc = 26;
        b.cfv().ceM().oJf = 0;
        Ba(26);
        com.tencent.mm.plugin.backup.h.d.cgP().cgS();
        this.oLD = Util.nowMilliSecond();
        this.oLs = new com.tencent.mm.plugin.backup.c.d(b.cfv(), 2, this, i, false, new LinkedList(), new LinkedList());
        this.oLs.jz(paramBoolean);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(21326);
        return;
      }
      int i = this.oLB.size();
    }
  }
  
  final class a
  {
    byte[] buf;
    boolean dLQ;
    int jlm;
    int type;
    
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(21314);
      this.dLQ = false;
      this.jlm = paramInt1;
      this.type = paramInt2;
      this.buf = ((byte[])paramArrayOfByte.clone());
      AppMethodBeat.o(21314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c
 * JD-Core Version:    0.7.0.1
 */