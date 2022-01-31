package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

public final class w
  extends m
  implements k
{
  private f callback;
  private byte[] fIx;
  private int kos;
  private final com.tencent.mm.ai.b rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(87882);
    this.kos = 0;
    ab.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new pe();
    ((b.a)localObject).fsY = new pf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((b.a)localObject).funcId = 558;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = new azq();
    ((azq)localObject).kpP = ((String)g.RL().Ru().get(ac.a.yyS, null));
    ((azq)localObject).latitude = am.bcj().dZu;
    ((azq)localObject).longitude = am.bcj().dZv;
    pe localpe = (pe)this.rr.fsV.fta;
    localpe.wFQ = 1;
    localpe.wFS = ((azq)localObject);
    localpe.wFT = paramInt;
    this.kos = paramInt;
    AppMethodBeat.o(87882);
  }
  
  private static boolean a(ud paramud)
  {
    AppMethodBeat.i(87885);
    if (paramud == null)
    {
      ab.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(87885);
      return false;
    }
    byte[] arrayOfByte = aa.a(paramud.wMD);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ab.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(87885);
      return false;
    }
    ab.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramud.wMC) });
    try
    {
      switch (paramud.wMC)
      {
      case 1: 
        ab.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramud.wMC) });
        AppMethodBeat.o(87885);
        return false;
      }
    }
    catch (Exception paramud)
    {
      ab.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramud.getMessage() });
      AppMethodBeat.o(87885);
      return false;
    }
    paramud = (pi)new pi().parseFrom(arrayOfByte);
    ab.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramud.jJS) });
    switch (paramud.jJS)
    {
    }
    for (;;)
    {
      ab.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramud.wGP) });
      AppMethodBeat.o(87885);
      return false;
      am.bcc().a(paramud);
      AppMethodBeat.o(87885);
      return true;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(87883);
    this.callback = paramf;
    paramf = (pe)this.rr.fsV.fta;
    this.fIx = bo.apQ(bo.nullAsNil((String)g.RL().Ru().get(282880, null)));
    if ((this.fIx == null) || (this.fIx.length == 0)) {
      ab.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    paramf.wFR = aa.ac(this.fIx);
    if (this.fIx == null) {}
    for (int i = 0;; i = this.fIx.length)
    {
      ab.i("MicroMsg.NetSceneCardSync", "doScene, keyBuf.length = %d", new Object[] { Integer.valueOf(i) });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(87883);
      return i;
    }
  }
  
  public final int getType()
  {
    return 558;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q arg5, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87884);
    ab.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(87884);
      return;
    }
    paramArrayOfByte = (pf)this.rr.fsW.fta;
    if (paramArrayOfByte.wFV == 1) {
      ab.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.fIx = aa.a(paramArrayOfByte.wFR, new byte[0]);
    if (paramArrayOfByte.wFU == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.fIx != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      ab.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.wBX) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((ud)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.wFU.jJv;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.fIx.length;
      break label161;
      label290:
      ab.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bcc().bbq();
      for (;;)
      {
        g.RL().Ru().set(282880, bo.cg(this.fIx));
        if (paramArrayOfByte.wBX > 0)
        {
          ab.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.wBX) });
          paramInt1 = doScene(dispatcher(), this.callback);
          if (paramInt1 <= 0)
          {
            ab.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
            this.callback.onSceneEnd(3, -1, paramString, this);
          }
          AppMethodBeat.o(87884);
          return;
          label421:
          ab.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          com.tencent.mm.plugin.card.b.b localb = am.bcc();
          ab.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
          synchronized (localb.eKs)
          {
            localb.pendingList.addAll(localb.kkT);
            localb.kkT.clear();
            localb.bbq();
          }
        }
      }
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(87884);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.w
 * JD-Core Version:    0.7.0.1
 */