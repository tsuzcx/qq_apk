package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class u
  extends n
  implements k
{
  private g callback;
  private a hyt;
  private com.tencent.mm.ak.b rr;
  
  public u(String paramString, a parama, a parama1)
  {
    AppMethodBeat.i(209537);
    ac.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", new Object[] { paramString, Integer.valueOf(2) });
    this.hyt = parama1;
    parama1 = new b.a();
    parama1.funcId = 1915;
    parama1.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
    parama1.hvt = new ob();
    parama1.hvu = new oc();
    parama1.reqCmdId = 0;
    parama1.respCmdId = 0;
    this.rr = parama1.aAz();
    parama1 = (ob)this.rr.hvr.hvw;
    parama1.EdX = paramString;
    parama1.EdY = 2;
    try
    {
      parama1.EdZ = com.tencent.mm.bw.b.cc(parama.toByteArray());
      AppMethodBeat.o(209537);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("bad cgi request", paramString);
      AppMethodBeat.o(209537);
      throw paramString;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(209539);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(209539);
    return i;
  }
  
  public final int getType()
  {
    return 1915;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209538);
    ac.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.hyt != null) {
      this.hyt.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(209538);
  }
  
  public static abstract class a<T extends a>
    implements g
  {
    private final T hyu;
    
    protected a(T paramT)
    {
      this.hyu = paramT;
    }
    
    protected abstract void e(T paramT);
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      if ((paramn == null) || (!(paramn instanceof u))) {
        return;
      }
      paramString = (oc)((com.tencent.mm.ak.b)paramn.getReqResp()).hvs.hvw;
      try
      {
        this.hyu.parseFrom(paramString.EdZ.xy);
        label47:
        e(this.hyu);
        return;
      }
      catch (Throwable paramString)
      {
        break label47;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.u
 * JD-Core Version:    0.7.0.1
 */