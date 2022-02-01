package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.sdk.platformtools.ac;

public final class y
  extends n
  implements k
{
  private g callback;
  public final b hEg;
  
  public y(int paramInt, coa paramcoa)
  {
    AppMethodBeat.i(20647);
    ac.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), paramcoa.FBg, Integer.valueOf(paramcoa.pAS), Integer.valueOf(paramcoa.ndI), Integer.valueOf(paramcoa.FvC) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cwv();
    ((b.a)localObject).hvu = new cww();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((b.a)localObject).funcId = 525;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (cwv)this.hEg.hvr.hvw;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((cwv)localObject).fZz = i;
    ((cwv)localObject).FGQ = paramcoa;
    AppMethodBeat.o(20647);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20648);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
      ac.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((cww)this.hEg.hvs.hvw).FBg });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20649);
      return;
      ac.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */