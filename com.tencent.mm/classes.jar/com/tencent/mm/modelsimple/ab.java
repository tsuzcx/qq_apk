package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public ab(String paramString, int paramInt, LinkedList<dr> paramLinkedList)
  {
    AppMethodBeat.i(150960);
    ad.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new deq();
    ((b.a)localObject).gUV = new der();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((b.a)localObject).funcId = 1200;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (deq)this.rr.gUS.gUX;
    ((deq)localObject).link = paramString;
    ((deq)localObject).scene = paramInt;
    ((deq)localObject).Ewh = paramLinkedList;
    AppMethodBeat.o(150960);
  }
  
  public final String aBb()
  {
    der localder = (der)this.rr.gUT.gUX;
    if (localder == null) {
      return null;
    }
    return localder.Ewi;
  }
  
  public final der aBc()
  {
    if ((this.rr != null) && (this.rr.gUT.gUX != null)) {
      return (der)this.rr.gUT.gUX;
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
    ad.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */