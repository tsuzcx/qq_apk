package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public String ntw;
  public int ntx;
  public String nty;
  private final b rr;
  
  public g(int paramInt1, LinkedList<csm> paramLinkedList, String paramString1, String paramString2, ctb paramctb, int paramInt2, cxe paramcxe)
  {
    AppMethodBeat.i(112972);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new csk();
    ((b.a)localObject).gUV = new csl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((b.a)localObject).funcId = 902;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (csk)this.rr.gUS.gUX;
    ((csk)localObject).Eks = paramInt1;
    ((csk)localObject).gKs = paramLinkedList;
    ((csk)localObject).DHP = paramString1;
    ((csk)localObject).DrO = paramString2;
    ad.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((csk)localObject).Ekt = paramctb;
    ((csk)localObject).dye = paramInt2;
    ((csk)localObject).CtX = paramcxe;
    AppMethodBeat.o(112972);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(112974);
    this.callback = paramg;
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
      paramq = (csl)this.rr.gUT.gUX;
      if (paramq != null)
      {
        this.ntw = paramq.ntw;
        this.ntx = paramq.ntx;
        this.nty = paramq.nty;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112973);
      return;
      paramq = (csl)this.rr.gUT.gUX;
      if (paramq != null)
      {
        this.ntw = paramq.ntw;
        this.ntx = paramq.ntx;
        this.nty = paramq.nty;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */