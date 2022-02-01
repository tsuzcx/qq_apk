package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class v
  extends q
  implements m
{
  private i callback;
  private a iOR;
  private d rr;
  
  public v(String paramString, a parama, a parama1)
  {
    AppMethodBeat.i(212179);
    Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", new Object[] { paramString, Integer.valueOf(2) });
    this.iOR = parama1;
    parama1 = new d.a();
    parama1.funcId = 1915;
    parama1.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
    parama1.iLN = new qh();
    parama1.iLO = new qi();
    parama1.iLP = 0;
    parama1.respCmdId = 0;
    this.rr = parama1.aXF();
    parama1 = (qh)this.rr.iLK.iLR;
    parama1.KXi = paramString;
    parama1.KXj = 2;
    try
    {
      parama1.KXk = b.cD(parama.toByteArray());
      AppMethodBeat.o(212179);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("bad cgi request", paramString);
      AppMethodBeat.o(212179);
      throw paramString;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212181);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(212181);
    return i;
  }
  
  public final int getType()
  {
    return 1915;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212180);
    Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.iOR != null) {
      this.iOR.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(212180);
  }
  
  public static abstract class a<T extends a>
    implements i
  {
    private final T iOS;
    
    protected a(T paramT)
    {
      this.iOS = paramT;
    }
    
    protected abstract void e(T paramT);
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      if ((paramq == null) || (!(paramq instanceof v))) {
        return;
      }
      paramString = (qi)((d)paramq.getReqResp()).iLL.iLR;
      try
      {
        this.iOS.parseFrom(paramString.KXk.zy);
        label47:
        e(this.iOS);
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