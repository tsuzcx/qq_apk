package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class q
  extends n
  implements k
{
  private f gzH;
  private final b hKw;
  
  public q(LinkedList<dli> paramLinkedList)
  {
    AppMethodBeat.i(121053);
    b.a locala = new b.a();
    locala.hNM = new ko();
    locala.hNN = new kp();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hKw = locala.aDC();
    ((ko)this.hKw.hNK.hNQ).FCU = paramLinkedList;
    AppMethodBeat.o(121053);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(121055);
    ad.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.hKw, this);
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
    ad.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.q
 * JD-Core Version:    0.7.0.1
 */