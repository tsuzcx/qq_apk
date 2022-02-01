package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class v
  extends q
  implements m
{
  private i callback;
  private a lFh;
  private d rr;
  
  public v(String paramString, a parama, a parama1)
  {
    AppMethodBeat.i(210098);
    Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", new Object[] { paramString, Integer.valueOf(2) });
    this.lFh = parama1;
    parama1 = new d.a();
    parama1.funcId = 1915;
    parama1.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
    parama1.lBU = new qd();
    parama1.lBV = new qe();
    parama1.lBW = 0;
    parama1.respCmdId = 0;
    this.rr = parama1.bgN();
    parama1 = (qd)d.b.b(this.rr.lBR);
    parama1.RYx = paramString;
    parama1.RYy = 2;
    try
    {
      parama1.RYz = b.cU(parama.toByteArray());
      AppMethodBeat.o(210098);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("bad cgi request", paramString);
      AppMethodBeat.o(210098);
      throw paramString;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210104);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(210104);
    return i;
  }
  
  public final int getType()
  {
    return 1915;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210101);
    Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.lFh != null) {
      this.lFh.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(210101);
  }
  
  public static abstract class a<T extends a>
    implements i
  {
    private final T lFi;
    
    protected a(T paramT)
    {
      this.lFi = paramT;
    }
    
    protected abstract void e(T paramT);
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      if ((paramq == null) || (!(paramq instanceof v))) {
        return;
      }
      paramString = (qe)d.c.b(((d)paramq.getReqResp()).lBS);
      try
      {
        this.lFi.parseFrom(paramString.RYz.UH);
        label47:
        e(this.lFi);
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
 * Qualified Name:     com.tencent.mm.ao.v
 * JD-Core Version:    0.7.0.1
 */