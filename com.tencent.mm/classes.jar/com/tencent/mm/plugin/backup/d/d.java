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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static boolean mrR = false;
  public static boolean mtq = false;
  public byte[] bitmapData;
  public b.b mqV;
  public com.tencent.mm.plugin.backup.b.b.d mrM;
  public boolean msP;
  public b.c mte;
  public final j.a mtf;
  public LinkedList<String> mtj;
  private com.tencent.mm.plugin.backup.c.b mtk;
  public com.tencent.mm.plugin.backup.c.c mtl;
  public long mtm;
  public long mtn;
  public boolean mto;
  public int mtp;
  private int mtr;
  private int mts;
  private int mtt;
  public final com.tencent.mm.plugin.backup.g.b.d mtu;
  public e mtv;
  
  public d()
  {
    AppMethodBeat.i(21349);
    this.mtm = 0L;
    this.mtn = 0L;
    this.mto = false;
    this.mtp = 0;
    this.msP = false;
    this.mtt = 0;
    this.mtu = new com.tencent.mm.plugin.backup.g.b.d()
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
            i = b.bwC().bvT().mqj;
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
              ad.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cx(paramAnonymousArrayOfByte)) });
              b.bwC().bvT().mqj = -5;
              d.this.sm(-5);
              AppMethodBeat.o(21339);
              return;
              i = paramAnonymousArrayOfByte.length;
              break;
              b.bwC().bwD().stop();
              b.bwC().bvT().mqj = -100;
              d.this.sm(-100);
              continue;
              b.bwC().bwD().stop();
              continue;
              d.this.cancel(true);
              b.bwC().bwD().stop();
              b.bwC().bvT().mqj = -4;
              d.this.sm(-4);
              h.vKh.idkeyStat(485L, 24L, 1L, false);
              if ((d.a(d.this) == null) || (d.a(d.this).mqY == 0L)) {
                continue;
              }
              long l = bt.vM(d.a(d.this).mqY);
              ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(d.this).bwl()), Long.valueOf(l / 1000L) });
              continue;
              d.this.cancel(true);
              continue;
            }
            if (bt.isNullOrNil(b.bwC().mqb)) {
              b.bwC().mqb = ((v)localObject).ID;
            }
            if (!((v)localObject).ID.equals(b.bwC().mqb))
            {
              ad.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.bwC().mqb, ((v)localObject).ID });
              d.this.cancel(false);
              b.bwC().bvT().mqj = -5;
              d.this.sm(-5);
              AppMethodBeat.o(21339);
              return;
            }
            ad.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).mBG) });
            if (((v)localObject).mBG == 0)
            {
              paramAnonymousArrayOfByte = ((v)localObject).mAx.wA;
              if (!b.bwC().mqc.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bvX()))))
              {
                d.vY(paramAnonymousInt2);
                b.bwC().bvT().mqj = -5;
                d.this.sm(-5);
              }
              if (((v)localObject).Version < com.tencent.mm.plugin.backup.b.c.mpT)
              {
                ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).Version) });
                h.vKh.idkeyStat(485L, 103L, 1L, false);
                b.bwC().bvT().mqj = -12;
                d.this.sm(-12);
                AppMethodBeat.o(21339);
                return;
              }
              ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
              d.a(d.this, paramAnonymousInt2);
              if ((d.baI()) || (d.mrR))
              {
                if ((d.baI()) && (d.mrR) && ((((v)localObject).mBI & com.tencent.mm.plugin.backup.b.c.mpY) == 0) && ((((v)localObject).mBI & com.tencent.mm.plugin.backup.b.c.mpZ) == 0))
                {
                  b.bwC().bvT().mqj = -31;
                  d.this.sm(-31);
                  d.b(d.this, 1);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.baI()) && ((((v)localObject).mBI & com.tencent.mm.plugin.backup.b.c.mpY) == 0))
                {
                  b.bwC().bvT().mqj = -32;
                  d.this.sm(-32);
                  d.b(d.this, 2);
                  AppMethodBeat.o(21339);
                  return;
                }
                if ((d.mrR) && ((((v)localObject).mBI & com.tencent.mm.plugin.backup.b.c.mpZ) == 0))
                {
                  b.bwC().bvT().mqj = -33;
                  d.this.sm(-33);
                  d.b(d.this, 3);
                  AppMethodBeat.o(21339);
                  return;
                }
              }
              d.this.hT(false);
              AppMethodBeat.o(21339);
              return;
            }
            if (((v)localObject).mBG == 1)
            {
              paramAnonymousArrayOfByte = ((v)localObject).mAx.wA;
              if (!b.bwC().mqd.equals(new String(l.d(paramAnonymousArrayOfByte, com.tencent.mm.plugin.backup.b.d.bvX()))))
              {
                ad.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                b.bwC().bvT().mqj = -5;
                d.this.sm(-5);
              }
              ad.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
              b.bwC().bvT().mqj = 2;
              d.this.sm(2);
            }
            AppMethodBeat.o(21339);
            return;
          }
        }
        if (paramAnonymousInt1 == 3)
        {
          d.c(d.this, paramAnonymousInt2);
          if (b.bwC().bwG().msr)
          {
            d.this.bwR();
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
            ad.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cx(paramAnonymousArrayOfByte)) });
            AppMethodBeat.o(21339);
            return;
          }
          ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).mwX) });
          paramAnonymousArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramAnonymousArrayOfByte);
          paramAnonymousArrayOfByte.mwX = ((com.tencent.mm.plugin.backup.i.e)localObject).mwX;
          try
          {
            ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify send heartbeatResp");
            com.tencent.mm.plugin.backup.g.b.u(paramAnonymousArrayOfByte.toByteArray(), 10, paramAnonymousInt2);
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
          b.bwC().bvT().mqj = -100;
          d.this.sm(-100);
          AppMethodBeat.o(21339);
          return;
        }
        if (paramAnonymousInt1 == 12)
        {
          localObject = (j)com.tencent.mm.plugin.backup.b.g.a(new j(), paramAnonymousArrayOfByte);
          if (localObject == null)
          {
            ad.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(bt.cx(paramAnonymousArrayOfByte)) });
            b.bwC().bvT().mqj = -5;
            d.this.sm(-5);
            AppMethodBeat.o(21339);
            return;
          }
          paramAnonymousArrayOfByte = com.tencent.mm.plugin.backup.b.g.b(((j)localObject).mAM, ((j)localObject).mAN);
          if (paramAnonymousArrayOfByte == null) {}
          for (paramAnonymousInt1 = -1;; paramAnonymousInt1 = paramAnonymousArrayOfByte.size())
          {
            ad.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            if (paramAnonymousArrayOfByte != null) {
              break;
            }
            ad.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
            d.bwM();
            b.bwC().bvT().mqj = -21;
            d.this.sm(-21);
            AppMethodBeat.o(21339);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.bxw();
          if ((d.a(d.this) == null) || (d.a(d.this).mqU)) {
            d.a(d.this, new com.tencent.mm.plugin.backup.c.c(b.bwC(), 2, d.c(d.this)));
          }
          d.a(d.this).hQ(false);
          d.a(d.this).a(paramAnonymousArrayOfByte, b.bwC().bvT().mqr, d.mrR);
        }
        AppMethodBeat.o(21339);
      }
    };
    this.mqV = new b.b()
    {
      public final void bvP()
      {
        AppMethodBeat.i(21342);
        com.tencent.mm.plugin.backup.g.b.wg(21);
        AppMethodBeat.o(21342);
      }
      
      public final void bvQ()
      {
        AppMethodBeat.i(21343);
        d.this.cancel(false);
        AppMethodBeat.o(21343);
      }
      
      public final void vS(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21341);
        if (d.d(d.this) != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21340);
              if (d.d(d.this) != null) {
                d.d(d.this).vS(paramAnonymousInt);
              }
              AppMethodBeat.o(21340);
            }
          });
        }
        AppMethodBeat.o(21341);
      }
    };
    this.mte = new b.c()
    {
      public final void bwQ()
      {
        AppMethodBeat.i(21344);
        ad.i("MicroMsg.BackupMoveServer", "stopCallback ");
        com.tencent.mm.plugin.backup.g.b.bxx();
        b.bwC().bvV();
        AppMethodBeat.o(21344);
      }
    };
    this.mtf = new j.a()
    {
      public final void bwO()
      {
        AppMethodBeat.i(21345);
        d.this.sm(b.bwC().bvT().mqj);
        AppMethodBeat.o(21345);
      }
      
      public final void bwP()
      {
        AppMethodBeat.i(21347);
        int i = b.bwC().bvT().mqj;
        ad.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", new Object[] { Integer.valueOf(i) });
        if ((i == 14) || (i == 4))
        {
          d.this.cancel(true);
          b.bwC().bwD().stop();
          b.bwC().bvT().mqj = -4;
          d.this.sm(-4);
        }
        AppMethodBeat.o(21347);
      }
      
      public final void vX(int paramAnonymousInt)
      {
        AppMethodBeat.i(21346);
        int i = b.bwC().bvT().mqj;
        if (paramAnonymousInt == 1)
        {
          if (i == 14)
          {
            ad.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
            b.bwC().bvT().mqj = 4;
            d.this.sm(4);
            AppMethodBeat.o(21346);
          }
        }
        else if ((paramAnonymousInt == 0) && (i == 4))
        {
          ad.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
          b.bwC().bvT().mqj = 14;
          d.this.sm(14);
        }
        AppMethodBeat.o(21346);
      }
    };
    this.mtv = new e(new e.a()
    {
      public final void n(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21348);
        if (paramAnonymousArrayOfByte != null) {
          d.this.bitmapData = paramAnonymousArrayOfByte;
        }
        d.this.sm(paramAnonymousInt);
        AppMethodBeat.o(21348);
      }
    }, b.bwC().bvT());
    AppMethodBeat.o(21349);
  }
  
  private void J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21356);
    ad.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.mtj.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    i locali = new i();
    locali.mAM = this.mtj;
    locali.mAN = new LinkedList();
    Iterator localIterator = this.mtj.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      locali.mAN.add(Long.valueOf(paramLong1));
      locali.mAN.add(Long.valueOf(paramLong2));
    }
    try
    {
      ad.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.mtj.size()) });
      com.tencent.mm.plugin.backup.g.b.N(locali.toByteArray(), 11);
      AppMethodBeat.o(21356);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
      AppMethodBeat.o(21356);
    }
  }
  
  public static void bwM()
  {
    AppMethodBeat.i(21357);
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.bwC().mqb;
    try
    {
      ad.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.N(locala.toByteArray(), 5);
      AppMethodBeat.o(21357);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
      AppMethodBeat.o(21357);
    }
  }
  
  public static String bwS()
  {
    AppMethodBeat.i(21358);
    String str = com.tencent.mm.plugin.backup.g.b.bxA();
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
    b.bwC();
    SharedPreferences.Editor localEditor = b.bvY().edit();
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
    if (paramd.equals(this.mrM)) {
      this.mrM = null;
    }
    AppMethodBeat.o(21350);
  }
  
  public final void bwR()
  {
    AppMethodBeat.i(21355);
    ad.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.mto = false;
    b.bwC().bvT().mqj = 12;
    sm(12);
    com.tencent.mm.plugin.backup.h.d.bxT().bxW();
    if (this.mtj == null)
    {
      AppMethodBeat.o(21355);
      return;
    }
    ad.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.mtj.size()) });
    o localo = new o();
    localo.ID = b.bwC().mqb;
    localo.mBg = this.mtj.size();
    localo.mBh = b.bwC().bwG().bwB();
    localo.mBi = 0;
    if (this.msP) {}
    for (int i = com.tencent.mm.plugin.backup.b.c.mpS;; i = com.tencent.mm.plugin.backup.b.c.mpR)
    {
      localo.mBj = i;
      if (mrR) {
        localo.mBf = 3;
      }
      m localm = new m();
      localm.mAT = q.Xa();
      localm.mAU = Build.MANUFACTURER;
      localm.mAV = Build.MODEL;
      localm.mAW = "Android";
      localm.mAX = Build.VERSION.RELEASE;
      localm.mAY = com.tencent.mm.protocal.d.CpK;
      localm.mAZ = 0L;
      ad.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.CpK) });
      localo.mBd = localm;
      try
      {
        com.tencent.mm.plugin.backup.g.b.u(localo.toByteArray(), 4, this.mtr);
        J(this.mtm, this.mtn);
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
    ad.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", new Object[] { at.eFT() });
    if (!paramBoolean) {
      bwM();
    }
    if (this.mtl != null) {
      this.mtl.cancel();
    }
    if (this.mtk != null)
    {
      this.mtk.cancel();
      this.mtk = null;
    }
    ad.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.bxx();
    com.tencent.mm.plugin.backup.g.b.bxz();
    b.bwC().bvV();
    AppMethodBeat.o(21351);
  }
  
  public final void hT(boolean paramBoolean)
  {
    AppMethodBeat.i(21354);
    if (paramBoolean) {
      switch (this.mtt)
      {
      }
    }
    for (;;)
    {
      b.bwC().bvU();
      w localw = new w();
      localw.mBG = 0;
      localw.ID = b.bwC().mqb;
      localw.Version = com.tencent.mm.plugin.backup.b.c.mpT;
      localw.mBi = 0;
      localw.mBH = this.mtp;
      localw.mAx = new com.tencent.mm.bx.b(l.e(b.bwC().mqd.getBytes(), com.tencent.mm.plugin.backup.b.d.bvX()));
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.mBI |= com.tencent.mm.plugin.backup.b.c.mpX;
      }
      localw.mBI |= com.tencent.mm.plugin.backup.b.c.mpY;
      localw.mBI |= com.tencent.mm.plugin.backup.b.c.mpZ;
      try
      {
        ad.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.u(localw.toByteArray(), 2, this.mts);
        AppMethodBeat.o(21354);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        AppMethodBeat.o(21354);
      }
      mtq = false;
      mrR = false;
      this.mtm = 0L;
      this.mtn = 0L;
      continue;
      mtq = false;
      this.mtm = 0L;
      this.mtn = 0L;
      continue;
      mrR = false;
    }
  }
  
  public final void sm(int paramInt)
  {
    AppMethodBeat.i(21353);
    this.mqV.vS(paramInt);
    AppMethodBeat.o(21353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */