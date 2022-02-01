package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.sdk.platformtools.ae;

public final class aa
  extends n
  implements k
{
  private f callback;
  public String oGs;
  private final b rr;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, diy paramdiy)
  {
    AppMethodBeat.i(112837);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ayz();
    ((b.a)localObject).hQG = new aza();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((b.a)localObject).funcId = 1057;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ayz)this.rr.hQD.hQJ;
    ((ayz)localObject).dJb = paramString1;
    ((ayz)localObject).dJd = paramInt1;
    ((ayz)localObject).oBM = paramString2;
    ((ayz)localObject).dJc = paramString3;
    ((ayz)localObject).FJO = paramString4;
    ((ayz)localObject).FJN = paramString5;
    ((ayz)localObject).FJP = paramInt2;
    ((ayz)localObject).GPt = paramString6;
    ((ayz)localObject).FJR = paramdiy;
    AppMethodBeat.o(112837);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112838);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112838);
    return i;
  }
  
  public final int getType()
  {
    return 1057;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112839);
    ae.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.oGs = ((aza)this.rr.hQE.hQJ).oGs;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */