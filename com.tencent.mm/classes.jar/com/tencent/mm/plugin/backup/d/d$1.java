package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class d$1
  implements b.d
{
  d$1(d paramd) {}
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(153489);
    int i;
    if (paramArrayOfByte == null)
    {
      i = -1;
      ab.i("MicroMsg.BackupMoveServer", "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((paramBoolean) && (paramArrayOfByte != null) && (10011 == paramInt1))
      {
        i = b.aTr().aSL().jyN;
        ab.i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
      }
    }
    Object localObject;
    for (;;)
    {
      if (paramInt1 == 1)
      {
        localObject = (v)g.a(new v(), paramArrayOfByte);
        if (localObject == null)
        {
          ab.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[] { Integer.valueOf(bo.cf(paramArrayOfByte)) });
          b.aTr().aSL().jyN = -5;
          this.jCb.rl(-5);
          AppMethodBeat.o(153489);
          return;
          i = paramArrayOfByte.length;
          break;
          b.aTr().aTs().stop();
          b.aTr().aSL().jyN = -100;
          this.jCb.rl(-100);
          continue;
          b.aTr().aTs().stop();
          continue;
          this.jCb.cancel(true);
          b.aTr().aTs().stop();
          b.aTr().aSL().jyN = -4;
          this.jCb.rl(-4);
          h.qsU.idkeyStat(485L, 24L, 1L, false);
          if ((d.a(this.jCb) == null) || (d.a(this.jCb).jzC == 0L)) {
            continue;
          }
          long l = bo.hl(d.a(this.jCb).jzC);
          ab.i("MicroMsg.BackupMoveServer", "onNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[] { Long.valueOf(d.a(this.jCb).aSZ()), Long.valueOf(l / 1000L) });
          continue;
          this.jCb.cancel(true);
          continue;
        }
        if (bo.isNullOrNil(b.aTr().jyF)) {
          b.aTr().jyF = ((v)localObject).ID;
        }
        if (!((v)localObject).ID.equals(b.aTr().jyF))
        {
          ab.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[] { b.aTr().jyF, ((v)localObject).ID });
          this.jCb.cancel(false);
          b.aTr().aSL().jyN = -5;
          this.jCb.rl(-5);
          AppMethodBeat.o(153489);
          return;
        }
        ab.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[] { ((v)localObject).ID, Integer.valueOf(((v)localObject).jKr) });
        if (((v)localObject).jKr == 0)
        {
          paramArrayOfByte = ((v)localObject).jJh.pW;
          if (!b.aTr().jyG.equals(new String(l.c(paramArrayOfByte, com.tencent.mm.plugin.backup.b.d.aSP()))))
          {
            d.rm(paramInt2);
            b.aTr().aSL().jyN = -5;
            this.jCb.rl(-5);
          }
          if (((v)localObject).Version < com.tencent.mm.plugin.backup.b.c.jyx)
          {
            ab.i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", new Object[] { Integer.valueOf(((v)localObject).Version) });
            h.qsU.idkeyStat(485L, 103L, 1L, false);
            b.aTr().aSL().jyN = -12;
            this.jCb.rl(-12);
            AppMethodBeat.o(153489);
            return;
          }
          ab.i("MicroMsg.BackupMoveServer", "summerbak start move");
          d.a(this.jCb, paramInt2);
          if ((d.aTJ()) || (d.access$400()))
          {
            if ((d.aTJ()) && (d.access$400()) && ((((v)localObject).jKt & com.tencent.mm.plugin.backup.b.c.jyC) == 0) && ((((v)localObject).jKt & com.tencent.mm.plugin.backup.b.c.jyD) == 0))
            {
              b.aTr().aSL().jyN = -31;
              this.jCb.rl(-31);
              d.b(this.jCb, 1);
              AppMethodBeat.o(153489);
              return;
            }
            if ((d.aTJ()) && ((((v)localObject).jKt & com.tencent.mm.plugin.backup.b.c.jyC) == 0))
            {
              b.aTr().aSL().jyN = -32;
              this.jCb.rl(-32);
              d.b(this.jCb, 2);
              AppMethodBeat.o(153489);
              return;
            }
            if ((d.access$400()) && ((((v)localObject).jKt & com.tencent.mm.plugin.backup.b.c.jyD) == 0))
            {
              b.aTr().aSL().jyN = -33;
              this.jCb.rl(-33);
              d.b(this.jCb, 3);
              AppMethodBeat.o(153489);
              return;
            }
          }
          this.jCb.fz(false);
          AppMethodBeat.o(153489);
          return;
        }
        if (((v)localObject).jKr == 1)
        {
          paramArrayOfByte = ((v)localObject).jJh.pW;
          if (!b.aTr().jyH.equals(new String(l.c(paramArrayOfByte, com.tencent.mm.plugin.backup.b.d.aSP()))))
          {
            ab.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
            b.aTr().aSL().jyN = -5;
            this.jCb.rl(-5);
          }
          ab.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
          b.aTr().aSL().jyN = 2;
          this.jCb.rl(2);
        }
        AppMethodBeat.o(153489);
        return;
      }
    }
    if (paramInt1 == 3)
    {
      d.c(this.jCb, paramInt2);
      if (b.aTr().aTv().jAU)
      {
        this.jCb.aTH();
        AppMethodBeat.o(153489);
        return;
      }
      d.b(this.jCb);
      AppMethodBeat.o(153489);
      return;
    }
    if (paramInt1 == 9)
    {
      localObject = (com.tencent.mm.plugin.backup.i.e)g.a(new com.tencent.mm.plugin.backup.i.e(), paramArrayOfByte);
      if (localObject == null)
      {
        ab.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[] { Integer.valueOf(bo.cf(paramArrayOfByte)) });
        AppMethodBeat.o(153489);
        return;
      }
      ab.i("MicroMsg.BackupMoveServer", "summerbak receive heartbeatReq,req:%s ack:%d", new Object[] { localObject, Long.valueOf(((com.tencent.mm.plugin.backup.i.e)localObject).jFD) });
      paramArrayOfByte = (f)g.a(new f(), paramArrayOfByte);
      paramArrayOfByte.jFD = ((com.tencent.mm.plugin.backup.i.e)localObject).jFD;
      try
      {
        ab.i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
        com.tencent.mm.plugin.backup.g.b.r(paramArrayOfByte.toByteArray(), 10, paramInt2);
        AppMethodBeat.o(153489);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.BackupMoveServer", paramArrayOfByte, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
        AppMethodBeat.o(153489);
        return;
      }
    }
    if (paramInt1 == 10)
    {
      localObject = new f();
      try
      {
        ((f)localObject).parseFrom(paramArrayOfByte);
        AppMethodBeat.o(153489);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.BackupMoveServer", paramArrayOfByte, "summerbak heartbeatResp parse from buf error.", new Object[0]);
        AppMethodBeat.o(153489);
        return;
      }
    }
    if (paramInt1 == 5)
    {
      ab.i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
      this.jCb.cancel(true);
      b.aTr().aSL().jyN = -100;
      this.jCb.rl(-100);
      AppMethodBeat.o(153489);
      return;
    }
    if (paramInt1 == 12)
    {
      localObject = (j)g.a(new j(), paramArrayOfByte);
      if (localObject == null)
      {
        ab.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[] { Integer.valueOf(bo.cf(paramArrayOfByte)) });
        b.aTr().aSL().jyN = -5;
        this.jCb.rl(-5);
        AppMethodBeat.o(153489);
        return;
      }
      paramArrayOfByte = g.b(((j)localObject).jJw, ((j)localObject).jJx);
      if (paramArrayOfByte == null) {}
      for (paramInt1 = -1;; paramInt1 = paramArrayOfByte.size())
      {
        ab.i("MicroMsg.BackupMoveServer", "summerbak backup receive requestsession response. backupSessionList:%d ", new Object[] { Integer.valueOf(paramInt1) });
        if (paramArrayOfByte != null) {
          break;
        }
        ab.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
        d.aTB();
        b.aTr().aSL().jyN = -21;
        this.jCb.rl(-21);
        AppMethodBeat.o(153489);
        return;
      }
      com.tencent.mm.plugin.backup.g.b.aUn();
      d.a(this.jCb).fx(false);
      d.a(this.jCb).a(paramArrayOfByte, b.aTr().aSL().jyV, d.access$400());
    }
    AppMethodBeat.o(153489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d.1
 * JD-Core Version:    0.7.0.1
 */