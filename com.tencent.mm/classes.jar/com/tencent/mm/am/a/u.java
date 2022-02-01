package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class u
  extends n
  implements k
{
  private f callback;
  Object data;
  public String hSu;
  public b rr;
  
  public u(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124316);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bps();
    ((b.a)localObject).hNN = new bpt();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((b.a)localObject).funcId = 1389;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bps)this.rr.hNK.hNQ;
    ((bps)localObject).GaY = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((bps)localObject).GKq = paramString1;
    ((bps)localObject).GKr = paramLinkedList;
    this.data = paramObject;
    AppMethodBeat.o(124316);
  }
  
  public final bpt aGw()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (bpt)this.rr.hNL.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124318);
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124318);
    return i;
  }
  
  public final int getType()
  {
    return 1389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124317);
    ad.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a.u
 * JD-Core Version:    0.7.0.1
 */