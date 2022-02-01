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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static boolean mTT = false;
  public static boolean mVs = false;
  public byte[] bitmapData;
  public b.b mSX;
  public com.tencent.mm.plugin.backup.b.b.d mTO;
  public boolean mUR;
  public b.c mVg;
  public final j.a mVh;
  public LinkedList<String> mVl;
  private com.tencent.mm.plugin.backup.c.b mVm;
  public com.tencent.mm.plugin.backup.c.c mVn;
  public long mVo;
  public long mVp;
  public boolean mVq;
  public int mVr;
  private int mVt;
  private int mVu;
  private int mVv;
  public final com.tencent.mm.plugin.backup.g.b.d mVw;
  public e mVx;
  
  public d()
  {
    AppMethodBeat.i(21349);
    this.mVo = 0L;
    this.mVp = 0L;
    this.mVq = false;
    this.mVr = 0;
    this.mUR = false;
    this.mVv = 0;
    this.mVw = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21339);
        int i;
        if (paramAnonymousArrayOfByte == null)
        {
          i = -1;
          ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify isLocal:%b type:%d seq:%d buf:%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((paramAnonymousBoolean) && (paramAnonymousArrayOfByte != null) && (10011 == paramAnonymousInt1))
          {
            i = b.bDy().bCP().mSk;
            ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
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
              ac.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(bs.cw(paramAnonymousArrayOfByte)) });
              b.bDy().bCP().mSk = -5;
              d.this.tc(-5);
              AppMethodBeat.o(21339);
              return;
              i = paramAnonymousArrayOfByte.length;
              break;
              b.bDy().bDz().stop();
              b.bDy().bCP().mSk = -100;
              d.this.tc(-100);
              continue;
              b.bDy().bDz().stop();
              continue;
              d.this.cancel(true);
              b.bDy().bDz().stop();
              b.bDy().bCP().mSk = -4;
              d.this.tc(-4);
              h.wUl.idkeyStat(485L, 24L, 1L, false);
              if ((d.a(d.this) == null) || (d.a(d.this).mTa == 0L)) {
                continue;
              }
              long l = bs.Ap(d.a(d.this).mTa);
              ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(d.this).bDh()), Long.valueOf(l / 1000L) });
              continue;
              d.this.cancel(true);
              continue;
            }
            if (bs.isNullOrNil(b.bDy().mSc)) {
              b.bDy().mSc = ((v)localObject).ID;
            }
            if (!((v)localObject).ID.equals(b.bDy().mSc))
            {
              ac.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.bDy().mSc, ((v)localObject).ID });
              d.this.cancel(false);
              b.bDy().bCP().mSk = -5;
              d.this.tc(-5);
              AppMethodBeat.o(21339);
              return;
            }
            ac.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).ndH) });
            if (((v)localObject).ndH == 0)
            {
              paramAnonymousArrayOfByte = ((v)localObject).ncy.xy;
              if (!b.bDy().mSd.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bCT()))))
              {
                d.wP(paramAnonymousInt2);
                b.bDy().bCP().mSk = -5;
                d.this.tc(-5);
              }
              if (((v)localObject).Version < com.tencent.mm.plugin.backup.b.c.mRU)
              {
                ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).Version) });
                h.wUl.idkeyStat(485L, 103L, 1L, false);
                b.bDy().bCP().mSk = -12;
                d.this.tc(-12);
                AppMethodBeat.o(21339);
                return;
              }
              ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
              d.a(d.this, paramAnonymousInt2);
              if ((d.bhB()) || (d.mTT))
              {
                if ((d.bhB()) && (d.mTT) && ((((v)localObject).ndJ & com.tencent.mm.plugin.backup.b.c.mRZ) == 0) && ((((v)localObject).ndJ & com.tencent.mm.plugin.backup.b.c.mSa) == 0))
                {
                  b.bDy().bCP().mSk = -31;
                  d.this.tc(-31);
                  d.b(d.this, 1);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.bhB()) && ((((v)localObject).ndJ & com.tencent.mm.plugin.backup.b.c.mRZ) == 0))
                {
                  b.bDy().bCP().mSk = -32;
                  d.this.tc(-32);
                  d.b(d.this, 2);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.mTT) && ((((v)localObject).ndJ & com.tencent.mm.plugin.backup.b.c.mSa) == 0))
                {
                  b.bDy().bCP().mSk = -33;
                  d.this.tc(-33);
                  d.b(d.this, 3);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              d.this.it(false);
              AppMethodBeat.o(21339);
              return;
            }
            if (((v)localObject).ndH == 1)
            {
              paramAnonymousArrayOfByte = ((v)localObject).ncy.xy;
              if (!b.bDy().mSe.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bCT()))))
              {
                ac.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                b.bDy().bCP().mSk = -5;
                d.this.tc(-5);
              }
              ac.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
              b.bDy().bCP().mSk = 2;
              d.this.tc(2);
            }
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 3)
        {
          d.c(d.this, paramAnonymousInt2);
          if (b.bDy().bDC().mUs)
          {
            d.this.bDN();
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
            ac.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bs.cw(paramAnonymousArrayOfByte)) });
            AppMethodBeat.o(21339);
            return;
          }
          ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).mYY) });
          paramAnonymousArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramAnonymousArrayOfByte);
          paramAnonymousArrayOfByte.mYY = ((com.tencent.mm.plugin.backup.i.e)localObject).mYY;
          try
          {
            ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify send heartbeatResp");
            com.tencent.mm.plugin.backup.g.b.t(paramAnonymousArrayOfByte.toByteArray(), 10, paramAnonymousInt2);
            AppMethodBeat.o(21339);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ac.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify buf to BackupHeartBeatResponse err.", new Object[0]);
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
            ac.printErrStackTrace("MicroMsg.BackupMoveServer", paramAnonymousArrayOfByte, "onBackupMoveServerNotify heartbeatResp parse from buf error.", new Object[0]);
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 5)
        {
          ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive command cancel");
          d.this.cancel(true);
          b.bDy().bCP().mSk = -100;
          d.this.tc(-100);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 12)
        {
          localObject = (j)com.tencent.mm.plugin.backup.b.g.a(new j(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            ac.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(bs.cw(paramAnonymousArrayOfByte)) });
            b.bDy().bCP().mSk = -5;
            d.this.tc(-5);
            AppMethodBeat.o(21339);
            return;
          }
          paramAnonymousArrayOfByte = com.tencent.mm.plugin.backup.b.g.b(((j)localObject).ncN, ((j)localObject).ncO);
          if (paramAnonymousArrayOfByte == null) {}
          for (paramAnonymousInt1 = -1;; paramAnonymousInt1 = paramAnonymousArrayOfByte.size())
          {
            ac.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if (paramAnonymousArrayOfByte != null) {
              break;
            }
            ac.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
            d.bDI();
            b.bDy().bCP().mSk = -21;
            d.this.tc(-21);
            AppMethodBeat.o(21339);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.bEs();
          if ((d.a(d.this) == null) || (d.a(d.this).mSW)) {
            d.a(d.this, new com.tencent.mm.plugin.backup.c.c(b.bDy(), 2, d.c(d.this)));
          }
          d.a(d.this).iq(false);
          d.a(d.this).a(paramAnonymousArrayOfByte, b.bDy().bCP().mSt, d.mTT);
        }
        AppMethodBeat.o(21339);
      }
    };
    this.mSX = new b.b()
    {
      public final void bCL()
      {
        AppMethodBeat.i(21342);
        com.tencent.mm.plugin.backup.g.b.wX(21);
        AppMethodBeat.o(21342);
      }
      
      public final void bCM()
      {
        AppMethodBeat.i(21343);
        d.this.cancel(false);
        AppMethodBeat.o(21343);
      }
      
      public final void wJ(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21341);
        if (d.d(d.this) != null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21340);
              if (d.d(d.this) != null) {
                d.d(d.this).wJ(paramAnonymousInt);
              }
              AppMethodBeat.o(21340);
            }
          });
        }
        AppMethodBeat.o(21341);
      }
    };
    this.mVg = new b.c()
    {
      public final void bDM()
      {
        AppMethodBeat.i(21344);
        ac.i("MicroMsg.BackupMoveServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bEt();
        b.bDy().bCR();
        AppMethodBeat.o(21344);
      }
    };
    this.mVh = new j.a()
    {
      public final void bDK()
      {
        AppMethodBeat.i(21345);
        d.this.tc(b.bDy().bCP().mSk);
        AppMethodBeat.o(21345);
      }
      
      public final void bDL()
      {
        AppMethodBeat.i(21347);
        int i = b.bDy().bCP().mSk;
        ac.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 14) || (i == 4))
        {
          d.this.cancel(true);
          b.bDy().bDz().stop();
          b.bDy().bCP().mSk = -4;
          d.this.tc(-4);
        }
        AppMethodBeat.o(21347);
      }
      
      public final void wO(int paramAnonymousInt)
      {
        AppMethodBeat.i(21346);
        int i = b.bDy().bCP().mSk;
        if (paramAnonymousInt == 1)
        {
          if (i == 14)
          {
            ac.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
            b.bDy().bCP().mSk = 4;
            d.this.tc(4);
            AppMethodBeat.o(21346);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ac.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
          b.bDy().bCP().mSk = 14;
          d.this.tc(14);
        }
        AppMethodBeat.o(21346);
      }
    };
    this.mVx = new e(new e.a()
    {
      public final void n(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21348);
        if (paramAnonymousArrayOfByte != null) {
          d.this.bitmapData = paramAnonymousArrayOfByte;
        }
        d.this.tc(paramAnonymousInt);
        AppMethodBeat.o(21348);
      }
    }, b.bDy().bCP());
    AppMethodBeat.o(21349);
  }
  
  private void F(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21356);
    ac.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.mVl.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    i locali = new i();
    locali.ncN = this.mVl;
    locali.ncO = new LinkedList();
    Iterator localIterator = this.mVl.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.ncO.add(Long.valueOf(paramLong1));
      locali.ncO.add(Long.valueOf(paramLong2));
    }
    try
    {
      ac.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.mVl.size()) });
      com.tencent.mm.plugin.backup.g.b.L(locali.toByteArray(), 11);
      AppMethodBeat.o(21356);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
      AppMethodBeat.o(21356);
    }
  }
  
  public static void bDI()
  {
    AppMethodBeat.i(21357);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bDy().mSc;
    try
    {
      ac.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.L(locala.toByteArray(), 5);
      AppMethodBeat.o(21357);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21357);
    }
  }
  
  public static String bDO()
  {
    AppMethodBeat.i(21358);
    String str = com.tencent.mm.plugin.backup.g.b.bEw();
    AppMethodBeat.o(21358);
    return str;
  }
  
  public static void e(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(21352);
    ac.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.bDy();
    SharedPreferences.Editor localEditor = b.bCU().edit();
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
    if (paramd.equals(this.mTO)) {
      this.mTO = null;
    }
    AppMethodBeat.o(21350);
  }
  
  public final void bDN()
  {
    AppMethodBeat.i(21355);
    ac.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.mVq = false;
    b.bDy().bCP().mSk = 12;
    tc(12);
    com.tencent.mm.plugin.backup.h.d.bEP().bES();
    if (this.mVl == null)
    {
      AppMethodBeat.o(21355);
      return;
    }
    ac.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.mVl.size()) });
    o localo = new o();
    localo.ID = b.bDy().mSc;
    localo.ndh = this.mVl.size();
    localo.ndi = b.bDy().bDC().bDx();
    localo.ndj = 0;
    if (this.mUR) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.mRT;; i = com.tencent.mm.plugin.backup.b.c.mRS)
    {
      localo.ndk = i;
      if (mTT) {
        localo.ndg = 3;
      }
      m localm = new m();
      localm.ncU = q.XX();
      localm.ncV = Build.MANUFACTURER;
      localm.ncW = Build.MODEL;
      localm.ncX = "Android";
      localm.ncY = Build.VERSION.RELEASE;
      localm.ncZ = com.tencent.mm.protocal.d.DIc;
      localm.nda = 0L;
      ac.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.DIc) });
      localo.nde = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.t(localo.toByteArray(), 4, this.mVt);
        F(this.mVo, this.mVp);
        AppMethodBeat.o(21355);
        return;
      }
      catch (IOException localIOException)
      {
        ac.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
        ac.printErrStackTrace("MicroMsg.BackupMoveServer", localIOException, "", new Object[0]);
        AppMethodBeat.o(21355);
      }
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(21351);
    ac.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", new Object[] { as.eVo() });
    if (!paramBoolean) {
      bDI();
    }
    if (this.mVn != null) {
      this.mVn.cancel();
    }
    if (this.mVm != null)
    {
      this.mVm.cancel();
      this.mVm = null;
    }
    ac.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.bEt();
    com.tencent.mm.plugin.backup.g.b.bEv();
    b.bDy().bCR();
    AppMethodBeat.o(21351);
  }
  
  public final void it(boolean paramBoolean)
  {
    AppMethodBeat.i(21354);
    if (paramBoolean) {
      switch (this.mVv)
      {
      }
    }
    for (;;)
    {
      b.bDy().bCQ();
      w localw = new w();
      localw.ndH = 0;
      localw.ID = b.bDy().mSc;
      localw.Version = com.tencent.mm.plugin.backup.b.c.mRU;
      localw.ndj = 0;
      localw.ndI = this.mVr;
      localw.ncy = new com.tencent.mm.bw.b(l.e(b.bDy().mSe.getBytes(), com.tencent.mm.plugin.backup.b.d.bCT()));
      if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.ndJ |= com.tencent.mm.plugin.backup.b.c.mRY;
      }
      localw.ndJ |= com.tencent.mm.plugin.backup.b.c.mRZ;
      localw.ndJ |= com.tencent.mm.plugin.backup.b.c.mSa;
      try
      {
        ac.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.t(localw.toByteArray(), 2, this.mVu);
        AppMethodBeat.o(21354);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(21354);
      }
      mVs = false;
      mTT = false;
      this.mVo = 0L;
      this.mVp = 0L;
      continue;
      mVs = false;
      this.mVo = 0L;
      this.mVp = 0L;
      continue;
      mTT = false;
    }
  }
  
  public final void tc(int paramInt)
  {
    AppMethodBeat.i(21353);
    this.mSX.wJ(paramInt);
    AppMethodBeat.o(21353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */