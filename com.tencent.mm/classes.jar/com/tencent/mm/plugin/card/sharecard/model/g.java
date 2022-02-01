package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private f callback;
  public String oGs;
  public int oGt;
  public String oGu;
  private final b rr;
  
  public g(int paramInt1, LinkedList<dec> paramLinkedList, String paramString1, String paramString2, det paramdet, int paramInt2, diy paramdiy)
  {
    AppMethodBeat.i(112972);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dea();
    ((b.a)localObject).hQG = new deb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((b.a)localObject).funcId = 902;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dea)this.rr.hQD.hQJ;
    ((dea)localObject).HLA = paramInt1;
    ((dea)localObject).hFT = paramLinkedList;
    ((dea)localObject).Hgn = paramString1;
    ((dea)localObject).GPt = paramString2;
    ae.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((dea)localObject).HLB = paramdet;
    ((dea)localObject).dJd = paramInt2;
    ((dea)localObject).FJR = paramdiy;
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
    ae.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      paramq = (deb)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        this.oGs = paramq.oGs;
        this.oGt = paramq.oGt;
        this.oGu = paramq.oGu;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112973);
      return;
      paramq = (deb)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        this.oGs = paramq.oGs;
        this.oGt = paramq.oGt;
        this.oGu = paramq.oGu;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */