package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.bwr;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class o
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public o(String paramString, LinkedList<bwo> paramLinkedList)
  {
    AppMethodBeat.i(5596);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bwr();
    ((b.a)localObject).hNN = new bws();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
    ((b.a)localObject).funcId = 1030;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bwr)this.rr.hNK.hNQ;
    ((bwr)localObject).GJO = paramString;
    ((bwr)localObject).GQL = paramLinkedList;
    AppMethodBeat.o(5596);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5598);
    this.callback = paramf;
    ad.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
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
    ad.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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