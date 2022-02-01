package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends q
  implements m
{
  private i callback;
  private cbn lFj;
  private a<aa> lFk;
  private final d rr;
  
  public aa()
  {
    AppMethodBeat.i(205445);
    Log.i("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "NetSceneGetReceiptAssisPluginMenu begin");
    d.a locala = new d.a();
    locala.funcId = 1769;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassismenu";
    cbm localcbm = new cbm();
    localcbm.timestamp = cm.bfD();
    locala.lBU = localcbm;
    locala.lBV = new cbn();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(205445);
  }
  
  public aa(a<aa> parama)
  {
    this();
    this.lFk = parama;
  }
  
  public final cbn bjq()
  {
    AppMethodBeat.i(205449);
    if (this.lFj == null)
    {
      localcbn = new cbn();
      AppMethodBeat.o(205449);
      return localcbn;
    }
    cbn localcbn = this.lFj;
    AppMethodBeat.o(205449);
    return localcbn;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(205447);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(205447);
    return i;
  }
  
  public final int getType()
  {
    return 1769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(205448);
    Log.w("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.lFj = ((cbn)d.c.b(((d)params).lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.lFk != null) {
      this.lFk.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(205448);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.aa
 * JD-Core Version:    0.7.0.1
 */