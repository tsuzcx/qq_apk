package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public String nWw;
  public int nWx;
  public String nWy;
  private final b rr;
  
  public g(int paramInt1, LinkedList<cxv> paramLinkedList, String paramString1, String paramString2, cym paramcym, int paramInt2, dcq paramdcq)
  {
    AppMethodBeat.i(112972);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cxt();
    ((b.a)localObject).hvu = new cxu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((b.a)localObject).funcId = 902;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cxt)this.rr.hvr.hvw;
    ((cxt)localObject).FHq = paramInt1;
    ((cxt)localObject).hkS = paramLinkedList;
    ((cxt)localObject).Fdk = paramString1;
    ((cxt)localObject).EMQ = paramString2;
    ac.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((cxt)localObject).FHr = paramcym;
    ((cxt)localObject).dvQ = paramInt2;
    ((cxt)localObject).DMo = paramdcq;
    AppMethodBeat.o(112972);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      paramq = (cxu)this.rr.hvs.hvw;
      if (paramq != null)
      {
        this.nWw = paramq.nWw;
        this.nWx = paramq.nWx;
        this.nWy = paramq.nWy;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112973);
      return;
      paramq = (cxu)this.rr.hvs.hvw;
      if (paramq != null)
      {
        this.nWw = paramq.nWw;
        this.nWx = paramq.nWx;
        this.nWy = paramq.nWy;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */