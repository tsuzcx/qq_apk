package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  extends p
  implements m
{
  private h callback;
  private String luk;
  private a<u> owM;
  c rr;
  
  private u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124117);
    this.luk = paramString1;
    Log.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[] { paramString1 });
    paramString1 = new c.a();
    paramString1.funcId = 1075;
    paramString1.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
    paramString1.otE = new oh();
    paramString1.otF = new oi();
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    this.rr = paramString1.bEF();
    paramString1 = (oh)c.b.b(this.rr.otB);
    paramString1.YRs = this.luk;
    paramString1.YRt = new b(Util.decodeHexString(Util.nullAsNil(paramString2)));
    AppMethodBeat.o(124117);
  }
  
  public u(String paramString1, String paramString2, a<u> parama)
  {
    this(paramString1, paramString2);
    this.owM = parama;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124119);
    this.callback = paramh;
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
    if (this.owM != null) {
      this.owM.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124118);
  }
  
  public static abstract interface a<T extends p>
  {
    public abstract void onNetSceneEndCallback(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.u
 * JD-Core Version:    0.7.0.1
 */