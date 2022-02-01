package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.List;

public final class w
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private byte[] hlA;
  private int ntF;
  private final com.tencent.mm.al.b rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(112824);
    this.ntF = 0;
    ad.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new rm();
    ((b.a)localObject).gUV = new rn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((b.a)localObject).funcId = 1047;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = new bla();
    ((bla)localObject).nvj = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhn, null));
    ((bla)localObject).latitude = am.bJb().fjD;
    ((bla)localObject).longitude = am.bJb().fjE;
    rm localrm = (rm)this.rr.gUS.gUX;
    localrm.CRw = 1;
    localrm.CRy = ((bla)localObject);
    localrm.CRz = paramInt;
    this.ntF = paramInt;
    AppMethodBeat.o(112824);
  }
  
  private static boolean a(xd paramxd)
  {
    AppMethodBeat.i(112827);
    if (paramxd == null)
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(112827);
      return false;
    }
    byte[] arrayOfByte = z.a(paramxd.CYZ);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(112827);
      return false;
    }
    ad.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramxd.CYY) });
    try
    {
      switch (paramxd.CYY)
      {
      case 1: 
        ad.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramxd.CYY) });
        AppMethodBeat.o(112827);
        return false;
      }
    }
    catch (Exception paramxd)
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramxd.getMessage() });
      AppMethodBeat.o(112827);
      return false;
    }
    paramxd = (rq)new rq().parseFrom(arrayOfByte);
    ad.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramxd.mBi) });
    switch (paramxd.mBi)
    {
    }
    for (;;)
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramxd.CSu) });
      AppMethodBeat.o(112827);
      return false;
      am.bIU().a(paramxd);
      AppMethodBeat.o(112827);
      return true;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(112825);
    this.callback = paramg;
    paramg = (rm)this.rr.gUS.gUX;
    this.hlA = bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(282880, null)));
    if ((this.hlA == null) || (this.hlA.length == 0)) {
      ad.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    paramg.CRx = z.am(this.hlA);
    if (this.hlA == null) {}
    for (int i = 0;; i = this.hlA.length)
    {
      ad.i("MicroMsg.NetSceneCardSync", "doScene, keyBuf.length = %d", new Object[] { Integer.valueOf(i) });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(112825);
      return i;
    }
  }
  
  public final int getType()
  {
    return 1047;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q arg5, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112826);
    ad.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
    paramArrayOfByte = (rn)this.rr.gUT.gUX;
    if (paramArrayOfByte.CRB == 1) {
      ad.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.hlA = z.a(paramArrayOfByte.CRx, new byte[0]);
    if (paramArrayOfByte.CRA == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.hlA != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      ad.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.CNq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((xd)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.CRA.mAL;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.hlA.length;
      break label161;
      label290:
      ad.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bIU().bIi();
      for (;;)
      {
        com.tencent.mm.kernel.g.afB().afk().set(282880, bt.cy(this.hlA));
        if (paramArrayOfByte.CNq > 0)
        {
          ad.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.CNq) });
          paramInt1 = doScene(dispatcher(), this.callback);
          if (paramInt1 <= 0)
          {
            ad.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
            this.callback.onSceneEnd(3, -1, paramString, this);
          }
          AppMethodBeat.o(112826);
          return;
          label421:
          ad.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          com.tencent.mm.plugin.card.b.b localb = am.bIU();
          ad.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
          synchronized (localb.lock)
          {
            localb.pendingList.addAll(localb.npY);
            localb.npY.clear();
            localb.bIi();
          }
        }
      }
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.w
 * JD-Core Version:    0.7.0.1
 */