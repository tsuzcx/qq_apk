package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class v
  extends n
  implements k
{
  private f callback;
  private a hQN;
  private com.tencent.mm.al.b rr;
  
  public v(String paramString, a parama, a parama1)
  {
    AppMethodBeat.i(207188);
    ad.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", new Object[] { paramString, Integer.valueOf(2) });
    this.hQN = parama1;
    parama1 = new b.a();
    parama1.funcId = 1915;
    parama1.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
    parama1.hNM = new pg();
    parama1.hNN = new ph();
    parama1.hNO = 0;
    parama1.respCmdId = 0;
    this.rr = parama1.aDC();
    parama1 = (pg)this.rr.hNK.hNQ;
    parama1.FKw = paramString;
    parama1.FKx = 2;
    try
    {
      parama1.FKy = com.tencent.mm.bx.b.cj(parama.toByteArray());
      AppMethodBeat.o(207188);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("bad cgi request", paramString);
      AppMethodBeat.o(207188);
      throw paramString;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(207190);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(207190);
    return i;
  }
  
  public final int getType()
  {
    return 1915;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207189);
    ad.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.hQN != null) {
      this.hQN.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(207189);
  }
  
  public static abstract class a<T extends a>
    implements f
  {
    private final T hQO;
    
    protected a(T paramT)
    {
      this.hQO = paramT;
    }
    
    protected abstract void e(T paramT);
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      if ((paramn == null) || (!(paramn instanceof v))) {
        return;
      }
      paramString = (ph)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
      try
      {
        this.hQO.parseFrom(paramString.FKy.zr);
        label47:
        e(this.hQO);
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
 * Qualified Name:     com.tencent.mm.am.v
 * JD-Core Version:    0.7.0.1
 */