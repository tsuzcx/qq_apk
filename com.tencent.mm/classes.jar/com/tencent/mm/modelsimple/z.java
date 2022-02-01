package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends q
  implements m
{
  private i callback;
  public final d lKU;
  
  public z(int paramInt, dwe paramdwe)
  {
    AppMethodBeat.i(20647);
    Log.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), paramdwe.Ucf, Integer.valueOf(paramdwe.vhF), Integer.valueOf(paramdwe.rWu), Integer.valueOf(paramdwe.TVM) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new egi();
    ((d.a)localObject).lBV = new egj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((d.a)localObject).funcId = 525;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.lKU = ((d.a)localObject).bgN();
    localObject = (egi)d.b.b(this.lKU.lBR);
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((egi)localObject).jUk = i;
    ((egi)localObject).Uje = paramdwe;
    AppMethodBeat.o(20647);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20648);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(20648);
    return i;
  }
  
  public final int getType()
  {
    return 525;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20649);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((egj)d.c.b(this.lKU.lBS)).Ucf });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20649);
      return;
      Log.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.z
 * JD-Core Version:    0.7.0.1
 */