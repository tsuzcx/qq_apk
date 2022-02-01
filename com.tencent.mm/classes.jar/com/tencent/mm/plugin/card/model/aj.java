package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.sdk.platformtools.ac;

public final class aj
  extends n
  implements k
{
  private g callback;
  public boolean gNN;
  public com.tencent.mm.bw.b nWX;
  public String nWw;
  private final com.tencent.mm.ak.b rr;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(112864);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new asn();
    ((b.a)localObject).hvu = new aso();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((b.a)localObject).funcId = 1059;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (asn)this.rr.hvr.hvw;
    ((asn)localObject).app_id = paramString1;
    ((asn)localObject).oeZ = paramInt1;
    ((asn)localObject).ofa = paramString2;
    ((asn)localObject).ofb = paramString3;
    ((asn)localObject).time_stamp = paramInt2;
    ((asn)localObject).ofc = paramString4;
    ((asn)localObject).nUr = paramString5;
    ((asn)localObject).ofd = paramString6;
    ((asn)localObject).nWX = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((asn)localObject).ELV = 1;
      AppMethodBeat.o(112864);
      return;
    }
    ((asn)localObject).ELV = 0;
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
    ac.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aso)this.rr.hvs.hvw;
      this.nWw = paramq.nWw;
      this.nWX = paramq.nWX;
      if (paramq.ELW == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.gNN = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */