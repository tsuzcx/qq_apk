package com.tencent.mm.aj.a;

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
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends m
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public n(String paramString, aeh paramaeh, Object paramObject)
  {
    AppMethodBeat.i(11612);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new vr();
    ((b.a)localObject).fsY = new vs();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((b.a)localObject).funcId = 1355;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (vr)this.rr.fsV.fta;
    ((vr)localObject).wyh = paramString;
    ((vr)localObject).wOs = paramaeh;
    this.data = paramObject;
    AppMethodBeat.o(11612);
  }
  
  public final vs afD()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (vs)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final vr afE()
  {
    if ((this.rr != null) && (this.rr.fsV.fta != null)) {
      return (vr)this.rr.fsV.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11614);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11614);
    return i;
  }
  
  public final int getType()
  {
    return 1355;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11613);
    ab.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a.n
 * JD-Core Version:    0.7.0.1
 */