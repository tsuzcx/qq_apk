package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends q
  implements m
{
  private i callback;
  private btv iOT;
  private a<aa> iOU;
  private final d rr;
  
  public aa()
  {
    AppMethodBeat.i(212182);
    Log.i("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "NetSceneGetReceiptAssisPluginMenu begin");
    d.a locala = new d.a();
    locala.funcId = 1769;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassismenu";
    btu localbtu = new btu();
    localbtu.timestamp = cl.aWz();
    locala.iLN = localbtu;
    locala.iLO = new btv();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(212182);
  }
  
  public aa(a<aa> parama)
  {
    this();
    this.iOU = parama;
  }
  
  public final btv bab()
  {
    AppMethodBeat.i(212185);
    if (this.iOT == null)
    {
      localbtv = new btv();
      AppMethodBeat.o(212185);
      return localbtv;
    }
    btv localbtv = this.iOT;
    AppMethodBeat.o(212185);
    return localbtv;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212183);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(212183);
    return i;
  }
  
  public final int getType()
  {
    return 1769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212184);
    Log.w("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.iOT = ((btv)((d)params).iLL.iLR);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.iOU != null) {
      this.iOU.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(212184);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.aa
 * JD-Core Version:    0.7.0.1
 */