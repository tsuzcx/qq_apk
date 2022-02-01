package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.i;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static boolean nBk = false;
  public static boolean nzM = false;
  public byte[] bitmapData;
  public boolean nAJ;
  public b.c nAY;
  public final j.a nAZ;
  public LinkedList<String> nBd;
  private com.tencent.mm.plugin.backup.c.b nBe;
  public com.tencent.mm.plugin.backup.c.c nBf;
  public long nBg;
  public long nBh;
  public boolean nBi;
  public int nBj;
  private int nBl;
  private int nBm;
  private int nBn;
  public final com.tencent.mm.plugin.backup.g.b.d nBo;
  public e nBp;
  public b.b nyQ;
  public com.tencent.mm.plugin.backup.b.b.d nzH;
  
  public d()
  {
    AppMethodBeat.i(21349);
    this.nBg = 0L;
    this.nBh = 0L;
    this.nBi = false;
    this.nBj = 0;
    this.nAJ = false;
    this.nBn = 0;
    this.nBo = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21339);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify isLocal:%b type:%d seq:%d buf:%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((paramAnonymousBoolean) && (paramAnonymousArrayOfByte != null) && (10011 == paramAnonymousInt1))
          {
            i = b.bIE().bHV().nye;
            ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            }
          }
        }
        Object localObject;
        for (;;)
        {
          if (paramAnonymousInt1 == 1)
          {
            localObject = (v)com.tencent.mm.plugin.backup.b.g.a(new v(), paramAnonymousArrayOfByte);
            if (localObject == null)
            {
              ae.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(bu.cG(paramAnonymousArrayOfByte)) });
              b.bIE().bHV().nye = -5;
              d.this.tK(-5);
              AppMethodBeat.o(21339);
              return;
              i = paramAnonymousArrayOfByte.length;
              break;
              b.bIE().bIF().stop();
              b.bIE().bHV().nye = -100;
              d.this.tK(-100);
              continue;
              b.bIE().bIF().stop();
              continue;
              d.this.cancel(true);
              b.bIE().bIF().stop();
              b.bIE().bHV().nye = -4;
              d.this.tK(-4);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 24L, 1L, false);
              if ((d.a(d.this) == null) || (d.a(d.this).nyT == 0L)) {
                continue;
              }
              long l = bu.DD(d.a(d.this).nyT);
              ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(d.this).bIn()), Long.valueOf(l / 1000L) });
              continue;
              d.this.cancel(true);
              continue;
            }
            if (bu.isNullOrNil(b.bIE().nxW)) {
              b.bIE().nxW = ((v)localObject).ID;
            }
            if (!((v)localObject).ID.equals(b.bIE().nxW))
            {
              ae.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.bIE().nxW, ((v)localObject).ID });
              d.this.cancel(false);
              b.bIE().bHV().nye = -5;
              d.this.tK(-5);
              AppMethodBeat.o(21339);
              return;
            }
            ae.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).nJz) });
            if (((v)localObject).nJz == 0)
            {
              paramAnonymousArrayOfByte = ((v)localObject).nIq.zr;
              if (!b.bIE().nxX.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bHZ()))))
              {
                d.xA(paramAnonymousInt2);
                b.bIE().bHV().nye = -5;
                d.this.tK(-5);
              }
              if (((v)localObject).Version < com.tencent.mm.plugin.backup.b.c.nxO)
              {
                ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).Version) });
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 103L, 1L, false);
                b.bIE().bHV().nye = -12;
                d.this.tK(-12);
                AppMethodBeat.o(21339);
                return;
              }
              ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
              d.a(d.this, paramAnonymousInt2);
              if ((d.blc()) || (d.nzM))
              {
                if ((d.blc()) && (d.nzM) && ((((v)localObject).nJB & com.tencent.mm.plugin.backup.b.c.nxT) == 0) && ((((v)localObject).nJB & com.tencent.mm.plugin.backup.b.c.nxU) == 0))
                {
                  b.bIE().bHV().nye = -31;
                  d.this.tK(-31);
                  d.b(d.this, 1);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.blc()) && ((((v)localObject).nJB & com.tencent.mm.plugin.backup.b.c.nxT) == 0))
                {
                  b.bIE().bHV().nye = -32;
                  d.this.tK(-32);
                  d.b(d.this, 2);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.nzM) && ((((v)localObject).nJB & com.tencent.mm.plugin.backup.b.c.nxU) == 0))
                {
                  b.bIE().bHV().nye = -33;
                  d.this.tK(-33);
                  d.b(d.this, 3);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              d.this.iA(false);
              AppMethodBeat.o(21339);
              return;
            }
            if (((v)localObject).nJz == 1)
            {
              paramAnonymousArrayOfByte = ((v)localObject).nIq.zr;
              if (!b.bIE().nxY.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bHZ()))))
              {
                ae.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                b.bIE().bHV().nye = -5;
                d.this.tK(-5);
              }
              ae.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
              b.bIE().bHV().nye = 2;
              d.this.tK(2);
            }
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 3)
        {
          d.c(d.this, paramAnonymousInt2);
          if (b.bIE().bII().nAl)
          {
            d.this.bIU();
            AppMethodBeat.o(21339);
            return;
          }
          d.b(d.this);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 9)
        {
          localObject = (com.tencent.mm.plugin.backup.i.e)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.e(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            ae.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bu.cG(paramAnonymousArrayOfByte)) });
            AppMethodBeat.o(21339);
            return;
          }
          ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).nEQ) });
          paramAnonymousArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramAnonymousArrayOfByte);
          paramAnonymousArrayOfByte.nEQ = ((com.tencent.mm.plugin.backup.i.e)localObject).nEQ;
          try
          {
            ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify send heartbeatResp");
            com.tencent.mm.plugin.backup.g.b.t(paramAnonymousArrayOfByte.toByteArray(), 10, paramAnonymousInt2);
            AppMethodBeat.o(21339);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ae.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify buf to BackupHeartBeatResponse err.", new Object[0]);
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 10)
        {
          localObject = new f();
          try
          {
            ((f)localObject).parseFrom(paramAnonymousArrayOfByte);
            AppMethodBeat.o(21339);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ae.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify heartbeatResp parse from buf error.", new Object[0]);
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 5)
        {
          ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive command cancel");
          d.this.cancel(true);
          b.bIE().bHV().nye = -100;
          d.this.tK(-100);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 12)
        {
          localObject = (j)com.tencent.mm.plugin.backup.b.g.a(new j(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            ae.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(bu.cG(paramAnonymousArrayOfByte)) });
            b.bIE().bHV().nye = -5;
            d.this.tK(-5);
            AppMethodBeat.o(21339);
            return;
          }
          paramAnonymousArrayOfByte = com.tencent.mm.plugin.backup.b.g.b(((j)localObject).nIF, ((j)localObject).nIG);
          if (paramAnonymousArrayOfByte == null) {}
          for (paramAnonymousInt1 = -1;; paramAnonymousInt1 = paramAnonymousArrayOfByte.size())
          {
            ae.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if (paramAnonymousArrayOfByte != null) {
              break;
            }
            ae.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
            d.bIO();
            b.bIE().bHV().nye = -21;
            d.this.tK(-21);
            AppMethodBeat.o(21339);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.bJz();
          if ((d.a(d.this) == null) || (d.a(d.this).nyP)) {
            d.a(d.this, new com.tencent.mm.plugin.backup.c.c(b.bIE(), 2, d.c(d.this)));
          }
          d.a(d.this).ix(false);
          d.a(d.this).a(paramAnonymousArrayOfByte, b.bIE().bHV().nym, d.nzM);
        }
        AppMethodBeat.o(21339);
      }
    };
    this.nyQ = new b.b()
    {
      public final void bHR()
      {
        AppMethodBeat.i(21342);
        com.tencent.mm.plugin.backup.g.b.xH(21);
        AppMethodBeat.o(21342);
      }
      
      public final void bHS()
      {
        AppMethodBeat.i(21343);
        d.this.cancel(false);
        AppMethodBeat.o(21343);
      }
      
      public final void xu(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21341);
        if (d.d(d.this) != null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21340);
              if (d.d(d.this) != null) {
                d.d(d.this).xu(paramAnonymousInt);
              }
              AppMethodBeat.o(21340);
            }
          });
        }
        AppMethodBeat.o(21341);
      }
    };
    this.nAY = new b.c()
    {
      public final void bIT()
      {
        AppMethodBeat.i(21344);
        ae.i("MicroMsg.BackupMoveServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bJA();
        b.bIE().bHX();
        AppMethodBeat.o(21344);
      }
    };
    this.nAZ = new j.a()
    {
      public final void bIR()
      {
        AppMethodBeat.i(21345);
        d.this.tK(b.bIE().bHV().nye);
        AppMethodBeat.o(21345);
      }
      
      public final void bIS()
      {
        AppMethodBeat.i(21347);
        int i = b.bIE().bHV().nye;
        ae.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 14) || (i == 4))
        {
          d.this.cancel(true);
          b.bIE().bIF().stop();
          b.bIE().bHV().nye = -4;
          d.this.tK(-4);
        }
        AppMethodBeat.o(21347);
      }
      
      public final void xz(int paramAnonymousInt)
      {
        AppMethodBeat.i(21346);
        int i = b.bIE().bHV().nye;
        if (paramAnonymousInt == 1)
        {
          if (i == 14)
          {
            ae.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
            b.bIE().bHV().nye = 4;
            d.this.tK(4);
            AppMethodBeat.o(21346);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ae.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
          b.bIE().bHV().nye = 14;
          d.this.tK(14);
        }
        AppMethodBeat.o(21346);
      }
    };
    this.nBp = new e(new e.a()
    {
      public final void n(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21348);
        if (paramAnonymousArrayOfByte != null) {
          d.this.bitmapData = paramAnonymousArrayOfByte;
        }
        d.this.tK(paramAnonymousInt);
        AppMethodBeat.o(21348);
      }
    }, b.bIE().bHV());
    AppMethodBeat.o(21349);
  }
  
  private void E(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21356);
    ae.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.nBd.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    i locali = new i();
    locali.nIF = this.nBd;
    locali.nIG = new LinkedList();
    Iterator localIterator = this.nBd.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.nIG.add(Long.valueOf(paramLong1));
      locali.nIG.add(Long.valueOf(paramLong2));
    }
    try
    {
      ae.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.nBd.size()) });
      com.tencent.mm.plugin.backup.g.b.L(locali.toByteArray(), 11);
      AppMethodBeat.o(21356);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
      AppMethodBeat.o(21356);
    }
  }
  
  public static void bIO()
  {
    AppMethodBeat.i(21357);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bIE().nxW;
    try
    {
      ae.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21357);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21357);
    }
  }
  
  public static String bIV()
  {
    AppMethodBeat.i(21358);
    String str = com.tencent.mm.plugin.backup.g.b.bJD();
    AppMethodBeat.o(21358);
    return str;
  }
  
  public static void e(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21352);
    ae.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.bIE();
    SharedPreferences.Editor localEditor = b.bIa().edit();
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", paramInt1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", paramLong1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", paramLong2);
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
    localEditor.commit();
    AppMethodBeat.o(21352);
  }
  
  public final void a(com.tencent.mm.plugin.backup.b.b.d paramd)
  {
    AppMethodBeat.i(21350);
    if (paramd.equals(this.nzH)) {
      this.nzH = null;
    }
    AppMethodBeat.o(21350);
  }
  
  public final void bIU()
  {
    AppMethodBeat.i(21355);
    ae.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.nBi = false;
    b.bIE().bHV().nye = 12;
    tK(12);
    com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
    if (this.nBd == null)
    {
      AppMethodBeat.o(21355);
      return;
    }
    ae.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.nBd.size()) });
    o localo = new o();
    localo.ID = b.bIE().nxW;
    localo.nIZ = this.nBd.size();
    localo.nJa = b.bIE().bII().bID();
    localo.nJb = 0;
    if (this.nAJ) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.nxN;; i = com.tencent.mm.plugin.backup.b.c.nxM)
    {
      localo.nJc = i;
      if (nzM) {
        localo.nIY = 3;
      }
      m localm = new m();
      localm.nIM = q.aaH();
      localm.nIN = Build.MANUFACTURER;
      localm.nIO = Build.MODEL;
      localm.nIP = "Android";
      localm.nIQ = Build.VERSION.RELEASE;
      localm.nIR = com.tencent.mm.protocal.d.FFH;
      localm.nIS = 0L;
      ae.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.FFH) });
      localo.nIW = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.t(localo.toByteArray(), 4, this.nBl);
        E(this.nBg, this.nBh);
        AppMethodBeat.o(21355);
        return;
      }
      catch (IOException localIOException)
      {
        ae.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
        ae.printErrStackTrace("MicroMsg.BackupMoveServer", localIOException, "", new Object[0]);
        AppMethodBeat.o(21355);
      }
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21351);
    ae.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", new Object[] { au.foQ() });
    if (!paramBoolean) {
      bIO();
    }
    if (this.nBf != null) {
      this.nBf.cancel();
    }
    if (this.nBe != null)
    {
      this.nBe.cancel();
      this.nBe = null;
    }
    ae.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.bJA();
    com.tencent.mm.plugin.backup.g.b.bJC();
    b.bIE().bHX();
    AppMethodBeat.o(21351);
  }
  
  public final void iA(boolean paramBoolean)
  {
    AppMethodBeat.i(21354);
    if (paramBoolean) {
      switch (this.nBn)
      {
      }
    }
    for (;;)
    {
      b.bIE().bHW();
      w localw = new w();
      localw.nJz = 0;
      localw.ID = b.bIE().nxW;
      localw.Version = com.tencent.mm.plugin.backup.b.c.nxO;
      localw.nJb = 0;
      localw.nJA = this.nBj;
      localw.nIq = new com.tencent.mm.bw.b(l.e(b.bIE().nxY.getBytes(), com.tencent.mm.plugin.backup.b.d.bHZ()));
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.nJB |= com.tencent.mm.plugin.backup.b.c.nxS;
      }
      localw.nJB |= com.tencent.mm.plugin.backup.b.c.nxT;
      localw.nJB |= com.tencent.mm.plugin.backup.b.c.nxU;
      try
      {
        ae.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.t(localw.toByteArray(), 2, this.nBm);
        AppMethodBeat.o(21354);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(21354);
      }
      nBk = false;
      nzM = false;
      this.nBg = 0L;
      this.nBh = 0L;
      continue;
      nBk = false;
      this.nBg = 0L;
      this.nBh = 0L;
      continue;
      nzM = false;
    }
  }
  
  public final void tK(int paramInt)
  {
    AppMethodBeat.i(21353);
    this.nyQ.xu(paramInt);
    AppMethodBeat.o(21353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */