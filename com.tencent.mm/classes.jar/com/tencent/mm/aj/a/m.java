package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  Object data;
  public String fye;
  public b rr;
  
  public m(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(11609);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new vk();
    ((b.a)localObject).fsY = new vl();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((b.a)localObject).funcId = 1315;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (vk)this.rr.fsV.fta;
    ((vk)localObject).wOf = paramString1;
    ((vk)localObject).wOh = paramString2;
    ((vk)localObject).wOg = paramString3;
    this.data = paramObject;
    AppMethodBeat.o(11609);
  }
  
  public final vl afC()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (vl)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11611);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneConvertBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11611);
    return i;
  }
  
  public final int getType()
  {
    return 1315;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11610);
    ab.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.a.m
 * JD-Core Version:    0.7.0.1
 */