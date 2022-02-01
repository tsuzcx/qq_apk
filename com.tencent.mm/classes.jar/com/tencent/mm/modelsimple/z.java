package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.sdk.platformtools.ae;

public final class z
  extends n
  implements k
{
  private f callback;
  public final b hZD;
  
  public z(int paramInt, ctx paramctx)
  {
    AppMethodBeat.i(20647);
    ae.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), paramctx.HET, Integer.valueOf(paramctx.qlc), Integer.valueOf(paramctx.nJA), Integer.valueOf(paramctx.Hzh) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ddc();
    ((b.a)localObject).hQG = new ddd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((b.a)localObject).funcId = 525;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (ddc)this.hZD.hQD.hQJ;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((ddc)localObject).gvx = i;
    ((ddc)localObject).HLa = paramctx;
    AppMethodBeat.o(20647);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20648);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(20648);
    return i;
  }
  
  public final int getType()
  {
    return 525;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20649);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ae.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((ddd)this.hZD.hQE.hQJ).HET });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20649);
      return;
      ae.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.z
 * JD-Core Version:    0.7.0.1
 */