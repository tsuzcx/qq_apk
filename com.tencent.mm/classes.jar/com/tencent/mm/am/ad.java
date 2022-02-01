package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cjf;
import java.util.LinkedList;

public final class ad
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public ad(LinkedList<cjd> paramLinkedList)
  {
    AppMethodBeat.i(124143);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cje();
    ((b.a)localObject).gUV = new cjf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportcommand";
    ((b.a)localObject).funcId = 2592;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cje)this.rr.gUS.gUX;
    ((cje)localObject).CYB = paramLinkedList;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[] { Integer.valueOf(((cje)localObject).CYB.size()) });
    AppMethodBeat.o(124143);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124145);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124145);
    return i;
  }
  
  public final int getType()
  {
    return 2592;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124144);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(124144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.ad
 * JD-Core Version:    0.7.0.1
 */