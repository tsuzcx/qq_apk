package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.List;

public final class w
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private byte[] hMd;
  private int nWF;
  private final com.tencent.mm.ak.b rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(112824);
    this.nWF = 0;
    ac.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new rw();
    ((b.a)localObject).hvu = new rx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((b.a)localObject).funcId = 1047;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = new bow();
    ((bow)localObject).nYj = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFc, null));
    ((bow)localObject).latitude = am.bQo().fmX;
    ((bow)localObject).longitude = am.bQo().fmY;
    rw localrw = (rw)this.rr.hvr.hvw;
    localrw.Ekh = 1;
    localrw.Ekj = ((bow)localObject);
    localrw.Ekk = paramInt;
    this.nWF = paramInt;
    AppMethodBeat.o(112824);
  }
  
  private static boolean a(xv paramxv)
  {
    AppMethodBeat.i(112827);
    if (paramxv == null)
    {
      ac.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(112827);
      return false;
    }
    byte[] arrayOfByte = z.a(paramxv.ErM);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ac.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(112827);
      return false;
    }
    ac.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramxv.ErL) });
    try
    {
      switch (paramxv.ErL)
      {
      case 1: 
        ac.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramxv.ErL) });
        AppMethodBeat.o(112827);
        return false;
      }
    }
    catch (Exception paramxv)
    {
      ac.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramxv.getMessage() });
      AppMethodBeat.o(112827);
      return false;
    }
    paramxv = (sa)new sa().parseFrom(arrayOfByte);
    ac.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramxv.ndj) });
    switch (paramxv.ndj)
    {
    }
    for (;;)
    {
      ac.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramxv.Elf) });
      AppMethodBeat.o(112827);
      return false;
      am.bQh().a(paramxv);
      AppMethodBeat.o(112827);
      return true;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(112825);
    this.callback = paramg;
    paramg = (rw)this.rr.hvr.hvw;
    this.hMd = bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(282880, null)));
    if ((this.hMd == null) || (this.hMd.length == 0)) {
      ac.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    paramg.Eki = z.al(this.hMd);
    if (this.hMd == null) {}
    for (int i = 0;; i = this.hMd.length)
    {
      ac.i("MicroMsg.NetSceneCardSync", "doScene, keyBuf.length = %d", new Object[] { Integer.valueOf(i) });
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
    ac.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
    paramArrayOfByte = (rx)this.rr.hvs.hvw;
    if (paramArrayOfByte.Ekm == 1) {
      ac.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.hMd = z.a(paramArrayOfByte.Eki, new byte[0]);
    if (paramArrayOfByte.Ekl == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.hMd != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      ac.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.EfS) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((xv)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.Ekl.ncM;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.hMd.length;
      break label161;
      label290:
      ac.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bQh().bPv();
      for (;;)
      {
        com.tencent.mm.kernel.g.agR().agA().set(282880, bs.cx(this.hMd));
        if (paramArrayOfByte.EfS > 0)
        {
          ac.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.EfS) });
          paramInt1 = doScene(dispatcher(), this.callback);
          if (paramInt1 <= 0)
          {
            ac.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
            this.callback.onSceneEnd(3, -1, paramString, this);
          }
          AppMethodBeat.o(112826);
          return;
          label421:
          ac.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          com.tencent.mm.plugin.card.b.b localb = am.bQh();
          ac.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
          synchronized (localb.lock)
          {
            localb.pendingList.addAll(localb.nSY);
            localb.nSY.clear();
            localb.bPv();
          }
        }
      }
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.w
 * JD-Core Version:    0.7.0.1
 */