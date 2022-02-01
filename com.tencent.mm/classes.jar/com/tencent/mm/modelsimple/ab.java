package com.tencent.mm.modelsimple;

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
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public ab(String paramString, int paramInt, LinkedList<dt> paramLinkedList)
  {
    AppMethodBeat.i(150960);
    ac.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dkf();
    ((b.a)localObject).hvu = new dkg();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((b.a)localObject).funcId = 1200;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dkf)this.rr.hvr.hvw;
    ((dkf)localObject).link = paramString;
    ((dkf)localObject).scene = paramInt;
    ((dkf)localObject).FTk = paramLinkedList;
    AppMethodBeat.o(150960);
  }
  
  public final String aHR()
  {
    dkg localdkg = (dkg)this.rr.hvs.hvw;
    if (localdkg == null) {
      return null;
    }
    return localdkg.FTl;
  }
  
  public final dkg aHS()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (dkg)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150961);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150961);
    return i;
  }
  
  public final int getType()
  {
    return 1200;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150962);
    ac.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */