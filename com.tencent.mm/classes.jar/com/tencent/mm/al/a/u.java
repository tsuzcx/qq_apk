package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class u
  extends n
  implements k
{
  private g callback;
  Object data;
  public String hzZ;
  public b rr;
  
  public u(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124316);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bli();
    ((b.a)localObject).hvu = new blj();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((b.a)localObject).funcId = 1389;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bli)this.rr.hvr.hvw;
    ((bli)localObject).EtG = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((bli)localObject).FaR = paramString1;
    ((bli)localObject).FaS = paramLinkedList;
    this.data = paramObject;
    AppMethodBeat.o(124316);
  }
  
  public final blj aDt()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (blj)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124318);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
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
    ac.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.a.u
 * JD-Core Version:    0.7.0.1
 */