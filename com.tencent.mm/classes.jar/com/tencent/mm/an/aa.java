package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends p
  implements m
{
  private h callback;
  private cqu owP;
  private a<aa> owQ;
  private final c rr;
  
  public aa()
  {
    AppMethodBeat.i(239429);
    Log.i("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "NetSceneGetReceiptAssisPluginMenu begin");
    c.a locala = new c.a();
    locala.funcId = 1769;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassismenu";
    cqt localcqt = new cqt();
    localcqt.timestamp = cn.bDv();
    locala.otE = localcqt;
    locala.otF = new cqu();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(239429);
  }
  
  public aa(a<aa> parama)
  {
    this();
    this.owQ = parama;
  }
  
  public final cqu bHa()
  {
    AppMethodBeat.i(239437);
    if (this.owP == null)
    {
      localcqu = new cqu();
      AppMethodBeat.o(239437);
      return localcqu;
    }
    cqu localcqu = this.owP;
    AppMethodBeat.o(239437);
    return localcqu;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(239432);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(239432);
    return i;
  }
  
  public final int getType()
  {
    return 1769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(239433);
    Log.w("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.owP = ((cqu)c.c.b(((c)params).otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.owQ != null) {
      this.owQ.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(239433);
  }
  
  public static abstract interface a<T extends p>
  {
    public abstract void onNetSceneEndCallback(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.aa
 * JD-Core Version:    0.7.0.1
 */