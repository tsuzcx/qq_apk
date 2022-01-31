package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.c.mf;
import com.tencent.mm.protocal.c.mi;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

public final class w
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  private byte[] esK;
  private int iny = 0;
  
  public w(int paramInt)
  {
    y.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new me();
    ((b.a)localObject).ecI = new mf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((b.a)localObject).ecG = 558;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = new atl();
    ((atl)localObject).ioI = ((String)g.DP().Dz().get(ac.a.uoW, null));
    ((atl)localObject).latitude = am.aAy().dia;
    ((atl)localObject).longitude = am.aAy().dib;
    me localme = (me)this.dmK.ecE.ecN;
    localme.sIh = 1;
    localme.sIj = ((atl)localObject);
    localme.sIk = paramInt;
    this.iny = paramInt;
  }
  
  private static boolean a(qv paramqv)
  {
    if (paramqv == null)
    {
      y.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      return false;
    }
    ??? = aa.a(paramqv.sOB);
    if ((??? == null) || (???.length == 0))
    {
      y.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      return false;
    }
    y.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(???.length), Integer.valueOf(paramqv.sOA) });
    try
    {
      switch (paramqv.sOA)
      {
      case 1: 
        y.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramqv.sOA) });
        return false;
      }
    }
    catch (Exception paramqv)
    {
      y.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramqv.getMessage() });
      return false;
    }
    ??? = (mi)new mi().aH((byte[])???);
    y.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(((mi)???).hQq) });
    switch (((mi)???).hQq)
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      for (;;)
      {
        y.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(((mi)???).sJg) });
        return false;
        paramqv = am.aAr();
        if (??? == null)
        {
          y.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
          break label477;
        }
        Object localObject2 = am.aAs().yi(((mi)???).sJe);
        String str = ((mi)???).sJe;
        if (localObject2 == null) {}
        for (long l = 0L;; l = ((CardInfo)localObject2).field_updateSeq)
        {
          y.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", new Object[] { str, Long.valueOf(l), Long.valueOf(((mi)???).sJf) });
          if ((localObject2 == null) || (((CardInfo)localObject2).field_updateSeq != ((mi)???).sJf)) {
            break;
          }
          y.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
          break label477;
        }
        localObject2 = ak.a((mi)???);
        synchronized (paramqv.dMQ)
        {
          if (!paramqv.ijT.contains(localObject2)) {}
        }
        if (paramqv.ijU.contains(localObject2)) {
          break label477;
        }
        paramqv.ijT.add(localObject2);
        y.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[] { Boolean.valueOf(am.aAt().b((com.tencent.mm.sdk.e.c)localObject2)) });
        break label477;
        break;
      }
    }
    label477:
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (me)this.dmK.ecE.ecN;
    this.esK = bk.ZM(bk.pm((String)g.DP().Dz().get(282880, null)));
    if ((this.esK == null) || (this.esK.length == 0)) {
      y.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    paramf.sIi = aa.I(this.esK);
    if (this.esK == null) {}
    for (int i = 0;; i = this.esK.length)
    {
      y.i("MicroMsg.NetSceneCardSync", "doScene, keyBuf.length = %d", new Object[] { Integer.valueOf(i) });
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q arg5, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte = (mf)this.dmK.ecF.ecN;
    if (paramArrayOfByte.sIm == 1) {
      y.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.esK = aa.a(paramArrayOfByte.sIi, new byte[0]);
    if (paramArrayOfByte.sIl == null)
    {
      ??? = null;
      label133:
      if (??? != null) {
        break label258;
      }
      paramInt1 = 0;
      label140:
      if (this.esK != null) {
        break label269;
      }
      paramInt2 = 0;
      label149:
      y.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.sFD) });
      if ((??? == null) || (???.size() <= 0)) {
        break label404;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label212:
      if (!???.hasNext()) {
        break label278;
      }
      if (a((qv)???.next())) {
        break label506;
      }
      paramInt1 += 1;
    }
    label258:
    label269:
    label278:
    label506:
    for (;;)
    {
      break label212;
      ??? = paramArrayOfByte.sIl.hPT;
      break label133;
      paramInt1 = ???.size();
      break label140;
      paramInt2 = this.esK.length;
      break label149;
      y.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.aAr().azK();
      for (;;)
      {
        g.DP().Dz().o(282880, bk.bG(this.esK));
        if (paramArrayOfByte.sFD > 0)
        {
          y.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.sFD) });
          paramInt1 = a(this.edc, this.dmL);
          if (paramInt1 > 0) {
            break;
          }
          y.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
          this.dmL.onSceneEnd(3, -1, paramString, this);
          return;
          y.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          com.tencent.mm.plugin.card.b.b localb = am.aAr();
          y.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.valueOf(true) });
          synchronized (localb.dMQ)
          {
            localb.ijT.addAll(localb.ijU);
            localb.ijU.clear();
            localb.azK();
          }
        }
      }
      this.dmL.onSceneEnd(0, 0, paramString, this);
      return;
    }
  }
  
  public final int getType()
  {
    return 558;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.w
 * JD-Core Version:    0.7.0.1
 */