package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.sdk.platformtools.ab;

public final class y
  extends m
  implements k
{
  private f callback;
  public final b fBd;
  
  public y(int paramInt, btj parambtj)
  {
    AppMethodBeat.i(16603);
    ab.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), parambtj.xGT, Integer.valueOf(parambtj.lGW), Integer.valueOf(parambtj.jKs), Integer.valueOf(parambtj.xCa) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new caw();
    ((b.a)localObject).fsY = new cax();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((b.a)localObject).funcId = 525;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fBd = ((b.a)localObject).ado();
    localObject = (caw)this.fBd.fsV.fta;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((caw)localObject).nrS = i;
    ((caw)localObject).xLU = parambtj;
    AppMethodBeat.o(16603);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16604);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(16604);
    return i;
  }
  
  public final int getType()
  {
    return 525;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16605);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ab.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((cax)this.fBd.fsW.fta).xGT });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(16605);
      return;
      ab.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */