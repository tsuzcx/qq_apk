package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.sdk.platformtools.ab;

public final class y
  extends m
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public y(ky paramky, Object paramObject)
  {
    AppMethodBeat.i(11461);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cam();
    ((b.a)localObject).fsY = new can();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((b.a)localObject).funcId = 1228;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cam)this.rr.fsV.fta;
    ((cam)localObject).wZL = paramky;
    ((cam)localObject).mask = 1;
    ((cam)localObject).wZJ = 1;
    this.data = paramObject;
    AppMethodBeat.o(11461);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11463);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11463);
    return i;
  }
  
  public final int getType()
  {
    return 1228;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11462);
    ab.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.y
 * JD-Core Version:    0.7.0.1
 */