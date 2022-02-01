package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class ae
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public ae(LinkedList<ctn> paramLinkedList)
  {
    AppMethodBeat.i(124143);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cto();
    ((b.a)localObject).hNN = new ctp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportcommand";
    ((b.a)localObject).funcId = 2592;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cto)this.rr.hNK.hNQ;
    ((cto)localObject).FYv = paramLinkedList;
    ad.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[] { Integer.valueOf(((cto)localObject).FYv.size()) });
    AppMethodBeat.o(124143);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124145);
    this.callback = paramf;
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
 * Qualified Name:     com.tencent.mm.am.ae
 * JD-Core Version:    0.7.0.1
 */