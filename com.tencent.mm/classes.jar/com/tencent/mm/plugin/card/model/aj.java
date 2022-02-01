package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.sdk.platformtools.ad;

public final class aj
  extends n
  implements k
{
  private f callback;
  public boolean hhJ;
  public com.tencent.mm.bx.b oAr;
  public String ozQ;
  private final com.tencent.mm.al.b rr;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(112864);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new awl();
    ((b.a)localObject).hNN = new awm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((b.a)localObject).funcId = 1059;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (awl)this.rr.hNK.hNQ;
    ((awl)localObject).app_id = paramString1;
    ((awl)localObject).oIt = paramInt1;
    ((awl)localObject).oIu = paramString2;
    ((awl)localObject).oIv = paramString3;
    ((awl)localObject).time_stamp = paramInt2;
    ((awl)localObject).oIw = paramString4;
    ((awl)localObject).oxM = paramString5;
    ((awl)localObject).oIx = paramString6;
    ((awl)localObject).oAr = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((awl)localObject).GuZ = 1;
      AppMethodBeat.o(112864);
      return;
    }
    ((awl)localObject).GuZ = 0;
    AppMethodBeat.o(112864);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112865);
    this.callback = paramf;
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
      paramq = (awm)this.rr.hNL.hNQ;
      this.ozQ = paramq.ozQ;
      this.oAr = paramq.oAr;
      if (paramq.Gva == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.hhJ = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */