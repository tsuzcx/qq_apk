package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class q
  extends n
  implements k
{
  private g gfX;
  private final b hse;
  
  public q(LinkedList<dfv> paramLinkedList)
  {
    AppMethodBeat.i(121053);
    b.a locala = new b.a();
    locala.hvt = new kf();
    locala.hvu = new kg();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hse = locala.aAz();
    ((kf)this.hse.hvr.hvw).DXy = paramLinkedList;
    AppMethodBeat.o(121053);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(121055);
    ac.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.hse, this);
    AppMethodBeat.o(121055);
    return i;
  }
  
  public final int getType()
  {
    return 1176;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121054);
    ac.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.q
 * JD-Core Version:    0.7.0.1
 */