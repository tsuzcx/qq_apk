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
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends m
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public s(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(11441);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ahi();
    ((b.a)localObject).fsY = new ahj();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((b.a)localObject).funcId = 1343;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ahi)this.rr.fsV.fta;
    ((ahi)localObject).wyh = paramString;
    ((ahi)localObject).wZJ = paramInt;
    if (aa.dsG().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((ahi)localObject).wZK = paramInt;
      this.data = paramObject;
      AppMethodBeat.o(11441);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11443);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11443);
    return i;
  }
  
  public final int getType()
  {
    return 1343;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11442);
    ab.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.s
 * JD-Core Version:    0.7.0.1
 */