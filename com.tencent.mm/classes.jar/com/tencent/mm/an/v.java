package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class v
  extends p
  implements m
{
  private h callback;
  private a owN;
  private c rr;
  
  public v(String paramString, a parama, a parama1)
  {
    AppMethodBeat.i(239454);
    Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", new Object[] { paramString, Integer.valueOf(2) });
    this.owN = parama1;
    parama1 = new c.a();
    parama1.funcId = 1915;
    parama1.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
    parama1.otE = new rn();
    parama1.otF = new ro();
    parama1.otG = 0;
    parama1.respCmdId = 0;
    this.rr = parama1.bEF();
    parama1 = (rn)c.b.b(this.rr.otB);
    parama1.YWx = paramString;
    parama1.Tps = 2;
    try
    {
      parama1.YWy = b.cX(parama.toByteArray());
      AppMethodBeat.o(239454);
      return;
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException("bad cgi request", paramString);
      AppMethodBeat.o(239454);
      throw paramString;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(239462);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(239462);
    return i;
  }
  
  public final int getType()
  {
    return 1915;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(239458);
    Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.owN != null) {
      this.owN.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(239458);
  }
  
  public static abstract class a<T extends a>
    implements h
  {
    private final T owO;
    
    protected a(T paramT)
    {
      this.owO = paramT;
    }
    
    protected abstract void c(T paramT);
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      if ((paramp == null) || (!(paramp instanceof v))) {
        return;
      }
      paramString = (ro)c.c.b(((c)paramp.getReqResp()).otC);
      try
      {
        this.owO.parseFrom(paramString.YWy.Op);
        label47:
        c(this.owO);
        return;
      }
      finally
      {
        break label47;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.v
 * JD-Core Version:    0.7.0.1
 */