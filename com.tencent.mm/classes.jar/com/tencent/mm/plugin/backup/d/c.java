package com.tencent.mm.plugin.backup.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c
  implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.g.b.d
{
  private static int ePG = 0;
  private static boolean jBD;
  private static boolean jBo = false;
  private static boolean jBp = false;
  String bYu;
  private long dbSize;
  private boolean eUJ;
  public com.tencent.mm.plugin.backup.b.b.d jAq;
  private boolean jAv;
  String jBA;
  int jBB;
  private ap jBC;
  final com.tencent.mm.ai.f jBE;
  private final com.tencent.mm.ai.f jBF;
  private final com.tencent.mm.ai.f jBG;
  public long jBH;
  private int jBI;
  b.c jBJ;
  private final j.a jBK;
  private com.tencent.mm.plugin.backup.c.d jBd;
  private long jBe;
  private long jBf;
  private LinkedList<String> jBg;
  private LinkedList<Long> jBh;
  private LinkedList<String> jBi;
  private LinkedList<Long> jBj;
  public b.a jBk;
  private HashSet<String> jBl;
  private long jBm;
  private long jBn;
  private boolean jBq;
  private HashSet<String> jBr;
  private int jBs;
  public boolean jBt;
  private boolean jBu;
  private boolean jBv;
  private boolean jBw;
  private boolean jBx;
  private int jBy;
  public String jBz;
  private long jyU;
  private Object lock;
  private long recvSize;
  
  static
  {
    jBD = false;
  }
  
  public c()
  {
    AppMethodBeat.i(17260);
    this.dbSize = 0L;
    this.jyU = 0L;
    this.recvSize = 0L;
    this.jBe = 0L;
    this.jBf = 0L;
    this.lock = new Object();
    this.eUJ = false;
    this.jBl = new HashSet();
    this.jBm = 0L;
    this.jBn = 0L;
    this.jBq = true;
    this.jBr = new HashSet();
    this.jBs = 0;
    this.jBt = false;
    this.jBu = true;
    this.jBv = true;
    this.jAv = false;
    this.jBw = false;
    this.jBx = false;
    this.jBE = new c.1(this);
    this.jBF = new c.5(this);
    this.jBG = new c.6(this);
    this.jBJ = new c.10(this);
    this.jBK = new c.11(this);
    AppMethodBeat.o(17260);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(17268);
    y localy = new y();
    localy.jKw = paramString;
    localy.jKx = paramInt1;
    localy.jKz = paramInt2;
    localy.jKA = paramInt3;
    localy.jJS = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.r(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(17268);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(17268);
    }
  }
  
  public static String aTA()
  {
    AppMethodBeat.i(17272);
    String str = com.tencent.mm.plugin.backup.g.b.aUr();
    AppMethodBeat.o(17272);
    return str;
  }
  
  private static void aTB()
  {
    AppMethodBeat.i(17273);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.aTr().jyF;
    try
    {
      ab.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.J(locala.toByteArray(), 5);
      AppMethodBeat.o(17273);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(17273);
    }
  }
  
  public static boolean aTw()
  {
    AppMethodBeat.i(17261);
    boolean bool = aw.aaz().Zf().dvS();
    AppMethodBeat.o(17261);
    return bool;
  }
  
