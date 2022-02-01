package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public final class v
  extends n
  implements k
{
  private f callback;
  private a hTF;
  private com.tencent.mm.ak.b rr;
  
  public v(String paramString, a parama, a parama1)
  {
    AppMethodBeat.i(188886);
    ae.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", new Object[] { paramString, Integer.valueOf(2) });
    this.hTF = parama1;
    parama1 = new b.a();
    parama1.funcId = 1915;
    parama1.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
    parama1.hQF = new pi();
    parama1.hQG = new pj();
    parama1.hQH = 0;
    parama1.respCmdId = 0;
    this.rr = parama1.aDS();
    parama1 = (pi)this.rr.hQD.hQJ;
    parama1.GcV = paramString;
    parama1.GcW = 2;
    try
    {
      parama1.GcX = com.tencent.mm.bw.b.cm(parama.toByteArray());
      AppMethodBeat.o(188886);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("bad cgi request", paramString);
      AppMethodBeat.o(188886);
      throw paramString;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(188888);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(188888);
    return i;
  }
  
  public final int getType()
  {
    return 1915;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(188887);
    ae.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.hTF != null) {
      this.hTF.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(188887);
  }
  
  public static abstract class a<T extends a>
    implements f
  {
    private final T hTG;
    
    protected a(T paramT)
    {
      this.hTG = paramT;
    }
    
    protected abstract void e(T paramT);
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      if ((paramn == null) || (!(paramn instanceof v))) {
        return;
      }
      paramString = (pj)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
      try
      {
        this.hTG.parseFrom(paramString.GcX.zr);
        label47:
        e(this.hTG);
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
 * Qualified Name:     com.tencent.mm.al.v
 * JD-Core Version:    0.7.0.1
 */