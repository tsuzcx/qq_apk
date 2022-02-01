package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class u
  extends n
  implements k
{
  private g callback;
  private a gXU;
  private com.tencent.mm.al.b rr;
  
  public u(String paramString, a parama, a parama1)
  {
    AppMethodBeat.i(191061);
    ad.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", new Object[] { paramString, Integer.valueOf(2) });
    this.gXU = parama1;
    parama1 = new b.a();
    parama1.funcId = 1915;
    parama1.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
    parama1.gUU = new nu();
    parama1.gUV = new nv();
    parama1.reqCmdId = 0;
    parama1.respCmdId = 0;
    this.rr = parama1.atI();
    parama1 = (nu)this.rr.gUS.gUX;
    parama1.CLu = paramString;
    parama1.CLv = 2;
    try
    {
      parama1.CLw = com.tencent.mm.bx.b.cd(parama.toByteArray());
      AppMethodBeat.o(191061);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("bad cgi request", paramString);
      AppMethodBeat.o(191061);
      throw paramString;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(191063);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(191063);
    return i;
  }
  
  public final int getType()
  {
    return 1915;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(191062);
    ad.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gXU != null) {
      this.gXU.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(191062);
  }
  
  public static abstract class a<T extends a>
    implements g
  {
    private final T gXV;
    
    protected a(T paramT)
    {
      this.gXV = paramT;
    }
    
    protected abstract void e(T paramT);
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      if ((paramn == null) || (!(paramn instanceof u))) {
        return;
      }
      paramString = (nv)((com.tencent.mm.al.b)paramn.getReqResp()).gUT.gUX;
      try
      {
        this.gXV.parseFrom(paramString.CLw.wA);
        label47:
        e(this.gXV);
        return;
      }
      catch (Throwable paramString)
      {
        break label47;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.u
 * JD-Core Version:    0.7.0.1
 */