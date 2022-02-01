package com.tencent.mm.ca;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b hvm;
  
  public b(cpa paramcpa)
  {
    AppMethodBeat.i(9330);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cpa();
    ((b.a)localObject).hvu = new cpb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((b.a)localObject).funcId = 809;
    this.hvm = ((b.a)localObject).aAz();
    localObject = (cpa)this.hvm.hvr.hvw;
    ((cpa)localObject).FBP = paramcpa.FBP;
    ((cpa)localObject).FBO = paramcpa.FBO;
    ((cpa)localObject).Ebg = paramcpa.Ebg;
    ((cpa)localObject).EmotionList.addAll(paramcpa.EmotionList);
    ((cpa)localObject).ndI = paramcpa.ndI;
    AppMethodBeat.o(9330);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(9331);
    this.callback = paramg;
    int i = dispatch(parame, this.hvm, this);
    AppMethodBeat.o(9331);
    return i;
  }
  
  public final int getType()
  {
    return 809;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9332);
    ac.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.b
 * JD-Core Version:    0.7.0.1
 */