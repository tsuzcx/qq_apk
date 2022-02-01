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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static boolean nur = false;
  public static boolean nvP = false;
  public byte[] bitmapData;
  public b.b ntv;
  public com.tencent.mm.plugin.backup.b.b.d num;
  public b.c nvD;
  public final j.a nvE;
  public LinkedList<String> nvI;
  private com.tencent.mm.plugin.backup.c.b nvJ;
  public com.tencent.mm.plugin.backup.c.c nvK;
  public long nvL;
  public long nvM;
  public boolean nvN;
  public int nvO;
  private int nvQ;
  private int nvR;
  private int nvS;
  public final com.tencent.mm.plugin.backup.g.b.d nvT;
  public e nvU;
  public boolean nvo;
  
  public d()
  {
    AppMethodBeat.i(21349);
    this.nvL = 0L;
    this.nvM = 0L;
    this.nvN = false;
    this.nvO = 0;
    this.nvo = false;
    this.nvS = 0;
    this.nvT = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21339);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify isLocal:%b type:%d seq:%d buf:%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((paramAnonymousBoolean) && (paramAnonymousArrayOfByte != null) && (10011 == paramAnonymousInt1))
          {
            i = b.bHG().bGX().nsJ;
            ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
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
              ad.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cD(paramAnonymousArrayOfByte)) });
              b.bHG().bGX().nsJ = -5;
              d.this.tF(-5);
              AppMethodBeat.o(21339);
              return;
              i = paramAnonymousArrayOfByte.length;
              break;
              b.bHG().bHH().stop();
              b.bHG().bGX().nsJ = -100;
              d.this.tF(-100);
              continue;
              b.bHG().bHH().stop();
              continue;
              d.this.cancel(true);
              b.bHG().bHH().stop();
              b.bHG().bGX().nsJ = -4;
              d.this.tF(-4);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 24L, 1L, false);
              if ((d.a(d.this) == null) || (d.a(d.this).nty == 0L)) {
                continue;
              }
              long l = bt.Df(d.a(d.this).nty);
              ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(d.this).bHp()), Long.valueOf(l / 1000L) });
              continue;
              d.this.cancel(true);
              continue;
            }
            if (bt.isNullOrNil(b.bHG().nsB)) {
              b.bHG().nsB = ((v)localObject).ID;
            }
            if (!((v)localObject).ID.equals(b.bHG().nsB))
            {
              ad.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.bHG().nsB, ((v)localObject).ID });
              d.this.cancel(false);
              b.bHG().bGX().nsJ = -5;
              d.this.tF(-5);
              AppMethodBeat.o(21339);
              return;
            }
            ad.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).nEe) });
            if (((v)localObject).nEe == 0)
            {
              paramAnonymousArrayOfByte = ((v)localObject).nCV.zr;
              if (!b.bHG().nsC.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bHb()))))
              {
                d.xv(paramAnonymousInt2);
                b.bHG().bGX().nsJ = -5;
                d.this.tF(-5);
              }
              if (((v)localObject).Version < com.tencent.mm.plugin.backup.b.c.nst)
              {
                ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).Version) });
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 103L, 1L, false);
                b.bHG().bGX().nsJ = -12;
                d.this.tF(-12);
                AppMethodBeat.o(21339);
                return;
              }
              ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
              d.a(d.this, paramAnonymousInt2);
              if ((d.bli()) || (d.nur))
              {
                if ((d.bli()) && (d.nur) && ((((v)localObject).nEg & com.tencent.mm.plugin.backup.b.c.nsy) == 0) && ((((v)localObject).nEg & com.tencent.mm.plugin.backup.b.c.nsz) == 0))
                {
                  b.bHG().bGX().nsJ = -31;
                  d.this.tF(-31);
                  d.b(d.this, 1);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.bli()) && ((((v)localObject).nEg & com.tencent.mm.plugin.backup.b.c.nsy) == 0))
                {
                  b.bHG().bGX().nsJ = -32;
                  d.this.tF(-32);
                  d.b(d.this, 2);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.nur) && ((((v)localObject).nEg & com.tencent.mm.plugin.backup.b.c.nsz) == 0))
                {
                  b.bHG().bGX().nsJ = -33;
                  d.this.tF(-33);
                  d.b(d.this, 3);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              d.this.iC(false);
              AppMethodBeat.o(21339);
              return;
            }
            if (((v)localObject).nEe == 1)
            {
              paramAnonymousArrayOfByte = ((v)localObject).nCV.zr;
              if (!b.bHG().nsD.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bHb()))))
              {
                ad.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                b.bHG().bGX().nsJ = -5;
                d.this.tF(-5);
              }
              ad.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
              b.bHG().bGX().nsJ = 2;
              d.this.tF(2);
            }
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 3)
        {
          d.c(d.this, paramAnonymousInt2);
          if (b.bHG().bHK().nuQ)
          {
            d.this.bHW();
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
            ad.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cD(paramAnonymousArrayOfByte)) });
            AppMethodBeat.o(21339);
            return;
          }
          ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).nzv) });
          paramAnonymousArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramAnonymousArrayOfByte);
          paramAnonymousArrayOfByte.nzv = ((com.tencent.mm.plugin.backup.i.e)localObject).nzv;
          try
          {
            ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify send heartbeatResp");
            com.tencent.mm.plugin.backup.g.b.t(paramAnonymousArrayOfByte.toByteArray(), 10, paramAnonymousInt2);
            AppMethodBeat.o(21339);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify buf to BackupHeartBeatResponse err.", new Object[0]);
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
            ad.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify heartbeatResp parse from buf error.", new Object[0]);
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 5)
        {
          ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive command cancel");
          d.this.cancel(true);
          b.bHG().bGX().nsJ = -100;
          d.this.tF(-100);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 12)
        {
          localObject = (j)com.tencent.mm.plugin.backup.b.g.a(new j(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            ad.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cD(paramAnonymousArrayOfByte)) });
            b.bHG().bGX().nsJ = -5;
            d.this.tF(-5);
            AppMethodBeat.o(21339);
            return;
          }
          paramAnonymousArrayOfByte = com.tencent.mm.plugin.backup.b.g.b(((j)localObject).nDk, ((j)localObject).nDl);
          if (paramAnonymousArrayOfByte == null) {}
          for (paramAnonymousInt1 = -1;; paramAnonymousInt1 = paramAnonymousArrayOfByte.size())
          {
            ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if (paramAnonymousArrayOfByte != null) {
              break;
            }
            ad.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
            d.bHQ();
            b.bHG().bGX().nsJ = -21;
            d.this.tF(-21);
            AppMethodBeat.o(21339);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.bIB();
          if ((d.a(d.this) == null) || (d.a(d.this).ntu)) {
            d.a(d.this, new com.tencent.mm.plugin.backup.c.c(b.bHG(), 2, d.c(d.this)));
          }
          d.a(d.this).iz(false);
          d.a(d.this).a(paramAnonymousArrayOfByte, b.bHG().bGX().nsR, d.nur);
        }
        AppMethodBeat.o(21339);
      }
    };
    this.ntv = new b.b()
    {
      public final void bGT()
      {
        AppMethodBeat.i(21342);
        com.tencent.mm.plugin.backup.g.b.xD(21);
        AppMethodBeat.o(21342);
      }
      
      public final void bGU()
      {
        AppMethodBeat.i(21343);
        d.this.cancel(false);
        AppMethodBeat.o(21343);
      }
      
      public final void xp(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21341);
        if (d.d(d.this) != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21340);
              if (d.d(d.this) != null) {
                d.d(d.this).xp(paramAnonymousInt);
              }
              AppMethodBeat.o(21340);
            }
          });
        }
        AppMethodBeat.o(21341);
      }
    };
    this.nvD = new b.c()
    {
      public final void bHV()
      {
        AppMethodBeat.i(21344);
        ad.i("MicroMsg.BackupMoveServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bIC();
        b.bHG().bGZ();
        AppMethodBeat.o(21344);
      }
    };
    this.nvE = new j.a()
    {
      public final void bHT()
      {
        AppMethodBeat.i(21345);
        d.this.tF(b.bHG().bGX().nsJ);
        AppMethodBeat.o(21345);
      }
      
      public final void bHU()
      {
        AppMethodBeat.i(21347);
        int i = b.bHG().bGX().nsJ;
        ad.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 14) || (i == 4))
        {
          d.this.cancel(true);
          b.bHG().bHH().stop();
          b.bHG().bGX().nsJ = -4;
          d.this.tF(-4);
        }
        AppMethodBeat.o(21347);
      }
      
      public final void xu(int paramAnonymousInt)
      {
        AppMethodBeat.i(21346);
        int i = b.bHG().bGX().nsJ;
        if (paramAnonymousInt == 1)
        {
          if (i == 14)
          {
            ad.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
            b.bHG().bGX().nsJ = 4;
            d.this.tF(4);
            AppMethodBeat.o(21346);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ad.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
          b.bHG().bGX().nsJ = 14;
          d.this.tF(14);
        }
        AppMethodBeat.o(21346);
      }
    };
    this.nvU = new e(new e.a()
    {
      public final void n(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21348);
        if (paramAnonymousArrayOfByte != null) {
          d.this.bitmapData = paramAnonymousArrayOfByte;
        }
        d.this.tF(paramAnonymousInt);
        AppMethodBeat.o(21348);
      }
    }, b.bHG().bGX());
    AppMethodBeat.o(21349);
  }
  
  private void F(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21356);
    ad.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.nvI.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    i locali = new i();
    locali.nDk = this.nvI;
    locali.nDl = new LinkedList();
    Iterator localIterator = this.nvI.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.nDl.add(Long.valueOf(paramLong1));
      locali.nDl.add(Long.valueOf(paramLong2));
    }
    try
    {
      ad.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.nvI.size()) });
      com.tencent.mm.plugin.backup.g.b.L(locali.toByteArray(), 11);
      AppMethodBeat.o(21356);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
      AppMethodBeat.o(21356);
    }
  }
  
  public static void bHQ()
  {
    AppMethodBeat.i(21357);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bHG().nsB;
    try
    {
      ad.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21357);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21357);
    }
  }
  
  public static String bHX()
  {
    AppMethodBeat.i(21358);
    String str = com.tencent.mm.plugin.backup.g.b.bIF();
    AppMethodBeat.o(21358);
    return str;
  }
  
  public static void e(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21352);
    ad.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.bHG();
    SharedPreferences.Editor localEditor = b.bHc().edit();
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
    if (paramd.equals(this.num)) {
      this.num = null;
    }
    AppMethodBeat.o(21350);
  }
  
  public final void bHW()
  {
    AppMethodBeat.i(21355);
    ad.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.nvN = false;
    b.bHG().bGX().nsJ = 12;
    tF(12);
    com.tencent.mm.plugin.backup.h.d.bIY().bJb();
    if (this.nvI == null)
    {
      AppMethodBeat.o(21355);
      return;
    }
    ad.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.nvI.size()) });
    o localo = new o();
    localo.ID = b.bHG().nsB;
    localo.nDE = this.nvI.size();
    localo.nDF = b.bHG().bHK().bHF();
    localo.nDG = 0;
    if (this.nvo) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.nss;; i = com.tencent.mm.plugin.backup.b.c.nsr)
    {
      localo.nDH = i;
      if (nur) {
        localo.nDD = 3;
      }
      m localm = new m();
      localm.nDr = q.aay();
      localm.nDs = Build.MANUFACTURER;
      localm.nDt = Build.MODEL;
      localm.nDu = "Android";
      localm.nDv = Build.VERSION.RELEASE;
      localm.nDw = com.tencent.mm.protocal.d.Fnj;
      localm.nDx = 0L;
      ad.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Fnj) });
      localo.nDB = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.t(localo.toByteArray(), 4, this.nvQ);
        F(this.nvL, this.nvM);
        AppMethodBeat.o(21355);
        return;
      }
      catch (IOException localIOException)
      {
        ad.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
        ad.printErrStackTrace("MicroMsg.BackupMoveServer", localIOException, "", new Object[0]);
        AppMethodBeat.o(21355);
      }
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21351);
    ad.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", new Object[] { at.fkV() });
    if (!paramBoolean) {
      bHQ();
    }
    if (this.nvK != null) {
      this.nvK.cancel();
    }
    if (this.nvJ != null)
    {
      this.nvJ.cancel();
      this.nvJ = null;
    }
    ad.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.bIC();
    com.tencent.mm.plugin.backup.g.b.bIE();
    b.bHG().bGZ();
    AppMethodBeat.o(21351);
  }
  
  public final void iC(boolean paramBoolean)
  {
    AppMethodBeat.i(21354);
    if (paramBoolean) {
      switch (this.nvS)
      {
      }
    }
    for (;;)
    {
      b.bHG().bGY();
      w localw = new w();
      localw.nEe = 0;
      localw.ID = b.bHG().nsB;
      localw.Version = com.tencent.mm.plugin.backup.b.c.nst;
      localw.nDG = 0;
      localw.nEf = this.nvO;
      localw.nCV = new com.tencent.mm.bx.b(l.e(b.bHG().nsD.getBytes(), com.tencent.mm.plugin.backup.b.d.bHb()));
      if (bt.getInt(com.tencent.mm.n.g.acA().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.nEg |= com.tencent.mm.plugin.backup.b.c.nsx;
      }
      localw.nEg |= com.tencent.mm.plugin.backup.b.c.nsy;
      localw.nEg |= com.tencent.mm.plugin.backup.b.c.nsz;
      try
      {
        ad.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.t(localw.toByteArray(), 2, this.nvR);
        AppMethodBeat.o(21354);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(21354);
      }
      nvP = false;
      nur = false;
      this.nvL = 0L;
      this.nvM = 0L;
      continue;
      nvP = false;
      this.nvL = 0L;
      this.nvM = 0L;
      continue;
      nur = false;
    }
  }
  
  public final void tF(int paramInt)
  {
    AppMethodBeat.i(21353);
    this.ntv.xp(paramInt);
    AppMethodBeat.o(21353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */