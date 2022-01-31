package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.sdk.platformtools.ab;

public final class w
  extends m
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public w(String paramString, kp paramkp, Object paramObject)
  {
    AppMethodBeat.i(11639);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cmq();
    ((b.a)localObject).fsY = new cmr();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
    ((b.a)localObject).funcId = 1356;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cmq)this.rr.fsV.fta;
    ((cmq)localObject).wyh = paramString;
    ((cmq)localObject).wXl = paramkp;
    this.data = paramObject;
    AppMethodBeat.o(11639);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11641);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11641);
    return i;
  }
  
  public final int getType()
  {
    return 1356;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11640);
    ab.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a.w
 * JD-Core Version:    0.7.0.1
 */