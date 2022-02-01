package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.sdk.platformtools.ad;

public final class aj
  extends n
  implements k
{
  private g callback;
  public boolean gna;
  public com.tencent.mm.bx.b ntX;
  public String ntw;
  private final com.tencent.mm.al.b rr;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(112864);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new apj();
    ((b.a)localObject).gUV = new apk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((b.a)localObject).funcId = 1059;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (apj)this.rr.gUS.gUX;
    ((apj)localObject).app_id = paramString1;
    ((apj)localObject).nBZ = paramInt1;
    ((apj)localObject).nCa = paramString2;
    ((apj)localObject).nCb = paramString3;
    ((apj)localObject).time_stamp = paramInt2;
    ((apj)localObject).nCc = paramString4;
    ((apj)localObject).nrr = paramString5;
    ((apj)localObject).nCd = paramString6;
    ((apj)localObject).ntX = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((apj)localObject).DqT = 1;
      AppMethodBeat.o(112864);
      return;
    }
    ((apj)localObject).DqT = 0;
    AppMethodBeat.o(112864);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112865);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112865);
    return i;
  }
  
  public final int getType()
  {
    return 1059;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112866);
    ad.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (apk)this.rr.gUT.gUX;
      this.ntw = paramq.ntw;
      this.ntX = paramq.ntX;
      if (paramq.DqU == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.gna = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */