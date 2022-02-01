package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class c
{
  private static boolean aMp = false;
  private static int ibG = 2;
  private MTimerHandler oLR;
  final i oLS;
  private final i oLT;
  b.c oLX;
  private final j.a oLY;
  public int oOk;
  public String oOl;
  String oOm;
  int oOn;
  boolean oOo;
  private com.tencent.mm.bw.b oOp;
  public int oOq;
  public boolean oOr;
  private final b.d oOs;
  public final h.a oOt;
  
  public c()
  {
    AppMethodBeat.i(21569);
    this.oOk = 0;
    this.oOr = true;
    this.oLS = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21558);
        bg.azz().b(595, c.a(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          h.CyF.idkeyStat(400L, 111L, 1L, false);
          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -2011)) {
            Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
          }
          b.cga().ceM().oJc = -5;
          b.cga().cgc().xI(-5);
          AppMethodBeat.o(21558);
          return;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.backup.g.e)paramAnonymousq).cgI();
        bg.aVF();
        if (!Util.nullAsNil((String)com.tencent.mm.model.c.azQ().get(2, null)).equals(paramAnonymousString.KMF))
        {
          Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
          b.cga().ceM().oJc = -5;
          b.cga().cgc().xI(-5);
          h.CyF.idkeyStat(400L, 112L, 1L, false);
          AppMethodBeat.o(21558);
          return;
        }
        if ((paramAnonymousString.KMD == null) || (paramAnonymousString.KMD.size() <= 0) || (paramAnonymousString.KMD.getFirst() == null))
        {
          paramAnonymousInt1 = paramAnonymousString.KMC;
          if (paramAnonymousString.KMD == null) {}
          for (paramAnonymousString = "null";; paramAnonymousString = paramAnonymousString.KMD.size())
          {
            Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
            b.cga().ceM().oJc = -5;
            b.cga().cgc().xI(-5);
            h.CyF.idkeyStat(400L, 113L, 1L, false);
            AppMethodBeat.o(21558);
            return;
          }
        }
        Object localObject = (adi)paramAnonymousString.KMD.getFirst();
        paramAnonymousq = ((adi)localObject).LjZ;
        paramAnonymousInt1 = ((Integer)((adi)localObject).Low.getFirst()).intValue();
        localObject = c.this;
        ((c)localObject).oOl = paramAnonymousString.KMG;
        ((c)localObject).oOm = paramAnonymousq;
        ((c)localObject).oOn = paramAnonymousInt1;
        Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramAnonymousString.oUv), Integer.valueOf(paramAnonymousString.Scene), paramAnonymousString.KMG, paramAnonymousq, Integer.valueOf(paramAnonymousInt1) });
        b.cga().oIU = paramAnonymousString.ID;
        b.cga().oIV = paramAnonymousString.KML;
        b.cga().oIW = paramAnonymousString.KMM;
        b.cga().oJa = paramAnonymousString.KLU.getBufferToBytes();
        c.b(c.this);
        AppMethodBeat.o(21558);
      }
    };
    this.oLT = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21560);
        c.bXt();
        h.CyF.a(13736, new Object[] { Integer.valueOf(0), c.e(c.this), g.eE(MMApplicationContext.getContext()), Integer.valueOf(0), Integer.valueOf(b.cga().cgb().oOq) });
        com.tencent.mm.plugin.backup.g.b.b(1, c.f(c.this));
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          switch (paramAnonymousInt2)
          {
          case -2: 
          default: 
            h.CyF.idkeyStat(400L, 116L, 1L, false);
          }
          for (;;)
          {
            h.CyF.a(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(c.this)) });
            b.cga().ceM().oJc = -5;
            b.cga().cgc().xI(-5);
            AppMethodBeat.o(21560);
            return;
            h.CyF.idkeyStat(400L, 114L, 1L, false);
            continue;
            h.CyF.idkeyStat(400L, 115L, 1L, false);
          }
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.g.a)paramAnonymousq;
        boolean bool1;
        boolean bool2;
        label319:
        boolean bool3;
        if ((paramAnonymousString.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIR) == 0)
        {
          bool1 = false;
          if ((paramAnonymousString.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIS) != 0) {
            break label436;
          }
          bool2 = false;
          if ((paramAnonymousString.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIT) != 0) {
            break label442;
          }
          bool3 = false;
          label336:
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (!bool3) {
            break label466;
          }
          if (paramAnonymousString.oPi.oUy != null) {
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
          b.cga().cgc().oOF = bool1;
          b.cga().cgc().oOG = bool2;
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
          paramAnonymousString = paramAnonymousString.oPi.oUy;
          break label388;
          label459:
          Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
          label466:
          c.this.a(false, null);
        }
      }
    };
    this.oOs = new b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21561);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (paramAnonymousArrayOfByte == null)) {
            break label251;
          }
          if (10011 == paramAnonymousInt1)
          {
            paramAnonymousInt1 = b.cga().ceM().oJc;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
          if (!c.aMp)
          {
            if (c.c(c.this) != null)
            {
              Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
              c.c(c.this).stopTimer();
            }
            c.d(c.this);
            AppMethodBeat.o(21561);
            return;
          }
          b.cga().cfw().stop();
          b.cga().ceM().oJc = -4;
          b.cga().cgc().xI(-4);
          AppMethodBeat.o(21561);
          return;
          b.cga().cfw().stop();
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
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.oTl) });
            i = localb.oTl;
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramAnonymousArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
            continue;
            bg.aVF();
            if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NZC, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            b.cga();
            paramAnonymousArrayOfByte = b.ceR().getString("BACKUP_PC_CHOOSE_SESSION", null);
            if (paramAnonymousArrayOfByte != null) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
            c.a(c.this, 5, paramAnonymousInt2);
            continue;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
            h.CyF.idkeyStat(400L, 29L, 1L, false);
            c.this.oOk = 3;
            paramAnonymousArrayOfByte = new LinkedList(Arrays.asList(g.eQ(paramAnonymousArrayOfByte, ",")));
            b.cga().cgc().init();
            b.cga().cgc().G(paramAnonymousArrayOfByte);
            c.eS(5, paramAnonymousInt2);
            b.cga().cgc().ceK();
            c.this.Bj(6);
            paramAnonymousArrayOfByte = b.cga().cgc();
            com.tencent.mm.plugin.backup.h.d.cgP().cgS();
            paramAnonymousArrayOfByte.Bv(paramAnonymousArrayOfByte.oMc.size());
            continue;
            c.b(c.this, 3, paramAnonymousInt2);
            continue;
            bg.aVF();
            if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NZD, Boolean.FALSE)).booleanValue()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            b.cga().cgd();
            if (d.cfA()) {
              continue;
            }
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
            c.b(c.this, 7, paramAnonymousInt2);
            continue;
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
            h.CyF.idkeyStat(400L, 30L, 1L, false);
            c.this.oOk = 4;
            b.cga().cgd().init();
            c.eS(7, paramAnonymousInt2);
            b.cga().cgc().ceK();
            c.this.Bj(8);
            continue;
            AppMethodBeat.o(21561);
          }
          if (paramAnonymousInt1 != 5) {
            continue;
          }
          Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
          h.CyF.a(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.cga().cgb().oOq) });
          b.cga().ceM().oJc = -100;
          b.cga().cgc().xI(-100);
          AppMethodBeat.o(21561);
          return;
          c.a(c.this, 1, paramAnonymousInt2);
        }
      }
    };
    this.oLY = new j.a()
    {
      public final void Bf(int paramAnonymousInt)
      {
        AppMethodBeat.i(21564);
        int i = b.cga().ceM().oJc;
        if (paramAnonymousInt == 1)
        {
          if (((1 == c.h(c.this)) || (3 == c.h(c.this))) && (i == 14))
          {
            Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.cga().ceM().oJc = 4;
            b.cga().cgc().xI(4);
            AppMethodBeat.o(21564);
            return;
          }
          if (((2 == c.h(c.this)) || (4 == c.h(c.this))) && (i == 23))
          {
            Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
            b.cga().ceM().oJc = 4;
            b.cga().cgd().Ba(4);
            AppMethodBeat.o(21564);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
          if ((1 == c.h(c.this)) || (3 == c.h(c.this)))
          {
            b.cga().ceM().oJc = 14;
            b.cga().cgc().xI(14);
            AppMethodBeat.o(21564);
            return;
          }
          if ((2 == c.h(c.this)) || (4 == c.h(c.this)))
          {
            b.cga().ceM().oJc = 23;
            b.cga().cgd().Ba(23);
          }
        }
        AppMethodBeat.o(21564);
      }
      
      public final void cfI()
      {
        AppMethodBeat.i(21563);
        int i = b.cga().cgb().oOk;
        if ((1 == i) || (3 == i))
        {
          b.cga().cgc().xI(b.cga().ceM().oJc);
          AppMethodBeat.o(21563);
          return;
        }
        if ((2 == i) || (4 == i)) {
          b.cga().cgd().Ba(b.cga().ceM().oJc);
        }
        AppMethodBeat.o(21563);
      }
      
      public final void cfJ()
      {
        AppMethodBeat.i(21565);
        int i = b.cga().ceM().oJc;
        Log.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        int j = b.cga().cgb().oOk;
        if (((1 == j) || (3 == j)) && ((i == 14) || (i == 4)))
        {
          b.cga().cfw().stop();
          b.cga().cgc().cancel(true);
          h.CyF.idkeyStat(400L, 9L, 1L, false);
          b.cga().cgc().Bk(18);
          b.cga().ceM().oJc = -4;
          b.cga().cgc().xI(-4);
          AppMethodBeat.o(21565);
          return;
        }
        if (((2 == j) || (4 == j)) && ((i == 23) || (i == 4)))
        {
          b.cga().cfw().stop();
          b.cga().cgd().a(true, false, -4);
          h.CyF.idkeyStat(400L, 17L, 1L, false);
          b.cga().cgd().Bk(18);
        }
        AppMethodBeat.o(21565);
      }
    };
    this.oOt = new h.a()
    {
      public final void cgh()
      {
        AppMethodBeat.i(21566);
        Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        int i;
        if (b.cga().ceM().oJc != 5)
        {
          b.cga().ceM().oJc = 5;
          i = b.cga().cgb().oOk;
          if ((1 != i) && (3 != i)) {
            break label82;
          }
          b.cga().cgc().xI(5);
        }
        for (;;)
        {
          c.this.Bj(9);
          AppMethodBeat.o(21566);
          return;
          label82:
          if ((2 == i) || (4 == i)) {
            b.cga().cgd().Ba(5);
          }
        }
      }
      
      public final void cgi()
      {
        AppMethodBeat.i(21567);
        int i = c.this.oOk;
        Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        if ((1 == i) || (3 == i))
        {
          b.cga().cgc();
          e.cgl();
          b.cga().cgc().cancel(true);
          b.cga().cfw().stop();
          b.cga().ceM().oJc = -4;
          b.cga().cgc().xI(-4);
          h.CyF.idkeyStat(400L, 9L, 1L, false);
          b.cga().cgc().Bk(3);
          AppMethodBeat.o(21567);
          return;
        }
        if ((2 == i) || (4 == i))
        {
          b.cga().cgd();
          d.cgj();
          b.cga().cgd().a(true, false, -4);
          b.cga().cfw().stop();
          h.CyF.idkeyStat(400L, 17L, 1L, false);
          b.cga().cgd().Bk(3);
        }
        AppMethodBeat.o(21567);
      }
    };
    this.oLX = new b.c()
    {
      public final void cfK()
      {
        AppMethodBeat.i(21568);
        Log.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
        com.tencent.mm.plugin.backup.g.b.cgt();
        b.cga().ceO();
        AppMethodBeat.o(21568);
      }
    };
    AppMethodBeat.o(21569);
  }
  
  public static void cfF()
  {
    AppMethodBeat.i(21574);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.cga().oIU;
    try
    {
      com.tencent.mm.plugin.backup.g.b.N(locala.toByteArray(), 5);
      AppMethodBeat.o(21574);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21574);
    }
  }
  
  private void cgf()
  {
    AppMethodBeat.i(21570);
    b.cga().cfw().connect(this.oOm, this.oOn);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.oLT);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.cga().oIV, b.cga().oIW, com.tencent.mm.plugin.backup.b.d.ceQ(), b.cga().oIU, 0, 1, false);
    locala.A(true, true);
    locala.oPh.oUx = 1;
    locala.cgA();
    Log.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.oLR == null) {
      this.oLR = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21559);
          if (!c.aMp)
          {
            Log.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
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
    this.oLR.startTimer(3000L);
    AppMethodBeat.o(21570);
  }
  
  public static String cgg()
  {
    AppMethodBeat.i(21571);
    String str = com.tencent.mm.plugin.backup.g.b.cgw();
    AppMethodBeat.o(21571);
    return str;
  }
  
  public static void eS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21573);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.oTl = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.D(localc.toByteArray(), 18, paramInt2);
      AppMethodBeat.o(21573);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
      AppMethodBeat.o(21573);
    }
  }
  
  public final void Bj(int paramInt)
  {
    AppMethodBeat.i(21572);
    Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.oTl = paramInt;
    if (paramInt == 9) {
      localb.oTm = this.oOp;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.N(localb.toByteArray(), 17);
      AppMethodBeat.o(21572);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21572);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.bw.b paramb)
  {
    this.oOo = paramBoolean;
    this.oOp = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */