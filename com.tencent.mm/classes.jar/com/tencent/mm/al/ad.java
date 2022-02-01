package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class ad
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public ad(LinkedList<cok> paramLinkedList)
  {
    AppMethodBeat.i(124143);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new col();
    ((b.a)localObject).hvu = new com();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportcommand";
    ((b.a)localObject).funcId = 2592;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (col)this.rr.hvr.hvw;
    ((col)localObject).Erl = paramLinkedList;
    ac.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[] { Integer.valueOf(((col)localObject).Erl.size()) });
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
 * Qualified Name:     com.tencent.mm.al.ad
 * JD-Core Version:    0.7.0.1
 */