  private void aTy()
  {
    AppMethodBeat.i(17265);
    String str1 = this.jBz;
    String str2 = this.jBA;
    String str3 = com.tencent.mm.plugin.backup.b.g.dx(ah.getContext());
    ab.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(ePG) });
    if ((str3 == null) || (str3.equals("")))
    {
      h.qsU.idkeyStat(485L, 1L, 1L, false);
      h.qsU.e(11787, new Object[] { Integer.valueOf(1) });
      b.aTr().aSL().jyN = -1;
      rf(-1);
      AppMethodBeat.o(17265);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      h.qsU.idkeyStat(485L, 2L, 1L, false);
      h.qsU.e(11787, new Object[] { Integer.valueOf(2) });
      b.aTr().aSL().jyN = -2;
      rf(-2);
      AppMethodBeat.o(17265);
      return;
    }
    if (!com.tencent.mm.plugin.backup.b.g.Gj(str2))
    {
      h.qsU.idkeyStat(485L, 3L, 1L, false);
      h.qsU.e(11787, new Object[] { Integer.valueOf(3) });
      b.aTr().aSL().jyN = -3;
      rf(-3);
      AppMethodBeat.o(17265);
      return;
    }
    if (ePG <= 0)
    {
      b.aTr().aSL().jyN = -5;
      rf(-5);
      h.qsU.idkeyStat(485L, 4L, 1L, false);
      h.qsU.e(11787, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(17265);
      return;
    }
    ePG -= 1;
    bF(this.jBA, this.jBB);
    AppMethodBeat.o(17265);
  }
  
  private void bF(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(17264);
    b.aTr().aTs().connect(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.jBF);
    for (;;)
    {
      try
      {
        if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.jBv = bool;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.aTr().jyG, b.aTr().jyH, com.tencent.mm.plugin.backup.b.d.aSP(), b.aTr().jyF, com.tencent.mm.plugin.backup.b.c.jyx, 22);
      paramString.t(this.jBv, false);
      paramString.aUv();
      ab.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.jBC == null) {
        this.jBC = new ap(new c.4(this), false);
      }
      this.jBC.ag(3000L, 3000L);
      AppMethodBeat.o(17264);
      return;
      bool = false;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(17266);
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      ab.i("MicroMsg.BackupMoveRecoverServer", "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break label384;
      }
      paramInt1 = b.aTr().aSL().jyN;
      ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      }
    }
    long l;
    for (;;)
    {
      AppMethodBeat.o(17266);
      return;
      i = paramArrayOfByte.length;
      break;
      b.aTr().aTs().stop();
      if (!jBD)
      {
        if (this.jBC != null)
        {
          ab.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
          this.jBC.stopTimer();
        }
        aTy();
        AppMethodBeat.o(17266);
        return;
      }
      b.aTr().aSL().jyN = -4;
      rf(-4);
      AppMethodBeat.o(17266);
      return;
      b.aTr().aTs().stop();
      AppMethodBeat.o(17266);
      return;
      c(true, false, -4);
      b.aTr().aTs().stop();
      jBp = true;
      h.qsU.idkeyStat(485L, 43L, 1L, false);
      rj(4);
      l = 0L;
      if (this.jBm != 0L) {
        l = bo.hl(this.jBm);
      }
      ab.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.jyU), Long.valueOf(this.recvSize), Long.valueOf(l) });
      AppMethodBeat.o(17266);
      return;
      c(true, false, 0);
    }
    label384:
    if (paramInt1 == 9)
    {
      com.tencent.mm.plugin.backup.i.e locale = (com.tencent.mm.plugin.backup.i.e)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.e(), paramArrayOfByte);
      if (locale == null)
      {
        ab.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bo.cf(paramArrayOfByte)) });
        AppMethodBeat.o(17266);
        return;
      }
      ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.jFD) });
      paramArrayOfByte = new com.tencent.mm.plugin.backup.i.f();
      paramArrayOfByte.jFD = locale.jFD;
      try
      {
        ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.r(paramArrayOfByte.toByteArray(), 10, paramInt2);
        AppMethodBeat.o(17266);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramArrayOfByte, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
        AppMethodBeat.o(17266);
        return;
      }
    }
    if (paramInt1 == 10)
    {
      paramArrayOfByte = (com.tencent.mm.plugin.backup.i.f)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.jFD;; l = -1L)
      {
        ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        AppMethodBeat.o(17266);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      h.qsU.idkeyStat(485L, 51L, 1L, false);
      c(true, false, -100);
    }
    aw.RO().ac(new c.7(this, paramInt1, paramArrayOfByte, paramInt2));
    AppMethodBeat.o(17266);
  }
  
  public final void aSK()
  {
    AppMethodBeat.i(17275);
    long l1 = bo.hl(this.jBn) / 1000L;
    long l2 = b.aTr().aSL().jyX;
    h.qsU.idkeyStat(485L, 49L, 1L, false);
    h.qsU.idkeyStat(485L, 50L, l1, false);
    h.qsU.idkeyStat(485L, 72L, l2, false);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yEv, Boolean.TRUE);
    ab.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    Object localObject;
    LinkedList localLinkedList;
    if (!this.jAv)
    {
      localObject = aw.aaz().Ze();
      localLinkedList = new LinkedList();
      localObject = ((n)localObject).getAll();
      if (localObject != null) {
        break label195;
      }
      ab.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
      if (localLinkedList.size() > 0) {
        break label242;
      }
      ab.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      aTx();
      com.tencent.mm.plugin.backup.g.b.ru(22);
      com.tencent.mm.plugin.backup.g.b.aUo();
      com.tencent.mm.plugin.backup.g.b.aUq();
      AppMethodBeat.o(17275);
      return;
      label195:
      while (((Cursor)localObject).moveToNext())
      {
        m localm = new m();
        localm.convertFrom((Cursor)localObject);
        localLinkedList.add(localm);
      }
      ((Cursor)localObject).close();
      break;
      label242:
      ab.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      aw.aaz().Zd().f(this.bYu, localLinkedList);
    }
  }
  
  public final void aTd()
  {
    AppMethodBeat.i(17271);
    synchronized (this.lock)
    {
      if ((this.jBd != null) && (this.jBd.jAk))
      {
        ab.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(17271);
        return;
      }
      if (this.jBd != null) {
        this.jBd.n(false, 0);
      }
      if ((this.jBl == null) || (this.jBl.size() <= 0))
      {
        i = aw.aaz().Zf().dvT();
        b.aTr().aSL().jyN = 26;
        b.aTr().aSL().jyQ = 0;
        rf(26);
        this.jBn = bo.aoy();
        this.jBd = new com.tencent.mm.plugin.backup.c.d(b.aTr(), 22, this, i, false, new LinkedList(), new LinkedList());
        this.jBd.aTd();
        h.qsU.idkeyStat(485L, 46L, 1L, false);
        AppMethodBeat.o(17271);
        return;
      }
      int i = this.jBl.size();
    }
  }
  
  public final void aTx()
  {
    AppMethodBeat.i(17262);
    ab.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.jBl.clear();
    AppMethodBeat.o(17262);
  }
  
  public final void aTz()
  {
    AppMethodBeat.i(17270);
    c(true, false, 28);
    b.aTr().aTs().stop();
    AppMethodBeat.o(17270);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(17263);
    ab.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), an.dtg() });
    if (!paramBoolean1) {
      aTB();
    }
    synchronized (this.lock)
    {
      this.eUJ = true;
      if ((this.jBd != null) && (this.jBd.jAk))
      {
        this.jBd.n(paramBoolean2, paramInt);
        this.jBd = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.aTr().aSL().jyN = paramInt;
          rf(paramInt);
        }
        if (paramBoolean2) {
          aTx();
        }
        com.tencent.mm.plugin.backup.g.b.aUo();
        com.tencent.mm.plugin.backup.g.b.aUq();
        b.aTr().aSN();
        b.aTr().aTs().jzl = null;
        AppMethodBeat.o(17263);
        return;
      }
      i = 1;
    }
  }
  
  public final void fy(boolean paramBoolean)
  {
    AppMethodBeat.i(17267);
    this.jBx = paramBoolean;
    Object localObject = new LinkedBlockingQueue();
    b.aTr().aTs().jzl = new a.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(17253);
        for (;;)
        {
          if (!c.n(c.this)) {}
          try
          {
            boolean bool = this.jBN.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              ab.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.jBN.size()) });
              AppMethodBeat.o(17253);
              return;
            }
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    com.tencent.mm.sdk.g.d.h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17254);
        for (;;)
        {
          if ((!c.n(c.this)) && (!c.aTD())) {
            try
            {
              c.a locala = (c.a)this.jBN.poll(500L, TimeUnit.MILLISECONDS);
              ab.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", new Object[] { Integer.valueOf(this.jBN.size()), locala });
              if (locala != null) {
                c.this.a(locala.idE, locala.type, locala.buf, locala.fQD);
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
        AppMethodBeat.o(17254);
      }
    }, "startSendRequestSessionResponse.onNotifyWorker").start();
    this.jBi = new LinkedList();
    this.jBj = new LinkedList();
    aw.aaz().Ze().a(this.jBg, this.jBh, this.jBi, this.jBj);
    if ((!this.jAv) && (!paramBoolean))
    {
      localObject = this.jBi;
      LinkedList localLinkedList = this.jBj;
      this.jBi = new LinkedList();
      this.jBj = new LinkedList();
      aw.aaz().Zd().a(this.bYu, (LinkedList)localObject, localLinkedList, this.jBi, this.jBj);
    }
    localObject = new com.tencent.mm.plugin.backup.i.j();
    ((com.tencent.mm.plugin.backup.i.j)localObject).jJw = this.jBi;
    ((com.tencent.mm.plugin.backup.i.j)localObject).jJx = this.jBj;
    try
    {
      ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(this.jBg.size()), Integer.valueOf(((com.tencent.mm.plugin.backup.i.j)localObject).jJx.size()) });
      com.tencent.mm.plugin.backup.g.b.r(((com.tencent.mm.plugin.backup.i.j)localObject).toByteArray(), 12, this.jBI);
      com.tencent.mm.plugin.backup.g.b.aUp();
      if (this.jBw)
      {
        b.aTr().aSL().N(23, 1, this.jBg.size());
        this.jyU = b.aTr().aSL().jyU;
        this.recvSize = b.aTr().aSL().jyR;
        this.jBe = b.aTr().aSL().jyS;
        this.jBf = b.aTr().aSL().jyT;
        this.dbSize = b.aTr().aSL().jyW;
        rf(23);
        AppMethodBeat.o(17267);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupRequestSessionResponse err.", new Object[0]);
        continue;
        b.aTr().aSL().a(23, 1, this.jBg.size(), 0L, this.jyU, 0L, 0L);
      }
    }
  }
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(17274);
    if (this.jAq != null) {
      al.d(new c.2(this, paramInt));
    }
    if (this.jBk != null) {
      al.d(new c.3(this, paramInt));
    }
    AppMethodBeat.o(17274);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(17269);
    long l = 0L;
    if (this.jBm != 0L) {
      l = bo.hl(this.jBm);
    }
    h.qsU.e(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.jBy), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.dbSize / 1024L) });
    ab.i("MicroMsg.BackupMoveRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], dbSize[%d kb]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.jyU / 1024L), Long.valueOf(this.recvSize / 1024L), Long.valueOf(l / 1000L), Long.valueOf(this.dbSize / 1024L) });
    AppMethodBeat.o(17269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c
 * JD-Core Version:    0.7.0.1
 */