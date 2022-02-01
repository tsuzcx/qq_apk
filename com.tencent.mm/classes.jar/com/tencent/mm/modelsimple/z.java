package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends q
  implements m
{
  private i callback;
  public final d iUB;
  
  public z(int paramInt, dmn paramdmn)
  {
    AppMethodBeat.i(20647);
    Log.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), paramdmn.MQb, Integer.valueOf(paramdmn.rBX), Integer.valueOf(paramdmn.oUv), Integer.valueOf(paramdmn.MJT) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dwg();
    ((d.a)localObject).iLO = new dwh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((d.a)localObject).funcId = 525;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (dwg)this.iUB.iLK.iLR;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((dwg)localObject).him = i;
    ((dwg)localObject).MWJ = paramdmn;
    AppMethodBeat.o(20647);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20648);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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
      Log.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((dwh)this.iUB.iLL.iLR).MQb });
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