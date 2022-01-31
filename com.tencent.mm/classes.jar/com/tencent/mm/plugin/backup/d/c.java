package com.tencent.mm.plugin.backup.d;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.c.a.a;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
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
  private static int ebp = 0;
  private static boolean hHQ = false;
  private static boolean hHR = false;
  private static boolean hIf = false;
  String bwK;
  private boolean edT = false;
  private long hFz = 0L;
  public com.tencent.mm.plugin.backup.b.b.d hGU;
  private boolean hGZ = false;
  private com.tencent.mm.plugin.backup.c.d hHH;
  private LinkedList<String> hHI;
  private LinkedList<Long> hHJ;
  private LinkedList<String> hHK;
  private LinkedList<Long> hHL;
  public b.a hHM;
  private HashSet<String> hHN = new HashSet();
  private long hHO = 0L;
  private long hHP = 0L;
  private boolean hHS = true;
  private HashSet<String> hHT = new HashSet();
  private int hHU = 0;
  public boolean hHV = false;
  private boolean hHW = true;
  private boolean hHX = true;
  private boolean hHY = false;
  private boolean hHZ = false;
  private int hIa;
  public String hIb;
  String hIc;
  int hId;
  private am hIe;
  final com.tencent.mm.ah.f hIg = new c.1(this);
  private final com.tencent.mm.ah.f hIh = new c.5(this);
  private final com.tencent.mm.ah.f hIi = new c.6(this);
  public long hIj;
  private int hIk;
  b.c hIl = new c.10(this);
  private final j.a hIm = new c.11(this);
  private Object lock = new Object();
  private long recvSize = 0L;
  
  public static boolean atX()
  {
    return au.Hx().Ge().ctw();
  }
  
  private void atZ()
  {
    String str1 = this.hIb;
    String str2 = this.hIc;
    String str3 = com.tencent.mm.plugin.backup.b.g.cM(ae.getContext());
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", new Object[] { str3, str1, str2, Integer.valueOf(ebp) });
    if ((str3 == null) || (str3.equals("")))
    {
      h.nFQ.a(485L, 1L, 1L, false);
      h.nFQ.f(11787, new Object[] { Integer.valueOf(1) });
      b.atS().atn().hFu = -1;
      nt(-1);
      return;
    }
    if ((str1 == null) || (!str1.equals(str3)))
    {
      h.nFQ.a(485L, 2L, 1L, false);
      h.nFQ.f(11787, new Object[] { Integer.valueOf(2) });
      b.atS().atn().hFu = -2;
      nt(-2);
      return;
    }
    if (!com.tencent.mm.plugin.backup.b.g.vA(str2))
    {
      h.nFQ.a(485L, 3L, 1L, false);
      h.nFQ.f(11787, new Object[] { Integer.valueOf(3) });
      b.atS().atn().hFu = -3;
      nt(-3);
      return;
    }
    if (ebp <= 0)
    {
      b.atS().atn().hFu = -5;
      nt(-5);
      h.nFQ.a(485L, 4L, 1L, false);
      h.nFQ.f(11787, new Object[] { Integer.valueOf(6) });
      return;
    }
    ebp -= 1;
    bf(this.hIc, this.hId);
  }
  
  public static String aub()
  {
    return com.tencent.mm.plugin.backup.g.b.auP();
  }
  
  private static void auc()
  {
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.atS().hFm;
    try
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
      com.tencent.mm.plugin.backup.g.b.I(locala.toByteArray(), 5);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
    }
  }
  
  private static void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    com.tencent.mm.plugin.backup.i.y localy = new com.tencent.mm.plugin.backup.i.y();
    localy.hQV = paramString;
    localy.hQW = paramInt1;
    localy.hQY = paramInt2;
    localy.hQZ = paramInt3;
    localy.hQq = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.o(localy.toByteArray(), 7, paramInt5);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "sendResp", new Object[0]);
    }
  }
  
  private void bf(String paramString, int paramInt)
  {
    boolean bool = true;
    b.atS().atT().connect(paramString, paramInt);
    com.tencent.mm.plugin.backup.g.b.a(1, this.hIh);
    for (;;)
    {
      try
      {
        if (bk.getInt(com.tencent.mm.m.g.AA().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
          continue;
        }
        this.hHX = bool;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramString, "getInt", new Object[0]);
        continue;
      }
      paramString = new com.tencent.mm.plugin.backup.g.a(b.atS().hFn, b.atS().hFo, com.tencent.mm.plugin.backup.b.d.atr(), b.atS().hFm, com.tencent.mm.plugin.backup.b.c.hFe, 22);
      paramString.t(this.hHX, false);
      paramString.auT();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
      if (this.hIe == null) {
        this.hIe = new am(new c.4(this), false);
      }
      this.hIe.S(3000L, 3000L);
      return;
      bool = false;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break;
      }
      paramInt1 = b.atS().atn().hFu;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    b.atS().atT().stop();
    if (!hIf)
    {
      if (this.hIe != null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
        this.hIe.stopTimer();
      }
      atZ();
      return;
    }
    b.atS().atn().hFu = -4;
    nt(-4);
    return;
    b.atS().atT().stop();
    return;
    a(true, false, -4);
    b.atS().atT().stop();
    hHR = true;
    h.nFQ.a(485L, 43L, 1L, false);
    nx(4);
    long l = 0L;
    if (this.hHO != 0L) {
      l = bk.co(this.hHO);
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(this.hFz), Long.valueOf(l) });
    return;
    a(true, false, 0);
    return;
    if (paramInt1 == 9)
    {
      com.tencent.mm.plugin.backup.i.e locale = (com.tencent.mm.plugin.backup.i.e)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.e(), paramArrayOfByte);
      if (locale == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bk.bF(paramArrayOfByte)) });
        return;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", new Object[] { locale, Long.valueOf(locale.hMb) });
      paramArrayOfByte = new com.tencent.mm.plugin.backup.i.f();
      paramArrayOfByte.hMb = locale.hMb;
      try
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
        com.tencent.mm.plugin.backup.g.b.o(paramArrayOfByte.toByteArray(), 10, paramInt2);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", paramArrayOfByte, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
        return;
      }
    }
    if (paramInt1 == 10)
    {
      paramArrayOfByte = (com.tencent.mm.plugin.backup.i.f)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.hMb;; l = -1L)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat response, resp:%s ack:%d", new Object[] { paramArrayOfByte, Long.valueOf(l) });
        return;
      }
    }
    if (paramInt1 == 5)
    {
      h.nFQ.a(485L, 51L, 1L, false);
      a(true, false, -100);
    }
    au.DS().O(new c.7(this, paramInt1, paramArrayOfByte, paramInt2));
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), ak.cri() });
    if (!paramBoolean1) {
      auc();
    }
    synchronized (this.lock)
    {
      this.edT = true;
      if ((this.hHH != null) && (this.hHH.hGO))
      {
        this.hHH.h(paramBoolean2, paramInt);
        this.hHH = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.atS().atn().hFu = paramInt;
          nt(paramInt);
        }
        if (paramBoolean2) {
          atY();
        }
        com.tencent.mm.plugin.backup.g.b.auM();
        com.tencent.mm.plugin.backup.g.b.auO();
        b.atS().atT().hFO = null;
        return;
      }
      i = 1;
    }
  }
  
  public final void atF()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if ((this.hHH != null) && (this.hHH.hGO))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
          return;
        }
        if (this.hHH != null) {
          this.hHH.h(false, 0);
        }
        if ((this.hHN == null) || (this.hHN.size() <= 0))
        {
          i = au.Hx().Ge().ctx();
          b.atS().atn().hFu = 26;
          b.atS().atn().hFx = 0;
          nt(26);
          this.hHP = bk.UY();
          this.hHH = new com.tencent.mm.plugin.backup.c.d(b.atS(), 22, this, i, false, new LinkedList(), new LinkedList());
          this.hHH.atF();
          h.nFQ.a(485L, 46L, 1L, false);
          return;
        }
      }
      int i = this.hHN.size();
    }
  }
  
  public final void atY()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
    this.hHN.clear();
  }
  
  public final void atm()
  {
    h.nFQ.a(485L, 49L, 1L, false);
    h.nFQ.a(485L, 50L, bk.co(this.hHP) / 1000L, false);
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.uus, Boolean.valueOf(true));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
    Object localObject;
    LinkedList localLinkedList;
    if (!this.hGZ)
    {
      localObject = au.Hx().Gd();
      localLinkedList = new LinkedList();
      localObject = ((n)localObject).aAn();
      if (localObject != null) {
        break label134;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
      if (localLinkedList.size() > 0) {
        break label174;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
    }
    for (;;)
    {
      atY();
      com.tencent.mm.plugin.backup.g.b.nG(22);
      com.tencent.mm.plugin.backup.g.b.auM();
      com.tencent.mm.plugin.backup.g.b.auO();
      return;
      label134:
      while (((Cursor)localObject).moveToNext())
      {
        m localm = new m();
        localm.d((Cursor)localObject);
        localLinkedList.add(localm);
      }
      ((Cursor)localObject).close();
      break;
      label174:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
      au.Hx().Gc().f(this.bwK, localLinkedList);
    }
  }
  
  public final void aua()
  {
    a(true, false, 28);
    b.atS().atT().stop();
  }
  
  public final void eb(boolean paramBoolean)
  {
    this.hHZ = paramBoolean;
    Object localObject = new LinkedBlockingQueue();
    b.atS().atT().hFO = new a.a()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        for (;;)
        {
          if (!c.m(c.this)) {}
          try
          {
            boolean bool = this.hIp.offer(new c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte), 500L, TimeUnit.MILLISECONDS);
            if (bool)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", new Object[] { Integer.valueOf(this.hIp.size()) });
              return;
            }
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    com.tencent.mm.sdk.f.e.b(new c.9(this, (LinkedBlockingQueue)localObject), "startSendRequestSessionResponse.onNotifyWorker").start();
    this.hHK = new LinkedList();
    this.hHL = new LinkedList();
    au.Hx().Gd().a(this.hHI, this.hHJ, this.hHK, this.hHL);
    if ((!this.hGZ) && (!paramBoolean))
    {
      localObject = this.hHK;
      LinkedList localLinkedList = this.hHL;
      this.hHK = new LinkedList();
      this.hHL = new LinkedList();
      au.Hx().Gc().a(this.bwK, (LinkedList)localObject, localLinkedList, this.hHK, this.hHL);
    }
    localObject = new com.tencent.mm.plugin.backup.i.j();
    ((com.tencent.mm.plugin.backup.i.j)localObject).hPU = this.hHK;
    ((com.tencent.mm.plugin.backup.i.j)localObject).hPV = this.hHL;
    try
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[] { Integer.valueOf(this.hHI.size()), Integer.valueOf(((com.tencent.mm.plugin.backup.i.j)localObject).hPV.size()) });
      com.tencent.mm.plugin.backup.g.b.o(((com.tencent.mm.plugin.backup.i.j)localObject).toByteArray(), 12, this.hIk);
      com.tencent.mm.plugin.backup.g.b.auN();
      if (this.hHY)
      {
        b.atS().atn().B(23, 1, this.hHI.size());
        this.recvSize = b.atS().atn().hFy;
        nt(23);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", localException, "buf to BackupRequestSessionResponse err.", new Object[0]);
        continue;
        b.atS().atn().a(23, 1, this.hHI.size(), 0L, this.hFz);
      }
    }
  }
  
  public final void nt(int paramInt)
  {
    if (this.hGU != null) {
      ai.d(new c.2(this, paramInt));
    }
    if (this.hHM != null) {
      ai.d(new c.3(this, paramInt));
    }
  }
  
  public final void nx(int paramInt)
  {
    long l = 0L;
    if (this.hHO != 0L) {
      l = bk.co(this.hHO);
    }
    h.nFQ.f(11789, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(this.hIa), Long.valueOf(this.hFz / 1024L), Long.valueOf(l / 1000L) });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupMoveRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recoverCostTime[%d s]", new Object[] { Integer.valueOf(11789), Integer.valueOf(paramInt), Long.valueOf(this.hFz / 1024L), Long.valueOf(l / 1000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c
 * JD-Core Version:    0.7.0.1
 */