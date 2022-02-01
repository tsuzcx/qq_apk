package com.tencent.mm.modelsimple;

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
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public ab(String paramString, int paramInt, LinkedList<du> paramLinkedList)
  {
    AppMethodBeat.i(150960);
    ad.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dpw();
    ((b.a)localObject).hNN = new dpx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((b.a)localObject).funcId = 1200;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dpw)this.rr.hNK.hNQ;
    ((dpw)localObject).link = paramString;
    ((dpw)localObject).scene = paramInt;
    ((dpw)localObject).HDW = paramLinkedList;
    AppMethodBeat.o(150960);
  }
  
  public final String aLc()
  {
    dpx localdpx = (dpx)this.rr.hNL.hNQ;
    if (localdpx == null) {
      return null;
    }
    return localdpx.HDX;
  }
  
  public final dpx aLd()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (dpx)this.rr.hNL.hNQ;
    }
    return null;
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
    ad.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */