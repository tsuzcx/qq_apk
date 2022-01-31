package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.f.b;
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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
  implements b.b, com.tencent.mm.plugin.backup.g.b.d
{
  public static boolean hGZ = false;
  public static boolean hIx = false;
  public byte[] bitmapData;
  public com.tencent.mm.plugin.backup.b.b.d hGU;
  public boolean hHV = false;
  private int hIA = 0;
  public e hIB = new e(new d.4(this), b.atS().atn());
  public b.c hIl = new d.2(this);
  public final j.a hIm = new d.3(this);
  public LinkedList<String> hIq;
  private com.tencent.mm.plugin.backup.c.b hIr;
  private com.tencent.mm.plugin.backup.c.c hIs;
  public long hIt = 0L;
  public long hIu = 0L;
  public boolean hIv = false;
  public int hIw = 0;
  private int hIy;
  private int hIz;
  
  private static void auc()
  {
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.atS().hFm;
    try
    {
      y.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
      com.tencent.mm.plugin.backup.g.b.I(locala.toByteArray(), 5);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to BackupCancelRequest err.", new Object[0]);
    }
  }
  
  public static String auj()
  {
    return com.tencent.mm.plugin.backup.g.b.auP();
  }
  
  public static void d(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    y.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramLong2 = 0L;
      paramLong1 = 0L;
    }
    b.atS();
    SharedPreferences.Editor localEditor = b.ats().edit();
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", paramInt1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", paramLong1);
    localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", paramLong2);
    localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", paramInt2);
    localEditor.commit();
  }
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i;
    if (paramArrayOfByte == null)
    {
      i = -1;
      y.i("MicroMsg.BackupMoveServer", "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((paramBoolean) && (paramArrayOfByte != null) && (10011 == paramInt1))
      {
        i = b.atS().atn().hFu;
        y.i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
      }
      switch (i)
      {
      default: 
        label160:
        if (paramInt1 == 1)
        {
          localObject = (v)com.tencent.mm.plugin.backup.b.g.a(new v(), paramArrayOfByte);
          if (localObject == null)
          {
            y.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(bk.bF(paramArrayOfByte)) });
            b.atS().atn().hFu = -5;
            nt(-5);
          }
        }
        break;
      }
    }
    do
    {
      do
      {
        return;
        i = paramArrayOfByte.length;
        break;
        b.atS().atT().stop();
        b.atS().atn().hFu = -100;
        nt(-100);
        break label160;
        b.atS().atT().stop();
        break label160;
        cancel(true);
        b.atS().atT().stop();
        b.atS().atn().hFu = -4;
        nt(-4);
        h.nFQ.a(485L, 24L, 1L, false);
        if ((this.hIs == null) || (this.hIs.hGg == 0L)) {
          break label160;
        }
        long l = bk.co(this.hIs.hGg);
        y.i("MicroMsg.BackupMoveServer", "onNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(this.hIs.atB()), Long.valueOf(l / 1000L) });
        break label160;
        cancel(true);
        break label160;
        if (bk.bl(b.atS().hFm)) {
          b.atS().hFm = ((v)localObject).ID;
        }
        if (!((v)localObject).ID.equals(b.atS().hFm))
        {
          y.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.atS().hFm, ((v)localObject).ID });
          cancel(false);
          b.atS().atn().hFu = -5;
          nt(-5);
          return;
        }
        y.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).hQP) });
        if (((v)localObject).hQP == 0)
        {
          paramArrayOfByte = ((v)localObject).hPF.oY;
          if (!b.atS().hFn.equals(new String(k.a(paramArrayOfByte, com.tencent.mm.plugin.backup.b.d.atr()))))
          {
            paramArrayOfByte = new w();
            paramArrayOfByte.hQP = 0;
            paramArrayOfByte.ID = b.atS().hFm;
            paramArrayOfByte.hQq = 1;
            y.e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
          }
          try
          {
            y.i("MicroMsg.BackupMoveServer", "summerbak send authFailResp.");
            com.tencent.mm.plugin.backup.g.b.o(paramArrayOfByte.toByteArray(), 2, paramInt2);
            b.atS().atn().hFu = -5;
            nt(-5);
            if (((v)localObject).hQQ < com.tencent.mm.plugin.backup.b.c.hFe)
            {
              y.i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).hQQ) });
              h.nFQ.a(485L, 103L, 1L, false);
              b.atS().atn().hFu = -12;
              nt(-12);
              return;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.BackupMoveServer", paramArrayOfByte, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
            }
            y.i("MicroMsg.BackupMoveServer", "summerbak start move");
            this.hIz = paramInt2;
            if ((hIx) || (hGZ))
            {
              if ((hIx) && (hGZ) && ((((v)localObject).hQS & com.tencent.mm.plugin.backup.b.c.hFj) == 0) && ((((v)localObject).hQS & com.tencent.mm.plugin.backup.b.c.hFk) == 0))
              {
                b.atS().atn().hFu = -31;
                nt(-31);
                this.hIA = 1;
                return;
              }
              if ((hIx) && ((((v)localObject).hQS & com.tencent.mm.plugin.backup.b.c.hFj) == 0))
              {
                b.atS().atn().hFu = -32;
                nt(-32);
                this.hIA = 2;
                return;
              }
              if ((hGZ) && ((((v)localObject).hQS & com.tencent.mm.plugin.backup.b.c.hFk) == 0))
              {
                b.atS().atn().hFu = -33;
                nt(-33);
                this.hIA = 3;
                return;
              }
            }
            ec(false);
            return;
          }
        }
      } while (((v)localObject).hQP != 1);
      paramArrayOfByte = ((v)localObject).hPF.oY;
      if (!b.atS().hFo.equals(new String(k.a(paramArrayOfByte, com.tencent.mm.plugin.backup.b.d.atr()))))
      {
        y.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
        b.atS().atn().hFu = -5;
        nt(-5);
      }
      y.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
      b.atS().atn().hFu = 2;
      nt(2);
      return;
      if (paramInt1 == 3)
      {
        this.hIy = paramInt2;
        if (b.atS().atW().hHy)
        {
          aui();
          return;
        }
        this.hIv = true;
        return;
      }
      if (paramInt1 == 9)
      {
        localObject = (com.tencent.mm.plugin.backup.i.e)com.tencent.mm.plugin.backup.b.g.a(new com.tencent.mm.plugin.backup.i.e(), paramArrayOfByte);
        if (localObject == null)
        {
          y.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bk.bF(paramArrayOfByte)) });
          return;
        }
        y.i("MicroMsg.BackupMoveServer", "summerbak receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).hMb) });
        paramArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramArrayOfByte);
        paramArrayOfByte.hMb = ((com.tencent.mm.plugin.backup.i.e)localObject).hMb;
        try
        {
          y.i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
          com.tencent.mm.plugin.backup.g.b.o(paramArrayOfByte.toByteArray(), 10, paramInt2);
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          y.printErrStackTrace("MicroMsg.BackupMoveServer", paramArrayOfByte, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
          return;
        }
      }
      if (paramInt1 == 10)
      {
        localObject = new f();
        try
        {
          ((f)localObject).aH(paramArrayOfByte);
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          y.printErrStackTrace("MicroMsg.BackupMoveServer", paramArrayOfByte, "summerbak heartbeatResp parse from buf error.", new Object[0]);
          return;
        }
      }
      if (paramInt1 == 5)
      {
        y.i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
        cancel(true);
        b.atS().atn().hFu = -100;
        nt(-100);
        return;
      }
    } while (paramInt1 != 12);
    Object localObject = (j)com.tencent.mm.plugin.backup.b.g.a(new j(), paramArrayOfByte);
    if (localObject == null)
    {
      y.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(bk.bF(paramArrayOfByte)) });
      b.atS().atn().hFu = -5;
      nt(-5);
      return;
    }
    paramArrayOfByte = com.tencent.mm.plugin.backup.b.g.a(((j)localObject).hPU, ((j)localObject).hPV);
    if (paramArrayOfByte == null) {}
    for (paramInt1 = -1;; paramInt1 = paramArrayOfByte.size())
    {
      y.i("MicroMsg.BackupMoveServer", "summerbak backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramInt1) });
      if (paramArrayOfByte != null) {
        break;
      }
      y.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
      auc();
      b.atS().atn().hFu = -21;
      nt(-21);
      return;
    }
    com.tencent.mm.plugin.backup.g.b.auL();
    this.hIs = new com.tencent.mm.plugin.backup.c.c(b.atS(), 2, this);
    this.hIs.ea(false);
    this.hIs.a(paramArrayOfByte, b.atS().atn().hFA, hGZ);
  }
  
  public final void atj()
  {
    com.tencent.mm.plugin.backup.g.b.nG(21);
  }
  
  public final void atk()
  {
    cancel(false);
  }
  
  public final void aui()
  {
    y.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
    this.hIv = false;
    b.atS().atn().hFu = 12;
    nt(12);
    com.tencent.mm.plugin.backup.h.d.avi().avl();
    if (this.hIq == null) {
      return;
    }
    y.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[] { Integer.valueOf(this.hIq.size()) });
    Object localObject1 = new o();
    ((o)localObject1).ID = b.atS().hFm;
    ((o)localObject1).hQo = this.hIq.size();
    Object localObject2 = b.atS().atW();
    long l2;
    if (((a)localObject2).atQ() == null) {
      l2 = 0L;
    }
    for (;;)
    {
      ((o)localObject1).hQp = l2;
      ((o)localObject1).hQq = 0;
      int i;
      if (this.hHV)
      {
        i = com.tencent.mm.plugin.backup.b.c.hFd;
        ((o)localObject1).hQr = i;
        if (hGZ) {
          ((o)localObject1).hQn = 3;
        }
        localObject2 = new m();
        ((m)localObject2).hQb = q.zg();
        ((m)localObject2).hQc = Build.MANUFACTURER;
        ((m)localObject2).hQd = Build.MODEL;
        ((m)localObject2).hQe = "Android";
        ((m)localObject2).hQf = Build.VERSION.RELEASE;
        ((m)localObject2).hQg = com.tencent.mm.protocal.d.spa;
        ((m)localObject2).hQh = 0L;
        y.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.spa) });
        ((o)localObject1).hQl = ((m)localObject2);
      }
      try
      {
        com.tencent.mm.plugin.backup.g.b.o(((o)localObject1).toByteArray(), 4, this.hIy);
        long l1 = this.hIt;
        l2 = this.hIu;
        y.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(this.hIq.size()), Long.valueOf(l1), Long.valueOf(l2) });
        localObject1 = new i();
        ((i)localObject1).hPU = this.hIq;
        ((i)localObject1).hPV = new LinkedList();
        localObject2 = this.hIq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ((Iterator)localObject2).next();
          ((i)localObject1).hPV.add(Long.valueOf(l1));
          ((i)localObject1).hPV.add(Long.valueOf(l2));
          continue;
          localObject2 = ((a)localObject2).atQ().iterator();
          for (l1 = 0L;; l1 = ((f.b)((Iterator)localObject2).next()).hFG + l1)
          {
            l2 = l1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          }
          i = com.tencent.mm.plugin.backup.b.c.hFc;
        }
      }
      catch (IOException localIOException)
      {
        y.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
        y.printErrStackTrace("MicroMsg.BackupMoveServer", localIOException, "", new Object[0]);
        return;
      }
    }
    try
    {
      y.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[] { Integer.valueOf(this.hIq.size()) });
      com.tencent.mm.plugin.backup.g.b.I(localIOException.toByteArray(), 11);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
    }
  }
  
  public final void cancel(boolean paramBoolean)
  {
    y.e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", new Object[] { ak.cri() });
    if (!paramBoolean) {
      auc();
    }
    if (this.hIs != null) {
      this.hIs.cancel();
    }
    if (this.hIr != null)
    {
      this.hIr.cancel();
      this.hIr = null;
    }
    y.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
    com.tencent.mm.plugin.backup.g.b.auM();
    com.tencent.mm.plugin.backup.g.b.auO();
  }
  
  public final void ec(boolean paramBoolean)
  {
    if (paramBoolean) {
      switch (this.hIA)
      {
      }
    }
    for (;;)
    {
      w localw = new w();
      localw.hQP = 0;
      localw.ID = b.atS().hFm;
      localw.hQQ = com.tencent.mm.plugin.backup.b.c.hFe;
      localw.hQq = 0;
      localw.hQR = this.hIw;
      localw.hPF = new com.tencent.mm.bv.b(k.b(b.atS().hFo.getBytes(), com.tencent.mm.plugin.backup.b.d.atr()));
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
        localw.hQS |= com.tencent.mm.plugin.backup.b.c.hFi;
      }
      localw.hQS |= com.tencent.mm.plugin.backup.b.c.hFj;
      localw.hQS |= com.tencent.mm.plugin.backup.b.c.hFk;
      try
      {
        y.i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
        com.tencent.mm.plugin.backup.g.b.o(localw.toByteArray(), 2, this.hIz);
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.BackupMoveServer", localException, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
      }
      hIx = false;
      hGZ = false;
      this.hIt = 0L;
      this.hIu = 0L;
      continue;
      hIx = false;
      this.hIt = 0L;
      this.hIu = 0L;
      continue;
      hGZ = false;
    }
  }
  
  public final void nt(int paramInt)
  {
    if (this.hGU != null) {
      ai.d(new d.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d
 * JD-Core Version:    0.7.0.1
 */