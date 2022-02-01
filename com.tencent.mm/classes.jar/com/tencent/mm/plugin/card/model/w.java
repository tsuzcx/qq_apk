package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.List;

public final class w
  extends n
  implements k
{
  private f callback;
  private byte[] ihP;
  private int oGB;
  private final com.tencent.mm.ak.b rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(112824);
    this.oGB = 0;
    ae.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ts();
    ((b.a)localObject).hQG = new tt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((b.a)localObject).funcId = 1047;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = new bud();
    ((bud)localObject).oIf = ((String)g.ajR().ajA().get(am.a.ILQ, null));
    ((bud)localObject).latitude = am.bWi().fHj;
    ((bud)localObject).longitude = am.bWi().fHk;
    ts localts = (ts)this.rr.hQD.hQJ;
    localts.GjP = 1;
    localts.GjR = ((bud)localObject);
    localts.GjS = paramInt;
    this.oGB = paramInt;
    AppMethodBeat.o(112824);
  }
  
  private static boolean a(zx paramzx)
  {
    AppMethodBeat.i(112827);
    if (paramzx == null)
    {
      ae.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(112827);
      return false;
    }
    byte[] arrayOfByte = z.a(paramzx.Grv);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      ae.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(112827);
      return false;
    }
    ae.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramzx.Gru) });
    try
    {
      switch (paramzx.Gru)
      {
      case 1: 
        ae.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramzx.Gru) });
        AppMethodBeat.o(112827);
        return false;
      }
    }
    catch (Exception paramzx)
    {
      ae.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramzx.getMessage() });
      AppMethodBeat.o(112827);
      return false;
    }
    paramzx = (tw)new tw().parseFrom(arrayOfByte);
    ae.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramzx.nJb) });
    switch (paramzx.nJb)
    {
    }
    for (;;)
    {
      ae.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramzx.GkM) });
      AppMethodBeat.o(112827);
      return false;
      am.bWb().a(paramzx);
      AppMethodBeat.o(112827);
      return true;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112825);
    this.callback = paramf;
    paramf = (ts)this.rr.hQD.hQJ;
    this.ihP = bu.aSx(bu.nullAsNil((String)g.ajR().ajA().get(282880, null)));
    if ((this.ihP == null) || (this.ihP.length == 0)) {
      ae.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    paramf.GjQ = z.al(this.ihP);
    if (this.ihP == null) {}
    for (int i = 0;; i = this.ihP.length)
    {
      ae.i("MicroMsg.NetSceneCardSync", "doScene, keyBuf.length = %d", new Object[] { Integer.valueOf(i) });
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
    ae.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
    paramArrayOfByte = (tt)this.rr.hQE.hQJ;
    if (paramArrayOfByte.GjU == 1) {
      ae.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.ihP = z.a(paramArrayOfByte.GjQ, new byte[0]);
    if (paramArrayOfByte.GjT == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.ihP != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      ae.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.GeQ) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((zx)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.GjT.nIE;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.ihP.length;
      break label161;
      label290:
      ae.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bWb().bVp();
      for (;;)
      {
        g.ajR().ajA().set(282880, bu.cH(this.ihP));
        if (paramArrayOfByte.GeQ > 0)
        {
          ae.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.GeQ) });
          paramInt1 = doScene(dispatcher(), this.callback);
          if (paramInt1 <= 0)
          {
            ae.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
            this.callback.onSceneEnd(3, -1, paramString, this);
          }
          AppMethodBeat.o(112826);
          return;
          label421:
          ae.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          com.tencent.mm.plugin.card.b.b localb = am.bWb();
          ae.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
          synchronized (localb.lock)
          {
            localb.pendingList.addAll(localb.oCV);
            localb.oCV.clear();
            localb.bVp();
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