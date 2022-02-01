package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class o
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public o(String paramString, LinkedList<bsb> paramLinkedList)
  {
    AppMethodBeat.i(5596);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bse();
    ((b.a)localObject).hvu = new bsf();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
    ((b.a)localObject).funcId = 1030;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bse)this.rr.hvr.hvw;
    ((bse)localObject).Fap = paramString;
    ((bse)localObject).Fhj = paramLinkedList;
    AppMethodBeat.o(5596);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(5598);
    this.callback = paramg;
    ac.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5598);
    return i;
  }
  
  public final int getType()
  {
    return 1030;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5597);
    ac.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.o
 * JD-Core Version:    0.7.0.1
 */