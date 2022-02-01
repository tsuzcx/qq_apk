package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public ac(String paramString, int paramInt, LinkedList<du> paramLinkedList)
  {
    AppMethodBeat.i(150960);
    ae.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dqt();
    ((b.a)localObject).hQG = new dqu();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((b.a)localObject).funcId = 1200;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dqt)this.rr.hQD.hQJ;
    ((dqt)localObject).link = paramString;
    ((dqt)localObject).scene = paramInt;
    ((dqt)localObject).HXJ = paramLinkedList;
    AppMethodBeat.o(150960);
  }
  
  public final dqu aLA()
  {
    if ((this.rr != null) && (this.rr.hQE.hQJ != null)) {
      return (dqu)this.rr.hQE.hQJ;
    }
    return null;
  }
  
  public final String aLz()
  {
    dqu localdqu = (dqu)this.rr.hQE.hQJ;
    if (localdqu == null) {
      return null;
    }
    return localdqu.HXK;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150961);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */