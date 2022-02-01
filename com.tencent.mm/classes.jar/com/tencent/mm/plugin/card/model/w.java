package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.List;

public final class w
  extends n
  implements k
{
  private f callback;
  private byte[] ieX;
  private int ozZ;
  private final com.tencent.mm.al.b rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(112824);
    this.ozZ = 0;
    ad.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new tq();
    ((b.a)localObject).hNN = new tr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((b.a)localObject).funcId = 1047;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = new btj();
    ((btj)localObject).oBD = ((String)g.ajC().ajl().get(al.a.Iru, null));
    ((btj)localObject).latitude = am.bUT().fFf;
    ((btj)localObject).longitude = am.bUT().fFg;
    tq localtq = (tq)this.rr.hNK.hNQ;
    localtq.FRq = 1;
    localtq.FRs = ((btj)localObject);
    localtq.FRt = paramInt;
    this.ozZ = paramInt;
    AppMethodBeat.o(112824);
  }
  
  private static boolean a(zu paramzu)
  {
    AppMethodBeat.i(112827);
    if (paramzu == null)
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(112827);
      return false;
    }
    byte[] arrayOfByte = z.a(paramzu.FYV);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(112827);
      return false;
    }
    ad.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramzu.FYU) });
    try
    {
      switch (paramzu.FYU)
      {
      case 1: 
        ad.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramzu.FYU) });
        AppMethodBeat.o(112827);
        return false;
      }
    }
    catch (Exception paramzu)
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramzu.getMessage() });
      AppMethodBeat.o(112827);
      return false;
    }
    paramzu = (tu)new tu().parseFrom(arrayOfByte);
    ad.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramzu.nDG) });
    switch (paramzu.nDG)
    {
    }
    for (;;)
    {
      ad.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramzu.FSn) });
      AppMethodBeat.o(112827);
      return false;
      am.bUM().a(paramzu);
      AppMethodBeat.o(112827);
      return true;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112825);
    this.callback = paramf;
    paramf = (tq)this.rr.hNK.hNQ;
    this.ieX = bt.aRa(bt.nullAsNil((String)g.ajC().ajl().get(282880, null)));
    if ((this.ieX == null) || (this.ieX.length == 0)) {
      ad.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    paramf.FRr = z.al(this.ieX);
    if (this.ieX == null) {}
    for (int i = 0;; i = this.ieX.length)
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
    paramArrayOfByte = (tr)this.rr.hNL.hNQ;
    if (paramArrayOfByte.FRv == 1) {
      ad.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.ieX = z.a(paramArrayOfByte.FRr, new byte[0]);
    if (paramArrayOfByte.FRu == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.ieX != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      ad.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.FMr) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((zu)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.FRu.nDj;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.ieX.length;
      break label161;
      label290:
      ad.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bUM().bUa();
      for (;;)
      {
        g.ajC().ajl().set(282880, bt.cE(this.ieX));
        if (paramArrayOfByte.FMr > 0)
        {
          ad.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.FMr) });
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
          com.tencent.mm.plugin.card.b.b localb = am.bUM();
          ad.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
          synchronized (localb.lock)
          {
            localb.pendingList.addAll(localb.owt);
            localb.owt.clear();
            localb.bUa();
          }
        }
      }
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.w
 * JD-Core Version:    0.7.0.1
 */