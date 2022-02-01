package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.sdk.platformtools.ad;

public final class y
  extends n
  implements k
{
  private f callback;
  public final b hWL;
  
  public y(int paramInt, ctd paramctd)
  {
    AppMethodBeat.i(20647);
    ad.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), paramctd.Hlt, Integer.valueOf(paramctd.qex), Integer.valueOf(paramctd.nEf), Integer.valueOf(paramctd.HfH) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dci();
    ((b.a)localObject).hNN = new dcj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((b.a)localObject).funcId = 525;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hWL = ((b.a)localObject).aDC();
    localObject = (dci)this.hWL.hNK.hNQ;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((dci)localObject).gsV = i;
    ((dci)localObject).Hry = paramctd;
    AppMethodBeat.o(20647);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20648);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
      ad.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((dcj)this.hWL.hNL.hNQ).Hlt });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20649);
      return;
      ad.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */