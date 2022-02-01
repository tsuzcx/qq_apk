package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ce;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.sdk.platformtools.ac;

public final class z
  extends n
  implements k
{
  private g callback;
  private bdb hyv;
  private a<z> hyw;
  private final b rr;
  
  public z()
  {
    AppMethodBeat.i(209540);
    ac.i("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "NetSceneGetReceiptAssisPluginMenu begin");
    b.a locala = new b.a();
    locala.funcId = 1769;
    locala.uri = "/cgi-bin/mmpay-bin/getreceiptassismenu";
    bda localbda = new bda();
    localbda.timestamp = ce.azI();
    locala.hvt = localbda;
    locala.hvu = new bdb();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(209540);
  }
  
  public z(a<z> parama)
  {
    this();
    this.hyw = parama;
  }
  
  public final bdb aCQ()
  {
    AppMethodBeat.i(209543);
    if (this.hyv == null)
    {
      localbdb = new bdb();
      AppMethodBeat.o(209543);
      return localbdb;
    }
    bdb localbdb = this.hyv;
    AppMethodBeat.o(209543);
    return localbdb;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(209541);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(209541);
    return i;
  }
  
  public final int getType()
  {
    return 1769;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209542);
    ac.w("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.hyv = ((bdb)((b)paramq).hvs.hvw);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hyw != null) {
      this.hyw.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(209542);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.z
 * JD-Core Version:    0.7.0.1
 */