package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private f callback;
  public String ozQ;
  public int ozR;
  public String ozS;
  private final b rr;
  
  public g(int paramInt1, LinkedList<ddi> paramLinkedList, String paramString1, String paramString2, ddz paramddz, int paramInt2, did paramdid)
  {
    AppMethodBeat.i(112972);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ddg();
    ((b.a)localObject).hNN = new ddh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((b.a)localObject).funcId = 902;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ddg)this.rr.hNK.hNQ;
    ((ddg)localObject).HrY = paramInt1;
    ((ddg)localObject).hDb = paramLinkedList;
    ((ddg)localObject).GMM = paramString1;
    ((ddg)localObject).GvU = paramString2;
    ad.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((ddg)localObject).HrZ = paramddz;
    ((ddg)localObject).dHZ = paramInt2;
    ((ddg)localObject).Frt = paramdid;
    AppMethodBeat.o(112972);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112974);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112974);
    return i;
  }
  
  public final int getType()
  {
    return 902;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112973);
    ad.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      paramq = (ddh)this.rr.hNL.hNQ;
      if (paramq != null)
      {
        this.ozQ = paramq.ozQ;
        this.ozR = paramq.ozR;
        this.ozS = paramq.ozS;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112973);
      return;
      paramq = (ddh)this.rr.hNL.hNQ;
      if (paramq != null)
      {
        this.ozQ = paramq.ozQ;
        this.ozR = paramq.ozR;
        this.ozS = paramq.ozS;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */