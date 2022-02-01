package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  extends q
  implements m
{
  private i callback;
  private String goe;
  private a<u> iOQ;
  d rr;
  
  private u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124117);
    this.goe = paramString1;
    Log.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[] { paramString1 });
    paramString1 = new d.a();
    paramString1.funcId = 1075;
    paramString1.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
    paramString1.iLN = new nm();
    paramString1.iLO = new nn();
    paramString1.iLP = 0;
    paramString1.respCmdId = 0;
    this.rr = paramString1.aXF();
    paramString1 = (nm)this.rr.iLK.iLR;
    paramString1.KSV = this.goe;
    paramString1.KSW = new b(Util.decodeHexString(Util.nullAsNil(paramString2)));
    AppMethodBeat.o(124117);
  }
  
  public u(String paramString1, String paramString2, a<u> parama)
  {
    this(paramString1, paramString2);
    this.iOQ = parama;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124119);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124119);
    return i;
  }
  
  public final int getType()
  {
    return 1075;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124118);
    Log.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.iOQ != null) {
      this.iOQ.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124118);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.u
 * JD-Core Version:    0.7.0.1
 */